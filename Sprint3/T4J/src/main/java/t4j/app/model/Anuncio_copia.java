package t4j.app.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import t4j.app.exception.ElementoInvalidoException;
import t4j.app.utils.Validacao;

@Entity
@Table(name = "anuncio")
@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class Anuncio_copia implements Serializable {

    /**
     * Variável de instância - referência do anúncio (será igual à referência da tarefa à qual se refere o anúncio)
     */
    @Id
    @Column(name = "referencia_tarefa")
    private String referencia;

    /**
     * Variável de instância - data de registo do anúncio
     */
    @Column(name = "dataregistoanuncio")
    private LocalDate dataRegistoAnuncio;

    /**
     * Variável de instância - data de início de publicitação do anúncio
     */
    @Column(name = "datainiciopublicacao")
    private LocalDate dataInicioPublicitacao;

    /**
     * Variável de instância - data de fim de publicitação do anúncio
     */
    @Column(name = "datafimpublicacao")
    private LocalDate dataFimPublicitacao;

    /**
     * Variável de instância - data de início de candidatura ao anúncio
     */
    @Column(name = "datainiciocandidatura")
    private LocalDate dataInicioCandidatura;

    /**
     * Variável de instância - data de fim de candidatura ao anúncio
     */
    @Column(name = "datafimcandidatura")
    private LocalDate dataFimCandidatura;

    /**
     * Variável de instância - data de início de seriação das candidaturas
     */
    @Column(name = "datainicioseriacao")
    private LocalDate dataInicioSeriacao;

    /**
     * Variável de instância - data de fim de seriação das candidaturas
     */
    @Column(name = "datafimseriacao")
    private LocalDate dataFimSeriacao;

    /**
     * Variável de instância - id do tipo de regimento pelo qual se rege o anúncio
     */
    @Column(name = "id_tipo_regimento")
    private Long idTipoRegimento;

    /**
     * Construtor completo de anúncio
     *
     * @param referencia referência do anúncio
     * @param dataInicioPublicitacao data de início de publicitação do anúncio
     * @param dataFimPublicitacao data de fim de publicitação do anúncio
     * @param dataInicioCandidatura data de início de candidatura ao anúncio
     * @param dataFimCandidatura data de fim de candidatura ao anúncio
     * @param dataInicioSeriacao data de início de seriação das candidaturas
     * @param dataFimSeriacao data de fim de seriação das candidaturas
     * @param idTipoRegimento id do tipo de regimento pelo qual se rege o anúncio
     */
    public Anuncio_copia(String referencia, LocalDate dataInicioPublicitacao, LocalDate dataFimPublicitacao,
            LocalDate dataInicioCandidatura, LocalDate dataFimCandidatura, LocalDate dataInicioSeriacao,
            LocalDate dataFimSeriacao, Long idTipoRegimento) {
        setReferencia(referencia);
        this.dataRegistoAnuncio = LocalDate.now();
        this.dataInicioPublicitacao = dataInicioPublicitacao;
        this.dataFimPublicitacao = dataFimPublicitacao;
        this.dataInicioCandidatura = dataInicioCandidatura;
        this.dataFimCandidatura = dataFimCandidatura;
        this.dataInicioSeriacao = dataInicioSeriacao;
        this.dataFimSeriacao = dataFimSeriacao;
        this.idTipoRegimento = idTipoRegimento;
    }

    /**
     * Construtor vazio de anúncio
     */
    public Anuncio_copia() {
    }

    /**
     * Construtor cópia de anúncio
     *
     * @param outroAnuncio instância de anúncio a ser copiada
     */
    public Anuncio_copia(Anuncio_copia outroAnuncio) {
        setReferencia(outroAnuncio.referencia);
        setDataRegistoAnuncio(outroAnuncio.dataRegistoAnuncio);
        setDataInicioPublicitacao(outroAnuncio.dataInicioPublicitacao);
        setDataFimPublicitacao(outroAnuncio.dataFimPublicitacao);
        setDataInicioCandidatura(outroAnuncio.dataInicioCandidatura);
        setDataFimCandidatura(outroAnuncio.dataFimCandidatura);
        setDataInicioSeriacao(outroAnuncio.dataInicioSeriacao);
        setDataFimSeriacao(outroAnuncio.dataFimSeriacao);
        setIdTipoRegimento(outroAnuncio.idTipoRegimento);
    }

    /**
     *
     * @return referência do anúncio
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     *
     * @return data de registo do anúncio
     */
    public LocalDate getDataRegistoAnuncio() {
        return dataRegistoAnuncio;
    }

    /**
     *
     * @return data de início de publicitação do anúncio
     */
    public LocalDate getDataInicioPublicitacao() {
        return dataInicioPublicitacao;
    }

    /**
     *
     * @return data de fim de publicitação do anúncio
     */
    public LocalDate getDataFimPublicitacao() {
        return dataFimPublicitacao;
    }

    /**
     *
     * @return data de início de candidatura ao anúncio
     */
    public LocalDate getDataInicioCandidatura() {
        return dataInicioCandidatura;
    }

    /**
     *
     * @return data de fim de candidatura ao anúncio
     */
    public LocalDate getDataFimCandidatura() {
        return dataFimCandidatura;
    }

    /**
     *
     * @return data de início de seriação das candidaturas
     */
    public LocalDate getDataInicioSeriacao() {
        return dataInicioSeriacao;
    }

    /**
     *
     * @return data de fim de seriação das candidaturas
     */
    public LocalDate getDataFimSeriacao() {
        return dataFimSeriacao;
    }

    /**
     *
     * @return id do tipo de regimento pelo qual se rege o anúncio
     */
    public Long getIdTipoRegimento() {
        return idTipoRegimento;
    }

    /**
     *
     * @param referencia especifica uma nova referência do anúncio
     * @throws ElementoInvalidoException
     */
    public void setReferencia(String referencia) throws ElementoInvalidoException {
        referencia = referencia.trim();
        if (Validacao.validaReferenciaAnuncio(referencia)) {
            this.referencia = referencia;
        } else {
            throw new ElementoInvalidoException("Referência inválida.");
        }
    }

    /**
     *
     * @param dataRegistoAnuncio especifica uma nova data de registo do anúncio
     */
    public void setDataRegistoAnuncio(LocalDate dataRegistoAnuncio) {
        this.dataRegistoAnuncio = dataRegistoAnuncio;
    }

    /**
     *
     * @param dataInicioPublicitacao especifica uma nova data de início de publicitação
     * @throws ElementoInvalidoException
     * @throws NullPointerException
     */
    public void setDataInicioPublicitacao(LocalDate dataInicioPublicitacao) throws ElementoInvalidoException, NullPointerException {
        if (dataInicioPublicitacao.isEqual(dataRegistoAnuncio)
                || dataInicioPublicitacao.isAfter(dataRegistoAnuncio)) {
            this.dataInicioPublicitacao = dataInicioPublicitacao;
        } else {
            throw new ElementoInvalidoException("A data de início de publicitação tem de ser igual ou posterior à data de hoje!");
        }
    }

    /**
     *
     * @param dataFimPublicitacao especifica uma nova data de fim de publicitação
     * @throws ElementoInvalidoException
     * @throws NullPointerException
     */
    public void setDataFimPublicitacao(LocalDate dataFimPublicitacao) throws ElementoInvalidoException, NullPointerException {
        if (dataFimPublicitacao.isAfter(dataInicioPublicitacao)) {
            this.dataFimPublicitacao = dataFimPublicitacao;
        } else {
            throw new ElementoInvalidoException("A data de fim de publicitação tem de ser posterior à data de início de publicitação!");
        }
    }

    /**
     *
     * @param dataInicioCandidatura especifica uma nova data de início de candidatura
     * @throws ElementoInvalidoException
     * @throws NullPointerException
     */
    public void setDataInicioCandidatura(LocalDate dataInicioCandidatura) throws ElementoInvalidoException, NullPointerException {
        if (dataInicioCandidatura.isAfter(dataInicioPublicitacao)
                || dataInicioCandidatura.isEqual(dataInicioPublicitacao)
                && !dataInicioCandidatura.isAfter(dataFimPublicitacao)) {
            this.dataInicioCandidatura = dataInicioCandidatura;
        } else {
            throw new ElementoInvalidoException("A data de início de candidatura tem de ser posterior à data de início de publicitação e anterior à data de fim de publicitação!");
        }
    }

    /**
     *
     * @param dataFimCandidatura especifica uma nova data de fim de candidatura
     * @throws ElementoInvalidoException
     * @throws NullPointerException
     */
    public void setDataFimCandidatura(LocalDate dataFimCandidatura) throws ElementoInvalidoException, NullPointerException {
        if (dataFimCandidatura.isAfter(dataInicioCandidatura)
                && !dataFimCandidatura.isAfter(dataFimPublicitacao)) {
            this.dataFimCandidatura = dataFimCandidatura;
        } else {
            throw new ElementoInvalidoException("A data de fim de candidatura tem de ser posterior à data de início de candidatura e anterior à data de fim de publicitação!");
        }
    }

    /**
     *
     * @param dataInicioSeriacao especifica uma nova data de início de seriação
     * @throws ElementoInvalidoException
     * @throws NullPointerException
     */
    public void setDataInicioSeriacao(LocalDate dataInicioSeriacao) throws ElementoInvalidoException, NullPointerException {
        if (dataInicioSeriacao.isAfter(dataFimCandidatura)
                && !dataInicioSeriacao.isAfter(dataFimPublicitacao)) {
            this.dataInicioSeriacao = dataInicioSeriacao;
        } else {
            throw new ElementoInvalidoException("A data de início de seriação tem de ser posterior à data de fim de candidatura e anterior à data de fim de publicitação!");
        }
    }

    /**
     *
     * @param dataFimSeriacao especifica uma nova data de fim de seriação
     * @throws ElementoInvalidoException
     * @throws NullPointerException
     */
    public void setDataFimSeriacao(LocalDate dataFimSeriacao) throws ElementoInvalidoException, NullPointerException {
        if (dataFimSeriacao.isAfter(dataInicioSeriacao)
                && !dataFimSeriacao.isAfter(dataFimPublicitacao)
                || dataFimSeriacao.isEqual(dataFimPublicitacao)) {
            this.dataFimSeriacao = dataFimSeriacao;
        } else {
            throw new ElementoInvalidoException("A data de fim de seriação tem de ser posterior à data de início de seriação e anterior ou igual à data de fim de publicitação!");
        }
    }

    /**
     *
     * @param idTipoRegimento especifica um novo id do tipo de regimento a aplicar ao anúncio
     */
    public void setIdTipoRegimento(Long idTipoRegimento) {
        this.idTipoRegimento = idTipoRegimento;
    }

    /**
     *
     * @return retorna uma String com a descrição do anúncio(referência, data de registo do anúncio, data de início de publicitação, data de fim de publicitação, da de início de candidatura, data de fim de candidatura, da de início de seriação, data de fim de seriação, id do tipo de regimento)
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Anuncio{referencia=").append(referencia);
        sb.append(", dataRegistoAnuncio=").append(dataRegistoAnuncio);
        sb.append(", dataInicioPublicitacao=").append(dataInicioPublicitacao);
        sb.append(", dataFimPublicitacao=").append(dataFimPublicitacao);
        sb.append(", dataInicioCandidatura=").append(dataInicioCandidatura);
        sb.append(", dataFimCandidatura=").append(dataFimCandidatura);
        sb.append(", dataInicioSeriacao=").append(dataInicioSeriacao);
        sb.append(", dataFimSeriacao=").append(dataFimSeriacao);
        sb.append(", idTipoRegimento=").append(idTipoRegimento);
        sb.append('}');
        return sb.toString();
    }

    /**
     *
     * @return Override do hashCode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.referencia);
        hash = 29 * hash + Objects.hashCode(this.dataRegistoAnuncio);
        hash = 29 * hash + Objects.hashCode(this.dataInicioPublicitacao);
        hash = 29 * hash + Objects.hashCode(this.dataFimPublicitacao);
        hash = 29 * hash + Objects.hashCode(this.dataInicioCandidatura);
        hash = 29 * hash + Objects.hashCode(this.dataFimCandidatura);
        hash = 29 * hash + Objects.hashCode(this.dataInicioSeriacao);
        hash = 29 * hash + Objects.hashCode(this.dataFimSeriacao);
        hash = 29 * hash + Objects.hashCode(this.idTipoRegimento);
        return hash;
    }

    /**
     *
     * @param outroObjeto instância de anúncio a ser comparada
     * @return reescrita do método equals e retorna um booleano
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Anuncio_copia outroAnuncio = (Anuncio_copia) outroObjeto;
        return referencia.equalsIgnoreCase(outroAnuncio.referencia)
                && dataRegistoAnuncio.equals(outroAnuncio.dataRegistoAnuncio)
                && dataInicioPublicitacao.equals(outroAnuncio.dataInicioPublicitacao)
                && dataFimPublicitacao.equals(outroAnuncio.dataFimPublicitacao)
                && dataInicioCandidatura.equals(outroAnuncio.dataInicioCandidatura)
                && dataFimCandidatura.equals(outroAnuncio.dataFimCandidatura)
                && dataInicioSeriacao.equals(outroAnuncio.dataInicioSeriacao)
                && dataFimSeriacao.equals(outroAnuncio.dataFimSeriacao)
                && idTipoRegimento.equals(outroAnuncio.idTipoRegimento);
    }
}
