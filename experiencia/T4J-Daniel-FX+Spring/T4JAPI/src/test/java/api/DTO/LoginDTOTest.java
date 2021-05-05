package api.DTO;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LoginDTOTest {
    
    private LoginDTO ldto;
    
    public LoginDTOTest() {
        ldto = new LoginDTO();
    }

    /**
     * Test of getApp_context method, of class LoginDTO.
     */
    @Test
    public void testGetApp_context() {
        System.out.println("getApp_context");
        String expResult = null;
        assertEquals(expResult, ldto.getApp_context());
    }

    /**
     * Test of getUser_id method, of class LoginDTO.
     */
    @Test
    public void testGetUser_id() {
        System.out.println("getUser_id");
        String expResult = null;
        assertEquals(expResult, ldto.getUser_id());
    }

    /**
     * Test of getPassword method, of class LoginDTO.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        String expResult = null;
        assertEquals(expResult, ldto.getPassword());
    }

    /**
     * Test of setApp_context method, of class LoginDTO.
     */
    @Test
    public void testSetApp_context() {
        System.out.println("setApp_context");
        String app_context = "app_context";
        ldto.setApp_context(app_context);
        assertEquals(app_context, ldto.getApp_context());
    }

    /**
     * Test of setUser_id method, of class LoginDTO.
     */
    @Test
    public void testSetUser_id() {
        System.out.println("setUser_id");
        String user_id = "user_id";
        ldto.setUser_id(user_id);
        assertEquals(user_id, ldto.getUser_id());
    }

    /**
     * Test of setPassword method, of class LoginDTO.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "password";
        ldto.setPassword(password);
        assertEquals(password, ldto.getPassword());
    }
}
