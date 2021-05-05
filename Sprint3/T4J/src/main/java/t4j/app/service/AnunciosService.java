package t4j.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import t4j.app.dao.AnuncioDAO;
import t4j.app.dao.FreeLancerDAO;
import t4j.app.dao.GrauProficienciaDAO;
import t4j.app.dao.ReconhecimentoCTDAO;
import t4j.app.dao.TarefaDAO;
import t4j.app.dto.AnuncioDTO;
import t4j.app.dto.Mapper;
import t4j.app.dto.RegistoAnunciosDTO;
import t4j.app.dto.RegistoTarefasDTO;
import t4j.app.dto.TarefaDTO;
import t4j.app.exception.ConversaoException;
import t4j.app.exception.ElementoDuplicadoException;
import t4j.app.model.Anuncio;
import t4j.app.model.CaraterCompetenciaTecnica;
import t4j.app.model.FreeLancer;
import t4j.app.model.GrauProficiencia;
import t4j.app.model.Plataforma;
import t4j.app.model.ReconhecimentoCT;
import t4j.app.model.RegistoAnuncios;
import t4j.app.model.Tarefa;
import t4j.app.repo.Dados;
import t4j.app.utils.Validacao;

@Service
public class AnunciosService {

    @Autowired
    AnuncioDAO anuncioDAO;
    @Autowired
    FreeLancerDAO freelancerDAO;
    @Autowired
    GrauProficienciaDAO grauDAO;
    @Autowired
    ReconhecimentoCTDAO rctDAO;
    @Autowired
    TarefaDAO tarefaDAO;

    public AnunciosService() {
    }

    /**
     *
     * @param referencia referência do anúncio que se pretende obter
     * @return um anúncio identificado pela sua referência
     */
    public AnuncioDTO getAnuncioByReferencia(String referencia) {
        AnuncioDTO adto = new AnuncioDTO();
        Anuncio anuncio = PlataformaService.getPlataforma().getRegistoAnuncios().getAnuncioByReferencia(referencia);
        adto = Mapper.anuncio2AnuncioDTO(anuncio);
        return adto;
    }

    /**
     *
     * @return o registo de anúncios
     */
//    public static RegistoAnunciosDTO getRegistoAnuncios() {
//        RegistoAnunciosDTO radto;
//        Plataforma plataforma = Dados.carregarDados();
//        RegistoAnuncios ra = plataforma.getRegistoAnuncios();
//        ArrayList<Anuncio> anuncios = ra.getAnuncios();
//        radto = Mapper.listAnuncios2ListAnunciosDTO(anuncios);
//        return radto;
//    }

    /**
     *
     * @param referencia referência do anúncio que se pretende obter
     * @return um anúncio identificado pela sua referência
     */
    public static AnuncioDTO getAnuncio(String referencia) {
        Plataforma plataforma = Dados.carregarDados();
        Anuncio anuncio = plataforma.getRegistoAnuncios().getAnuncioByReferencia(referencia);
        if (anuncio == null) {
            return null;
        }
        AnuncioDTO anuncioDTO = Mapper.anuncio2AnuncioDTO(anuncio);
        if (anuncioDTO != null) {
            return anuncioDTO;
        } else {
            throw new ConversaoException("AnuncioDTO");
        }
    }

    @Transactional
    public RegistoTarefasDTO findAllAnunciosElegiveisByFreelancer(String emailU) {
        Optional<FreeLancer> freelancerOptional = freelancerDAO.findById(emailU);
        FreeLancer freelancer = freelancerOptional.get();
        ArrayList<Tarefa> tarefas = new ArrayList<>();
        ArrayList<TarefaDTO> tarefasDTO = new ArrayList<>();
        List<String> listaAnunciosPeriodoCandidatura = anuncioDAO.findAnunciosPeriodoCandidatura();
        for (String refTarefa : listaAnunciosPeriodoCandidatura) {
            boolean checkRecon = false;
            boolean elegivel = true;
            Optional<Tarefa> tarefaOptional = tarefaDAO.findById(refTarefa);
            Tarefa tarefa = tarefaOptional.get();
            ArrayList<CaraterCompetenciaTecnica> listaCCT = new ArrayList<>();
            listaCCT.addAll(tarefa.getCategoria().getListaCaraterCompetenciaTecnica());
            List<Long> listaRCTDAO = rctDAO.findAllByEmailFreelancer(emailU);
            for (CaraterCompetenciaTecnica cct : listaCCT) {
                if (cct.getObrigatorioAsString().equals("0")) {
                    checkRecon = true;
                } else {
                    for (Long idRCT : listaRCTDAO) {
                        Optional<ReconhecimentoCT> rctOptional = rctDAO.findById(idRCT);
                        ReconhecimentoCT rct = rctOptional.get();
                        Optional<GrauProficiencia> rctGrauOptional = grauDAO.findById(Long.valueOf(rct.getIdgrauproficiencia()));
                        GrauProficiencia rctGrau = rctGrauOptional.get();
                        if (rct.getCodigocompetenciatecnica().equals(cct.getCompetenciaTecnica().getCodigoCompetenciaTecnica())) {
                            if (Long.valueOf(rctGrau.getValorGrauProficiencia()) >= Long.valueOf(cct.getGrauProficiencia().getValorGrauProficiencia())) {
                                checkRecon = true;
                            }
                        }
                    }
                }
                if (!checkRecon) {
                    elegivel = false;
                }
            }
            if (elegivel) {
                TarefaDTO tarefaDTO = Mapper.tarefa2TarefaDTO(tarefa);
                tarefasDTO.add(tarefaDTO);
            }
        }
        RegistoTarefasDTO rtdto = new RegistoTarefasDTO();
        rtdto.setTarefas(tarefasDTO);
        return rtdto;
    }

    /**
     *
     * @param anuncioDTO anúncio a ser adicionado
     * @return true se adicionou um novo anúncio passado por parâmetro e false
     * se contrário
     */
    @Transactional
    public boolean addAnuncio(AnuncioDTO anuncioDTO) {
        boolean result = false;
        Anuncio anuncio = Mapper.anuncioDTO2Anuncio(anuncioDTO);
        Validacao.validaDatasAnuncio(anuncio);
        if (anuncio == null) {
            throw new ConversaoException("AnuncioDTO");
        }

        Optional<Anuncio> anuncioDB = anuncioDAO.findById(anuncio.getReferencia());
        if (anuncioDB.isPresent()) {
            throw new ElementoDuplicadoException("Anúncio já existe.");
        }
        anuncio = anuncioDAO.save(anuncio);

        return anuncio != null;
    }

    /**
     *
     * @param referencia referência do anúncio a ser atualizado
     * @param anuncioDTO anúncio identificado pela sua referência a ser
     * atualizado
     */
    public static void updateAnuncio(String referencia, AnuncioDTO anuncioDTO) {

        Anuncio anuncio = Mapper.anuncioDTO2Anuncio(anuncioDTO);
        Plataforma plataforma = Dados.carregarDados();
        if (anuncio != null) {
            plataforma.getRegistoAnuncios().updateAnuncio(referencia, anuncio);
            Dados.guardarDados(plataforma);
        } else {
            throw new ConversaoException("AnuncioDTO");
        }
    }

    /**
     *
     * @param referencia referência do anúncio a ser removido
     */
    public static void removeAnuncio(String referencia) {
        Plataforma plataforma = Dados.carregarDados();
        plataforma.getRegistoAnuncios().removeAnuncio(referencia);
        Dados.guardarDados(plataforma);
    }
}
