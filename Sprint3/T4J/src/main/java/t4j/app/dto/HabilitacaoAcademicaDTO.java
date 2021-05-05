/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 *
 * @author Home
 */
@JsonPropertyOrder({"id", "grau", "designacaocurso", "nomeinstituicao", "mediacurso"})
@JacksonXmlRootElement(localName = "habilitacaoacademica")
public class HabilitacaoAcademicaDTO {


    @JacksonXmlProperty(localName = "id")
    private String id;


    @JacksonXmlProperty(localName = "grau")
    private String grau;


    @JacksonXmlProperty(localName = "designacaocurso")
    private String designacaocurso;


    @JacksonXmlProperty(localName = "nomeinstituicao")
    private String nomeinstituicao;

    /**
     * Variável de instância - lista de graus de proficiência
     */
    @JacksonXmlProperty(localName = "mediacurso")
    private String mediacurso;

    private String emailFreelancer = "";


    public String getId() {
        return id;
    }

    public String getGrau() {
        return grau;
    }

    public String getDesignacaocurso() {
        return designacaocurso;
    }

    public String getNomeinstituicao() {
        return nomeinstituicao;
    }

    public String getMediacurso() {
        return mediacurso;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setGrau(String grau) {
        this.grau = grau;
    }

    public void setDesignacaocurso(String designacaocurso) {
        this.designacaocurso = designacaocurso;
    }

    public void setNomeinstituicao(String nomeinstituicao) {
        this.nomeinstituicao = nomeinstituicao;
    }

    public void setMediacurso(String mediacurso) {
        this.mediacurso = mediacurso;
    }


}
