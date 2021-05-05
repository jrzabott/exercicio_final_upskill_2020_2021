package t4j.app.dto;

import java.util.ArrayList;

public class RegistoGrausProficienciaDTO {

    /**
     * Variável de instância - contentor do tipo ArrayList que guarda todas as
     * instâncias do tipo competência técnica
     */
    private ArrayList<GrauProficienciaDTO> grausProficiencia;

    /**
     * Construtor vazio de lista de competências técnicas
     */
    public RegistoGrausProficienciaDTO() {
    }

    /**
     *
     * @return contentor do tipo ArrayList que guarda todas as instâncias do
     * tipo competência técnica
     */
    public ArrayList<GrauProficienciaDTO> getGrausProficiencia() {
        return grausProficiencia;
    }

    /**
     *
     * @param grausProficiencia especifica um novo contentor do tipo ArrayList
     * que guarda todas as instâncias do tipo competência técnica
     */
    public void setGrausProficiencia(ArrayList<GrauProficienciaDTO> grausProficiencia) {
        this.grausProficiencia = grausProficiencia;
    }
}
