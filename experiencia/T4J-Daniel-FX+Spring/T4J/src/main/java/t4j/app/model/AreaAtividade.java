package t4j.app.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import t4j.app.exception.ElementoInvalidoException;
import t4j.app.utils.Validacao;

@Entity
@Table(name = "areaatividade")
@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class AreaAtividade implements Serializable {

    /**
     * Variável de instância - código da área de atividade
     */
    @Id
    @Column(name = "codigo")
    private String codigoAreaAtividade;

    /**
     * Variável de instância - descrição breve da área de atividade
     */
    @Column(name = "descricaobreve")
    private String descricaoBreve;

    /**
     * Variável de instância - descrição detalhada da área de atividade
     */
    @Column(name = "descricaodetalhada")
    private String descricaoDetalhada;

    /**
     * Construtor completo de área de atividade
     *
     * @param codigoAreaAtividade código da área de atividade
     * @param descricaoBreve descrição breve da área de atividade
     * @param descricaoDetalhada descrição detalhada da área de atividade
     */
    public AreaAtividade(String codigoAreaAtividade, String descricaoBreve, String descricaoDetalhada) {
        setCodigoAreaAtividade(codigoAreaAtividade);
        setDescricaoBreve(descricaoBreve);
        setDescricaoDetalhada(descricaoDetalhada);
    }

    /**
     * Construtor vazio de área de atividade
     */
    public AreaAtividade() {
    }

    /**
     * Construtor cópia de área de atividade
     *
     * @param outraAreaAtividade instância de área de atividade a ser copiada
     */
    public AreaAtividade(AreaAtividade outraAreaAtividade) {
        setCodigoAreaAtividade(outraAreaAtividade.codigoAreaAtividade);
        setDescricaoBreve(outraAreaAtividade.descricaoBreve);
        setDescricaoDetalhada(outraAreaAtividade.descricaoDetalhada);
    }

    /**
     *
     * @return código da área de atividade
     */
    public String getCodigoAreaAtividade() {
        return codigoAreaAtividade;
    }

    /**
     *
     * @return descrição breve da área de atividade
     */
    public String getDescricaoBreve() {
        return descricaoBreve;
    }

    /**
     *
     * @return descrição detalhada da área de atividade
     */
    public String getDescricaoDetalhada() {
        return descricaoDetalhada;
    }

    /**
     *
     * @param codigoAreaAtividade especifica um novo código da área de atividade
     */
    public void setCodigoAreaAtividade(String codigoAreaAtividade) throws ElementoInvalidoException {
        if (codigoAreaAtividade == null) {
            throw new ElementoInvalidoException("Código inválido.");
        }
        codigoAreaAtividade = codigoAreaAtividade.trim();
        if (Validacao.validaCodigoAreaAtividade(codigoAreaAtividade)) {
            this.codigoAreaAtividade = codigoAreaAtividade;
        } else {
            throw new ElementoInvalidoException("Código inválido.");
        }
    }

    /**
     *
     * @param descricaoBreve especifica uma nova descrição breve da área de atividade
     */
    public void setDescricaoBreve(String descricaoBreve) throws ElementoInvalidoException {
        if (descricaoBreve == null) {
            throw new ElementoInvalidoException("Descrição breve inválida.");
        }
        descricaoBreve = descricaoBreve.trim();
        if (Validacao.validaDescricaoBreveAreaAtividade(descricaoBreve)) {
            this.descricaoBreve = descricaoBreve;
        } else {
            throw new ElementoInvalidoException("Descrição breve inválida.");
        }
    }

    /**
     *
     * @param descricaoDetalhada especifica uma nova descrição detalhada da área de atividade
     */
    public void setDescricaoDetalhada(String descricaoDetalhada) throws ElementoInvalidoException {
        if (descricaoDetalhada == null) {
            throw new ElementoInvalidoException("Descrição detalhada inválida.");
        }
        descricaoDetalhada = descricaoDetalhada.trim();
        if (Validacao.validaDescricaoDetalhadaAreaAtividade(descricaoDetalhada)) {
            this.descricaoDetalhada = descricaoDetalhada.trim();
        } else {
            throw new ElementoInvalidoException("Descrição detalhada inválida.");
        }
    }

    /**
     *
     * @return retorna uma String com a descrição da área de atividade (código, descrição breve,
     * descrição detalhada)
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AreaAtividade{codigoAreaAtividade=").append(codigoAreaAtividade);
        sb.append(", descricaoBreve=").append(descricaoBreve);
        sb.append(", descricaoDetalhada=").append(descricaoDetalhada);
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
        hash = 71 * hash + Objects.hashCode(this.codigoAreaAtividade);
        hash = 71 * hash + Objects.hashCode(this.descricaoBreve);
        hash = 71 * hash + Objects.hashCode(this.descricaoDetalhada);
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
        final AreaAtividade other = (AreaAtividade) obj;
        if (!Objects.equals(this.codigoAreaAtividade, other.codigoAreaAtividade)) {
            return false;
        }
        if (!Objects.equals(this.descricaoBreve, other.descricaoBreve)) {
            return false;
        }
        if (!Objects.equals(this.descricaoDetalhada, other.descricaoDetalhada)) {
            return false;
        }
        return true;
    }
}
