package t4j.app.model;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import t4j.app.exception.ElementoInvalidoException;

public class AnuncioTest {

    private Anuncio aT, a, a2, a3;
    private LocalDate dip, dfp, dic, dfc, dis, dfs;
    private Object obj;
    
    public AnuncioTest() {
        dip = LocalDate.of(2021, 02, 19);
        dfp = LocalDate.of(2021, 03, 19);
        dic = LocalDate.of(2021, 02, 19);
        dfc = LocalDate.of(2021, 03, 10);
        dis = LocalDate.of(2021, 03, 11);
        dfs = LocalDate.of(2021, 03, 19);
        a = new Anuncio("Tarefa1", dip, dfp, dic, dfc, dis, dfs, 1L);
        a2 = new Anuncio(a);
        a3 = new Anuncio("Tarefa2", dip, dfp, dic, dfc, dis, dfs, 2L);
        aT = new Anuncio();
        obj = new Object();
    }
    
    /**
     * Test of getReferencia method, of class Anuncio.
     */
    @Test
    public void testGetReferencia() {
        System.out.println("getReferencia");
        assertEquals("Tarefa1", a.getReferencia());
    }

    /**
     * Test of getDataRegistoAnuncio method, of class Anuncio.
     */
//    @Test
    public void testGetDataRegistoAnuncio() {
        System.out.println("getReferencia");
        assertEquals("Tarefa1", a.getReferencia());
    }

    /**
     * Test of getDataInicioPublicitacao method, of class Anuncio.
     */
    @Test
    public void testGetDataInicioPublicitacao() {
        System.out.println("getDataInicioPublicitacao");
        assertEquals(dip.toString(), a.getDataInicioPublicitacao().toString());
    }

    /**
     * Test of getDataFimPublicitacao method, of class Anuncio.
     */
    @Test
    public void testGetDataFimPublicitacao() {
        System.out.println("getDataFimPublicitacao");
        assertEquals(dfp.toString(), a.getDataFimPublicitacao().toString());
    }

    /**
     * Test of getDataInicioCandidatura method, of class Anuncio.
     */
    @Test
    public void testGetDataInicioCandidatura() {
        System.out.println("getDataInicioCandidatura");
        assertEquals(dic.toString(), a.getDataInicioCandidatura().toString());
    }

    /**
     * Test of getDataFimCandidatura method, of class Anuncio.
     */
    @Test
    public void testGetDataFimCandidatura() {
        System.out.println("getDataFimCandidatura");
        assertEquals(dfc.toString(), a.getDataFimCandidatura().toString());
    }

    /**
     * Test of getDataInicioSeriacao method, of class Anuncio.
     */
    @Test
    public void testGetDataInicioSeriacao() {
        System.out.println("getDataInicioSeriacao");
        assertEquals(dis.toString(), a.getDataInicioSeriacao().toString());
    }

    /**
     * Test of getDataFimSeriacao method, of class Anuncio.
     */
    @Test
    public void testGetDataFimSeriacao() {
        System.out.println("getDataFimSeriacao");
        assertEquals(dfs.toString(), a.getDataFimSeriacao().toString());
    }

    /**
     * Test of getIdTipoRegimento method, of class Anuncio.
     */
    @Test
    public void testGetIdTipoRegimento() {
        System.out.println("getIdTipoRegimento");
        assertEquals(1, a.getIdTipoRegimento());
    }

    /**
     * Test of setIdTipoRegimento method, of class Anuncio.
     */
    @Test
    public void testSetIdTipoRegimento() {
        System.out.println("setIdTipoRegimento");
        Long id = 10L;
        a.setIdTipoRegimento(id);
        assertEquals(id, a.getIdTipoRegimento());
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
        //Testes de sucesso
        System.out.println("setDataInicioPublicitacao");
        LocalDate data = LocalDate.of(2021, 02, 18);
        a.setDataInicioPublicitacao(data);
        assertEquals(data, a.getDataInicioPublicitacao());
        
        
    }

    /**
     * Test of setDataFimPublicitacao method, of class Anuncio.
     */
    @Test
    public void testSetDataFimPublicitacao() {
        System.out.println("setDataFimPublicitacao");
        LocalDate data = LocalDate.of(2021, 02, 20);
        a.setDataFimPublicitacao(data);
        assertEquals(data, a.getDataFimPublicitacao());
        
        
    }

    /**
     * Test of setDataInicioCandidatura method, of class Anuncio.
     */
    @Test
    public void testSetDataInicioCandidatura() {
        System.out.println("setDataInicioCandidatura");
        LocalDate data = LocalDate.of(2021, 02, 20);
        a.setDataInicioCandidatura(data);
        assertEquals(data, a.getDataInicioCandidatura());
        
    }

    /**
     * Test of setDataFimCandidatura method, of class Anuncio.
     */
    @Test
    public void testSetDataFimCandidatura() {
        System.out.println("setDataFimCandidatura");
        LocalDate data = LocalDate.of(2021, 03, 11);
        a.setDataFimCandidatura(data);
        assertEquals(data, a.getDataFimCandidatura());
        
    }

    /**
     * Test of setDataInicioSeriacao method, of class Anuncio.
     */
    @Test
    public void testSetDataInicioSeriacao() {
        System.out.println("setDataInicioSeriacao");
        LocalDate data = LocalDate.of(2021, 03, 12);
        a.setDataInicioSeriacao(data);
        assertEquals(data, a.getDataInicioSeriacao());
        
    }

    /**
     * Test of setDataFimSeriacao method, of class Anuncio.
     */
    @Test
    public void testSetDataFimSeriacao() {
        System.out.println("setDataFimSeriacao");
        LocalDate data = LocalDate.of(2021, 03, 20);
        a.setDataFimSeriacao(data);
        assertEquals(data, a.getDataFimSeriacao());
        
    }

    /**
     * Test of equals method, of class Anuncio.
     */
    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        assertEquals(a, a);
        assertEquals(a.hashCode(), a.hashCode());
        assertEquals(a3, a3);
        assertEquals(a3.hashCode(), a3.hashCode());
        
    }
    
    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");
        // Testes de sucesso
        assertEquals(a, a2);
        assertEquals(a.hashCode(), a2.hashCode());
        assertEquals(a2, a);
        assertEquals(a2.hashCode(), a.hashCode());
        // Testes de insucesso
        assertNotEquals(a, a3);
        assertNotEquals(a.hashCode(), a3.hashCode());
        assertNotEquals(a3, a);
        assertNotEquals(a3.hashCode(), a.hashCode());
    }

    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        assertNotEquals(a, null);
        assertNotEquals(a2, null);
        assertNotEquals(a3, null);
        assertNotEquals(obj, null);
        
    }

    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: objetos de classes diferentes");
        assertNotEquals(a, obj);
        assertNotEquals(a.hashCode(), obj.hashCode());
        assertNotEquals(a2, obj);
        assertNotEquals(a2.hashCode(), obj.hashCode());
        assertNotEquals(a3, obj);
        assertNotEquals(a3.hashCode(), obj.hashCode());
        
    }

    @Test
    public void testEqualsCoverage() {
        System.out.println("equals: testa todas as propriedades");

        a2.setReferencia("T003");
        assertNotEquals(a, a2);
        a2.setReferencia(a.getReferencia());

        a2.setDataRegistoAnuncio(LocalDate.MIN);
        assertNotEquals(a, a2);
        a2.setDataRegistoAnuncio(a.getDataRegistoAnuncio());
        
        a2.setDataInicioPublicitacao(LocalDate.MIN);
        assertNotEquals(a, a2);
        a2.setDataInicioPublicitacao(a.getDataInicioPublicitacao());
        
        a2.setDataFimPublicitacao(LocalDate.MIN);
        assertNotEquals(a, a2);
        a2.setDataFimPublicitacao(a.getDataFimPublicitacao());
        
        a2.setDataInicioCandidatura(LocalDate.MIN);
        assertNotEquals(a, a2);
        a2.setDataInicioCandidatura(a.getDataInicioCandidatura());
        
        a2.setDataFimCandidatura(LocalDate.MIN);
        assertNotEquals(a, a2);
        a2.setDataFimCandidatura(a.getDataFimCandidatura());
        
        a2.setDataInicioSeriacao(LocalDate.MIN);
        assertNotEquals(a, a2);
        a2.setDataInicioSeriacao(a.getDataInicioSeriacao());
        
        a2.setDataFimSeriacao(LocalDate.MIN);
        assertNotEquals(a, a2);
        a2.setDataFimSeriacao(a.getDataFimSeriacao());

        a2.setIdTipoRegimento(10L);
        assertNotEquals(a, a2);
        a2.setIdTipoRegimento(a.getIdTipoRegimento());
    }

    /**
     * Test of toString method, of class Anuncio.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        LocalDate data = LocalDate.now();
        String dataRegisto = data.toString();
        
        String ts1 = "Anuncio{referencia=Tarefa1, dataRegistoAnuncio="+dataRegisto+", dataInicioPublicitacao=2021-02-19, dataFimPublicitacao=2021-03-19, dataInicioCandidatura=2021-02-19, dataFimCandidatura=2021-03-10, dataInicioSeriacao=2021-03-11, dataFimSeriacao=2021-03-19, idTipoRegimento=1}";
        assertEquals(ts1, a.toString());
        
        aT = new Anuncio();
        String ts2 = "Anuncio{referencia=null, dataRegistoAnuncio=null, dataInicioPublicitacao=null, dataFimPublicitacao=null, dataInicioCandidatura=null, dataFimCandidatura=null, dataInicioSeriacao=null, dataFimSeriacao=null, idTipoRegimento=null}";
        assertEquals(ts2, aT.toString());
        
    }

}
