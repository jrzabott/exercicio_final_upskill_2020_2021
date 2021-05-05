package api.dao;

import api.model.Roles;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RolesDAO extends JpaRepository<Roles, Long> {

    @Query(value = "SELECT ID, DESCRICAO "
            + "FROM ROLES WHERE TRIM(UPPER(DESCRICAO)) = TRIM(UPPER(:descricao))", nativeQuery = true)
    public Roles getRoleByDescricao(@Param("descricao") String descricao);

//    @Query(value = "SELECT COUNT(*) FROM ROLES WHERE TRIM(UPPER(DESCRICAO)) = TRIM(UPPER(:descricao))", nativeQuery = true)
//    public int countRoleByDescricao(@Param("descricao") String descricao);
    @Query(value = "SELECT countRoleByDescricao(:descricao) from dual", nativeQuery = true)
    public int countRoleByDescricao(@Param("descricao") String descricao);

//    @Query(value = "SELECT listagg(r.DESCRICAO,', ') WITHIN GROUP(ORDER BY r.DESCRICAO) CSV "
//            + "FROM USERROLES u , ROLES r "
//            + "WHERE u.ID_ROLES = r.ID "
//            + "AND u.ID_USER = :userid", nativeQuery = true)
//    public String getRolesByUserId(@Param("userid") Long userid);
    @Query(value = "SELECT getRolesByUserId(:userid) from dual", nativeQuery = true)
    public String getRolesByUserId(@Param("userid") Long userid);

    @Query(value = "SELECT r.DESCRICAO "
            + "FROM ROLES r LEFT JOIN USERROLES u ON r.ID = u.ID_ROLES "
            + "WHERE u.ID_USER = :userid", nativeQuery = true)
    public ArrayList<String> getUserRolesByUserId(@Param("userid") Long userid);
}
