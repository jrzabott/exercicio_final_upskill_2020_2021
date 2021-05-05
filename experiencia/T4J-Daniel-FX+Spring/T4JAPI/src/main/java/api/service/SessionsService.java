package api.service;

import api.DTO.GetSessionDTO;
import api.DTO.LoginDTO;
import api.dao.AppKeyDAO;
import api.dao.ContextsDAO;
import api.dao.RolesDAO;
import api.dao.SessionsDAO;
import api.dao.UsersDAO;
import api.model.Contexts;
import api.model.Sessions;
import api.model.Users;
import exception.ElementoInvalidoException;
import exception.ElementoNaoExistenteException;
import exception.NoRollbackException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import org.apache.commons.validator.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SessionsService {

    @Autowired
    SessionsDAO sdao;
    @Autowired
    ContextsDAO cdao;
    @Autowired
    AppKeyDAO apdao;
    @Autowired
    UsersDAO udao;
    @Autowired
    RolesDAO rdao;
    @Autowired
    ContextsService contextsService;

    private static final String APPKEY = "VDRKIC0gVVBTS0lMTCAtIEJSVU5PIEJBUkJPU0EgLSBEQU5JRUwgSlVOSU9SIC0gRkVSTkFORE8gQ1JJU1RBIC0gSk9SR0UgUElSRVM";
    
    public SessionsService() {
    }

    @Transactional(noRollbackFor = NoRollbackException.class)
    public GetSessionDTO getSession(String app_context) {
        if (contextsService.validaContextAndSession(app_context)) {
            GetSessionDTO gsdto = new GetSessionDTO();
            Long idContext = cdao.getContextByContext(app_context).getId();
            Sessions session = sdao.getSessionsByIdContext(idContext);
            LocalDateTime loginDate = session.getLoginDate();
            Long idUser = session.getIdUser();
            Users user = udao.getUserById(idUser);
            String username = user.getUsername();
            String email = user.getEmail();
            gsdto.setUsername(username);
            gsdto.setEmail(email);
            gsdto.setRolenames(rdao.getRolesByUserId(idUser));
            gsdto.setLogin_date(loginDate);
            return gsdto;
        } else {
            return null;
        }
    }

    @Transactional(noRollbackFor = NoRollbackException.class)
    public boolean login(LoginDTO loginDTO) {
        String app_context = loginDTO.getApp_context();
        if (cdao.checkIfContextIsValid(app_context) == null || "N".equals(cdao.checkIfContextIsValid(app_context))) {
            throw new ElementoInvalidoException("Contexto inválido");
        }
        String userid = loginDTO.getUser_id();
        if (userid == null) {
            throw new NullPointerException("O campo username está vazio");
        }
        if (userid.isEmpty()) {
            throw new ElementoNaoExistenteException("O campo username está vazio");
        }
        String password = loginDTO.getPassword();
        if (password == null) {
            throw new NullPointerException("O campo password está vazio");
        }
        if (password.isEmpty()) {
            throw new ElementoNaoExistenteException("O campo password está vazio");
        }
        Contexts context = cdao.getContextByContext(loginDTO.getApp_context());
        Long idContext = context.getId();
        LocalDateTime dataCriacao = context.getDataCriacao();
        // TODO atualização para o futuro: associar, na BD, cada app_context à appkey que a gerou.
        // Usar esse dado para retornar o valor do timeout de modo a AppKey não estar Hardcoded na API.
        Long timeout = apdao.getTimeoutByAppKey(APPKEY);
        Long diff = dataCriacao.until(LocalDateTime.now(), ChronoUnit.MILLIS);
        if (diff > timeout) {
            cdao.invalidateContext(idContext);
            throw new NoRollbackException("Contexto inválido (timeout)");
        }
        try {
            EmailValidator emailValidator = EmailValidator.getInstance();
            Sessions session = new Sessions();
            if (emailValidator.isValid(userid)) {
                Users user = udao.getUserByEmail(userid);
                if (user == null) {
                    throw new NullPointerException("Utilizador e password inválidos");
                }
                Long idUser = udao.getUserByEmail(userid).getId();
                if (udao.countUserByEmailAndPassword(userid, password) == 1) {
                    session.setLoginDate(LocalDateTime.now());
                    session.setIdContext(idContext);
                    session.setIdUser(idUser);
                    session = sdao.save(session);
                } else {
                    throw new ElementoInvalidoException("Utilizador e password inválidos");
                }
            } else {
                Users user = udao.getUserByUsername(userid);
                if (user == null) {
                    throw new NullPointerException("Utilizador e password inválidos");
                }
                Long idUser = udao.getUserByUsername(userid).getId();
                if (udao.countUserByUsernameAndPassword(userid, password) == 1) {
                    session.setLoginDate(LocalDateTime.now());
                    session.setIdContext(idContext);
                    session.setIdUser(idUser);
                    session = sdao.save(session);
                } else {
                    throw new ElementoInvalidoException("Utilizador e password inválidos");
                }
            }
            return session != null;
        } catch (DataIntegrityViolationException de) {
            throw new DataIntegrityViolationException("Login já se encontra efetuado");
        }
    }

    @Transactional(noRollbackFor = NoRollbackException.class)
    public boolean logout(String app_context) {
        if (contextsService.validaContextAndSession(app_context)) {
            cdao.invalidateContext(app_context);
            return true;
        } else {
            return false;
        }
    }
}
