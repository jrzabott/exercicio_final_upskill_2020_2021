package t4j.app.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import t4j.app.model.Anuncio;
import t4j.app.model.Tarefa;

public interface AnuncioDAO extends JpaRepository<Anuncio, String> {

    @Query(value = "SELECT t.REFERENCIA "
            + "FROM tarefa t LEFT JOIN anuncio a ON a.REFERENCIA_TAREFA = t.REFERENCIA "
            + "WHERE a.REFERENCIA_TAREFA IS NULL "
            + "AND t.EMAIL_COLABORADOR = :email", nativeQuery = true)
    public List<String> tarefasNaoPublicadas(@Param("email") String emailColaborador);
    
    
    @Query(value = "SELECT T.REFERENCIA "
            + "FROM ANUNCIO a JOIN TAREFA t ON t.REFERENCIA = a.REFERENCIA_TAREFA "
            + "WHERE SYSDATE BETWEEN A.DATAINICIOCANDIDATURA AND A.DATAFIMCANDIDATURA "
            + "ORDER BY T.REFERENCIA ", nativeQuery = true)
    public List<String> findAnunciosPeriodoCandidatura();
}
