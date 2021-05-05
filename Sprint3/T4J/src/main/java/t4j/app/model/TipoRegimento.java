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
@Table(name = "tiporegimento")
@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class TipoRegimento implements Serializable {

    /**
     * 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * 
     */
    @Column(name = "designacao")
    private String designacao;
    
    /**
     * 
     */
    @Column(name = "descricaoregras")
    private String descricaoRegras;

    /**
     * 
     * @param designacao
     * @param descricaoRegras 
     */
    public TipoRegimento(String designacao, String descricaoRegras) {
        setDesignacao(designacao);
        this.descricaoRegras = descricaoRegras;
    }

    /**
     * 
     */
    public TipoRegimento() {
    }

    /**
     * 
     * @param outroTipoRegimento 
     */
    public TipoRegimento(TipoRegimento outroTipoRegimento) {
        setDesignacao(outroTipoRegimento.designacao);
        setDescricaoRegras(outroTipoRegimento.descricaoRegras);
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
    public String getDesignacao() {
        return designacao;
    }

    /**
     * 
     * @return 
     */
    public String getDescricaoRegras() {
        return descricaoRegras;
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
     * @param designacao 
     */
    public void setDesignacao(String designacao) {
        designacao = designacao.trim();
        if (Validacao.validaDesignacaoTipoRegimento(designacao)) {
            this.designacao = designacao;
        } else {
            throw new ElementoInvalidoException("Designação inválida.");
        }
    }

    /**
     * 
     * @param descricaoRegras 
     */
    public void setDescricaoRegras(String descricaoRegras) {
        descricaoRegras = descricaoRegras.trim();
        if (Validacao.validaDescricaoRegrasTipoRegimento(descricaoRegras)) {
            this.descricaoRegras = descricaoRegras;
        } else {
            throw new ElementoInvalidoException("Descrição de regras inválida.");
        }
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TipoRegimento{id=").append(id);
        sb.append(", designacao=").append(designacao);
        sb.append(", descricaoRegras=").append(descricaoRegras);
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
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.designacao);
        hash = 97 * hash + Objects.hashCode(this.descricaoRegras);
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
        TipoRegimento outroTipoRegimento = (TipoRegimento) outroObjeto;
        return id.equals(outroTipoRegimento.id)
                && designacao.equalsIgnoreCase(outroTipoRegimento.designacao)
                && descricaoRegras.equalsIgnoreCase(outroTipoRegimento.descricaoRegras);
    }
}
