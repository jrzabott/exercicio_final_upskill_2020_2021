package t4j.app.dto;

import java.util.List;

public class FreeLancerDTO {

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private String nome;

    /**
     * 
     */
    private String nif;

    /**
     * 
     */
    private String telefone;

    /**
     * 
     */
    private EnderecoPostalDTO endereco;

    /**
     * 
     */
    private List<HabilitacaoAcademicaDTO> habilitacoes;

    /**
     * 
     */
    private List<ReconhecimentoCTDTO> reconhecimentos;

    /**
     * 
     */
    public FreeLancerDTO() {
        this.endereco = new EnderecoPostalDTO();
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
    public EnderecoPostalDTO getEndereco() {
        return endereco;
    }
    
    /**
     * 
     * @return 
     */
    public List<HabilitacaoAcademicaDTO> getHabilitacoes() {
        return habilitacoes;
    }
    
    /**
     * 
     * @return 
     */
    public List<ReconhecimentoCTDTO> getReconhecimentos() {
        return reconhecimentos;
    }

    /**
     * 
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @param nome 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * 
     * @param nif 
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * 
     * @param telefone 
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * 
     * @param endereco 
     */
    public void setEndereco(EnderecoPostalDTO endereco) {
        this.endereco = endereco;
    }
    
    /**
     * 
     * @param habilitacoes 
     */
    public void setHabilitacoes(List<HabilitacaoAcademicaDTO> habilitacoes) {
        this.habilitacoes = habilitacoes;
    }

    /**
     * 
     * @param reconhecimentos 
     */
    public void setReconhecimentos(List<ReconhecimentoCTDTO> reconhecimentos) {
        this.reconhecimentos = reconhecimentos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FreeLancerDTO{email=").append(email);
        sb.append(", nome=").append(nome);
        sb.append(", nif=").append(nif);
        sb.append(", telefone=").append(telefone);
        sb.append(", endereco=").append(endereco);
        sb.append(", habilitacoes=").append(habilitacoes);
        sb.append(", reconhecimentos=").append(reconhecimentos);
        sb.append('}');
        return sb.toString();
    }
}
