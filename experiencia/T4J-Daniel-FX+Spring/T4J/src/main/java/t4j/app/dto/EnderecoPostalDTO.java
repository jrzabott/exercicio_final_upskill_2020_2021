package t4j.app.dto;

public class EnderecoPostalDTO {

    /**
     *
     */
    private Long id;

    /**
     * Variável de instância - morada
     */
    private String morada;

    /**
     * Variável de instância - código postal
     */
    private String codigoPostal;

    /**
     * Variável de instância - localidade
     */
    private String localidade;

    /**
     * Construtor vazio de endereço postal
     */
    public EnderecoPostalDTO() {
    }

    /**
     *
     * @return
     */
    public String getCodigoPostal() {
        return codigoPostal;
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
    public String getCodPostal() {
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
     * @param codigoPostal
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
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
    public void setMorada(String morada) {
        this.morada = morada;
    }

    /**
     *
     * @param codigoPostal especifica um novo código postal do endereço postal
     */
    public void setCodPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     *
     * @param localidade especifica uma nova localidade do endereço postal
     */
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EnderecoPostalDTO{id=").append(id);
        sb.append(", morada=").append(morada);
        sb.append(", codigoPostal=").append(codigoPostal);
        sb.append(", localidade=").append(localidade);
        sb.append('}');
        return sb.toString();
    }
}
