/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import t4j.app.exception.ElementoInvalidoException;

/**
 *
 * @author Upskill
 */
public class HabilitacaoAcademicaTest {
    HabilitacaoAcademica haT, ha, ha2, ha3;
    Object obj;
    
    public HabilitacaoAcademicaTest() {
        ha = new HabilitacaoAcademica(1L, "1", "Curso", "Instituição", "20", "freel@mail.pt");
        ha2 = new HabilitacaoAcademica(ha);
        ha3 = new HabilitacaoAcademica("2", "Curso 2", "Instituição 2", "19", "freel2@mail.pt");
        obj = new Object();
    }

    /**
     * Test of getId method, of class HabilitacaoAcademica.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        assertEquals(1, ha.getId());
    }

    /**
     * Test of getGrau method, of class HabilitacaoAcademica.
     */
    @Test
    public void testGetGrau() {
        System.out.println("getGrau");
        assertEquals("1", ha.getGrau());
    }

    /**
     * Test of getDesignacaocurso method, of class HabilitacaoAcademica.
     */
    @Test
    public void testGetDesignacaocurso() {
        System.out.println("getDesignacaoCurso");
        assertEquals("Curso", ha.getDesignacaocurso());
    }

    /**
     * Test of getNomeinstituicao method, of class HabilitacaoAcademica.
     */
    @Test
    public void testGetNomeinstituicao() {
        System.out.println("getNomeInstituicao");
        assertEquals("Instituição", ha.getNomeinstituicao());
    }

    /**
     * Test of getMediacurso method, of class HabilitacaoAcademica.
     */
    @Test
    public void testGetMediacurso() {
        System.out.println("getMediaCurso");
        assertEquals("20", ha.getMediacurso());
    }

    /**
     * Test of getEmailFreelancer method, of class HabilitacaoAcademica.
     */
    @Test
    public void testGetEmailFreelancer() {
        System.out.println("getEmailFreelancer");
        assertEquals("freel@mail.pt", ha.getEmailFreelancer());
    }

    /**
     * Test of setGrau method, of class HabilitacaoAcademica.
     */
    @Test
    public void testSetGrau() {
        System.out.println("setGrau");
        String grau = "2";
        ha.setGrau(grau);
        assertEquals(grau, ha.getGrau());
        
        //Testes de insucesso
        String grau2 = " ";
        Throwable e2 = assertThrows(ElementoInvalidoException.class, () -> ha.setGrau(grau2));
        assertEquals("Grau inválido.", e2.getMessage());
    }

    /**
     * Test of setDesignacaoCurso method, of class HabilitacaoAcademica.
     */
    @Test
    public void testSetDesignacaoCurso() {
        //Testes de sucesso
        System.out.println("setDesignacaoCurso");
        String curso = "Curso 2";
        ha.setDesignacaoCurso(curso);
        assertEquals(curso, ha.getDesignacaocurso());
        
        //Testes de insucesso
        String curso2 = " ";
        Throwable e2 = assertThrows(ElementoInvalidoException.class, () -> ha.setDesignacaoCurso(curso2));
        assertEquals("Designação de Curso inválida.", e2.getMessage());
        
    }

    /**
     * Test of setNomeInstituicao method, of class HabilitacaoAcademica.
     */
    @Test
    public void testSetNomeInstituicao() {
        System.out.println("setNomeInstituicao");
        String inst = "Instituição 2";
        ha.setNomeInstituicao(inst);
        assertEquals(inst, ha.getNomeinstituicao());
        
        //Testes de insucesso
        String inst2 = " ";
        Throwable e2 = assertThrows(ElementoInvalidoException.class, () -> ha.setNomeInstituicao(inst2));
        assertEquals("Nome de instituição inválido.", e2.getMessage());
    }

    /**
     * Test of setMediaCurso method, of class HabilitacaoAcademica.
     */
    @Test
    public void testSetMediaCurso() {
        System.out.println("setMediaCurso");
        String media = "19";
        ha.setMediaCurso(media);
        assertEquals(media, ha.getMediacurso());
        
        //Testes de insucesso
        String media2 = "21";
        Throwable e2 = assertThrows(ElementoInvalidoException.class, () -> ha.setMediaCurso(media2));
        assertEquals("Média Inválida", e2.getMessage());
    }

    /**
     * Test of setEmailFreelancer method, of class HabilitacaoAcademica.
     */
    @Test
    public void testSetEmailFreelancer() {
        System.out.println("setEmailFreelancer");
        String email = "freel2@mail.pt";
        ha.setEmailFreelancer(email);
        assertEquals(email, ha.getEmailFreelancer());
    }

    /**
     * Test of setId method, of class HabilitacaoAcademica.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 2L;
        ha.setId(id);
        assertEquals(id, ha.getId());
    }

    /**
     * Test of toString method, of class HabilitacaoAcademica.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
        String ts1 = "HabilitacaoAcademica{id=1, grau=1, designacaocurso=Curso, nomeinstituicao=Instituição, mediacurso=20, emailFreelancer=freel@mail.pt}";
        assertEquals(ts1, ha.toString());
        
        haT = new HabilitacaoAcademica();
        String ts2 = "HabilitacaoAcademica{id=null, grau=null, designacaocurso=null, nomeinstituicao=null, mediacurso=null, emailFreelancer=null}";
        assertEquals(ts2, haT.toString());
    }

    /**
     * Test of equals method, of class HabilitacaoAcademica.
     */
    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        assertEquals(ha, ha);
        assertEquals(ha.hashCode(), ha.hashCode());
        assertEquals(ha3, ha3);
        assertEquals(ha3.hashCode(), ha3.hashCode());
        
    }
    
    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");
        // Testes de sucesso
        assertEquals(ha, ha2);
        assertEquals(ha.hashCode(), ha2.hashCode());
        assertEquals(ha2, ha);
        assertEquals(ha2.hashCode(), ha.hashCode());
        // Testes de insucesso
        assertNotEquals(ha, ha3);
        assertNotEquals(ha.hashCode(), ha3.hashCode());
        assertNotEquals(ha3, ha);
        assertNotEquals(ha3.hashCode(), ha.hashCode());
    }

    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        assertNotEquals(ha, null);
        assertNotEquals(ha2, null);
        assertNotEquals(ha3, null);
        assertNotEquals(obj, null);
        
    }

    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: objetos de classes diferentes");
        assertNotEquals(ha, obj);
        assertNotEquals(ha.hashCode(), obj.hashCode());
        assertNotEquals(ha2, obj);
        assertNotEquals(ha2.hashCode(), obj.hashCode());
        assertNotEquals(ha3, obj);
        assertNotEquals(ha3.hashCode(), obj.hashCode());
        
    }

    @Test
    public void testEqualsCoverage() {
        System.out.println("equals: testa todas as propriedades");
        

        ha2.setId(100L);
        System.out.println(ha.toString());
        System.out.println(ha2.toString());
        assertNotEquals(ha, ha2);
        ha2.setId(ha.getId());
        
        ha2.setGrau("99");
        assertNotEquals(ha, ha2);
        ha2.setGrau(ha.getGrau());
        
        ha2.setDesignacaoCurso("Curso 100");
        assertNotEquals(ha, ha2);
        ha2.setDesignacaoCurso(ha.getDesignacaocurso());
        
        ha2.setNomeInstituicao("Instituição X");
        assertNotEquals(ha, ha2);
        ha2.setNomeInstituicao(ha.getNomeinstituicao());
        
        ha2.setMediaCurso("19");
        assertNotEquals(ha, ha2);
        ha2.setMediaCurso(ha.getMediacurso());
        
        ha2.setEmailFreelancer("freel100@mail.pt");
        assertNotEquals(ha, ha2);
        ha2.setEmailFreelancer(ha.getEmailFreelancer());

        
    }
    
}
