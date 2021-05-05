package t4j.app.dto;

import java.util.Objects;

public class HabilitacaoAcademicaDTO {

    /**
     *
     */
    private Long id;

    /**
     *
     */
    private String grau;

    /**
     *
     */
    private String designacaocurso;

    /**
     *
     */
    private String nomeinstituicao;

    /**
     * Variável de instância - lista de graus de proficiência
     */
    private String mediacurso;

    /**
     *
     */
    private String emailFreelancer = "";

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
        final HabilitacaoAcademicaDTO other = (HabilitacaoAcademicaDTO) obj;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.grau);
        hash = 47 * hash + Objects.hashCode(this.designacaocurso);
        hash = 47 * hash + Objects.hashCode(this.nomeinstituicao);
        hash = 47 * hash + Objects.hashCode(this.mediacurso);
        hash = 47 * hash + Objects.hashCode(this.emailFreelancer);
        return hash;
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
     * @param grau
     */
    public void setGrau(String grau) {
        this.grau = grau;
    }

    /**
     *
     * @param designacaocurso
     */
    public void setDesignacaocurso(String designacaocurso) {
        this.designacaocurso = designacaocurso;
    }

    /**
     *
     * @param nomeinstituicao
     */
    public void setNomeinstituicao(String nomeinstituicao) {
        this.nomeinstituicao = nomeinstituicao;
    }

    /**
     *
     * @param mediacurso
     */
    public void setMediacurso(String mediacurso) {
        this.mediacurso = mediacurso;
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
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HabilitacaoAcademicaDTO{id=").append(id);
        sb.append(", grau=").append(grau);
        sb.append(", designacaocurso=").append(designacaocurso);
        sb.append(", nomeinstituicao=").append(nomeinstituicao);
        sb.append(", mediacurso=").append(mediacurso);
        sb.append(", emailFreelancer=").append(emailFreelancer);
        sb.append('}');
        return sb.toString();
    }

    
}
