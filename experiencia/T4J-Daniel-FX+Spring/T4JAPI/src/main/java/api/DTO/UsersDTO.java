package api.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "app_context", "email", "username", "password", "rolenames"})
public class UsersDTO {
    
    @JsonProperty(value ="id")
    private Long id;
    @JsonIgnore @JsonProperty(value ="app_context")
    private String app_context;
    @JsonProperty(value ="email")
    private String email;
    @JsonProperty(value ="username")
    private String username;
    @JsonProperty(value ="password")
    private String password;
    @JsonProperty(value ="rolenames")
    private String rolenames;

    public UsersDTO() {
    }

    @JsonIgnore
    public Long getId() {
        return id;
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

    public String getPassword() {
        return password;
    }
    
    public String getRolenames() {
        return rolenames;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRolenames(String rolenames) {
        this.rolenames = rolenames;
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UsersDTO{id=").append(id);
        sb.append(", email=").append(email);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append('}');
        return sb.toString();
    }
}
