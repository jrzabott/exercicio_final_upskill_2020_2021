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
@Table(name = "GRAUPROFICIENCIA")
public class GrauProficiencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Variável de instância - valorGrauProficiencia do grau de proficiência
     */
    @Column(name = "VALOR")
    private String valorGrauProficiencia;

    /**
     * Variável de instância - designação do grau de proficiência
     */
    @Column(name = "DESIGNACAO")
    private String designacaoGrauProficiencia;

    /**
     * Construtor completo de grau de proficiência
     *
     * @param valorGrauProficiencia valorGrauProficiencia do grau de
     * proficiência
     * @param designacaoGrauProficiencia designação do grau de proficiência
     */
    public GrauProficiencia(String valorGrauProficiencia,
            String designacaoGrauProficiencia) {
        setValorGrauProficiencia(valorGrauProficiencia);
        setDesignacaoGrauProficiencia(designacaoGrauProficiencia);
    }

    /**
     * Construtor vazio de grau de proficiência
     */
    public GrauProficiencia() {
    }

    /**
     * Construtor cópia de grau de proficiência
     *
     * @param outroGrauProficiencia instância de grau de proficiência a ser
     * copiada
     */
    public GrauProficiencia(GrauProficiencia outroGrauProficiencia) {
        setValorGrauProficiencia(outroGrauProficiencia.valorGrauProficiencia);
        setDesignacaoGrauProficiencia(
                outroGrauProficiencia.designacaoGrauProficiencia);
    }

    public GrauProficiencia(long id, String valorGrauProficiencia,
            String designacaoGrauProficiencia) {
        this.id = id;
        this.valorGrauProficiencia = valorGrauProficiencia;
        this.designacaoGrauProficiencia = designacaoGrauProficiencia;
    }

    /**
     *
     * @return valorGrauProficiencia do grau de proficiência
     */
    public String getValorGrauProficiencia() {
        return valorGrauProficiencia;
    }

    /**
     *
     * @return designação do grau de proficiência
     */
    public String getDesignacaoGrauProficiencia() {
        return designacaoGrauProficiencia;
    }

    /**
     *
     * @param valorGrauProficiencia especifica um novo valorGrauProficiencia de
     * grau de proficiência
     */
    public void setValorGrauProficiencia(String valorGrauProficiencia) throws ElementoInvalidoException {
        if (Validacao.validaValorGrauProficiencia(valorGrauProficiencia)) {
// Daniel Junior - 20210220 - 17:02
// Não é possível fazer trim em valores nulos. (conforme validação).
//            valorGrauProficiencia = valorGrauProficiencia.trim();
            this.valorGrauProficiencia = valorGrauProficiencia;
        } else {
            throw new ElementoInvalidoException("Valor inválido.");
        }
    }

    /**
     *
     * @param designacaoGrauProficiencia especifica uma nova designação de grau
     * de proficiência
     */
    public void setDesignacaoGrauProficiencia(String designacaoGrauProficiencia)
            throws ElementoInvalidoException {
// Daniel Junior - 20210220 - 17:02
// Não é possível fazer trim em valores nulos. (conforme validação).
//        designacaoGrauProficiencia = designacaoGrauProficiencia.trim();
//        if (Validacao.validaDesignacaoGrauProficiencia(
//                designacaoGrauProficiencia)) {
        this.designacaoGrauProficiencia = designacaoGrauProficiencia;
//        } else {
//            throw new ElementoInvalidoException("Designação inválida.");
//        }
    }

    /**
     *
     * @return retorna uma String com a descrição do grau de proficiência
     * (valorGrauProficiencia, designação)
     */
    @Override
    public String toString() {
        return String.format(
                "Grau de proficiência:%n{%n  id=%s%n  valor= %s%n  designação= %s"
                + "%n}",
                getId(),
                getValorGrauProficiencia(),
                getDesignacaoGrauProficiencia());
    }

    /**
     *
     * @param outroObjeto instância de grau de proficiência a ser comparada
     * @return reescrita do método equals e retorna um booleano
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
        final GrauProficiencia other = (GrauProficiencia) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.valorGrauProficiencia,
                other.valorGrauProficiencia)) {
            return false;
        }
        if (!Objects.equals(this.designacaoGrauProficiencia,
                other.designacaoGrauProficiencia)) {
            return false;
        }
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return Override do hashCode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 37 * hash + Objects.hashCode(this.valorGrauProficiencia);
        hash = 37 * hash + Objects.hashCode(this.designacaoGrauProficiencia);
        return hash;
    }

}
