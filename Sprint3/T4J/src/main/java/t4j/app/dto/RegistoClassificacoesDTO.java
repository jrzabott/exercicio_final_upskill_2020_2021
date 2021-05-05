package t4j.app.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;

@JacksonXmlRootElement(localName = "classificacoes")
public class RegistoClassificacoesDTO {
    
    /**
     * 
     */
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "classificacao")
    private ArrayList<ClassificacaoDTO> classificacoes;

    /**
     * 
     */
    public RegistoClassificacoesDTO() {
    }

    /**
     * 
     * @return 
     */
    public ArrayList<ClassificacaoDTO> getClassificacoes() {
        return classificacoes;
    }

    /**
     * 
     * @param classificacoes 
     */
    public void setClassificacoes(ArrayList<ClassificacaoDTO> classificacoes) {
        this.classificacoes = classificacoes;
    }
}
