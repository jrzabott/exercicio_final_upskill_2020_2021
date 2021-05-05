package t4j.app.converter;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import t4j.app.dto.LocalDateDTO;

public class LocalDateConverterTest {
    
    private LocalDate ld;
    private LocalDateDTO lddto;
    
    public LocalDateConverterTest() {
        ld = LocalDate.now();
        lddto = new LocalDateDTO();
        lddto.setLocalDate(ld);
    }

    /**
     * Test of data2DataDTO method, of class LocalDateConverter.
     */
    @Test
    public void testData2DataDTO() {
        System.out.println("data2DataDTO");
        LocalDateDTO result = LocalDateConverter.data2DataDTO(ld);
        assertEquals(ld.toString(), result.toString());
    }

    /**
     * Test of dataDTO2Data method, of class LocalDateConverter.
     */
    @Test
    public void testDataDTO2Data() {
        System.out.println("dataDTO2Data");
        LocalDate result = LocalDateConverter.dataDTO2Data(lddto);
        assertEquals(lddto.toString(), result.toString());
    }
}
