package api.controller;

import api.DTO.RolesDTO;
import api.service.RolesService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RolesController {
    
    @Autowired
    private RolesService rolesService;

    void addRole(String app_context, String rolename) {
        RolesDTO roleDTO = new RolesDTO();
        roleDTO.setApp_context(app_context);
        roleDTO.setRolename(rolename);
        rolesService.addRole(roleDTO);
    }

    ArrayList<RolesDTO> getRoles(String app_context) {
        return rolesService.getRoles(app_context);
    }

    void removeRole(String app_context, String rolename) {
        RolesDTO roleDTO = new RolesDTO();
        roleDTO.setApp_context(app_context);
        roleDTO.setRolename(rolename);
        rolesService.removeRole(roleDTO);
    }
}
