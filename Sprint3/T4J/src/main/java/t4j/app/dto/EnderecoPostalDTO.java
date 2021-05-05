package t4j.app.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@JsonPropertyOrder({"morada", "codigoPostal", "localidade"})
@JacksonXmlRootElement(localName = "enderecoPostal")
public class EnderecoPostalDTO {

    @JacksonXmlProperty(localName = "id")
    private Long id;

    /**
     * Variável de instância - morada
     */
    @JacksonXmlProperty(localName = "morada")
    private String morada;

    /**
     * Variável de instância - código postal
     */
    @JacksonXmlProperty(localName = "codigoPostal")
    private String codigoPostal;

    /**
     * Variável de instância - localidade
     */
    @JacksonXmlProperty(localName = "localidade")
    private String localidade;

    /**
     * Construtor vazio de endereço postal
     */
    public EnderecoPostalDTO() {
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EnderecoPostalDTO other = (EnderecoPostalDTO) obj;
        if (!Objects.equals(this.morada, other.morada)) {
            return false;
        }
        if (!Objects.equals(this.codigoPostal, other.codigoPostal)) {
            return false;
        }
        if (!Objects.equals(this.localidade, other.localidade)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public Long getId() {
        return id;
    }

    /**
     *
     * @return morada
     */
    public String getMorada() {
        return morada;
    }

    /**
     *
     * @return código postal
     */
    public String getCodPostal() {
        return codigoPostal;
    }

    /**
     *
     * @return localidade
     */
    public String getLocalidade() {
        return localidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.morada);
        hash = 59 * hash + Objects.hashCode(this.codigoPostal);
        hash = 59 * hash + Objects.hashCode(this.localidade);
        return hash;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @param morada especifica uma nova morada do endereço postal
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

    /**
     *
     * @param codigoPostal especifica um novo código postal do endereço postal
     */
    public void setCodPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     *
     * @param localidade especifica uma nova localidade do endereço postal
     */
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EnderecoPostalDTO\n{\n  id=").append(id);
        sb.append("\n  morada=").append(morada);
        sb.append("\n  codigoPostal=").append(codigoPostal);
        sb.append("\n  localidade=").append(localidade);
        sb.append("\n}");
        return sb.toString();
    }
}
