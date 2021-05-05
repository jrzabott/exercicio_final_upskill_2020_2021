/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.model;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Upskill
 */
public class CaraterCompetenciaTecnicaTest {

    private AreaAtividade at;
    private GrauProficiencia grau, grau2;
    private CompetenciaTecnica ct, ct2;
    private CaraterCompetenciaTecnica cct, cct2, cct3;
    private Object obj;

    public CaraterCompetenciaTecnicaTest() {
        at = new AreaAtividade("ITTEC", "Tecnologia da Informação", "Atividades relacionadas à informações e tecnologias");
        grau = new GrauProficiencia("1", "Designação");
        grau2 = new GrauProficiencia("2", "Designação 2");
        ArrayList<GrauProficiencia> listaGraus = new ArrayList<>();
        listaGraus.add(grau);
        ct = new CompetenciaTecnica("CodigoCT", "Descrição Breve", "Descrição Detalhada", at, listaGraus);
        ct2 = new CompetenciaTecnica("CodigoCT2", "Descrição Breve 2", "Descrição Detalhada 2", at, listaGraus);
        cct = new CaraterCompetenciaTecnica(1L, true, "1", ct, grau);
        cct2 = new CaraterCompetenciaTecnica(cct);
        cct3 = new CaraterCompetenciaTecnica(2L, false, "0", ct, grau);
        obj = new Object();
    }
    
    /**
     * Test of getId method, of class CaraterCompetenciaTecnica.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        assertEquals(1, cct.getId());
    }

    /**
     * Test of isObrigatorio method, of class CaraterCT.
     */
    @Test
    public void testIsObrigatorio() {
        System.out.println("isObrigatorio");
        boolean result = true;
        assertEquals(result, cct.isObrigatorio());
    }
    
    /**
     * Test of getObrigatorioAsString method, of class CaraterCompetenciaTecnica.
     */
    @Test
    public void testGetObrigatorioAsString() {
        System.out.println("getObrigatorioAsString");
        assertEquals("1", cct.getObrigatorioAsString());
        
    }

    /**
     * Test of getCompetenciaTecnica method, of class CaraterCompetenciaTecnica.
     */
    @Test
    public void testGetCompetenciaTecnica() {
        System.out.println("getCompetenciaTecnica");
        assertEquals(ct, cct.getCompetenciaTecnica());
    }

    /**
     * Test of getGrauProficiencia method, of class CaraterCompetenciaTecnica.
     */
    @Test
    public void testGetGrauProficiencia() {
        System.out.println("getGrauProficiencia");
        assertEquals(grau, cct.getGrauProficiencia());
    }
    
    /**
     * Test of setId method, of class CaraterCompetenciaTecnica.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 2L;
        cct.setId(id);
        assertEquals(id, cct.getId());
    }
    
    /**
     * Test of setObrigatorio method, of class CaraterCT.
     */
    @Test
    public void testSetObrigatorio() {
        //Testes de sucesso
        boolean result = true;
        cct.setObrigatorio(result);
        assertEquals(result, cct.isObrigatorio());
        
        boolean result2 = false;
        cct.setObrigatorio(result2);
        assertEquals(result2, cct.isObrigatorio());
    }
    
    /**
     * Test of setObrigatorioAsString method, of class CaraterCompetenciaTecnica.
     */
    @Test
    public void testSetObrigatorioAsString() {
        System.out.println("setObrigatorioAsString");
        boolean result = false;
        cct.setObrigatorio(result);
        cct.setObrigatorioAsString(cct.getObrigatorioAsString());
        assertEquals("0", cct.getObrigatorioAsString());
    }
    
    /**
     * Test of setCompetenciaTecnica method, of class CaraterCompetenciaTecnica.
     */
    @Test
    public void testSetCompetenciaTecnica() {
        System.out.println("setCompetenciaTecnica");
        cct.setCompetenciaTecnica(ct2);
        assertEquals(ct2, cct.getCompetenciaTecnica());
    }

    /**
     * Test of setGrauProficiencia method, of class CaraterCompetenciaTecnica.
     */
    @Test
    public void testSetGrauProficiencia() {
        System.out.println("setGrauProficiencia");
        cct.setGrauProficiencia(grau2);
        assertEquals(grau2, cct.getGrauProficiencia());
        
    }
    
    /**
     * Test of toString method, of class CaraterCompetenciaTecnica.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String ts1 = "CaraterCompetenciaTecnica{id=1, obrigatorio=true, obrigatorioAsString=1, competenciaTecnica=CompetenciaTecnica{codigoCompetenciaTecnica=CodigoCT, descricaoBreve=Descrição Breve, descricaoDetalhada=Descrição Detalhada, areaAtividade=AreaAtividade{codigoAreaAtividade=ITTEC, descricaoBreve=Tecnologia da Informação, descricaoDetalhada=Atividades relacionadas à informações e tecnologias}, grausProficiencia=[GrauProficiencia{id=null, valorGrauProficiencia=1, designacaoGrauProficiencia=Designação}]}, grauProficiencia=GrauProficiencia{id=null, valorGrauProficiencia=1, designacaoGrauProficiencia=Designação}}";
        assertEquals(ts1, cct.toString());
        
        CaraterCompetenciaTecnica cctT = new CaraterCompetenciaTecnica();
        String ts2 = "CaraterCompetenciaTecnica{id=null, obrigatorio=false, obrigatorioAsString=0, competenciaTecnica=CompetenciaTecnica{codigoCompetenciaTecnica=null, descricaoBreve=null, descricaoDetalhada=null, areaAtividade=AreaAtividade{codigoAreaAtividade=null, descricaoBreve=null, descricaoDetalhada=null}, grausProficiencia=[]}, grauProficiencia=GrauProficiencia{id=null, valorGrauProficiencia=null, designacaoGrauProficiencia=null}}";
        assertEquals(ts2, cctT.toString());
    }

    /**
     * Test of equals method, of class CaraterCT.
     */
    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        assertEquals(cct, cct);
        assertEquals(cct.hashCode(), cct.hashCode());
        assertEquals(cct3, cct3);
        assertEquals(cct3.hashCode(), cct3.hashCode());
    }

    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");
        // Testes de sucesso
        assertEquals(cct, cct2);
        assertEquals(cct.hashCode(), cct2.hashCode());
        assertEquals(cct2, cct);
        assertEquals(cct2.hashCode(), cct.hashCode());
        // Testes de insucesso
        assertNotEquals(cct, cct3);
        assertNotEquals(cct.hashCode(), cct3.hashCode());
        assertNotEquals(cct3, cct);
        assertNotEquals(cct3.hashCode(), cct.hashCode());
    }

    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        assertNotEquals(cct, null);
        assertNotEquals(cct, null);
        assertNotEquals(cct3, null);
        assertNotEquals(obj, null);
    }

    @Test
    public void testEqualsCoverage() {
        System.out.println("equals: testa todas as propriedades");

        cct2.setId(1111111L);
        assertNotEquals(cct, cct2);
        cct2.setId(cct.getId());

        cct2.setObrigatorio(false);
        assertNotEquals(cct, cct2);
        cct2.setObrigatorio(cct.isObrigatorio());

        cct2.setObrigatorioAsString("0");
        assertNotEquals(cct, cct2);
        cct2.setObrigatorioAsString(cct.getObrigatorioAsString());

        cct2.setCompetenciaTecnica(ct2);
        assertNotEquals(cct, cct2);
        cct2.setCompetenciaTecnica(cct.getCompetenciaTecnica());

        cct2.setGrauProficiencia(grau2);
        assertNotEquals(cct, cct2);
        cct2.setGrauProficiencia(cct.getGrauProficiencia());
    }

    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: objetos de classes diferentes");
        assertNotEquals(cct, obj);
        assertNotEquals(cct.hashCode(), obj.hashCode());
        assertNotEquals(cct2, obj);
        assertNotEquals(cct2.hashCode(), obj.hashCode());
        assertNotEquals(cct3, obj);
        assertNotEquals(cct3.hashCode(), obj.hashCode());
    }

}
