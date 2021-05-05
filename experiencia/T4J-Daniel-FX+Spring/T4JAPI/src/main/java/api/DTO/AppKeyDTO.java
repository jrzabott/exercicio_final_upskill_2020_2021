package api.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "app_Key", "descricao", "timeout"})
public class AppKeyDTO {

    @JsonIgnore //@JsonProperty(value ="id")
    private Long id;
    @JsonProperty(value ="app_key")
    private String appkey;
    @JsonProperty(value ="descricao")
    private String descricao;
    @JsonProperty(value ="timeout")
    private Long timeout;


    public AppKeyDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getAppKey() {
        return appkey;
    }

    public String getDescricao() {
        return descricao;
    }

    public Long getTimeout() {
        return timeout;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAppKey(String appKey) {
        this.appkey = appKey;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AppKeyDTO{id=").append(id);
        sb.append(", appKey=").append(appkey);
        sb.append(", descricao=").append(descricao);
        sb.append(", timeout=").append(timeout);
        sb.append('}');
        return sb.toString();
    }
}
