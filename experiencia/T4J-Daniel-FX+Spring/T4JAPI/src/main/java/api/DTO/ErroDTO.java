package api.DTO;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "erro")
public class ErroDTO {

    @JacksonXmlProperty(localName = "mensagem")
    private String error;

    public ErroDTO(Exception e) {
        error = e.getMessage();
    }

    public ErroDTO() {
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("error").append(error);
        return sb.toString();
    }
}
