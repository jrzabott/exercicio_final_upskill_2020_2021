package api.converter;

import api.DTO.LocalDateTimeDTO;
import java.time.LocalDateTime;


public class LocalDateTimeConverter {

    public static LocalDateTimeDTO data2DataDTO(LocalDateTime data) throws NullPointerException {
        LocalDateTimeDTO datadto = new LocalDateTimeDTO();
        datadto.setLocalDateTime(data);
        return datadto;
    }

    public static LocalDateTime dataDTO2Data(LocalDateTimeDTO datadto) throws NullPointerException {
        LocalDateTime data = datadto.getLocalDateTime();
        return data;
    }
}
