package t4j.app.repo;

public enum EnumFXMLs {

    /**
     * Constante - caminho até à interface gráfica da janela principal e título
     * da janela
     */
    MAIN_SCENE("/fxml/MainScene.fxml", "TASKS 4 JOE - T4J"),
    /**
     * Constante - caminho até à interface gráfica da janela de login e título
     * da janela
     */
    AUTENTICACAO("/fxml/UIAutenticacao.fxml", "Login"),
    /**
     * Constante - caminho até à interface gráfica da janela de definição de
     * área de trabalho e título da janela
     */
    CRIAR_AREA_ATIVIDADE("/fxml/UICreateAreaAtividade.fxml", "Area de Atividade"),
    /**
     * Constante - caminho até à interface gráfica da janela de definição de
     * categoria de tarefa e título da janela
     */
    CRIAR_CATEGORIA_TAREFA("/fxml/UICreateCategoriaTarefa.fxml", "Categoria de Tarefa"),
    /**
     * Constante - caminho até à interface gráfica da janela de definição de
     * competência técnica e título da janela
     */
    CRIAR_COMPETENCIA_TECNICA("/fxml/UICreateCompetenciaTecnica.fxml", "Competencia Técnica"),
    /**
     * Constante - caminho até à interface gráfica da janela de especificação de
     * um colaborador e título da janela
     */
    CRIAR_COLABORADOR("/fxml/UICreateColaborador.fxml", "Colaborador"),
    /**
     * Constante - caminho até à interface gráfica da janela de especificação de
     * uma tarefa e título da janela
     */
    CRIAR_TAREFA("/fxml/UICreateTarefa.fxml", "Tarefa"),
    /**
     * Constante - caminho até à interface gráfica da janela de registo de uma
     * organização e título da janela
     */
    CRIAR_ORGANIZACAO("/fxml/UICreateOrganizacao.fxml", "Organização"),
    /**
     * Constante - caminho até à interface gráfica da janela de registo de um freelancer e título da janela
     */
    CRIAR_FREELANCER("/fxml/UICreateFreelancer.fxml", "Freelancer"),
    /**
     * Constante - caminho até à interface gráfica da janela de publicação de tarefa e título da janela
     */
    PUBLICAR_TAREFA("/fxml/UICreateAnuncio.fxml", "Publicar Tarefa"),
    /**
     * Constante - caminho até à interface gráfica da janela de atualização de um anúncio e título da janela
     */
    CRIAR_ANUNCIO("/fxml/UIUpdateAnuncio.fxml", "Atalizar Anúncio"),
    /**
     * Constante - caminho até à interface gráfica da janela de seriação de candidaturas e título da janela
     */
    SERIAR_CANDIDATURA("/fxml/UISeriarCandidaturas.fxml", "Seriar"),
    /**
     * Constante - caminho até à interface gráfica da janela de efetuar candidatura e título da janela
     */
    CRIAR_CANDIDATURA("/fxml/UICreateCandidatura.fxml", "Candidatura"),
    /**
     * Constante - caminho até à interface gráfica da janela de configuração e título da janela
     */
    CONFIGURACAO("/fxml/Configuracao.fxml", "Configuração"),
    /**
     * Constante - caminho até à interface gráfica da janela de definir tipo de regimento e título da janela
     */
    CRIAR_TIPO_REGIMENTO("/fxml/UICreateTipoRegimento.fxml", "Tipo de Regimento"),

    REGISTAR_HABILITACAO_ACADEMICA("/fxml/UICreateHabilitacoesAcademicas.fxml", "Habilitacao_Academica"),

    CRIAR_RECONHECIMENTO_CT("/fxml/UICreateReconhecimentoCT.fxml", "Reconhecimento Competência Técnica");

    /**
     * Variável de instância - caminho
     */
    private final String path;

    /**
     * Variável de instância - título
     */
    private final String title;

    /**
     * Construtor completo de enumeração de FXML's
     *
     * @param path
     * @param title
     */
    private EnumFXMLs(String path, String title) {
        this.path = path;
        this.title = title;
    }

    /**
     * Construtor parcial de enumeração de FXML's
     *
     * @param path
     */
    private EnumFXMLs(String path) {
        this.path = path;
        this.title = "";
    }

    /**
     *
     * @return caminho
     */
    public String getPath() {
        return path;
    }

    /**
     *
     * @return título
     */
    public String getTitle() {
        return title;
    }
}
