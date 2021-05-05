package api.DTO;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AppKeyDTOTest {
    
    AppKeyDTO akdto;
    
    public AppKeyDTOTest() {
        akdto = new AppKeyDTO();
    }

    /**
     * Test of getId method, of class AppKeyDTO.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Long expResult = null;
        assertEquals(expResult, akdto.getId());
    }

    /**
     * Test of getAppKey method, of class AppKeyDTO.
     */
    @Test
    public void testGetAppKey() {
        System.out.println("getAppKey");
        String expResult = null;
        assertEquals(expResult, akdto.getAppKey());
    }

    /**
     * Test of getDescricao method, of class AppKeyDTO.
     */
    @Test
    public void testGetDescricao() {
        System.out.println("getDescricao");
        String expResult = null;
        assertEquals(expResult, akdto.getDescricao());
    }

    /**
     * Test of getTimeout method, of class AppKeyDTO.
     */
    @Test
    public void testGetTimeout() {
        System.out.println("getTimeout");
        Long expResult = null;
        assertEquals(expResult, akdto.getTimeout());
    }

    /**
     * Test of setId method, of class AppKeyDTO.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 1L;
        akdto.setId(id);
        assertEquals(id, akdto.getId());
    }

    /**
     * Test of setAppKey method, of class AppKeyDTO.
     */
    @Test
    public void testSetAppKey() {
        System.out.println("setAppKey");
        String appKey = "appKey";
        akdto.setAppKey(appKey);
        assertEquals(appKey, akdto.getAppKey());
    }

    /**
     * Test of setDescricao method, of class AppKeyDTO.
     */
    @Test
    public void testSetDescricao() {
        System.out.println("setDescricao");
        String descricao = "descricao";
        akdto.setDescricao(descricao);
        assertEquals(descricao, akdto.getDescricao());
    }

    /**
     * Test of setTimeout method, of class AppKeyDTO.
     */
    @Test
    public void testSetTimeout() {
        System.out.println("setTimeout");
        Long timeout = 1L;
        akdto.setTimeout(timeout);
        assertEquals(timeout, akdto.getTimeout());
    }

    /**
     * Test of toString method, of class AppKeyDTO.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "AppKeyDTO{id=null, appKey=null, descricao=null, timeout=null}";
        assertEquals(expResult, akdto.toString());
    }
}
