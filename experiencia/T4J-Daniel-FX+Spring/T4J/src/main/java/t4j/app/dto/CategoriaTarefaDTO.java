package t4j.app.dto;

import java.util.ArrayList;

public class CategoriaTarefaDTO {

    /**
     *
     */
    private String idCategoria;

    /**
     *
     */
    private String descricao;

    /**
     *
     */
    private AreaAtividadeDTO areaAtividade;

    /**
     *
     */
    private ArrayList<CaraterCompetenciaTecnicaDTO> caraterCompetenciaTecnica;

    /**
     *
     */
    public CategoriaTarefaDTO() {
        this.idCategoria = "";
        this.descricao = "";
        this.areaAtividade = new AreaAtividadeDTO();
        this.caraterCompetenciaTecnica = new ArrayList<>();
    }

    /**
     *
     * @return
     */
    public String getIdCategoria() {
        return idCategoria;
    }

    /**
     *
     * @return
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     *
     * @return
     */
    public AreaAtividadeDTO getAreaAtividade() {
        return areaAtividade;
    }

    /**
     *
     * @return
     */
    public ArrayList<CaraterCompetenciaTecnicaDTO> getCaraterCompetenciaTecnica() {
        return caraterCompetenciaTecnica;
    }

    /**
     *
     * @param idCategoria
     */
    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     *
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     *
     * @param areaAtividade
     */
    public void setAreaAtividade(AreaAtividadeDTO areaAtividade) {
        this.areaAtividade = areaAtividade;
    }

    /**
     *
     * @param caraterCompetenciaTecnica
     */
    public void setCaraterCompetenciaTecnica(ArrayList<CaraterCompetenciaTecnicaDTO> caraterCompetenciaTecnica) {
        this.caraterCompetenciaTecnica = caraterCompetenciaTecnica;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CategoriaTarefaDTO{idCategoria=").append(idCategoria);
        sb.append(", descricao=").append(descricao);
        sb.append(", areaAtividade=").append(areaAtividade);
        sb.append(", caraterCompetenciaTecnica=").append(caraterCompetenciaTecnica);
        sb.append('}');
        return sb.toString();
    }
}
