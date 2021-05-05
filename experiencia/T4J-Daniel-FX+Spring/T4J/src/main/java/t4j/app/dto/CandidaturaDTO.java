package t4j.app.dto;

public class CandidaturaDTO {

    /**
     * Variável de instância - id
     */
    private String id;

    /**
     * Variável de instância - data de candidatura
     */
    private LocalDateDTO dataCandidatura;

    /**
     * Variável de instância - valor pretendido
     */
    private String valorPretendido;

    /**
     * Variável de instância - número de dias
     */
    private String nrDias;

    /**
     * Variável de instância - texto de apresentação
     */
    private String txtApresentacao;

    /**
     * Variável de instância - texto de motivação
     */
    private String txtMotivacao;

    /**
     *
     */
    private String refAnuncio;

    /**
     *
     */
    private String emailFreelancer;

    /**
     *
     */
    private String classificacao;

    /**
     *
     */
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
    public String getId() {
        return id;
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
     * @return
     */
    public String getValorPretendido() {
        return valorPretendido;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
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
     * @return
     */
    public String getTxtApresentacao() {
        return txtApresentacao;
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
     * @return
     */
    public String getRefAnuncio() {
        return refAnuncio;
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
     * @return
     */
    public String getClassificacao() {
        return classificacao;
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
     * @param dataCandidatura
     */
    public void setDataCandidatura(LocalDateDTO dataCandidatura) {
        this.dataCandidatura = dataCandidatura;
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
     * @param nrDias
     */
    public void setNrDias(String nrDias) {
        this.nrDias = nrDias;
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
     * @param txtMotivacao
     */
    public void setTxtMotivacao(String txtMotivacao) {
        this.txtMotivacao = txtMotivacao;
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
     * @param emailFreelancer
     */
    public void setEmailFreelancer(String emailFreelancer) {
        this.emailFreelancer = emailFreelancer;
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
     * @param emailColaboradorClassificou
     */
    public void setEmailColaboradorClassificou(String emailColaboradorClassificou) {
        this.emailColaboradorClassificou = emailColaboradorClassificou;
    }

    /**
     *
     * @return
     */
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
