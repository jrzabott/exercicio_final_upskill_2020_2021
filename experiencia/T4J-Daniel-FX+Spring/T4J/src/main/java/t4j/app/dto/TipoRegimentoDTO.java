package t4j.app.dto;

public class TipoRegimentoDTO {
    
    /**
     * 
     */
    private Long id;
    
    /**
     * 
     */
    private String designacao;
    
    /**
     * 
     */
    private String descricaoRegras;
    
    /**
     * 
     */
    public TipoRegimentoDTO() {
    }
    

    /**
     * 
     * @return 
     */
    public String getDesignacao() {
        return designacao;
    }
    
    /**
     * 
     * @return 
     */
    public String getDescricaoRegras() {
        return descricaoRegras;
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
     * @param designacao 
     */
    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    /**
     * 
     * @param descricaoRegras 
     */
    public void setDescricaoRegras(String descricaoRegras) {
        this.descricaoRegras = descricaoRegras;
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
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TipoRegimentoDTO{id=").append(id);
        sb.append(", designacao=").append(designacao);
        sb.append(", descricaoRegras=").append(descricaoRegras);
        sb.append('}');
        return sb.toString();
    }
}
