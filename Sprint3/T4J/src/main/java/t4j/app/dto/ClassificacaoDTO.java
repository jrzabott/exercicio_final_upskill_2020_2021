package t4j.app.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"id", "idprocessoseriacao", "idcandidaturavencedora"})
@JacksonXmlRootElement(localName = "classificacao")
public class ClassificacaoDTO {

    /**
     * 
     */
    @JacksonXmlProperty(localName = "id")
    private Long id;
    
    /**
     * 
     */
    @JacksonXmlProperty(localName = "idprocessoseriacao")
    private Long idProcessoSeriacao;
    
    /**
     * 
     */
    @JacksonXmlProperty(localName = "idcandidaturavencedora")
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
}
