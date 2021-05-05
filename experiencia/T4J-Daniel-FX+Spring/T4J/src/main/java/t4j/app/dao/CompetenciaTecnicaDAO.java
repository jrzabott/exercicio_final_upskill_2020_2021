package t4j.app.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import t4j.app.model.CompetenciaTecnica;

public interface CompetenciaTecnicaDAO extends JpaRepository<CompetenciaTecnica, String> {

    /**
     *
     * @return
     */
    @Query(value = "Select c.codigo from competenciatecnica c", nativeQuery = true)
    public List<String> getAllCompetenciasTecnicasIDs();
}
