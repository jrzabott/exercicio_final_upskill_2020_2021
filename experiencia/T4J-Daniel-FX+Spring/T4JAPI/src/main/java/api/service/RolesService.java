package api.service;

import api.DTO.RolesDTO;
import api.converter.RolesConverter;
import api.dao.ContextsDAO;
import api.dao.RolesDAO;
import api.dao.SessionsDAO;
import api.model.Roles;
import exception.ConversaoException;
import exception.ElementoDuplicadoException;
import exception.ElementoNaoExistenteException;
import exception.NoRollbackException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RolesService {

    @Autowired
    RolesDAO rdao;
    @Autowired
    ContextsDAO cdao;
    @Autowired
    SessionsDAO sdao;
    @Autowired
    ContextsService contextsService;

    public RolesService() {
    }

    @Transactional(noRollbackFor = NoRollbackException.class)
    public boolean addRole(RolesDTO roleDTO) {
        if (contextsService.validaContextAndSession(roleDTO.getApp_context())) {
            Roles roles = RolesConverter.rolesDTO2Roles(roleDTO);
            if (roles == null) {
                throw new ConversaoException("RolesDTO");
            }
            String descricao = roles.getDescricao();
            if (descricao == null) {
                throw new NullPointerException("O campo rolename está vazio");
            }
            if (descricao.isEmpty()) {
                throw new ElementoNaoExistenteException("O campo rolename está vazio");
            }
            int count = rdao.countRoleByDescricao(descricao);
            if (count > 0) {
                throw new ElementoDuplicadoException(String.format("Role %s já existe.", descricao));
            }
            roles = rdao.save(roles);
            return roles != null;
        } else {
            return false;
        }
    }

    @Transactional(noRollbackFor = NoRollbackException.class)
    public ArrayList<RolesDTO> getRoles(String app_context) {
        if (contextsService.validaContextAndSession(app_context)) {
            ArrayList<RolesDTO> listaRolesDTO = new ArrayList<>();
            ArrayList<Roles> listaRoles = new ArrayList<>();
            for (Roles role : rdao.findAll()) {
                listaRoles.add(role);
            }
            listaRolesDTO = RolesConverter.listRoles2ListRolesDTO(listaRoles);
            if (listaRolesDTO == null) {
                throw new ConversaoException("RolesDTO");
            }
            return listaRolesDTO;
        } else {
            return null;
        }
    }

    @Transactional(noRollbackFor = NoRollbackException.class)
    public boolean removeRole(RolesDTO roleDTO) {
        if (contextsService.validaContextAndSession(roleDTO.getApp_context())) {
            Roles roles = RolesConverter.rolesDTO2Roles(roleDTO);
            if (roles == null) {
                throw new ConversaoException("RolesDTO");
            }
            String descricao = roles.getDescricao();
            if (descricao == null) {
                throw new NullPointerException("O campo rolename está vazio");
            }
            if (descricao.isEmpty()) {
                throw new ElementoNaoExistenteException("O campo rolename está vazio");
            }
            Roles role = rdao.getRoleByDescricao(descricao);
            int count = rdao.countRoleByDescricao(descricao);
            if (count > 0) {
                rdao.delete(role);
                return true;
            } else {
                throw new ElementoNaoExistenteException(String.format("Role %s não existe.", descricao));
            }
        } else {
            return false;
        }
    }
}
