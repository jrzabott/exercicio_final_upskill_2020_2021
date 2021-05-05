package t4j.app.converter;

import java.util.ArrayList;
import java.util.List;
import static t4j.app.converter.ColaboradorConverter.colaboradorDTO2Colaborador;
import t4j.app.dto.CategoriaTarefaDTO;
import t4j.app.dto.RegistoTarefasDTO;
import t4j.app.dto.TarefaDTO;
import t4j.app.model.CategoriaTarefa;
import t4j.app.model.Colaborador;
import t4j.app.model.Tarefa;
import static t4j.app.converter.CategoriaTarefaConverter.categoriaTarefaDTO2CategoriaTarefa;
import static t4j.app.converter.CategoriaTarefaConverter.categoriaTarefa2CategoriaTarefaDTO;

public class TarefaConverter {

    /**
     *
     * @param tarefas
     * @return
     * @throws NullPointerException
     */
    public static List<TarefaDTO> listTarefa2ListTarefaDTO(List<Tarefa> tarefas) throws NullPointerException {
        List<TarefaDTO> tarefasDTO = new ArrayList<>();
        for (Tarefa tarefa : tarefas) {
            try {
                TarefaDTO tarefaDTO = tarefa2TarefaDTO(tarefa);
                tarefasDTO.add(tarefaDTO);
            } catch (NullPointerException e) {
                //does nothing. Actually, nothing is added to arraylist
            }
        }
        return tarefasDTO;
    }

    /**
     *
     * @param tarefa
     * @return
     * @throws NullPointerException
     */
    public static TarefaDTO tarefa2TarefaDTO(Tarefa tarefa) throws NullPointerException {
        TarefaDTO tdto = new TarefaDTO();
        tdto.setReferencia(tarefa.getReferencia());
        tdto.setDesignacao(tarefa.getDesignacao());
        tdto.setDescricaoInformal(tarefa.getDescricaoInformal());
        tdto.setDescricaoTecnica(tarefa.getDescricaoTecnica());
        tdto.setDuracaoEstimada(tarefa.getDuracaoEstimada());
        tdto.setCustoEstimado(tarefa.getCustoEstimado().toString());
        CategoriaTarefaDTO categoriaDTO = categoriaTarefa2CategoriaTarefaDTO(tarefa.getCategoria());
        tdto.setCategoria(categoriaDTO);
        tdto.setEmailColaborador(tarefa.getEmailColaborador());
        tdto.setNifOrganizacao(tarefa.getNifOrganizacao());
        return tdto;
    }

    /**
     *
     * @param tarefaDTO
     * @return
     * @throws NullPointerException
     */
    public static Tarefa tarefaDTO2Tarefa(TarefaDTO tarefaDTO) throws NullPointerException {
        Tarefa tarefa = null;
        CategoriaTarefa categoria = categoriaTarefaDTO2CategoriaTarefa(tarefaDTO. getCategoria());
        // 20210309 - 12:32 - Daniel Junior
        // COLABORADOR REMOVIDO POIS SERÁ INSERIDO MANUALMENTE NA CAMADA DO SERVICE.
//        Colaborador colaborador = colaboradorDTO2Colaborador(tarefaDTO.getColaborador());
        tarefa = new Tarefa();
        tarefa.setCategoria(categoria);
        tarefa.setCustoEstimado(Double.parseDouble(tarefaDTO.getCustoEstimado()));
        tarefa.setDescricaoInformal(tarefaDTO.getDescricaoInformal());
        tarefa.setDescricaoTecnica(tarefaDTO.getDescricaoTecnica());
        tarefa.setDesignacao(tarefaDTO.getDesignacao());
        tarefa.setDuracaoEstimada(tarefaDTO.getDuracaoEstimada());
        tarefa.setReferencia(tarefaDTO.getReferencia());
        tarefa.setEmailColaborador(tarefaDTO.getEmailColaborador());
        tarefa.setNifOrganizacao(tarefaDTO.getNifOrganizacao());
        return tarefa;
    }
}
