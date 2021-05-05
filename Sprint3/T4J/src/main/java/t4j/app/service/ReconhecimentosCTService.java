/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import t4j.app.dao.CompetenciaTecnicaDAO;
import t4j.app.dto.CompetenciaTecnicaDTO;
import t4j.app.dto.Mapper;
import t4j.app.model.CompetenciaTecnica;

/**
 *
 * @author Home
 */
@Service
public class ReconhecimentosCTService {

    @Autowired
    CompetenciaTecnicaDAO ctdao;
    
    public List<CompetenciaTecnicaDTO> findAllCTs() {
        List<CompetenciaTecnica> listCT = ctdao.findAll();
        List<CompetenciaTecnicaDTO> listdto = new ArrayList<>();

        for (CompetenciaTecnica competenciaTecnica : listCT) {
            CompetenciaTecnicaDTO ctdto = Mapper.competenciaTecnica2CompetenciaTecnicaDTO(competenciaTecnica);
            listdto.add(ctdto);
        }
        return listdto;
    }

    public CompetenciaTecnicaDTO findCompetenciaTecnicaById(String codigo) {
        Optional<CompetenciaTecnica> ct = ctdao.findById(codigo);
        if (!ct.isPresent()) {
            return null;
        }
        CompetenciaTecnicaDTO ctdto = Mapper.competenciaTecnica2CompetenciaTecnicaDTO(ct.get());
        return ctdto;
    }

}
