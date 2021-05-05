package t4j.app.dto;

public class RoleDTO {

    /**
     * Variável de instância - nome do role
     */
    private String rolename;

    /**
     * Variável de instância - descrição do role
     */
    private String description;

    /**
     * Construtor vazio de Role
     */
    public RoleDTO() {
    }

    /**
     *
     * @return nome do role
     */
    public String getRolename() {
        return rolename;
    }

    /**
     *
     * @return descrição do role
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param rolename especifica um novo nome do role
     */
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    /**
     *
     * @param description especifica uma nova descrição do role
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RoleDTO{");
        sb.append("rolename=").append(rolename);
        sb.append("description=").append(description);
        sb.append('}');
        return sb.toString();
    }
}
