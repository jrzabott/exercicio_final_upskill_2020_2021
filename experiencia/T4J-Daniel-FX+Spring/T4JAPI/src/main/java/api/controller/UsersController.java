package api.controller;

import api.DTO.UserRolesDTO;
import api.DTO.UsersDTO;
import api.service.UsersService;
import com.github.fzakaria.ascii85.Ascii85;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UsersController {
    
    @Autowired
    private UsersService usersService;

    void addUser(String app_context, String username, String email, String password, String rolenames) {
        String passEncoded = Ascii85.encode(password.getBytes());
        UsersDTO userDTO = new UsersDTO();
        userDTO.setApp_context(app_context);
        userDTO.setUsername(username);
        userDTO.setEmail(email);
        userDTO.setPassword(passEncoded);
        userDTO.setRolenames(rolenames);
        usersService.addUser(userDTO);
    }

    void addUserRoles(String app_context, String user_id, String rolenames) {
        UserRolesDTO userRolesDTO = new UserRolesDTO();
        userRolesDTO.setApp_context(app_context);
        userRolesDTO.setUser_id(user_id);
        userRolesDTO.setRolenames(rolenames);
        usersService.addUserRoles(userRolesDTO);
    }

    ArrayList<String> getUserRoles(String app_context, String user_id) {
        return usersService.getUserRoles(app_context, user_id);
    }

    void removeUserRoles(String app_context, String user_id, String rolenames) {
        UserRolesDTO userRolesDTO = new UserRolesDTO();
        userRolesDTO.setApp_context(app_context);
        userRolesDTO.setUser_id(user_id);
        userRolesDTO.setRolenames(rolenames);
        usersService.removeUserRoles(userRolesDTO);
    }
}
