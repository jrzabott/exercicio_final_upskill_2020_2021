package t4j.app.converter;

import t4j.app.dto.UserInfoDTO;
import t4j.app.model.User;

public class UserConverter {
    
    /**
     * 
     * @param uidto
     * @return 
     */
    public static User UserInfoDTO2User(UserInfoDTO uidto) {
        User u = new User();
        u.setEmail(uidto.getEmail());
        u.setUsername(uidto.getUsername());
        u.setRoles(uidto.getRolenames());
        return u;
    }
}
