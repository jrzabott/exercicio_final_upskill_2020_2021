package t4j.app.model;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import t4j.app.exception.ElementoInvalidoException;

public class AreaAtividadeTest {

    private AreaAtividade atT, at, at2, at3, at4;
    private Object obj;

    public AreaAtividadeTest() {
        at = new AreaAtividade("ITTEC", "Tecnologia da Informação", "Atividades relacionadas à informações e tecnologias");
        at2 = new AreaAtividade(at);
        at3 = new AreaAtividade("ITTEC2", "Tecnologia da Informação", "Atividades relacionadas à informações e tecnologias");
        obj = new Object();
        atT = new AreaAtividade();
    }

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * Test of setCod method, of class AreaAtividade.
     */
    @Test
    public void testSetCod() {
        //Testes de sucesso
        String at1 = "AT1";
        atT.setCodigoAreaAtividade(at1);
        assertEquals(at1, atT.getCodigoAreaAtividade());
        //Testes de insucesso
//        System.out.println("setCodigo Vazio");
        String at2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {
            atT.setCodigoAreaAtividade(at2);
        });
        assertEquals("Código inválido.", exception2.getMessage());
//        System.out.println("setCodigo maxLength");
        String at3 = String.format("|%22d|", 0);
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {
            atT.setCodigoAreaAtividade(at3);
        });
        assertEquals("Código inválido.", exception3.getMessage());
//        System.out.println("setCodigo c/Carateres especiais");
        String at4 = "Codigo4$";
        Throwable exception4 = assertThrows(ElementoInvalidoException.class, () -> {
            atT.setCodigoAreaAtividade(at4);
        });
        assertEquals("Código inválido.", exception4.getMessage());
    }

    /**
     * Test of setDescBreve method, of class AreaAtividade.
     */
    @Test
    public void testSetDescBreve() {
        //Testes de sucesso
        String descBreve1 = "Descrição Breve";
        atT.setDescricaoBreve(descBreve1);
        assertEquals(descBreve1, atT.getDescricaoBreve());
        //Testes de insucesso
//        System.out.println("setDescBreve Vazia");
        String descBreve2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {
            atT.setDescricaoBreve(descBreve2);
        });
        assertEquals("Descrição breve inválida.", exception2.getMessage());
//        System.out.println("setDescBreve maxLength");
        String descBreve3 = String.format("|%260d|", 0);
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {
            atT.setDescricaoBreve(descBreve3);
        });
        assertEquals("Descrição breve inválida.", exception3.getMessage());
    }

    /**
     * Test of setDescDetalhada method, of class AreaAtividade.
     */
    @Test
    public void testSetDescDetalhada() {
        //Testes de sucesso
        String descDetalhada1 = "Descrição Detalhada";
        atT.setDescricaoDetalhada(descDetalhada1);
        assertEquals(descDetalhada1, atT.getDescricaoDetalhada());
        //Testes de insucesso
//        System.out.println("setDescDetalhada Vazia");
        String descDetalhada2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {
            atT.setDescricaoDetalhada(descDetalhada2);
        });
        assertEquals("Descrição detalhada inválida.", exception2.getMessage());
    }

    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        assertEquals(at, at);
        assertEquals(at3, at3);
    }

    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");
        // Testes de sucesso
        assertEquals(at, at2);
        assertEquals(at2, at);
        // Testes de insucesso
        assertNotEquals(at, at3);
        assertNotEquals(at3, at);
    }

    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        assertNotEquals(at, null);
        assertNotEquals(at3, null);
        assertNotEquals(obj, null);
    }

    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: objetos de classes diferentes");
        assertNotEquals(at, obj);
        assertNotEquals(at2, obj);
        assertNotEquals(at3, obj);
    }

    /**
     * Test of getCodigoAreaAtividade method, of class AreaAtividade.
     */
    @Test
    public void testGetCodigoAreaAtividade() {
        System.out.println("getCodigoAreaAtividade");

//<editor-fold defaultstate="collapsed" desc="comment">
// at = new AreaAtividade("ITTEC", "Tecnologia da Informação", "Atividades relacionadas à informações e tecnologias");
// at2 = new AreaAtividade(at);
// at3 = new AreaAtividade("ITTEC2", "Tecnologia da Informação", "Atividades relacionadas à informações e tecnologias");
// obj = new Object();
// atT = new AreaAtividade();
//</editor-fold>
        assertEquals("ITTEC", at.getCodigoAreaAtividade());
        assertEquals("ITTEC", at2.getCodigoAreaAtividade());
        assertEquals("ITTEC2", at3.getCodigoAreaAtividade());
        assertEquals(null, atT.getCodigoAreaAtividade());
    }

    /**
     * Test of getDescricaoBreve method, of class AreaAtividade.
     */
    @Test
    public void testGetDescricaoBreve() {
        System.out.println("getDescricaoBreve");

//<editor-fold defaultstate="collapsed" desc="comment">
// at = new AreaAtividade("ITTEC", "Tecnologia da Informação", "Atividades relacionadas à informações e tecnologias");
// at2 = new AreaAtividade(at);
// at3 = new AreaAtividade("ITTEC2", "Tecnologia da Informação", "Atividades relacionadas à informações e tecnologias");
// obj = new Object();
// atT = new AreaAtividade();
//</editor-fold>
        String atDescDetalhadaString = "Atividades relacionadas à informações e tecnologias";
        String atTDescDetalhadaString = null;

        assertEquals(atDescDetalhadaString, at.getDescricaoDetalhada());
        assertEquals(atDescDetalhadaString, at2.getDescricaoDetalhada());
        assertEquals(atDescDetalhadaString, at3.getDescricaoDetalhada());
        assertEquals(atTDescDetalhadaString, atT.getDescricaoDetalhada());

    }

    /**
     * Test of getDescricaoDetalhada method, of class AreaAtividade.
     */
    @Test
    public void testGetDescricaoDetalhada() {
        System.out.println("getDescricaoDetalhada");

//<editor-fold defaultstate="collapsed" desc="comment">
// at = new AreaAtividade("ITTEC", "Tecnologia da Informação", "Atividades relacionadas à informações e tecnologias");
// at2 = new AreaAtividade(at);
// at3 = new AreaAtividade("ITTEC2", "Tecnologia da Informação", "Atividades relacionadas à informações e tecnologias");
// obj = new Object();
// atT = new AreaAtividade();
//</editor-fold>
        String atDescBreveString = "Tecnologia da Informação";
        String atTDescBreveString = null;

        assertEquals(atDescBreveString, at.getDescricaoBreve());
        assertEquals(atDescBreveString, at2.getDescricaoBreve());
        assertEquals(atDescBreveString, at3.getDescricaoBreve());
        assertEquals(null, atT.getDescricaoBreve());
    }

    /**
     * Test of setCodigoAreaAtividade method, of class AreaAtividade.
     */
    @Test
    public void testSetCodigoAreaAtividade() {
        /**
         * Codigo de Atividade não pode ser null Codigo de Atividade não pode conter caracteres
         * especiais Codigo nao pode ser vazio Codigo nao pode exceder 20 Caracteres
         */

        System.out.println("setCodigoAreaAtividade");

        String nullString = null;
        String specialCharsString = "#$&/%/&&";
        String emptyString = "        ";
        String greaterThan20String = "123456789012345678901";
        String validString = "abcd";

        AreaAtividade instance = new AreaAtividade();
        assertThrows(ElementoInvalidoException.class, () -> instance.setCodigoAreaAtividade(nullString));
        assertThrows(ElementoInvalidoException.class, () -> instance.setCodigoAreaAtividade(specialCharsString));
        assertThrows(ElementoInvalidoException.class, () -> instance.setCodigoAreaAtividade(emptyString));
        assertThrows(ElementoInvalidoException.class, () -> instance.setCodigoAreaAtividade(greaterThan20String));

        instance.setCodigoAreaAtividade(validString);
        assertEquals(validString, instance.getCodigoAreaAtividade());
    }

    /**
     * Test of setDescricaoBreve method, of class AreaAtividade.
     */
    @Test
    public void testSetDescricaoBreve() {
        System.out.println("setDescricaoBreve");

//<editor-fold defaultstate="collapsed" desc="comment">
//      Descricao detalhada não pode:
//          Conter null
//          Ser vazia
//          Ser maior que: 20 caracteres
//</editor-fold>
        String nullString = null;
        String emptyString = "        ";
        String greaterThan20String = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011";

        AreaAtividade instance = new AreaAtividade();

        assertThrows(ElementoInvalidoException.class, () -> instance.setDescricaoBreve(nullString));
        assertThrows(ElementoInvalidoException.class, () -> instance.setDescricaoBreve(emptyString));
        assertThrows(ElementoInvalidoException.class, () -> instance.setDescricaoBreve(greaterThan20String));

        String validString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011";
        instance.setDescricaoBreve(validString);
        assertEquals(validString, instance.getDescricaoBreve());

    }

    /**
     * Test of setDescricaoDetalhada method, of class AreaAtividade.
     */
    @Test
    public void testSetDescricaoDetalhada() {
        System.out.println("setDescricaoDetalhada");

//<editor-fold defaultstate="collapsed" desc="comment">
//      Descricao detalhada não pode:
//          Conter null
//          Ser vazia
//          Ser maior que: 1024 caracteres
//</editor-fold>
        String nullString = null;
        String emptyString = "        ";
        String greaterThan1024String = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011";

        AreaAtividade instance = new AreaAtividade();

        assertThrows(ElementoInvalidoException.class, () -> instance.setDescricaoDetalhada(nullString));
        assertThrows(ElementoInvalidoException.class, () -> instance.setDescricaoDetalhada(emptyString));
        assertThrows(ElementoInvalidoException.class, () -> instance.setDescricaoDetalhada(greaterThan1024String));

        String validString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789011";
        instance.setDescricaoDetalhada(validString);
        assertEquals(validString, instance.getDescricaoDetalhada());

    }

    /**
     * Test of toString method, of class AreaAtividade.
     */
    @Test
    public void testToString() {
        System.out.println("toString");

        String atToString = "AreaAtividade{codigoAreaAtividade=ITTEC, descricaoBreve=Tecnologia da Informação, descricaoDetalhada=Atividades relacionadas à informações e tecnologias}";
        String at3ToString = "AreaAtividade{codigoAreaAtividade=ITTEC2, descricaoBreve=Tecnologia da Informação, descricaoDetalhada=Atividades relacionadas à informações e tecnologias}";
        String atTToString = "AreaAtividade{codigoAreaAtividade=null, descricaoBreve=null, descricaoDetalhada=null}";

        assertEquals(atToString, at.toString());
        assertEquals(atToString, at2.toString());
        assertEquals(at3ToString, at3.toString());
        assertEquals(atTToString, atT.toString());

    }

    /**
     * Test of equals method, of class AreaAtividade.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");

        // Equals Reflexivo
        assertEquals(at, at);
        assertEquals(at2, at2);
        assertEquals(at3, at3);
        assertEquals(atT, atT);

        // Equals Simétrico
        assertEquals(at, at2);
        assertEquals(at2, at);
        assertNotEquals(at, at3);
        assertNotEquals(at3, at);

        //Equals null
        assertNotEquals(at, null);
        assertNotEquals(at2, null);
        assertNotEquals(at3, null);
        assertNotEquals(atT, null);

        // Equals to another Class
        assertNotEquals(at, obj);
        assertNotEquals(at2, obj);
        assertNotEquals(at3, obj);
        assertNotEquals(atT, obj);
        
        //Equals Coverage
        at2.setCodigoAreaAtividade("COD100");
        assertNotEquals(at, at2);
        at2.setCodigoAreaAtividade(at.getCodigoAreaAtividade());
        
        at2.setDescricaoBreve("Descricao100");
        assertNotEquals(at, at2);
        at2.setDescricaoBreve(at.getDescricaoBreve());
        
        at2.setDescricaoDetalhada("DescricaoDetalhada100");
        assertNotEquals(at, at2);
        at2.setDescricaoDetalhada(at.getDescricaoDetalhada());

    }

    /**
     * Test of hashCode method, of class AreaAtividade.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");

        int atHashCode = -757766494;
        int at2HashCode = -757766494;
        int at3HashCode = -1387888474;
        int atTHashCode = 2505377;

        System.out.println(at.hashCode());
        System.out.println(at2.hashCode());
        System.out.println(at3.hashCode());
        System.out.println(atT.hashCode());

        assertEquals(atHashCode, at.hashCode());
        assertEquals(at2HashCode, at2.hashCode());
        assertEquals(at3HashCode, at3.hashCode());
        assertEquals(atTHashCode, atT.hashCode());
    }

}
