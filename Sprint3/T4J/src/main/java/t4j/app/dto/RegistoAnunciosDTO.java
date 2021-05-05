package t4j.app.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;

@JacksonXmlRootElement(localName = "anuncios")
public class RegistoAnunciosDTO {
    
    /**
     * Variável de instância - contentor do tipo ArrayList que guarda todas as instâncias do tipo anúncio
     */
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "anuncio")
    private ArrayList<AnuncioDTO> anuncios;
    
    /**
     * Construtor vazio de lista de anúncios
     */
    public RegistoAnunciosDTO() {
    }
    
    /**
     * 
     * @return contentor do tipo ArrayList que guarda todas as instâncias do tipo anúncio
     */
    public ArrayList<AnuncioDTO> getAnuncios() {
        return anuncios;
    }
    
    /**
     * 
     * @param anuncios especifica um novo contentor do tipo ArrayList que guarda todas as instâncias do tipo anúncio
     */
    public void setAnuncios(ArrayList<AnuncioDTO> anuncios) {
        this.anuncios = anuncios;
    }
}
