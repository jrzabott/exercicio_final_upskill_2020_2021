package api.DTO;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RolesDTOTest {
    
    RolesDTO rdto;
    
    public RolesDTOTest() {
        rdto = new RolesDTO();
    }

    /**
     * Test of getId method, of class RolesDTO.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Long expResult = null;
        assertEquals(expResult, rdto.getId());
    }

    /**
     * Test of getApp_context method, of class RolesDTO.
     */
    @Test
    public void testGetApp_context() {
        System.out.println("getApp_context");
        String expResult = null;
        assertEquals(expResult, rdto.getApp_context());
    }

    /**
     * Test of getRolename method, of class RolesDTO.
     */
    @Test
    public void testGetRolename() {
        System.out.println("getRolename");
        String expResult = null;
        assertEquals(expResult, rdto.getRolename());
    }

    /**
     * Test of setId method, of class RolesDTO.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 1L;
        rdto.setId(id);
        assertEquals(id , rdto.getId());
    }

    /**
     * Test of setApp_context method, of class RolesDTO.
     */
    @Test
    public void testSetApp_context() {
        System.out.println("setApp_context");
        String app_context = "app_context";
        rdto.setApp_context(app_context);
        assertEquals(app_context , rdto.getApp_context());
    }

    /**
     * Test of setRolename method, of class RolesDTO.
     */
    @Test
    public void testSetRolename() {
        System.out.println("setRolename");
        String rolename = "rolename";
        rdto.setRolename(rolename);
        assertEquals(rolename , rdto.getRolename());
    }

    /**
     * Test of toString method, of class RolesDTO.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "RolesDTO{id=null, rolename=null}";
        assertEquals(expResult, rdto.toString());
    }
}
