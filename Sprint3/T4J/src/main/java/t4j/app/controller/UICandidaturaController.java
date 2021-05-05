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
import t4j.app.dto.ProcessoSeriacaoDTO;
import t4j.app.dto.RegistoTarefasDTO;
import t4j.app.service.AnunciosService;
import t4j.app.service.CandidaturasService;
import t4j.app.service.ColaboradoresService;

@Controller
public class UICandidaturaController {

    @Autowired
    private AnunciosService as;
    @Autowired
    private CandidaturasService cds;
    @Autowired
    private ColaboradoresService cs;

    public UICandidaturaController() {
    }

    public ArrayList<AnuncioDTO> anunciosEmPeriodoSeriacao(String emailColaborador) {
        ArrayList<AnuncioDTO> lista = cds.anunciosEmPeriodoSeriacao(emailColaborador);
        return lista;
    }

    public List<Long> candidaturasEmPeriodoSeriacao(String referencia) {
        List<Long> listaCand = cds.candidaturasEmPeriodoSeriacao(referencia);
        return listaCand;
    }

    public ArrayList<CandidaturaDTO> getListaCandidaturas() {
        return cds.getListaCandidaturas();
    }

    public ArrayList<ColaboradorDTO> getListaColaboradores() {
        return cs.getListaColaboradores();
    }

    public Long idTipoRegimentoByCandidatura(String referenciaAnuncio) {
        return cds.idTipoRegimentoByCandidatura(referenciaAnuncio);
    }

    public boolean registarCandidatura(String valorPretendido, String nrDias, String txtApresentacao, String txtMotivacao) {
        boolean result;
        LocalDateDTO localDate = new LocalDateDTO();
        localDate.setLocalDate(LocalDate.now());
        CandidaturaDTO cddto = new CandidaturaDTO();
        cddto.setDataCandidatura(localDate);
        cddto.setValorPretendido(valorPretendido);
        cddto.setNrDias(nrDias);
        cddto.setTxtApresentacao(txtApresentacao);
        cddto.setTxtMotivacao(txtMotivacao);

        result = cds.addCandidatura(cddto);
        return result;
    }

    public boolean seriarCandidatura(ProcessoSeriacaoDTO psdto, Long idCandidaturaVencedora) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean seriarCandidaturaNaoAutomaticamente(ProcessoSeriacaoDTO psdto, Long idCandidaturaVencedora) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    public boolean seriarCandidaturaNaoAutomaticamente() {
//        boolean result;
//
//        return result;
//    }
//
//    public boolean seriarCandidaturaAutomaticamente() {
//        boolean result;
//
//        return result;
//    }

    public void updateTabelaCandidatura(String emailFreelancer, Long classif, String emailColaborador) {
        cds.updateTabelaCandidatura(emailFreelancer, classif, emailColaborador);
    }

    public RegistoTarefasDTO obterAnunciosElegiveisFreelancer(String emailU) {
        return as.findAllAnunciosElegiveisByFreelancer(emailU);

    }

    public boolean registarCandidatura(String valorPretendido, String nrDias, String txtApresentacao, String txtMotivacao, String refAnuncio, String emailFreelancer) {
        boolean result;
        LocalDateDTO localDate = new LocalDateDTO();
        localDate.setLocalDate(LocalDate.now());
        CandidaturaDTO cddto = new CandidaturaDTO();
        cddto.setDataCandidatura(localDate);
        cddto.setValorPretendido(valorPretendido);
        cddto.setNrDias(nrDias);
        cddto.setTxtApresentacao(txtApresentacao);
        cddto.setTxtMotivacao(txtMotivacao);
        cddto.setRefAnuncio(refAnuncio);
        cddto.setEmailFreelancer(emailFreelancer);

        result = cds.addCandidatura(cddto);
        return result;
    }
}
