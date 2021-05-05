package t4j.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import t4j.app.model.Tarefa;

public interface TarefaDAO extends JpaRepository<Tarefa, String> {

}
