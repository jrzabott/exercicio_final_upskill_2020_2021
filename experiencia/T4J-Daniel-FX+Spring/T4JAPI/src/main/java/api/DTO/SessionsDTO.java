package api.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "app_context", "login_date", "context_id", "user_id"})
public class SessionsDTO {
    
    @JsonIgnore @JsonProperty(value ="id")
    private Long id;
    @JsonIgnore @JsonProperty(value ="app_context")
    private String app_context;
    @JsonProperty(value ="login_date")
    private LocalDateTimeDTO login_date;
    @JsonProperty(value ="context_id")
    private Long context_id;
    @JsonProperty(value ="user_id")
    private Long user_id;

    public SessionsDTO() {
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }
    
    @JsonIgnore
    public String getApp_context() {
        return app_context;
    }

    public LocalDateTimeDTO getLogin_date() {
        return login_date;
    }

    public Long getContext_id() {
        return context_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void setApp_context(String app_context) {
        this.app_context = app_context;
    }

    public void setLogin_date(LocalDateTimeDTO login_date) {
        this.login_date = login_date;
    }

    public void setContext_id(Long context_id) {
        this.context_id = context_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SessionsDTO{id=").append(id);
        sb.append(", login_date=").append(login_date);
        sb.append(", context_id=").append(context_id);
        sb.append(", user_id=").append(user_id);
        sb.append('}');
        return sb.toString();
    }
}
