package api.converter;

import api.DTO.LocalDateTimeDTO;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LocalDateTimeConverterTest {
    
    private LocalDateTime ldt;
    private LocalDateTimeDTO ldtdto;
    
    public LocalDateTimeConverterTest() {
        ldt = LocalDateTime.now();
        ldtdto = new LocalDateTimeDTO();
        ldtdto.setLocalDateTime(ldt);
        
    }

    /**
     * Test of data2DataDTO method, of class LocalDateTimeConverter.
     */
    @Test
    public void testData2DataDTO() {
        System.out.println("data2DataDTO");
        LocalDateTimeDTO result = LocalDateTimeConverter.data2DataDTO(ldt);
        assertEquals(ldtdto.toString(), result.toString());
    }

    /**
     * Test of dataDTO2Data method, of class LocalDateTimeConverter.
     */
    @Test
    public void testDataDTO2Data() {
        System.out.println("dataDTO2Data");
        LocalDateTime result = LocalDateTimeConverter.dataDTO2Data(ldtdto);
        assertEquals(ldt.toString(), result.toString());
    }
}
