package t4j.app.dto;

import java.util.ArrayList;

public class RegistoOrganizacoesDTO {

    /**
     * Variável de instância - contentor do tipo ArrayList que guarda todas as
     * instâncias do tipo organização
     */
    private ArrayList<OrganizacaoDTO> organizacoes;

    /**
     * Construtor vazio de registo de organização
     */
    public RegistoOrganizacoesDTO() {
    }

    /**
     *
     * @return contentor do tipo ArrayList que guarda todas as instâncias do
     * tipo organização
     */
    public ArrayList<OrganizacaoDTO> getOrganizacoes() {
        return organizacoes;
    }

    /**
     *
     * @param organizacoes especifica uma novo contentor do tipo ArrayList que
     * guarda todas as instâncias do tipo organização
     */
    public void setOrganizacoes(ArrayList<OrganizacaoDTO> organizacoes) {
        this.organizacoes = organizacoes;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (OrganizacaoDTO org : organizacoes) {
            sb.append(org.toString()).append("\n");
        }
        return sb.toString();
    }

    /**
     *
     * @return
     */
    public String toShortString() {
        StringBuilder sb = new StringBuilder();
        for (OrganizacaoDTO org : organizacoes) {
            sb.append(org.toShortString()).append("\n");
        }
        return sb.toString();
    }
}
