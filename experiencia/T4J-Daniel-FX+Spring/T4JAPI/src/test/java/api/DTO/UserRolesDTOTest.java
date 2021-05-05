package api.DTO;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserRolesDTOTest {
    
    private UserRolesDTO urdto;
    
    public UserRolesDTOTest() {
        urdto = new UserRolesDTO();
    }

    /**
     * Test of getApp_context method, of class UserRolesDTO.
     */
    @Test
    public void testGetApp_context() {
        System.out.println("getApp_context");
        String expResult = null;
        assertEquals(expResult, urdto.getApp_context());
    }

    /**
     * Test of getUser_id method, of class UserRolesDTO.
     */
    @Test
    public void testGetUser_id() {
        System.out.println("getUser_id");
        String expResult = null;
        assertEquals(expResult, urdto.getUser_id());
    }

    /**
     * Test of getRolenames method, of class UserRolesDTO.
     */
    @Test
    public void testGetRolenames() {
        System.out.println("getRolenames");
        String expResult = null;
        assertEquals(expResult, urdto.getRolenames());
    }

    /**
     * Test of setApp_context method, of class UserRolesDTO.
     */
    @Test
    public void testSetApp_context() {
        System.out.println("setApp_context");
        String app_context = "app_context";
        urdto.setApp_context(app_context);
        assertEquals(app_context, urdto.getApp_context());
    }

    /**
     * Test of setUser_id method, of class UserRolesDTO.
     */
    @Test
    public void testSetUser_id() {
        System.out.println("setUser_id");
        String user_id = "user_id";
        urdto.setUser_id(user_id);
        assertEquals(user_id, urdto.getUser_id());
    }

    /**
     * Test of setRolenames method, of class UserRolesDTO.
     */
    @Test
    public void testSetRolenames() {
        System.out.println("setRolenames");
        String rolenames = "rolenames";
        urdto.setRolenames(rolenames);
        assertEquals(rolenames, urdto.getRolenames());
    }
}
