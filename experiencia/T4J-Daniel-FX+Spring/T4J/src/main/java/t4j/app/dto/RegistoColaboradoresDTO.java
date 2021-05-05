package t4j.app.dto;

import java.util.ArrayList;

public class RegistoColaboradoresDTO {

    /**
     * Variável de instância - contentor do tipo ArrayList que guarda todas as
     * instâncias do tipo colaborador
     */
    private ArrayList<ColaboradorDTO> colaboradores;

    /**
     * Construtor vazio de lista de colaboradores
     */
    public RegistoColaboradoresDTO() {
    }

    /**
     *
     * @return contentor do tipo ArrayList que guarda todas as instâncias do
     * tipo colaborador
     */
    public ArrayList<ColaboradorDTO> getColaboradores() {
        return this.colaboradores;
    }

    /**
     *
     * @param colaboradores especifica um novo contentor do tipo ArrayList que
     * guarda todas as instâncias do tipo colaborador
     */
    public void setColaboradores(ArrayList<ColaboradorDTO> colaboradores) {
        this.colaboradores = colaboradores;
    }
}
