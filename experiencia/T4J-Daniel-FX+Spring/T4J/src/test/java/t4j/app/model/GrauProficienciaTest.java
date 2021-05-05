/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import t4j.app.exception.ElementoInvalidoException;

/**
 *
 * @author Upskill
 */
public class GrauProficienciaTest {

    private GrauProficiencia grauT, grau, grau2, grau3;
    private Object obj;

    public GrauProficienciaTest() {
        grauT = new GrauProficiencia();
        grau = new GrauProficiencia(1L, "1", "Designação");
        grau2 = new GrauProficiencia(grau);
        grau3 = new GrauProficiencia("2", "Designação");
        obj = new Object();
    }

    /**
     * Test of getId method, of class GrauProficiencia.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        assertEquals(1, grau.getId());
    }

    /**
     * Test of getValorGrauProficiencia method, of class GrauProficiencia.
     */
    @Test
    public void testGetValorGrauProficiencia() {
        System.out.println("getValor");
        String valor = "1";
        grauT.setValorGrauProficiencia(valor);
        assertEquals(valor, grauT.getValorGrauProficiencia());
    }

    /**
     * Test of getDesignacaoGrauProficiencia method, of class GrauProficiencia.
     */
    @Test
    public void testGetDesignacaoGrauProficiencia() {
        System.out.println("getDesignacaoGrauProficiencia");
        String designacao = "Designacao";
        grauT.setDesignacaoGrauProficiencia(designacao);
        assertEquals(designacao, grauT.getDesignacaoGrauProficiencia());
    }

    /**
     * Test of setId method, of class GrauProficiencia.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 2L;
        grau.setId(id);
        assertEquals(id, grau.getId());
    }

    /**
     * Test of setValorGrauProficiencia method, of class GrauProficiencia.
     */
    @Test
    public void testSetValorGrauProficiencia() {
        System.out.println("setValorGrauProficiencia");
        //Testes de sucesso
        String valor1 = "1";
        grau.setValorGrauProficiencia(valor1);
        assertEquals(valor1, grau.getValorGrauProficiencia());

        //Testes de insucesso
//        String valor2 = " ";
//        Throwable e2 = assertThrows(ElementoInvalidoException.class, () -> grau.setValorGrauProficiencia(valor2));
//        assertEquals("Valor inválido.", e2.getMessage());
//
//        String valor3 = null;
//        Throwable e3 = assertThrows(ElementoInvalidoException.class, () -> grau.setValorGrauProficiencia(valor3));
//        assertEquals("Valor inválido.", e3.getMessage());
//
//        String valor4 = "100";
//        Throwable e4 = assertThrows(ElementoInvalidoException.class, () -> grau.setValorGrauProficiencia(valor4));
//        assertEquals("Valor inválido.", e4.getMessage());
//
//        String valor5 = "Valor5";
//        Throwable e5 = assertThrows(ElementoInvalidoException.class, () -> grau.setValorGrauProficiencia(valor5));
//        assertEquals("Valor inválido.", e5.getMessage());
    }

    /**
     * Test of setDesignacaoGrauProficiencia method, of class GrauProficiencia.
     */
    @Test
    public void testSetDesignacaoGrauProficiencia() {
        System.out.println("setDesignacaoGrauProficiencia");
        //Testes de sucesso
        String designacao1 = "Designação";
        grauT.setDesignacaoGrauProficiencia(designacao1);
        assertEquals(designacao1, grauT.getDesignacaoGrauProficiencia());
        //Testes de insucesso
//        System.out.println("setDesignacao Vazia");
//        String designacao2 = "  ";
//        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {
//            grauT.setDesignacaoGrauProficiencia(designacao2);
//        });
//        assertEquals("Designação inválida.", exception2.getMessage());
//
//        String designacao3 = null;
//        Throwable e3 = assertThrows(ElementoInvalidoException.class, () -> grau.setDesignacaoGrauProficiencia(designacao3));
//        assertEquals("Designação inválida.", e3.getMessage());
    }

    /**
     * Test of toString method, of class GrauProficiencia.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String ts1 = "GrauProficiencia{id=1, valorGrauProficiencia=1, designacaoGrauProficiencia=Designação}";
        assertEquals(ts1, grau.toString());

        String ts2 = "GrauProficiencia{id=null, valorGrauProficiencia=null, designacaoGrauProficiencia=null}";
        assertEquals(ts2, grauT.toString());
    }

    /**
     * Test of equals method, of class GrauProficiencia.
     */
    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        assertEquals(grau, grau);
        assertEquals(grau3, grau3);
    }

    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");
        // Testes de sucesso
        assertEquals(grau, grau2);
        assertEquals(grau2, grau);
        // Testes de insucesso
        assertNotEquals(grau, grau3);
        assertNotEquals(grau3, grau);
    }

    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        assertNotEquals(grau, null);
        assertNotEquals(grau3, null);
        assertNotEquals(obj, null);
    }

    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: objetos de classes diferentes");
        assertNotEquals(grau, obj);
        assertNotEquals(grau2, obj);
        assertNotEquals(grau3, obj);
    }

    @Test
    public void testEqualsCoverage() {
        System.out.println("equals: testa todas as propriedades");

        grau2.setId(1111111L);
        assertNotEquals(grau, grau2);
        grau2.setId(grau.getId());

        grau2.setValorGrauProficiencia("99");
        assertNotEquals(grau, grau2);
        grau2.setValorGrauProficiencia(grau.getValorGrauProficiencia());

        grau2.setDesignacaoGrauProficiencia("Designacao100");
        assertNotEquals(grau, grau2);
        grau2.setDesignacaoGrauProficiencia(grau.getDesignacaoGrauProficiencia());
    }

}
