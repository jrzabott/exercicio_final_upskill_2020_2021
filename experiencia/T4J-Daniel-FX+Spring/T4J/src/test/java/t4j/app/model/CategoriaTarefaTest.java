/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.model;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import t4j.app.exception.ElementoInvalidoException;

/**
 *
 * @author Upskill
 */
public class CategoriaTarefaTest {
    private AreaAtividade at, at2;
    private CompetenciaTecnica ct;
    private CaraterCompetenciaTecnica cct, cct2, cct3;
    private GrauProficiencia grau, grau2;
    private List<GrauProficiencia> listaGraus = new ArrayList<>();
    private List<CaraterCompetenciaTecnica> listaCCT = new ArrayList<>();
    private CategoriaTarefa catT, cat, cat2, cat3;
    private Object obj;

    public CategoriaTarefaTest() {
        at = new AreaAtividade("ITTEC", "Tecnologia da Informação", "Atividades relacionadas à informações e tecnologias");
        at2 = new AreaAtividade("ITTEC2", "Tecnologia da Informação", "Atividades relacionadas à informações e tecnologias");
        grau = new GrauProficiencia("1", "Designação");
        grau2 = new GrauProficiencia("2", "Designação");
        listaGraus.add(grau);
        ct = new CompetenciaTecnica("CodigoCT", "Descrição Breve", "Descrição Detalhada", at, listaGraus);
        cct = new CaraterCompetenciaTecnica(true, ct, grau);
        cct2 = new CaraterCompetenciaTecnica(true, ct, grau2);
        cct3 = new CaraterCompetenciaTecnica(false, ct, grau);
        listaCCT.add(cct);
        cat = new CategoriaTarefa("Upskill", at, listaCCT);
        cat2 = new CategoriaTarefa(cat);
        cat3 = new CategoriaTarefa("Upskill2", at, listaCCT);
        obj = new Object();
        catT = new CategoriaTarefa();
    }

    /**
     * Test of getIdCategoria method, of class CategoriaTarefa.
     */
    @Test
    public void testGetIdCategoria() {
        System.out.println("getIdCategoria");
        assertEquals(0, cat.getIdCategoria());
    }

    /**
     * Test of getDescricaoCategoria method, of class CategoriaTarefa.
     */
    @Test
    public void testGetDescricaoCategoria() {
        System.out.println("getDescricaoCategoria");
        assertEquals("Upskill", cat.getDescricaoCategoria());
    }

    /**
     * Test of getListaCaraterCompetenciaTecnica method, of class CategoriaTarefa.
     */
    @Test
    public void testGetListaCaraterCompetenciaTecnica() {
        System.out.println("getListaCaraterCompetenciaTecnica");
        assertEquals(listaCCT, cat.getListaCaraterCompetenciaTecnica());
    }

    /**
     * Test of getAreaAtividade method, of class CategoriaTarefa.
     */
    @Test
    public void testGetAreaAtividade() {
        System.out.println("getAreaAtividade");
        assertEquals(at, cat.getAreaAtividade());
    }

    /**
     * Test of setDescricaoCategoria method, of class CategoriaTarefa.
     */
    @Test
    public void testSetDescricaoCategoria() {
        //Testes de sucesso
        String descricao1 = "Descrição";
        catT.setDescricaoCategoria(descricao1);
        assertEquals(descricao1, catT.getDescricaoCategoria());
        //Testes de insucesso
//        System.out.println("setDescricao Vazia");
        String descricao2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {
            catT.setDescricaoCategoria(descricao2);
        });
        assertEquals("Descrição inválida.", exception2.getMessage());
    }

    /**
     * Test of setAreaAtividade method, of class CategoriaTarefa.
     */
    @Test
    public void testSetAreaAtividade() {
        System.out.println("setAreaAtividade");
        cat.setAreaAtividade(at2);
        assertEquals(at2, cat.getAreaAtividade());
    }

    /**
     * Test of setIdCategoria method, of class CategoriaTarefa.
     */
    @Test
    public void testSetIdCategoria() {
        System.out.println("setIdCategoria");
        Long id = 2L;
        cat.setIdCategoria(id);
        assertEquals(id, cat.getIdCategoria());
    }

    /**
     * Test of setListaCaraterCompetenciaTecnica method, of class CategoriaTarefa.
     */
    @Test
    public void testSetListaCaraterCompetenciaTecnica() {
        System.out.println("setListaCaraterCompetenciaTecnica");
        listaCCT.add(cct2);
        cat.setListaCaraterCompetenciaTecnica((ArrayList) listaCCT);
        assertEquals(listaCCT, cat.getListaCaraterCompetenciaTecnica());
    }

    /**
     * Test of toString method, of class CategoriaTarefa.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
//        String ts1 = "CategoriaTarefa{idCategoria=1, descricaoCategoria=Upskill, areaAtividade=AreaAtividade{codigoAreaAtividade=ITTEC, descricaoBreve=Tecnologia da Informação, descricaoDetalhada=Atividades relacionadas à informações e tecnologias}, listaCaraterCompetenciaTecnica=[CaraterCompetenciaTecnica{id=null, obrigatorio=true, obrigatorioAsString=0, competenciaTecnica=CompetenciaTecnica{codigoCompetenciaTecnica=CodigoCT, descricaoBreve=Descrição Breve, descricaoDetalhada=Descrição Detalhada, areaAtividade=AreaAtividade{codigoAreaAtividade=ITTEC, descricaoBreve=Tecnologia da Informação, descricaoDetalhada=Atividades relacionadas à informações e tecnologias}, grausProficiencia=[GrauProficiencia{id=null, valorGrauProficiencia=1, designacaoGrauProficiencia=Designação}]}, grauProficiencia=GrauProficiencia{id=null, valorGrauProficiencia=1, designacaoGrauProficiencia=Designação}}]}";
        String ts1 = "CategoriaTarefa{idCategoria=0, descricaoCategoria=Upskill, areaAtividade=AreaAtividade{codigoAreaAtividade=ITTEC, descricaoBreve=Tecnologia da Informação, descricaoDetalhada=Atividades relacionadas à informações e tecnologias}, listaCaraterCompetenciaTecnica=[CaraterCompetenciaTecnica{id=null, obrigatorio=true, obrigatorioAsString=0, competenciaTecnica=CompetenciaTecnica{codigoCompetenciaTecnica=CodigoCT, descricaoBreve=Descrição Breve, descricaoDetalhada=Descrição Detalhada, areaAtividade=AreaAtividade{codigoAreaAtividade=ITTEC, descricaoBreve=Tecnologia da Informação, descricaoDetalhada=Atividades relacionadas à informações e tecnologias}, grausProficiencia=[GrauProficiencia{id=null, valorGrauProficiencia=1, designacaoGrauProficiencia=Designação}]}, grauProficiencia=GrauProficiencia{id=null, valorGrauProficiencia=1, designacaoGrauProficiencia=Designação}}]}";
        assertEquals(ts1, cat.toString());

        String ts2 = "CategoriaTarefa{idCategoria=0, descricaoCategoria=null, areaAtividade=AreaAtividade{codigoAreaAtividade=null, descricaoBreve=null, descricaoDetalhada=null}, listaCaraterCompetenciaTecnica=[]}";
        assertEquals(ts2, catT.toString());
    }

    /**
     * Test of equals method, of class CategoriaTarefa.
     */
    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        assertEquals(cat, cat);
        assertEquals(cat.hashCode(), cat.hashCode());
        assertEquals(cat3, cat3);
        assertEquals(cat3.hashCode(), cat3.hashCode());
    }

    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");
        // Testes de sucesso
//        assertEquals(cat, cat2);
//        assertEquals(cat.hashCode(), cat2.hashCode());
//        assertEquals(cat2, cat);
//        assertEquals(cat2.hashCode(), cat.hashCode());
        // Testes de insucesso
        assertNotEquals(cat, cat3);
        assertNotEquals(cat.hashCode(), cat3.hashCode());
        assertNotEquals(cat3, cat);
        assertNotEquals(cat3.hashCode(), cat.hashCode());
    }

    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        assertNotEquals(cat, null);
        assertNotEquals(cat, null);
        assertNotEquals(cat3, null);
        assertNotEquals(obj, null);
    }

    @Test
    public void testEqualsCoverage() {
        System.out.println("equals: testa todas as propriedades");

        cat2.setIdCategoria(1111111L);
        assertNotEquals(cat, cat2);
        cat2.setIdCategoria(cat.getIdCategoria());

        cat2.setDescricaoCategoria("DescricaoCategoria");
        assertNotEquals(cat, cat2);
        cat2.setDescricaoCategoria(cat.getDescricaoCategoria());

        cat2.setAreaAtividade(at2);
        assertNotEquals(cat, cat2);
        cat2.setAreaAtividade(cat.getAreaAtividade());

        List<CaraterCompetenciaTecnica> listaCCT2 = new ArrayList<>();
        listaCCT2.add(cct2);
        cat2.setListaCaraterCompetenciaTecnica(listaCCT2);
        assertNotEquals(cat, cat2);
        cat2.setListaCaraterCompetenciaTecnica(cat.getListaCaraterCompetenciaTecnica());
    }

    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: objetos de classes diferentes");
        assertNotEquals(cat, obj);
        assertNotEquals(cat.hashCode(), obj.hashCode());
        assertNotEquals(cat2, obj);
        assertNotEquals(cat2.hashCode(), obj.hashCode());
        assertNotEquals(cat3, obj);
        assertNotEquals(cat3.hashCode(), obj.hashCode());
    }

}
