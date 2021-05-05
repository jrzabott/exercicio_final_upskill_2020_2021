/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import t4j.app.exception.ElementoInvalidoException;
import t4j.app.utils.Validacao;

/**
 *
 * @author Home
 */
@Entity
@Table(name = "freelancer")
public class FreeLancer implements Serializable {

    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "nome")
    private String nome;

    @Column(name = "nif")
    private String nif;

    @Column(name = "telefone")
    private String telefone;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco", foreignKey = @ForeignKey(name
            = "FK_FREELANCER_ENDERECO"))
    private EnderecoPostal endereco;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id", foreignKey = @ForeignKey(name = "FK_HABITACAOACADEMICA_FREELANCER"))
    @Transient
    private List<HabilitacaoAcademica> habilitacoes;

    @Transient
    public List<ReconhecimentoCT> reconhecimentos;

    public FreeLancer(String email, String nome, String nif, String telefone, EnderecoPostal endereco) {
        setEmail(email);
        setNome(nome);
        setNif(nif);
        setTelefone(telefone);
        setEndereco(endereco);
        setHabilitacoes(habilitacoes);

    }

    public FreeLancer() {
        this.endereco = new EnderecoPostal();
        this.habilitacoes = new ArrayList<HabilitacaoAcademica>();
    }

    public FreeLancer(FreeLancer outroFreeLancer) {
        setEmail(outroFreeLancer.email);
        setNome(outroFreeLancer.nome);
        setNif(outroFreeLancer.nif);
        setTelefone(outroFreeLancer.telefone);
        setEndereco(outroFreeLancer.endereco);
        setHabilitacoes(outroFreeLancer.habilitacoes);
    }

    public EnderecoPostal getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getNif() {
        return nif;
    }

    public String getTelefone() {
        return telefone;
    }

    public List<HabilitacaoAcademica> getHabilitacoes() {
        return habilitacoes;
    }

    public List<ReconhecimentoCT> getReconhecimentos() {
        return reconhecimentos;
    }
    
    public void setHabilitacoes(List<HabilitacaoAcademica> habilitacoes) {
        this.habilitacoes = habilitacoes;
    }

    public void setReconhecimentos(List<ReconhecimentoCT> reconhecimentos) {
        this.reconhecimentos = reconhecimentos;
    }

    public void setEndereco(EnderecoPostal endereco) {
        this.endereco = endereco;
    }

    public void setEmail(String email) throws ElementoInvalidoException {
        email = email.trim();
        if (Validacao.validaEmail(email)) {
            this.email = email;
        } else {
            throw new ElementoInvalidoException("Email de colaborador inválido.");
        }
    }

    public void setNome(String nome) throws ElementoInvalidoException {
        nome = nome.trim();
        if (Validacao.validaNomeColaborador(nome)) {
            this.nome = nome;
        } else {
            throw new ElementoInvalidoException("Nome de colaborador inválido.");
        }
    }

    public void setNif(String nif) throws ElementoInvalidoException {
        nif = nif.trim();
        if (Validacao.validaNif(nif)) {
            this.nif = nif;
        } else {
            throw new ElementoInvalidoException(
                    "NIF inválido. Introduza NIF com 9 dígitos.");
        }
    }

    public void setTelefone(String telefone) throws ElementoInvalidoException {
        telefone = telefone.trim();
        if (Validacao.validaTelefone(telefone)) {
            this.telefone = telefone;
        } else {
            throw new ElementoInvalidoException("Telefone de colaborador inválido.");
        }
    }

    @Override
    public String toString() {
        return String.format(
                "Freelancer:%n email = %s%n nome = %s%n telefone = %s%n e-Mail = %s%n Nif: %s%n id_Endereco: %s Habilitacoes: %s",
                getNome(),
                getTelefone(),
                getEmail(),
                getNif(),
                getEndereco(),
                getHabilitacoes());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.email);
        hash = 83 * hash + Objects.hashCode(this.nome);
        hash = 83 * hash + Objects.hashCode(this.nif);
        hash = 83 * hash + Objects.hashCode(this.telefone);
        hash = 83 * hash + Objects.hashCode(this.endereco);
        hash = 83 * hash + Objects.hashCode(this.habilitacoes);
        return hash;
    }

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
        final FreeLancer other = (FreeLancer) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.nif, other.nif)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.habilitacoes, other.habilitacoes)) {
            return false;
        }
        return true;
    }

}
