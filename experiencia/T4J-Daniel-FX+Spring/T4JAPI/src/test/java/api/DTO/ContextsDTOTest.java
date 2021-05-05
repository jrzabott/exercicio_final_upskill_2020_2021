package api.DTO;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContextsDTOTest {
    
    ContextsDTO cdto;
    
    public ContextsDTOTest() {
        cdto = new ContextsDTO();
    }

    /**
     * Test of getId method, of class ContextsDTO.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Long expResult = null;
        assertEquals(expResult, cdto.getId());
    }

    /**
     * Test of getContext method, of class ContextsDTO.
     */
    @Test
    public void testGetContext() {
        System.out.println("getContext");
        String expResult = null;
        assertEquals(expResult, cdto.getContext());
    }

    /**
     * Test of getDataCriacao method, of class ContextsDTO.
     */
    @Test
    public void testGetDataCriacao() {
        System.out.println("getDataCriacao");
        LocalDateTimeDTO expResult = null;
        assertEquals(expResult, cdto.getDataCriacao());
    }

    /**
     * Test of getValido method, of class ContextsDTO.
     */
    @Test
    public void testGetValido() {
        System.out.println("getValido");
        String expResult = null;
        assertEquals(expResult, cdto.getValido());
    }

    /**
     * Test of setId method, of class ContextsDTO.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 1L;
        cdto.setId(id);
        assertEquals(id, cdto.getId());
    }

    /**
     * Test of setContext method, of class ContextsDTO.
     */
    @Test
    public void testSetContext() {
        System.out.println("setContext");
        String context = "context";
        cdto.setContext(context);
        assertEquals(context, cdto.getContext());
    }

    /**
     * Test of setDataCriacao method, of class ContextsDTO.
     */
    @Test
    public void testSetDataCriacao() {
        System.out.println("setDataCriacao");
        LocalDateTimeDTO dataCriacao = null;
        cdto.setDataCriacao(dataCriacao);
        assertEquals(dataCriacao, cdto.getDataCriacao());
    }

    /**
     * Test of setValido method, of class ContextsDTO.
     */
    @Test
    public void testSetValido() {
        System.out.println("setValido");
        String valido = "valido";
        cdto.setValido(valido);
        assertEquals(valido, cdto.getValido());
    }

    /**
     * Test of toString method, of class ContextsDTO.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "ContextsDTO{id=null, context=null, dataCriacao=null, valido=null}";
        assertEquals(expResult, cdto.toString());
    }
}
