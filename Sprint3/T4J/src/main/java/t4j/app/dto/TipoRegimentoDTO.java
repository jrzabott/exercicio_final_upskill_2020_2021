package t4j.app.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"designacao", "descricaoregras"})
@JacksonXmlRootElement(localName = "tiporegimento")
public class TipoRegimentoDTO {
    
    /**
     * 
     */
    @JacksonXmlProperty(localName = "id")
    private Long id;
    
    /**
     * 
     */
    @JacksonXmlProperty(localName = "designacao")
    private String designacao;
    
    /**
     * 
     */
    @JacksonXmlProperty(localName = "descricaoregras")
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
}
