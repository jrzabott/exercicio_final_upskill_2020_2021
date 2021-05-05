package t4j.app.service;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import t4j.app.dao.ColaboradorDAO;
import t4j.app.dao.OrganizacaoDAO;
import t4j.app.dto.Mapper;
import t4j.app.dto.OrganizacaoDTO;
import t4j.app.dto.RegistoOrganizacoesDTO;
import t4j.app.dto.UserInfoDTO;
import t4j.app.exception.ElementoNaoExistenteException;
import t4j.app.model.Colaborador;
import t4j.app.model.Organizacao;
import t4j.app.model.Plataforma;
import t4j.app.model.RegistoOrganizacoes;
import t4j.app.repo.Dados;
import t4j.app.utils.AlgoritmoGeradorPasswords;

@Service
public class OrganizacoesService {

    @Autowired
    OrganizacaoDAO organizacaoDAO;
    @Autowired
    ColaboradoresService ColaboradoresService;
    @Autowired
    UsersService usersService;
    @Autowired
    ColaboradorDAO colaboradorDAO;

    public OrganizacoesService() {
    }

    // Daniel Junior 20210217 19:27 - Para utilizar o SpringBoot da melhor forma, a classe não terá mais atributos ou métodos estáticos
    // Spring e static não se gostam muito.
    @Transactional
    public boolean addOrganizacao(OrganizacaoDTO odto) {
        boolean result = false;
        Organizacao org = Mapper.organizacaoDTO2Organizacao(odto);
        Organizacao orgInserida = organizacaoDAO.save(org);
        result = orgInserida != null;

// Daniel Junior - 20200217 19:06
        // Removido, não iremos mais serializar/des... a plataforma. A Plat é SingleTon.
//        Plataforma p = Dados.carregarDados();
        // Daniel Junior - 20200217 19:06
        // As operações com Registo de Organizações também parecem sem sentido, se devo realizar consultas à DB quando necessário.
//        Plataforma p = Plataforma.getInstance();
//        RegistoOrganizacoes ro = p.getRegistoOrganizacoes();
//        result = ro.addOrganizacao(org);
        if (result) {
            UserInfoDTO u = Mapper.colaboradorDTO2UserInfoDTO(odto
                    .getGestorDTO());
            u.setPassword(AlgoritmoGeradorPasswords.geraString(
                    AlgoritmoGeradorPasswords.MIX, 16));
            result = ColaboradoresService.addUtilizadorGestor(u);
            if (result) {
                usersService.sendPassword(u.getEmail(), u.getPassword());
            }
        }
//        Dados.guardarDados(p);
        return result;
    }

    /**
     *
     * @param odto organização a ser adicionada
     * @return adiciona uma nova organização
     */
//    public static boolean addOrganizacao(OrganizacaoDTO odto) {
//        boolean result;
//        Organizacao org = Mapper.organizacaoDTO2Organizacao(odto);
//        Organizacao orgInserida = getOrganizacaoDAO().save(org);
//
//// Daniel Junior - 20200217 19:06
//        // Removido, não iremos mais serializar/des... a plataforma. A Plat é SingleTon.
////        Plataforma p = Dados.carregarDados();
//
//        // Daniel Junior - 20200217 19:06
//        // As operações com Registo de Organizações também parecem sem sentido, se devo realizar consultas à DB quando necessário.
////        Plataforma p = Plataforma.getInstance();
////        RegistoOrganizacoes ro = p.getRegistoOrganizacoes();
////        result = ro.addOrganizacao(org);
//
//
//
//        if (result) {
//            UserInfoDTO u = Mapper.colaboradorDTO2UserInfoDTO(odto
//                    .getGestorDTO());
//            u.setPassword(AlgoritmoGeradorPasswords.geraString(
//                    AlgoritmoGeradorPasswords.MIX, 16));
//            result = colaboradoresService.addUtilizadorGestor(u);
//            if (result) {
//                UsersService.sendPassword(u.getEmail(), u.getPassword());
//            }
//        }
//        Dados.guardarDados(p);
//        return result;
//    }
    /**
     *
     * @param nifString NIF da organização que se pretende obter
     * @return a organização identificada pelo seu NIF
     */
    public static OrganizacaoDTO getOrganizacaoByNif(String nifString) {
        Organizacao o = null;
        OrganizacaoDTO odto = null;

        Plataforma p = Dados.carregarDados();
        RegistoOrganizacoes ro = p.getRegistoOrganizacoes();
        o = ro.getOrganizacaoByNif(nifString);
        if (o != null) {
            odto = Mapper.organizacao2OrganizacaoDTO(o);
        }
        return odto;
    }

    /**
     *
     * @return o registo de organizações
     */
    public static RegistoOrganizacoesDTO getRegistoOrganizacoes() {
        RegistoOrganizacoesDTO rodto;
        Plataforma p = Dados.carregarDados();
        RegistoOrganizacoes ro = p.getRegistoOrganizacoes();
        ArrayList<Organizacao> organizacoes = ro.getOrganizacoes();
        rodto = Mapper.listOrganizacao2OrganizacaoDTO(organizacoes);
        return rodto;
    }

    public void setOrgInfoInSessionByUserEmail(UserInfoDTO u) {
//        Plataforma p = Dados.carregarDados();
//        RegistoOrganizacoesDTO rodto;
//        RegistoOrganizacoes ro = p.getRegistoOrganizacoes();
//        ArrayList<Organizacao> organizacoes = ro.getOrganizacoes();
//        OrganizacaoDTO o = null;
//        for (Organizacao org : organizacoes) {
//            for (Colaborador colaboradore : org.getColaboradores()) {
//                if (u.getUsername().equalsIgnoreCase(colaboradore.getEmail())) {
//                    o = Mapper.organizacao2OrganizacaoDTO(org);
//                    u.setOrganizacao(o);
//                    break;
//                }
//            }
//        }
//    }
        Optional<Colaborador> userOptional = colaboradorDAO.findById(u.getUsername());
        u.setNifOrganizacao(userOptional.orElseThrow(() -> new ElementoNaoExistenteException("Utilizador não encontrado.")).getNifOrganizacao());
    }
}
