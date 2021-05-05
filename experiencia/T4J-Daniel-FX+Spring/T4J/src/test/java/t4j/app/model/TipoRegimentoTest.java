package t4j.app.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import t4j.app.exception.ElementoInvalidoException;

public class TipoRegimentoTest {
    
    private TipoRegimento trT, tr, tr2, tr3, tr4;
    private Object obj;
    
    public TipoRegimentoTest() {
        obj = new Object();
        tr = new TipoRegimento(1L, "TRA", "Seriação manual obrigatória");
        tr2 = new TipoRegimento(tr);
        tr3 = new TipoRegimento("TRB", "Seriação manual obrigatória");
        trT = new TipoRegimento();
    }

    /**
     * Test of setDesignacao method, of class TipoRegimento.
     */
    @Test
    public void testSetDesignacao() {
        System.out.println("setDesignacao");
        //Testes de sucesso
        String tr1 = "TRC";
        trT.setDesignacao(tr1);
        assertEquals(tr1, trT.getDesignacao());
        //Testes de insucesso
        String tr2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {trT.setDesignacao(tr2);});
        assertEquals("Designação inválida.", exception2.getMessage());
//        System.out.println("setCodigo maxLength");
        String tr3 = String.format("|%61d|", 0);
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {trT.setDesignacao(tr3);});
        assertEquals("Designação inválida.", exception3.getMessage());
//        System.out.println("setCodigo c/Carateres especiais");
        String tr4 = "Codigo4$";
        Throwable exception4 = assertThrows(ElementoInvalidoException.class, () -> {trT.setDesignacao(tr4);});
        assertEquals("Designação inválida.", exception4.getMessage());
    }

    /**
     * Test of setDescricaoRegras method, of class TipoRegimento.
     */
    @Test
    public void testSetDescricaoRegras() {
        System.out.println("setDescricaoRegras");
        //Testes de sucesso
        String descRegras1 = "Descrição Regras";
        trT.setDescricaoRegras(descRegras1);
        assertEquals(descRegras1, trT.getDescricaoRegras());
        //Testes de insucesso
//        System.out.println("getDescricaoRegras Vazia");
        String descRegras2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {trT.setDescricaoRegras(descRegras2);});
        assertEquals("Descrição de regras inválida.", exception2.getMessage());
    }

    /**
     * Test of equals method, of class TipoRegimento.
     */
    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        assertEquals(tr, tr);
        assertEquals(tr.hashCode(), tr.hashCode());
        assertEquals(tr3.hashCode(), tr3.hashCode());
    }
    
    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");
        // Testes de sucesso
        assertEquals(tr, tr2);
        assertEquals(tr.hashCode(), tr2.hashCode());
        assertEquals(tr2.hashCode(), tr.hashCode());
        // Testes de insucesso
        assertNotEquals(tr.hashCode(), tr3.hashCode());
        assertNotEquals(tr3.hashCode(), tr.hashCode());
    }

    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        assertNotEquals(tr, null);
        assertNotEquals(tr3, null);
        assertNotEquals(obj, null);
    }

    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: objetos de classes diferentes");
        assertNotEquals(tr, obj);
        assertNotEquals(tr.hashCode(), obj.hashCode());
        assertNotEquals(tr2, obj);
        assertNotEquals(tr2.hashCode(), obj.hashCode());
        assertNotEquals(tr3.hashCode(), obj.hashCode());
    }
    
    @Test
    public void testEqualsCoverage() {
        System.out.println("equals: testa todas as propriedades");

        tr2.setId(1111111L);
        assertNotEquals(tr, tr2);
        tr2.setId(tr.getId());

        tr2.setDesignacao("Designacao");
        assertNotEquals(tr, tr2);
        tr2.setDesignacao(tr.getDesignacao());

        tr2.setDescricaoRegras("DescricaoRegras");
        assertNotEquals(tr, tr2);
        tr2.setDescricaoRegras(tr.getDescricaoRegras());
    }
}
