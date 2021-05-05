package t4j.app.dto;

public class ClassificacaoDTO {

    /**
     *
     */
    private Long id;

    /**
     *
     */
    private Long idProcessoSeriacao;

    /**
     *
     */
    private Long idCandidaturaVencedora;

    /**
     *
     */
    public ClassificacaoDTO() {
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
     * @return
     */
    public Long getIdProcessoSeriacao() {
        return idProcessoSeriacao;
    }

    /**
     *
     * @return
     */
    public Long getIdCandidaturaVencedora() {
        return idCandidaturaVencedora;
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
     * @param idProcessoSeriacao
     */
    public void setIdProcessoSeriacao(Long idProcessoSeriacao) {
        this.idProcessoSeriacao = idProcessoSeriacao;
    }

    /**
     *
     * @param idCandidaturaVencedora
     */
    public void setIdCandidaturaVencedora(Long idCandidaturaVencedora) {
        this.idCandidaturaVencedora = idCandidaturaVencedora;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ClassificacaoDTO{id=").append(id);
        sb.append(", idProcessoSeriacao=").append(idProcessoSeriacao);
        sb.append(", idCandidaturaVencedora=").append(idCandidaturaVencedora);
        sb.append('}');
        return sb.toString();
    }
}
