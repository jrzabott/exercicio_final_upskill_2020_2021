package api.dao;

import api.model.AppKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AppKeyDAO extends JpaRepository<AppKey, Long> {

//    @Query(value = "SELECT TIMEOUT "
//            + "FROM APPKEY WHERE APP_KEY = :appkey", nativeQuery = true)
//    public Long getTimeoutByAppKey(@Param("appkey") String appKey);
    @Query(value = "SELECT getTimeoutByAppKey(:appkey) from dual", nativeQuery = true)
    public Long getTimeoutByAppKey(@Param("appkey") String appKey);

//    @Query(value = "SELECT COUNT(*) FROM APPKEY WHERE APP_KEY = :appkey", nativeQuery = true)
//    public int countAppKeyByAppKey(@Param("appkey") String appKey);
    @Query(value = "SELECT countAppKeyByAppKey(:appkey) from dual", nativeQuery = true)
    public int countAppKeyByAppKey(@Param("appkey") String appKey);
}
