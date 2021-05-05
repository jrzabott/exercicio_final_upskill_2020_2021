/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.model;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import t4j.app.exception.ElementoInvalidoException;

/**
 *
 * @author Upskill
 */
public class TarefaTest {

    private AreaAtividade at, at2;
    private CategoriaTarefa cat, cat2;
    private CompetenciaTecnica ct;
    private CaraterCompetenciaTecnica cct;
    private GrauProficiencia grau;
    private Tarefa tt, t1, t2, t3;
    private Object obj;

    public TarefaTest() {
        at = new AreaAtividade("ITTEC", "Tecnologia da Informação", "Atividades relacionadas à informações e tecnologias");
        at2 = new AreaAtividade("ITTEC2", "Tecnologia da Informação", "Atividades relacionadas à informações e tecnologias");
        grau = new GrauProficiencia("1", "Designação");
        ArrayList<GrauProficiencia> listaGraus = new ArrayList<>();
        listaGraus.add(grau);
        ct = new CompetenciaTecnica("CodigoCT", "Descrição Breve", "Descrição Detalhada", at, listaGraus);
        cct = new CaraterCompetenciaTecnica(true, ct, grau);
        ArrayList<CaraterCompetenciaTecnica> listaCCT = new ArrayList<>();
        listaCCT.add(cct);
        cat = new CategoriaTarefa("Upskill", at, listaCCT);
        cat2 = new CategoriaTarefa("Upskill2", at2, listaCCT);
        t1 = new Tarefa("T001", "Designacao", "DescricaoInformal", "DescricaoTecnica", "10", 450.20, cat, "colab@mail.pt", "123456789");
        t2 = new Tarefa(t1);
        t3 = new Tarefa("T002", "Designacao", "DescricaoInformal", "DescricaoTecnica", "10", 450.20, cat);
        tt = new Tarefa();
        obj = new Object();
    }
    
    /**
     * Test of getReferencia method, of class Tarefa.
     */
    @Test
    public void testGetReferencia() {
        System.out.println("getReferencia");
        assertEquals("T001", t1.getReferencia());
    }

    /**
     * Test of getDesignacao method, of class Tarefa.
     */
    @Test
    public void testGetDesignacao() {
        System.out.println("getDesignacao");
        assertEquals("Designacao", t1.getDesignacao());
    }

    /**
     * Test of getDescricaoInformal method, of class Tarefa.
     */
    @Test
    public void testGetDescricaoInformal() {
        System.out.println("getDescricaoInformal");
        assertEquals("DescricaoInformal", t1.getDescricaoInformal());
    }

    /**
     * Test of getDescricaoTecnica method, of class Tarefa.
     */
    @Test
    public void testGetDescricaoTecnica() {
        System.out.println("getDescricaoTecnica");
        assertEquals("DescricaoTecnica", t1.getDescricaoTecnica());
    }

    /**
     * Test of getDuracaoEstimada method, of class Tarefa.
     */
    @Test
    public void testGetDuracaoEstimada() {
        System.out.println("getDuracaoEstimado");
        assertEquals("10", t1.getDuracaoEstimada());
    }

    /**
     * Test of getCustoEstimado method, of class Tarefa.
     */
    @Test
    public void testGetCustoEstimado() {
        System.out.println("getCustoEstimado");
        assertEquals(450.20, t1.getCustoEstimado());
    }

    /**
     * Test of getCategoria method, of class Tarefa.
     */
    @Test
    public void testGetCategoria() {
        System.out.println("getCategoria");
        assertEquals(cat, t1.getCategoria());
    }

    /**
     * Test of getColaborador method, of class Tarefa.
     */
//    @Test
    public void testGetColaborador() {
    }

    /**
     * Test of getEmailColaborador method, of class Tarefa.
     */
    @Test
    public void testGetEmailColaborador() {
        System.out.println("getEmailColaborador");
        assertEquals("colab@mail.pt", t1.getEmailColaborador());
    }

    /**
     * Test of getNifOrganizacao method, of class Tarefa.
     */
    @Test
    public void testGetNifOrganizacao() {
        System.out.println("getNifOrganizacao");
        assertEquals("123456789", t1.getNifOrganizacao());
    }

    /**
     * Test of setReferencia method, of class Tarefa.
     */
    @Test
    public void testSetReferencia() {
        //Testes de sucesso
        String ref1 = "Ref1";
        t1.setReferencia(ref1);
        assertEquals(ref1, t1.getReferencia());
        //Testes de insucesso
//        System.out.println("setRef Vazia");
        String ref2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {
            t1.setReferencia(ref2);
        });
        assertEquals("Referência inválida.", exception2.getMessage());
//        System.out.println("setRef maxLength");
        String ref3 = String.format("|%22d|", 0);
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {
            t1.setReferencia(ref3);
        });
        assertEquals("Referência inválida.", exception3.getMessage());
//        System.out.println("setRef c/Carateres especiais");
        String ref4 = "Ref1$";
        Throwable exception4 = assertThrows(ElementoInvalidoException.class, () -> {
            t1.setReferencia(ref4);
        });
        assertEquals("Referência inválida.", exception4.getMessage());
    }

    /**
     * Test of setDesignacao method, of class Tarefa.
     */
    @Test
    public void testSetDesignacao() {
        //Testes de sucesso
        String designacao1 = "Designação";
        t1.setDesignacao(designacao1);
        assertEquals(designacao1, t1.getDesignacao());
        //Testes de insucesso
//        System.out.println("setDesignacao Vazia");
        String designacao2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {
            t1.setDesignacao(designacao2);
        });
        assertEquals("Designação inválida.", exception2.getMessage());
//        System.out.println("setDesignacao maxLength");
        String designacao3 = String.format("|%65d|", 0);
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {
            t1.setDesignacao(designacao3);
        });
        assertEquals("Designação inválida.", exception3.getMessage());
    }

    /**
     * Test of setDescricaoInformal method, of class Tarefa.
     */
    @Test
    public void testSetDescricaoInformal() {
        //Testes de sucesso
        String descInformal1 = "Descrição Informal";
        t1.setDescricaoInformal(descInformal1);
        assertEquals(descInformal1, t1.getDescricaoInformal());
        //Testes de insucesso
//        System.out.println("setDescInformal Vazia");
        String descInformal2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {
            t1.setDescricaoInformal(descInformal2);
        });
        assertEquals("Descrição informal inválida.", exception2.getMessage());
    }

    /**
     * Test of setDescricaoTecnica method, of class Tarefa.
     */
    @Test
    public void testSetDescricaoTecnica() {
        //Testes de sucesso
        String descTecnica1 = "Descrição Técnica";
        t1.setDescricaoTecnica(descTecnica1);
        assertEquals(descTecnica1, t1.getDescricaoTecnica());
        //Testes de insucesso
//        System.out.println("setDescTecnica Vazia");
        String descTecnica2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {
            t1.setDescricaoTecnica(descTecnica2);
        });
        assertEquals("Descrição técnica inválida.", exception2.getMessage());
    }

    /**
     * Test of setDuracaoEstimada method, of class Tarefa.
     */
    @Test
    public void testSetDuracaoEstimada() {
        //Testes de sucesso
        String duracaoEst1 = "700";
        t1.setDuracaoEstimada(duracaoEst1);
        assertEquals(duracaoEst1, t1.getDuracaoEstimada());
        //Testes de insucesso
//        System.out.println("setDuracaoEstimada Vazia");
        String duracaoEst2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {
            t1.setDuracaoEstimada(duracaoEst2);
        });
        assertEquals("Duração inválida.", exception2.getMessage());
//        System.out.println("setDuracaoEstimada Non-Digits");
        String duracaoEst3 = "700h";
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {
            t1.setDuracaoEstimada(duracaoEst3);
        });
        assertEquals("Duração inválida.", exception3.getMessage());
//        System.out.println("setDuracaoEstimada maxLength");
        String duracaoEst4 = "3000000";
        Throwable exception4 = assertThrows(ElementoInvalidoException.class, () -> {
            t1.setDuracaoEstimada(duracaoEst4);
        });
        assertEquals("Duração inválida.", exception4.getMessage());
    }
//
//    /**
//     * Test of setCustoEstimado method, of class Tarefa.
//     */
//    @Test
//    public void testSetCustoEstimado() {
//        //Testes de sucesso
//        String custoEst1 = "715.239";
//        t1.setCustoEstimado(custoEst1);
//        assertEquals(custoEst1, t1.getCustoEstimado());
//        //Testes de insucesso
////        System.out.println("setCustoEstimado Vazio");
//        String custoEst2 = "   ";
//        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {
//            t1.setCustoEstimado(custoEst2);
//        });
//        assertEquals("Custo inválido.", exception2.getMessage());
////        System.out.println("setCustoEstimado Non-Digits");
//        String custoEst3 = "700h";
//        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {
//            t1.setCustoEstimado(custoEst3);
//        });
//        assertEquals("Custo inválido.", exception3.getMessage());
////        System.out.println("setCustoEstimado maxLength");
//        String custoEst4 = "300.000.000.000,00";
//        Throwable exception4 = assertThrows(ElementoInvalidoException.class, () -> {
//            t1.setCustoEstimado(custoEst4);
//        });
//        assertEquals("Custo inválido.", exception4.getMessage());
//    }

    /**
     * Test of setCategoria method, of class Tarefa.
     */
    @Test
    public void testSetCategoria() {
        System.out.println("setCategoria");
        t1.setCategoria(cat2);
        assertEquals(cat2, t1.getCategoria());
    }

    /**
     * Test of setColaborador method, of class Tarefa.
     */
//    @Test
    public void testSetColaborador() {
    }

    /**
     * Test of setEmailColaborador method, of class Tarefa.
     */
    @Test
    public void testSetEmailColaborador() {
        System.out.println("setEmailColaborador");
        String email = "colab2@mail.pt";
        t1.setEmailColaborador(email);
        assertEquals(email, t1.getEmailColaborador());
        
    }

    /**
     * Test of setNifOrganizacao method, of class Tarefa.
     */
    @Test
    public void testSetNifOrganizacao() {
        System.out.println("setNifOrganizacao");
        String nifOrg = "234567890";
        t1.setNifOrganizacao(nifOrg);
        assertEquals(nifOrg, t1.getNifOrganizacao());
    }

    /**
     * Test of toString method, of class Tarefa.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String ts1 = "Tarefa{referencia=T001, designacao=Designacao, descricaoInformal=DescricaoInformal, descricaoTecnica=DescricaoTecnica, duracaoEstimada=10, custoEstimado=450.2, categoria=CategoriaTarefa{idCategoria=0, descricaoCategoria=Upskill, areaAtividade=AreaAtividade{codigoAreaAtividade=ITTEC, descricaoBreve=Tecnologia da Informação, descricaoDetalhada=Atividades relacionadas à informações e tecnologias}, listaCaraterCompetenciaTecnica=[CaraterCompetenciaTecnica{id=null, obrigatorio=true, obrigatorioAsString=0, competenciaTecnica=CompetenciaTecnica{codigoCompetenciaTecnica=CodigoCT, descricaoBreve=Descrição Breve, descricaoDetalhada=Descrição Detalhada, areaAtividade=AreaAtividade{codigoAreaAtividade=ITTEC, descricaoBreve=Tecnologia da Informação, descricaoDetalhada=Atividades relacionadas à informações e tecnologias}, grausProficiencia=[GrauProficiencia{id=null, valorGrauProficiencia=1, designacaoGrauProficiencia=Designação}]}, grauProficiencia=GrauProficiencia{id=null, valorGrauProficiencia=1, designacaoGrauProficiencia=Designação}}]}, colaborador=null, emailColaborador=colab@mail.pt, nifOrganizacao=123456789}";
        assertEquals(ts1, t1.toString());
        
        String ts2 = "Tarefa{referencia=null, designacao=null, descricaoInformal=null, descricaoTecnica=null, duracaoEstimada=null, custoEstimado=null, categoria=CategoriaTarefa{idCategoria=0, descricaoCategoria=null, areaAtividade=AreaAtividade{codigoAreaAtividade=null, descricaoBreve=null, descricaoDetalhada=null}, listaCaraterCompetenciaTecnica=[]}, colaborador=null, emailColaborador=null, nifOrganizacao=null}";
        assertEquals(ts2, tt.toString());
        
    }

    /**
     * Test of equals method, of class Tarefa.
     */
    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        assertEquals(t1, t1);
        assertEquals(t1.hashCode(), t1.hashCode());
        assertEquals(t3, t3);
        assertEquals(t3.hashCode(), t3.hashCode());
    }

    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");
        // Testes de sucesso
        assertEquals(t1, t2);
        assertEquals(t1.hashCode(), t2.hashCode());
        assertEquals(t2, t1);
        assertEquals(t2.hashCode(), t1.hashCode());
        // Testes de insucesso
        assertNotEquals(t1, t3);
        assertNotEquals(t1.hashCode(), t3.hashCode());
        assertNotEquals(t3, t1);
        assertNotEquals(t3.hashCode(), t1.hashCode());
    }

    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        assertNotEquals(t1, null);
        assertNotEquals(t1, null);
        assertNotEquals(t3, null);
        assertNotEquals(obj, null);
    }

    @Test
    public void testEqualsCoverage() {
        System.out.println("equals: testa todas as propriedades");

        t2.setReferencia("T100");
        assertNotEquals(t1, t2);
        t2.setReferencia(t1.getReferencia());

        t2.setDesignacao("Designacao100");
        assertNotEquals(t1, t2);
        t2.setDesignacao(t1.getDesignacao());

        t2.setDescricaoInformal("DescricaoInformal00");
        assertNotEquals(t1, t2);
        t2.setDescricaoInformal(t1.getDescricaoInformal());

        t2.setDescricaoTecnica("DescricaoTecnica100");
        assertNotEquals(t1, t2);
        t2.setDescricaoTecnica(t1.getDescricaoTecnica());

        t2.setDuracaoEstimada("100");
        assertNotEquals(t1, t2);
        t2.setDuracaoEstimada(t1.getDuracaoEstimada());

        t2.setCustoEstimado(550.20);
        assertNotEquals(t1, t2);
        t2.setCustoEstimado(t1.getCustoEstimado());
        
        t2.setCategoria(cat2);
        assertNotEquals(t1, t2);
        t2.setCategoria(t1.getCategoria());

        t2.setEmailColaborador("colab100@mail.pt");
        assertNotEquals(t1, t2);
        t2.setEmailColaborador(t1.getEmailColaborador());

        t2.setNifOrganizacao("999999999");
        assertNotEquals(t1, t2);
        t2.setNifOrganizacao(t1.getNifOrganizacao());
    }

    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: objetos de classes diferentes");
        assertNotEquals(t1, obj);
        assertNotEquals(t1.hashCode(), obj.hashCode());
        assertNotEquals(t2, obj);
        assertNotEquals(t2.hashCode(), obj.hashCode());
        assertNotEquals(t3, obj);
        assertNotEquals(t3.hashCode(), obj.hashCode());
    }

}
