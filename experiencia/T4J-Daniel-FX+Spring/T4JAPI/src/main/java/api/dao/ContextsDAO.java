package api.dao;

import api.model.Contexts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContextsDAO extends JpaRepository<Contexts, Long> {

//    @Query(value = "SELECT VALIDO FROM CONTEXTS "
//            + "WHERE CONTEXT = :appContext", nativeQuery = true)
//    public String checkIfContextIsValid(@Param("appContext") String appContext);
    @Query(value = "SELECT checkIfContextIsValid(:app_context) from dual", nativeQuery = true)
    public String checkIfContextIsValid(@Param("app_context") String app_context);

    @Query(value = "SELECT RandomUUID() from dual", nativeQuery = true)
    public String createContext();

    @Query(value = "SELECT ID, CONTEXT, DATA_CRIACAO, VALIDO "
            + "FROM CONTEXTS WHERE CONTEXT = :app_context", nativeQuery = true)
    public Contexts getContextByContext(@Param("app_context") String app_context);

//    @Query(value = "SELECT ID "
//            + "FROM CONTEXTS WHERE CONTEXT = :app_context", nativeQuery = true)
//    public Long getIdByContext(@Param("app_context") String app_context);
    @Query(value = "SELECT getIdByContext(:app_context) from dual", nativeQuery = true)
    public Long getIdByContext(@Param("app_context") String app_context);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE CONTEXTS SET VALIDO = 'N' "
            + "WHERE CONTEXT = :app_context", nativeQuery = true)
    public void invalidateContext(@Param("app_context") String app_context);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE CONTEXTS SET VALIDO = 'N' "
            + "WHERE ID = :id", nativeQuery = true)
    public void invalidateContext(@Param("id") Long id);
}
