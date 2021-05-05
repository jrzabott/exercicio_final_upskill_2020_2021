package t4j.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static t4j.app.converter.CompetenciaTecnicaConverter.competenciaTecnica2CompetenciaTecnicaDTO;
import t4j.app.dao.CompetenciaTecnicaDAO;
import t4j.app.dto.CompetenciaTecnicaDTO;
import t4j.app.model.CompetenciaTecnica;

@Service
public class ReconhecimentosCTService {

    /**
     * 
     */
    @Autowired
    CompetenciaTecnicaDAO ctdao;
    
    /**
     * 
     * @return 
     */
    public List<CompetenciaTecnicaDTO> findAllCTs() {
        List<CompetenciaTecnica> listCT = ctdao.findAll();
        List<CompetenciaTecnicaDTO> listdto = new ArrayList<>();

        for (CompetenciaTecnica competenciaTecnica : listCT) {
            CompetenciaTecnicaDTO ctdto = competenciaTecnica2CompetenciaTecnicaDTO(competenciaTecnica);
            listdto.add(ctdto);
        }
        return listdto;
    }

    /**
     * 
     * @param codigo
     * @return 
     */
    public CompetenciaTecnicaDTO findCompetenciaTecnicaById(String codigo) {
        Optional<CompetenciaTecnica> ct = ctdao.findById(codigo);
        if (!ct.isPresent()) {
            return null;
        }
        CompetenciaTecnicaDTO ctdto = competenciaTecnica2CompetenciaTecnicaDTO(ct.get());
        return ctdto;
    }
}
