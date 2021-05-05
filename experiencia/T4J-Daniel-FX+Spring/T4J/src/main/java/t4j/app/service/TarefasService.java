package t4j.app.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static t4j.app.converter.TarefaConverter.tarefaDTO2Tarefa;
import t4j.app.dao.AnuncioDAO;
import t4j.app.dao.ColaboradorDAO;
import t4j.app.dao.TarefaDAO;
import t4j.app.dto.TarefaDTO;
import t4j.app.exception.ConversaoException;
import t4j.app.exception.ElementoDuplicadoException;
import t4j.app.model.Colaborador;
import t4j.app.model.Tarefa;

@Service
public class TarefasService {

    /**
     *
     */
    @Autowired
    TarefaDAO tarefaDAO;

    /**
     *
     */
    @Autowired
    AnuncioDAO anuncioDAO;

    @Autowired
    ColaboradorDAO cdao;
    @Autowired
    ColaboradoresService colaboradoresService;

    /**
     *
     */
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

        Optional<Colaborador> cOptional = cdao.findByEmail(tarefaDTO.getEmailColaborador());
        Tarefa tarefa = tarefaDTO2Tarefa(tarefaDTO);
        tarefa.setColaborador(cOptional.get());

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
     * @param emailColaborador
     * @return
     */
    public List<String> tarefasNaoPublicadas(String emailColaborador) {
        List<String> lista = anuncioDAO.tarefasNaoPublicadas(emailColaborador);
        return lista;
    }
}
