package api.controller;

import api.DTO.GetSessionDTO;
import api.DTO.LoginDTO;
import api.service.SessionsService;
import com.github.fzakaria.ascii85.Ascii85;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SessionsController {
    
    @Autowired
    private SessionsService sessionsService;

    GetSessionDTO getSession(String app_context) {
        return sessionsService.getSession(app_context);
    }

    void login(String app_context, String user_id, String password) {
        String passEncoded = Ascii85.encode(password.getBytes());
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setApp_context(app_context);
        loginDTO.setUser_id(user_id);
        loginDTO.setPassword(passEncoded);
        sessionsService.login(loginDTO);
    }

    void logout(String app_context) {
        sessionsService.logout(app_context);
    }
}
