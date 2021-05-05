package api.converter;

import api.DTO.ContextsDTO;
import api.model.Contexts;
import java.time.LocalDateTime;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContextsConverterTest {
    
    private Contexts c;
    private ContextsDTO cdto;
    private ArrayList<Contexts> contexts;
    private ArrayList<ContextsDTO> contextsDTO;
    
    public ContextsConverterTest() {
        contexts = new ArrayList<>();
        contextsDTO = new ArrayList<>();
        c = new Contexts(1L, "contexts", LocalDateTime.MIN, "Y");
        cdto = new ContextsDTO();
        LocalDateTime ldt = LocalDateTime.MIN;
        cdto.setId(1L);
        cdto.setContext("contexts");
        cdto.setDataCriacao(LocalDateTimeConverter.data2DataDTO(ldt));
        cdto.setValido("Y");
        contexts.add(c);
        contextsDTO.add(cdto);
    }

    /**
     * Test of contexts2ContextsDTO method, of class ContextsConverter.
     */
    @Test
    public void testContexts2ContextsDTO() {
        System.out.println("users2UsersDTO");
        ContextsDTO result = ContextsConverter.contexts2ContextsDTO(c);
        assertEquals(cdto.toString(), result.toString());
    }

    /**
     * Test of contextsDTO2Contexts method, of class ContextsConverter.
     */
    @Test
    public void testContextsDTO2Contexts() {
        System.out.println("usersDTO2Users");
        Contexts result = ContextsConverter.contextsDTO2Contexts(cdto);
        assertEquals(c.toString(), result.toString());
    }

    /**
     * Test of listContexts2ListContextsDTO method, of class ContextsConverter.
     */
    @Test
    public void testListContexts2ListContextsDTO() {
        System.out.println("listContexts2ListContextsDTO");
        ArrayList<ContextsDTO> result = ContextsConverter.listContexts2ListContextsDTO(contexts);
        assertEquals(contextsDTO.contains(cdto.toString()), result.contains(cdto.toString()));
    }

    /**
     * Test of listContextsDTO2ListContexts method, of class ContextsConverter.
     */
    @Test
    public void testListContextsDTO2ListContexts() {
        System.out.println("listContextsDTO2ListContexts");
        ArrayList<Contexts> result = ContextsConverter.listContextsDTO2ListContexts(contextsDTO);
        assertEquals(contexts.contains(c.toString()), result.contains(c.toString()));
    }
}
