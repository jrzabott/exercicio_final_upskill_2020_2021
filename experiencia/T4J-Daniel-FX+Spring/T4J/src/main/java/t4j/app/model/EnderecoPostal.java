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

@Entity
@Table(name = "endereco")
@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class EnderecoPostal implements Serializable {

    /**
     *
     */
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
     * @param morada       morada
     * @param codigoPostal código postal
     * @param localidade   localidade
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
        setId(outroEnderecoPostal.getId());
        setMorada(outroEnderecoPostal.morada);
        setCodigoPostal(outroEnderecoPostal.codigoPostal);
        setLocalidade(outroEnderecoPostal.localidade);
    }

    public EnderecoPostal(Long id, String morada, String codigoPostal, String localidade) {
        this(morada, codigoPostal, localidade);
        this.id = id;
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

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @param morada especifica uma nova morada do endereço postal
     */
    public void setMorada(String morada) throws ElementoInvalidoException {
        if (ValidaEnderecoPostal.validaMorada(morada)) {
            this.morada = morada;
        }
    }

    /**
     *
     * @param codigoPostal especifica um novo código postal do endereço postal
     */
    public void setCodigoPostal(String codigoPostal) throws ElementoInvalidoException {
        if (ValidaEnderecoPostal.validaCodigoPostal(codigoPostal)) {
            this.codigoPostal = codigoPostal;
        }
    }

    /**
     *
     * @param localidade especifica uma nova localidade do endereço postal
     */
    public void setLocalidade(String localidade) throws ElementoInvalidoException {
        if (ValidaEnderecoPostal.validaLocalidade(localidade)) {
            this.localidade = localidade;
        }
    }

    /**
     *
     * @return retorna uma String com a descrição do endereço postal (morada, código postal,
     *         localidade)
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EnderecoPostal{id=").append(id);
        sb.append(", morada=").append(morada);
        sb.append(", codigoPostal=").append(codigoPostal);
        sb.append(", localidade=").append(localidade);
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
        hash = 97 * hash + Objects.hashCode(this.morada);
        hash = 97 * hash + Objects.hashCode(this.codigoPostal);
        hash = 97 * hash + Objects.hashCode(this.localidade);
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
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    protected static class ValidaEnderecoPostal {
        /**
         * Constante - caractéres que a validação aceita e seu formato
         */
        private static final String CODIGO_POSTAL_REGEX = "[1-9][0-9]{3}-[0-9]{3}";
        /**
         * Constante - número máximo de caractéres da localidade
         */
        private static final int LOCALIDADE_LENGTH = 50;
        /**
         * Constante - caractéres que a validação aceita e seu formato
         */
        private static final String LOCALIDADE_REGEX = "[a-zA-ZÀ-ú ]+";
        /**
         * Constante - número máximo de caractéres da morada
         */
        private static final int MORADA_LENGTH = 256;
        protected static final String CODIGO_POSTAL_EMPTY_EXCEPTION = "Código Postal deve ser preenchida.";
        protected static final String CODIGO_POSTAL_NULL_EXCEPTION = "Código Postal não pode ser null.";
        protected static final String CODIGO_POSTAL_REGEX_EXCEPTION = "Codigo Postal deve estar no formato XXXX-XXX";
        protected static final String LOCALIDADE_EMPTY_EXCEPTION = "Localidade deve ser preenchida.";
        protected static final String LOCALIDADE_MAX_SIZE_EXCEPTION = String.format("Localidade deve ter no máximo %s caracteres.", LOCALIDADE_LENGTH);
        protected static final String LOCALIDADE_NULL_EXCEPTION = "Localidade não pode ser null.";
        protected static final String LOCALIDADE_REGEX_EXCEPTION = "Localidade não pode conter caracteres especiais ou números";
        protected static final String MORADA_EMPTY_EXCEPTION = "Morada deve ser preenchida.";
        protected static final String MORADA_MAX_SIZE_EXCEPTION = String.format("Morada deve ter no máximo %s caracteres.", MORADA_LENGTH);
        protected static final String MORADA_NULL_EXCEPTION = "Morada não pode ser null.";

        protected static boolean validaCodigoPostal(String codigoPostal) {
            boolean isNull = false;
            boolean isEmpty = false;
            boolean isRegexInvalid = false;

            isNull = codigoPostal == null;
            if (isNull) {
                throw new ElementoInvalidoException(CODIGO_POSTAL_NULL_EXCEPTION);
            }
            isEmpty = codigoPostal.trim().isEmpty();
            if (isEmpty) {
                throw new ElementoInvalidoException(CODIGO_POSTAL_EMPTY_EXCEPTION);
            }
            isRegexInvalid = !codigoPostal.matches(CODIGO_POSTAL_REGEX);
            if (isRegexInvalid) {
                throw new ElementoInvalidoException(CODIGO_POSTAL_REGEX_EXCEPTION);
            }

            return true;
        }
        protected static boolean validaLocalidade(String localidade) {
            boolean isNull = false;
            boolean isEmpty = false;
            boolean isGreaterThanMaxLength = false;
            boolean isRegexInvalid = false;

            isNull = localidade == null;
            if (isNull) {
                throw new ElementoInvalidoException(LOCALIDADE_NULL_EXCEPTION);
            }

            isEmpty = localidade.trim().isEmpty();
            if (isEmpty) {
                throw new ElementoInvalidoException(LOCALIDADE_EMPTY_EXCEPTION);
            }

            isGreaterThanMaxLength = localidade.length() > LOCALIDADE_LENGTH;
            if (isGreaterThanMaxLength) {
                throw new ElementoInvalidoException(String.format(LOCALIDADE_MAX_SIZE_EXCEPTION,
                        LOCALIDADE_LENGTH));
            }

            isRegexInvalid = !localidade.matches(LOCALIDADE_REGEX);
            if (isRegexInvalid) {
                throw new ElementoInvalidoException(LOCALIDADE_REGEX_EXCEPTION);
            }

            return true;
        }
        protected static boolean validaMorada(String morada) {
            boolean isNull = false;
            boolean isEmpty = false;
            boolean isGreaterThanMaxLength = false;

            isNull = morada == null;
            if (isNull) {
                throw new ElementoInvalidoException(MORADA_NULL_EXCEPTION);
            }

            isEmpty = morada.trim().isEmpty();
            if (isEmpty) {
                throw new ElementoInvalidoException(MORADA_EMPTY_EXCEPTION);
            }

            isGreaterThanMaxLength = morada.length() > MORADA_LENGTH;
            if (isGreaterThanMaxLength) {
                throw new ElementoInvalidoException(MORADA_MAX_SIZE_EXCEPTION);
            }

            return true;
        }

    }
}
