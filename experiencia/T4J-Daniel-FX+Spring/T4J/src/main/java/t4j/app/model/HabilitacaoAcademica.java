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

@Entity
@Table(name = "HABILITACAOACADEMICA")
public class HabilitacaoAcademica implements Serializable {

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    /**
     *
     */
    @Column(name = "grau")
    private String grau;

    /**
     *
     */
    @Column(name = "designacaocurso")
    private String designacaocurso;

    /**
     *
     */
    @Column(name = "nomeinstituicao")
    private String nomeinstituicao;

    /**
     *
     */
    @Column(name = "mediacurso")
    private String mediacurso;

    /**
     *
     */
    @Column(name = "email_freelancer")
    private String emailFreelancer;

    /**
     *
     * @param grau
     * @param designacaocurso
     * @param nomeinstituicao
     * @param mediacurso
     * @param email
     */
    public HabilitacaoAcademica(String grau, String designacaocurso, String nomeinstituicao, String mediacurso, String emailFreelancer) {
        this.id = id;
        setGrau(grau);
        setDesignacaoCurso(designacaocurso);
        setNomeInstituicao(nomeinstituicao);
        setMediaCurso(mediacurso);
        this.emailFreelancer = emailFreelancer;
    }

    /**
     * 
     * @param id
     * @param grau
     * @param designacaocurso
     * @param nomeinstituicao
     * @param mediacurso
     * @param emailFreelancer 
     */
    public HabilitacaoAcademica(Long id, String grau, String designacaocurso, String nomeinstituicao, String mediacurso, String emailFreelancer) {
        this.id = id;
        setGrau(grau);
        setDesignacaoCurso(designacaocurso);
        setNomeInstituicao(nomeinstituicao);
        setMediaCurso(mediacurso);
        this.emailFreelancer = emailFreelancer;
    }

    /**
     *
     */
    public HabilitacaoAcademica() {
    }

    /**
     *
     * @param outraHabilitacaoAcademica
     */
    public HabilitacaoAcademica(HabilitacaoAcademica outraHabilitacaoAcademica) {
        setId(outraHabilitacaoAcademica.id);
        setGrau(outraHabilitacaoAcademica.grau);
        setDesignacaoCurso(outraHabilitacaoAcademica.designacaocurso);
        setNomeInstituicao(outraHabilitacaoAcademica.nomeinstituicao);
        setMediaCurso(outraHabilitacaoAcademica.mediacurso);
        setEmailFreelancer(outraHabilitacaoAcademica.emailFreelancer);
    }

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @return
     */
    public String getGrau() {
        return grau;
    }

    /**
     *
     * @return
     */
    public String getDesignacaocurso() {
        return designacaocurso;
    }

    /**
     *
     * @return
     */
    public String getNomeinstituicao() {
        return nomeinstituicao;
    }

    /**
     *
     * @return
     */
    public String getMediacurso() {
        return mediacurso;
    }

    /**
     *
     * @return
     */
    public String getEmailFreelancer() {
        return emailFreelancer;
    }

    /**
     *
     * @param grau
     * @throws ElementoInvalidoException
     */
    public void setGrau(String grau) throws ElementoInvalidoException {
        grau = grau.trim();
        if (Validacao.validaGrau(grau)) {
            this.grau = grau;
        } else {
            throw new ElementoInvalidoException("Grau inválido.");
        }
    }

    /**
     *
     * @param designacaocurso
     * @throws ElementoInvalidoException
     */
    public void setDesignacaoCurso(String designacaocurso) throws ElementoInvalidoException {
        designacaocurso = designacaocurso.trim();
        if (Validacao.validaDescricaoBreveCompetenciaTecnica(designacaocurso)) {
            this.designacaocurso = designacaocurso;
        } else {
            throw new ElementoInvalidoException("Designação de Curso inválida.");
        }
    }

    /**
     *
     * @param nomeinstituicao
     * @throws ElementoInvalidoException
     */
    public void setNomeInstituicao(String nomeinstituicao) throws ElementoInvalidoException {
        nomeinstituicao = nomeinstituicao.trim();
        if (Validacao.validaDescricaoDetalhadaCompetenciaTecnica(
                nomeinstituicao)) {
            this.nomeinstituicao = nomeinstituicao;
        } else {
            throw new ElementoInvalidoException("Nome de instituição inválido.");
        }
    }

    /**
     *
     * @param mediacurso
     * @throws ElementoInvalidoException
     */
    public void setMediaCurso(String mediacurso) throws ElementoInvalidoException {
        int media = Integer.parseInt(mediacurso);
        if (media >= 10 && media <= 20) {
            this.mediacurso = String.valueOf(media);
        } else {
            throw new ElementoInvalidoException("Média Inválida");
        }
    }

    /**
     *
     * @param emailFreelancer
     */
    public void setEmailFreelancer(String emailFreelancer) {
        this.emailFreelancer = emailFreelancer;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HabilitacaoAcademica{id=").append(id);
        sb.append(", grau=").append(grau);
        sb.append(", designacaocurso=").append(designacaocurso);
        sb.append(", nomeinstituicao=").append(nomeinstituicao);
        sb.append(", mediacurso=").append(mediacurso);
        sb.append(", emailFreelancer=").append(emailFreelancer);
        sb.append('}');
        return sb.toString();
    }

    /**
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.grau);
        hash = 79 * hash + Objects.hashCode(this.designacaocurso);
        hash = 79 * hash + Objects.hashCode(this.nomeinstituicao);
        hash = 79 * hash + Objects.hashCode(this.mediacurso);
        hash = 79 * hash + Objects.hashCode(this.emailFreelancer);
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
        if (!Objects.equals(this.emailFreelancer, other.emailFreelancer)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
