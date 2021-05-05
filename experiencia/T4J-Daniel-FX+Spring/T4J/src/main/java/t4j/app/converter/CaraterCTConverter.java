package t4j.app.converter;

import java.util.ArrayList;
import java.util.Optional;
import static t4j.app.converter.CompetenciaTecnicaConverter.competenciaTecnica2CompetenciaTecnicaDTO;
import static t4j.app.converter.CompetenciaTecnicaConverter.competenciaTecnicaDTO2CompetenciaTecnica;
import static t4j.app.converter.GrauProficienciaConverter.grau2GrauDTO;
import static t4j.app.converter.GrauProficienciaConverter.grauDTO2Grau;
import t4j.app.dto.CaraterCompetenciaTecnicaDTO;
import t4j.app.dto.CompetenciaTecnicaDTO;
import t4j.app.dto.GrauProficienciaDTO;
import t4j.app.model.CaraterCompetenciaTecnica;
import t4j.app.model.CompetenciaTecnica;
import t4j.app.model.GrauProficiencia;

public class CaraterCTConverter {

    /**
     *
     * @param caraterCompetenciaTecnicaDTO
     * @return
     */
    public static CaraterCompetenciaTecnica caraterCTDTO2CaraterCT(CaraterCompetenciaTecnicaDTO caraterCompetenciaTecnicaDTO) {
        CaraterCompetenciaTecnica cct = new CaraterCompetenciaTecnica();
        cct.setObrigatorio(caraterCompetenciaTecnicaDTO.isObrigatorio());
        GrauProficiencia gp = grauDTO2Grau(caraterCompetenciaTecnicaDTO.getGrauProficiencia());
        cct.setGrauProficiencia(gp);
        CompetenciaTecnica ct = competenciaTecnicaDTO2CompetenciaTecnica(caraterCompetenciaTecnicaDTO.getCompetenciaTecnica());
        cct.setCompetenciaTecnica(ct);
        return cct;
    }
    
    /**
     *
     * @param caraterCompetenciaTecnica
     * @return
     */
    public static CaraterCompetenciaTecnicaDTO caraterCT2CaraterCTDTO(CaraterCompetenciaTecnica caraterCompetenciaTecnica) {
        CaraterCompetenciaTecnicaDTO cctdto = new CaraterCompetenciaTecnicaDTO();
        CompetenciaTecnicaDTO ctdto = competenciaTecnica2CompetenciaTecnicaDTO(caraterCompetenciaTecnica.getCompetenciaTecnica());
        cctdto.setCompetenciaTecnica(ctdto);
        Optional<GrauProficiencia> optGP = Optional.ofNullable(caraterCompetenciaTecnica.getGrauProficiencia());
        if (optGP.isPresent()) {
            cctdto.setGrauProficiencia(grau2GrauDTO(optGP.get()));
        }
        GrauProficienciaDTO gpdto;
        cctdto.setObrigatorio(caraterCompetenciaTecnica.isObrigatorio());
        return cctdto;
    }

    /**
     *
     * @param caraterCompetenciaTecnicaDTOs
     * @return
     */
    public static ArrayList<CaraterCompetenciaTecnica> listCaraterCTDTO2ListCaraterCT(ArrayList<CaraterCompetenciaTecnicaDTO> caraterCompetenciaTecnicaDTOs) {
        ArrayList<CaraterCompetenciaTecnica> cts = new ArrayList<>();
        for (CaraterCompetenciaTecnicaDTO caraterCompetenciaTecnicaDTO : caraterCompetenciaTecnicaDTOs) {
            try {
                CaraterCompetenciaTecnica ct = caraterCTDTO2CaraterCT(caraterCompetenciaTecnicaDTO);
                cts.add(ct);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        return cts;
    }

    /**
     *
     * @param carateresCompetenciaTecnica
     * @return
     */
    public static ArrayList<CaraterCompetenciaTecnicaDTO> listCaraterCT2ListCaraterCTDTO(ArrayList<CaraterCompetenciaTecnica> carateresCompetenciaTecnica) {
        ArrayList<CaraterCompetenciaTecnicaDTO> ctsDTO = new ArrayList<>();
        for (CaraterCompetenciaTecnica caraterCompetenciaTecnica : carateresCompetenciaTecnica) {
            try {
                CaraterCompetenciaTecnicaDTO ctDTO = caraterCT2CaraterCTDTO(caraterCompetenciaTecnica);
                ctsDTO.add(ctDTO);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        return ctsDTO;
    }
}
