package t4j.app.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"id", "dataCandidatura", "valorPretendido","nrDias", "txtApresentacao", "txtMotivacao"})
@JacksonXmlRootElement(localName = "candidatura")
public class CandidaturaDTO {

    /**
     * Variável de instância - id
     */
    @JacksonXmlProperty(localName = "id")
    private Long id;

    /**
     * Variável de instância - data de candidatura
     */
    @JacksonXmlProperty(localName = "dataCandidatura")
    private LocalDateDTO dataCandidatura;

    /**
     * Variável de instância - valor pretendido
     */
    @JacksonXmlProperty(localName = "valorPretendido")
    private String valorPretendido;

    /**
     * Variável de instância - número de dias
     */
    @JacksonXmlProperty(localName = "nrDias")
    private String nrDias;

    /**
     * Variável de instância - texto de apresentação
     */
    @JacksonXmlProperty(localName = "txtApresentacao")
    private String txtApresentacao;

    /**
     * Variável de instância - texto de motivação
     */
    @JacksonXmlProperty(localName = "txtMotivacao")
    private String txtMotivacao;

    /**
     *
     */
    @JacksonXmlProperty(localName = "referenciaanuncio")
    private String refAnuncio;

    /**
     *
     */
    @JacksonXmlProperty(localName = "emailfreelancer")
    private String emailFreelancer;

    /**
     *
     */
    @JacksonXmlProperty(localName = "classificacao")
    private String classificacao;

    /**
     *
     */
    @JacksonXmlProperty(localName = "emailcolaboradorclassificou")
    private String emailColaboradorClassificou;

    /**
     * Construtor vazio de candidatura
     */
    public CandidaturaDTO() {
    }

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public LocalDateDTO getDataCandidatura() {
        return dataCandidatura;
    }

    /**
     *
     * @param dataCandidatura
     */
    public void setDataCandidatura(LocalDateDTO dataCandidatura) {
        this.dataCandidatura = dataCandidatura;
    }

    /**
     *
     * @return
     */
    public String getValorPretendido() {
        return valorPretendido;
    }

    /**
     *
     * @param valorPretendido
     */
    public void setValorPretendido(String valorPretendido) {
        this.valorPretendido = valorPretendido;
    }

    /**
     *
     * @return
     */
    public String getNrDias() {
        return nrDias;
    }

    /**
     *
     * @param nrDias
     */
    public void setNrDias(String nrDias) {
        this.nrDias = nrDias;
    }

    /**
     *
     * @return
     */
    public String getTxtApresentacao() {
        return txtApresentacao;
    }

    /**
     *
     * @param txtApresentacao
     */
    public void setTxtApresentacao(String txtApresentacao) {
        this.txtApresentacao = txtApresentacao;
    }

    /**
     *
     * @return
     */
    public String getTxtMotivacao() {
        return txtMotivacao;
    }

    /**
     *
     * @param txtMotivacao
     */
    public void setTxtMotivacao(String txtMotivacao) {
        this.txtMotivacao = txtMotivacao;
    }

    /**
     *
     * @return
     */
    public String getRefAnuncio() {
        return refAnuncio;
    }

    /**
     *
     * @param refAnuncio
     */
    public void setRefAnuncio(String refAnuncio) {
        this.refAnuncio = refAnuncio;
    }

    /**
     *
     * @return
     */
    public String getEmailFreelancer() {
        return emailFreelancer;
    }

    /**
     *
     * @param emailFreelancer
     */
    public void setEmailFreelancer(String emailFreelancer) {
        this.emailFreelancer = emailFreelancer;
    }

    /**
     *
     * @return
     */
    public String getClassificacao() {
        return classificacao;
    }

    /**
     *
     * @param classificacao
     */
    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    /**
     *
     * @return
     */
    public String getEmailColaboradorClassificou() {
        return emailColaboradorClassificou;
    }

    /**
     *
     * @param emailColaboradorClassificou
     */
    public void setEmailColaboradorClassificou(String emailColaboradorClassificou) {
        this.emailColaboradorClassificou = emailColaboradorClassificou;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CandidaturaDTO{id=").append(id);
        sb.append(", dataCandidatura=").append(dataCandidatura);
        sb.append(", valorPretendido=").append(valorPretendido);
        sb.append(", nrDias=").append(nrDias);
        sb.append(", txtApresentacao=").append(txtApresentacao);
        sb.append(", txtMotivacao=").append(txtMotivacao);
        sb.append(", refAnuncio=").append(refAnuncio);
        sb.append(", emailFreelancer=").append(emailFreelancer);
        sb.append(", classificacao=").append(classificacao);
        sb.append(", emailColaboradorClassificou=").append(emailColaboradorClassificou);
        sb.append('}');
        return sb.toString();
    }


    
}
