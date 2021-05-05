package t4j.app.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"dataregisto", "datainiciopublicitacao", "datafimpublicitacao",
    "datainiciocandidatura", "datafimcandidatura", "datainicioseriacao",
    "datafimseriacao", "colaborador", "referenciatarefa", "idtiporegimento"})
@JacksonXmlRootElement(localName = "anuncio")
public class AnuncioDTO {

    /**
     * Variável de instância - data de registo do anúncio
     */
    @JacksonXmlProperty(localName = "dataregisto")
    private LocalDateDTO dataRegistoAnuncio;
    
    /**
     * Variável de instância - data de início de publicitação do anúncio
     */
    @JacksonXmlProperty(localName = "datainiciopublicitacao")
    private LocalDateDTO dataInicioPublicitacao;
    
    /**
     * Variável de instância - data de fim de publicitação do anúncio
     */
    @JacksonXmlProperty(localName = "datafimpublicitacao")
    private LocalDateDTO dataFimPublicitacao;
    
    /**
     * Variável de instância - data de início de candidatura ao anúncio
     */
    @JacksonXmlProperty(localName = "datainiciocandidatura")
    private LocalDateDTO dataInicioCandidatura;
    
    /**
     * Variável de instância - data de fim de candidatura ao anúncio
     */
    @JacksonXmlProperty(localName = "datafimcandidatura")
    private LocalDateDTO dataFimCandidatura;
    
    /**
     * Variável de instância - data de início de seriação das candidaturas
     */
    @JacksonXmlProperty(localName = "datainicioseriacao")
    private LocalDateDTO dataInicioSeriacao;
    
    /**
     * Variável de instância - data de fim de seriação das candidaturas
     */
    @JacksonXmlProperty(localName = "datafimseriacao")
    private LocalDateDTO dataFimSeriacao;
    
    /**
     * Variável de instância - referência do anúncio
     * (será igual à referência da tarefa à qual se refere o anúncio)
     */
    @JacksonXmlProperty(localName = "referenciatarefa")
    private String referenciaTarefa;
    
    /**
     * Variável de instância - id do tipo de regimento pelo qual se rege o anúncio
     */
    @JacksonXmlProperty(localName = "idtiporegimento")
    private Long idTipoRegimento;

    /**
     * Construtor vazio de anúncio
     */
    public AnuncioDTO() {
    }

    /**
     * 
     * @return data de registo do anúncio
     */
    public LocalDateDTO getDataRegistoAnuncio() {
        return dataRegistoAnuncio;
    }

    /**
     * 
     * @return data de início de publicitação do anúncio
     */
    public LocalDateDTO getDataInicioPublicitacao() {
        return dataInicioPublicitacao;
    }

    /**
     * 
     * @return data de fim de publicitação do anúncio
     */
    public LocalDateDTO getDataFimPublicitacao() {
        return dataFimPublicitacao;
    }

    /**
     * 
     * @return data de início de candidatura ao anúncio
     */
    public LocalDateDTO getDataInicioCandidatura() {
        return dataInicioCandidatura;
    }

    /**
     * 
     * @return data de fim de candidatura ao anúncio
     */
    public LocalDateDTO getDataFimCandidatura() {
        return dataFimCandidatura;
    }

    /**
     * 
     * @return data de início de seriação das candidaturas
     */
    public LocalDateDTO getDataInicioSeriacao() {
        return dataInicioSeriacao;
    }

    /**
     * 
     * @return data de fim de seriação das candidaturas
     */
    public LocalDateDTO getDataFimSeriacao() {
        return dataFimSeriacao;
    }

    /**
     * 
     * @return referência do anúncio
     */
    public String getReferenciaTarefa() {
        return referenciaTarefa;
    }

    /**
     * 
     * @return id do tipo de regimento pelo qual se rege o anúncio
     */
    public Long getIdTipoRegimento() {
        return idTipoRegimento;
    }

    /**
     * 
     * @param dataRegistoAnuncio especifica uma nova data de registo do anúncio
     */
    public void setDataRegistoAnuncio(LocalDateDTO dataRegistoAnuncio) {
        this.dataRegistoAnuncio = dataRegistoAnuncio;
    }

    /**
     * 
     * @param dataInicioPublicitacao especifica uma nova data de início de publicitação
     */
    public void setDataInicioPublicitacao(LocalDateDTO dataInicioPublicitacao) {
        this.dataInicioPublicitacao = dataInicioPublicitacao;
    }

    /**
     * 
     * @param dataFimPublicitacao especifica uma nova data de fim de publicitação
     */
    public void setDataFimPublicitacao(LocalDateDTO dataFimPublicitacao) {
        this.dataFimPublicitacao = dataFimPublicitacao;
    }

    /**
     * 
     * @param dataInicioCandidatura especifica uma nova data de início de candidatura
     */
    public void setDataInicioCandidatura(LocalDateDTO dataInicioCandidatura) {
        this.dataInicioCandidatura = dataInicioCandidatura;
    }

    /**
     * 
     * @param dataFimCandidatura especifica uma nova data de fim de candidatura
     */
    public void setDataFimCandidatura(LocalDateDTO dataFimCandidatura) {
        this.dataFimCandidatura = dataFimCandidatura;
    }

    /**
     * 
     * @param dataInicioSeriacao especifica uma nova data de início de seriação
     */
    public void setDataInicioSeriacao(LocalDateDTO dataInicioSeriacao) {
        this.dataInicioSeriacao = dataInicioSeriacao;
    }

    /**
     * 
     * @param dataFimSeriacao especifica uma nova data de fim de seriação
     */
    public void setDataFimSeriacao(LocalDateDTO dataFimSeriacao) {
        this.dataFimSeriacao = dataFimSeriacao;
    }

    /**
     * 
     * @param referenciaTarefa especifica uma nova referência do anúncio
     */
    public void setReferenciaTarefa(String referenciaTarefa) {
        this.referenciaTarefa = referenciaTarefa;
    }

    /**
     * 
     * @param idTipoRegimento especifica um novo id do tipo de regimento a aplicar ao anúncio
     */
    public void setIdTipoRegimento(Long idTipoRegimento) {
        this.idTipoRegimento = idTipoRegimento;
    }
}
