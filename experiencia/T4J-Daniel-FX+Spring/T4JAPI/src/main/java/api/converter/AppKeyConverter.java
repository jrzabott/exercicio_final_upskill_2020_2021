package api.converter;

import api.DTO.AppKeyDTO;
import api.model.AppKey;
import java.util.ArrayList;

public class AppKeyConverter {
    
    public static AppKeyDTO appKey2AppKeyDTO(AppKey appKey) throws NullPointerException {
        AppKeyDTO appKeyDTO = new AppKeyDTO();
        appKeyDTO.setId(appKey.getId());
        appKeyDTO.setAppKey(appKey.getAppKey());
        appKeyDTO.setDescricao(appKey.getDescricao());
        appKeyDTO.setTimeout(appKey.getTimeout());
        return  appKeyDTO;
    }
    
    public static AppKey appKeyDTO2AppKey(AppKeyDTO appKeyDTO) throws NullPointerException {
        AppKey appKey = new AppKey();
        appKey.setId(appKeyDTO.getId());
        appKey.setAppKey(appKeyDTO.getAppKey());
        appKey.setDescricao(appKeyDTO.getDescricao());
        appKey.setTimeout(appKeyDTO.getTimeout());
        return  appKey;
    }
    
    public static ArrayList<AppKeyDTO> listAppKey2ListAppKeyDTO(ArrayList<AppKey> appKey) throws NullPointerException {
        ArrayList<AppKeyDTO> appKeyDTO = new ArrayList<>();
        for (AppKey ap : appKey) {
            try {
                AppKeyDTO apdto = appKey2AppKeyDTO(ap);
                appKeyDTO.add(apdto);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        return appKeyDTO;
    }

    public static ArrayList<AppKey> listAppKeyDTO2ListAppKey(ArrayList<AppKeyDTO> appKeyDTO) throws NullPointerException {
        ArrayList<AppKey> appKey = new ArrayList<>();
        for (AppKeyDTO apDTO : appKeyDTO) {
            try {
                AppKey ap = appKeyDTO2AppKey(apDTO);
                appKey.add(ap);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        return appKey;
    }
}
