package t4j.app.dto;

public class ColaboradorDTO {

    /**
     * Variável de instância - nome do colaborador
     */
    private String nome;

    /**
     * Variável de instância - função do colaborador
     */
    private String funcao;

    /**
     * Variável de instância - telefone do colaborador
     */
    private String telefone;

    /**
     * Variável de instância - email do colaborador
     */
    private String email;

    /**
     *
     */
    private String nifOrganizacao;

    /**
     *
     */
    private String gestor;

    /**
     * Construtor vazio do colaborador
     */
    public ColaboradorDTO() {
    }

    /**
     *
     * @return
     */
    public String getGestor() {
        return gestor;
    }

    /**
     *
     * @return
     */
    public String getNifOrganizacao() {
        return nifOrganizacao;
    }

    /**
     *
     * @return nome do colaborador
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return função do colaborador
     */
    public String getFuncao() {
        return funcao;
    }

    /**
     *
     * @return telefone do colaborador
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     *
     * @return email do colaborador
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param gestor
     */
    public void setGestor(String gestor) {
        this.gestor = gestor;
    }

    /**
     *
     * @param nifOrganizacao
     */
    public void setNifOrganizacao(String nifOrganizacao) {
        this.nifOrganizacao = nifOrganizacao;
    }

    /**
     *
     * @param nome especifica um novo nome nome do colaborador
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @param funcao especifica uma nova função do colaborador
     */
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    /**
     *
     * @param telefone especifica um novo telefone do colaborador
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     *
     * @param email especifica um novo email do colaborador
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ColaboradorDTO{nome=").append(nome);
        sb.append(", funcao=").append(funcao);
        sb.append(", telefone=").append(telefone);
        sb.append(", email=").append(email);
        sb.append(", nifOrganizacao=").append(nifOrganizacao);
        sb.append(", gestor=").append(gestor);
        sb.append('}');
        return sb.toString();
    }
}
