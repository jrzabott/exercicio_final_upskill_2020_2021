/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import t4j.app.exception.ElementoInvalidoException;

/**
 *
 * @author Upskill
 */
public class ColaboradorTest {

    private Colaborador colabT, colab, colab2, colab3;
    private Object obj;

    public ColaboradorTest() {

        colab = new Colaborador("Joao", "Gestor", "911234567",
                "joao@org.com", "1", "000000001");
        colab2 = new Colaborador(colab);
        colab3 = new Colaborador("Joana", "Gestora", "911234568",
                "joana@org.com", "1", "000000001");
        obj = new Object();
        colabT = new Colaborador();
    }

    /**
     * Test of setNome method, of class Colaborador.
     */
    @Test
    public void testSetNome() {
        //Testes de sucesso
        String nome1 = "João Martins";
        colabT.setNome(nome1);
        assertEquals(nome1, colabT.getNome());

        //Testes de insucesso
        String nome2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {
            colabT.setNome(nome2);
        });
        assertEquals("Nome do colaborador deve ser diferente de vazio.", exception2.getMessage());

        String nome3 = String.format("|%52d|", 0);
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {
            colabT.setNome(nome3);
        });
        assertEquals("Nome do colaborador não pode ultrapassar 50 caracteres.", exception3.getMessage());

        String nome4 = "João$";
        Throwable exception4 = assertThrows(ElementoInvalidoException.class, () -> {
            colabT.setNome(nome4);
        });
        assertEquals("Nome não pode conter caracteres especiais. (Acentos são suportados)", exception4.getMessage());
    }

    /**
     * Test of setFuncao method, of class Colaborador.
     */
    @Test
    public void testSetFuncao() {
        //Testes de sucesso
        String funcao1 = "Gestor";
        colabT.setFuncao(funcao1);
        assertEquals(funcao1, colabT.getFuncao());

        //Testes de insucesso
        String funcao2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {
            colabT.setFuncao(funcao2);
        });
        assertEquals("Função do colaborador deve ser diferente de vazio.", exception2.getMessage());

        String funcao3 = String.format("|%52d|", 0);
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {
            colabT.setFuncao(funcao3);
        });
        assertEquals("Função do colaborador não pode ultrapassar 50 caracteres.", exception3.getMessage());

        String funcao4 = null;
        Throwable exception4 = assertThrows(ElementoInvalidoException.class, () -> {
            colabT.setFuncao(funcao4);
        });
        assertEquals("Função do colaborador não pode ser null.", exception4.getMessage());
    }

    /**
     * Test of setTelefone method, of class Colaborador.
     */
    @Test
    public void testSetTelefone() {
        System.out.println("setTelefone Vazio");

        String telefoneValido0 = "999999999";
        String telefoneValido1 = "911911911";
        String telefoneInvalidoVazio = "";
        String telefoneInvalidoNull = null;
        String telefoneInvalidoSpecialChars = "/&%$/%&$/9";
        String telefoneInvalidoManyChars = "99999999999999999999999999999999999";
        String telefoneInvalidoFewChars = "999";

        colab.setTelefone(telefoneValido0);
        assertEquals(telefoneValido0, colab.getTelefone());
        colab.setTelefone(telefoneValido1);
        assertEquals(telefoneValido1, colab.getTelefone());

        assertThrows(ElementoInvalidoException.class, () -> colab.setTelefone(telefoneInvalidoNull));
        assertThrows(ElementoInvalidoException.class, () -> colab.setTelefone(telefoneInvalidoVazio));
        assertThrows(ElementoInvalidoException.class, () -> colab.setTelefone(telefoneInvalidoSpecialChars));
        assertThrows(ElementoInvalidoException.class, () -> colab.setTelefone(telefoneInvalidoManyChars));
        assertThrows(ElementoInvalidoException.class, () -> colab.setTelefone(telefoneInvalidoFewChars));

    }

    /**
     * Test of setEmail method, of class Colaborador.
     */
    @Test
    public void testSetEmail() {
        //Testes de sucesso
        String email1 = "joao@org.com";
        String expResultMensagemErro = "Email do colaborador deve ser um email válido.";

        colabT.setEmail(email1);
        assertEquals(email1, colabT.getEmail());
        //Testes de insucesso
//        System.out.println("setEmail Vazio");
        String email2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {
            colabT.setEmail(email2);
        });
        assertEquals(expResultMensagemErro, exception2.getMessage());
////        System.out.println("setEmail maxLength");
//        String email3 = String.format("|%50d|", 0);
//        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {colabT.setEmail(email3);});
//        assertEquals("Email de colaborador inválido.", exception3.getMessage());
//        System.out.println("setEmail Carateres Inválidos");
//        String email4 = "joao!@org.com";
//        Throwable exception4 = assertThrows(ElementoInvalidoException.class, () -> {colabT.setEmail(email4);});
//        assertEquals("Email de colaborador inválido.", exception4.getMessage());
//        System.out.println("setEmail Inválidos");
        String email5 = "joaoorg.com";
        Throwable exception5 = assertThrows(ElementoInvalidoException.class, () -> {
            colabT.setEmail(email5);
        });
        assertEquals(expResultMensagemErro, exception5.getMessage());
//        System.out.println("setEmail Inválidos");
        String email6 = "joao@orgcom";
        Throwable exception6 = assertThrows(ElementoInvalidoException.class, () -> {
            colabT.setEmail(email6);
        });
        assertEquals(expResultMensagemErro, exception6.getMessage());
//        System.out.println("setEmail Inválidos");
        String email7 = "jo ao@org.com";
        Throwable exception7 = assertThrows(ElementoInvalidoException.class, () -> {
            colabT.setEmail(email7);
        });
        assertEquals(expResultMensagemErro, exception7.getMessage());

        String email8 = null;
        String expResultMsgErr8 = "Email do colaborador não pode ser null.";
        Throwable exception8 = assertThrows(ElementoInvalidoException.class, () -> {
            colabT.setEmail(email8);
        });
        assertEquals(expResultMsgErr8, exception8.getMessage());

        String sample512String = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890AAabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890AAabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890AAabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890AAabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890AAabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890AAabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890AAabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890AA";
        StringBuilder email9 = new StringBuilder();
        email9.append(sample512String);
        email9.append("@org.com");
        String expResultMsgErr9 = "Email do colaborador não pode ultrapassar 254 caracteres.";
        Throwable exception9 = assertThrows(ElementoInvalidoException.class, () -> {
            colabT.setEmail(email9.toString());
        });
        assertEquals(expResultMsgErr9, exception9.getMessage());
    }

    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        assertEquals(colab, colab);
        assertEquals(colab3, colab3);
    }

    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");
        // Testes de sucesso
        assertEquals(colab, colab2);
        assertEquals(colab2, colab);
        // Testes de insucesso
        assertNotEquals(colab, colab3);
        assertNotEquals(colab3, colab);
    }

    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        assertNotEquals(colab, null);
        assertNotEquals(colab3, null);
        assertNotEquals(obj, null);
    }

    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: objetos de classes diferentes");
        assertNotEquals(colab, obj);
        assertNotEquals(colab2, obj);
        assertNotEquals(colab3, obj);
    }

    /**
     * Test of getGestor method, of class Colaborador.
     */
    @Test
    public void testGetGestor() {
        System.out.println("getGestor");

        String expResultColab = "1";
        String expResultColab3 = "0";
        colab3.setGestor("0");

        assertEquals(expResultColab, colab.getGestor());
        assertEquals(expResultColab, colab2.getGestor());
        assertEquals(expResultColab3, colab3.getGestor());
        assertEquals(null, colabT.getGestor());
    }

    /**
     * Test of getNifOrganizacao method, of class Colaborador.
     */
    @Test
    public void testGetNifOrganizacao() {
        System.out.println("getNifOrganizacao");
        String expResult = "000000001";

        assertEquals(expResult, colab.getNifOrganizacao());
        assertEquals(expResult, colab2.getNifOrganizacao());
        assertEquals(expResult, colab3.getNifOrganizacao());
        assertEquals(null, colabT.getNifOrganizacao());

    }

    /**
     * Test of getNome method, of class Colaborador.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");

        String nomeValido0 = "João Silva";
        String nomeValido1 = "João Silva Silva";
        String nomeInvalidoVazio = "";
        String nomeInvalidoNull = null;
        String nomeInvalidoMaxChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        colab.setNome(nomeValido0);
        assertEquals(nomeValido0, colab.getNome());
        colab.setNome(nomeValido1);
        assertEquals(nomeValido1, colab.getNome());

        assertThrows(ElementoInvalidoException.class, () -> colab.setNome(nomeInvalidoNull));
        assertThrows(ElementoInvalidoException.class, () -> colab.setNome(nomeInvalidoVazio));
        assertThrows(ElementoInvalidoException.class, () -> colab.setNome(nomeInvalidoMaxChars));
    }

    /**
     * Test of getFuncao method, of class Colaborador.
     */
    @Test
    public void testGetFuncao() {
        System.out.println("getFuncao");

        String expResultColab = "Gestor";
        String expResultColab3 = "Gestora";

        assertEquals(expResultColab, colab.getFuncao());
        assertEquals(expResultColab, colab2.getFuncao());
        assertEquals(expResultColab3, colab3.getFuncao());
        assertEquals(null, colabT.getFuncao());
    }

    /**
     * Test of getTelefone method, of class Colaborador.
     */
    @Test
    public void testGetTelefone() {
        System.out.println("getTelefone");

        String expResultColab = "911234567";
        String expResultColab3 = "911234568";

        assertEquals(expResultColab, colab.getTelefone());
        assertEquals(expResultColab, colab2.getTelefone());
        assertEquals(expResultColab3, colab3.getTelefone());
        assertEquals(null, colabT.getTelefone());
    }

    /**
     * Test of getEmail method, of class Colaborador.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");

        String expResultColab = "joao@org.com";
        String expResultColab3 = "joana@org.com";

        assertEquals(expResultColab, colab.getEmail());
        assertEquals(expResultColab, colab2.getEmail());
        assertEquals(expResultColab3, colab3.getEmail());
        assertEquals(null, colabT.getEmail());

    }

    /**
     * Test of setGestor method, of class Colaborador.
     */
    @Test
    public void testSetGestor() {
        System.out.println("setGestor");

        String gestorValido0 = "0";
        String gestorValido1 = "1";
        String gestorInvalido2 = "2";
        String gestorInvalidoVazio = "";
        String gestorInvalidoNull = null;
        String gestorInvalidLength = "0000000000000000000";

        colab.setGestor(gestorValido0);
        assertEquals(gestorValido0, colab.getGestor());
        colab.setGestor(gestorValido1);
        assertEquals(gestorValido1, colab.getGestor());

        assertThrows(ElementoInvalidoException.class, () -> colab.setGestor(gestorInvalido2));
        assertThrows(ElementoInvalidoException.class, () -> colab.setGestor(gestorInvalidoNull));
        assertThrows(ElementoInvalidoException.class, () -> colab.setGestor(gestorInvalidoVazio));
        assertThrows(ElementoInvalidoException.class, () -> colab.setGestor(gestorInvalidLength));

    }

    /**
     * Test of setNifOrganizacao method, of class Colaborador.
     */
    @Test
    public void testSetNifOrganizacao() {
        System.out.println("setNifOrganizacao");

        String nifValido = "222222222";
        String niInvalidoRegex = "222AAAA22";
        String nifInvalidoVazio = "";
        String nifInvalidoNull = null;
        String nifInvalidoMaior = "12345678901234567890";
        String nifInvalidoMenor = "12";

        colab.setNifOrganizacao(nifValido);
        assertEquals(nifValido, colab.getNifOrganizacao());

        assertThrows(ElementoInvalidoException.class, () -> colab.setNifOrganizacao(nifInvalidoMaior));
        assertThrows(ElementoInvalidoException.class, () -> colab.setNifOrganizacao(nifInvalidoMenor));
        assertThrows(ElementoInvalidoException.class, () -> colab.setNifOrganizacao(nifInvalidoNull));
        assertThrows(ElementoInvalidoException.class, () -> colab.setNifOrganizacao(nifInvalidoVazio));
        assertThrows(ElementoInvalidoException.class, () -> colab.setNifOrganizacao(niInvalidoRegex));

    }

    /**
     * Test of toString method, of class Colaborador.
     */
    @Test
    public void testToString() {
        System.out.println("toString");

        String expResultColab = "Colaborador{nome=Joao, funcao=Gestor, telefone=911234567, email=joao@org.com, nifOrganizacao=000000001, gestor=1}";
        String expResultColab2 = expResultColab;
        String expResultColab3 = "Colaborador{nome=Joana, funcao=Gestora, telefone=911234568, email=joana@org.com, nifOrganizacao=000000001, gestor=1}";
        String expResultColabT = "Colaborador{nome=null, funcao=null, telefone=null, email=null, nifOrganizacao=null, gestor=null}";

        assertEquals(expResultColab, colab.toString());
        assertEquals(expResultColab2, colab2.toString());
        assertEquals(expResultColab3, colab3.toString());
        assertEquals(expResultColabT, colabT.toString());

    }

    /**
     * Test of hashCode method, of class Colaborador.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");

        int expResultColab = 1236500376;
        int expResultColab2 = 1236500376;
        int expResultColab3 = -1276782902;
        int expResultColabT = -892755365;

        assertEquals(expResultColab, colab.hashCode());
        assertEquals(expResultColab2, colab2.hashCode());
        assertEquals(expResultColab3, colab3.hashCode());
        assertEquals(expResultColabT, colabT.hashCode());

    }

    /**
     * Test of equals method, of class Colaborador.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");

        assertEquals(colab, colab);
        assertEquals(colab2, colab2);
        assertEquals(colab3, colab3);
        assertEquals(colabT, colabT);

        assertEquals(colab, colab2);
        assertEquals(colab2, colab);
        assertNotEquals(colab, colab3);
        assertNotEquals(colab3, colab);
        assertNotEquals(colab2, colab3);
        assertNotEquals(colab3, colab2);

        assertNotEquals(colab, null);
        assertNotEquals(colab2, null);
        assertNotEquals(colab3, null);
        assertNotEquals(colabT, null);

        assertNotEquals(obj, colab);
        assertNotEquals(obj, colab2);
        assertNotEquals(obj, colab3);
        assertNotEquals(obj, colabT);

        colab2.setEmail("outro@email.com");
        assertNotEquals(colab, colab2);
        colab2.setEmail(colab.getEmail());

        colab2.setFuncao("Outra Função");
        assertNotEquals(colab, colab2);
        colab2.setFuncao(colab.getFuncao());

        colab2.setGestor("0");
        assertNotEquals(colab, colab2);
        colab2.setGestor(colab.getGestor());

        colab2.setNifOrganizacao("000000003");
        assertNotEquals(colab, colab2);
        colab2.setNifOrganizacao(colab.getNifOrganizacao());

        colab2.setNome("Mario");
        assertNotEquals(colab, colab2);
        colab2.setNome(colab.getNome());

        colab2.setTelefone("123456789");
        assertNotEquals(colab, colab2);
        colab2.setTelefone(colab.getTelefone());

    }

}
