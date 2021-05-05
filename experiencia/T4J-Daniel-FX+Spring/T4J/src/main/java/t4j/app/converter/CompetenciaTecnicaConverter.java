package t4j.app.converter;

import java.util.ArrayList;
import static t4j.app.converter.AreaAtividadeConverter.areaAtividade2AreaAtividadeDTO;
import static t4j.app.converter.AreaAtividadeConverter.areaAtividadeDTO2AreaAtividade;
import t4j.app.dto.AreaAtividadeDTO;
import t4j.app.dto.CompetenciaTecnicaDTO;
import t4j.app.dto.RegistoCompetenciasTecnicasDTO;
import t4j.app.dto.RegistoGrausProficienciaDTO;
import t4j.app.model.AreaAtividade;
import t4j.app.model.CompetenciaTecnica;
import t4j.app.model.GrauProficiencia;
import static t4j.app.converter.GrauProficienciaConverter.listGrau2ListGrauDTO;
import static t4j.app.converter.GrauProficienciaConverter.listGrauDTO2ListGrau;

public class CompetenciaTecnicaConverter {
    
    /**
     * 
     * @param competenciaTecnica
     * @return
     * @throws NullPointerException 
     */
    public static CompetenciaTecnicaDTO competenciaTecnica2CompetenciaTecnicaDTO(CompetenciaTecnica competenciaTecnica) throws NullPointerException {
        CompetenciaTecnicaDTO competenciaTecnicaDTO = new CompetenciaTecnicaDTO();
        competenciaTecnicaDTO.setCodigoCompetenciaTecnica(competenciaTecnica.getCodigoCompetenciaTecnica());
        competenciaTecnicaDTO.setDescricaoBreve(competenciaTecnica.getDescricaoBreve());
        competenciaTecnicaDTO.setDescricaoDetalhada(competenciaTecnica.getDescricaoDetalhada());
        AreaAtividadeDTO atDTO = areaAtividade2AreaAtividadeDTO(competenciaTecnica.getAreaAtividade());
        competenciaTecnicaDTO.setAreaAtividade(atDTO);
        RegistoGrausProficienciaDTO grausDTO = listGrau2ListGrauDTO(competenciaTecnica.getGrausProficiencia());
        competenciaTecnicaDTO.setGrausProficiencia(grausDTO.getGrausProficiencia());
        return competenciaTecnicaDTO;
    }

    /**
     *
     * @param ctDTO
     * @return
     * @throws NullPointerException
     */
    public static CompetenciaTecnica competenciaTecnicaDTO2CompetenciaTecnica(CompetenciaTecnicaDTO ctDTO) throws NullPointerException {
        CompetenciaTecnica ct = new CompetenciaTecnica();
        ct.setCodigoCompetenciaTecnica(ctDTO.getCodigoCompetenciaTecnica());
        ct.setDescricaoBreve(ctDTO.getDescricaoBreve());
        ct.setDescricaoDetalhada(ctDTO.getDescricaoDetalhada());
        AreaAtividade at = areaAtividadeDTO2AreaAtividade(ctDTO.getAreaAtividade());
        ct.setAreaAtividade(at);
        ArrayList<GrauProficiencia> graus = listGrauDTO2ListGrau(ctDTO.getGrausProficiencia());
        ct.setGrausProficiencia(graus);
        return ct;
    }

    /**
     *
     * @param listaCT
     * @return
     * @throws NullPointerException
     */
    public static RegistoCompetenciasTecnicasDTO listCompetenciasTecnicas2ListCompetenciasTecnicasDTO(ArrayList<CompetenciaTecnica> listaCT) throws NullPointerException {
        ArrayList<CompetenciaTecnicaDTO> listaCTDTO = new ArrayList<>();
        for (CompetenciaTecnica ct : listaCT)
            try {
            listaCTDTO.add(competenciaTecnica2CompetenciaTecnicaDTO(ct));
        } catch (NullPointerException e) {
            // Does nothing
        }
        RegistoCompetenciasTecnicasDTO regCTDTO = new RegistoCompetenciasTecnicasDTO();
        regCTDTO.setCompetenciasTecnicas(listaCTDTO);
        return regCTDTO;
    }
}
