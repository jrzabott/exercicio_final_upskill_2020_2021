package t4j.app.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.time.LocalDate;

@JsonPropertyOrder({"data"})
@JacksonXmlRootElement(localName = "data")
public class LocalDateDTO {

    /**
     * 
     */
    @JacksonXmlProperty(localName = "data")
    private LocalDate localDate;

    /**
     *
     */
    public LocalDateDTO() {
    }

    /**
     * 
     * @return 
     */
    public LocalDate getLocalDate() {
        return localDate;
    }

    /**
     * 
     * @param localDate 
     */
    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
