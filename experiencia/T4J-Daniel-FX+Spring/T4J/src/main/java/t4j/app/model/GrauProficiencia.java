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

    /**
     *
     */
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
     * @param valorGrauProficiencia valorGrauProficiencia do grau de proficiência
     * @param designacaoGrauProficiencia designação do grau de proficiência
     */
    public GrauProficiencia(String valorGrauProficiencia, String designacaoGrauProficiencia) {
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
     * @param outroGrauProficiencia instância de grau de proficiência a ser copiada
     */
    public GrauProficiencia(GrauProficiencia outroGrauProficiencia) {
        id = outroGrauProficiencia.id;
        setValorGrauProficiencia(outroGrauProficiencia.valorGrauProficiencia);
        setDesignacaoGrauProficiencia(
                outroGrauProficiencia.designacaoGrauProficiencia);
    }

    /**
     *
     * @param id
     * @param valorGrauProficiencia
     * @param designacaoGrauProficiencia
     */
    public GrauProficiencia(long id, String valorGrauProficiencia, String designacaoGrauProficiencia) {
        this.id = id;
        this.valorGrauProficiencia = valorGrauProficiencia;
        this.designacaoGrauProficiencia = designacaoGrauProficiencia;
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
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @param valorGrauProficiencia especifica um novo valorGrauProficiencia de grau de proficiência
     */
    public void setValorGrauProficiencia(String valorGrauProficiencia) throws ElementoInvalidoException {
//        if (valorGrauProficiencia == null) {
//            throw new ElementoInvalidoException("Valor inválido.");
//        }
//        if (valorGrauProficiencia.trim().isEmpty()) {
//            throw new ElementoInvalidoException("Valor inválido.");
//        }
//        try {
//            int valor = Integer.parseInt(valorGrauProficiencia);
//            if (valor > 99 || valor <= 0) {
//                throw new ElementoInvalidoException("Valor inválido.");
//            }
//        } catch (NumberFormatException e) {
//            throw new ElementoInvalidoException("Valor inválido.");
//        }
//        valorGrauProficiencia = valorGrauProficiencia.trim();
//        if (Validacao.validaValorGrauProficiencia(valorGrauProficiencia)) {
            this.valorGrauProficiencia = valorGrauProficiencia;
//        } else {
//            throw new ElementoInvalidoException("Valor inválido.");
//        }
    }

    /**
     *
     * @param designacaoGrauProficiencia especifica uma nova designação de grau de proficiência
     */
    public void setDesignacaoGrauProficiencia(String designacaoGrauProficiencia)
            throws ElementoInvalidoException {
//        if (designacaoGrauProficiencia == null) {
//            throw new ElementoInvalidoException("Designação inválida.");
//        }
//        if (designacaoGrauProficiencia.trim().isEmpty()) {
//            throw new ElementoInvalidoException("Designação inválida.");
//        }
        this.designacaoGrauProficiencia = designacaoGrauProficiencia;

    }

    /**
     *
     * @return retorna uma String com a descrição do grau de proficiência (valorGrauProficiencia,
     * designação)
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GrauProficiencia{id=").append(id);
        sb.append(", valorGrauProficiencia=").append(valorGrauProficiencia);
        sb.append(", designacaoGrauProficiencia=").append(designacaoGrauProficiencia);
        sb.append('}');
        return sb.toString();
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.valorGrauProficiencia);
        hash = 71 * hash + Objects.hashCode(this.designacaoGrauProficiencia);
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
        final GrauProficiencia other = (GrauProficiencia) obj;
        if (!Objects.equals(this.valorGrauProficiencia, other.valorGrauProficiencia)) {
            return false;
        }
        if (!Objects.equals(this.designacaoGrauProficiencia, other.designacaoGrauProficiencia)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
