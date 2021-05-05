/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import t4j.app.exception.ElementoInvalidoException;
import t4j.app.utils.Validacao;

/**
 *
 * @author Home
 */
@Entity
@Table(name = "HABILITACAOACADEMICA")
public class HabilitacaoAcademica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(name = "grau")
    private String grau;

    @Column(name = "designacaocurso")
    private String designacaocurso;

    @Column(name = "nomeinstituicao")
    private String nomeinstituicao;

    @Column(name = "mediacurso")
    private String mediacurso;

    @Column(name = "email_freelancer")
    private String emailFreelancer;

    public HabilitacaoAcademica(String grau,
            String designacaocurso, String nomeinstituicao, String mediacurso,
            FreeLancer email) {
        setGrau(grau);
        setDesignacaoCurso(designacaocurso);
        setNomeInstituicao(nomeinstituicao);
        setMediaCurso(mediacurso);

    }

    public HabilitacaoAcademica() {

    }

    public HabilitacaoAcademica(HabilitacaoAcademica outraHabilitacaoAcademica) {
        setGrau(outraHabilitacaoAcademica.grau);
        setDesignacaoCurso(outraHabilitacaoAcademica.designacaocurso);
        setNomeInstituicao(outraHabilitacaoAcademica.nomeinstituicao);
        setMediaCurso(outraHabilitacaoAcademica.mediacurso);

    }

    public Long getId() {
        return id;
    }

    public String getGrau() {
        return grau;
    }

    public String getDesignacaocurso() {
        return designacaocurso;
    }

    public String getNomeinstituicao() {
        return nomeinstituicao;
    }

    public String getMediacurso() {
        return mediacurso;
    }

    public void setGrau(String grau) throws
            ElementoInvalidoException {
        grau = grau.trim();
        if (Validacao.validaGrau(grau)) {
            this.grau = grau;
        } else {
            throw new ElementoInvalidoException("Grau inválido.");
        }
    }

    public void setDesignacaoCurso(String designacaocurso) throws
            ElementoInvalidoException {
        designacaocurso = designacaocurso.trim();
        if (Validacao.validaDescricaoBreveCompetenciaTecnica(designacaocurso)) {
            this.designacaocurso = designacaocurso;
        } else {
            throw new ElementoInvalidoException("Designação de Curso inválida.");
        }

    }

    public void setNomeInstituicao(String nomeinstituicao) throws ElementoInvalidoException {
        nomeinstituicao = nomeinstituicao.trim();
        if (Validacao.validaDescricaoDetalhadaCompetenciaTecnica(
                nomeinstituicao)) {
            this.nomeinstituicao = nomeinstituicao;
        } else {
            throw new ElementoInvalidoException("Descrição detalhada inválida.");
        }
    }

    public void setMediaCurso(String mediacurso) throws ElementoInvalidoException {
        int media = Integer.parseInt(mediacurso);
        if (media >= 10 || media <= 20) {
            this.mediacurso = String.valueOf(media);
        } else {
            throw new ElementoInvalidoException("Média Inválida");
        }
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "HabilitacaoAcademica{" + "id=" + id + ", grau=" + grau + ", designacaocurso="
                + designacaocurso + ", nomeinstituicao=" + nomeinstituicao + ", mediacurso=" + mediacurso + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.grau);
        hash = 97 * hash + Objects.hashCode(this.designacaocurso);
        hash = 97 * hash + Objects.hashCode(this.nomeinstituicao);
        hash = 97 * hash + Objects.hashCode(this.mediacurso);
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
        final HabilitacaoAcademica other = (HabilitacaoAcademica) obj;
        if (!Objects.equals(this.grau, other.grau)) {
            return false;
        }
        if (!Objects.equals(this.designacaocurso, other.designacaocurso)) {
            return false;
        }
        if (!Objects.equals(this.nomeinstituicao, other.nomeinstituicao)) {
            return false;
        }
        if (!Objects.equals(this.mediacurso, other.mediacurso)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }

        return true;
    }

    public String getEmailFreelancer() {
        return emailFreelancer;
    }

    public void setEmailFreelancer(String emailFreelancer) {
        this.emailFreelancer = emailFreelancer;
    }

}
