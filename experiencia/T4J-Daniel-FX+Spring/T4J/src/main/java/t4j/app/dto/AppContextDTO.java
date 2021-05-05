package t4j.app.dto;

public class AppContextDTO {

    /**
     * variável de instância - app_context da API de autenticação
     */
    private String app_context;

    /**
     *
     * @return app_context da API de autenticação
     */
    public String getApp_context() {
        return app_context;
    }

    /**
     *
     * @param app_context especifica uma nova app_context da API de autenticação
     */
    public void setApp_context(String app_context) {
        this.app_context = app_context;
    }

    /**
     * construtor vazio AppContext
     */
    public AppContextDTO() {
    }
}
