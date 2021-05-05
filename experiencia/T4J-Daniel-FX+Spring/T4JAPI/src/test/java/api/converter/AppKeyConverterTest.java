package api.converter;

import api.DTO.AppKeyDTO;
import api.model.AppKey;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AppKeyConverterTest {
    
    private AppKey ak;
    private AppKeyDTO akdto;
    private ArrayList<AppKey> appKey;
    private ArrayList<AppKeyDTO> appKeyDTO;
    
    public AppKeyConverterTest() {
        appKey = new ArrayList<>();
        appKeyDTO = new ArrayList<>();
        ak = new AppKey(1L, "appKey", "descricao", 1L);
        akdto = new AppKeyDTO();
        akdto.setId(1L);
        akdto.setAppKey("appKey");
        akdto.setDescricao("descricao");
        akdto.setTimeout(1L);
        appKey.add(ak);
        appKeyDTO.add(akdto);
    }

    /**
     * Test of appKey2AppKeyDTO method, of class AppKeyConverter.
     */
    @Test
    public void testAppKey2AppKeyDTO() {
        System.out.println("appKey2AppKeyDTO");
        AppKeyDTO result = AppKeyConverter.appKey2AppKeyDTO(ak);
        assertEquals(akdto.toString(), result.toString());
    }

    /**
     * Test of appKeyDTO2AppKey method, of class AppKeyConverter.
     */
    @Test
    public void testAppKeyDTO2AppKey() {
        System.out.println("appKeyDTO2AppKey");
        AppKey result = AppKeyConverter.appKeyDTO2AppKey(akdto);
        assertEquals(ak.toString(), result.toString());
    }

    /**
     * Test of listAppKey2ListAppKeyDTO method, of class AppKeyConverter.
     */
    @Test
    public void testListAppKey2ListAppKeyDTO() {
        System.out.println("listAppKey2ListAppKeyDTO");
        ArrayList<AppKeyDTO> result = AppKeyConverter.listAppKey2ListAppKeyDTO(appKey);
        assertEquals(appKeyDTO.contains(akdto.toString()), result.contains(akdto.toString()));
    }

    /**
     * Test of listAppKeyDTO2ListAppKey method, of class AppKeyConverter.
     */
    @Test
    public void testListAppKeyDTO2ListAppKey() {
        System.out.println("listAppKeyDTO2ListAppKey");
        ArrayList<AppKey> result = AppKeyConverter.listAppKeyDTO2ListAppKey(appKeyDTO);
        assertEquals(appKey.contains(ak.toString()), result.contains(ak.toString()));
    }
}
