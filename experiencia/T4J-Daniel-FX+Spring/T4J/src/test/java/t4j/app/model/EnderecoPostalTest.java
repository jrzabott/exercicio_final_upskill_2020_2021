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
public class EnderecoPostalTest {

    private EnderecoPostal endT, end, end2, end3;
    private Object obj;

    public EnderecoPostalTest() {
        end = new EnderecoPostal("Rua org", "4000-001", "Porto");
        end2 = new EnderecoPostal(end);
        end3 = new EnderecoPostal(1L,"Rua org2", "4000-001", "Porto");
        endT = new EnderecoPostal();
        obj = new Object();
    }

    /**
     * Test of setMorada method, of class EnderecoPostal.
     */
    @Test
    public void testSetMorada() {
        //Testes de sucesso
        String morada1 = "Morada nº1 - 3ºE";
        endT.setMorada(morada1);
        assertEquals(morada1, endT.getMorada());

        //Testes de insucesso
        String morada2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {
            endT.setMorada(morada2);
        });
        assertEquals(EnderecoPostal.ValidaEnderecoPostal.MORADA_EMPTY_EXCEPTION, exception2.getMessage());

        String morada3 = String.format("|%260d|", 0);
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {
            endT.setMorada(morada3);
        });
        assertEquals(EnderecoPostal.ValidaEnderecoPostal.MORADA_MAX_SIZE_EXCEPTION, exception3.getMessage());

        String morada4 = null;
        Throwable exception4 = assertThrows(ElementoInvalidoException.class, () -> {
            endT.setMorada(morada4);
        });
        assertEquals(EnderecoPostal.ValidaEnderecoPostal.MORADA_NULL_EXCEPTION, exception4.getMessage());

    }

    /**
     * Test of setMorada method, of class EnderecoPostal.
     */
    @Test
    public void testSetCodigoPostal() {
        //Testes de sucesso
        String codPostal1 = "4300-000";
        endT.setCodigoPostal(codPostal1);
        assertEquals(codPostal1, endT.getCodigoPostal());

        //Testes de insucesso
        String codPostal2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {
            endT.setCodigoPostal(codPostal2);
        });
        assertEquals(EnderecoPostal.ValidaEnderecoPostal.CODIGO_POSTAL_EMPTY_EXCEPTION, exception2.getMessage());

        String codPostal3 = String.format("|%9d|", 0);
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {
            endT.setCodigoPostal(codPostal3);
        });
        assertEquals(EnderecoPostal.ValidaEnderecoPostal.CODIGO_POSTAL_REGEX_EXCEPTION, exception3.getMessage());

        String codPostal4 = "0000-100";
        Throwable exception4 = assertThrows(ElementoInvalidoException.class, () -> {
            endT.setCodigoPostal(codPostal4);
        });
        assertEquals(EnderecoPostal.ValidaEnderecoPostal.CODIGO_POSTAL_REGEX_EXCEPTION, exception4.getMessage());

        String codPostal5 = null;
        Throwable exception5 = assertThrows(ElementoInvalidoException.class, () -> {
            endT.setCodigoPostal(codPostal5);
        });
        assertEquals(EnderecoPostal.ValidaEnderecoPostal.CODIGO_POSTAL_NULL_EXCEPTION, exception5.getMessage());
    }

    /**
     * Test of setLocalidade method, of class EnderecoPostal.
     */
    @Test
    public void testSetLocalidade() {
        //Testes de sucesso
        String local1 = "Águas Santas";
        endT.setLocalidade(local1);
        assertEquals(local1, endT.getLocalidade());

        //Testes de insucesso
        String local2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {endT.setLocalidade(local2);});
        assertEquals(EnderecoPostal.ValidaEnderecoPostal.LOCALIDADE_EMPTY_EXCEPTION, exception2.getMessage());

        String local3 = String.format("|%52d|", 0);
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {endT.setLocalidade(local3);});
        assertEquals(EnderecoPostal.ValidaEnderecoPostal.LOCALIDADE_MAX_SIZE_EXCEPTION, exception3.getMessage());

        String local4 = "Porto2";
        Throwable exception4 = assertThrows(ElementoInvalidoException.class, () -> {endT.setLocalidade(local4);});
        assertEquals(EnderecoPostal.ValidaEnderecoPostal.LOCALIDADE_REGEX_EXCEPTION, exception4.getMessage());

        String local5 = null;
        Throwable exception5 = assertThrows(ElementoInvalidoException.class, () -> {endT.setLocalidade(local5);});
        assertEquals(EnderecoPostal.ValidaEnderecoPostal.LOCALIDADE_NULL_EXCEPTION, exception5.getMessage());
    }

    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        assertEquals(end, end);
        assertEquals(end3, end3);
    }

    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");
        // Testes de sucesso
        assertEquals(end, end2);
        assertEquals(end2, end);
        // Testes de insucesso
        assertNotEquals(end, end3);
        assertNotEquals(end3, end);
    }

    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        assertNotEquals(end, null);
        assertNotEquals(end3, null);
        assertNotEquals(obj, null);
    }

    @Test
    public void testEqualsCoverage() {
        System.out.println("equals: testa todas as propriedades");

        end2.setCodigoPostal("1111-111");
        assertNotEquals(end, end2);
        end2.setCodigoPostal(end.getCodigoPostal());

        end2.setId(1111111L);
        assertNotEquals(end, end2);
        end2.setId(end.getId());

        end2.setLocalidade("XXX");
        assertNotEquals(end, end2);
        end2.setLocalidade(end.getLocalidade());

        end2.setMorada("YYYYYYYYYYYYYYYY");
        assertNotEquals(end, end2);
        end2.setMorada(end.getMorada());

    }

    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: objetos de classes diferentes");
        assertNotEquals(end, obj);
        assertNotEquals(end2, obj);
        assertNotEquals(end3, obj);
    }

    /**
     * Test of getId method, of class EnderecoPostal.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");

        Long expResult1 = 0L;
        Long expResult2 = 1L;
        Long expResult3 = 1000L;
        Long expResult4 = null;

        endT.setId(expResult1);
        assertEquals(expResult1, endT.getId());
        endT.setId(expResult2);
        assertEquals(expResult2, endT.getId());
        endT.setId(expResult3);
        assertEquals(expResult3, endT.getId());
        endT.setId(expResult4);
        assertEquals(expResult4, endT.getId());
    }

    /**
     * Test of getMorada method, of class EnderecoPostal.
     */
    @Test
    public void testGetMorada() {
        System.out.println("getMorada");

        String expResult1 = "Rua Nova do PORTIC, 123";
        String expResult2 = "Rua Nova do PORTIC, 1234";

        endT.setMorada(expResult1);
        assertEquals(expResult1, endT.getMorada());
        endT.setMorada(expResult2);
        assertEquals(expResult2, endT.getMorada());
    }

    /**
     * Test of getCodigoPostal method, of class EnderecoPostal.
     */
    @Test
    public void testGetCodigoPostal() {
        System.out.println("getCodigoPostal");

        String expResult1 = "1234-123";
        String expResult2 = "1234-124";

        endT.setCodigoPostal(expResult1);
        assertEquals(expResult1, endT.getCodigoPostal());
        endT.setCodigoPostal(expResult2);
        assertEquals(expResult2, endT.getCodigoPostal());
    }

    /**
     * Test of getLocalidade method, of class EnderecoPostal.
     */
    @Test
    public void testGetLocalidade() {
        System.out.println("getLocalidade");

        String expResult1 = "localidade Um";
        String expResult2 = "localidade Dois";

        endT.setLocalidade(expResult1);
        assertEquals(expResult1, endT.getLocalidade());
        endT.setLocalidade(expResult2);
        assertEquals(expResult2, endT.getLocalidade());
    }

    /**
     * Test of setId method, of class EnderecoPostal.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");

        Long id1 = 100L;
        Long id2 = null;

        endT.setId(id1);
        assertEquals(id1, endT.getId());
        endT.setId(id2);
        assertEquals(id2, endT.getId());
    }

    /**
     * Test of toString method, of class EnderecoPostal.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult1 = "EnderecoPostal{id=null, morada=Rua org, codigoPostal=4000-001, localidade=Porto}";
        String expResult2 = "EnderecoPostal{id=null, morada=Rua org, codigoPostal=4000-001, localidade=Porto}";
        String expResult3 = "EnderecoPostal{id=1, morada=Rua org2, codigoPostal=4000-001, localidade=Porto}";
        String expResultT = "EnderecoPostal{id=null, morada=null, codigoPostal=null, localidade=null}";

        assertEquals(expResult1, end.toString());
        assertEquals(expResult2, end2.toString());
        assertEquals(expResult3, end3.toString());
        assertEquals(expResultT, endT.toString());
    }

    @Test
    public void testConstrutor(){

        System.out.println("Construtor");

        EnderecoPostal end4 = new EnderecoPostal(1L,"Rua org2", "4000-001", "Porto");
        assertEquals(end4, new EnderecoPostal(1L,"Rua org2", "4000-001", "Porto"));
    }

    @Test
    public void testHashCode(){
        assertEquals(end.hashCode(), end2.hashCode());
        assertNotEquals(end.hashCode(), end3.hashCode());
        assertEquals(end.hashCode(),end.hashCode());

        EnderecoPostal end4 = new EnderecoPostal(1L,"Rua org2", "4000-001", "Porto");
        assertEquals(end4.hashCode(), new EnderecoPostal(1L,"Rua org2", "4000-001", "Porto").hashCode());
    }
}
