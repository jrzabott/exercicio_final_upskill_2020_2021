package api.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"app_context", "user_id", "rolenames"})
public class UserRolesDTO {
    
    @JsonIgnore @JsonProperty(value ="app_context")
    private String app_context;
    @JsonProperty(value ="user_id")
    private String user_id;
    @JsonProperty(value ="rolenames")
    private String rolenames;

    public UserRolesDTO() {
    }

    public String getApp_context() {
        return app_context;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getRolenames() {
        return rolenames;
    }

    public void setApp_context(String app_context) {
        this.app_context = app_context;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setRolenames(String rolenames) {
        this.rolenames = rolenames;
    }
}
