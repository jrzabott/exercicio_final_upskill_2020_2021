package api.model;

import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContextsTest {
    
    private Contexts cc, cv, ccop;
    private Object obj;
    
    public ContextsTest() {
        cc = new Contexts(1L, "context", LocalDateTime.MIN, "Y");
        cv = new Contexts();
        ccop = new Contexts(cc);
        obj = new Object();
    }

    /**
     * Test of getId method, of class Contexts.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Long expResult = 1L;
        assertEquals(expResult, cc.getId());
    }

    /**
     * Test of getContext method, of class Contexts.
     */
    @Test
    public void testGetContext() {
        System.out.println("getContext");
        String expResult = "context";
        assertEquals(expResult, cc.getContext());
    }

    /**
     * Test of getDataCriacao method, of class Contexts.
     */
    @Test
    public void testGetDataCriacao() {
        System.out.println("getDataCriacao");
        LocalDateTime expResult = LocalDateTime.MIN;
        assertEquals(expResult, cc.getDataCriacao());
    }

    /**
     * Test of getValido method, of class Contexts.
     */
    @Test
    public void testGetValido() {
        System.out.println("getValido");
        String expResult = "Y";
        assertEquals(expResult, cc.getValido());
    }

    /**
     * Test of setId method, of class Contexts.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 1L;
        cv.setId(id);
        assertEquals(id, cv.getId());
    }

    /**
     * Test of setContext method, of class Contexts.
     */
    @Test
    public void testSetContext() {
        System.out.println("setContext");
        String context = "context";
        cv.setContext(context);
        assertEquals(context, cv.getContext());
    }

    /**
     * Test of setDataCriacao method, of class Contexts.
     */
    @Test
    public void testSetDataCriacao() {
        System.out.println("setDataCriacao");
        LocalDateTime dataCriacao = LocalDateTime.MIN;
        cv.setDataCriacao(dataCriacao);
        assertEquals(dataCriacao, cv.getDataCriacao());
    }

    /**
     * Test of setValido method, of class Contexts.
     */
    @Test
    public void testSetValido() {
        System.out.println("setValido");
        String valido = "Y";
        cv.setValido(valido);
        assertEquals(valido, cv.getValido());
    }

    /**
     * Test of toString method, of class Contexts.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Contexts{id=1, context=context, dataCriacao=-999999999-01-01T00:00, valido=Y}";
        String expResultv = "Contexts{id=null, context=null, dataCriacao=null, valido=null}";
        assertEquals(expResult, cc.toString());
        assertEquals(expResultv, cv.toString());
    }

    /**
     * Test of hashCode method, of class Contexts.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        assertEquals(cc.hashCode(), cc.hashCode());
        assertNotEquals(cc.hashCode(), cv.hashCode());
    }

    /**
     * Test of equals method, of class Contexts.
     */
    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        assertEquals(cc, cc);
        assertEquals(cv, cv);
    }

    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");
        // Testes de sucesso
        assertEquals(cc, ccop);
        assertEquals(ccop, cc);
        // Testes de insucesso
        assertNotEquals(cc, cv);
        assertNotEquals(cv, cc);
    }

    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        assertNotEquals(cc, null);
        assertNotEquals(cv, null);
        assertNotEquals(obj, null);
    }

    @Test
    public void testEqualsCoverage() {
        System.out.println("equals: testa todas as propriedades");

        ccop.setId(2L);
        assertNotEquals(cc, ccop);
        ccop.setId(cc.getId());
        
        ccop.setContext("cont");
        assertNotEquals(cc, ccop);
        ccop.setContext(cc.getContext());
        
        ccop.setDataCriacao(LocalDateTime.MAX);
        assertNotEquals(cc, ccop);
        ccop.setDataCriacao(cc.getDataCriacao());
        
        ccop.setValido("N");
        assertNotEquals(cc, ccop);
        ccop.setValido(cc.getValido());
    }

    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: objetos de classes diferentes");
        assertNotEquals(cc, obj);
        assertNotEquals(cv, obj);
        assertNotEquals(ccop, obj);
    }
}
