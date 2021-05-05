package t4j.app.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import t4j.app.exception.ElementoInvalidoException;
import t4j.app.utils.Validacao;

@Entity
@Table(name = "tarefa")
public class Tarefa implements Serializable {

    /**
     * Variável de instância - referência da tarefa
     */
    @Id
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
    @OneToOne(targetEntity = CategoriaTarefa.class)
    @JoinColumn(referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_TAREFA_CATEGORIATAREFA"), name = "id_categoria")
    private CategoriaTarefa categoria;

    /**
     * Variável de instância - colaborador que cria a tarefa
     */
    @Transient
    private Colaborador colaborador;

    /**
     * Variável de instância - email do colaborador que cria a tarefa
     */
//    @OneToOne(targetEntity = Colaborador.class)
//    @JoinColumn(referencedColumnName = "email", foreignKey = @ForeignKey(name = "FK_TAREFA_COLABORADOR"), name ="email_colaborador")
    @Column(name = "email_colaborador")
    private String emailColaborador;

    /**
     * Variável de instância - nif da organização à qual pertence o colaborador que cria a tarefa
     */
//    @OneToOne(targetEntity = Organizacao.class)
//    @JoinColumn(referencedColumnName = "nif", foreignKey = @ForeignKey(name = "FK_TAREFA_ORGANIZACAO"), name ="nif_organizacao")
    @Column(name = "nif_organizacao")
    private String nifOrganizacao;

    /**
     * Construtor completo de tarefa
     *
     * @param referencia referência da tarefa
     * @param designacao designação da tarefa
     * @param descricaoInformal descrição informal da tarefa
     * @param descricaoTecnica descrição técnica da tarefa
     * @param duracaoEstimada duração estimada para conclusão da tarefa
     * @param custoEstimado custo estimado da implememtação da tarefa
     * @param categoria categoria em qual a tarefa se enquadra
     * @param emailColaborador email do colaborador que cria a tarefa
     * @param nifOrganizacao nif da organização à qual pertence o colaborador que cria a tarefa
     */
    public Tarefa(String referencia, String designacao, String descricaoInformal, String descricaoTecnica, String duracaoEstimada, String custoEstimado, CategoriaTarefa categoria, String emailColaborador, String nifOrganizacao) {
        setReferencia(referencia);
        setDesignacao(designacao);
        setDescricaoInformal(descricaoInformal);
        setDescricaoTecnica(descricaoTecnica);
        setDuracaoEstimada(duracaoEstimada);
        this.custoEstimado = custoEstimado;
        this.categoria = new CategoriaTarefa(categoria);
        this.emailColaborador = emailColaborador;
        this.nifOrganizacao = nifOrganizacao;
    }
    
    /**
     * Construtor parcial de tarefa
     * 
     * @param referencia referência da tarefa
     * @param designacao designação da tarefa
     * @param descricaoInformal descrição informal da tarefa
     * @param descricaoTecnica descrição técnica da tarefa
     * @param duracaoEstimada duração estimada para conclusão da tarefa
     * @param custoEstimado custo estimado da implememtação da tarefa
     * @param categoria  categoria em qual a tarefa se enquadra
     */
    public Tarefa(String referencia, String designacao, String descricaoInformal, String descricaoTecnica, String duracaoEstimada, String custoEstimado, CategoriaTarefa categoria) {
        setReferencia(referencia);
        setDesignacao(designacao);
        setDescricaoInformal(descricaoInformal);
        setDescricaoTecnica(descricaoTecnica);
        setDuracaoEstimada(duracaoEstimada);
        this.custoEstimado = custoEstimado;
        this.categoria = new CategoriaTarefa(categoria);
        this.colaborador = colaborador;
    }

    /**
     * Construtor vazio de tarefa
     */
    public Tarefa() {
        categoria = new CategoriaTarefa();
    }

    /**
     * Construtor cópia de tarefa
     *
     * @param outraTarefa instância de tarefa a ser copiada
     */
    public Tarefa(Tarefa outraTarefa) {
        setReferencia(outraTarefa.referencia);
        setDesignacao(outraTarefa.designacao);
        setDescricaoInformal(outraTarefa.descricaoInformal);
        setDescricaoTecnica(outraTarefa.descricaoTecnica);
        setDuracaoEstimada(outraTarefa.duracaoEstimada);
        this.custoEstimado = custoEstimado;
        this.categoria = new CategoriaTarefa(outraTarefa.categoria);
        this.emailColaborador = "";
        this.nifOrganizacao = "";
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
    public CategoriaTarefa getCategoria() {
        return categoria;
    }

    /**
     *
     * @return colaborador que cria a tarefa
     */
    public Colaborador getColaborador() {
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
    public void setReferencia(String referencia) throws ElementoInvalidoException {
        referencia = referencia.trim();
        if (Validacao.validaReferenciaTarefa(referencia)) {
            this.referencia = referencia;
        } else {
            throw new ElementoInvalidoException("Referência inválida.");
        }
    }

    /**
     *
     * @param designacao especifica uma nova designação de tarefa
     */
    public void setDesignacao(String designacao) throws ElementoInvalidoException {
        designacao = designacao.trim();
        if (Validacao.validaDesignacaoTarefa(designacao)) {
            this.designacao = designacao;
        } else {
            throw new ElementoInvalidoException("Designação inválida.");
        }
    }

    /**
     *
     * @param descricaoInformal especifica uma nova descrição informal de tarefa
     */
    public void setDescricaoInformal(String descricaoInformal) throws ElementoInvalidoException {
        descricaoInformal = descricaoInformal.trim();
        if (Validacao.validaDescricaoInformalTarefa(descricaoInformal)) {
            this.descricaoInformal = descricaoInformal;
        } else {
            throw new ElementoInvalidoException("Descrição informal inválida.");
        }
    }

    /**
     *
     * @param descricaoTecnica especifica uma nova descrição técnica de tarefa
     */
    public void setDescricaoTecnica(String descricaoTecnica) throws ElementoInvalidoException {
        descricaoTecnica = descricaoTecnica.trim();
        if (Validacao.validaDescricaoTecnicaTarefa(descricaoTecnica)) {
            this.descricaoTecnica = descricaoTecnica;
        } else {
            throw new ElementoInvalidoException("Descrição técnica inválida.");
        }
    }

    /**
     *
     * @param duracaoEstimada especifica uma nova duração estimada de tarefa
     */
    public void setDuracaoEstimada(String duracaoEstimada) throws ElementoInvalidoException {
        duracaoEstimada = duracaoEstimada.trim();
        if (Validacao.validaDuracaoEstimadaTarefa(duracaoEstimada)) {
            this.duracaoEstimada = duracaoEstimada;
        } else {
            throw new ElementoInvalidoException("Duração inválida.");
        }
    }

    /**
     *
     * @param custoEstimado especifica um novo custo estimado de tarefa
     */
    // check and round number before set
    public void setCustoEstimado(String custoEstimado) throws ElementoInvalidoException {
        custoEstimado = custoEstimado.trim();
        if (Validacao.validaCustoEstimadoTarefa(custoEstimado)) {
            this.custoEstimado = custoEstimado;
        } else {
            throw new ElementoInvalidoException("Custo inválido.");
        }
    }

    /**
     *
     * @param categoria especifica uma nova categoria em qual a tarefa se
     * enquadra
     */
    public void setCategoria(CategoriaTarefa categoria) {
        this.categoria = categoria;
    }

    /**
     *
     * @param colaborador especifica um novo colaborador responsável pela tarefa
     */
    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
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
     * @return retorna uma String com a descrição da tarefa (referência, designação, descrição informal, descrição técnica,
     * duração estimada, custo estimado, categoria, colaborador, email do colaborador, nif da organização)
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tarefa{referencia=").append(referencia);
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

    /**
     *
     * @param outroObjeto instância de tarefa a ser comparada
     * @return reescrita do método equals e retorna um booleano
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Tarefa outraTarefa = (Tarefa) outroObjeto;
        return referencia.equalsIgnoreCase(outraTarefa.referencia)
                && designacao.equalsIgnoreCase(outraTarefa.designacao)
                && descricaoInformal.equalsIgnoreCase(outraTarefa.descricaoInformal)
                && descricaoTecnica.equalsIgnoreCase(outraTarefa.descricaoTecnica)
                && duracaoEstimada.equalsIgnoreCase(outraTarefa.duracaoEstimada)
                && custoEstimado.equalsIgnoreCase(outraTarefa.custoEstimado)
                && nifOrganizacao.equalsIgnoreCase(outraTarefa.nifOrganizacao)
                && emailColaborador.equalsIgnoreCase(outraTarefa.emailColaborador)
                && categoria.equals(outraTarefa.categoria);
    }

    /**
     *
     * @return Override do hashCode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.referencia);
        hash = 97 * hash + Objects.hashCode(this.designacao);
        hash = 97 * hash + Objects.hashCode(this.descricaoInformal);
        hash = 97 * hash + Objects.hashCode(this.descricaoTecnica);
        hash = 97 * hash + Objects.hashCode(this.duracaoEstimada);
        hash = 97 * hash + Objects.hashCode(this.custoEstimado);
        hash = 97 * hash + Objects.hashCode(this.categoria);
        hash = 97 * hash + Objects.hashCode(this.nifOrganizacao);
        hash = 97 * hash + Objects.hashCode(this.emailColaborador);
        return hash;
    }
}
