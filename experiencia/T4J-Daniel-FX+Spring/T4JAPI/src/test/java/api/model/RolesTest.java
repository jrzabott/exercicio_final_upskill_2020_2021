package api.model;

import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RolesTest {
    
    private Roles rc, rv, rcop;
    private Object obj;
    
    public RolesTest() {
        rc = new Roles(1L, "descricao");
        rv = new Roles();
        rcop = new Roles(rc);
        obj = new Object();
    }

    /**
     * Test of getId method, of class Roles.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Long expResult = 1L;
        assertEquals(expResult, rc.getId());
    }

    /**
     * Test of getDescricao method, of class Roles.
     */
    @Test
    public void testGetDescricao() {
        System.out.println("getDescricao");
        String expResult = "descricao";
        assertEquals(expResult, rc.getDescricao());
    }
    
    /**
     * Test of getUsers method, of class Roles.
     */
    @Test
    public void testGetUsers() {
        System.out.println("getUsers");
        Set<Users> expResult = new HashSet<>();
        assertEquals(expResult, rc.getUsers());
    }

    /**
     * Test of setId method, of class Roles.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 1L;
        rv.setId(id);
        assertEquals(id, rv.getId());
    }

    /**
     * Test of setDescricao method, of class Roles.
     */
    @Test
    public void testSetDescricao() {
        System.out.println("setDescricao");
        String descricao = "descricao";
        rv.setDescricao(descricao);
        assertEquals(descricao, rv.getDescricao());
    }
    
    /**
     * Test of setUsers method, of class Roles.
     */
    @Test
    public void testSetUsers() {
        System.out.println("setUsers");
        Set<Users> users = new HashSet<>();
        rv.setUsers(users);
        assertEquals(users, rv.getUsers());
    }

    /**
     * Test of toString method, of class Roles.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Roles{id=1, descricao=descricao}";
        String expResultv = "Roles{id=null, descricao=null}";
        assertEquals(expResult, rc.toString());
        assertEquals(expResultv, rv.toString());
    }

    /**
     * Test of hashCode method, of class Roles.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        assertEquals(rc.hashCode(), rc.hashCode());
        assertNotEquals(rc.hashCode(), rv.hashCode());
    }

    /**
     * Test of equals method, of class Roles.
     */
    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        assertEquals(rc, rc);
        assertEquals(rv, rv);
    }

    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");
        // Testes de sucesso
        assertEquals(rc, rcop);
        assertEquals(rcop, rc);
        // Testes de insucesso
        assertNotEquals(rc, rv);
        assertNotEquals(rv, rc);
    }

    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        assertNotEquals(rc, null);
        assertNotEquals(rv, null);
        assertNotEquals(obj, null);
    }

    @Test
    public void testEqualsCoverage() {
        System.out.println("equals: testa todas as propriedades");

        rcop.setId(2L);
        assertNotEquals(rc, rcop);
        rcop.setId(rc.getId());

        rcop.setDescricao("desc");
        assertNotEquals(rc, rcop);
        rcop.setDescricao(rc.getDescricao());
    }

    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: objetos de classes diferentes");
        assertNotEquals(rc, obj);
        assertNotEquals(rv, obj);
        assertNotEquals(rcop, obj);
    }
}
