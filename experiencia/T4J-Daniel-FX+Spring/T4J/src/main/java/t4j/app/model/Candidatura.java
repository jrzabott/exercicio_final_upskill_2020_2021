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
        this.dataCandidatura = dataCandidatura;
        setValorPretendido(valorPretendido);
        setNrDias(nrDias);
        setTxtApresentacao(txtApresentacao);
        setTxtMotivacao(txtMotivacao);
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
        setValorPretendido(valorPretendido);
        setNrDias(nrDias);
        setTxtApresentacao(txtApresentacao);
        setTxtMotivacao(txtMotivacao);
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
        if (ValidaCandidatura.validaValorPretendido(valorPretendido)) {
            this.valorPretendido = valorPretendido;
        }
    }

    /**
     *
     * @param nrDias
     */
    public void setNrDias(String nrDias) {
        if (ValidaCandidatura.validaNrDias(nrDias)) {
            this.nrDias = nrDias;
        }
    }

    /**
     *
     * @param txtApresentacao
     */
    public void setTxtApresentacao(String txtApresentacao) {
        if (ValidaCandidatura.validaTxtApresentacao(txtApresentacao)) {
            this.txtApresentacao = txtApresentacao;
        }
    }

    /**
     *
     * @param txtMotivacao
     */
    public void setTxtMotivacao(String txtMotivacao) {
        if (ValidaCandidatura.validaTxtMotivacao(txtMotivacao)) {
            this.txtMotivacao = txtMotivacao;
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
        this.emailFreelancer = emailFreelancer;
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
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.dataCandidatura);
        hash = 89 * hash + Objects.hashCode(this.valorPretendido);
        hash = 89 * hash + Objects.hashCode(this.nrDias);
        hash = 89 * hash + Objects.hashCode(this.txtApresentacao);
        hash = 89 * hash + Objects.hashCode(this.txtMotivacao);
        hash = 89 * hash + Objects.hashCode(this.refAnuncio);
        hash = 89 * hash + Objects.hashCode(this.emailFreelancer);
        hash = 89 * hash + Objects.hashCode(this.classificacao);
        hash = 89 * hash + Objects.hashCode(this.emailColaboradorClassificou);
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
        final Candidatura other = (Candidatura) obj;
        if (!Objects.equals(this.valorPretendido, other.valorPretendido)) {
            return false;
        }
        if (!Objects.equals(this.nrDias, other.nrDias)) {
            return false;
        }
        if (!Objects.equals(this.txtApresentacao, other.txtApresentacao)) {
            return false;
        }
        if (!Objects.equals(this.txtMotivacao, other.txtMotivacao)) {
            return false;
        }
        if (!Objects.equals(this.refAnuncio, other.refAnuncio)) {
            return false;
        }
        if (!Objects.equals(this.emailFreelancer, other.emailFreelancer)) {
            return false;
        }
        if (!Objects.equals(this.emailColaboradorClassificou, other.emailColaboradorClassificou)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dataCandidatura, other.dataCandidatura)) {
            return false;
        }
        if (!Objects.equals(this.classificacao, other.classificacao)) {
            return false;
        }
        return true;
    }
    
    protected static class ValidaCandidatura {

        private static final int VALORPRETENDIDO_LENGTH = 16;
        private static final String VALORPRETENDIDO_REGEX = "[0-9,]+";
        private static final int NRDIAS_LENGTH = 6;
        private static final String NRDIAS_REGEX = "[0-9]+";
        private static final int TXTAPRESENTACAO_LENGTH = 1024;
        private static final int TXTMOTIVACAO_LENGTH = 1024;
        
        protected static final String VALORPRETENDIDO_EMPTY_EXCEPTION = "Valor Pretendido deve ser preenchido.";
        protected static final String VALORPRETENDIDO_MAX_SIZE_EXCEPTION = String.format("Valor Pretendido deve ter no máximo %d caracteres.", VALORPRETENDIDO_LENGTH);
        protected static final String VALORPRETENDIDO_NULL_EXCEPTION = "Valor Pretendido não pode ser null.";
        protected static final String VALORPRETENDIDO_REGEX_EXCEPTION = "Valor Pretendido pode conter apenas números e separador decimal.";
        protected static final String NRDIAS_EMPTY_EXCEPTION = "Duração deve ser preenchida.";
        protected static final String NRDIAS_MAX_SIZE_EXCEPTION = String.format("Duração deve ter no máximo %d caracteres.", NRDIAS_LENGTH);
        protected static final String NRDIAS_NULL_EXCEPTION = "Duração não pode ser null.";
        protected static final String NRDIAS_REGEX_EXCEPTION = "Duração pode conter apenas números.";
        protected static final String TXTAPRESENTACAO_EMPTY_EXCEPTION = "Texto de apresentação deve ser preenchido.";
        protected static final String TXTAPRESENTACAO_MAX_SIZE_EXCEPTION = String.format("Texto de apresentação deve ter no máximo %d caracteres.", TXTAPRESENTACAO_LENGTH);
        protected static final String TXTAPRESENTACAO_NULL_EXCEPTION = "Texto de apresentação não pode ser null.";
        protected static final String TXTMOTIVACAO_EMPTY_EXCEPTION = "Texto de apresentação deve ser preenchido.";
        protected static final String TXTMOTIVACAO_MAX_SIZE_EXCEPTION = String.format("Texto de motivação deve ter no máximo %d caracteres.", TXTMOTIVACAO_LENGTH);
        protected static final String TXTMOTIVACAO_NULL_EXCEPTION = "Texto de motivação não pode ser null.";

        protected static boolean validaValorPretendido(String valorPretendido) {
            boolean isNull = false;
            boolean isEmpty = false;
            boolean isGreaterThanMaxLength = false;
            boolean isRegexInvalid = false;

            isNull = valorPretendido == null;
            if (isNull) {
                throw new ElementoInvalidoException(VALORPRETENDIDO_NULL_EXCEPTION);
            }
            
            isEmpty = valorPretendido.trim().isEmpty();
            if (isEmpty) {
                throw new ElementoInvalidoException(VALORPRETENDIDO_EMPTY_EXCEPTION);
            }
            
            isGreaterThanMaxLength = valorPretendido.length() > VALORPRETENDIDO_LENGTH;
            if (isGreaterThanMaxLength) {
                throw new ElementoInvalidoException(VALORPRETENDIDO_MAX_SIZE_EXCEPTION);
            }
            
            isRegexInvalid = !valorPretendido.matches(VALORPRETENDIDO_REGEX);
            if (isRegexInvalid) {
                throw new ElementoInvalidoException(VALORPRETENDIDO_REGEX_EXCEPTION);
            }
            
            return true;
        }
        
        protected static boolean validaNrDias(String nrDias) {
            boolean isNull = false;
            boolean isEmpty = false;
            boolean isGreaterThanMaxLength = false;
            boolean isRegexInvalid = false;

            isNull = nrDias == null;
            if (isNull) {
                throw new ElementoInvalidoException(NRDIAS_NULL_EXCEPTION);
            }
            
            isEmpty = nrDias.trim().isEmpty();
            if (isEmpty) {
                throw new ElementoInvalidoException(NRDIAS_EMPTY_EXCEPTION);
            }
            
            isGreaterThanMaxLength = nrDias.length() > NRDIAS_LENGTH;
            if (isGreaterThanMaxLength) {
                throw new ElementoInvalidoException(NRDIAS_MAX_SIZE_EXCEPTION);
            }
            
            isRegexInvalid = !nrDias.matches(NRDIAS_REGEX);
            if (isRegexInvalid) {
                throw new ElementoInvalidoException(NRDIAS_REGEX_EXCEPTION);
            }
            
            return true;
        }
        
        protected static boolean validaTxtApresentacao(String txtApresentacao) {
            boolean isNull = false;
            boolean isEmpty = false;
            boolean isGreaterThanMaxLength = false;

            isNull = txtApresentacao == null;
            if (isNull) {
                throw new ElementoInvalidoException(TXTAPRESENTACAO_NULL_EXCEPTION);
            }
            
            isEmpty = txtApresentacao.trim().isEmpty();
            if (isEmpty) {
                throw new ElementoInvalidoException(TXTAPRESENTACAO_EMPTY_EXCEPTION);
            }
            
            isGreaterThanMaxLength = txtApresentacao.length() > TXTAPRESENTACAO_LENGTH;
            if (isGreaterThanMaxLength) {
                throw new ElementoInvalidoException(TXTAPRESENTACAO_MAX_SIZE_EXCEPTION);
            }
            
            return true;
        }
        
        protected static boolean validaTxtMotivacao(String txtMotivacao) {
            boolean isNull = false;
            boolean isEmpty = false;
            boolean isGreaterThanMaxLength = false;

            isNull = txtMotivacao == null;
            if (isNull) {
                throw new ElementoInvalidoException(TXTMOTIVACAO_NULL_EXCEPTION);
            }
            
            isEmpty = txtMotivacao.trim().isEmpty();
            if (isEmpty) {
                throw new ElementoInvalidoException(TXTMOTIVACAO_EMPTY_EXCEPTION);
            }
            
            isGreaterThanMaxLength = txtMotivacao.length() > TXTMOTIVACAO_LENGTH;
            if (isGreaterThanMaxLength) {
                throw new ElementoInvalidoException(TXTMOTIVACAO_MAX_SIZE_EXCEPTION);
            }
            
            return true;  
        }
        
    }
}
