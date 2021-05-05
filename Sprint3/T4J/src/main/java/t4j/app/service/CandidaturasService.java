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
import t4j.app.dao.CandidaturaDAO;
import t4j.app.dao.ClassificacaoDAO;
import t4j.app.dao.ProcessoSeriacaoDAO;
import t4j.app.dto.AnuncioDTO;
import t4j.app.dto.CandidaturaDTO;
import t4j.app.dto.ClassificacaoDTO;
import t4j.app.dto.Mapper;
import t4j.app.dto.ProcessoSeriacaoDTO;
import t4j.app.exception.ElementoInvalidoException;
import t4j.app.exception.ElementoNaoExistenteException;
import t4j.app.model.Anuncio;
import t4j.app.model.Candidatura;
import t4j.app.model.Classificacao;
import t4j.app.model.ProcessoSeriacao;

@Service
public class CandidaturasService {

    @Autowired
    CandidaturaDAO cdao;
    @Autowired
    ProcessoSeriacaoDAO pdao;
    @Autowired
    ClassificacaoDAO cldao;

    public CandidaturasService() {
    }

    @Transactional
    public boolean addCandidatura(CandidaturaDTO cddto) {
        Candidatura cd = Mapper.candidaturaDTO2Candidatura(cddto);
        Candidatura cdInserida = cdao.save(cd);
        boolean result = cdInserida != null;
        return result;
    }

    public boolean addProcessoSeriacao(ProcessoSeriacaoDTO psdto) {
        ProcessoSeriacao ps = Mapper.processoSeriacaoDTO2ProcessoSeriacao(psdto);
        ProcessoSeriacao psInserida = pdao.save(ps);
        boolean result = psInserida != null;
        return result;
    }

    public boolean addClassificacao(ClassificacaoDTO cdto) {
        Classificacao c = Mapper.classificacaoDTO2Classificacao(cdto);
        Classificacao cInserida = cldao.save(c);
        boolean result = cInserida != null;
        return result;
    }

    public ArrayList<AnuncioDTO> anunciosEmPeriodoSeriacao(String emailColaborador) {
        List<Object> listaObjetosAnuncio = cdao.anunciosEmPeriodoSeriacao(emailColaborador);
        ArrayList<Anuncio> anunciosEmPeriodoSeriacao = convertObjectFromDBToAnuncio(listaObjetosAnuncio);
        ArrayList<AnuncioDTO> anunciosEmPeriodoSeriacaoDTO = Mapper.listAnuncios2ListAnunciosDTO(anunciosEmPeriodoSeriacao);
        return anunciosEmPeriodoSeriacaoDTO;
    }

    public List<Long> candidaturasEmPeriodoSeriacao(String referencia) {
        List<Long> listaCand = cdao.candidaturasEmPeriodoSeriacao(referencia);
        return listaCand;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public ArrayList<CandidaturaDTO> getListaCandidaturas() {
        ArrayList<CandidaturaDTO> listaCandidaturasDTO = new ArrayList<>();
        List<Candidatura> lista;
        lista = cdao.findAll();
        ArrayList<Candidatura> listaCandidaturas = new ArrayList<>(lista);
        listaCandidaturasDTO = Mapper.listCandidaturas2ListCandidaturasDTO(listaCandidaturas);
        return listaCandidaturasDTO;
    }

    public Long idTipoRegimentoByCandidatura(String referenciaAnuncio) {
        return cdao.idTipoRegimentoByCandidatura(referenciaAnuncio);
    }

    public void updateTabelaCandidatura(String emailFreelancer, Long classif, String emailColaborador) {
        cdao.updateTabelaCandidatura(emailFreelancer, classif, emailColaborador);
    }

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

    @Transactional
    public void seriarCandidaturas(List<CandidaturaDTO> cdtoByAnuncio, ProcessoSeriacaoDTO psdto) {
        ClassificacaoDTO classdto = new ClassificacaoDTO();

        ///////////////////////////////////////////////////////////////////////////////
        // VALIDAÇÕES DAS CANDIDATURAS E SUAS CLASSIFICAÇOES
        ///////////////////////////////////////////////////////////////////////////////
        // Testar se tabela tem registos (se há candidaturas para esta tarefa)
        if (cdtoByAnuncio.size() < 1) {
            throw new ElementoNaoExistenteException("Não existem candidaturas para a tarefa.");
        }
        // Testar se Classificaca está preenchida (!= null ou "")
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
                throw new ElementoInvalidoException("Candidatura: " + item.getId().toString() + ". Deve receber valor maior que 1 em sua classificação.");
            }
            if (Integer.parseInt(item.getClassificacao()) > 20) {
                throw new ElementoInvalidoException("Candidatura: " + item.getId().toString() + ". Deve receber valor menor ou igual a 20 em sua classificação.");
            }
        }
        // FIM VALIDAÇÕES DAS CANDIDATURAS E SUAS CLASSIFICAÇOES
        ///////////////////////////////////////////////////////////////////////////////

        Iterable<Candidatura> listToSave = new ArrayList();
        for (CandidaturaDTO item : cdtoByAnuncio) {
            Candidatura cdto3 = Mapper.candidaturaDTO2Candidatura(item);
            if (cdto3 != null) {
                ((ArrayList<Candidatura>) listToSave).add(cdto3);
            }
        }
        cdao.saveAll(listToSave);

        // TODO - Criar novo registo na tabela PROCESSOSERIACAO
        ProcessoSeriacao ps = Mapper.processoSeriacaoDTO2ProcessoSeriacao(psdto);
        Optional<ProcessoSeriacao> psOptional = pdao.findByReferenciaAnuncio(ps.getReferenciaAnuncio());
        if (psOptional.isPresent()) {
            throw new ElementoInvalidoException(("Tarefa já seriada."));
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
        // Testar classificação != null e Colaborador != null
        Candidatura ct = Mapper.candidaturaDTO2Candidatura(cdto2);

        classdto.setIdCandidaturaVencedora(ct.getId());
        classdto.setIdProcessoSeriacao(ps.getId());
        Classificacao cl = Mapper.classificacaoDTO2Classificacao(classdto);
        cl = cldao.save(cl);

    }
}
