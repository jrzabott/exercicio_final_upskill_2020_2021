/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import t4j.app.utils.Validacao;

/**
 *
 * @author Home
 */
@Entity
@Table(name = "RECONHECIMENTOCT")
public class ReconhecimentoCT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(name = "data_reconhecimento")
    private LocalDate datareconhecimento;

    @Column(name = "id_grau_proficiencia")
    private String idgrauproficiencia;

    @Column(name = "codigo_competencia_tecnica")
    private String codigocompetenciatecnica;

    @Column(name = "email_freelancer")
    private String emailfreelancer;

    public ReconhecimentoCT(LocalDate datareconhecimento,
            String idgrauproficiencia, String codigocompetenciatecnica, String emailfreelancer) {
        setDataReconhecimento(datareconhecimento);
        setIdGrauProficiencia(idgrauproficiencia);
        setCodigoCompetenciaTecnica(codigocompetenciatecnica);
        setEmailFreelancer(emailfreelancer);

    }

    public ReconhecimentoCT() {

    }

    public ReconhecimentoCT(ReconhecimentoCT outroreconhecimentoCT) {
        setDataReconhecimento(outroreconhecimentoCT.datareconhecimento);
        setIdGrauProficiencia(outroreconhecimentoCT.idgrauproficiencia);
        setCodigoCompetenciaTecnica(outroreconhecimentoCT.codigocompetenciatecnica);
        setEmailFreelancer(outroreconhecimentoCT.emailfreelancer);

    }

    public Long getId() {
        return id;
    }

    public LocalDate getDatareconhecimento() {
        return datareconhecimento;
    }

    public String getIdgrauproficiencia() {
        return idgrauproficiencia;
    }

    public String getCodigocompetenciatecnica() {
        return codigocompetenciatecnica;
    }

    public String getEmailfreelancer() {
        return emailfreelancer;
    }

    public void setCodigoCompetenciaTecnica(String codigocompetenciatecnica) throws
            ElementoInvalidoException {
        codigocompetenciatecnica = codigocompetenciatecnica.trim();
        if (Validacao.validaGrau(codigocompetenciatecnica)) {
            this.codigocompetenciatecnica = codigocompetenciatecnica;
        } else {
            throw new ElementoInvalidoException("Grau inválido.");
        }
    }

    public void setEmailFreelancer(String emailfreelancer) throws
            ElementoInvalidoException {
        emailfreelancer = emailfreelancer.trim();
        if (Validacao.validaDescricaoBreveCompetenciaTecnica(emailfreelancer)) {
            this.emailfreelancer= emailfreelancer;
        } else {
            throw new ElementoInvalidoException("Email Inválido!");
        }

    }

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
        idgrauproficiencia = idgrauproficiencia.trim();
        if (Validacao.validaDescricaoDetalhadaCompetenciaTecnica(
                idgrauproficiencia)) {
            this.idgrauproficiencia = idgrauproficiencia;
        } else {
            throw new ElementoInvalidoException("Grau de Proficiencia Inválido!.");
        }
    }

    @Override
    public String toString() {
        return "ReconhecimentoCT{" + "id=" + id + ", datareconhecimento=" + datareconhecimento + ", idgrauproficiencia=" + idgrauproficiencia + ", codigocompetenciatecnica=" + codigocompetenciatecnica + ", emailfreelancer=" + emailfreelancer + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + Objects.hashCode(this.datareconhecimento);
        hash = 13 * hash + Objects.hashCode(this.idgrauproficiencia);
        hash = 13 * hash + Objects.hashCode(this.codigocompetenciatecnica);
        hash = 13 * hash + Objects.hashCode(this.emailfreelancer);
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

    public void setId(Long id) {
        this.id = id;
    }

}
