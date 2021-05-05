package t4j.app.model;

import java.io.Serializable;
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

@Entity
@Table(name = "candidatura")
@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class Candidatura implements Serializable {

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     *
     */
    @Column(name = "DATACANDIDATURA")
    private LocalDate dataCandidatura;

    /**
     *
     */
    @Column(name = "VALORPRETENDIDO")
    private String valorPretendido;

    /**
     *
     */
    @Column(name = "NRDIAS")
    private String nrDias;

    /**
     *
     */
    @Column(name = "TXTAPRESENTACAO")
    private String txtApresentacao;

    /**
     *
     */
    @Column(name = "TXTMOTIVACAO")
    private String txtMotivacao;

    /**
     *
     */
    @Column(name = "REFERENCIA_ANUNCIO")
    private String refAnuncio;

    /**
     *
     */
    @Column(name = "EMAIL_FREELANCER")
    private String emailFreelancer;

    /**
     *
     */
    @Column(name = "CLASSIFICACAO_SERIACAO")
    private Integer classificacao;

    /**
     *
     */
    @Column(name = "EMAIL_COLABORADOR_CLASSIFICOU")
    private String emailColaboradorClassificou;

    /**
     *
     * @param id
     * @param dataCandidatura
     * @param valorPretendido
     * @param nrDias
     * @param txtApresentacao
     * @param txtMotivacao
     * @param refAnuncio
     * @param emailFreelancer
     * @param classificacao
     * @param emailColaboradorClassificou
     */
    public Candidatura(Long id, LocalDate dataCandidatura, String valorPretendido, String nrDias, String txtApresentacao, String txtMotivacao, String refAnuncio, String emailFreelancer, Integer classificacao, String emailColaboradorClassificou) {
        this.id = id;
        this.dataCandidatura = LocalDate.now();
        this.valorPretendido = valorPretendido;
        this.nrDias = nrDias;
        this.txtApresentacao = txtApresentacao;
        this.txtMotivacao = txtMotivacao;
        this.refAnuncio = refAnuncio;
        this.emailFreelancer = emailFreelancer;
        this.classificacao = classificacao;
        this.emailColaboradorClassificou = emailColaboradorClassificou;
    }

    /**
     *
     * @param id
     * @param dataCandidatura
     * @param valorPretendido
     * @param nrDias
     * @param txtApresentacao
     * @param txtMotivacao
     * @param refAnuncio
     * @param emailFreelancer
     */
    public Candidatura(Long id, LocalDate dataCandidatura, String valorPretendido, String nrDias, String txtApresentacao, String txtMotivacao, String refAnuncio, String emailFreelancer) {
        this.id = id;
        this.dataCandidatura = dataCandidatura;
        this.valorPretendido = valorPretendido;
        this.nrDias = nrDias;
        this.txtApresentacao = txtApresentacao;
        this.txtMotivacao = txtMotivacao;
        this.refAnuncio = refAnuncio;
        this.emailFreelancer = emailFreelancer;
    }

    /**
     *
     */
    public Candidatura() {
    }

    /**
     *
     * @param outraCandidatura
     */
    public Candidatura(Candidatura outraCandidatura) {
        setId(outraCandidatura.id);
        setDataCandidatura(outraCandidatura.dataCandidatura);
        setValorPretendido(outraCandidatura.valorPretendido);
        setNrDias(outraCandidatura.nrDias);
        setTxtApresentacao(outraCandidatura.txtApresentacao);
        setTxtMotivacao(outraCandidatura.txtMotivacao);
        setRefAnuncio(outraCandidatura.refAnuncio);
        setEmailFreelancer(outraCandidatura.emailFreelancer);
        setClassificacao(outraCandidatura.classificacao);
        setEmailColaboradorClassificou(outraCandidatura.emailColaboradorClassificou);
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
    public LocalDate getDataCandidatura() {
        return dataCandidatura;
    }

    /**
     *
     * @return
     */
    public String getValorPretendido() {
        return valorPretendido;
    }

    /**
     *
     * @return
     */
    public String getNrDias() {
        return nrDias;
    }

    /**
     *
     * @return
     */
    public String getTxtApresentacao() {
        return txtApresentacao;
    }

    /**
     *
     * @return
     */
    public String getTxtMotivacao() {
        return txtMotivacao;
    }

    /**
     *
     * @return
     */
    public String getRefAnuncio() {
        return refAnuncio;
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
     * @return
     */
    public Integer getClassificacao() {
        return classificacao;
    }

    /**
     *
     * @return
     */
    public String getEmailColaboradorClassificou() {
        return emailColaboradorClassificou;
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
     * @param dataCandidatura
     */
    public void setDataCandidatura(LocalDate dataCandidatura) {
        this.dataCandidatura = dataCandidatura;
    }

    /**
     *
     * @param valorPretendido
     */
    public void setValorPretendido(String valorPretendido) {
//        valorPretendido = valorPretendido.trim();
//        if (Validacao.validaCustoEstimadoTarefa(valorPretendido)) {
        this.valorPretendido = valorPretendido;
//        } else {
//            throw new ElementoInvalidoException("Valor pretendido inválido.");
//        }
    }

    /**
     *
     * @param nrDias
     */
    public void setNrDias(String nrDias) {
        nrDias = nrDias.trim();
        if (Validacao.validaDuracaoEstimadaTarefa(nrDias)) {
            this.nrDias = nrDias;
        } else {
            throw new ElementoInvalidoException("Duração inválida.");
        }
    }

    /**
     *
     * @param txtApresentacao
     */
    public void setTxtApresentacao(String txtApresentacao) {
        txtApresentacao = txtApresentacao.trim();
        if (Validacao.validaTextoApresentacaoCandidatura(txtApresentacao)) {
            this.txtApresentacao = txtApresentacao;
        } else {
            throw new ElementoInvalidoException("Texto de apresentação inválido (número de caractéres inferior a 256).");
        }
    }

    /**
     *
     * @param txtMotivacao
     */
    public void setTxtMotivacao(String txtMotivacao) {
        txtMotivacao = txtMotivacao.trim();
        if (Validacao.validaTextoMotivacaoCandidatura(txtMotivacao)) {
            this.txtMotivacao = txtMotivacao;
        } else {
            throw new ElementoInvalidoException("Texto de motivação inválido (número de caractéres inferior a 1024).");
        }
    }

    /**
     *
     * @param refAnuncio
     */
    public void setRefAnuncio(String refAnuncio) {
        this.refAnuncio = refAnuncio;
    }

    /**
     *
     * @param emailFreelancer
     */
    public void setEmailFreelancer(String emailFreelancer) {
        emailFreelancer = emailFreelancer.trim();
        if (Validacao.validaEmail(emailFreelancer)) {
            this.emailFreelancer = emailFreelancer;
        } else {
            throw new ElementoInvalidoException("Email de colaborador inválido.");
        }
    }

    /**
     *
     * @param classificacao
     */
    public void setClassificacao(Integer classificacao) {
        this.classificacao = classificacao;
    }

    /**
     *
     * @param emailColaboradorClassificou
     */
    public void setEmailColaboradorClassificou(String emailColaboradorClassificou) {
        this.emailColaboradorClassificou = emailColaboradorClassificou;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Candidatura{id=").append(id);
        sb.append(", dataCandidatura=").append(dataCandidatura);
        sb.append(", valorPretendido=").append(valorPretendido);
        sb.append(", nrDias=").append(nrDias);
        sb.append(", txtApresentacao=").append(txtApresentacao);
        sb.append(", txtMotivacao=").append(txtMotivacao);
        sb.append(", refAnuncio=").append(refAnuncio);
        sb.append(", emailFreelancer=").append(emailFreelancer);
        sb.append(", classificacao=").append(classificacao);
        sb.append(", emailColaboradorClassificou=").append(emailColaboradorClassificou);
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
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.dataCandidatura);
        hash = 67 * hash + Objects.hashCode(this.valorPretendido);
        hash = 67 * hash + Objects.hashCode(this.nrDias);
        hash = 67 * hash + Objects.hashCode(this.txtApresentacao);
        hash = 67 * hash + Objects.hashCode(this.txtMotivacao);
        hash = 67 * hash + Objects.hashCode(this.refAnuncio);
        hash = 67 * hash + Objects.hashCode(this.emailFreelancer);
        hash = 67 * hash + this.classificacao;
        hash = 67 * hash + Objects.hashCode(this.emailColaboradorClassificou);
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
        Candidatura outraCandidatura = (Candidatura) outroObjeto;
        return classificacao != outraCandidatura.classificacao
                && valorPretendido.equals(outraCandidatura.valorPretendido)
                && nrDias.equalsIgnoreCase(outraCandidatura.nrDias)
                && txtApresentacao.equalsIgnoreCase(outraCandidatura.txtApresentacao)
                && txtMotivacao.equalsIgnoreCase(outraCandidatura.txtMotivacao)
                && refAnuncio.equalsIgnoreCase(outraCandidatura.refAnuncio)
                && emailFreelancer.equalsIgnoreCase(outraCandidatura.emailFreelancer)
                && emailColaboradorClassificou.equalsIgnoreCase(outraCandidatura.emailColaboradorClassificou)
                && id.equals(outraCandidatura.id)
                && dataCandidatura.equals(outraCandidatura.dataCandidatura);
    }
}
