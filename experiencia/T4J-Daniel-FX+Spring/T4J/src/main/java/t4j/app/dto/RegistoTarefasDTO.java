package t4j.app.dto;

import java.util.ArrayList;

public class RegistoTarefasDTO {

    /**
     * Variável de instância - contentor do tipo ArrayList que guarda todas as
     * instâncias do tipo tarefa
     */
    private ArrayList<TarefaDTO> tarefas;

    /**
     * Construtor vazio de lista de tarefas
     */
    public RegistoTarefasDTO() {
    }

    /**
     *
     * @return contentor do tipo ArrayList que guarda todas as instâncias do
     * tipo tarefa
     */
    public ArrayList<TarefaDTO> getTarefas() {
        return tarefas;
    }

    /**
     *
     * @param tarefas especifica um novo contentor do tipo ArrayList que guarda
     * todas as instâncias do tipo tarefa
     */
    public void setTarefas(ArrayList<TarefaDTO> tarefas) {
        this.tarefas = tarefas;
    }
}
