/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.controller;

import t4j.app.service.CategoriaTarefasService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import t4j.app.dto.CategoriaTarefaDTO;
import t4j.app.dto.RegistoAreasAtividadesDTO;
import t4j.app.dto.RegistoCompetenciasTecnicasDTO;
import t4j.app.service.AreaAtividadeService;
import t4j.app.service.CompetenciasTecnicasService;

/**
 *
 * @author user
 */
@Controller
public class UICategoriaTarefaController {

    private Long idGerado;

    @Autowired
    AreaAtividadeService aas;
    @Autowired
    CompetenciasTecnicasService competenciasTecnicasService;
    @Autowired
    CategoriaTarefasService categoriaTarefasService;

    public UICategoriaTarefaController() {
        idGerado = new Long(0);
    }

    public RegistoAreasAtividadesDTO getRegistoAreasAtividadeDTO() {
        return aas.findAllAreasAtividades();
    }

    public RegistoCompetenciasTecnicasDTO getRegistoCompetenciasTecnicas() {
        return competenciasTecnicasService.getRegistoCompetenciasTecnicas();
    }

    public boolean addCategoriaTarefa(CategoriaTarefaDTO ctdto) {
        Optional<Long> newId = Optional.ofNullable(categoriaTarefasService.addCategoriaTarefa(ctdto));
        this.idGerado = newId.get();
        return newId.isPresent();
    }

    public Long getIdGerado() {
        return idGerado;
    }

}
