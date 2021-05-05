package t4j.app.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import t4j.app.exception.ElementoInvalidoException;
import t4j.app.utils.Validacao;

@Entity
@Table(name = "endereco")
@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class EnderecoPostal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Variável de instância - morada
     */
    @Column(name = "morada")
    private String morada;

    /**
     * Variável de instância - código postal
     */
    @Column(name = "codigo_postal")
    private String codigoPostal;

    /**
     * Variável de instância - localidade
     */
    @Column(name = "localidade")
    private String localidade;

    /**
     * Construtor completo de endereço postal
     *
     * @param morada morada
     * @param codigoPostal código postal
     * @param localidade localidade
     */
    public EnderecoPostal(String morada, String codigoPostal, String localidade) {
        setMorada(morada);
        setCodigoPostal(codigoPostal);
        setLocalidade(localidade);
    }

    /**
     * Construtor vazio de endereço postal
     */
    public EnderecoPostal() {
    }

    /**
     * Construtor cópia de endereço postal
     *
     * @param outroEnderecoPostal instância endereço postal a ser copiada
     */
    public EnderecoPostal(EnderecoPostal outroEnderecoPostal) {
        setMorada(outroEnderecoPostal.morada);
        setCodigoPostal(outroEnderecoPostal.codigoPostal);
        setLocalidade(outroEnderecoPostal.localidade);
    }

    public EnderecoPostal(Long id, String morada, String codigoPostal,
            String localidade) {
        this.id = id;
        this.morada = morada;
        this.codigoPostal = codigoPostal;
        this.localidade = localidade;
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
        final EnderecoPostal other = (EnderecoPostal) obj;
        if (!Objects.equals(this.morada, other.morada)) {
            return false;
        }
        if (!Objects.equals(this.codigoPostal, other.codigoPostal)) {
            return false;
        }
        if (!Objects.equals(this.localidade, other.localidade)) {
            return false;
        }
        return true;
    }

    public Long getId() {
        return id;
    }

    /**
     *
     * @return morada
     */
    public String getMorada() {
        return morada;
    }

    /**
     *
     * @return código postal
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     *
     * @return localidade
     */
    public String getLocalidade() {
        return localidade;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.morada);
        hash = 89 * hash + Objects.hashCode(this.codigoPostal);
        hash = 89 * hash + Objects.hashCode(this.localidade);
        return hash;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @param morada especifica uma nova morada do endereço postal
     */
    public void setMorada(String morada) throws ElementoInvalidoException {
        morada = morada.trim();
        if (Validacao.validaMorada(morada)) {
            this.morada = morada;
        } else {
            throw new ElementoInvalidoException("Morada inválida.");
        }
    }

    /**
     *
     * @param codigoPostal especifica um novo código postal do endereço postal
     */
    public void setCodigoPostal(String codigoPostal) throws
            ElementoInvalidoException {
        codigoPostal = codigoPostal.trim();
        if (Validacao.validaCodigoPostal(codigoPostal)) {
            this.codigoPostal = codigoPostal;
        } else {
            throw new ElementoInvalidoException("Código postal inválido.");
        }
    }

    /**
     *
     * @param localidade especifica uma nova localidade do endereço postal
     */
    public void setLocalidade(String localidade) throws
            ElementoInvalidoException {
        localidade = localidade.trim();
        if (Validacao.validaLocalidade(localidade)) {
            this.localidade = localidade;
        } else {
            throw new ElementoInvalidoException("Localidade inválida.");
        }
    }

    /**
     *
     * @return retorna uma String com a descrição do endereço postal (morada,
     * código postal, localidade)
     */
    @Override
    public String toString() {
        return String.format(
                "%nEndereço postal:%n{"
                + "%n  id=%d"
                + "%n  morada=%s"
                + "%n  códido postal=%s"
                + "%n  localidade = %s%n}",
                getId(),
                getMorada(),
                getCodigoPostal(),
                getLocalidade());
    }

}
