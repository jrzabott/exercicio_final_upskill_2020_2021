package t4j.app.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import static t4j.app.converter.AnuncioConverter.listAnuncios2ListAnunciosDTO;
import static t4j.app.converter.CandidaturaConverter.candidaturaDTO2Candidatura;
import static t4j.app.converter.CandidaturaConverter.listCandidaturas2ListCandidaturasDTO;
import static t4j.app.converter.ClassificacaoConverter.classificacaoDTO2Classificacao;
import static t4j.app.converter.ProcessoSeriacaoConverter.processoSeriacaoDTO2ProcessoSeriacao;
import t4j.app.dao.CandidaturaDAO;
import t4j.app.dao.ClassificacaoDAO;
import t4j.app.dao.ProcessoSeriacaoDAO;
import t4j.app.dto.AnuncioDTO;
import t4j.app.dto.CandidaturaDTO;
import t4j.app.dto.ClassificacaoDTO;
import t4j.app.dto.ProcessoSeriacaoDTO;
import t4j.app.exception.ElementoDuplicadoException;
import t4j.app.exception.ElementoInvalidoException;
import t4j.app.exception.ElementoNaoExistenteException;
import t4j.app.model.Anuncio;
import t4j.app.model.Candidatura;
import t4j.app.model.Classificacao;
import t4j.app.model.ProcessoSeriacao;

@Service
public class CandidaturasService {

    /**
     *
     */
    @Autowired
    CandidaturaDAO cdao;

    /**
     *
     */
    @Autowired
    ProcessoSeriacaoDAO pdao;

    /**
     *
     */
    @Autowired
    ClassificacaoDAO cldao;

    /**
     *
     */
    public CandidaturasService() {
    }

    /**
     *
     * @param cddto
     * @return
     */

    @Transactional
    public boolean addCandidatura(CandidaturaDTO cddto) {
        Candidatura cd = candidaturaDTO2Candidatura(cddto);
        cd = cdao.save(cd);
        boolean result = cd != null;
        return result;
    }
    
    @Transactional
    public boolean updateCandidatura(CandidaturaDTO cddto) {
        Candidatura cd = candidaturaDTO2Candidatura(cddto);
        cd = cdao.save(cd);
        boolean result = cd != null;
        return result;
    }
    
    @Transactional
    public boolean removeCandidatura(String idCd) {
        cdao.deleteById(Long.valueOf(idCd));
//        Optional<Candidatura> cdOptional = cdao.findById(idCd);
//        cdOptional.ifPresent((t) -> {cdao.delete(t);});
        boolean result = !cdao.existsById(Long.valueOf(idCd));
        return true;
    }

    /**
     *
     * @param psdto
     * @return
     */
    public boolean addProcessoSeriacao(ProcessoSeriacaoDTO psdto) {
        ProcessoSeriacao ps = processoSeriacaoDTO2ProcessoSeriacao(psdto);
        ProcessoSeriacao psInserida = pdao.save(ps);
        boolean result = psInserida != null;
        return result;
    }

    /**
     *
     * @param cdto
     * @return
     */
    public boolean addClassificacao(ClassificacaoDTO cdto) {
        Classificacao c = classificacaoDTO2Classificacao(cdto);
        Classificacao cInserida = cldao.save(c);
        boolean result = cInserida != null;
        return result;
    }

    /**
     *
     * @param emailColaborador
     * @return
     */
    public List<AnuncioDTO> anunciosEmPeriodoSeriacao(String emailColaborador) {
        List<Object> listaObjetosAnuncio = cdao.anunciosEmPeriodoSeriacao(emailColaborador);
        ArrayList<Anuncio> anunciosEmPeriodoSeriacao = convertObjectFromDBToAnuncio(listaObjetosAnuncio);
        List<AnuncioDTO> anunciosEmPeriodoSeriacaoDTO = listAnuncios2ListAnunciosDTO(anunciosEmPeriodoSeriacao);
        return anunciosEmPeriodoSeriacaoDTO;
    }

    /**
     *
     * @param referencia
     * @return
     */
    public List<Long> candidaturasEmPeriodoSeriacao(String referencia) {
        List<Long> listaCand = cdao.candidaturasEmPeriodoSeriacao(referencia);
        return listaCand;
    }

    @Transactional
    public List<CandidaturaDTO> findCandidaturasByFreelancer(String emailU) {
        List<Candidatura> lcd = cdao.findAllByFreelancer(emailU);
        List<CandidaturaDTO> lcddto = listCandidaturas2ListCandidaturasDTO(lcd);
        return lcddto;
    }

    /**
     *
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public List<CandidaturaDTO> getListaCandidaturas() {
        List<CandidaturaDTO> listaCandidaturasDTO = new ArrayList<>();
        List<Candidatura> lista;
        lista = cdao.findAll();
        ArrayList<Candidatura> listaCandidaturas = new ArrayList<>(lista);
        listaCandidaturasDTO = listCandidaturas2ListCandidaturasDTO(listaCandidaturas);
        return listaCandidaturasDTO;
    }

    /**
     *
     * @param referenciaAnuncio
     * @return
     */
    public Long idTipoRegimentoByCandidatura(String referenciaAnuncio) {
        return cdao.idTipoRegimentoByCandidatura(referenciaAnuncio);
    }

    /**
     *
     * @param emailFreelancer
     * @param classif
     * @param emailColaborador
     */
    public void updateTabelaCandidatura(String emailFreelancer, Long classif, String emailColaborador) {
        cdao.updateTabelaCandidatura(emailFreelancer, classif, emailColaborador);
    }

    /**
     *
     * @param listaObjetosAnuncio
     * @return
     */
    private ArrayList<Anuncio> convertObjectFromDBToAnuncio(List<Object> listaObjetosAnuncio) {
        ArrayList<Anuncio> listAnuncio = new ArrayList();
        for (Object object : listaObjetosAnuncio) {
            Object[] get = (Object[]) object;

            LocalDate dataReg = ((Timestamp) get[0]).toLocalDateTime().toLocalDate();
            LocalDate dataIniPub = ((Timestamp) get[1]).toLocalDateTime().toLocalDate();
            LocalDate dataFimPub = ((Timestamp) get[2]).toLocalDateTime().toLocalDate();
            LocalDate dataIniCand = ((Timestamp) get[3]).toLocalDateTime().toLocalDate();
            LocalDate dataFimCand = ((Timestamp) get[4]).toLocalDateTime().toLocalDate();
            LocalDate dataIniSer = ((Timestamp) get[5]).toLocalDateTime().toLocalDate();
            LocalDate dataFimSer = ((Timestamp) get[6]).toLocalDateTime().toLocalDate();
            String ref = ((String) get[7]);
            Long regimento = ((BigDecimal) get[8]).longValue();

            Anuncio a = new Anuncio();
            a.setDataFimCandidatura(dataFimCand);
            a.setDataFimPublicitacao(dataFimPub);
            a.setDataFimSeriacao(dataFimSer);
            a.setDataInicioCandidatura(dataIniCand);
            a.setDataInicioPublicitacao(dataIniPub);
            a.setDataInicioSeriacao(dataIniSer);
            a.setDataRegistoAnuncio(dataFimCand);
            a.setIdTipoRegimento(regimento);
            a.setReferencia(ref);

            listAnuncio.add(a);
        }
        return listAnuncio;
    }

    /**
     *
     * @param cdtoByAnuncio
     * @param psdto
     */
    @Transactional
    public void seriarCandidaturas(List<CandidaturaDTO> cdtoByAnuncio, ProcessoSeriacaoDTO psdto) {
        ClassificacaoDTO classdto = new ClassificacaoDTO();

        ///////////////////////////////////////////////////////////////////////////////
        // VALIDA????ES DAS CANDIDATURAS E SUAS CLASSIFICA??OES
        ///////////////////////////////////////////////////////////////////////////////
        // Testar se tabela tem registos (se h?? candidaturas para esta tarefa)
        if (cdtoByAnuncio.size() < 1) {
            throw new ElementoNaoExistenteException("N??o existem candidaturas para a tarefa.");
        }
        // Testar se Classificaca est?? preenchida (!= null ou "")
        boolean classificaoEmBranco = false;
        for (CandidaturaDTO item : cdtoByAnuncio) {
            if (item.getClassificacao() == null
                    || item.getClassificacao().isEmpty()) {
                classificaoEmBranco = true;
                break;
            }
        }
        if (classificaoEmBranco) {
            throw new ElementoInvalidoException("Todas as candidaturas devem ser classificadas, com valores entre 1 e 20");
        }
        for (CandidaturaDTO item : cdtoByAnuncio) {
            if (Integer.parseInt(item.getClassificacao()) < 1) {
                throw new ElementoInvalidoException("Candidatura: " + item.getId().toString() + ". Deve receber valor maior que 1 em sua classifica????o.");
            }
            if (Integer.parseInt(item.getClassificacao()) > 20) {
                throw new ElementoInvalidoException("Candidatura: " + item.getId().toString() + ". Deve receber valor menor ou igual a 20 em sua classifica????o.");
            }
        }
        // FIM VALIDA????ES DAS CANDIDATURAS E SUAS CLASSIFICA??OES
        ///////////////////////////////////////////////////////////////////////////////

        Iterable<Candidatura> listToSave = new ArrayList();
        for (CandidaturaDTO item : cdtoByAnuncio) {
            Candidatura cdto3 = candidaturaDTO2Candidatura(item);
            if (cdto3 != null) {
                ((ArrayList<Candidatura>) listToSave).add(cdto3);
            }
        }
        cdao.saveAll(listToSave);

        // TODO - Criar novo registo na tabela PROCESSOSERIACAO
        ProcessoSeriacao ps = processoSeriacaoDTO2ProcessoSeriacao(psdto);
        Optional<ProcessoSeriacao> psOptional = pdao.findByReferenciaAnuncio(ps.getReferenciaAnuncio());
        if (psOptional.isPresent()) {
            throw new ElementoInvalidoException(("Tarefa j?? seriada."));
        }
        ps = pdao.save(ps);

        // Tabela Classificacao
        CandidaturaDTO cdto2 = new CandidaturaDTO();
        int melhorClassificacao = 0;
        for (CandidaturaDTO item : cdtoByAnuncio) {
            int classAtual = Integer.parseInt(item.getClassificacao());
            if (classAtual > melhorClassificacao) {
                melhorClassificacao = classAtual;
                cdto2 = item;
            }
        }
        // Testar classifica????o != null e Colaborador != null
        Candidatura ct = candidaturaDTO2Candidatura(cdto2);
        classdto.setIdCandidaturaVencedora(ct.getId());
        classdto.setIdProcessoSeriacao(ps.getId());
        Classificacao cl = classificacaoDTO2Classificacao(classdto);
        cl = cldao.save(cl);
    }
}
