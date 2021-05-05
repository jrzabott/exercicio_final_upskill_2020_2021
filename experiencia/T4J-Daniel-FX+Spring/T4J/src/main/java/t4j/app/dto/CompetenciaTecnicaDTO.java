package t4j.app.dto;

import java.util.ArrayList;

public class CompetenciaTecnicaDTO {

    /**
     * Variável de instância - código da competência técnica
     */
    private String codigoCompetenciaTecnica;

    /**
     * Variável de instância - descrição breve da competência técnica
     */
    private String descricaoBreve;

    /**
     * Variável de instância - descrição detalhada da competência técnica
     */
    private String descricaoDetalhada;

    /**
     * Variável de instância - área de atividade
     */
    private AreaAtividadeDTO areaAtividade;

    /**
     * Variável de instância - lista de graus de proficiência
     */
    private ArrayList<GrauProficienciaDTO> grausProficiencia;

    /**
     * Construtor de competência técnica
     */
    public CompetenciaTecnicaDTO() {
        this.areaAtividade = new AreaAtividadeDTO();
        this.grausProficiencia = new ArrayList<>();
    }

    /**
     *
     * @return código da competência técnica
     */
    public String getCodigoCompetenciaTecnica() {
        return codigoCompetenciaTecnica;
    }

    /**
     *
     * @return descrição breve da competência técnica
     */
    public String getDescricaoBreve() {
        return descricaoBreve;
    }

    /**
     *
     * @return descrição detalhada da competência técnica
     */
    public String getDescricaoDetalhada() {
        return descricaoDetalhada;
    }

    /**
     *
     * @return área de atividade
     */
    public AreaAtividadeDTO getAreaAtividade() {
        return areaAtividade;
    }

    /**
     *
     * @return lista de graus de proficiência
     */
    public ArrayList<GrauProficienciaDTO> getGrausProficiencia() {
        return grausProficiencia;
    }

    /**
     *
     * @param codigoCompetenciaTecnica especifica um novo código da competência técnica
     */
    public void setCodigoCompetenciaTecnica(String codigoCompetenciaTecnica) {
        this.codigoCompetenciaTecnica = codigoCompetenciaTecnica;
    }

    /**
     *
     * @param descricaoBreve especifica uma nova descrição breve da competência técnica
     */
    public void setDescricaoBreve(String descricaoBreve) {
        this.descricaoBreve = descricaoBreve;
    }

    /**
     *
     * @param descricaoDetalhada especifica uma nova descrição detalhada da competência técnica
     */
    public void setDescricaoDetalhada(String descricaoDetalhada) {
        this.descricaoDetalhada = descricaoDetalhada;
    }

    /**
     *
     * @param areaAtividade especifica uma nova área de atividade
     */
    public void setAreaAtividade(AreaAtividadeDTO areaAtividade) {
        this.areaAtividade = areaAtividade;
    }

    /**
     *
     * @param grausProficiencia especifica uma nova lista de graus de proficiência
     */
    public void setGrausProficiencia(ArrayList<GrauProficienciaDTO> grausProficiencia) {
        this.grausProficiencia = grausProficiencia;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CompetenciaTecnicaDTO{codigoCompetenciaTecnica=").append(codigoCompetenciaTecnica);
        sb.append(", descricaoBreve=").append(descricaoBreve);
        sb.append(", descricaoDetalhada=").append(descricaoDetalhada);
        sb.append(", areaAtividade=").append(areaAtividade);
        sb.append(", grausProficiencia=").append(grausProficiencia);
        sb.append('}');
        return sb.toString();
    }
}
