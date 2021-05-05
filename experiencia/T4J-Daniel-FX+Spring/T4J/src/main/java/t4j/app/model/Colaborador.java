package t4j.app.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.validator.EmailValidator;
import t4j.app.exception.ElementoInvalidoException;

@Entity
@Table(name = "colaborador")
@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class Colaborador implements Serializable {

    /**
     * Variável de instância - nome do colaborador
     */
    @Column(name = "nome")
    private String nome;

    /**
     * Variável de instância - função do colaborador
     */
    @Column(name = "funcao")
    private String funcao;

    /**
     * Variável de instância - telefone do colaborador
     */
    @Column(name = "telefone")
    private String telefone;

    /**
     * Variável de instância - e-Mail do colaborador
     */
    @Id
    @Column(name = "email")
    private String email;

    /**
     *
     */
    @Column(name = "nif_organizacao")
    private String nifOrganizacao;

    /**
     *
     */
    @Column(name = "gestor")
    private String gestor;

    /**
     * Construtor completo de colaborador
     *
     * @param nome
     * @param funcao
     * @param telefone
     * @param email
     * @param gestor         representa se colabora é um gestor (0 iou 1)
     * @param nifOrganizacao
     */
    public Colaborador(String nome, String funcao, String telefone, String email, String gestor, String nifOrganizacao) {
        this(nome, funcao, telefone, email, gestor);
        this.nifOrganizacao = nifOrganizacao;
    }

    /**
     * Construtor parcial de colaborador
     *
     * @param nome     nome do colaborador
     * @param funcao   função do colaborador
     * @param telefone telefone do colaborador
     * @param email    e-Mail do colaborador
     * @param gestor   representa se colabora é um gestor (0 iou 1)
     */
    public Colaborador(String nome, String funcao, String telefone, String email, String gestor) {
        setNome(nome);
        setFuncao(funcao);
        setTelefone(telefone);
        setEmail(email);
        setGestor(gestor);
    }

    /**
     * Construtor parcial de colaborador
     *
     * @param nome     nome do colaborador
     * @param funcao   função do colaborador
     * @param telefone telefone do colaborador
     * @param email    e-Mail do colaborador
     */
    public Colaborador(String nome, String funcao, String telefone, String email) {
        setNome(nome);
        setFuncao(funcao);
        setTelefone(telefone);
        setEmail(email);
    }

    /**
     * Construtor vazio de colaborador
     */
    public Colaborador() {

    }

    /**
     * Construtor cópia de colaborador
     *
     * @param outroColaborador instância colaborador a ser copiada
     */
    public Colaborador(Colaborador outroColaborador) {
        setNome(outroColaborador.nome);
        setFuncao(outroColaborador.funcao);
        setTelefone(outroColaborador.telefone);
        setEmail(outroColaborador.email);
        setNifOrganizacao(outroColaborador.getNifOrganizacao());
        setGestor(outroColaborador.getGestor());
    }

    /**
     *
     * @return
     */
    public String getGestor() {
        return gestor;
    }

    /**
     *
     * @return
     */
    public String getNifOrganizacao() {
        return nifOrganizacao;
    }

    /**
     *
     * @return nome do colaborador
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return função do colaborador
     */
    public String getFuncao() {
        return funcao;
    }

    /**
     *
     * @return telefone do colaborador
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     *
     * @return e-Mail do colaborador
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param gestor
     */
    public void setGestor(String gestor) {
        if (ValidaColaborador.validaGestor(gestor)) {
            this.gestor = gestor;
        }
    }

    /**
     *
     * @param nifOrganizacao
     */
    public void setNifOrganizacao(String nifOrganizacao) {
        if (ValidaColaborador.validaNif(nifOrganizacao)) {
            this.nifOrganizacao = nifOrganizacao;
        }
    }

    /**
     *
     * @param nome especifica um novo nome do colaborador
     */
    public void setNome(String nome) throws ElementoInvalidoException {
        if (ValidaColaborador.validaNomeColaborador(nome)) {
            this.nome = nome;
        }
    }

    /**
     *
     * @param funcao especifica uma nova função do colaborador
     */
    public void setFuncao(String funcao) throws ElementoInvalidoException {
        if (ValidaColaborador.validaFuncaoColaborador(funcao)) {
            this.funcao = funcao;
        }
    }

    /**
     *
     * @param telefone especifica um novo telefone do colaborador
     */
    public void setTelefone(String telefone) throws ElementoInvalidoException {
        if (ValidaColaborador.validaTelefone(telefone)) {
            this.telefone = telefone;
        }
    }

    /**
     *
     * @param email especifica um novo e-Mail do colaborador
     */
    public void setEmail(String email) throws ElementoInvalidoException {
        if (ValidaColaborador.validaEmail(email)) {
            this.email = email;
        }
    }

    /**
     *
     * @return retorna uma String com a descrição do colaborador (nome, função,
     *         telefone, e-Mail)
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Colaborador{nome=").append(nome);
        sb.append(", funcao=").append(funcao);
        sb.append(", telefone=").append(telefone);
        sb.append(", email=").append(email);
        sb.append(", nifOrganizacao=").append(nifOrganizacao);
        sb.append(", gestor=").append(gestor);
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
        hash = 37 * hash + Objects.hashCode(this.nome);
        hash = 37 * hash + Objects.hashCode(this.funcao);
        hash = 37 * hash + Objects.hashCode(this.telefone);
        hash = 37 * hash + Objects.hashCode(this.email);
        hash = 37 * hash + Objects.hashCode(this.nifOrganizacao);
        hash = 37 * hash + Objects.hashCode(this.gestor);
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
        final Colaborador other = (Colaborador) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.funcao, other.funcao)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.nifOrganizacao, other.nifOrganizacao)) {
            return false;
        }
        if (!Objects.equals(this.gestor, other.gestor)) {
            return false;
        }
        return true;
    }

    private static class ValidaColaborador {

        /**
         * Constante - número máximo de caractéres da função do colaborador
         */
        private static final int FUNCAO_LENGTH = 50;
        /**
         * Constante - número máximo de caractéres do nome do colaborador
         */
        private static final int NOME_LENGTH = 50;
        /**
         * Constante - caractéres que a validação aceita e seu formato
         */
        private static final String NOME_REGEX = "[a-zA-ZÀ-ú ]+";
        /**
         * Constante - número máximo de dígitos do telefone
         */
        private static final int TELEFONE_LENGTH_MAX = 16;
        /**
         * Constante - número máximo de dígitos do NIF
         */
        private static final int NIF_LENGTH = 9;
        /**
         * Constante - caractéres que a validação aceita e seu formato
         */
        private static final String NIF_REGEX = "[0-9]+";
        /**
         * Constante - número mínimo de dígitos do telefone
         */
        private static final int TELEFONE_LENGTH_MIN = 9;
        /**
         * Constante - número máximo de caractéres do email
         */
        private static final int EMAIL_LENGTH = 254;
        /**
         * Constante - número máximo de caractéres do gestor
         */
        private static final int GESTOR_LENGTH = 1;
        /**
         * Constante - caractéres que a validação aceita e seu formato
         */
        private static final String TELEFONE_REGEX = "[0-9]+";
        /**
         * Constante - valor 0 do gestor - represet um colaborador
         */
        private static final String GESTOR_VALUE_0 = "0";
        /**
         * Constante - valor 1 do gestor - representa um gestor
         */
        private static final String GESTOR_VALUE_1 = "1";

        /**
         *
         * @param funcao função do colaborador a ser validada
         * @return true se válido e false se inválido
         *
         * @exception ElementoInvalidoException
         */
        public static boolean validaFuncaoColaborador(String funcao) {
            boolean isNull = false;
            boolean isEmpty = false;
            boolean isGreaterThanMaxSize = false;

            isNull = funcao == null;
            if (isNull) {
                throw new ElementoInvalidoException("Função do colaborador não pode ser null.");
            }

            isEmpty = funcao.trim().isEmpty();
            if (isEmpty) {
                throw new ElementoInvalidoException("Função do colaborador deve ser diferente de vazio.");
            }

            isGreaterThanMaxSize = funcao.length() > FUNCAO_LENGTH;
            if (isGreaterThanMaxSize) {
                throw new ElementoInvalidoException(String.format("Função do colaborador não pode ultrapassar %d caracteres.",
                        FUNCAO_LENGTH));
            }
            return true;
        }

        /**
         *
         * @param nome nome do colaborador a ser validado
         * @return true se válido
         *
         * @exception ElementoInvalidoException
         */
        public static boolean validaNomeColaborador(String nome) {
            boolean isNull = false;
            boolean isEmpty = false;
            boolean isGreaterThanMaxSize = false;
            boolean isRegexInvalid = false;

            isNull = nome == null;
            if (isNull) {
                throw new ElementoInvalidoException("Nome do colaborador não pode ser null.");
            }

            isEmpty = nome.trim().isEmpty();
            if (isEmpty) {
                throw new ElementoInvalidoException("Nome do colaborador deve ser diferente de vazio.");
            }

            isGreaterThanMaxSize = nome.length() > NOME_LENGTH;
            if (isGreaterThanMaxSize) {
                throw new ElementoInvalidoException(String.format("Nome do colaborador não pode ultrapassar %d caracteres.",
                        NOME_LENGTH));
            }

            isRegexInvalid = !nome.trim().matches(NOME_REGEX);
            if (isRegexInvalid) {
                throw new ElementoInvalidoException("Nome não pode conter caracteres especiais. (Acentos são suportados)");
            }

            return true;
        }

        /**
         *
         * @param email email a ser validado
         * @return true se válido e false se inválido
         *
         * @exception ElementoInvalidoException
         */
        public static boolean validaEmail(String email) {
            EmailValidator emailValidator = EmailValidator.getInstance();
            boolean isNull = false;
            boolean isInvalid = false;
            boolean isGreaterThanMaxSize = false;

            isNull = email == null;
            if (isNull) {
                throw new ElementoInvalidoException("Email do colaborador não pode ser null.");
            }

            isGreaterThanMaxSize = email.length() > EMAIL_LENGTH;
            if (isGreaterThanMaxSize) {
                throw new ElementoInvalidoException(String.format("Email do colaborador não pode ultrapassar %d caracteres.",
                        EMAIL_LENGTH));
            }

            isInvalid = !emailValidator.isValid(email);
            if (isInvalid) {
                throw new ElementoInvalidoException("Email do colaborador deve ser um email válido.");
            }

            return true;
        }

        /**
         *
         * @param nif telefone a ser vaidado
         * @return true se válido
         *
         * @exception ElementoInvalidoException
         *
         */
        public static boolean validaNif(String nif) {
            boolean isNull = false;
            boolean isEmpty = false;
            boolean isRegexInvalid = false;
            boolean isDiferentFromSize = false;

            isNull = nif == null;
            if (isNull) {
                throw new ElementoInvalidoException("(Colaborador) NIF da organização não pode ser null.");
            }

            isEmpty = nif.trim().isEmpty();
            if (isEmpty) {
                throw new ElementoInvalidoException("(Colaborador) NIF da organização deve ser diferente de vazio.");
            }

            isRegexInvalid = !nif.matches(NIF_REGEX);
            if (isRegexInvalid) {
                throw new ElementoInvalidoException("(Colaborador) NIF da organização deve conter apenas números.");
            }

            isDiferentFromSize = nif.length() != NIF_LENGTH;
            if (isDiferentFromSize) {
                throw new ElementoInvalidoException(String.format("(Colaborador) NIF da organização não pode ultrapassar %d caracteres.",
                        NIF_LENGTH));
            }

            return true;
        }

        /**
         *
         * @param telefone telefone a ser vaidado
         * @return true se válido
         *
         * @exception ElementoInvalidoException
         *
         */
        public static boolean validaTelefone(String telefone) {
            boolean isNull = false;
            boolean isEmpty = false;
            boolean isRegexInvalid = false;
            boolean isGreaterThanMaxSize = false;
            boolean isSmallerThanMinSize = false;

            isNull = telefone == null;
            if (isNull) {
                throw new ElementoInvalidoException("Telefone do colaborador não pode ser null.");
            }

            isEmpty = telefone.trim().isEmpty();
            if (isEmpty) {
                throw new ElementoInvalidoException("Telefone do colaborador deve ser diferente de vazio.");
            }

            isRegexInvalid = !telefone.matches(TELEFONE_REGEX);
            if (isRegexInvalid) {
                throw new ElementoInvalidoException("Telefone do colaborador deve conter apenas números e sinal de positivo (+).");
            }

            isGreaterThanMaxSize = telefone.length() > TELEFONE_LENGTH_MAX;
            if (isGreaterThanMaxSize) {
                throw new ElementoInvalidoException(String.format("Telefone do colaborador não pode ultrapassar %d caracteres.",
                        TELEFONE_LENGTH_MAX));
            }
            isSmallerThanMinSize = telefone.length() < TELEFONE_LENGTH_MIN;
            if (isSmallerThanMinSize) {
                throw new ElementoInvalidoException(String.format("Telefone do colaborador ser menor do que %d caracteres.",
                        TELEFONE_LENGTH_MIN));
            }

            return true;
        }

        /**
         *
         * @param gestor a ser validado
         * @return true se válido
         *
         * @exception ElementoInvalidoException
         */
        public static boolean validaGestor(String gestor) {
            boolean isNull = false;
            boolean isEmpty = false;
            boolean isContentInvalid = false;
            boolean isDiferentFromExpectedSize = false;

            isNull = gestor == null;
            if (isNull) {
                throw new ElementoInvalidoException("Propriedade Gestor não pode ser null.");
            }

            isEmpty = gestor.trim().isEmpty();
            if (isEmpty) {
                throw new ElementoInvalidoException("Propriedade Gestor deve ser diferente de vazio.");
            }

            isDiferentFromExpectedSize = gestor.length() != GESTOR_LENGTH;
            if (isDiferentFromExpectedSize) {
                throw new ElementoInvalidoException(String.format("Propriedade Gestor não pode ultrapassar %d caracteres.",
                        GESTOR_LENGTH));
            }

            isContentInvalid = !GESTOR_VALUE_0.equals(gestor) && !GESTOR_VALUE_1.equals(gestor);
            if (isContentInvalid) {
                throw new ElementoInvalidoException("Propriedade Gestor deve conter apenas os caracteres 0 ou 1. \"0\" Representa um Colaborador. \"1\" Representa um gestor.");
            }


            return true;
        }
    }
}
