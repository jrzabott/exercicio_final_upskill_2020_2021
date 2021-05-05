package t4j.app.model;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import t4j.app.exception.ElementoInvalidoException;

public class OrganizacaoTest {

    private Organizacao orgT, org, org2, org3;
    private Organizacao orgNull = null;
    private EnderecoPostal endereco;
    private EnderecoPostal enderecoDiferente;
    private Colaborador gestor, colab, colab2;
    private Object obj;
    private static final Logger logger = Logger.getLogger(OrganizacaoTest.class.getName());
    public static final String LINE_SEPARATOR = "**********************************************";
    public static final String METHOD_NAME_FORMAT = "%n%s%n%s%n%s";

    public OrganizacaoTest() {
        // Criados de acordo com a relação de dependências
        org = new Organizacao("nome", "123456789", "www.org.com", "221234567", "geral@org.com");
        endereco = new EnderecoPostal("Rua org", "4000-001", "Porto");
        enderecoDiferente = new EnderecoPostal("Rua Diferente", "4000-001", "Porto");
        gestor = new Colaborador("Joao", "Gestor", "911234567", "joao@org.com", "1", org.getNif());
        org.setEndereco(endereco);
        org.setGestor(gestor);
        org.addColaborador(gestor);

        colab = new Colaborador("Marta Costa", "Consultora", "912345678", "marta@org.com");
        colab2 = new Colaborador("Joao", "Gestor", "911234567", "joao@org.com");

        orgT = new Organizacao();
        org2 = new Organizacao(org);
        org3 = new Organizacao(org);
        org3.getColaboradores().add(colab);
        org3.addColaborador(colab2);

        obj = new Object();
    }

    /**
     * Test of setNome method, of class Organizacao.
     */
    @Test
    public void testSetNome() {
        //Testes de sucesso
        String nome1 = "Organização";
        orgT.setNome(nome1);
        assertEquals(nome1, orgT.getNome());
        //Testes de insucesso
//        System.out.println("setNome Vazio");
        String nome2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {
            orgT.setNome(nome2);
        });
        assertEquals("Nome de organização inválido.", exception2.getMessage());
//        System.out.println("setNome maxLength");
        String nome3 = String.format("|%60d|", 0);
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {
            orgT.setNome(nome3);
        });
        assertEquals("Nome de organização inválido.", exception3.getMessage());
    }

    /**
     * Test of setNif method, of class Organizacao.
     */
    @Test
    public void testSetNif() {
        //Testes de sucesso
        String nif1 = "123456789";
        orgT.setNif(nif1);
        assertEquals(nif1, orgT.getNif());
        //Testes de insucesso
//        System.out.println("setNif Vazio");
        String nif2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {
            orgT.setNif(nif2);
        });
        assertEquals("NIF inválido. Introduza NIF com 9 dígitos.", exception2.getMessage());
//        System.out.println("setNif DiffLength");
        String nif3 = "12345678";
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {
            orgT.setNif(nif3);
        });
        assertEquals("NIF inválido. Introduza NIF com 9 dígitos.", exception3.getMessage());
//        System.out.println("setNif Non-Digit");
        String nif4 = "12345678a";
        Throwable exception4 = assertThrows(ElementoInvalidoException.class, () -> {
            orgT.setNif(nif4);
        });
        assertEquals("NIF inválido. Introduza NIF com 9 dígitos.", exception4.getMessage());
    }

    /**
     * Test of setWebsite method, of class Organizacao.
     */
    @Test
    public void testSetWebsite() {
        //Testes de sucesso
        String website1 = "www.org.com";
        String http = "http://";
        orgT.setWebsite(website1);
        assertEquals(http += website1, orgT.getWebsite());
        //Testes de insucesso
//        System.out.println("setWebsite Vazio");
        String website2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {
            orgT.setWebsite(website2);
        });
        assertEquals("Website inválido.", exception2.getMessage());
//        System.out.println("setWebsite Inválido");
        String website3 = "www.orgcom";
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {
            orgT.setWebsite(website3);
        });
        assertEquals("Website inválido.", exception3.getMessage());
//        System.out.println("setWebsite Inválido");
        String website4 = "wwworgcom";
        Throwable exception4 = assertThrows(ElementoInvalidoException.class, () -> {
            orgT.setWebsite(website4);
        });
        assertEquals("Website inválido.", exception4.getMessage());
//        System.out.println("setWebsite Inválido");
        String website5 = "ww!.org.com";
        Throwable exception5 = assertThrows(ElementoInvalidoException.class, () -> {
            orgT.setWebsite(website5);
        });
        assertEquals("Website inválido.", exception5.getMessage());
//        System.out.println("setWebsite maxLength");
//        String website6 = String.format("|%80d|", 0);
//        Throwable exception6 = assertThrows(ElementoInvalidoException.class, () -> {orgT.setWebsite(website6);});
//        assertEquals("Website inválido.", exception6.getMessage());
    }

    /**
     * Test of setTelefone method, of class Organizacao.
     */
    @Test
    public void testSetTelefone() {
        //Testes de sucesso
        String telefone1 = "911234567";
        orgT.setTelefone(telefone1);
        assertEquals(telefone1, orgT.getTelefone());
        //Testes de insucesso
//        System.out.println("setTelefone Vazio");
        String telefone2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {
            orgT.setTelefone(telefone2);
        });
        assertEquals("Telefone de organização inválido.", exception2.getMessage());
//        System.out.println("setTelefone maxLength");
        String telefone3 = String.format("|%18d|", 0);
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {
            orgT.setTelefone(telefone3);
        });
        assertEquals("Telefone de organização inválido.", exception3.getMessage());
//        System.out.println("setTelefone com espaços");
        String telefone4 = "91 1234567";
        Throwable exception4 = assertThrows(ElementoInvalidoException.class, () -> {
            orgT.setTelefone(telefone4);
        });
        assertEquals("Telefone de organização inválido.", exception4.getMessage());
    }

    /**
     * Test of setEmail method, of class Organizacao.
     */
    @Test
    public void testSetEmail() {
        //Testes de sucesso
        String email1 = "geral@org.com";
        orgT.setEmail(email1);
        assertEquals(email1, orgT.getEmail());
        //Testes de insucesso
//        System.out.println("setTelefone Vazio");
        String email2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {
            orgT.setEmail(email2);
        });
        assertEquals("Email de organização inválido.", exception2.getMessage());
//        System.out.println("setEmail maxLength");
        String email3 = String.format("|%60d|", 0);
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {
            orgT.setEmail(email3);
        });
        assertEquals("Email de organização inválido.", exception3.getMessage());
//        System.out.println("setEmail Inválido");
        String email4 = "geralorg.com";
        Throwable exception4 = assertThrows(ElementoInvalidoException.class, () -> {
            orgT.setEmail(email4);
        });
        assertEquals("Email de organização inválido.", exception4.getMessage());
        String email5 = "geral@orgcom";
        Throwable exception5 = assertThrows(ElementoInvalidoException.class, () -> {
            orgT.setEmail(email5);
        });
        assertEquals("Email de organização inválido.", exception5.getMessage());
        String email6 = "ger al@orgcom";
        Throwable exception6 = assertThrows(ElementoInvalidoException.class, () -> {
            orgT.setEmail(email4);
        });
        assertEquals("Email de organização inválido.", exception6.getMessage());
    }

//    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        assertEquals(org, org);
        assertEquals(org.hashCode(), org.hashCode());
        assertEquals(org3, org3);
        assertEquals(org3.hashCode(), org3.hashCode());
    }

//    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");
        // Testes de sucesso
        assertEquals(org, org2);
        assertEquals(org.hashCode(), org2.hashCode());
        assertEquals(org2, org);
        assertEquals(org2.hashCode(), org.hashCode());
        // Testes de insucesso
        assertNotEquals(org, org3);
        assertNotEquals(org.hashCode(), org3.hashCode());
        assertNotEquals(org3, org);
        assertNotEquals(org3.hashCode(), org.hashCode());
    }

    @Test
    public void testEqualsTodosAsClausulas() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        logger.log(Level.WARNING, String.format(METHOD_NAME_FORMAT, LINE_SEPARATOR, methodName, LINE_SEPARATOR));

        Organizacao expResult = org;
        Organizacao result = org2;
        ArrayList<Colaborador> colabs = new ArrayList<>();
        ArrayList<Colaborador> colabs2 = new ArrayList<>();
        EnderecoPostal e1 = new EnderecoPostal("morada", "1234-567", "localidade");
        EnderecoPostal e2 = new EnderecoPostal("moradaDiferente", "1234-567", "localidade");

        colabs.add(colab);
        colabs.add(colab2);
        org.setColaboradores(colabs);
        org2.setColaboradores(colabs);

        logger.log(Level.INFO, "Colaboradores de ORG == Colaboradores de ORG2");
        logger.log(Level.INFO, String.format("%nexpResult=%s%nresult=%s", org.getColaboradores(), org2.getColaboradores()));
        logger.log(Level.INFO, "ORG == ORG2");
        logger.log(Level.INFO, String.format("%nexpResult=%s%nresult=%s", org, org2));
        assertEquals(org.getColaboradores(), org2.getColaboradores());
        boolean equals = org.equals(org2);
        assertEquals(org, org2);

        colabs2.add(colab);
        org2.setColaboradores(colabs2);
        logger.log(Level.INFO, "Colaboradores de ORG != Colaboradores de ORG2");
        logger.log(Level.INFO, String.format("%nexpResult=%s%nresult=%s", org.getColaboradores(), org2.getColaboradores()));
        logger.log(Level.INFO, "ORG != ORG2");
        logger.log(Level.INFO, String.format("%nexpResult=%s%nresult=%s", org, org2));
        assertNotEquals(org.getColaboradores(), org2.getColaboradores());
        assertNotEquals(org, org2);
        org2.setColaboradores(org.getColaboradores());

        org2.setEmail("email@email.email");
        logger.log(Level.INFO, String.format("%nexpResult=%s%nresult=%s", org, org2));
        assertNotEquals(org, org2);
        org2.setEmail(org.getEmail());

        org2.setEndereco(enderecoDiferente);
        logger.log(Level.INFO, String.format("%nexpResult=%s%nresult=%s", org, org2));
        assertNotEquals(org, org2);
        org2.setEndereco(org.getEndereco());

        org2.setGestor(colab2);
        logger.log(Level.INFO, String.format("%nexpResult=%s%nresult=%s", org, org2));
        assertNotEquals(org, org2);
        org2.setGestor(org.getGestor());

        org2.setNif("123123123");
        logger.log(Level.INFO, String.format("%nexpResult=%s%nresult=%s", org, org2));
        assertNotEquals(org, org2);
        org2.setNif(org.getNif());

        org2.setNome("123123123");
        logger.log(Level.INFO, String.format("%nexpResult=%s%nresult=%s", org, org2));
        assertNotEquals(org, org2);
        org2.setNome(org.getNome());

        org2.setTelefone("444555666");
        logger.log(Level.INFO, String.format("%nexpResult=%s%nresult=%s", org, org2));
        assertNotEquals(org, org2);
        org2.setTelefone(org.getTelefone());

        org2.setWebsite("http://outrosite.com");
        logger.log(Level.INFO, String.format("%nexpResult=%s%nresult=%s", org, org2));
        assertNotEquals(org, org2);
        org2.setWebsite(org.getWebsite());

        logger.log(Level.INFO, String.format("%nexpResult=%s%nresult=%s", org, orgNull));
        assertNotEquals(org, orgNull);

        logger.log(Level.INFO, String.format("%nexpResult=%s%nresult=%s", org, obj));
        assertNotEquals(org, obj);

    }

    @Test
    public void testToString() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        logger.log(Level.WARNING, String.format(METHOD_NAME_FORMAT, LINE_SEPARATOR, methodName, LINE_SEPARATOR));

        String expResult = "Organizacao{nome=nome, nif=123456789, website=http://www.org.com, telefone=221234567, email=geral@org.com, endereco=EnderecoPostal{id=null, morada=Rua org, codigoPostal=4000-001, localidade=Porto}, gestor=Colaborador{nome=Joao, funcao=Gestor, telefone=911234567, email=joao@org.com, nifOrganizacao=123456789, gestor=1}, listaTarefas=Registo de tarefas:, colaboradores=[Colaborador{nome=Joao, funcao=Gestor, telefone=911234567, email=joao@org.com, nifOrganizacao=123456789, gestor=1}]}";
        logger.info("org == org");
        logger.log(Level.INFO, String.format("%nexpResult=%s%nresult=%s", expResult, org.toString()));
        assertEquals(expResult, org.toString());

        logger.info("org == org3");
        logger.log(Level.INFO, String.format("%nexpResult=%s%nresult=%s", expResult, org3.toString()));
        assertNotEquals(expResult, org3.toString());

        logger.info("org == orgT");
        logger.log(Level.INFO, String.format("%nexpResult=%s%nresult=%s", expResult, orgT.toString()));
        assertNotEquals(expResult, orgT.toString());

    }

//    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        assertNotEquals(org, null);
        assertNotEquals(org3, null);
        assertNotEquals(obj, null);
    }

//    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: objetos de classes diferentes");
        assertNotEquals(org, obj);
        assertNotEquals(org.hashCode(), obj.hashCode());
        assertNotEquals(org2, obj);
        assertNotEquals(org2.hashCode(), obj.hashCode());
        assertNotEquals(org3, obj);
        assertNotEquals(org3.hashCode(), obj.hashCode());
    }
}
