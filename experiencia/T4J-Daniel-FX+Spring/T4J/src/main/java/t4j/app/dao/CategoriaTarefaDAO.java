package t4j.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import t4j.app.model.CategoriaTarefa;

public interface CategoriaTarefaDAO extends JpaRepository<CategoriaTarefa, String> {

    /**
     *
     * @return
     */
    @Query(nativeQuery = true, value = "SELECT nvel(max(id), 0) + 1 from categoriatarefa")
    long findNextId();

}
