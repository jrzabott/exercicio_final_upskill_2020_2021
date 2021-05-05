package api.DTO;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UsersDTOTest {
    
    UsersDTO udto;
    
    public UsersDTOTest() {
        udto = new UsersDTO();
    }

    /**
     * Test of getId method, of class UsersDTO.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Long expResult = null;
        assertEquals(expResult, udto.getId());
    }

    /**
     * Test of getApp_context method, of class UsersDTO.
     */
    @Test
    public void testGetApp_context() {
        System.out.println("getApp_context");
        String expResult = null;
        assertEquals(expResult, udto.getApp_context());
    }

    /**
     * Test of getEmail method, of class UsersDTO.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        String expResult = null;
        assertEquals(expResult, udto.getEmail());
    }

    /**
     * Test of getUsername method, of class UsersDTO.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        String expResult = null;
        assertEquals(expResult, udto.getUsername());
    }

    /**
     * Test of getPassword method, of class UsersDTO.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        String expResult = null;
        assertEquals(expResult, udto.getPassword());
    }

    /**
     * Test of getRolenames method, of class UsersDTO.
     */
    @Test
    public void testGetRolenames() {
        System.out.println("getRolenames");
        String expResult = null;
        assertEquals(expResult, udto.getRolenames());
    }

    /**
     * Test of setId method, of class UsersDTO.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 1L;
        udto.setId(id);
        assertEquals(id, udto.getId());
    }

    /**
     * Test of setApp_context method, of class UsersDTO.
     */
    @Test
    public void testSetApp_context() {
        System.out.println("setApp_context");
        String app_context = "app_context";
        udto.setApp_context(app_context);
        assertEquals(app_context, udto.getApp_context());
    }

    /**
     * Test of setEmail method, of class UsersDTO.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "email";
        udto.setEmail(email);
        assertEquals(email, udto.getEmail());
    }

    /**
     * Test of setUsername method, of class UsersDTO.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "username";
        udto.setUsername(username);
        assertEquals(username, udto.getUsername());
    }

    /**
     * Test of setPassword method, of class UsersDTO.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "password";
        udto.setPassword(password);
        assertEquals(password, udto.getPassword());
    }

    /**
     * Test of setRolenames method, of class UsersDTO.
     */
    @Test
    public void testSetRolenames() {
        System.out.println("setRolenames");
        String rolenames = "rolenames";
        udto.setRolenames(rolenames);
        assertEquals(rolenames, udto.getRolenames());
    }

    /**
     * Test of toString method, of class UsersDTO.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "UsersDTO{id=null, email=null, username=null, password=null}";
        assertEquals(expResult, udto.toString());
    }
}
