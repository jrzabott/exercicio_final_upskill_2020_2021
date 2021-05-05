package api.converter;

import api.DTO.RolesDTO;
import api.model.Roles;
import java.util.ArrayList;

public class RolesConverter {

    public static RolesDTO roles2RolesDTO(Roles roles) throws NullPointerException {
        RolesDTO rolesDTO = new RolesDTO();
        rolesDTO.setId(roles.getId());
        rolesDTO.setRolename(roles.getDescricao());
        return rolesDTO;
    }

    public static Roles rolesDTO2Roles(RolesDTO rolesDTO) throws NullPointerException {
        Roles roles = new Roles();
        roles.setId(rolesDTO.getId());
        roles.setDescricao(rolesDTO.getRolename());
        return roles;
    }

    public static ArrayList<RolesDTO> listRoles2ListRolesDTO(ArrayList<Roles> roles) throws NullPointerException {
        ArrayList<RolesDTO> rolesDTO = new ArrayList<>();
        for (Roles role : roles) {
            try {
                RolesDTO rdto = roles2RolesDTO(role);
                rolesDTO.add(rdto);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        return rolesDTO;
    }

    public static ArrayList<Roles> listRolesDTO2ListRoles(ArrayList<RolesDTO> rolesDTO) throws NullPointerException {
        ArrayList<Roles> roles = new ArrayList<>();
        for (RolesDTO roleDTO : rolesDTO) {
            try {
                Roles r = rolesDTO2Roles(roleDTO);
                roles.add(r);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        return roles;
    }
}
