package api.converter;

import api.DTO.RolesDTO;
import api.model.Roles;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RolesConverterTest {
    
    private Roles r;
    private RolesDTO rdto;
    private ArrayList<Roles> roles;
    private ArrayList<RolesDTO> rolesDTO;
    
    public RolesConverterTest() {
        roles = new ArrayList<>();
        rolesDTO = new ArrayList<>();
        r = new Roles(1L, "descricao");
        rdto = new RolesDTO();
        rdto.setId(1L);
        rdto.setRolename("descricao");
        roles.add(r);
        rolesDTO.add(rdto);
    }

    /**
     * Test of roles2RolesDTO method, of class RolesConverter.
     */
    @Test
    public void testRoles2RolesDTO() {
        System.out.println("users2UsersDTO");
        RolesDTO result = RolesConverter.roles2RolesDTO(r);
        assertEquals(rdto.toString(), result.toString());
    }

    /**
     * Test of rolesDTO2Roles method, of class RolesConverter.
     */
    @Test
    public void testRolesDTO2Roles() {
        System.out.println("usersDTO2Users");
        Roles result = RolesConverter.rolesDTO2Roles(rdto);
        assertEquals(r.toString(), result.toString());
    }

    /**
     * Test of listRoles2ListRolesDTO method, of class RolesConverter.
     */
    @Test
    public void testListRoles2ListRolesDTO() {
        System.out.println("listRoles2ListRolesDTO");
        ArrayList<RolesDTO> result = RolesConverter.listRoles2ListRolesDTO(roles);
        assertEquals(rolesDTO.contains(rdto.toString()), result.contains(rdto.toString()));
    }

    /**
     * Test of listRolesDTO2ListRoles method, of class RolesConverter.
     */
    @Test
    public void testListRolesDTO2ListRoles() {
        System.out.println("listRolesDTO2ListRoles");
        ArrayList<Roles> result = RolesConverter.listRolesDTO2ListRoles(rolesDTO);
        assertEquals(roles.contains(r.toString()), result.contains(r.toString()));
    }
}
