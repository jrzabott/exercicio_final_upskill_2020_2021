package t4j.app.controller;

import t4j.app.service.CategoriaTarefasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import t4j.app.dto.CategoriaTarefaDTO;
import t4j.app.dto.ColaboradorDTO;
import t4j.app.dto.RegistoCategoriasDTO;
import t4j.app.dto.TarefaDTO;
import t4j.app.service.TarefasService;

@Controller
public class UITarefaController {

    @Autowired
    CategoriaTarefasService categoriaTarefasService;

    @Autowired
    TarefasService tarefasService;

    public UITarefaController() {
    }

    public boolean addTarefa(TarefaDTO tdto) {
        return tarefasService.addTarefa(tdto);
    }

    /**
     *
     * @param referencia referência da tarefa
     * @param designacao designação da tarefa
     * @param descricaoInformal descrição infromal da tarefa
     * @param descricaoTecnica descrição técnica da tarefa
     * @param duracaoEstimada duração estimada da tarefa
     * @param custoEstimado custo estimado da tarefa
     * @param categoria categoria da tarefa
     * @param colaborador colaborador da tarefa
     * @return true se foi especificada uma nova tarefa e false se contrário
     */
    public boolean especificarTarefa(String referencia, String designacao,
            String descricaoInformal, String descricaoTecnica,
            String duracaoEstimada, String custoEstimado, CategoriaTarefaDTO categoria, ColaboradorDTO colaborador) {
        boolean result;
        TarefaDTO tdto = new TarefaDTO();
        tdto.setReferencia(referencia);
        tdto.setDesignacao(designacao);
        tdto.setDescricaoInformal(descricaoInformal);
        tdto.setDescricaoTecnica(descricaoTecnica);
        tdto.setDuracaoEstimada(duracaoEstimada);
        tdto.setCustoEstimado(custoEstimado);
        tdto.setCategoria(categoria);
        result = tarefasService.addTarefa(tdto);
        return result;
    }

    public RegistoCategoriasDTO getRegistoCategoriasDTO() {
        return categoriaTarefasService.getRegistoCategorias();
    }
    
//    public TarefaDTO getTarefaByReferencia (String referencia) {
//        TarefaDTO tdto = ts.getTarefaByReferencia(referencia);
//        return tdto;
//    }

    public List<String> tarefasNaoPublicadas(String emailColaborador) {
        List<String> lista = tarefasService.tarefasNaoPublicadas(emailColaborador);
        return lista;
    }
}
