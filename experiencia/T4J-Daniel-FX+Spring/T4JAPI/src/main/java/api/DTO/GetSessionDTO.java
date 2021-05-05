package api.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.time.LocalDateTime;

@JsonPropertyOrder({"app_context", "username", "email", "rolenames", "logindate"})
public class GetSessionDTO {

    @JsonIgnore
    @JsonProperty(value = "app_context")
    private String app_context;
    @JsonProperty(value = "email")
    private String email;
    @JsonProperty(value = "username")
    private String username;
    @JsonProperty(value = "rolenames")
    private String rolenames;
    @JsonProperty(value = "logindate")
    private LocalDateTime login_date;

    public GetSessionDTO() {
    }

    @JsonIgnore
    public String getApp_context() {
        return app_context;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getRolenames() {
        return rolenames;
    }

    public LocalDateTime getLogin_date() {
        return login_date;
    }

    public void setApp_context(String app_context) {
        this.app_context = app_context;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRolenames(String rolenames) {
        this.rolenames = rolenames;
    }

    public void setLogin_date(LocalDateTime login_date) {
        this.login_date = login_date;
    }
}
