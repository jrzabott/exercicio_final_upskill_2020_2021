package t4j.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import static t4j.app.converter.CompetenciaTecnicaConverter.competenciaTecnicaDTO2CompetenciaTecnica;
import t4j.app.dao.CompetenciaTecnicaDAO;
import t4j.app.dto.CompetenciaTecnicaDTO;
import t4j.app.dto.RegistoCompetenciasTecnicasDTO;
import t4j.app.exception.ConversaoException;
import t4j.app.exception.ElementoDuplicadoException;
import t4j.app.model.CompetenciaTecnica;
import t4j.app.model.RegistoCompetenciasTecnicas;
import static t4j.app.converter.CompetenciaTecnicaConverter.listCompetenciasTecnicas2ListCompetenciasTecnicasDTO;

@Service
public class CompetenciasTecnicasService {

    /**
     *
     */
    @Autowired
    CompetenciaTecnicaDAO competenciaTecnicaDAO;

    /**
     *
     */
    public CompetenciasTecnicasService() {
    }

    /**
     *
     * @param ctDTO competência técnica a ser adicionada
     * @return true se adicionou uma nova competência técnica passada por parâmetro e false se contrário
     */
    @Transactional
    public boolean addCompetenciaTecnica(CompetenciaTecnicaDTO ctDTO) {
        boolean result = false;
        CompetenciaTecnica ct = competenciaTecnicaDTO2CompetenciaTecnica(ctDTO);
        if (ct == null) {
            throw new ConversaoException("CompetenciaTecnicaDTO");
        }
        Optional<CompetenciaTecnica> findById = competenciaTecnicaDAO.findById(ct.getCodigoCompetenciaTecnica());
        if (findById.isPresent()) {
            throw new ElementoDuplicadoException(ct.getCodigoCompetenciaTecnica()
                    + ": Já existe uma competência técnica com este código."
            );
        }
        CompetenciaTecnica ctInserida = competenciaTecnicaDAO.save(ct);
        result = ctInserida != null;
        return result;
    }

    /**
     *
     * @return o registo de competências técnicas
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public RegistoCompetenciasTecnicasDTO getRegistoCompetenciasTecnicas() {
        RegistoCompetenciasTecnicasDTO rctDTO = new RegistoCompetenciasTecnicasDTO();
        List<CompetenciaTecnica> competenciaTecnicas;
        competenciaTecnicas = competenciaTecnicaDAO.findAll();
        RegistoCompetenciasTecnicas rct = new RegistoCompetenciasTecnicas();
        competenciaTecnicas.forEach(rct::addCompetenciaTecnica);

        List<CompetenciaTecnica> listaCT;
        listaCT = rct.getCompetenciasTecnicas();
        rctDTO = listCompetenciasTecnicas2ListCompetenciasTecnicasDTO((ArrayList<CompetenciaTecnica>) listaCT);
        return rctDTO;
    }

    /**
     *
     * @return
     */
    public List<String> getAllCompetenciasTecnicasIDs() {
        List<String> result = new ArrayList<>();
        result = competenciaTecnicaDAO.getAllCompetenciasTecnicasIDs();
        return result;
    }
}
