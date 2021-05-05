/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Upskill
 */
public class ClassificacaoTest {
    private Classificacao classifT, classif1, classif2, classif3;
    private Object obj;
    
    public ClassificacaoTest() {
        classif1 = new Classificacao(1L, 2L, 3L);
        classif2 = new Classificacao(classif1);
        classif3 = new Classificacao(2L, 4L, 6L);
        classifT = new Classificacao();
        obj = new Object();
    }

    /**
     * Test of getId method, of class Classificacao.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        assertEquals(1, classif1.getId());
    }

    /**
     * Test of getIdProcessoSeriacao method, of class Classificacao.
     */
    @Test
    public void testGetIdProcessoSeriacao() {
        System.out.println("getIdProcessoSeriacao");
        assertEquals(2, classif1.getIdProcessoSeriacao());
    }

    /**
     * Test of getIdCandidaturaVencedora method, of class Classificacao.
     */
    @Test
    public void testGetIdCandidaturaVencedora() {
        System.out.println("getIdCandidaturaVencedora");
        assertEquals(3, classif1.getIdCandidaturaVencedora());
    }

    /**
     * Test of setId method, of class Classificacao.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 10L;
        classif1.setId(id);
        assertEquals(id, classif1.getId());
    }

    /**
     * Test of setIdProcessoSeriacao method, of class Classificacao.
     */
    @Test
    public void testSetIdProcessoSeriacao() {
        System.out.println("setIdProcessoSeriacao");
        Long id = 10L;
        classif1.setIdProcessoSeriacao(id);
        assertEquals(id, classif1.getIdProcessoSeriacao());
    }

    /**
     * Test of setIdCandidaturaVencedora method, of class Classificacao.
     */
    @Test
    public void testSetIdCandidaturaVencedora() {
        System.out.println("setIdCandidaturaVencedora");
        Long id = 10L;
        classif1.setIdCandidaturaVencedora(id);
        assertEquals(id, classif1.getIdCandidaturaVencedora());
    }

    /**
     * Test of toString method, of class Classificacao.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String ts1 = "Classificacao{id=1, idProcessoSeriacao=2, idCandidaturaVencedora=3}";
        assertEquals(ts1, classif1.toString());
        
        String ts2 = "Classificacao{id=null, idProcessoSeriacao=null, idCandidaturaVencedora=null}";
        assertEquals(ts2, classifT.toString());
    }

    /**
     * Test of equals method, of class Classificacao.
     */
    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        assertEquals(classif1, classif1);
        assertEquals(classif1.hashCode(), classif1.hashCode());
        assertEquals(classif3, classif3);
        assertEquals(classif3.hashCode(), classif3.hashCode());
    }

    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");
        // Testes de sucesso
        assertEquals(classif1, classif2);
        assertEquals(classif1.hashCode(), classif2.hashCode());
        assertEquals(classif2, classif1);
        assertEquals(classif2.hashCode(), classif1.hashCode());
        // Testes de insucesso
        assertNotEquals(classif1, classif3);
        assertNotEquals(classif1.hashCode(), classif3.hashCode());
        assertNotEquals(classif3, classif1);
        assertNotEquals(classif3.hashCode(), classif1.hashCode());
    }

    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        assertNotEquals(classif1, null);
        assertNotEquals(classif1, null);
        assertNotEquals(classif3, null);
        assertNotEquals(obj, null);
    }

    @Test
    public void testEqualsCoverage() {
        System.out.println("equals: testa todas as propriedades");

        classif2.setId(1111111L);
        assertNotEquals(classif1, classif2);
        classif2.setId(classif1.getId());

        classif2.setIdProcessoSeriacao(1111111L);
        assertNotEquals(classif1, classif2);
        classif2.setIdProcessoSeriacao(classif1.getIdProcessoSeriacao());
        
        classif2.setIdCandidaturaVencedora(1111111L);
        assertNotEquals(classif1, classif2);
        classif2.setIdCandidaturaVencedora(classif1.getIdCandidaturaVencedora());
    }

    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: objetos de classes diferentes");
        assertNotEquals(classif1, obj);
        assertNotEquals(classif1.hashCode(), obj.hashCode());
        assertNotEquals(classif2, obj);
        assertNotEquals(classif2.hashCode(), obj.hashCode());
        assertNotEquals(classif3, obj);
        assertNotEquals(classif3.hashCode(), obj.hashCode());
    }
    
}
