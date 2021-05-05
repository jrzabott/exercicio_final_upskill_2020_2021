/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author user
 */
@JsonPropertyOrder({"competenciaTecnica", "grauProficiencia", "obrigatorio"})
@JacksonXmlRootElement(localName = "caraterCompetenciaTecnica")
public class CaraterCompetenciaTecnicaDTO {

    @JacksonXmlProperty(localName = "obrigatorio")
    private boolean obrigatorio;
    @JacksonXmlProperty(localName = "competenciaTecnica")
    private CompetenciaTecnicaDTO competenciaTecnica;
    @JacksonXmlProperty(localName = "grauProficiencia")
    private GrauProficienciaDTO grauProficiencia;

    ////////////////////////////////////////////////////////////
    // Daniel Junior - 20210220 13:25
    // ------------------------------------------------
    // Após cansar de apanhar do JavaFX e suas ObservablesProperties
    // Me rendi às mesmas e por isso alterei o DTO para que possamos
    // fazer uso das funcionalidades Observáveis e facilitar a vida.
    ////////////////////////////////////////////////////////////
    @JsonIgnore
    private BooleanProperty obrigatorioProp = new SimpleBooleanProperty(false);
    @JsonIgnore
    private ObjectProperty<CompetenciaTecnicaDTO> competenciaTecnicaProp = new SimpleObjectProperty<>(new CompetenciaTecnicaDTO());
    @JsonIgnore
    private ObjectProperty<GrauProficienciaDTO> grauProficienciaProp = new SimpleObjectProperty<>(new GrauProficienciaDTO());

    public CaraterCompetenciaTecnicaDTO() {
        this.competenciaTecnica = new CompetenciaTecnicaDTO();
        this.grauProficiencia = new GrauProficienciaDTO();
    }

    public boolean isObrigatorio() {
        return obrigatorio;
    }

    public void setObrigatorio(boolean obrigatorio) {
        this.obrigatorioProp.set(obrigatorio);
        this.obrigatorio = obrigatorio;
    }

    public CompetenciaTecnicaDTO getCompetenciaTecnica() {
        return competenciaTecnica;
    }

    public void setCompetenciaTecnica(CompetenciaTecnicaDTO competenciaTecnica) {
        this.competenciaTecnicaProp.set(competenciaTecnica);
        this.competenciaTecnica = competenciaTecnica;
    }

    public GrauProficienciaDTO getGrauProficiencia() {
        return grauProficiencia;
    }

    public void setGrauProficiencia(GrauProficienciaDTO grauProficiencia) {
        this.grauProficienciaProp.set(grauProficiencia);
        this.grauProficiencia = grauProficiencia;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CaraterCompetenciaTecnicaDTO:\nobrigatorio: ").append(obrigatorio);
        sb.append("\ngrauProficiencia: ").append(grauProficiencia.toString());
        sb.append("\ncompetenciaTecnica: ").append(competenciaTecnica.toString());
        sb.append('}');
        return sb.toString();
    }

    public BooleanProperty getObrigatorioProp() {
        return obrigatorioProp;
    }

    public ObjectProperty<CompetenciaTecnicaDTO> getCompetenciaTecnicaProp() {
        return competenciaTecnicaProp;
    }

    public ObjectProperty<GrauProficienciaDTO> getGrauProficienciaProp() {
        return grauProficienciaProp;
    }

}
