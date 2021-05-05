package api.service;

import api.DTO.UserRolesDTO;
import api.DTO.UsersDTO;
import api.converter.UsersConverter;
import api.dao.ContextsDAO;
import api.dao.RolesDAO;
import api.dao.SessionsDAO;
import api.dao.UsersDAO;
import api.model.Roles;
import api.model.Users;
import exception.ConversaoException;
import exception.ElementoDuplicadoException;
import exception.ElementoInvalidoException;
import exception.ElementoNaoExistenteException;
import exception.NoRollbackException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.validator.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersService {

    @Autowired
    UsersDAO udao;
    @Autowired
    RolesDAO rdao;
    @Autowired
    ContextsDAO cdao;
    @Autowired
    SessionsDAO sdao;
    @Autowired
    ContextsService contextsService;

    UsersService() {
    }

    @Transactional(noRollbackFor = NoRollbackException.class)
    public boolean addUser(UsersDTO userDTO) {
        String app_context = userDTO.getApp_context();
        if (cdao.checkIfContextIsValid(app_context) == null || "N".equals(cdao.checkIfContextIsValid(app_context))) {
            throw new ElementoInvalidoException("Contexto inválido");
        }
        String email = userDTO.getEmail();
        if (email == null) {
            throw new NullPointerException("O campo email está vazio");
        }
        if (email.isEmpty()) {
            throw new ElementoNaoExistenteException("O campo email está vazio");
        }
        String username = userDTO.getUsername();
        if (username == null) {
            throw new NullPointerException("O campo username está vazio");
        }
        if (username.isEmpty()) {
            throw new ElementoNaoExistenteException("O campo username está vazio");
        }
        String password = userDTO.getPassword();
        if (password == null) {
            throw new NullPointerException("O campo password está vazio");
        }
        if (password.isEmpty()) {
            throw new ElementoNaoExistenteException("O campo password está vazio");
        }
        EmailValidator emailValidator = EmailValidator.getInstance();
        if (!emailValidator.isValid(email)) {
            throw new ElementoInvalidoException("Introduza um email válido");
        }
        if (udao.countUserByEmail(email) != 0) {
            throw new ElementoDuplicadoException("Email já existe.");
        }
        if (udao.countUserByUsername(username) != 0) {
            throw new ElementoDuplicadoException("Username já existe.");
        }
        Users user = UsersConverter.usersDTO2Users(userDTO);
        if (user == null) {
            throw new ConversaoException("UsersDTO");
        }
        Set<Roles> rolesSet = new HashSet<>();
        boolean verificarRolenames = userDTO.getRolenames() != null;
        if (verificarRolenames == true) {
            String rolenames = userDTO.getRolenames().trim();
            String[] arrRolenames = rolenames.split(",");
            for (String arrRolename : arrRolenames) {
                int verificarExistenciaRole = rdao.countRoleByDescricao(arrRolename.trim());
                if (verificarExistenciaRole != 1) {
                    throw new ElementoNaoExistenteException(String.format("O Role %s não existe. Tem de o criar primeiro.", arrRolename));
                }
                rolesSet.add(new Roles(rdao.getRoleByDescricao(arrRolename.trim()).getId(), arrRolename));
                user.setRoles(rolesSet);
            }
        }
        user = udao.save(user);
        return user != null;
    }

    @Transactional(noRollbackFor = NoRollbackException.class)
    public ArrayList<String> getUserRoles(String app_context, String user_id) {
        if (user_id == null) {
            throw new NullPointerException("O campo userid está vazio");
        }
        if (user_id.isEmpty()) {
            throw new ElementoNaoExistenteException("O campo userid está vazio");
        }
        if (contextsService.validaContextAndSession(app_context)) {
            Long idUser = getIdFromUserId(user_id);
            ArrayList<String> listUserRoles = new ArrayList<>();
            listUserRoles = rdao.getUserRolesByUserId(idUser);
            return listUserRoles;
        } else {
            return null;
        }
    }

    @Transactional(noRollbackFor = NoRollbackException.class)
    public boolean addUserRoles(UserRolesDTO userRolesDTO) {
        String user_id = userRolesDTO.getUser_id();
        if (user_id == null) {
            throw new NullPointerException("O campo userid está vazio");
        }
        if (user_id.isEmpty()) {
            throw new ElementoNaoExistenteException("O campo userid está vazio");
        }
        if (contextsService.validaContextAndSession(userRolesDTO.getApp_context())) {
            Long idUser = getIdFromUserId(user_id);
            String rolenames = userRolesDTO.getRolenames();
            if (rolenames == null) {
                throw new NullPointerException("O campo rolenames está vazio");
            }
            if (rolenames.isEmpty()) {
                throw new ElementoNaoExistenteException("O campo rolenames está vazio");
            }
            String[] arrRolenames = rolenames.split(",");
            for (String arrRolename : arrRolenames) {
                int verificarExistenciaRole = rdao.countRoleByDescricao(arrRolename.trim());
                if (verificarExistenciaRole != 1) {
                    throw new ElementoNaoExistenteException(String.format("O Role %s não existe. Tem de o criar primeiro.", arrRolename));
                }
                Long id_roles = rdao.getRoleByDescricao(arrRolename.trim()).getId();
                udao.insertNewUserRole(idUser, id_roles);
            }
            return true;
        } else {
            return false;
        }
    }

    @Transactional(noRollbackFor = NoRollbackException.class)
    public boolean removeUserRoles(UserRolesDTO userRolesDTO) {
        String user_id = userRolesDTO.getUser_id();
        if (user_id == null) {
            throw new NullPointerException("O campo userid está vazio");
        }
        if (user_id.isEmpty()) {
            throw new ElementoNaoExistenteException("O campo userid está vazio");
        }
        if (contextsService.validaContextAndSession(userRolesDTO.getApp_context())) {
            Long idUser = getIdFromUserId(user_id);
            String rolenames = userRolesDTO.getRolenames();
            if (rolenames == null) {
                throw new NullPointerException("O campo rolenames está vazio");
            }
            if (rolenames.isEmpty()) {
                throw new ElementoNaoExistenteException("O campo rolenames está vazio");
            }
            String[] arrRolenames = rolenames.split(",");
            for (String arrRolename : arrRolenames) {
                int verificarExistenciaRole = rdao.countRoleByDescricao(arrRolename.trim());
                if (verificarExistenciaRole != 1) {
                    throw new ElementoNaoExistenteException(String.format("O Role %s não existe.", arrRolename));
                }
                Long id_roles = rdao.getRoleByDescricao(arrRolename.trim()).getId();
                udao.deleteUserRoles(idUser, id_roles);
            }
            return true;
        } else {
            return false;
        }
    }

    private Long getIdFromUserId(String user_id) {
        EmailValidator emailValidator = EmailValidator.getInstance();
        if (emailValidator.isValid(user_id)) {
            try {
                Long idUser = udao.getUserByEmail(user_id).getId();
                return idUser;
            } catch (NullPointerException e) {
                throw new NullPointerException("O Utilizador não existe");
            }
        } else {
            try {
                Long idUser = udao.getUserByUsername(user_id).getId();
                return idUser;
            } catch (NullPointerException e) {
                throw new NullPointerException("O Utilizador não existe");
            }
        }
    }
}
