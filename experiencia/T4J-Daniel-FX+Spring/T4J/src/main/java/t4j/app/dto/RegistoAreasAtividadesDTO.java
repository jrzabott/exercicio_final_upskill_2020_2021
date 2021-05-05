package t4j.app.dto;

import java.util.ArrayList;

public class RegistoAreasAtividadesDTO {

    /**
     * Variável de instância - contentor do tipo ArrayList que guarda todas as
     * instâncias do tipo área de atividade
     */
    private ArrayList<AreaAtividadeDTO> atividades;

    /**
     * Construtor vazio de lista de áreas de atividade
     */
    public RegistoAreasAtividadesDTO() {
        this.atividades = new ArrayList<>();
    }

    /**
     *
     * @return contentor do tipo ArrayList que guarda todas as instâncias do
     * tipo área de atividade
     */
    public ArrayList<AreaAtividadeDTO> getAtividades() {
        return atividades;
    }

    /**
     *
     * @param atividades especifica um novo contentor do tipo ArrayList que
     * guarda todas as instâncias do tipo área de atividade
     */
    public void setAtividades(ArrayList<AreaAtividadeDTO> atividades) {
        this.atividades = atividades;
    }
}
