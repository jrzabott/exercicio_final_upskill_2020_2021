package api.dao;

import api.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsersDAO extends JpaRepository<Users, Long> {

    @Query(value = "SELECT ID, EMAIL, PASSWORD, USERNAME "
            + "FROM USERS WHERE ID = :id", nativeQuery = true)
    public Users getUserById(@Param("id") Long id);

    @Query(value = "SELECT ID, EMAIL, PASSWORD, USERNAME "
            + "FROM USERS WHERE USERNAME = :username", nativeQuery = true)
    public Users getUserByUsername(@Param("username") String username);

    @Query(value = "SELECT ID, EMAIL, PASSWORD, USERNAME "
            + "FROM USERS WHERE EMAIL = :email", nativeQuery = true)
    public Users getUserByEmail(@Param("email") String email);

//    @Query(value = "SELECT COUNT(*) FROM USERS WHERE USERNAME = :username", nativeQuery = true)
//    public int countUserByUsername(@Param("username") String username);
    @Query(value = "SELECT countUserByUsername(:username) from dual", nativeQuery = true)
    public int countUserByUsername(@Param("username") String username);

//    @Query(value = "SELECT COUNT(*) FROM USERS WHERE EMAIL = :email", nativeQuery = true)
//    public int countUserByEmail(@Param("email") String email);
    @Query(value = "SELECT countUserByEmail(:email) from dual", nativeQuery = true)
    public int countUserByEmail(@Param("email") String email);

//    @Query(value = "SELECT COUNT(*) FROM USERS WHERE USERNAME = :username AND PASSWORD = :password", nativeQuery = true)
//    public int countUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
    @Query(value = "SELECT countUserByUsernameAndPassword(:username, :password) from dual", nativeQuery = true)
    public int countUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

//    @Query(value = "SELECT COUNT(*) FROM USERS WHERE EMAIL = :email AND PASSWORD = :password", nativeQuery = true)
//    public int countUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);
    @Query(value = "SELECT countUserByEmailAndPassword(:email, :password) from dual", nativeQuery = true)
    public int countUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    @Modifying(clearAutomatically = true)
    @Query(value = "INSERT INTO USERROLES (ID_USER, ID_ROLES) VALUES (:id_user ,:id_roles)", nativeQuery = true)
    public void insertNewUserRole(@Param("id_user") Long id_user, @Param("id_roles") Long id_roles);

    @Modifying(clearAutomatically = true)
    @Query(value = "DELETE FROM USERROLES WHERE ID_USER = :id_user AND ID_ROLES = :id_roles", nativeQuery = true)
    public void deleteUserRoles(@Param("id_user") Long id_user, @Param("id_roles") Long id_roles);
}
