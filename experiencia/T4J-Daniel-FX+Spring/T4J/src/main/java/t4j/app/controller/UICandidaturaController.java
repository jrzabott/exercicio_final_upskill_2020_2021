package t4j.app.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import t4j.app.dto.AnuncioDTO;
import t4j.app.dto.CandidaturaDTO;
import t4j.app.dto.ColaboradorDTO;
import t4j.app.dto.LocalDateDTO;
import t4j.app.dto.OrganizacaoDTO;
import t4j.app.dto.ProcessoSeriacaoDTO;
import t4j.app.dto.TarefaDTO;
import t4j.app.service.AnunciosService;
import t4j.app.service.CandidaturasService;
import t4j.app.service.ColaboradoresService;
import t4j.app.service.OrganizacoesService;
import t4j.app.service.TarefasService;

@Controller
public class UICandidaturaController {

    @Autowired
    private AnunciosService as;
    @Autowired
    private CandidaturasService cds;
    @Autowired
    private ColaboradoresService cs;
    @Autowired
    private OrganizacoesService os;
    @Autowired
    private TarefasService ts;

    public UICandidaturaController() {
    }

    public List<AnuncioDTO> anunciosEmPeriodoSeriacao(String emailColaborador) {
        List<AnuncioDTO> lista = cds.anunciosEmPeriodoSeriacao(emailColaborador);
        return lista;
    }

    public List<Long> candidaturasEmPeriodoSeriacao(String referencia) {
        List<Long> listaCand = cds.candidaturasEmPeriodoSeriacao(referencia);
        return listaCand;
    }

    public List<CandidaturaDTO> getListaCandidaturas() {
        return cds.getListaCandidaturas();
    }

    public ArrayList<ColaboradorDTO> getListaColaboradores() {
        return cs.getListaColaboradores();
    }

    public Long idTipoRegimentoByCandidatura(String referenciaAnuncio) {
        return cds.idTipoRegimentoByCandidatura(referenciaAnuncio);
    }

    public boolean registarCandidatura(String id, String valorPretendido, String nrDias, 
            String txtApresentacao, String txtMotivacao, String refAnuncio, String emailFreelancer) {
        boolean result = addCandidatura(id, valorPretendido, nrDias, txtApresentacao, txtMotivacao, refAnuncio, emailFreelancer);
        return result;
    }
    
    public boolean atualizarCandidatura(String id, String valorPretendido, String nrDias, 
            String txtApresentacao, String txtMotivacao, String refAnuncio, String emailFreelancer) {
        boolean result = addCandidatura(id, valorPretendido, nrDias, txtApresentacao, txtMotivacao, refAnuncio, emailFreelancer);
        return result;
    }
    
    public boolean addCandidatura(String id, String valorPretendido, String nrDias, 
            String txtApresentacao, String txtMotivacao, String refAnuncio, String emailFreelancer) {
        boolean result;
        LocalDateDTO localDate = new LocalDateDTO();
        localDate.setLocalDate(LocalDate.now());
        CandidaturaDTO cddto = new CandidaturaDTO();
        cddto.setId(id);
        cddto.setDataCandidatura(localDate);
        cddto.setValorPretendido(valorPretendido);
        cddto.setNrDias(nrDias);
        cddto.setTxtApresentacao(txtApresentacao);
        cddto.setTxtMotivacao(txtMotivacao);
        cddto.setRefAnuncio(refAnuncio);
        cddto.setEmailFreelancer(emailFreelancer);
        if (cddto.getId() == null) {
            return result = cds.addCandidatura(cddto);
        }
        return cds.updateCandidatura(cddto);
    }

    public boolean removerCandidatura(String idCd) {
        boolean result = cds.removeCandidatura(idCd);
        return result;
    }
    
//    public List<OrganizacaoDTO> getOrganizacaoFromNif(List<TarefaDTO> ltdto) {
//        return os.getOrganizacaoFromNif(ltdto);
//    }

    public boolean seriarCandidatura(ProcessoSeriacaoDTO psdto, Long idCandidaturaVencedora) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean seriarCandidaturaNaoAutomaticamente(ProcessoSeriacaoDTO psdto, Long idCandidaturaVencedora) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateTabelaCandidatura(String emailFreelancer, Long classif, String emailColaborador) {
        cds.updateTabelaCandidatura(emailFreelancer, classif, emailColaborador);
    }

    public List<TarefaDTO> obterAnunciosElegiveisFreelancer(String emailU) {
        return as.findAllAnunciosElegiveisByFreelancer(emailU);

    }
    
    public List<AnuncioDTO> obterAnunciosPorTarefas(List<TarefaDTO> ltdto) {
        return as.findAnunciosPorTarefas(ltdto);
    }
    
    public List<CandidaturaDTO> obterCandidaturasFreelancer(String emailU) {
        return cds.findCandidaturasByFreelancer(emailU);
    }
}
