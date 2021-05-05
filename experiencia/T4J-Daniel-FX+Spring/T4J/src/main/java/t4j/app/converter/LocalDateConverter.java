package t4j.app.converter;

import java.time.LocalDate;
import t4j.app.dto.LocalDateDTO;

public class LocalDateConverter {
    
    /**
     * 
     * @param data
     * @return
     * @throws NullPointerException 
     */
    public static LocalDateDTO data2DataDTO(LocalDate data) throws NullPointerException {
        LocalDateDTO datadto = new LocalDateDTO();
        datadto.setLocalDate(data);
        return datadto;
    }

    /**
     * 
     * @param datadto
     * @return
     * @throws NullPointerException 
     */
    public static LocalDate dataDTO2Data(LocalDateDTO datadto) throws NullPointerException {
        LocalDate data = datadto.getLocalDate();
        return data;
    }
}
