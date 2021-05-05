package t4j.app.dto;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;

public class CaraterCompetenciaTecnicaDTO {

    /**
     *
     */
    private boolean obrigatorio;

    /**
     *
     */
    private CompetenciaTecnicaDTO competenciaTecnica;

    /**
     *
     */
    private GrauProficienciaDTO grauProficiencia;

    ////////////////////////////////////////////////////////////
    // Daniel Junior - 20210220 13:25
    // ------------------------------------------------
    // Após cansar de apanhar do JavaFX e suas ObservablesProperties
    // Me rendi às mesmas e por isso alterei o DTO para que possamos
    // fazer uso das funcionalidades Observáveis e facilitar a vida.
    ////////////////////////////////////////////////////////////
    /**
     *
     */
    private BooleanProperty obrigatorioProp = new SimpleBooleanProperty(false);

    /**
     *
     */
    private ObjectProperty<CompetenciaTecnicaDTO> competenciaTecnicaProp = new SimpleObjectProperty<>(new CompetenciaTecnicaDTO());

    /**
     *
     */
    private ObjectProperty<GrauProficienciaDTO> grauProficienciaProp = new SimpleObjectProperty<>(new GrauProficienciaDTO());

    /**
     *
     */
    public CaraterCompetenciaTecnicaDTO() {
        this.competenciaTecnica = new CompetenciaTecnicaDTO();
        this.grauProficiencia = new GrauProficienciaDTO();
    }

    /**
     *
     * @return
     */
    public boolean isObrigatorio() {
        return obrigatorio;
    }

    /**
     *
     * @return
     */
    public CompetenciaTecnicaDTO getCompetenciaTecnica() {
        return competenciaTecnica;
    }

    /**
     *
     * @return
     */
    public GrauProficienciaDTO getGrauProficiencia() {
        return grauProficiencia;
    }

    /**
     *
     * @return
     */
    public BooleanProperty getObrigatorioProp() {
        return obrigatorioProp;
    }

    /**
     *
     * @return
     */
    public ObjectProperty<CompetenciaTecnicaDTO> getCompetenciaTecnicaProp() {
        return competenciaTecnicaProp;
    }

    /**
     *
     * @return
     */
    public ObjectProperty<GrauProficienciaDTO> getGrauProficienciaProp() {
        return grauProficienciaProp;
    }

    /**
     *
     * @param obrigatorio
     */
    public void setObrigatorio(boolean obrigatorio) {
        this.obrigatorioProp.set(obrigatorio);
        this.obrigatorio = obrigatorio;
    }

    /**
     *
     * @param competenciaTecnica
     */
    public void setCompetenciaTecnica(CompetenciaTecnicaDTO competenciaTecnica) {
        this.competenciaTecnicaProp.set(competenciaTecnica);
        this.competenciaTecnica = competenciaTecnica;
    }

    /**
     *
     * @param grauProficiencia
     */
    public void setGrauProficiencia(GrauProficienciaDTO grauProficiencia) {
        this.grauProficienciaProp.set(grauProficiencia);
        this.grauProficiencia = grauProficiencia;
    }

    /**
     *
     * @param obrigatorioProp
     */
    public void setObrigatorioProp(BooleanProperty obrigatorioProp) {
        this.obrigatorioProp = obrigatorioProp;
    }

    /**
     *
     * @param competenciaTecnicaProp
     */
    public void setCompetenciaTecnicaProp(ObjectProperty<CompetenciaTecnicaDTO> competenciaTecnicaProp) {
        this.competenciaTecnicaProp = competenciaTecnicaProp;
    }

    /**
     *
     * @param grauProficienciaProp
     */
    public void setGrauProficienciaProp(ObjectProperty<GrauProficienciaDTO> grauProficienciaProp) {
        this.grauProficienciaProp = grauProficienciaProp;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CaraterCompetenciaTecnicaDTO{obrigatorio=").append(obrigatorio);
        sb.append(", competenciaTecnica=").append(competenciaTecnica);
        sb.append(", grauProficiencia=").append(grauProficiencia);
        sb.append(", obrigatorioProp=").append(obrigatorioProp);
        sb.append(", competenciaTecnicaProp=").append(competenciaTecnicaProp);
        sb.append(", grauProficienciaProp=").append(grauProficienciaProp);
        sb.append('}');
        return sb.toString();
    }

}
