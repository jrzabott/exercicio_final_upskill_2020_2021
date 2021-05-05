package api.DTO;

import static api.converter.LocalDateTimeConverter.data2DataDTO;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LocalDateTimeDTOTest {
    
    LocalDateTimeDTO ldtdto;
    
    public LocalDateTimeDTOTest() {
        ldtdto = new LocalDateTimeDTO();
    }

    /**
     * Test of getLocalDateTime method, of class LocalDateTimeDTO.
     */
    @Test
    public void testGetLocalDateTime() {
        System.out.println("getLocalDateTime");
        LocalDateTime expResult = null;
        assertEquals(expResult, ldtdto.getLocalDateTime());
    }

    /**
     * Test of setLocalDateTime method, of class LocalDateTimeDTO.
     */
    @Test
    public void testSetLocalDateTime() {
        System.out.println("setLocalDateTime");
        LocalDateTime localDateTime = LocalDateTime.now();
        ldtdto.setLocalDateTime(localDateTime);
        assertEquals(localDateTime, ldtdto.getLocalDateTime());
    }

    /**
     * Test of toString method, of class LocalDateTimeDTO.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        LocalDateTime localDateTime = LocalDateTime.MIN;
        ldtdto = data2DataDTO(localDateTime);
        String expResult = "-999999999-01-01T00:00";
        assertEquals(expResult, ldtdto.toString());
    }
}
