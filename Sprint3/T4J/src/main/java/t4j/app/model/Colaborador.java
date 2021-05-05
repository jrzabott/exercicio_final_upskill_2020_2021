package t4j.app.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import t4j.app.exception.ElementoInvalidoException;
import t4j.app.utils.Validacao;

@Entity
@Table(name = "colaborador")
@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class Colaborador implements Serializable {

    /**
     * Variável de instância - nome do colaborador
     */
    @Column(name = "nome")
    private String nome;

    /**
     * Variável de instância - função do colaborador
     */
    @Column(name = "funcao")
    private String funcao;

    /**
     * Variável de instância - telefone do colaborador
     */
    @Column(name = "telefone")
    private String telefone;

    /**
     * Variável de instância - e-Mail do colaborador
     */
    @Id
    @Column(name = "email")
    private String email;

    /**
     *
     */
    @Column(name = "nif_organizacao")
    private String nifOrganizacao;

    /**
     *
     */
    @Column(name = "gestor")
    private String gestor;

    /**
     * Construtor completo de colaborador
     *
     * @param nome nome do colaborador
     * @param funcao função do colaborador
     * @param telefone telefone do colaborador
     * @param email e-Mail do colaborador
     */
    public Colaborador(String nome, String funcao, String telefone, String email, String gestor) {
        setNome(nome);
        setFuncao(funcao);
        setTelefone(telefone);
        setEmail(email);
        setGestor(gestor);
    }

    /**
     * Construtor completo de colaborador
     *
     * @param nome nome do colaborador
     * @param funcao função do colaborador
     * @param telefone telefone do colaborador
     * @param email e-Mail do colaborador
     */
    public Colaborador(String nome, String funcao, String telefone, String email) {
        setNome(nome);
        setFuncao(funcao);
        setTelefone(telefone);
        setEmail(email);
    }

    /**
     * Construtor vazio de colaborador
     */
    public Colaborador() {

    }

    /**
     * Construtor cópia de colaborador
     *
     * @param outroColaborador instância colaborador a ser copiada
     */
    public Colaborador(Colaborador outroColaborador) {
        setNome(outroColaborador.nome);
        setFuncao(outroColaborador.funcao);
        setTelefone(outroColaborador.telefone);
        setEmail(outroColaborador.email);
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
     * @return e-Mail do colaborador
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
     * @param nome especifica um novo nome do colaborador
     */
    public void setNome(String nome) throws ElementoInvalidoException {
        nome = nome.trim();
        if (Validacao.validaNomeColaborador(nome)) {
            this.nome = nome;
        } else {
            throw new ElementoInvalidoException("Nome de colaborador inválido.");
        }
    }

    /**
     *
     * @param funcao especifica uma nova função do colaborador
     */
    public void setFuncao(String funcao) throws ElementoInvalidoException {
        funcao = funcao.trim();
        if (Validacao.validaFuncaoColaborador(funcao)) {
            this.funcao = funcao;
        } else {
            throw new ElementoInvalidoException("Função inválida.");
        }
    }

    /**
     *
     * @param telefone especifica um novo telefone do colaborador
     */
    public void setTelefone(String telefone) throws ElementoInvalidoException {
        telefone = telefone.trim();
        if (Validacao.validaTelefone(telefone)) {
            this.telefone = telefone;
        } else {
            throw new ElementoInvalidoException("Telefone de colaborador inválido.");
        }
    }

    /**
     *
     * @param email especifica um novo e-Mail do colaborador
     */
    public void setEmail(String email) throws ElementoInvalidoException {
        email = email.trim();
        if (Validacao.validaEmail(email)) {
            this.email = email;
        } else {
            throw new ElementoInvalidoException("Email de colaborador inválido.");
        }
    }

    /**
     *
     * @return retorna uma String com a descrição do colaborador (nome, função,
     * telefone, e-Mail)
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Colaborador{nome=").append(nome);
        sb.append(", funcao=").append(funcao);
        sb.append(", telefone=").append(telefone);
        sb.append(", email=").append(email);
        sb.append(", nifOrganizacao=").append(nifOrganizacao);
        sb.append(", gestor=").append(gestor);
        sb.append('}');
        return sb.toString();
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.nome);
        hash = 73 * hash + Objects.hashCode(this.funcao);
        hash = 73 * hash + Objects.hashCode(this.telefone);
        hash = 73 * hash + Objects.hashCode(this.email);
        hash = 73 * hash + Objects.hashCode(this.nifOrganizacao);
        hash = 73 * hash + Objects.hashCode(this.gestor);
        return hash;
    }

    /**
     *
     * @param outroObjeto
     * @return
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Colaborador outroColaborador = (Colaborador) outroObjeto;
        return nome.equalsIgnoreCase(outroColaborador.nome)
                && funcao.equalsIgnoreCase(outroColaborador.funcao)
                && telefone.equalsIgnoreCase(outroColaborador.telefone)
                && email.equalsIgnoreCase(outroColaborador.email)
                && nifOrganizacao.equalsIgnoreCase(outroColaborador.nifOrganizacao)
                && gestor.equalsIgnoreCase(outroColaborador.gestor);
    }
}
