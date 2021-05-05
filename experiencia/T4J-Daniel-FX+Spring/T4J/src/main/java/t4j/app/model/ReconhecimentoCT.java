package t4j.app.model;

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import t4j.app.exception.ElementoInvalidoException;

@Entity
@Table(name = "RECONHECIMENTOCT")
public class ReconhecimentoCT {

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
    @Column(name = "data_reconhecimento")
    private LocalDate datareconhecimento;

    /**
     *
     */
    @Column(name = "id_grau_proficiencia")
    private String idgrauproficiencia;

    /**
     *
     */
    @Column(name = "codigo_competencia_tecnica")
    private String codigocompetenciatecnica;

    /**
     *
     */
    @Column(name = "email_freelancer")
    private String emailfreelancer;

    public ReconhecimentoCT(Long id, LocalDate datareconhecimento, String idgrauproficiencia,
            String codigocompetenciatecnica, String emailfreelancer) {
        this.id = id;
        setDataReconhecimento(datareconhecimento);
        this.idgrauproficiencia = idgrauproficiencia;
        this.codigocompetenciatecnica = codigocompetenciatecnica;
        this.emailfreelancer = emailfreelancer;
    }

    /**
     *
     * @param datareconhecimento
     * @param idgrauproficiencia
     * @param codigocompetenciatecnica
     * @param emailfreelancer
     */
    public ReconhecimentoCT(LocalDate datareconhecimento, String idgrauproficiencia, String codigocompetenciatecnica, String emailfreelancer) {
        setDataReconhecimento(datareconhecimento);
        setIdGrauProficiencia(idgrauproficiencia);
        setCodigoCompetenciaTecnica(codigocompetenciatecnica);
        setEmailFreelancer(emailfreelancer);
    }

    /**
     *
     */
    public ReconhecimentoCT() {
    }

    /**
     *
     * @param outroreconhecimentoCT
     */
    public ReconhecimentoCT(ReconhecimentoCT outroreconhecimentoCT) {
        setId(outroreconhecimentoCT.id);
        setDataReconhecimento(outroreconhecimentoCT.datareconhecimento);
        setIdGrauProficiencia(outroreconhecimentoCT.idgrauproficiencia);
        setCodigoCompetenciaTecnica(outroreconhecimentoCT.codigocompetenciatecnica);
        setEmailFreelancer(outroreconhecimentoCT.emailfreelancer);
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

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @param codigocompetenciatecnica
     * @throws ElementoInvalidoException
     */
    public void setCodigoCompetenciaTecnica(String codigocompetenciatecnica) throws ElementoInvalidoException {
        this.codigocompetenciatecnica = codigocompetenciatecnica;
    }

    /**
     *
     * @param emailfreelancer
     * @throws ElementoInvalidoException
     */
    public void setEmailFreelancer(String emailfreelancer) throws ElementoInvalidoException {
        this.emailfreelancer = emailfreelancer;
    }

    /**
     *
     * @param datareconhecimento
     * @throws ElementoInvalidoException
     * @throws NullPointerException
     */
    public void setDataReconhecimento(LocalDate datareconhecimento) throws ElementoInvalidoException, NullPointerException {
        LocalDate tempodate = LocalDate.now();
        if (datareconhecimento == null) {
            throw new NullPointerException("O campo data tem de estar preenchido!");
        } else {
            if (datareconhecimento.isAfter(tempodate) || (datareconhecimento.equals(tempodate))) {
                throw new ElementoInvalidoException("A data de reconhecimento tem de ser anterior á data de hoje!");
            } else {
                this.datareconhecimento = datareconhecimento;
            }
        }
    }

    public void setIdGrauProficiencia(String idgrauproficiencia) throws ElementoInvalidoException {
        this.idgrauproficiencia = idgrauproficiencia;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ReconhecimentoCT{id=").append(id);
        sb.append(", datareconhecimento=").append(datareconhecimento);
        sb.append(", idgrauproficiencia=").append(idgrauproficiencia);
        sb.append(", codigocompetenciatecnica=").append(codigocompetenciatecnica);
        sb.append(", emailfreelancer=").append(emailfreelancer);
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
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.datareconhecimento);
        hash = 23 * hash + Objects.hashCode(this.idgrauproficiencia);
        hash = 23 * hash + Objects.hashCode(this.codigocompetenciatecnica);
        hash = 23 * hash + Objects.hashCode(this.emailfreelancer);
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
        final ReconhecimentoCT other = (ReconhecimentoCT) obj;
        if (!Objects.equals(this.idgrauproficiencia, other.idgrauproficiencia)) {
            return false;
        }
        if (!Objects.equals(this.codigocompetenciatecnica, other.codigocompetenciatecnica)) {
            return false;
        }
        if (!Objects.equals(this.emailfreelancer, other.emailfreelancer)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.datareconhecimento, other.datareconhecimento)) {
            return false;
        }
        return true;
    }
}
