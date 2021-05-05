/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.dto;

import java.time.LocalDate;


public class ReconhecimentoCTDTO {


    private String id;


    private LocalDate datareconhecimento;


    private String idgrauproficiencia;
    private String descricaoGrauProficiencia;

    private String codigocompetenciatecnica;


    private String emailfreelancer;

    public String getId() {
        return id;
    }

    public LocalDate getDatareconhecimento() {
        return datareconhecimento;
    }

    public String getIdgrauproficiencia() {
        return idgrauproficiencia;
    }

    public String getCodigocompetenciatecnica() {
        return codigocompetenciatecnica;
    }

    public String getEmailfreelancer() {
        return emailfreelancer;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDatareconhecimento(LocalDate datareconhecimento) {
        this.datareconhecimento = datareconhecimento;
    }

    public void setIdgrauproficiencia(String idgrauproficiencia) {
        this.idgrauproficiencia = idgrauproficiencia;
    }

    public void setCodigocompetenciatecnica(String codigocompetenciatecnica) {
        this.codigocompetenciatecnica = codigocompetenciatecnica;
    }

    public void setEmailfreelancer(String emailfreelancer) {
        this.emailfreelancer = emailfreelancer;
    }

    public String getDescricaoGrauProficiencia() {
        return descricaoGrauProficiencia;
    }

    public void setDescricaoGrauProficiencia(String descricaoGrauProficiencia) {
        this.descricaoGrauProficiencia = descricaoGrauProficiencia;
    }

}
