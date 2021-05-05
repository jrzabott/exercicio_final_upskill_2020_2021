package t4j.app.dto;

public class AreaAtividadeDTO {

    /**
     * Variável de instância - código da área de atividade
     */
    private String codigo;

    /**
     * Variável de instância - descrição breve da área de atividade
     */
    private String descBreve;

    /**
     * Variável de instância - descrição detalhada da área de atividade
     */

    private String descDetalhada;

    /**
     * Contrutor vazio da área de atividade
     */
    public AreaAtividadeDTO() {
    }

    /**
     *
     * @return código da área de atividade
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     *
     * @return - descrição breve da área de atividade
     */
    public String getDescBreve() {
        return descBreve;
    }

    /**
     *
     * @return - descrição detalhada da área de atividade
     */
    public String getDescDetalhada() {
        return descDetalhada;
    }

    /**
     *
     * @param codigo especifica um novo código da área de atividade
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @param descBreve especifica uma nova descrição breve da área de atividade
     */
    public void setDescBreve(String descBreve) {
        this.descBreve = descBreve;
    }

    /**
     *
     * @param descDetalhada especifica uma nova descrição detalhada da área de atividade
     */
    public void setDescDetalhada(String descDetalhada) {
        this.descDetalhada = descDetalhada;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AreaAtividadeDTO{codigo=").append(codigo);
        sb.append(", descBreve=").append(descBreve);
        sb.append(", descDetalhada=").append(descDetalhada);
        sb.append('}');
        return sb.toString();
    }
}
