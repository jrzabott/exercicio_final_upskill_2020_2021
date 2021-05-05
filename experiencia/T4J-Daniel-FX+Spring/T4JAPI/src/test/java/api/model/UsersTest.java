package api.model;

import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UsersTest {
    
    private Users uc, uv, ucop;
    private Object obj;
    
    public UsersTest() {
        uc = new Users(1L, "teste@teste.pt", "username", "password");
        uv = new Users();
        ucop = new Users(uc);
        obj = new Object();
    }

    /**
     * Test of getId method, of class Users.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Long expResult = 1L;
        assertEquals(expResult, uc.getId());
    }

    /**
     * Test of getEmail method, of class Users.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        String expResult = "teste@teste.pt";
        assertEquals(expResult, uc.getEmail());
    }

    /**
     * Test of getUsername method, of class Users.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        String expResult = "username";
        assertEquals(expResult, uc.getUsername());
    }

    /**
     * Test of getPassword method, of class Users.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        String expResult = "password";
        assertEquals(expResult, uc.getPassword());
    }
    
    /**
     * Test of getRoles method, of class Users.
     */
    @Test
    public void testGetRoles() {
        System.out.println("getRoles");
        Set<Roles> expResult = new HashSet<>();
        assertEquals(expResult, uc.getRoles());
    }

    /**
     * Test of setId method, of class Users.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 1L;
        uv.setId(id);
        assertEquals(id, uv.getId());
    }

    /**
     * Test of setEmail method, of class Users.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "teste@test.pt";
        uv.setEmail(email);
        assertEquals(email, uv.getEmail());
    }

    /**
     * Test of setUsername method, of class Users.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "username";
        uv.setUsername(username);
        assertEquals(username, uv.getUsername());
    }

    /**
     * Test of setPassword method, of class Users.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "password";
        uv.setPassword(password);
        assertEquals(password, uv.getPassword());
    }
    
    /**
     * Test of setRoles method, of class Users.
     */
    @Test
    public void testSetRoles() {
        System.out.println("setRoles");
        Set<Roles> roles = new HashSet<>();
        uv.setRoles(roles);
        assertEquals(roles, uv.getRoles());
    }

    /**
     * Test of toString method, of class Users.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Users{id=1, email=teste@teste.pt, username=username, password=password}";
        String expResultv = "Users{id=null, email=null, username=null, password=null}";
        assertEquals(expResult, uc.toString());
        assertEquals(expResultv, uv.toString());
    }

    /**
     * Test of constructor method, of class Users.
     */
    @Test
    public void testConstructor() {
        System.out.println("constructor");
        Users u1 = new Users(100L, "test@test.com", "user", "pass");
        assertEquals(u1, new Users(100L, "test@test.com", "user", "pass"));
    }
    
    /**
     * Test of hashCode method, of class Users.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        assertEquals(uc.hashCode(), uc.hashCode());
        assertNotEquals(uc.hashCode(), uv.hashCode());
    }

    /**
     * Test of equals method, of class Users.
     */
    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        assertEquals(uc, uc);
        assertEquals(uv, uv);
    }

    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");
        // Testes de sucesso
        assertEquals(uc, ucop);
        assertEquals(ucop, uc);
        // Testes de insucesso
        assertNotEquals(uc, uv);
        assertNotEquals(uv, uc);
    }

    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        assertNotEquals(uc, null);
        assertNotEquals(uv, null);
        assertNotEquals(obj, null);
    }

    @Test
    public void testEqualsCoverage() {
        System.out.println("equals: testa todas as propriedades");

        ucop.setId(2L);
        assertNotEquals(uc, ucop);
        ucop.setId(uc.getId());

        ucop.setEmail("copia@copia.pt");
        assertNotEquals(uc, ucop);
        ucop.setEmail(uc.getEmail());

        ucop.setUsername("users");
        assertNotEquals(uc, ucop);
        ucop.setUsername(uc.getUsername());

        ucop.setPassword("qwerty");
        assertNotEquals(uc, ucop);
        ucop.setPassword(uc.getPassword());

    }

    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: objetos de classes diferentes");
        assertNotEquals(uc, obj);
        assertNotEquals(uv, obj);
        assertNotEquals(ucop, obj);
    }
}
