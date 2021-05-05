package t4j.app.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;

@JacksonXmlRootElement(localName = "tiposregimento")
public class RegistoTiposRegimentoDTO {
    
    /**
     * Variável de instância - contentor do tipo ArrayList que guarda todas as instâncias do tipo tipo de regimento
     */
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "tiporegimento")
    private ArrayList<TipoRegimentoDTO> tiposRegimento;
    
    /**
     * Construtor vazio de lista de tipos de regimento
     */
    public RegistoTiposRegimentoDTO() {
    }
    
    /**
     * 
     * @return contentor do tipo ArrayList que guarda todas as instâncias do tipo tipo de regimento
     */
    public ArrayList<TipoRegimentoDTO> getTiposRegimento() {
        return tiposRegimento;
    }
    
    /**
     * 
     * @param tiposRegimento especifica um novo contentor do tipo ArrayList que guarda todas as instâncias do tipo tipo de regimento
     */
    public void setTiposRegimento(ArrayList<TipoRegimentoDTO> tiposRegimento) {
        this.tiposRegimento = tiposRegimento;
    }
}
