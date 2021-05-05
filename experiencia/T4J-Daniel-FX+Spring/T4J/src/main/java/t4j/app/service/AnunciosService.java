package t4j.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import t4j.app.converter.AnuncioConverter;
import static t4j.app.converter.AnuncioConverter.anuncioDTO2Anuncio;
import static t4j.app.converter.TarefaConverter.tarefa2TarefaDTO;
import t4j.app.dao.AnuncioDAO;
import t4j.app.dao.FreeLancerDAO;
import t4j.app.dao.GrauProficienciaDAO;
import t4j.app.dao.ReconhecimentoCTDAO;
import t4j.app.dao.TarefaDAO;
import t4j.app.dto.AnuncioDTO;
import t4j.app.dto.TarefaDTO;
import t4j.app.exception.ConversaoException;
import t4j.app.exception.ElementoDuplicadoException;
import t4j.app.model.Anuncio;
import t4j.app.model.CaraterCompetenciaTecnica;
import t4j.app.model.FreeLancer;
import t4j.app.model.GrauProficiencia;
import t4j.app.model.ReconhecimentoCT;
import t4j.app.model.Tarefa;
import t4j.app.utils.Validacao;

@Service
public class AnunciosService {

    /**
     *
     */
    @Autowired
    AnuncioDAO anuncioDAO;

    /**
     *
     */
    @Autowired
    FreeLancerDAO freelancerDAO;

    /**
     *
     */
    @Autowired
    GrauProficienciaDAO grauDAO;

    /**
     *
     */
    @Autowired
    ReconhecimentoCTDAO rctDAO;

    /**
     *
     */
    @Autowired
    TarefaDAO tarefaDAO;

    public AnunciosService() {
    }

    /**
     *
     * @param emailU
     * @return
     */
    @Transactional
    public List<TarefaDTO> findAllAnunciosElegiveisByFreelancer(String emailU) {
        Optional<FreeLancer> freelancerOptional = freelancerDAO.findById(emailU);
        FreeLancer freelancer = freelancerOptional.get();
        List<Tarefa> tarefas = new ArrayList<>();
        List<TarefaDTO> tarefasDTO = new ArrayList<>();
        List<String> listaAnunciosPeriodoCandidatura = anuncioDAO.findAnuncios();
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
                TarefaDTO tarefaDTO = tarefa2TarefaDTO(tarefa);
                tarefasDTO.add(tarefaDTO);
            }
        }
        return tarefasDTO;
    }
    @Transactional
    public List<AnuncioDTO> findAnunciosPorTarefas(List<TarefaDTO> ltdto) {
        List<Anuncio> lanu = new ArrayList<>();
        for (TarefaDTO tdto : ltdto) {
            Anuncio anu = anuncioDAO.findById(tdto.getReferencia()).get();
            lanu.add(anu);
        }
        List<AnuncioDTO> lanudto = AnuncioConverter.listAnuncios2ListAnunciosDTO(lanu);
        return lanudto;
    }

    /**
     *
     * @param anuncioDTO anúncio a ser adicionado
     * @return true se adicionou um novo anúncio passado por parâmetro e false se contrário
     */
    @Transactional
    public boolean addAnuncio(AnuncioDTO anuncioDTO) {
        boolean result = false;
        Anuncio anuncio = anuncioDTO2Anuncio(anuncioDTO);
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
}
