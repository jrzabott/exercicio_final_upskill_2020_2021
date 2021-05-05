package api.controller;

import api.DTO.ContextsDTO;
import api.DTO.ErroDTO;
import api.DTO.GetSessionDTO;
import api.DTO.RolesDTO;
import exception.ContextoInvalidoException;
import exception.ElementoDuplicadoException;
import exception.ElementoNaoExistenteException;
import exception.NoRollbackException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WebServerController {

    @Autowired
    private RolesController rolesController;
    @Autowired
    private SessionsController sessionsController;
    @Autowired
    private UsersController usersController;
    @Autowired
    private ContextsController contextsController;

    @RequestMapping(value = "/context",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getContext(@RequestParam String app_key) {
        try {
            ContextsDTO contextDTO = contextsController.getContext(app_key);
            if (contextDTO != null) {
                ArrayList<ContextsDTO> listContextsDTO = new ArrayList<>();
                listContextsDTO.add(contextDTO);
                return new ResponseEntity<>(listContextsDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(arrayErroDTO(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = {"/registerUser", "/registerUserWithRoles"},
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addRegisteredUser(@RequestParam String app_context, String username, String email, String password, String rolenames) {
        try {
            usersController.addUser(app_context, username, email, password, rolenames);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (ContextoInvalidoException | NoRollbackException e) {
            return new ResponseEntity<>(arrayErroDTO(e), HttpStatus.UNAUTHORIZED);
        } catch (NullPointerException | ElementoNaoExistenteException | ElementoDuplicadoException e) {
            return new ResponseEntity<>(arrayErroDTO(e), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(arrayErroDTO(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/login",
            method = RequestMethod.POST)
    public ResponseEntity<Object> login(@RequestParam String app_context, String user_id, String password) {
        try {
            sessionsController.login(app_context, user_id, password);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ContextoInvalidoException | NoRollbackException e) {
            return new ResponseEntity<>(arrayErroDTO(e), HttpStatus.UNAUTHORIZED);
        } catch (NullPointerException | ElementoNaoExistenteException e) {
            return new ResponseEntity<>(arrayErroDTO(e), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(arrayErroDTO(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/logout",
            method = RequestMethod.POST)
    public ResponseEntity<Object> logout(@RequestParam String app_context) {
        try {
            sessionsController.logout(app_context);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ContextoInvalidoException | NoRollbackException e) {
            return new ResponseEntity<>(arrayErroDTO(e), HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            return new ResponseEntity<>(arrayErroDTO(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/roles",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getRoles(@RequestParam String app_context) {
        try {
            ArrayList<RolesDTO> listRolesDTO = rolesController.getRoles(app_context);
            if (listRolesDTO != null) {
                return new ResponseEntity<>(listRolesDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (ContextoInvalidoException | NoRollbackException e) {
            return new ResponseEntity<>(arrayErroDTO(e), HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            return new ResponseEntity<>(arrayErroDTO(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/roles",
            method = RequestMethod.POST)
    public ResponseEntity<Object> addRole(@RequestParam String app_context, String rolename) {
        try {
            rolesController.addRole(app_context, rolename);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (ContextoInvalidoException | NoRollbackException e) {
            return new ResponseEntity<>(arrayErroDTO(e), HttpStatus.UNAUTHORIZED);
        } catch (NullPointerException | ElementoNaoExistenteException e) {
            return new ResponseEntity<>(arrayErroDTO(e), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(arrayErroDTO(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/roles",
            method = RequestMethod.DELETE)
    public ResponseEntity<Object> removeRole(@RequestParam String app_context, String rolename) {
        try {
            rolesController.removeRole(app_context, rolename);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ContextoInvalidoException | NoRollbackException e) {
            return new ResponseEntity<>(arrayErroDTO(e), HttpStatus.UNAUTHORIZED);
        } catch (NullPointerException | ElementoNaoExistenteException e) {
            return new ResponseEntity<>(arrayErroDTO(e), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            if (e.getMessage().contains("FK_ID_ROLES_USERROLES")) {
                return new ResponseEntity<>(arrayErroDTO(new Exception("Não é possível eliminar um Role que esteja associado a um utilizador")), HttpStatus.INTERNAL_SERVER_ERROR);
            } else {
                return new ResponseEntity<>(arrayErroDTO(e), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @RequestMapping(value = "/userRoles",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getUserRoles(@RequestParam String app_context, String user_id) {
        try {
            ArrayList<String> listRoles = usersController.getUserRoles(app_context, user_id);
            if (listRoles != null) {
                return new ResponseEntity<>(listRoles, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (ContextoInvalidoException | NoRollbackException e) {
            return new ResponseEntity<>(arrayErroDTO(e), HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            return new ResponseEntity<>(arrayErroDTO(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/userRoles",
            method = RequestMethod.POST)
    public ResponseEntity<Object> addUserRoles(@RequestParam String app_context, String user_id, String rolenames) {
        try {
            usersController.addUserRoles(app_context, user_id, rolenames);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (ContextoInvalidoException | NoRollbackException e) {
            return new ResponseEntity<>(arrayErroDTO(e), HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            if (e.getMessage().contains("UK_UNIQUE_USERROLES")) {
                return new ResponseEntity<>(arrayErroDTO(new Exception("Já existe o Role associado ao utilizador")), HttpStatus.INTERNAL_SERVER_ERROR);
            } else {
                return new ResponseEntity<>(arrayErroDTO(e), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @RequestMapping(value = "/userRoles",
            method = RequestMethod.DELETE)
    public ResponseEntity<Object> removeUserRoles(@RequestParam String app_context, String user_id, String rolenames) {
        try {
            usersController.removeUserRoles(app_context, user_id, rolenames);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ContextoInvalidoException | NoRollbackException e) {
            return new ResponseEntity<>(arrayErroDTO(e), HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            return new ResponseEntity<>(arrayErroDTO(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/session",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getSession(@RequestParam String app_context) {
        try {
            GetSessionDTO getSessionDTO = sessionsController.getSession(app_context);
            if (getSessionDTO != null) {
                ArrayList<GetSessionDTO> listGetSessionDTO = new ArrayList<>();
                listGetSessionDTO.add(getSessionDTO);
                return new ResponseEntity<>(listGetSessionDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (ContextoInvalidoException | NoRollbackException e) {
            return new ResponseEntity<>(arrayErroDTO(e), HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            return new ResponseEntity<>(arrayErroDTO(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private ArrayList<ErroDTO> arrayErroDTO(Exception e) {
        ArrayList<ErroDTO> arrayErroDTO = new ArrayList<>();
        arrayErroDTO.add(new ErroDTO(e));
        return arrayErroDTO;
    }
}
