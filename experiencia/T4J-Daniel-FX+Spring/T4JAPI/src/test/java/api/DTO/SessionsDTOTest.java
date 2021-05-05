package api.DTO;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SessionsDTOTest {
    
    SessionsDTO sdto;
    
    public SessionsDTOTest() {
        sdto = new SessionsDTO();
    }

    /**
     * Test of getId method, of class SessionsDTO.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Long expResult = null;
        assertEquals(expResult, sdto.getId());
    }

    /**
     * Test of getApp_context method, of class SessionsDTO.
     */
    @Test
    public void testGetApp_context() {
        System.out.println("getApp_context");
        String expResult = null;
        assertEquals(expResult, sdto.getApp_context());
    }

    /**
     * Test of getLogin_date method, of class SessionsDTO.
     */
    @Test
    public void testGetLogin_date() {
        System.out.println("getLogin_date");
        LocalDateTimeDTO expResult = null;
        assertEquals(expResult, sdto.getLogin_date());
    }

    /**
     * Test of getContext_id method, of class SessionsDTO.
     */
    @Test
    public void testGetContext_id() {
        System.out.println("getContext_id");
        Long expResult = null;
        assertEquals(expResult, sdto.getContext_id());
    }

    /**
     * Test of getUser_id method, of class SessionsDTO.
     */
    @Test
    public void testGetUser_id() {
        System.out.println("getUser_id");
        Long expResult = null;
        assertEquals(expResult, sdto.getUser_id());
    }

    /**
     * Test of setId method, of class SessionsDTO.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 1L;
        sdto.setId(id);
        assertEquals(id, sdto.getId());
    }

    /**
     * Test of setApp_context method, of class SessionsDTO.
     */
    @Test
    public void testSetApp_context() {
        System.out.println("setApp_context");
        String app_context = "app_context";
        sdto.setApp_context(app_context);
        assertEquals(app_context, sdto.getApp_context());
    }

    /**
     * Test of setLogin_date method, of class SessionsDTO.
     */
    @Test
    public void testSetLogin_date() {
        System.out.println("setLogin_date");
        LocalDateTimeDTO login_date = null;
        sdto.setLogin_date(login_date);
        assertEquals(login_date, sdto.getLogin_date());
    }

    /**
     * Test of setContext_id method, of class SessionsDTO.
     */
    @Test
    public void testSetContext_id() {
        System.out.println("setContext_id");
        Long context_id = 1L;
        sdto.setContext_id(context_id);
        assertEquals(context_id, sdto.getContext_id());
    }

    /**
     * Test of setUser_id method, of class SessionsDTO.
     */
    @Test
    public void testSetUser_id() {
        System.out.println("setUser_id");
        Long user_id = 1L;
        sdto.setUser_id(user_id);
        assertEquals(user_id, sdto.getUser_id());
    }

    /**
     * Test of toString method, of class SessionsDTO.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "SessionsDTO{id=null, login_date=null, context_id=null, user_id=null}";
        assertEquals(expResult, sdto.toString());
    }
}
