package t4j.app.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import t4j.app.dto.AreaAtividadeDTO;
import t4j.app.dto.CompetenciaTecnicaDTO;
import t4j.app.dto.GrauProficienciaDTO;
import t4j.app.service.CompetenciasTecnicasService;

@Controller
public class UICompetenciaTecnicaController {

    @Autowired
    private CompetenciasTecnicasService competenciasTecnicasService;

    //    public boolean adicionarCompetenciaTecnica(String codAreaAtividade, CompetenciaTecnicaDTO ctdto) {
    //        return CompetenciasTecnicasService.addCompetenciaTecnica(codAreaAtividade, ctdto);
    //    }
    /**
     *
     * @param ctdto competência técnica a ser adicionada
     * @return adiciona uuma nova competência técnica
     */
    public boolean adicionarCompetenciaTecnica(CompetenciaTecnicaDTO ctdto) {
        return competenciasTecnicasService.addCompetenciaTecnica(ctdto);
    }
}
