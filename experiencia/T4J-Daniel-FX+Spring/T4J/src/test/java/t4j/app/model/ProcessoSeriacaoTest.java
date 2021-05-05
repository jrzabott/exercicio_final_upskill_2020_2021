/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.model;

import java.time.LocalDate;
import java.time.Month;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Upskill
 */
public class ProcessoSeriacaoTest {
    ProcessoSeriacao psT, ps1, ps2, ps3;
    LocalDate data;
    Object obj;
    
    public ProcessoSeriacaoTest() {
        data = LocalDate.of(2021, 01, 01);
        ps1 = new ProcessoSeriacao(1L, data, "T001");
        ps2 = new ProcessoSeriacao(ps1);
        ps3 = new ProcessoSeriacao(2L, data, "T002");
        psT = new ProcessoSeriacao();
        obj = new Object();
    }

    /**
     * Test of getId method, of class ProcessoSeriacao.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        assertEquals(1, ps1.getId());
    }

    /**
     * Test of getDataRealizacao method, of class ProcessoSeriacao.
     */
    @Test
    public void testGetDataRealizacao() {
        System.out.println("getDataRealizacao");
        assertEquals(data, ps1.getDataRealizacao());
    }

    /**
     * Test of getReferenciaAnuncio method, of class ProcessoSeriacao.
     */
    @Test
    public void testGetReferenciaAnuncio() {
        System.out.println("getReferenciaAnuncio");
        assertEquals("T001", ps1.getReferenciaAnuncio());
    }

    /**
     * Test of setId method, of class ProcessoSeriacao.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 10L;
        ps1.setId(id);
        assertEquals(id, ps1.getId());
    }

    /**
     * Test of setDataRealizacao method, of class ProcessoSeriacao.
     */
    @Test
    public void testSetDataRealizacao() {
        System.out.println("setDataRealizacao");
        LocalDate data2 = LocalDate.of(2021, 01, 02);
        ps1.setDataRealizacao(data2);
        assertEquals(data2, ps1.getDataRealizacao());
    }

    /**
     * Test of setReferenciaAnuncio method, of class ProcessoSeriacao.
     */
    @Test
    public void testSetReferenciaAnuncio() {
        System.out.println("setReferenciaAnuncio");
        String ref = "T100";
        ps1.setReferenciaAnuncio(ref);
        assertEquals(ref, ps1.getReferenciaAnuncio());
    }

    /**
     * Test of toString method, of class ProcessoSeriacao.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String ts1 = "ProcessoSeriacao{id=1, dataRealizacao=2021-01-01, idAnuncio=T001}";
        assertEquals(ts1, ps1.toString());
        
        String ts2 = "ProcessoSeriacao{id=null, dataRealizacao=null, idAnuncio=null}";
        assertEquals(ts2, psT.toString());
    }

    /**
     * Test of equals method, of class ProcessoSeriacao.
     */
    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        assertEquals(ps1, ps1);
        assertEquals(ps1.hashCode(), ps1.hashCode());
        assertEquals(ps3, ps3);
        assertEquals(ps3.hashCode(), ps3.hashCode());
    }

    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");
        // Testes de sucesso
        assertEquals(ps1, ps2);
        assertEquals(ps1.hashCode(), ps2.hashCode());
        assertEquals(ps2, ps1);
        assertEquals(ps2.hashCode(), ps1.hashCode());
        // Testes de insucesso
        assertNotEquals(ps1, ps3);
        assertNotEquals(ps1.hashCode(), ps3.hashCode());
        assertNotEquals(ps3, ps1);
        assertNotEquals(ps3.hashCode(), ps1.hashCode());
    }

    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        assertNotEquals(ps1, null);
        assertNotEquals(ps1, null);
        assertNotEquals(ps3, null);
        assertNotEquals(obj, null);
    }

    @Test
    public void testEqualsCoverage() {
        System.out.println("equals: testa todas as propriedades");

        ps2.setId(1111111L);
        assertNotEquals(ps1, ps2);
        ps2.setId(ps1.getId());

        ps2.setDataRealizacao(LocalDate.MIN);
        assertNotEquals(ps1, ps2);
        ps2.setDataRealizacao(ps1.getDataRealizacao());

        ps2.setReferenciaAnuncio("T100");
        assertNotEquals(ps1, ps2);
        ps2.setReferenciaAnuncio(ps1.getReferenciaAnuncio());
    }

    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: objetos de classes diferentes");
        assertNotEquals(ps1, obj);
        assertNotEquals(ps1.hashCode(), obj.hashCode());
        assertNotEquals(ps2, obj);
        assertNotEquals(ps2.hashCode(), obj.hashCode());
        assertNotEquals(ps3, obj);
        assertNotEquals(ps3.hashCode(), obj.hashCode());
    }
    
}
