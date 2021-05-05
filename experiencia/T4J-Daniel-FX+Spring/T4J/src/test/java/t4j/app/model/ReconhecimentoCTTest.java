/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.model;

import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import t4j.app.exception.ElementoInvalidoException;

/**
 *
 * @author Upskill
 */
public class ReconhecimentoCTTest {

    ReconhecimentoCT rctT, rct1, rct2, rct3, rct4;
    Object obj;

    public ReconhecimentoCTTest() {
        rct1 = new ReconhecimentoCT(1L, LocalDate.of(2021, 01, 01), "Grau1", "CT1", "freel@mail.pt");
        rct2 = new ReconhecimentoCT(rct1);
        rct3 = new ReconhecimentoCT(LocalDate.of(2021, 01, 02), "Grau2", "CT2", "freel2@mail.pt");
        rct4 = new ReconhecimentoCT(rct3);
        obj = new Object();
    }

    /**
     * Test of getId method, of class ReconhecimentoCT.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        assertEquals(1, rct1.getId());
    }

    /**
     * Test of getDatareconhecimento method, of class ReconhecimentoCT.
     */
    @Test
    public void testGetDataReconhecimento() {
        System.out.println("getDataReconhecimento");
        LocalDate data = LocalDate.of(2021, 01, 01);
        assertEquals(data, rct1.getDatareconhecimento());
    }

    /**
     * Test of getIdgrauproficiencia method, of class ReconhecimentoCT.
     */
    @Test
    public void testGetIdGrauProficiencia() {
        System.out.println("getIdGrauProficiencia");
        assertEquals("Grau1", rct1.getIdgrauproficiencia());
    }

    /**
     * Test of getCodigocompetenciatecnica method, of class ReconhecimentoCT.
     */
    @Test
    public void testGetCodigoCompetenciaTecnica() {
        System.out.println("getCodigoCompetenciaTecnica");
        assertEquals("CT1", rct1.getCodigocompetenciatecnica());
    }

    /**
     * Test of getEmailfreelancer method, of class ReconhecimentoCT.
     */
    @Test
    public void testGetEmailfreelancer() {
        System.out.println("getEmailFreelancer");
        assertEquals("freel@mail.pt", rct1.getEmailfreelancer());
    }

    /**
     * Test of setId method, of class ReconhecimentoCT.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 10L;
        rct1.setId(id);
        assertEquals(id, rct1.getId());

    }

    /**
     * Test of setCodigoCompetenciaTecnica method, of class ReconhecimentoCT.
     */
    @Test
    public void testSetCodigoCompetenciaTecnica() {
        System.out.println("setCodigoCompetenciaTecnica");
        //Testes de sucesso
        String ct = "CT3";
        rct1.setCodigoCompetenciaTecnica(ct);
        assertEquals(ct, rct1.getCodigocompetenciatecnica());
    }

    /**
     * Test of setEmailFreelancer method, of class ReconhecimentoCT.
     */
    @Test
    public void testSetEmailFreelancer() {
        System.out.println("setEmailFreelancer");
        //Testes de sucesso
        String email = "freel3@mail.pt";
        rct1.setEmailFreelancer(email);
        assertEquals(email, rct1.getEmailfreelancer());
    }

    /**
     * Test of setDataReconhecimento method, of class ReconhecimentoCT.
     */
    @Test
    public void testSetDataReconhecimento() {
        System.out.println("setDataReconhecimento");
        //Testes de sucesso
        LocalDate data1 = LocalDate.of(2021, 01, 03);
        rct1.setDataReconhecimento(data1);
        assertEquals(data1, rct1.getDatareconhecimento());

        //Testes de insucesso
        LocalDate data2 = LocalDate.now();
        Throwable e2 = assertThrows(ElementoInvalidoException.class, () -> rct1.setDataReconhecimento(data2));
        assertEquals("A data de reconhecimento tem de ser anterior á data de hoje!", e2.getMessage());
        
        LocalDate data3 = null;
        Throwable e3 = assertThrows(NullPointerException.class, () -> rct1.setDataReconhecimento(data3));
        assertEquals("O campo data tem de estar preenchido!", e3.getMessage());
    }

    /**
     * Test of setIdGrauProficiencia method, of class ReconhecimentoCT.
     */
    @Test
    public void testSetIdGrauProficiencia() {
        System.out.println("setIdGrauProficiencia");
        String grau = "Grau3";
        rct1.setIdGrauProficiencia(grau);
        assertEquals(grau, rct1.getIdgrauproficiencia());
    }

    /**
     * Test of toString method, of class ReconhecimentoCT.
     */
    @Test
    public void testToString() {
        System.out.println("toString");

        String ts1 = "ReconhecimentoCT{id=1, datareconhecimento=2021-01-01, idgrauproficiencia=Grau1, codigocompetenciatecnica=CT1, emailfreelancer=freel@mail.pt}";
        assertEquals(ts1, rct1.toString());

        rctT = new ReconhecimentoCT();
        String ts2 = "ReconhecimentoCT{id=null, datareconhecimento=null, idgrauproficiencia=null, codigocompetenciatecnica=null, emailfreelancer=null}";
        assertEquals(ts2, rctT.toString());
    }

    /**
     * Test of equals method, of class ReconhecimentoCT.
     */
    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        assertEquals(rct1, rct1);
        assertEquals(rct1.hashCode(), rct1.hashCode());
        assertEquals(rct3, rct3);
        assertEquals(rct3.hashCode(), rct3.hashCode());
    }

    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");
        // Testes de sucesso
        assertEquals(rct1, rct2);
        assertEquals(rct1.hashCode(), rct2.hashCode());
        assertEquals(rct2, rct1);
        assertEquals(rct2.hashCode(), rct1.hashCode());
        // Testes de insucesso
        assertNotEquals(rct1, rct3);
        assertNotEquals(rct1.hashCode(), rct3.hashCode());
        assertNotEquals(rct3, rct1);
        assertNotEquals(rct3.hashCode(), rct1.hashCode());
    }

    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        assertNotEquals(rct1, null);
        assertNotEquals(rct1, null);
        assertNotEquals(rct3, null);
        assertNotEquals(obj, null);
    }

    @Test
    public void testEqualsCoverage() {
        System.out.println("equals: testa todas as propriedades");

        rct2.setId(1111111L);
        assertNotEquals(rct1, rct2);
        rct2.setId(rct1.getId());

        rct2.setDataReconhecimento(LocalDate.MIN);
        assertNotEquals(rct1, rct2);
        rct2.setDataReconhecimento(rct1.getDatareconhecimento());

        rct2.setIdGrauProficiencia("Grau100");
        assertNotEquals(rct1, rct2);
        rct2.setIdGrauProficiencia(rct1.getIdgrauproficiencia());

        rct2.setCodigoCompetenciaTecnica("CT100");
        assertNotEquals(rct1, rct2);
        rct2.setCodigoCompetenciaTecnica(rct1.getCodigocompetenciatecnica());

        rct2.setEmailFreelancer("freel10@mail.pt");
        assertNotEquals(rct1, rct2);
        rct2.setEmailFreelancer(rct1.getEmailfreelancer());
    }

    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: objetos de classes diferentes");
        assertNotEquals(rct1, obj);
        assertNotEquals(rct1.hashCode(), obj.hashCode());
        assertNotEquals(rct2, obj);
        assertNotEquals(rct2.hashCode(), obj.hashCode());
        assertNotEquals(rct3, obj);
        assertNotEquals(rct3.hashCode(), obj.hashCode());
    }

}
