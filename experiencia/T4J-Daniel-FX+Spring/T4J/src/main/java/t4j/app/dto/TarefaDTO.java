package t4j.app.dto;

public class TarefaDTO {

    /**
     * Variável de instância - referência da tarefa
     */
    private String referencia;

    /**
     * Variável de instância - designação da tarefa
     */
    private String designacao;

    /**
     * Variável de instância - descrição informal da tarefa
     */
    private String descricaoInformal;

    /**
     * Variável de instância - descrição técnica da tarefa
     */
    private String descricaoTecnica;

    /**
     * Variável de instância - duração estimada para conclusão da tarefa
     */
    private String duracaoEstimada;

    /**
     * Variável de instância - custo estimado da implememtação da tarefa
     */
    private String custoEstimado;

    /**
     * Variável de instância - categoria em qual a tarefa se enquadra
     */
    private CategoriaTarefaDTO categoria;

    /**
     * Variável de instância - colaborador que cria a tarefa
     */
    private ColaboradorDTO colaborador;

    /**
     * Variável de instância - email do colaborador que cria a tarefa
     */
    private String emailColaborador;

    /**
     * Variável de instância - nif da organização à qual pertence o colaborador que cria a tarefa
     */
    private String nifOrganizacao;

    /**
     * Construtor vazio de tarefa
     */
    public TarefaDTO() {
        this.categoria = new CategoriaTarefaDTO();
    }

    /**
     *
     * @return referência da tarefa
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     *
     * @return designação da tarefa
     */
    public String getDesignacao() {
        return designacao;
    }

    /**
     *
     * @return descrição informal da tarefa
     */
    public String getDescricaoInformal() {
        return descricaoInformal;
    }

    /**
     *
     * @return descrição técnica da tarefa
     */
    public String getDescricaoTecnica() {
        return descricaoTecnica;
    }

    /**
     *
     * @return duração estimada para conclusão da tarefa
     */
    public String getDuracaoEstimada() {
        return duracaoEstimada;
    }

    /**
     *
     * @return custo estimado da implememtação da tarefa
     */
    public String getCustoEstimado() {
        return custoEstimado;
    }

    /**
     *
     * @return categoria em qual a tarefa se enquadra
     */
    public CategoriaTarefaDTO getCategoria() {
        return categoria;
    }

    /**
     *
     * @return colaborador que cria a tarefa
     */
    public ColaboradorDTO getColaborador() {
        return colaborador;
    }

    /**
     *
     * @return email do colaborador que cria a tarefa
     */
    public String getEmailColaborador() {
        return emailColaborador;
    }

    /**
     *
     * @return nif da organização à qual pertence o colaborador que cria a tarefa
     */
    public String getNifOrganizacao() {
        return nifOrganizacao;
    }

    /**
     *
     * @param referencia especifica uma nova referência de tarefa
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     *
     * @param designacao especifica uma nova designação de tarefa
     */
    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    /**
     *
     * @param descricaoInformal especifica uma nova descrição informal de tarefa
     */
    public void setDescricaoInformal(String descricaoInformal) {
        this.descricaoInformal = descricaoInformal;
    }

    /**
     *
     * @param descricaoTecnica especifica uma nova descrição técnica de tarefa
     */
    public void setDescricaoTecnica(String descricaoTecnica) {
        this.descricaoTecnica = descricaoTecnica;
    }

    /**
     *
     * @param duracaoEstimada especifica uma nova duração estimada de tarefa
     */
    public void setDuracaoEstimada(String duracaoEstimada) {
        this.duracaoEstimada = duracaoEstimada;
    }

    /**
     *
     * @param custoEstimado especifica um novo custo estimado de tarefa
     */
    public void setCustoEstimado(String custoEstimado) {
        this.custoEstimado = custoEstimado;
    }

    /**
     *
     * @param categoria especifica uma nova categoria em qual a tarefa se
     * enquadra
     */
    public void setCategoria(CategoriaTarefaDTO categoria) {
        this.categoria = categoria;
    }

    /**
     *
     * @param emailColaborador especifica um novo email do colaborador responsável pela tarefa
     */
    public void setEmailColaborador(String emailColaborador) {
        this.emailColaborador = emailColaborador;
    }

    /**
     *
     * @param nifOrganizacao especifica um novo nif da organização à qual pertence o colaborador responsável pela tarefa
     */
    public void setNifOrganizacao(String nifOrganizacao) {
        this.nifOrganizacao = nifOrganizacao;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TarefaDTO{referencia=").append(referencia);
        sb.append(", designacao=").append(designacao);
        sb.append(", descricaoInformal=").append(descricaoInformal);
        sb.append(", descricaoTecnica=").append(descricaoTecnica);
        sb.append(", duracaoEstimada=").append(duracaoEstimada);
        sb.append(", custoEstimado=").append(custoEstimado);
        sb.append(", categoria=").append(categoria);
        sb.append(", colaborador=").append(colaborador);
        sb.append(", emailColaborador=").append(emailColaborador);
        sb.append(", nifOrganizacao=").append(nifOrganizacao);
        sb.append('}');
        return sb.toString();
    }
}
