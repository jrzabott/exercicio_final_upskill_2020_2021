package api.model;

import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SessionsTest {

    private Sessions sc, sv, scop;
    private Object obj;

    public SessionsTest() {
        sc = new Sessions(1L, LocalDateTime.MIN, 1L, 1L);
        sv = new Sessions();
        scop = new Sessions(sc);
        obj = new Object();
    }

    /**
     * Test of getId method, of class Sessions.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Long expResult = 1L;
        assertEquals(expResult, sc.getId());
    }

    /**
     * Test of getLoginDate method, of class Sessions.
     */
    @Test
    public void testGetLoginDate() {
        System.out.println("getLoginDate");
        LocalDateTime expResult = LocalDateTime.MIN;
        assertEquals(expResult, sc.getLoginDate());
    }

    /**
     * Test of getIdContext method, of class Sessions.
     */
    @Test
    public void testGetIdContext() {
        System.out.println("getIdContext");
        Long expResult = 1L;
        assertEquals(expResult, sc.getIdContext());
    }

    /**
     * Test of getIdUser method, of class Sessions.
     */
    @Test
    public void testGetIdUser() {
        System.out.println("getIdUser");
        Long expResult = 1L;
        assertEquals(expResult, sc.getIdUser());
    }

    /**
     * Test of setId method, of class Sessions.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 1L;
        sv.setId(id);
        assertEquals(id, sv.getId());
    }

    /**
     * Test of setLoginDate method, of class Sessions.
     */
    @Test
    public void testSetLoginDate() {
        System.out.println("setLoginDate");
        LocalDateTime ldt = LocalDateTime.MIN;
        sv.setLoginDate(ldt);
        assertEquals(ldt, sv.getLoginDate());
    }

    /**
     * Test of setIdContext method, of class Sessions.
     */
    @Test
    public void testSetIdContext() {
        System.out.println("setIdContext");
        Long idContext = 1L;
        sv.setIdContext(idContext);
        assertEquals(idContext, sv.getIdContext());
    }

    /**
     * Test of setIdUser method, of class Sessions.
     */
    @Test
    public void testSetIdUser() {
        System.out.println("setIdUser");
        Long idUser = 1L;
        sv.setIdUser(idUser);
        assertEquals(idUser, sv.getIdUser());
    }

    /**
     * Test of toString method, of class Sessions.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Sessions{id=1, loginDate=-999999999-01-01T00:00, idContext=1, idUser=1}";
        String expResultv = "Sessions{id=null, loginDate=null, idContext=null, idUser=null}";
        assertEquals(expResult, sc.toString());
        assertEquals(expResultv, sv.toString());
    }

    /**
     * Test of hashCode method, of class Sessions.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        assertEquals(sc.hashCode(), sc.hashCode());
        assertNotEquals(sc.hashCode(), sv.hashCode());
    }

    /**
     * Test of equals method, of class Sessions.
     */
    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        assertEquals(sc, sc);
        assertEquals(sv, sv);
    }

    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");
        // Testes de sucesso
        assertEquals(sc, scop);
        assertEquals(scop, sc);
        // Testes de insucesso
        assertNotEquals(sc, sv);
        assertNotEquals(sv, sc);
    }

    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        assertNotEquals(sc, null);
        assertNotEquals(sv, null);
        assertNotEquals(obj, null);
    }

    @Test
    public void testEqualsCoverage() {
        System.out.println("equals: testa todas as propriedades");

        scop.setId(2L);
        assertNotEquals(sc, scop);
        scop.setId(sc.getId());

        scop.setLoginDate(LocalDateTime.MAX);
        assertNotEquals(sc, scop);
        scop.setLoginDate(sc.getLoginDate());
        
        scop.setIdContext(2L);
        assertNotEquals(sc, scop);
        scop.setIdContext(sc.getIdContext());
        
        scop.setIdUser(2L);
        assertNotEquals(sc, scop);
        scop.setIdUser(sc.getIdUser());
    }

    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: objetos de classes diferentes");
        assertNotEquals(sc, obj);
        assertNotEquals(sv, obj);
        assertNotEquals(scop, obj);
    }
}
