package t4j.app.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;

@JacksonXmlRootElement(localName = "processosseriacao")
public class RegistoProcessosSeriacaoDTO {
    
    /**
     * 
     */
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "processoseriacao")
    private ArrayList<ProcessoSeriacaoDTO> processosSeriacao;

    /**
     * 
     */
    public RegistoProcessosSeriacaoDTO() {
    }

    /**
     * 
     * @return 
     */
    public ArrayList<ProcessoSeriacaoDTO> getProcessosSeriacao() {
        return processosSeriacao;
    }

    /**
     * 
     * @param processosSeriacao 
     */
    public void setProcessosSeriacao(ArrayList<ProcessoSeriacaoDTO> processosSeriacao) {
        this.processosSeriacao = processosSeriacao;
    }
}
