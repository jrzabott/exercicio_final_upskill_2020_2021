package t4j.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import t4j.app.exception.ElementoInvalidoException;
import org.apache.commons.validator.EmailValidator;

/**
 *
 * @author Home
 */
@Entity
@Table(name = "freelancer")
public class FreeLancer implements Serializable {

    /**
     * 
     */
    @Id
    @Column(name = "email")
    private String email;

    /**
     * 
     */
    @Column(name = "nome")
    private String nome;

    /**
     * 
     */
    @Column(name = "nif")
    private String nif;

    /**
     * 
     */
    @Column(name = "telefone")
    private String telefone;
    
    /**
     * 
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco", foreignKey = @ForeignKey(name = "FK_FREELANCER_ENDERECO"))
    private EnderecoPostal endereco;

    /**
     * 
     */
    @Transient
    private List<HabilitacaoAcademica> habilitacoes;

    /**
     * 
     */
    @Transient
    public List<ReconhecimentoCT> reconhecimentos;
    
    public FreeLancer(String email, String nome, String nif, String telefone, EnderecoPostal endereco, List<HabilitacaoAcademica> habilitacoes, List<ReconhecimentoCT> reconhecimentos) {
        setEmail(email);
        setNome(nome);
        setNif(nif);
        setTelefone(telefone);
        setEndereco(endereco);
        this.habilitacoes = new ArrayList<HabilitacaoAcademica>(habilitacoes);
        this.reconhecimentos = new ArrayList<ReconhecimentoCT>(reconhecimentos);
    }
    
    /**
     * 
     * @param email
     * @param nome
     * @param nif
     * @param telefone
     * @param endereco 
     */
    public FreeLancer(String email, String nome, String nif, String telefone, EnderecoPostal endereco) {
        setEmail(email);
        setNome(nome);
        setNif(nif);
        setTelefone(telefone);
        setEndereco(endereco);
        this.habilitacoes = new ArrayList<HabilitacaoAcademica>();
        this.reconhecimentos = new ArrayList<ReconhecimentoCT>();
    }

    /**
     * 
     */
    public FreeLancer() {
        this.endereco = new EnderecoPostal();
        this.habilitacoes = new ArrayList<HabilitacaoAcademica>();
        this.reconhecimentos = new ArrayList<ReconhecimentoCT>();
    }

    /**
     * 
     * @param outroFreeLancer 
     */
    public FreeLancer(FreeLancer outroFreeLancer) {
        setEmail(outroFreeLancer.email);
        setNome(outroFreeLancer.nome);
        setNif(outroFreeLancer.nif);
        setTelefone(outroFreeLancer.telefone);
        setEndereco(outroFreeLancer.endereco);
        setHabilitacoes(outroFreeLancer.habilitacoes);
        setReconhecimentos(outroFreeLancer.reconhecimentos);
    }

    /**
     * 
     * @return 
     */
    public EnderecoPostal getEndereco() {
        return endereco;
    }

    /**
     * 
     * @return 
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @return 
     */
    public String getNome() {
        return nome;
    }

    /**
     * 
     * @return 
     */
    public String getNif() {
        return nif;
    }

    /**
     * 
     * @return 
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * 
     * @return 
     */
    public List<HabilitacaoAcademica> getHabilitacoes() {
        return habilitacoes;
    }

    /**
     * 
     * @return 
     */
    public List<ReconhecimentoCT> getReconhecimentos() {
        return reconhecimentos;
    }
    
    /**
     * 
     * @param habilitacoes 
     */
    public void setHabilitacoes(List<HabilitacaoAcademica> habilitacoes) {
        this.habilitacoes = new ArrayList<>(habilitacoes);
    }

    /**
     * 
     * @param reconhecimentos 
     */
    public void setReconhecimentos(List<ReconhecimentoCT> reconhecimentos) {
        this.reconhecimentos = new ArrayList<>(reconhecimentos);
    }

    /**
     * 
     * @param endereco 
     */
    public void setEndereco(EnderecoPostal endereco) {
        if (EnderecoPostal.ValidaEnderecoPostal.validaMorada(endereco.getMorada())
                && EnderecoPostal.ValidaEnderecoPostal.validaCodigoPostal(endereco.getCodigoPostal())
                && EnderecoPostal.ValidaEnderecoPostal.validaLocalidade(endereco.getLocalidade())) {
            this.endereco = endereco;
        }
        
    }

    /**
     * 
     * @param email
     * @throws ElementoInvalidoException 
     */
    public void setEmail(String email) throws ElementoInvalidoException {
        if (validaFreelancer.validaEmail(email)) {
            this.email = email;
        }
    }

    /**
     * 
     * @param nome
     * @throws ElementoInvalidoException 
     */
    public void setNome(String nome) throws ElementoInvalidoException {
        if (validaFreelancer.validaNome(nome)) {
            this.nome = nome;
        }
    }

    /**
     * 
     * @param nif
     * @throws ElementoInvalidoException 
     */
    public void setNif(String nif) throws ElementoInvalidoException {
        if (validaFreelancer.validaNif(nif)) {
            this.nif = nif;
        }
    }

    /**
     * 
     * @param telefone
     * @throws ElementoInvalidoException 
     */
    public void setTelefone(String telefone) throws ElementoInvalidoException {
        if (validaFreelancer.validaTelefone(telefone)) {
            this.telefone = telefone;
        }
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FreeLancer{email=").append(email);
        sb.append(", nome=").append(nome);
        sb.append(", nif=").append(nif);
        sb.append(", telefone=").append(telefone);
        sb.append(", endereco=").append(endereco);
        sb.append(", habilitacoes=").append(habilitacoes);
        sb.append(", reconhecimentos=").append(reconhecimentos);
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
        hash = 79 * hash + Objects.hashCode(this.email);
        hash = 79 * hash + Objects.hashCode(this.nome);
        hash = 79 * hash + Objects.hashCode(this.nif);
        hash = 79 * hash + Objects.hashCode(this.telefone);
        hash = 79 * hash + Objects.hashCode(this.endereco);
        hash = 79 * hash + Objects.hashCode(this.habilitacoes);
        hash = 79 * hash + Objects.hashCode(this.reconhecimentos);
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
        final FreeLancer other = (FreeLancer) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.nif, other.nif)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.habilitacoes, other.habilitacoes)) {
            return false;
        }
        if (!Objects.equals(this.reconhecimentos, other.reconhecimentos)) {
            return false;
        }
        return true;
    }
    
    protected static class validaFreelancer {
        private static final String NIF_REGEX = "[0-9]+";
        private static final String TELEFONE_REGEX = "[0-9]+";
        private static final String NOME_REGEX = "[a-zA-ZÀ-ú ]+";
        private static final int NIF_LENGTH = 9;
        private static final int NOME_LENGTH = 50;
        private static final int EMAIL_LENGTH = 254;
        private static final int TELEFONE_LENGTH_MIN = 9;
        private static final int TELEFONE_LENGTH_MAX = 16;
        
        protected static final String NOME_NULL_EXCEPTION = "Nome não pode ser null.";
        protected static final String NIF_NULL_EXCEPTION = "NIF não pode ser null.";
        protected static final String TELEFONE_NULL_EXCEPTION = "Telefone não pode ser null.";
        protected static final String NOME_EMPTY_EXCEPTION = "Nome deve ser preenchido.";
        protected static final String NIF_EMPTY_EXCEPTION = "NIF deve ser preenchido.";
        protected static final String TELEFONE_EMPTY_EXCEPTION = "Telefone deve ser preenchido.";
        protected static final String NOME_REGEX_EXCEPTION = "Nome não pode conter caracteres especiais. (Acentos são suportados)";
        protected static final String NIF_REGEX_EXCEPTION = "NIF pode conter apenas números.";
        protected static final String TELEFONE_REGEX_EXCEPTION = "Telefone pode conter apenas números.";
        protected static final String NOME_MAX_SIZE_EXCEPTION = String.format("Nome do freelancer não pode ultrapassar %d caracteres.", NOME_LENGTH);
        protected static final String TELEFONE_SIZE_EXCEPTION = String.format("Telefone deve ter entre %d e %d algarismos.", TELEFONE_LENGTH_MIN, TELEFONE_LENGTH_MAX);
        protected static final String NIF_SIZE_EXCEPTION = String.format("NIF inválido. Introduza NIF com 9 dígitos.");
        protected static final String EMAIL_NULL_EXCEPTION = "Email não pode ser null.";
        protected static final String EMAIL_INVALID_EXCEPTION = "Email não é válido.";
        protected static final String EMAIL_MAX_SIZE_EXCEPTION = String.format("Email deve ter no máximo %d caracteres.", EMAIL_LENGTH);
        
        public static boolean validaNome(String nome) {
            boolean isNull = false;
            boolean isEmpty = false;
            boolean isGreaterThanMaxSize = false;
            boolean isRegexInvalid = false;

            isNull = nome == null;
            if (isNull) {
                throw new ElementoInvalidoException(NOME_NULL_EXCEPTION);
            }

            isEmpty = nome.trim().isEmpty();
            if (isEmpty) {
                throw new ElementoInvalidoException(NOME_EMPTY_EXCEPTION);
            }

            isGreaterThanMaxSize = nome.length() > NOME_LENGTH;
            if (isGreaterThanMaxSize) {
                throw new ElementoInvalidoException(NOME_MAX_SIZE_EXCEPTION);
            }

            isRegexInvalid = !nome.trim().matches(NOME_REGEX);
            if (isRegexInvalid) {
                throw new ElementoInvalidoException(NOME_REGEX_EXCEPTION);
            }

            return true;
        }
        
        public static boolean validaNif(String nif) {
            boolean isNull = false;
            boolean isEmpty = false;
            boolean isGreaterThanMaxSize = false;
            boolean isRegexInvalid = false;

            isNull = nif == null;
            if (isNull) {
                throw new ElementoInvalidoException(NIF_NULL_EXCEPTION);
            }

            isEmpty = nif.trim().isEmpty();
            if (isEmpty) {
                throw new ElementoInvalidoException(NIF_EMPTY_EXCEPTION);
            }

            isGreaterThanMaxSize = nif.length() > NIF_LENGTH;
            if (isGreaterThanMaxSize) {
                throw new ElementoInvalidoException(NIF_SIZE_EXCEPTION);
            }

            isRegexInvalid = !nif.trim().matches(NIF_REGEX);
            if (isRegexInvalid) {
                throw new ElementoInvalidoException(NIF_REGEX_EXCEPTION);
            }

            return true;
        }
        
        protected static boolean validaEmail(String email) {
            EmailValidator emailValidator = EmailValidator.getInstance();
            boolean isNull = false;
            boolean isGreaterThanMaxLength = false;
            boolean isInvalid = false;
            
            isNull = email == null;
            if (isNull) {
                throw new ElementoInvalidoException(EMAIL_NULL_EXCEPTION);
            }
            
            isGreaterThanMaxLength = email.length() > EMAIL_LENGTH;
            if (isGreaterThanMaxLength) {
                throw new ElementoInvalidoException(EMAIL_MAX_SIZE_EXCEPTION);
            }
            
            isInvalid = !emailValidator.isValid(email);
            if (isInvalid) {
                throw new ElementoInvalidoException(EMAIL_INVALID_EXCEPTION);
            }
            
            return true;
        }
        
        public static boolean validaTelefone(String telefone) {
            boolean isNull = false;
            boolean isEmpty = false;
            boolean isRegexInvalid = false;
            boolean isSizeDifferent = false;

            isNull = telefone == null;
            if (isNull) {
                throw new ElementoInvalidoException(TELEFONE_NULL_EXCEPTION);
            }

            isEmpty = telefone.trim().isEmpty();
            if (isEmpty) {
                throw new ElementoInvalidoException(TELEFONE_EMPTY_EXCEPTION);
            }

            isRegexInvalid = !telefone.matches(TELEFONE_REGEX);
            if (isRegexInvalid) {
                throw new ElementoInvalidoException(TELEFONE_REGEX_EXCEPTION);
            }

            isSizeDifferent = (telefone.length() > TELEFONE_LENGTH_MAX) || (telefone.length() < TELEFONE_LENGTH_MIN);
            if (isSizeDifferent) {
                throw new ElementoInvalidoException(TELEFONE_SIZE_EXCEPTION);
            }

            return true;
        }
    }
}
