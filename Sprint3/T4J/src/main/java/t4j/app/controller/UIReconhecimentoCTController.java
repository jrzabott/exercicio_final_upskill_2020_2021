/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.controller;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import t4j.app.dto.CompetenciaTecnicaDTO;
import t4j.app.service.ReconhecimentosCTService;

/**
 *
 * @author Home
 */
@Controller
public class UIReconhecimentoCTController {

    private Long idGerado;

      @Autowired
    ReconhecimentosCTService rcts;

    public ObservableList<CompetenciaTecnicaDTO> findAllCompetenciasTecnicas() {
        List<CompetenciaTecnicaDTO> list = rcts.findAllCTs();
        return FXCollections.observableArrayList(list);
    }
    public CompetenciaTecnicaDTO findCompetenciaTecnicaById(String codigo){
        CompetenciaTecnicaDTO ctdto = rcts.findCompetenciaTecnicaById(codigo);
        return ctdto;
    }
}
