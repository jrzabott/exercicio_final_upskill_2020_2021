package api.DTO;

import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GetSessionDTOTest {
    
    GetSessionDTO gsdto;
    
    public GetSessionDTOTest() {
        gsdto = new GetSessionDTO();
    }

    /**
     * Test of getApp_context method, of class GetSessionDTO.
     */
    @Test
    public void testGetApp_context() {
        System.out.println("getApp_context");
        String expResult = null;
        assertEquals(expResult, gsdto.getApp_context());
    }

    /**
     * Test of getEmail method, of class GetSessionDTO.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        String expResult = null;
        assertEquals(expResult, gsdto.getEmail());
    }

    /**
     * Test of getUsername method, of class GetSessionDTO.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        String expResult = null;
        assertEquals(expResult, gsdto.getUsername());
    }

    /**
     * Test of getRolenames method, of class GetSessionDTO.
     */
    @Test
    public void testGetRolenames() {
        System.out.println("getRolenames");
        String expResult = null;
        assertEquals(expResult, gsdto.getRolenames());
    }

    /**
     * Test of getLogin_date method, of class GetSessionDTO.
     */
    @Test
    public void testGetLogin_date() {
        System.out.println("getLogin_date");
        LocalDateTime expResult = null;
        assertEquals(expResult, gsdto.getLogin_date());
    }

    /**
     * Test of setApp_context method, of class GetSessionDTO.
     */
    @Test
    public void testSetApp_context() {
        System.out.println("setApp_context");
        String app_context = "app_context";
        gsdto.setApp_context(app_context);
        assertEquals(app_context, gsdto.getApp_context());
    }

    /**
     * Test of setEmail method, of class GetSessionDTO.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "email";
        gsdto.setEmail(email);
        assertEquals(email, gsdto.getEmail());
    }

    /**
     * Test of setUsername method, of class GetSessionDTO.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "username";
        gsdto.setUsername(username);
        assertEquals(username, gsdto.getUsername());
    }

    /**
     * Test of setRolenames method, of class GetSessionDTO.
     */
    @Test
    public void testSetRolenames() {
        System.out.println("setRolenames");
        String rolenames = "rolenames";
        gsdto.setRolenames(rolenames);
        assertEquals(rolenames, gsdto.getRolenames());
    }

    /**
     * Test of setLogin_date method, of class GetSessionDTO.
     */
    @Test
    public void testSetLogin_date() {
        System.out.println("setLogin_date");
        LocalDateTime login_date = LocalDateTime.now();
        gsdto.setLogin_date(login_date);
        assertEquals(login_date, gsdto.getLogin_date());
    }
}
