package api.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AppKeyTest {
    
    private AppKey apc, apv, apcop;
    private Object obj;
    
    public AppKeyTest() {
        apc = new AppKey(1L, "appKey", "descricao", 1L);
        apv = new AppKey();
        apcop = new AppKey(apc);
        obj = new Object();
    }

    /**
     * Test of getId method, of class AppKey.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Long expResult = 1L;
        assertEquals(expResult, apc.getId());
    }

    /**
     * Test of getAppKey method, of class AppKey.
     */
    @Test
    public void testGetAppKey() {
        System.out.println("getAppKey");
        String expResult = "appKey";
        assertEquals(expResult, apc.getAppKey());
    }

    /**
     * Test of getDeapcricao method, of class AppKey.
     */
    @Test
    public void testGetDeapcricao() {
        System.out.println("getDescricao");
        String expResult = "descricao";
        assertEquals(expResult, apc.getDescricao());
    }

    /**
     * Test of getTimeout method, of class AppKey.
     */
    @Test
    public void testGetTimeout() {
        System.out.println("getTimeout");
        Long expResult = 1L;
        assertEquals(expResult, apc.getTimeout());
    }

    /**
     * Test of setId method, of class AppKey.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 1L;
        apv.setId(id);
        assertEquals(id, apv.getId());
    }

    /**
     * Test of setAppKey method, of class AppKey.
     */
    @Test
    public void testSetAppKey() {
        System.out.println("setAppKey");
        String appKey = "appKey";
        apv.setAppKey(appKey);
        assertEquals(appKey, apv.getAppKey());
    }

    /**
     * Test of setDeapcricao method, of class AppKey.
     */
    @Test
    public void testSetDeapcricao() {
        System.out.println("setDescricao");
        String deapcricao = "descricao";
        apv.setDescricao(deapcricao);
        assertEquals(deapcricao, apv.getDescricao());
    }

    /**
     * Test of setTimeout method, of class AppKey.
     */
    @Test
    public void testSetTimeout() {
        System.out.println("setTimeout");
        Long timeout = 1L;
        apv.setTimeout(timeout);
        assertEquals(timeout, apv.getTimeout());
    }

    /**
     * Test of toString method, of class AppKey.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "AppKey{id=1, appKey=appKey, descricao=descricao, timeout=1}";
        String expResultv = "AppKey{id=null, appKey=null, descricao=null, timeout=null}";
        assertEquals(expResult, apc.toString());
        assertEquals(expResultv, apv.toString());
    }

    /**
     * Test of hashCode method, of class AppKey.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        assertEquals(apc.hashCode(), apc.hashCode());
        assertNotEquals(apc.hashCode(), apv.hashCode());
    }

    /**
     * Test of equals method, of class AppKey.
     */
    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        assertEquals(apc, apc);
        assertEquals(apv, apv);
    }

    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");
        // Testes de sucesso
        assertEquals(apc, apcop);
        assertEquals(apcop, apc);
        // Testes de insucesso
        assertNotEquals(apc, apv);
        assertNotEquals(apv, apc);
    }

    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        assertNotEquals(apc, null);
        assertNotEquals(apv, null);
        assertNotEquals(obj, null);
    }

    @Test
    public void testEqualsCoverage() {
        System.out.println("equals: testa todas as propriedades");

        apcop.setId(2L);
        assertNotEquals(apc, apcop);
        apcop.setId(apc.getId());

        apcop.setAppKey("appk");
        assertNotEquals(apc, apcop);
        apcop.setAppKey(apc.getAppKey());
        
        apcop.setDescricao("desc");
        assertNotEquals(apc, apcop);
        apcop.setDescricao(apc.getDescricao());
        
        apcop.setTimeout(2L);
        assertNotEquals(apc, apcop);
        apcop.setTimeout(apc.getTimeout());
    }

    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: objetos de classes diferentes");
        assertNotEquals(apc, obj);
        assertNotEquals(apv, obj);
        assertNotEquals(apcop, obj);
    }
}
