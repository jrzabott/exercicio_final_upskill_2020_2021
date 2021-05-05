package t4j.app.dto;

import java.time.LocalDate;
import java.util.Objects;

public class ReconhecimentoCTDTO {

    /**
     *
     */
    private String id;

    /**
     *
     */
    private LocalDate datareconhecimento;

    /**
     *
     */
    private String idgrauproficiencia;

    /**
     *
     */
    private String descricaoGrauProficiencia;

    /**
     *
     */
    private String codigocompetenciatecnica;

    /**
     *
     */
    private String emailfreelancer;

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
        final ReconhecimentoCTDTO other = (ReconhecimentoCTDTO) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.idgrauproficiencia, other.idgrauproficiencia)) {
            return false;
        }
        if (!Objects.equals(this.descricaoGrauProficiencia, other.descricaoGrauProficiencia)) {
            return false;
        }
        if (!Objects.equals(this.codigocompetenciatecnica, other.codigocompetenciatecnica)) {
            return false;
        }
        if (!Objects.equals(this.emailfreelancer, other.emailfreelancer)) {
            return false;
        }
        if (!Objects.equals(this.datareconhecimento, other.datareconhecimento)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @return
     */
    public LocalDate getDatareconhecimento() {
        return datareconhecimento;
    }

    /**
     *
     * @return
     */
    public String getIdgrauproficiencia() {
        return idgrauproficiencia;
    }

    /**
     *
     * @return
     */
    public String getCodigocompetenciatecnica() {
        return codigocompetenciatecnica;
    }

    /**
     *
     * @return
     */
    public String getEmailfreelancer() {
        return emailfreelancer;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.datareconhecimento);
        hash = 59 * hash + Objects.hashCode(this.idgrauproficiencia);
        hash = 59 * hash + Objects.hashCode(this.descricaoGrauProficiencia);
        hash = 59 * hash + Objects.hashCode(this.codigocompetenciatecnica);
        hash = 59 * hash + Objects.hashCode(this.emailfreelancer);
        return hash;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @param datareconhecimento
     */
    public void setDatareconhecimento(LocalDate datareconhecimento) {
        this.datareconhecimento = datareconhecimento;
    }

    /**
     *
     * @param idgrauproficiencia
     */
    public void setIdgrauproficiencia(String idgrauproficiencia) {
        this.idgrauproficiencia = idgrauproficiencia;
    }

    /**
     *
     * @param codigocompetenciatecnica
     */
    public void setCodigocompetenciatecnica(String codigocompetenciatecnica) {
        this.codigocompetenciatecnica = codigocompetenciatecnica;
    }

    /**
     *
     * @param emailfreelancer
     */
    public void setEmailfreelancer(String emailfreelancer) {
        this.emailfreelancer = emailfreelancer;
    }

    /**
     *
     * @return
     */
    public String getDescricaoGrauProficiencia() {
        return descricaoGrauProficiencia;
    }

    /**
     *
     * @param descricaoGrauProficiencia
     */
    public void setDescricaoGrauProficiencia(String descricaoGrauProficiencia) {
        this.descricaoGrauProficiencia = descricaoGrauProficiencia;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ReconhecimentoCTDTO{id=").append(id);
        sb.append(", datareconhecimento=").append(datareconhecimento);
        sb.append(", idgrauproficiencia=").append(idgrauproficiencia);
        sb.append(", descricaoGrauProficiencia=").append(descricaoGrauProficiencia);
        sb.append(", codigocompetenciatecnica=").append(codigocompetenciatecnica);
        sb.append(", emailfreelancer=").append(emailfreelancer);
        sb.append('}');
        return sb.toString();
    }
}
