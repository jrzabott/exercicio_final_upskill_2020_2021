package api.dao;

import api.model.Sessions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SessionsDAO extends JpaRepository<Sessions, Long> {

    @Query(value = "SELECT ID, LOGIN_DATE, ID_CONTEXT, ID_USER "
            + "FROM SESSIONS WHERE ID_CONTEXT = :idcontext", nativeQuery = true)
    public Sessions getSessionsByIdContext(@Param("idcontext") Long idContext);

//    @Query(value = "SELECT COUNT(*) FROM SESSIONS WHERE ID_CONTEXT = :idcontext", nativeQuery = true)
//    public int checkIfSessionIsValid(@Param("idcontext") Long idcontext);
    @Query(value = "SELECT checkIfSessionIsValid(:idcontext) from dual", nativeQuery = true)
    public int checkIfSessionIsValid(@Param("idcontext") Long idcontext);
}
