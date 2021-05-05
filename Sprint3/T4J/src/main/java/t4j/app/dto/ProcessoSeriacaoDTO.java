package t4j.app.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"id", "datarealizacao", "idanuncio"})
@JacksonXmlRootElement(localName = "processoseriacao")
public class ProcessoSeriacaoDTO {
    
    /**
     * 
     */
    @JacksonXmlProperty(localName = "id")
    private Long id;
    
    /**
     * 
     */
    @JacksonXmlProperty(localName = "datarealizacao")
    private LocalDateDTO dataRealizacao;
    
    /**
     * 
     */
    @JacksonXmlProperty(localName = "idanuncio")
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
}
