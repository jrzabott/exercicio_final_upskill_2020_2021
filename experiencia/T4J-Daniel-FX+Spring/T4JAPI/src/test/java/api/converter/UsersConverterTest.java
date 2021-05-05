package api.converter;

import api.DTO.UsersDTO;
import api.model.Users;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UsersConverterTest {

    private Users u;
    private UsersDTO udto;
    private ArrayList<Users> users;
    private ArrayList<UsersDTO> usersDTO;

    public UsersConverterTest() {
        users = new ArrayList<>();
        usersDTO = new ArrayList<>();
        u = new Users(1L, "testes@teste.pt", "username", "password");
        udto = new UsersDTO();
        udto.setId(1L);
        udto.setEmail("testes@teste.pt");
        udto.setUsername("username");
        udto.setPassword("password");
        users.add(u);
        usersDTO.add(udto);
    }

    /**
     * Test of users2UsersDTO method, of class UsersConverter.
     */
    @Test
    public void testUsers2UsersDTO() {
        System.out.println("users2UsersDTO");
        UsersDTO result = UsersConverter.users2UsersDTO(u);
        assertEquals(udto.toString(), result.toString());
    }

    /**
     * Test of usersDTO2Users method, of class UsersConverter.
     */
    @Test
    public void testUsersDTO2Users() {
        System.out.println("usersDTO2Users");
        Users result = UsersConverter.usersDTO2Users(udto);
        assertEquals(u.toString(), result.toString());
    }

    /**
     * Test of listUsers2ListUsersDTO method, of class UsersConverter.
     */
    @Test
    public void testListUsers2ListUsersDTO() {
        System.out.println("listUsers2ListUsersDTO");
        ArrayList<UsersDTO> result = UsersConverter.listUsers2ListUsersDTO(users);
        assertEquals(usersDTO.contains(udto.toString()), result.contains(udto.toString()));
    }

    /**
     * Test of listUsersDTO2ListUsers method, of class UsersConverter.
     */
    @Test
    public void testListUsersDTO2ListUsers() {
        System.out.println("listUsersDTO2ListUsers");
        ArrayList<Users> result = UsersConverter.listUsersDTO2ListUsers(usersDTO);
        assertEquals(users.contains(u.toString()), result.contains(u.toString()));
    }
}
