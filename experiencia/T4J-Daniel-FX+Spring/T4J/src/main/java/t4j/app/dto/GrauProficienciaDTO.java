package t4j.app.dto;

public class GrauProficienciaDTO {

    /**
     *
     */
    private String id;
    /**
     * Variável de instância - valorGrauProficiencia do grau de proficiência
     */
    private String valor;

    /**
     * Variável de instância - designação do grau de proficiência
     */
    private String designacao;

    /**
     * Construtor vazio de grau de proficiência
     */
    public GrauProficienciaDTO() {
    }

    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @return valorGrauProficiencia do grau de proficiência
     */
    public String getValor() {
        return valor;
    }

    /**
     *
     * @return designação do grau de proficiência
     */
    public String getDesignacao() {
        return designacao;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @param valor especifica um novo valorGrauProficiencia de grau de
     *              proficiência
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     *
     * @param designacao especifica uma nova designação de grau de proficiência
     */
    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (designacao != null && !designacao.isEmpty()) {
            sb.append("").append(valor);
            sb.append(" - ").append(designacao);
            return sb.toString();
        }
        return "";
    }

    public String toString(boolean b) {
        StringBuilder sb = new StringBuilder();
        sb.append("GrauProficienciaDTO{id=").append(id);
        sb.append(", valor=").append(valor);
        sb.append(", designacao=").append(designacao);
        sb.append('}');
        return sb.toString();
    }
}
