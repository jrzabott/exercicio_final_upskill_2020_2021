package t4j.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static t4j.app.converter.ColaboradorConverter.colaboradorDTO2UserInfoDTO;
import t4j.app.converter.OrganizacaoConverter;
import static t4j.app.converter.OrganizacaoConverter.organizacaoDTO2Organizacao;
import t4j.app.dao.ColaboradorDAO;
import t4j.app.dao.OrganizacaoDAO;
import t4j.app.dto.OrganizacaoDTO;
import t4j.app.dto.TarefaDTO;
import t4j.app.dto.UserInfoDTO;
import t4j.app.exception.ElementoDuplicadoException;
import t4j.app.exception.ElementoNaoExistenteException;
import t4j.app.model.Colaborador;
import t4j.app.model.Organizacao;
import t4j.app.utils.AlgoritmoGeradorPasswords;

@Service
public class OrganizacoesService {

    /**
     *
     */
    @Autowired
    OrganizacaoDAO organizacaoDAO;

    /**
     *
     */
    @Autowired
    ColaboradoresService ColaboradoresService;

    /**
     *
     */
    @Autowired
    UsersService usersService;

    /**
     *
     */
    @Autowired
    ColaboradorDAO colaboradorDAO;

    /**
     *
     */
    public OrganizacoesService() {
    }

    /**
     *
     * @param odto
     * @return
     */
    @Transactional
    public boolean addOrganizacao(OrganizacaoDTO odto) {
        boolean result = false;

        Organizacao org = organizacaoDTO2Organizacao(odto);

        // VERIFICA SE ORGANIZAÇÃO EXISTE
        Optional<Organizacao> orgOptional = organizacaoDAO.findById(odto.getNifOrganizacao());
        // CASO POSITIVO INTERROMPE EXECUÇÃO E APRESENTA ERRO
        orgOptional.ifPresent((o) -> {
            throw new ElementoDuplicadoException(odto.getNifOrganizacao() + ": NIF da Organização já existe na base de dados.");
        });

        // ADICIONAR NOVA ORGANIZAÇÃO
        Organizacao orgInserida = organizacaoDAO.save(org);
        result = orgInserida != null;

        // CASO ORGANIZAÇÃO TENHA SIDO INSERIDA COM SUCESSO, REGISTA NOVO USER.
        if (result) {
            UserInfoDTO u = colaboradorDTO2UserInfoDTO(odto
                    .getGestorDTO());
            u.setPassword(AlgoritmoGeradorPasswords.geraString(
                    AlgoritmoGeradorPasswords.MIX, 16));
            result = ColaboradoresService.addUtilizadorGestor(u);
            if (result) {
                usersService.sendPassword(u.getEmail(), u.getPassword());
            }
        }
        return result;
    }

    /**
     *
     * @param u
     */
    public void setOrgInfoInSessionByUserEmail(UserInfoDTO u) {
        Optional<Colaborador> userOptional = colaboradorDAO.findById(u.getEmail());
        u.setNifOrganizacao(userOptional.orElseThrow(() -> new ElementoNaoExistenteException("Utilizador não encontrado.")).getNifOrganizacao());
    }

//    public List<OrganizacaoDTO> getOrganizacaoFromNif(List<TarefaDTO> ltdto) {
//        List<OrganizacaoDTO> lodto = new ArrayList<>();
//        List<Organizacao> lo = new ArrayList<>();
//        for (TarefaDTO tdto : ltdto) {
//            if (tdto.getNifOrganizacao() != null) {
//                Organizacao org = organizacaoDAO.findById(tdto.getNifOrganizacao()).get().getN;
//                if (!lo.contains(org)) {
//                    lo.add(org);
//                }
//            }
//        }
//        lodto = OrganizacaoConverter.listOrganizacao2OrganizacaoDTO(lo);
//        return lodto;
//    }

}
