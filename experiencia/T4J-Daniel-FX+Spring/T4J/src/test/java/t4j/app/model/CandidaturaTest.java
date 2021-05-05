/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.model;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import t4j.app.exception.ElementoInvalidoException;

/**
 *
 * @author Upskill
 */
public class CandidaturaTest {

    private Candidatura cdT, cd1, cd2, cd3;
    private Object obj;

    public CandidaturaTest() {
        cd1 = new Candidatura(1L, LocalDate.now(), "3500", "40", "Teste 1", "Teste 2", "T003", "freela01@fl.pt", 1, "colaboradorA@teste.pt");
        cd2 = new Candidatura(cd1);
        cd3 = new Candidatura(2L, LocalDate.now(), "4000", "45", "Teste 3", "Teste 4", "T004", "freela02@fl.pt", 1, "colaboradorB@teste.pt");
        obj = new Object();
    }

    /**
     * Test of getId method, of class Candidatura.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        assertEquals(1, cd1.getId());
    }

    /**
     * Test of getDataCandidatura method, of class Candidatura.
     */
    @Test
    public void testGetDataCandidatura() {
        System.out.println("getDataCandidatura");
        assertEquals(LocalDate.now(), cd1.getDataCandidatura());
    }

    /**
     * Test of getValorPretendido method, of class Candidatura.
     */
    @Test
    public void testGetValorPretendido() {
        System.out.println("getValorPretendido");
        assertEquals("3500", cd1.getValorPretendido());
    }

    /**
     * Test of getNrDias method, of class Candidatura.
     */
    @Test
    public void testGetNrDias() {
        System.out.println("getNrDias");
        assertEquals("40", cd1.getNrDias());
    }

    /**
     * Test of getTxtApresentacao method, of class Candidatura.
     */
    @Test
    public void testGetTxtApresentacao() {
        System.out.println("getTxtApresentacao");
        assertEquals("Teste 1", cd1.getTxtApresentacao());
    }

    /**
     * Test of getTxtMotivacao method, of class Candidatura.
     */
    @Test
    public void testGetTxtMotivacao() {
        System.out.println("getTxtMotivacao");
        assertEquals("Teste 2", cd1.getTxtMotivacao());
    }

    /**
     * Test of getRefAnuncio method, of class Candidatura.
     */
    @Test
    public void testGetRefAnuncio() {
        System.out.println("getRefAnuncio");
        assertEquals("T003", cd1.getRefAnuncio());
    }

    /**
     * Test of getEmailFreelancer method, of class Candidatura.
     */
    @Test
    public void testGetEmailFreelancer() {
        System.out.println("getEmailFreelancer");
        assertEquals("freela01@fl.pt", cd1.getEmailFreelancer());
    }

    /**
     * Test of getClassificacao method, of class Candidatura.
     */
    @Test
    public void testGetClassificacao() {
        System.out.println("getClassificacao");
        assertEquals(1, cd1.getClassificacao());
    }

    /**
     * Test of getEmailColaboradorClassificou method, of class Candidatura.
     */
    @Test
    public void testGetEmailColaboradorClassificou() {
        System.out.println("getEmailColaboradorClassificou");
        assertEquals("colaboradorA@teste.pt", cd1.getEmailColaboradorClassificou());
    }

    /**
     * Test of setId method, of class Candidatura.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 2L;
        cd1.setId(id);
        assertEquals(id, cd1.getId());
    }

    /**
     * Test of setDataCandidatura method, of class Candidatura.
     */
    @Test
    public void testSetDataCandidatura() {
        System.out.println("setDataCandidatura");
        LocalDate data = LocalDate.now();
        cd1.setDataCandidatura(data);
        assertEquals(data, cd1.getDataCandidatura());
    }

    /**
     * Test of setValorPretendido method, of class Candidatura.
     */
    @Test
    public void testSetValorPretendido() {
        System.out.println("setValorPretendido");
        //Testes de sucesso
        String valor1 = "10000";
        cd1.setValorPretendido(valor1);
        assertEquals(valor1, cd1.getValorPretendido());

        //Testes de insucesso
        String valor2 = " ";
        Throwable e2 = assertThrows(ElementoInvalidoException.class, () -> cd1.setValorPretendido(valor2));
        assertEquals(Candidatura.ValidaCandidatura.VALORPRETENDIDO_EMPTY_EXCEPTION, e2.getMessage());

        String valor3 = null;
        Throwable e3 = assertThrows(ElementoInvalidoException.class, () -> cd1.setValorPretendido(valor3));
        assertEquals(Candidatura.ValidaCandidatura.VALORPRETENDIDO_NULL_EXCEPTION, e3.getMessage());

        String valor4 = String.format("|%16d|", 0);
        Throwable e4 = assertThrows(ElementoInvalidoException.class, () -> cd1.setValorPretendido(valor4));
        assertEquals(Candidatura.ValidaCandidatura.VALORPRETENDIDO_MAX_SIZE_EXCEPTION, e4.getMessage());

        String valor5 = "3500.00";
        Throwable e5 = assertThrows(ElementoInvalidoException.class, () -> cd1.setValorPretendido(valor5));
        assertEquals(Candidatura.ValidaCandidatura.VALORPRETENDIDO_REGEX_EXCEPTION, e5.getMessage());
    }

    /**
     * Test of setNrDias method, of class Candidatura.
     */
    @Test
    public void testSetNrDias() {
        System.out.println("setNrDias");
        //Testes de sucesso
        String nrDias1 = "50";
        cd1.setNrDias(nrDias1);
        assertEquals(nrDias1, cd1.getNrDias());

        //Testes de insucesso
        String nrDias2 = " ";
        Throwable e2 = assertThrows(ElementoInvalidoException.class, () -> cd1.setNrDias(nrDias2));
        assertEquals(Candidatura.ValidaCandidatura.NRDIAS_EMPTY_EXCEPTION, e2.getMessage());

        String nrDias3 = null;
        Throwable e3 = assertThrows(ElementoInvalidoException.class, () -> cd1.setNrDias(nrDias3));
        assertEquals(Candidatura.ValidaCandidatura.NRDIAS_NULL_EXCEPTION, e3.getMessage());

        String nrDias4 = String.format("|%6d|", 0);
        Throwable e4 = assertThrows(ElementoInvalidoException.class, () -> cd1.setNrDias(nrDias4));
        assertEquals(Candidatura.ValidaCandidatura.NRDIAS_MAX_SIZE_EXCEPTION, e4.getMessage());

        String nrDias5 = "40d";
        Throwable e5 = assertThrows(ElementoInvalidoException.class, () -> cd1.setNrDias(nrDias5));
        assertEquals(Candidatura.ValidaCandidatura.NRDIAS_REGEX_EXCEPTION, e5.getMessage());
    }

    /**
     * Test of setTxtApresentacao method, of class Candidatura.
     */
    @Test
    public void testSetTxtApresentacao() {
        System.out.println("setTxtApresentacao");
        //Testes de sucesso
        String txtApr1 = "50";
        cd1.setTxtApresentacao(txtApr1);
        assertEquals(txtApr1, cd1.getTxtApresentacao());

        //Testes de insucesso
        String txtApr2 = " ";
        Throwable e2 = assertThrows(ElementoInvalidoException.class, () -> cd1.setTxtApresentacao(txtApr2));
        assertEquals(Candidatura.ValidaCandidatura.TXTAPRESENTACAO_EMPTY_EXCEPTION, e2.getMessage());

        String txtApr3 = null;
        Throwable e3 = assertThrows(ElementoInvalidoException.class, () -> cd1.setTxtApresentacao(txtApr3));
        assertEquals(Candidatura.ValidaCandidatura.TXTAPRESENTACAO_NULL_EXCEPTION, e3.getMessage());

        String txtApr4 = String.format("|%1024d|", 0);
        Throwable e4 = assertThrows(ElementoInvalidoException.class, () -> cd1.setTxtApresentacao(txtApr4));
        assertEquals(Candidatura.ValidaCandidatura.TXTAPRESENTACAO_MAX_SIZE_EXCEPTION, e4.getMessage());
    }

    /**
     * Test of setTxtMotivacao method, of class Candidatura.
     */
    @Test
    public void testSetTxtMotivacao() {
        System.out.println("setTxtMotivacao");
        //Testes de sucesso
        String txtMot1 = "50";
        cd1.setTxtMotivacao(txtMot1);
        assertEquals(txtMot1, cd1.getTxtMotivacao());

        //Testes de insucesso
        String txtMot2 = " ";
        Throwable e2 = assertThrows(ElementoInvalidoException.class, () -> cd1.setTxtMotivacao(txtMot2));
        assertEquals(Candidatura.ValidaCandidatura.TXTMOTIVACAO_EMPTY_EXCEPTION, e2.getMessage());

        String txtMot3 = null;
        Throwable e3 = assertThrows(ElementoInvalidoException.class, () -> cd1.setTxtMotivacao(txtMot3));
        assertEquals(Candidatura.ValidaCandidatura.TXTMOTIVACAO_NULL_EXCEPTION, e3.getMessage());

        String txtMot4 = String.format("|%1024d|", 0);
        Throwable e4 = assertThrows(ElementoInvalidoException.class, () -> cd1.setTxtMotivacao(txtMot4));
        assertEquals(Candidatura.ValidaCandidatura.TXTMOTIVACAO_MAX_SIZE_EXCEPTION, e4.getMessage());
    }

    /**
     * Test of setRefAnuncio method, of class Candidatura.
     */
    @Test
    public void testSetRefAnuncio() {
        System.out.println("setRefAnuncio");
        String refAnuncio = "T004";
        cd1.setRefAnuncio(refAnuncio);
        assertEquals(refAnuncio, cd1.getRefAnuncio());
    }

    /**
     * Test of setEmailFreelancer method, of class Candidatura.
     */
    @Test
    public void testSetEmailFreelancer() {
        System.out.println("setEmailFreelancer");
        String emailFreelancer = "freela03@fl.pt";
        cd1.setEmailFreelancer(emailFreelancer);
        assertEquals(emailFreelancer, cd1.getEmailFreelancer());
    }

    /**
     * Test of setClassificacao method, of class Candidatura.
     */
    @Test
    public void testSetClassificacao() {
        int classif = 2;
        cd1.setClassificacao(classif);
        assertEquals(classif, cd1.getClassificacao());
    }

    /**
     * Test of setEmailColaboradorClassificou method, of class Candidatura.
     */
    @Test
    public void testSetEmailColaboradorClassificou() {
        System.out.println("setEmailColaboradorClassificou");
        String emailColabClassif = "colaboradorC@teste.pt";
        cd1.setEmailColaboradorClassificou(emailColabClassif);
        assertEquals(emailColabClassif, cd1.getEmailColaboradorClassificou());
    }

    /**
     * Test of toString method, of class Candidatura.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        LocalDate date = LocalDate.now();
        String dateString = date.toString();

        String ts1 = "Candidatura{id=1, dataCandidatura=" + dateString + ", valorPretendido=3500, nrDias=40, txtApresentacao=Teste 1, txtMotivacao=Teste 2, refAnuncio=T003, emailFreelancer=freela01@fl.pt, classificacao=1, emailColaboradorClassificou=colaboradorA@teste.pt}";
        assertEquals(ts1, cd1.toString());

        cdT = new Candidatura();
        String tsT = "Candidatura{id=null, dataCandidatura=null, valorPretendido=null, nrDias=null, txtApresentacao=null, txtMotivacao=null, refAnuncio=null, emailFreelancer=null, classificacao=null, emailColaboradorClassificou=null}";
        assertEquals(tsT, cdT.toString());
    }

    /**
     * Test of equals method, of class Candidatura.
     */
    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        assertEquals(cd1, cd1);
        assertEquals(cd1.hashCode(), cd1.hashCode());
        assertEquals(cd3, cd3);
        assertEquals(cd3.hashCode(), cd3.hashCode());
    }

    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");
        // Testes de sucesso
        assertEquals(cd1, cd2);
        assertEquals(cd1.hashCode(), cd2.hashCode());
        assertEquals(cd2, cd1);
        assertEquals(cd2.hashCode(), cd1.hashCode());
        // Testes de insucesso
        assertNotEquals(cd1, cd3);
        assertNotEquals(cd1.hashCode(), cd3.hashCode());
        assertNotEquals(cd3, cd1);
        assertNotEquals(cd3.hashCode(), cd1.hashCode());
    }

    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        assertNotEquals(cd1, null);
        assertNotEquals(cd1, null);
        assertNotEquals(cd3, null);
        assertNotEquals(obj, null);
    }

    @Test
    public void testEqualsCoverage() {
        System.out.println("equals: testa todas as propriedades");

        cd2.setId(1111111L);
        assertNotEquals(cd1, cd2);
        cd2.setId(cd1.getId());

        cd2.setDataCandidatura(LocalDate.MIN);
        assertNotEquals(cd1, cd2);
        cd2.setDataCandidatura(cd1.getDataCandidatura());

        cd2.setValorPretendido("10000");
        assertNotEquals(cd1, cd2);
        cd2.setValorPretendido(cd1.getValorPretendido());

        cd2.setNrDias("100");
        assertNotEquals(cd1, cd2);
        cd2.setNrDias(cd1.getNrDias());

        cd2.setTxtApresentacao("Hello");
        assertNotEquals(cd1, cd2);
        cd2.setTxtApresentacao(cd1.getTxtApresentacao());

        cd2.setTxtMotivacao("Hello");
        assertNotEquals(cd1, cd2);
        cd2.setTxtMotivacao(cd1.getTxtMotivacao());

        cd2.setRefAnuncio("A001");
        assertNotEquals(cd1, cd2);
        cd2.setRefAnuncio(cd1.getRefAnuncio());

        cd2.setEmailFreelancer("email@gmail.pt");
        assertNotEquals(cd1, cd2);
        cd2.setEmailFreelancer(cd1.getEmailFreelancer());

        cd2.setClassificacao(100);
        assertNotEquals(cd1, cd2);
        cd2.setClassificacao(cd1.getClassificacao());

        cd2.setEmailColaboradorClassificou("email@gmail.pt");
        assertNotEquals(cd1, cd2);
        cd2.setEmailColaboradorClassificou(cd1.getEmailColaboradorClassificou());

    }

    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: objetos de classes diferentes");
        assertNotEquals(cd1, obj);
        assertNotEquals(cd1.hashCode(), obj.hashCode());
        assertNotEquals(cd2, obj);
        assertNotEquals(cd2.hashCode(), obj.hashCode());
        assertNotEquals(cd3, obj);
        assertNotEquals(cd3.hashCode(), obj.hashCode());
    }

    /**
     * Test of equals method, of class Candidatura.
     */
    @Test
    public void testConstrutor() {
        System.out.println("Construtor");
        cdT = new Candidatura(1L, LocalDate.now(), "3500", "40", "Teste 1", "Teste 2", "T003", "freela01@fl.pt", 1, "colaboradorA@teste.pt");
        assertEquals(1L, cdT.getId());
        assertEquals(LocalDate.now(), cdT.getDataCandidatura());
        assertEquals("3500", cdT.getValorPretendido());
        assertEquals("40", cdT.getNrDias());
        assertEquals("Teste 1", cdT.getTxtApresentacao());
        assertEquals("Teste 2", cdT.getTxtMotivacao());
        assertEquals("T003", cdT.getRefAnuncio());
        assertEquals("freela01@fl.pt", cdT.getEmailFreelancer());
        assertEquals(1, cdT.getClassificacao());
        assertEquals("colaboradorA@teste.pt", cdT.getEmailColaboradorClassificou());

        Candidatura cdT2 = new Candidatura(1L, LocalDate.now(), "3500", "40", "Teste 1", "Teste 2", "T003", "freela01@fl.pt");
        assertEquals(1L, cdT2.getId());
        assertEquals(LocalDate.now(), cdT2.getDataCandidatura());
        assertEquals("3500", cdT2.getValorPretendido());
        assertEquals("40", cdT2.getNrDias());
        assertEquals("Teste 1", cdT2.getTxtApresentacao());
        assertEquals("Teste 2", cdT2.getTxtMotivacao());
        assertEquals("T003", cdT2.getRefAnuncio());
        assertEquals("freela01@fl.pt", cdT2.getEmailFreelancer());

        Candidatura cdT3 = cdT;
        assertEquals(1L, cdT3.getId());
        assertEquals(LocalDate.now(), cdT3.getDataCandidatura());
        assertEquals("3500", cdT3.getValorPretendido());
        assertEquals("40", cdT3.getNrDias());
        assertEquals("Teste 1", cdT3.getTxtApresentacao());
        assertEquals("Teste 2", cdT3.getTxtMotivacao());
        assertEquals("T003", cdT3.getRefAnuncio());
        assertEquals("freela01@fl.pt", cdT3.getEmailFreelancer());
        assertEquals(1, cdT3.getClassificacao());
        assertEquals("colaboradorA@teste.pt", cdT3.getEmailColaboradorClassificou());
    }

}
