package t4j.app.dto;

public class ProcessoSeriacaoDTO {
    
    /**
     * 
     */
    private Long id;
    
    /**
     * 
     */
    private LocalDateDTO dataRealizacao;
    
    /**
     * 
     */
    private String referenciaAnuncio;

    /**
     * 
     */
    public ProcessoSeriacaoDTO() {
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
    public LocalDateDTO getDataRealizacao() {
        return dataRealizacao;
    }
    
    /**
     * 
     * @return 
     */
    public String getReferenciaAnuncio() {
        return referenciaAnuncio;
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
     * @param dataRealizacao 
     */
    public void setDataRealizacao(LocalDateDTO dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    /**
     * 
     * @param referenciaAnuncio 
     */
    public void setReferenciaAnuncio(String referenciaAnuncio) {
        this.referenciaAnuncio = referenciaAnuncio;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProcessoSeriacaoDTO{id=").append(id);
        sb.append(", dataRealizacao=").append(dataRealizacao);
        sb.append(", referenciaAnuncio=").append(referenciaAnuncio);
        sb.append('}');
        return sb.toString();
    }
}
