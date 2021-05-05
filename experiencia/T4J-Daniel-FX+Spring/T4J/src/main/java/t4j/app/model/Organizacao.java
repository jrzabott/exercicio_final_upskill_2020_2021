package t4j.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import t4j.app.exception.ElementoDuplicadoException;
import t4j.app.exception.ElementoInvalidoException;
import t4j.app.utils.Validacao;

@Entity
@Table(name = "organizacao")
@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class Organizacao implements Serializable {

    /**
     * Variável de instância - nome da organização
     */
    @Column(name = "nome")
    private String nome;

    /**
     * Variável de instância - nif da organização
     */
    @Id
    private String nif;

    /**
     * Variável de instância - website da organização
     */
    @Column(name = "website")
    private String website;

    /**
     * Variável de instância - telefone da organização
     */
    @Column(name = "telefone")
    private String telefone;

    /**
     * Variável de instância - email da organização
     */
    @Column(name = "email")
    private String email;

    /**
     * Variável de instância - endereço da organização
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco", foreignKey = @ForeignKey(name = "FK_ORGANIZACAO_ENDERECO"))
    private EnderecoPostal endereco;

    /**
     * Variável de instância - gestor da organização
     */
    @Transient
    private Colaborador gestor;

    /**
     * Variável de instância - registo de tarefas
     */
    @Transient
    private RegistoTarefas listaTarefas;

    /**
     * Variável de instância - contentor do tipo ArrayList que guarda todas as instâncias do tipo
     * colaborador
     */
//    @Transient
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "NIF_ORGANIZACAO", foreignKey = @ForeignKey(name = "FK_COLABORADOR_ORGANIZACAO"))
    private List<Colaborador> colaboradores;

    /**
     * Construtor completo de organização
     *
     * @param nome     nome da organização
     * @param nif      nif da organização
     * @param website  website da organização
     * @param telefone telefone da organização
     * @param email    email da organização
     * @param endereco endereço da organização
     * @param gestor   gestor da organização
     */
    public Organizacao(String nome, String nif, String website, String telefone, String email, EnderecoPostal endereco, Colaborador gestor) {
        this.endereco = endereco;
        this.gestor = gestor;
        this.colaboradores = new ArrayList<Colaborador>();
        this.listaTarefas = new RegistoTarefas();
        setNome(nome);
        setNif(nif);
        setWebsite(website);
        setTelefone(telefone);
        setEmail(email);
    }

    /**
     * Construtor cópia de organização
     *
     * @param organizacao
     */
    public Organizacao(Organizacao organizacao) {
        setNome(organizacao.nome);
        setNif(organizacao.nif);
        setWebsite(organizacao.website);
        setTelefone(organizacao.telefone);
        setEmail(organizacao.email);
        this.endereco = new EnderecoPostal(organizacao.endereco);
        this.gestor = new Colaborador(organizacao.gestor);
        this.colaboradores = new ArrayList<Colaborador>(organizacao.getColaboradores());
        this.listaTarefas = new RegistoTarefas(organizacao.listaTarefas);
    }

    /**
     * Construtor vazio de organização
     */
    public Organizacao() {
        colaboradores = new ArrayList<>();
        endereco = new EnderecoPostal();
        gestor = new Colaborador();
        listaTarefas = new RegistoTarefas();
    }

    /**
     * Construtor parcial da Organização
     *
     * @param nome
     * @param nif
     * @param website
     * @param telefone
     * @param email
     */
    public Organizacao(String nome, String nif, String website, String telefone, String email) {
        setNome(nome);
        setNif(nif);
        setWebsite(website);
        setTelefone(telefone);
        setEmail(email);
        this.endereco = new EnderecoPostal();
        this.gestor = new Colaborador();
        this.colaboradores = new ArrayList<Colaborador>();
        this.listaTarefas = new RegistoTarefas();
    }

    /**
     *
     * @return contentor do tipo ArrayList que guarda todas as instâncias do tipo colaborador
     */
    public ArrayList<Colaborador> getColaboradores() {
        return new ArrayList<Colaborador>(this.colaboradores);
    }

    /**
     *
     * @return email da organização
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @return endereço da organização
     */
    public EnderecoPostal getEndereco() {
        return endereco;
    }

    /**
     *
     * @return gestor da organização
     */
    public Colaborador getGestor() {
        return gestor;
    }

    /**
     *
     * @return registo de tarefas
     */
    public RegistoTarefas getListaTarefas() {
        return listaTarefas;
    }

    /**
     *
     * @return nif da organização
     */
    public String getNif() {
        return nif;
    }

    /**
     *
     * @return nome da organização
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return telefone da organização
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     *
     * @return website da organização
     */
    public String getWebsite() {
        return website;
    }

    /**
     *
     * @param colaboradores especifica um novo contentor do tipo ArrayList que guarda todas as
     *                      instâncias do tipo colaborador
     */
    public void setColaboradores(ArrayList<Colaborador> colaboradores) {
        this.colaboradores = new ArrayList<Colaborador>(colaboradores);
    }

    /**
     *
     * @param emailOrganizacao especifica um novo email da organização
     */
    public void setEmail(String emailOrganizacao) throws ElementoInvalidoException {
        emailOrganizacao = emailOrganizacao.trim();
        if (Validacao.validaEmail(emailOrganizacao)) {
            this.email = emailOrganizacao;
        } else {
            throw new ElementoInvalidoException("Email de organização inválido.");
        }
    }

    /**
     *
     * @param nome especifica um novo nome da organização
     * @throws ElementoInvalidoException
     */
    public void setNome(String nome) throws ElementoInvalidoException {
        nome = nome.trim();
        if (Validacao.validaNomeOrganizacao(nome)) {
            this.nome = nome;
        } else {
            throw new ElementoInvalidoException("Nome de organização inválido.");
        }
    }

    /**
     *
     * @param endereco especifica um novo enderço da organização
     */
    public void setEndereco(EnderecoPostal endereco) {
        this.endereco = endereco;
    }

    /**
     *
     * @param gestor especifica um novo gestor da organização
     */
    public void setGestor(Colaborador gestor) {
        this.gestor = gestor;
    }

    /**
     *
     * @param listaTarefas especifica uma nova lista de tarefas
     */
    public void setListaTarefas(RegistoTarefas listaTarefas) {
        this.listaTarefas = listaTarefas;
    }

    /**
     *
     * @param nif especifica um novo nif da organização
     */
    public void setNif(String nif) throws ElementoInvalidoException {
        nif = nif.trim();
        if (Validacao.validaNif(nif)) {
            this.nif = nif;
        } else {
            throw new ElementoInvalidoException("NIF inválido. Introduza NIF com 9 dígitos.");
        }
    }

    /**
     *
     * @param website especifica um novo website da organização
     * @throws ElementoInvalidoException
     */
    public void setWebsite(String website) throws ElementoInvalidoException {
        website = website.trim();
        String http = "http://";
        if (!website.startsWith("http", 0)) {
            website = http += website;
        }
        if (Validacao.validaWebsiteOrganizacao(website)) {
            this.website = website;
        } else {
            throw new ElementoInvalidoException("Website inválido.");
        }
    }

    /**
     *
     * @param telefone especifica um novo telefone da organização
     */
    public void setTelefone(String telefone) throws ElementoInvalidoException {
        telefone = telefone.trim();
        if (Validacao.validaTelefone(telefone)) {
            this.telefone = telefone;
        } else {
            throw new ElementoInvalidoException("Telefone de organização inválido.");
        }
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.nome);
        hash = 11 * hash + Objects.hashCode(this.nif);
        hash = 11 * hash + Objects.hashCode(this.website);
        hash = 11 * hash + Objects.hashCode(this.telefone);
        hash = 11 * hash + Objects.hashCode(this.email);
        hash = 11 * hash + Objects.hashCode(this.endereco);
        hash = 11 * hash + Objects.hashCode(this.gestor);
        hash = 11 * hash + Objects.hashCode(this.listaTarefas);
        hash = 11 * hash + Objects.hashCode(this.colaboradores);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Organizacao other = (Organizacao) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.nif, other.nif)) {
            return false;
        }
        if (!Objects.equals(this.website, other.website)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.gestor, other.gestor)) {
            return false;
        }
        if (!Objects.equals(this.listaTarefas, other.listaTarefas)) {
            return false;
        }
        if (!Objects.equals(this.colaboradores, other.colaboradores)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param colaborador instância do tipo colaborador a ser adicionada à lista de colaboradores
     * @return adiciona um novo colaborador à lista de colaboradores e retorn true se foi adicionado
     *         e false se não foi adicionado
     */
    public boolean addColaborador(Colaborador colaborador) {
        if (this.colaboradores.contains(colaborador)) {
            throw new ElementoDuplicadoException("Colaborador já existe na organização.");
        }
        return this.colaboradores.add(colaborador);
    }

    /**
     *
     * @return retorna uma String com a descrição da organização (nome, nif, website, telefone,
     *         email, endereço, gestor, lista de colaboradores e lista de tarefas)
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Organizacao{nome=").append(nome);
        sb.append(", nif=").append(nif);
        sb.append(", website=").append(website);
        sb.append(", telefone=").append(telefone);
        sb.append(", email=").append(email);
        sb.append(", endereco=").append(endereco);
        sb.append(", gestor=").append(gestor);
        sb.append(", listaTarefas=").append(listaTarefas);
        sb.append(", colaboradores=").append(colaboradores);
        sb.append('}');
        return sb.toString();
    }
}
