package t4j.app.model;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import t4j.app.exception.ElementoInvalidoException;

public class AnuncioTest {

    private Anuncio aT, a, a2, a3;
    private LocalDate dip, dfp, dic, dfc, dis, dfs;
    private Object obj;
    private String t;
    private Long tr;
    
    public AnuncioTest() {
        a = new Anuncio("Tarefa1", dip, dfp, dic, dfc, dis, dfs, tr);
        a2 = new Anuncio(a);
        a3 = new Anuncio("Tarefa2", dip, dfp, dic, dfc, dis, dfs, tr);
        aT = new Anuncio();
        obj = new Object();
        dip = LocalDate.of(2021, 02, 19);
        dfp = LocalDate.of(2021, 03, 19);
        dic = LocalDate.of(2021, 02, 19);
        dfc = LocalDate.of(2021, 03, 10);
        dis = LocalDate.of(2021, 03, 11);
        dfs = LocalDate.of(2021, 03, 19);
        t = new Tarefa().getReferencia();
    }

    /**
     * Test of setReferencia method, of class Anuncio.
     */
    @Test
    public void testSetReferencia() {
        System.out.println("setReferencia");
        //Testes de sucesso
        String r1 = "TRC";
        aT.setReferencia(r1);
        assertEquals(r1, aT.getReferencia());
        //Testes de insucesso
        String r2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {aT.setReferencia(r2);});
        assertEquals("Referência inválida.", exception2.getMessage());
//        System.out.println("setCodigo maxLength");
        String r3 = String.format("|%21d|", 0);
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {aT.setReferencia(r3);});
        assertEquals("Referência inválida.", exception3.getMessage());
//        System.out.println("setCodigo c/Carateres especiais");
        String r4 = "Codigo4$";
        Throwable exception4 = assertThrows(ElementoInvalidoException.class, () -> {aT.setReferencia(r4);});
        assertEquals("Referência inválida.", exception4.getMessage());
    }

    /**
     * Test of setDataRegistoAnuncio method, of class Anuncio.
     */
    @Test
    public void testSetDataRegistoAnuncio() {
        System.out.println("setDataRegistoAnuncio");
        LocalDate da = LocalDate.now();
        //Testes de sucesso
        aT.setDataRegistoAnuncio(da);
        assertEquals(da, aT.getDataRegistoAnuncio());
    }

    /**
     * Test of setDataInicioPublicitacao method, of class Anuncio.
     */
    @Test
    public void testSetDataInicioPublicitacao() {
        System.out.println("setDataInicioPublicitacao");
    }

    /**
     * Test of setDataFimPublicitacao method, of class Anuncio.
     */
    @Test
    public void testSetDataFimPublicitacao() {
        System.out.println("setDataFimPublicitacao");
        
    }

    /**
     * Test of setDataInicioCandidatura method, of class Anuncio.
     */
    @Test
    public void testSetDataInicioCandidatura() {
        System.out.println("setDataInicioCandidatura");
        
    }

    /**
     * Test of setDataFimCandidatura method, of class Anuncio.
     */
    @Test
    public void testSetDataFimCandidatura() {
        System.out.println("setDataFimCandidatura");
        
    }

    /**
     * Test of setDataInicioSeriacao method, of class Anuncio.
     */
    @Test
    public void testSetDataInicioSeriacao() {
        System.out.println("setDataInicioSeriacao");
        
    }

    /**
     * Test of setDataFimSeriacao method, of class Anuncio.
     */
    @Test
    public void testSetDataFimSeriacao() {
        System.out.println("setDataFimSeriacao");
        
    }

    /**
     * Test of setReferenciaTarefa method, of class Anuncio.
     */
    @Test
    public void testSetTarefa() {
        System.out.println("setTarefa");
        
    }

    /**
     * Test of setIdTipoRegimento method, of class Anuncio.
     */
    @Test
    public void testSetTipoRegimento() {
        System.out.println("setTipoRegimento");
        
    }

    /**
     * Test of equals method, of class Anuncio.
     */
    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        
    }
    
    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");
        // Testes de sucesso
        
        // Testes de insucesso
        
    }

    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        
    }

    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: objetos de classes diferentes");
        
    }
}
