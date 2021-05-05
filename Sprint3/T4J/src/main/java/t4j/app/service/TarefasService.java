package t4j.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import t4j.app.dao.AnuncioDAO;
import t4j.app.dao.TarefaDAO;
import t4j.app.dto.Mapper;
import t4j.app.dto.RegistoTarefasDTO;
import t4j.app.dto.TarefaDTO;
import t4j.app.exception.ConversaoException;
import t4j.app.exception.ElementoDuplicadoException;
import t4j.app.model.Plataforma;
import t4j.app.model.RegistoTarefas;
import t4j.app.model.Tarefa;
import t4j.app.repo.Dados;

@Service
public class TarefasService {

    @Autowired
    TarefaDAO tarefaDAO;
    @Autowired
    AnuncioDAO anuncioDAO;

    public TarefasService() {
    }

    /**
     *
     * @param tarefaDTO tarefa a ser adicionada
     * @return true se adicionou uma nova tarefa passada por parâmetro e false
     * se contrário
     */
    @Transactional
    public boolean addTarefa(TarefaDTO tarefaDTO) {
        boolean result = false;
        Tarefa tarefa = Mapper.tarefaDTO2Tarefa(tarefaDTO);
        if (tarefa == null) {
            throw new ConversaoException("TarefaDTO");
        }

        Optional<Tarefa> tarefaDB = tarefaDAO.findById(tarefa.getReferencia());
        if (tarefaDB.isPresent()) {
            throw new ElementoDuplicadoException("Tarefa já existe.");
        }
        tarefa = tarefaDAO.save(tarefa);

        return tarefa != null;
    }

    /**
     *
     * @return o registo de tarefas
     */
    public static RegistoTarefasDTO getRegistoTarefas() {
        RegistoTarefasDTO rtdto;
        Plataforma plataforma = Dados.carregarDados();
        RegistoTarefas rt = plataforma.getRegistoTarefas();
        ArrayList<Tarefa> tarefas = rt.getTarefas();
        rtdto = Mapper.listTarefa2TarefaDTO(tarefas);
        return rtdto;
    }

    /**
     *
     * @param referencia referência da tarefa que se pretende obter
     * @return uma tarefa identificada pela sua referência
     */
    public static TarefaDTO getTarefa(String referencia) {
        Plataforma plataforma = Dados.carregarDados();
        Tarefa tarefa = plataforma.getRegistoTarefas().getTarefaByReferencia(referencia);
        if (tarefa == null) {
            return null;
        }
        TarefaDTO tarefaDTO = Mapper.tarefa2TarefaDTO(tarefa);
        if (tarefaDTO != null) {
            return tarefaDTO;
        } else {
            throw new ConversaoException("TarefaDTO");
        }
    }

    /**
     *
     * @param referencia referência da tarefa a ser atualizada
     * @param tarefaDTO tarefa identificada pela sua referência a ser atualizada
     */
    public static void updateTarefa(String referencia, TarefaDTO tarefaDTO) {

        Tarefa tarefa = Mapper.tarefaDTO2Tarefa(tarefaDTO);
        Plataforma plataforma = Dados.carregarDados();
        if (tarefa != null) {
            plataforma.getRegistoTarefas().updateTarefa(referencia, tarefa);
            Dados.guardarDados(plataforma);
        } else {
            throw new ConversaoException("TarefaDTO");
        }
    }

    /**
     *
     * @param referencia referência da tarefa a ser removida
     */
    public static void removeTarefa(String referencia) {
        Plataforma plataforma = Dados.carregarDados();
        plataforma.getRegistoTarefas().removeTarefa(referencia);
        Dados.guardarDados(plataforma);
    }

    public List<String> tarefasNaoPublicadas(String emailColaborador) {
        List<String> lista = anuncioDAO.tarefasNaoPublicadas(emailColaborador);
        return lista;
    }
}
