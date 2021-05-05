package t4j.app.converter;

import java.util.ArrayList;
import java.util.List;
import t4j.app.dto.GrauProficienciaDTO;
import t4j.app.dto.RegistoGrausProficienciaDTO;
import t4j.app.model.GrauProficiencia;

public class GrauProficienciaConverter {
    
    /**
     *
     * @param grau
     * @return
     */
    public static GrauProficienciaDTO grau2GrauDTO(GrauProficiencia grau) {
        GrauProficienciaDTO grauDTO = new GrauProficienciaDTO();
        grauDTO.setId(String.valueOf(grau.getId()));
        grauDTO.setValor(grau.getValorGrauProficiencia());
        grauDTO.setDesignacao(grau.getDesignacaoGrauProficiencia());
        return grauDTO;
    }

    /**
     *
     * @param grauDTO
     * @return
     */
    public static GrauProficiencia grauDTO2Grau(GrauProficienciaDTO grauDTO) {
        GrauProficiencia grau = new GrauProficiencia();
        grau.setId((grauDTO.getId() == null) ? null : Long.parseLong(grauDTO.getId()));
        grau.setValorGrauProficiencia(grauDTO.getValor());
        grau.setDesignacaoGrauProficiencia(grauDTO.getDesignacao());
        return grau;
    }

    /**
     *
     * @param graus
     * @return
     * @throws NullPointerException
     */
    public static RegistoGrausProficienciaDTO listGrau2ListGrauDTO(List<GrauProficiencia> graus) throws NullPointerException {
        ArrayList<GrauProficienciaDTO> grausDTO = new ArrayList<>();
        for (GrauProficiencia grau : graus)
            try {
            GrauProficienciaDTO grauproficienciaDTO = grau2GrauDTO(grau);
            grausDTO.add(grauproficienciaDTO);
        } catch (NullPointerException e) {
            // Does nothing
        }
        RegistoGrausProficienciaDTO registoGrausProficienciaDTO = new RegistoGrausProficienciaDTO();
        registoGrausProficienciaDTO.setGrausProficiencia(grausDTO);
        return registoGrausProficienciaDTO;
    }

    /**
     *
     * @param grausDTO
     * @return
     * @throws NullPointerException
     */
    public static ArrayList<GrauProficiencia> listGrauDTO2ListGrau(ArrayList<GrauProficienciaDTO> grausDTO) throws NullPointerException {
        ArrayList<GrauProficiencia> graus = new ArrayList<>();
        for (GrauProficienciaDTO grauDTO : grausDTO)
            try {
            GrauProficiencia grauProficiencia = grauDTO2Grau(grauDTO);
            graus.add(grauProficiencia);
        } catch (NullPointerException e) {
            // Does nothing
        }
        return new ArrayList<GrauProficiencia>(graus);
    }
}
