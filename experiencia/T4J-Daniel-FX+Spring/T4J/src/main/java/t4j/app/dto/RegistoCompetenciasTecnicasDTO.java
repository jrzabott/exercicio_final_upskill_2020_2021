package t4j.app.dto;

import java.util.ArrayList;

public class RegistoCompetenciasTecnicasDTO {

    /**
     * Variável de instância - contentor do tipo ArrayList que guarda todas as
     * instâncias do tipo competência técnica
     */
    private ArrayList<CompetenciaTecnicaDTO> competenciasTecnicas;

    /**
     * Construtor vazio de lista de competências técnicas
     */
    public RegistoCompetenciasTecnicasDTO() {
    }

    /**
     *
     * @return contentor do tipo ArrayList que guarda todas as instâncias do
     * tipo competência técnica
     */
    public ArrayList<CompetenciaTecnicaDTO> getCompetenciasTecnicas() {
        return competenciasTecnicas;
    }

    /**
     *
     * @param competenciasTecnicas especifica um novo contentor do tipo
     * ArrayList que guarda todas as instâncias do tipo competência técnica
     */
    public void setCompetenciasTecnicas(ArrayList<CompetenciaTecnicaDTO> competenciasTecnicas) {
        this.competenciasTecnicas = competenciasTecnicas;
    }
}
