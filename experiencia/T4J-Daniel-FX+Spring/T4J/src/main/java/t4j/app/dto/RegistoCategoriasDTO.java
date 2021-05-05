package t4j.app.dto;

import java.util.ArrayList;

public class RegistoCategoriasDTO {

    /**
     * Variável de instância - contentor do tipo ArrayList que guarda todas as
     * instâncias do tipo categoria
     */
    private ArrayList<CategoriaTarefaDTO> categorias;

    /**
     * Construtor vazio de lista de categorias
     */
    public RegistoCategoriasDTO() {
    }

    /**
     *
     * @return contentor do tipo ArrayList que guarda todas as instâncias do
     * tipo categoria
     */
    public ArrayList<CategoriaTarefaDTO> getCategorias() {
        return categorias;
    }

    /**
     *
     * @param categorias especifica um novo contentor do tipo ArrayList que
     * guarda todas as instâncias do tipo categoria
     */
    public void setCategorias(ArrayList<CategoriaTarefaDTO> categorias) {
        this.categorias = categorias;
    }
}
