package api.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "app_context", "rolename"})
public class RolesDTO {
    
    @JsonIgnore @JsonProperty(value ="id")
    private Long id;
    @JsonIgnore @JsonProperty(value ="app_context")
    private String app_context;
    @JsonProperty(value ="rolename")
    private String rolename;

    public RolesDTO() {
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }
    
    @JsonIgnore
    public String getApp_context() {
        return app_context;
    }

    public String getRolename() {
        return rolename;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void setApp_context(String app_context) {
        this.app_context = app_context;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RolesDTO{id=").append(id);
        sb.append(", rolename=").append(rolename);
        sb.append('}');
        return sb.toString();
    }
}
