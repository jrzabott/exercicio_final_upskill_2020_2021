/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.List;

/**
 *
 * @author Home
 */
@JsonPropertyOrder({"nome", "nif", "telefone", "email"})
@JacksonXmlRootElement(localName = "freelancer")
public class FreeLancerDTO {

    @JacksonXmlProperty(localName = "email")
    private String email;

    @JacksonXmlProperty(localName = "nome")
    private String nome;

    @JacksonXmlProperty(localName = "nif")
    private String nif;

    @JacksonXmlProperty(localName = "telefone")
    private String telefone;

    private EnderecoPostalDTO endereco;

    private List<HabilitacaoAcademicaDTO> habilitacoes;

    private List<ReconhecimentoCTDTO> reconhecimentos;

    public List<HabilitacaoAcademicaDTO> getHabilitacoes() {
        return habilitacoes;
    }

    public void setHabilitacoes(List<HabilitacaoAcademicaDTO> habilitacoes) {
        this.habilitacoes = habilitacoes;
    }

    public List<ReconhecimentoCTDTO> getReconhecimentos() {
        return reconhecimentos;
    }

    public void setReconhecimentos(List<ReconhecimentoCTDTO> reconhecimentos) {
        this.reconhecimentos = reconhecimentos;
    }



    public FreeLancerDTO() {
        this.endereco = new EnderecoPostalDTO();
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getNif() {
        return nif;
    }

    public String getTelefone() {
        return telefone;
    }

    public EnderecoPostalDTO getEndereco() {
        return endereco;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(EnderecoPostalDTO endereco) {
        this.endereco = endereco;
    }

}
