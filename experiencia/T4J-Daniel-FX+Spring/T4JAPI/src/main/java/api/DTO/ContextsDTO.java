package api.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "app_context", "datacriacao", "valido"})
public class ContextsDTO {

    @JsonIgnore //@JsonProperty("id")
    private Long id;
    @JsonProperty("app_context")
    private String context;
    @JsonIgnore //@JsonProperty("datacriacao")
    private LocalDateTimeDTO dataCriacao;
    @JsonIgnore //@JsonProperty("valido")
    private String valido;

    public ContextsDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getContext() {
        return context;
    }

    public LocalDateTimeDTO getDataCriacao() {
        return dataCriacao;
    }

    public String getValido() {
        return valido;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setDataCriacao(LocalDateTimeDTO dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setValido(String valido) {
        this.valido = valido;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ContextsDTO{id=").append(id);
        sb.append(", context=").append(context);
        sb.append(", dataCriacao=").append(dataCriacao);
        sb.append(", valido=").append(valido);
        sb.append('}');
        return sb.toString();
    }
}
