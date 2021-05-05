/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import t4j.app.exception.ElementoInvalidoException;

/**
 *
 * @author Upskill
 */
public class CompetenciaTecnicaTest {

    private AreaAtividade at, at2;
    private GrauProficiencia grau, grau2, grau3;
    private List<GrauProficiencia> listaGraus = new ArrayList<>();
    private CompetenciaTecnica ctT, ct, ct2, ct3;
    private Object obj;

    public CompetenciaTecnicaTest() {
        at = new AreaAtividade("ITTEC", "Tecnologia da Informação", "Atividades relacionadas à informações e tecnologias");
        at2 = new AreaAtividade("ITTEC2", "Tecnologia da Informação", "Atividades relacionadas à informações e tecnologias");
        grau = new GrauProficiencia("1", "Designação");
        grau2 = new GrauProficiencia("2", "Designação");
        grau3 = new GrauProficiencia("1", "Designação2");
        listaGraus.add(grau);
        ct = new CompetenciaTecnica("CodigoCT", "Descrição Breve", "Descrição Detalhada", at, listaGraus);
        ct2 = new CompetenciaTecnica(ct);
        ct3 = new CompetenciaTecnica("CodigoCT2", "Descrição Breve", "Descrição Detalhada", at, listaGraus);
        ctT = new CompetenciaTecnica();
        obj = new Object();
    }
    
    /**
     * Test of getCodigoCompetenciaTecnica method, of class CompetenciaTecnica.
     */
    @Test
    public void testGetCodigoCompetenciaTecnica() {
        System.out.println("getCodigoCompetenciaTecnica");
        assertEquals("CodigoCT", ct.getCodigoCompetenciaTecnica());
    }
    
    /**
     * Test of getDescricaoBreve method, of class CompetenciaTecnica.
     */
    @Test
    public void testGetDescricaoBreve() {
        System.out.println("getDescricaoBreve");
        assertEquals("Descrição Breve", ct.getDescricaoBreve());
    }
    
    /**
     * Test of getDescricaoDetalhada method, of class CompetenciaTecnica.
     */
    @Test
    public void testGetDescricaoDetalhada() {
        System.out.println("getDescricaoDetalhada");
        assertEquals("Descrição Detalhada", ct.getDescricaoDetalhada());
    }
    
    /**
     * Test of getAreaAtividade method, of class CompetenciaTecnica.
     */
    @Test
    public void testGetAreaAtividade() {
        System.out.println("getAreaATividade");
        assertEquals(at, ct.getAreaAtividade());
    }
    
    /**
     * Test of getGrausProficiencia method, of class CompetenciaTecnica.
     */
    @Test
    public void testGetGrausProficiencia() {
        System.out.println("getGrausProficiencia");
        assertEquals(listaGraus, ct.getGrausProficiencia());
    }

    /**
     * Test of setCodigoCompetenciaTecnica method, of class CompetenciaTecnica.
     */
    @Test
    public void testSetCodigoCompetenciaTecnica() {
        //Testes de sucesso
        String codCT1 = "CodCT1";
        ctT.setCodigoCompetenciaTecnica(codCT1);
        assertEquals(codCT1, ctT.getCodigoCompetenciaTecnica());
        //Testes de insucesso
//        System.out.println("setCodCT Vazio");
        String codCT2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {
            ctT.setCodigoCompetenciaTecnica(codCT2);
        });
        assertEquals("Código inválido.", exception2.getMessage());
//        System.out.println("setCodCT maxLength");
        String codCT3 = String.format("|%22d|", 0);
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {
            ctT.setCodigoCompetenciaTecnica(codCT3);
        });
        assertEquals("Código inválido.", exception3.getMessage());
//        System.out.println("setCodCT c/Carateres especiais");
        String codCT4 = "Ref1$";
        Throwable exception4 = assertThrows(ElementoInvalidoException.class, () -> {
            ctT.setCodigoCompetenciaTecnica(codCT4);
        });
        assertEquals("Código inválido.", exception4.getMessage());
    }

    /**
     * Test of setDescricaoBreve method, of class CompetenciaTecnica.
     */
    @Test
    public void testSetDescricaoBreve() {
        //Testes de sucesso
        String descBreve1 = "Descrição Breve";
        ctT.setDescricaoBreve(descBreve1);
        assertEquals(descBreve1, ctT.getDescricaoBreve());
        //Testes de insucesso
//        System.out.println("setDescBreve Vazia");
        String descBreve2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {
            ctT.setDescricaoBreve(descBreve2);
        });
        assertEquals("Descrição breve inválida.", exception2.getMessage());
//        System.out.println("setDescBreve maxLength");
        String descBreve3 = String.format("|%62d|", 0);
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {
            ctT.setDescricaoBreve(descBreve3);
        });
        assertEquals("Descrição breve inválida.", exception3.getMessage());
    }

    /**
     * Test of setDescricaoDetalhada method, of class CompetenciaTecnica.
     */
    @Test
    public void testSetDescricaoDetalhada() {
        //Testes de sucesso
        String descDetalhada1 = "Descrição Detalhada";
        ctT.setDescricaoDetalhada(descDetalhada1);
        assertEquals(descDetalhada1, ctT.getDescricaoDetalhada());
        //Testes de insucesso
//        System.out.println("setDescDetalhada Vazia");
        String descDetalhada2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {
            ctT.setDescricaoDetalhada(descDetalhada2);
        });
        assertEquals("Descrição detalhada inválida.", exception2.getMessage());
    }
    
    /**
     * Test of setAreaAtividade method, of class CompetenciaTecnica.
     */
    @Test
    public void testSetAreaAtividade() {
        System.out.println("setAreaAtividade");
        ct.setAreaAtividade(at2);
        assertEquals(at2, ct.getAreaAtividade());
    }
    
    /**
     * Test of setGrausProficiencia method, of class CompetenciaTecnica.
     */
    @Test
    public void testSetGrausProficiencia() {
        System.out.println("setGrausProficiencia");
        listaGraus.add(grau2);
        ct.setGrausProficiencia(listaGraus);
        assertEquals(listaGraus, ct.getGrausProficiencia());
    }
    
    /**
     * Test of toString method, of class CompetenciaTecnica.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String ts1 = "CompetenciaTecnica{codigoCompetenciaTecnica=CodigoCT, descricaoBreve=Descrição Breve, descricaoDetalhada=Descrição Detalhada, areaAtividade=AreaAtividade{codigoAreaAtividade=ITTEC, descricaoBreve=Tecnologia da Informação, descricaoDetalhada=Atividades relacionadas à informações e tecnologias}, grausProficiencia=[GrauProficiencia{id=null, valorGrauProficiencia=1, designacaoGrauProficiencia=Designação}]}";
        assertEquals(ts1, ct.toString());
        
        String ts2 = "CompetenciaTecnica{codigoCompetenciaTecnica=null, descricaoBreve=null, descricaoDetalhada=null, areaAtividade=AreaAtividade{codigoAreaAtividade=null, descricaoBreve=null, descricaoDetalhada=null}, grausProficiencia=[]}";
        assertEquals(ts2, ctT.toString());
    }
    
    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        assertEquals(ct, ct);
        assertEquals(ct3, ct3);
    }

    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");
        // Testes de sucesso
        assertEquals(ct, ct2);
        assertEquals(ct2, ct);
        // Testes de insucesso
        assertNotEquals(ct, ct3);
        assertNotEquals(ct3, ct);
    }

    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        assertNotEquals(ct, null);
        assertNotEquals(ct3, null);
        assertNotEquals(obj, null);
    }

    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: objetos de classes diferentes");
        assertNotEquals(ct, obj);
        assertNotEquals(ct2, obj);
        assertNotEquals(ct3, obj);
    }
    
    @Test
    public void testEqualsCoverage() {
        System.out.println("equals: testa todas as propriedades");

        ct2.setCodigoCompetenciaTecnica("CodigoCT100");
        assertNotEquals(ct, ct2);
        ct2.setCodigoCompetenciaTecnica(ct.getCodigoCompetenciaTecnica());


        ct2.setDescricaoBreve("Descrição Breve 100");
        assertNotEquals(ct, ct2);
        ct2.setDescricaoBreve(ct.getDescricaoBreve());

        ct2.setDescricaoDetalhada("Descrição Detalhada 100");
        assertNotEquals(ct, ct2);
        ct2.setDescricaoDetalhada(ct.getDescricaoDetalhada());

        ct2.setAreaAtividade(at2);
        assertNotEquals(ct, ct2);
        ct2.setAreaAtividade(ct.getAreaAtividade());
        
        listaGraus.add(grau2);
        ct2.setGrausProficiencia(listaGraus);
        assertNotEquals(ct, ct2);
        ct2.setGrausProficiencia(ct.getGrausProficiencia());

    }

}
