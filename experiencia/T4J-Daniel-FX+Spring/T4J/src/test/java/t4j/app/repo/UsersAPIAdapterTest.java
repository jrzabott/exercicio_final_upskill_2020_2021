package t4j.app.repo;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import t4j.app.dto.OrganizacaoDTO;
import t4j.app.dto.RoleDTO;
import t4j.app.dto.UserInfoDTO;
import t4j.app.exception.LoginServerException;
import t4j.app.exception.UsersAPIException;

/**
 *
 * @author user
 */
public class UsersAPIAdapterTest {

    private UsersAPIAdapter uapiaInvalidK;
    private UsersAPIAdapter uapiaValidK;
    private UserInfoDTO uidtoEmptyValues;
    private UserInfoDTO uidtoNull;
    private UserInfoDTO uidtoNullValues;
    private UserInfoDTO uidtoValid1;
    private UserInfoDTO uidtoValid2;
    private String app_context1;
    private String app_context2;

//    private static final String VALID_APP_KEY = "IBD0DEHBDID62EB1EAZBEoA95E3cB5BD5135d01F0FqE6eDDoD4yDEX05RFEF19q9BY04KBE03A919hAFM06";
    private static final String VALID_APP_KEY = "qwertyuiopasdfghjkl";
    private static final String INVALID_APP_KEY = "xpto";
    private static final String LOG_FORMAT = "expResult=%s «««»»» result=%s%n";
    private static final String UUID_REGEX = "/^[0-9a-f]{8}-[0-9a-f]{4}-[0-5][0-9a-f]{3}-[089ab][0-9a-f]{3}-[0-9a-f]{12}$/i";
    private static final String LINE_SEPARATOR = "*******************************************************";
    private static final String METHOD_NAME_FORMAT = ("%n%s%n%s%n%s");
    private static final Logger logger = Logger.getLogger(UsersAPIAdapterTest.class.getName());

    public UsersAPIAdapterTest() {
        uapiaInvalidK = new UsersAPIAdapter(INVALID_APP_KEY);
        uapiaValidK = new UsersAPIAdapter(VALID_APP_KEY);

        uidtoNull = null;
        uidtoNullValues = new UserInfoDTO();
        uidtoEmptyValues = new UserInfoDTO();
        uidtoValid1 = new UserInfoDTO();
        uidtoValid2 = new UserInfoDTO();

        uidtoNullValues.setApp_context(null);
        uidtoNullValues.setEmail(null);
        uidtoNullValues.setLastHttpResponse(null);
        uidtoNullValues.setLastHttpResponseCode(null);
        uidtoNullValues.setLogindate(null);
        uidtoNullValues.setNifOrganizacao(null);
        uidtoNullValues.setOrganizacao(null);
        uidtoNullValues.setPassword(null);
        uidtoNullValues.setRolenames(null);
        uidtoNullValues.setSession(null);
        uidtoNullValues.setUsername(null);

        uidtoEmptyValues.setApp_context("");
        uidtoEmptyValues.setEmail("");
        uidtoEmptyValues.setLastHttpResponse("");
        uidtoEmptyValues.setLastHttpResponseCode("");
        uidtoEmptyValues.setLogindate("");
        uidtoEmptyValues.setNifOrganizacao("");
        uidtoEmptyValues.setOrganizacao(null);
        uidtoEmptyValues.setPassword("");
        uidtoEmptyValues.setRolenames("");
        uidtoEmptyValues.setSession("");
        uidtoEmptyValues.setUsername("");

        uidtoValid1.setApp_context(null);
        uidtoValid1.setEmail("testedanieljrWITHROLE9@mycompany.com");
        uidtoValid1.setLastHttpResponse(null);
        uidtoValid1.setLastHttpResponseCode(null);
        uidtoValid1.setLogindate(null);
        uidtoValid1.setNifOrganizacao("000000009");
        uidtoValid1.setOrganizacao(new OrganizacaoDTO());
        uidtoValid1.setPassword("testedanieljrWITHROLE9");
        uidtoValid1.setRolenames("GESTOR,COLABORADOR");
        uidtoValid1.setSession(null);
        uidtoValid1.setUsername("testedanieljrWITHROLE9");

        uidtoValid2.setApp_context(null);
        uidtoValid2.setEmail("gestor9@gestor.org");
        uidtoValid2.setLastHttpResponse(null);
        uidtoValid2.setLastHttpResponseCode(null);
        uidtoValid2.setLogindate(null);
        uidtoValid2.setNifOrganizacao("000000009");
        uidtoValid2.setOrganizacao(new OrganizacaoDTO());
        uidtoValid2.setPassword("Rozf0Ri31Bc@7fZL");
        uidtoValid2.setRolenames("GESTOR,COLABORADOR");
        uidtoValid2.setSession(null);
        uidtoValid2.setUsername("gestor9@gestor.org");

        uapiaValidK.getNewAppContext(uidtoNullValues);
        app_context1 = uidtoNullValues.getApp_context();
        uapiaValidK.getNewAppContext(uidtoNullValues);
        app_context2 = uidtoNullValues.getApp_context();
        uidtoNullValues.setApp_context(null);
    }

    @Test
    public void testGetNewAppContextCorrectAppKey() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        logger.log(Level.WARNING, String.format(METHOD_NAME_FORMAT, LINE_SEPARATOR, methodName, LINE_SEPARATOR));

        UserInfoDTO u1DTO = null;
        UserInfoDTO u2DTO = null;
        UsersAPIAdapter instance = null;

        u1DTO = new UserInfoDTO();
        u2DTO = new UserInfoDTO();
        instance = new UsersAPIAdapter(VALID_APP_KEY);

        instance.getNewAppContext(u1DTO);
        String instanceContext = u1DTO.getApp_context();
        uapiaValidK.getNewAppContext(u2DTO);
        String uapiaContext = u2DTO.getApp_context();

        logger.log(Level.INFO, logString(instanceContext, uapiaContext));
        assertEquals(u1DTO.getApp_context().matches(UUID_REGEX), u2DTO.getApp_context().matches(UUID_REGEX));

    }

    @Test
    public void testGetNewAppContextIncorrectAppKey() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        logger.log(Level.WARNING, String.format(METHOD_NAME_FORMAT, LINE_SEPARATOR, methodName, LINE_SEPARATOR));

        UserInfoDTO u1DTO = null;
        UserInfoDTO u2DTO = null;
        final UserInfoDTO u3DTO = new UserInfoDTO();
        UsersAPIAdapter instance;

        u1DTO = new UserInfoDTO();
        u2DTO = new UserInfoDTO();

        final UsersAPIAdapter instance2 = new UsersAPIAdapter(INVALID_APP_KEY);
        logger.log(Level.INFO, instance2.APP_KEY);

        LoginServerException lse = assertThrows(LoginServerException.class, () -> instance2.getNewAppContext(u3DTO));
        String expErrMsg1 = "HTTP response code: 401";
        String expErrMsg2 = "Server returned HTTP response code: 500";

        String errMsg = u3DTO.getLastHttpResponse();
        errMsg = lse.getMessage();

        boolean checkFrag1 = errMsg.contains(expErrMsg1);
        boolean checkFrag2 = errMsg.contains(expErrMsg2);
        boolean checkFrags = checkFrag1 || checkFrag2;

        logger.log(Level.INFO, u3DTO.getLastHttpResponseCode() + " - " + u3DTO.getLastHttpResponse());

        logger.log(Level.INFO, String.format("Response Code: %s", u3DTO.getLastHttpResponseCode()));
        logger.log(Level.INFO, String.format("Response Body: %s", u3DTO.getLastHttpResponse()));

        logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expErrMsg1, checkFrag1));
        logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expErrMsg2, checkFrag2));
        logger.log(Level.INFO, String.format("CheckFrags? %b.", checkFrags));

        assertTrue(checkFrags);

    }

    /**
     * Test of login method, of class UsersAPIAdapter.
     */
    @Test
    public void testLoginBemSucedidoSemTentativaDeLoginPrevio() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        logger.log(Level.WARNING, String.format(METHOD_NAME_FORMAT, LINE_SEPARATOR, methodName, LINE_SEPARATOR));

        try {
            String expResCode = "200";
            String expFragment1 = "user_id";
            String expFragment2 = uidtoValid1.getEmail();
            String expFragment3 = "login";
            String expFragment4 = "true";

            uidtoValid1.setApp_context(app_context1);
            logger.log(Level.INFO, String.format("BEFORE LOGIN: app_context1=%s «««»»» uidtoValid1.getAppContext()=%s", app_context1, uidtoValid1.getApp_context()));
            uapiaValidK.login(uidtoValid1);
            logger.log(Level.INFO, String.format(" AFTER LOGIN: app_context1=%s «««»»» uidtoValid1.getAppContext()=%s", app_context1, uidtoValid1.getApp_context()));

            String fullString = uidtoValid1.getLastHttpResponse();
//            boolean checkFrag1 = fullString.contains(expFragment1);
//            boolean checkFrag2 = fullString.contains(expFragment2);
//            boolean checkFrag3 = fullString.contains(expFragment3);
//            boolean checkFrag4 = fullString.contains(expFragment4);

            logger.log(Level.INFO, String.format("Response Code: %s", uidtoValid1.getLastHttpResponseCode()));
            logger.log(Level.INFO, String.format("Response Body: %s", uidtoValid1.getLastHttpResponse()));
//            logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment1, checkFrag1));
//            logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment2, checkFrag2));
//            logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment3, checkFrag3));
//            logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment4, checkFrag4));

            assertEquals(expResCode, uidtoValid1.getLastHttpResponseCode());
//            assertTrue(checkFrag1);
//            assertTrue(checkFrag2);
//            assertTrue(checkFrag3);
//            assertTrue(checkFrag4);

        } finally {
            uapiaValidK.logout(uidtoValid1);
        }
    }

    @Test
    public void testLoginMalSucedidoContextoInvalido() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        logger.log(Level.WARNING, String.format(METHOD_NAME_FORMAT, LINE_SEPARATOR, methodName, LINE_SEPARATOR));

        try {
            String expResCode = "500";
            String expFragment1 = "Invalid context";
            String expFragment2 = "Contexto inválido";

            uidtoValid1.setApp_context("xxx"); // CONTEXTO INVÁLIDO
            UsersAPIException assertThrows = assertThrows(UsersAPIException.class, () -> uapiaValidK.login(uidtoValid1));
            logger.log(Level.INFO, String.format("app_context1=%s «««»»» uidtoValid1.getAppContext()=%s", app_context1, uidtoValid1.getApp_context()));

            String errMsg = assertThrows.getMessage();
            logger.log(Level.INFO, String.format("errMsg=%s", errMsg));

            boolean checkFrag1 = errMsg.contains(expFragment1);
            boolean checkFrag2 = errMsg.contains(expFragment2);

            logger.log(Level.INFO, String.format("Response Code: %s", uidtoValid1.getLastHttpResponseCode()));
            logger.log(Level.INFO, String.format("Response Body: %s", uidtoValid1.getLastHttpResponse()));
            logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment1, checkFrag1));
            logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment2, checkFrag2));

            assertEquals(expResCode, uidtoValid1.getLastHttpResponseCode());
            assertTrue(checkFrag1 || checkFrag2);
        } finally {
            uapiaValidK.logout(uidtoValid1);
        }
    }

    @Test
    public void testLoginMalSucedidoPasswordIncorreta() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        logger.log(Level.WARNING, String.format(METHOD_NAME_FORMAT, LINE_SEPARATOR, methodName, LINE_SEPARATOR));

        try {
            String expResCode1 = "500";
            String expFragment1 = "Invalid credentials";
            String expFragment2 = "Utilizador e password inválidos";

            uidtoValid1.setPassword("xxx"); // PASSSWORD INCORRETA
            UsersAPIException assertThrows = assertThrows(UsersAPIException.class, () -> uapiaValidK.login(uidtoValid1));
            logger.log(Level.INFO, String.format("app_context1=%s «««»»» uidtoValid1.getAppContext()=%s", app_context1, uidtoValid1.getApp_context()));

            String errMsg = assertThrows.getMessage();
            logger.log(Level.INFO, String.format("errMsg=%s", errMsg));

            boolean checkFrag1 = errMsg.contains(expFragment1);
            boolean checkFrag2 = errMsg.contains(expFragment2);

            logger.log(Level.INFO, String.format("Response Code: %s", uidtoValid1.getLastHttpResponseCode()));
            logger.log(Level.INFO, String.format("Response Body: %s", uidtoValid1.getLastHttpResponse()));
            logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment1, checkFrag1));
            logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment2, checkFrag2));

            assertEquals(expResCode1, uidtoValid1.getLastHttpResponseCode());
            assertTrue(checkFrag1 || checkFrag2);
        } finally {
            uapiaValidK.logout(uidtoValid1);
        }
    }

    @Test
    public void testLoginMalSucedidoNomeDeUtilizadorInexistente() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        logger.log(Level.WARNING, String.format(METHOD_NAME_FORMAT, LINE_SEPARATOR, methodName, LINE_SEPARATOR));

        try {
            String expResCode1 = "500";
            String expResCode2 = "400";
            String expFragment1 = "Invalid login";
            String expFragment2 = "Utilizador e password inválidos";

            uidtoValid1.setEmail("xxx"); // setEmail INCORRETA
            uidtoValid1.setUsername("xxx"); // setUsername INCORRETA
            UsersAPIException assertThrows = assertThrows(UsersAPIException.class, () -> uapiaValidK.login(uidtoValid1));
            logger.log(Level.INFO, String.format("app_context1=%s «««»»» uidtoValid1.getAppContext()=%s", app_context1, uidtoValid1.getApp_context()));

            String errMsg = assertThrows.getMessage();
            logger.log(Level.INFO, String.format("errMsg=%s", errMsg));
            errMsg = uidtoValid1.getLastHttpResponseCode() + " - " + uidtoValid1.getLastHttpResponse();
            logger.log(Level.INFO, String.format("errMsg=%s", errMsg));

            boolean checkFrag1 = errMsg.contains(expFragment1);
            boolean checkFrag2 = errMsg.contains(expFragment2);
            boolean checkResCode = errMsg.contains(expResCode1) || errMsg.contains(expResCode2);

            logger.log(Level.INFO, String.format("Response Code: %s", uidtoValid1.getLastHttpResponseCode()));
            logger.log(Level.INFO, String.format("Response Body: %s", uidtoValid1.getLastHttpResponse()));
            logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment1, checkFrag1));
            logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment2, checkFrag2));
            logger.log(Level.INFO, String.format("checkResCode? %b.", checkResCode));

            assertTrue(checkResCode);
            assertTrue(checkFrag1 || checkFrag2);
        } finally {
            uapiaValidK.logout(uidtoValid1);
        }
    }

    @Test
    public void testLoginMalSucedidoNomeDeUtilizadorEPasswordEmBranco() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        logger.log(Level.WARNING, String.format(METHOD_NAME_FORMAT, LINE_SEPARATOR, methodName, LINE_SEPARATOR));

        try {
            String expResCode1 = "500";
            String expResCode2 = "400";
            String expFragment1 = "Invalid login";
            String expFragment2 = "O campo username está vazio";

            uidtoValid1.setPassword(""); // pass INCORRETA
            uidtoValid1.setEmail(""); // email INCORRETA
            uidtoValid1.setUsername(""); // username INCORRETA
            UsersAPIException assertThrows = assertThrows(UsersAPIException.class, () -> uapiaValidK.login(uidtoValid1));
            logger.log(Level.INFO, String.format("app_context1=%s «««»»» uidtoValid1.getAppContext()=%s", app_context1, uidtoValid1.getApp_context()));

            String errMsg = assertThrows.getMessage();
            logger.log(Level.INFO, String.format("assertThrows: errMsg=%s", errMsg));
            errMsg = uidtoValid1.getLastHttpResponseCode() + " - " + uidtoValid1.getLastHttpResponse();
            logger.log(Level.INFO, String.format("uidtoValid1.get...: errMsg=%s", errMsg));

            boolean checkFrag1 = errMsg.contains(expFragment1);
            boolean checkFrag2 = errMsg.contains(expFragment2);
            boolean checkResultCode = uidtoValid1.getLastHttpResponseCode().contains(expResCode1)
                    || uidtoValid1.getLastHttpResponseCode().contains(expResCode2);

            logger.log(Level.INFO, String.format("Response Code: %s", uidtoValid1.getLastHttpResponseCode()));
            logger.log(Level.INFO, String.format("Response Body: %s", uidtoValid1.getLastHttpResponse()));
            logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment1, checkFrag1));
            logger.log(Level.INFO, String.format("checkResultCode? %b.", checkResultCode));

            assertTrue(checkResultCode);
            assertTrue(checkFrag1 || checkFrag2);
        } finally {
            uapiaValidK.logout(uidtoValid1);
        }
    }

    @Test
    public void testLoginMalSucedidoUtilizadorJaLogado() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        logger.log(Level.WARNING, String.format(METHOD_NAME_FORMAT, LINE_SEPARATOR, methodName, LINE_SEPARATOR));

        try {
            String expResCode = "500";
            String expFragment1 = "You're already logged in";
            String expFragment2 = "Login já se encontra efetuado";

            uapiaValidK.login(uidtoValid1);
            UsersAPIException assertThrows = assertThrows(UsersAPIException.class, () -> uapiaValidK.login(uidtoValid1));
            logger.log(Level.INFO, String.format("»»» uidtoValid1.getAppContext()=%s", uidtoValid1.getApp_context()));

            String errMsg = assertThrows.getMessage();
            logger.log(Level.INFO, String.format("errMsg=%s", errMsg));

            boolean checkFrag1 = errMsg.contains(expFragment1);
            boolean checkFrag2 = errMsg.contains(expFragment2);

            logger.log(Level.INFO, String.format("Response Code: %s", uidtoValid1.getLastHttpResponseCode()));
            logger.log(Level.INFO, String.format("Response Body: %s", uidtoValid1.getLastHttpResponse()));
            logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment1, checkFrag1));
            logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment2, checkFrag2));

            assertEquals(expResCode, uidtoValid1.getLastHttpResponseCode());
            assertTrue(checkFrag1 || checkFrag2);
        } finally {
            uapiaValidK.logout(uidtoValid1);
        }
    }

    @Test
    public void testLogoutSemLogin() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        logger.log(Level.WARNING, String.format(METHOD_NAME_FORMAT, LINE_SEPARATOR, methodName, LINE_SEPARATOR));

        final UserInfoDTO u1DTO = new UserInfoDTO();
        UsersAPIAdapter instance = null;
        instance = new UsersAPIAdapter(VALID_APP_KEY);
        instance.getNewAppContext(u1DTO);
        String instanceContext = u1DTO.getApp_context();

        uapiaValidK.logout(u1DTO);
        logger.log(Level.INFO, String.format("»»» u1DTO.getAppContext()=%s", u1DTO.getApp_context()));

        String expResCode = "401";
        String expFragment1 = "Invalid context";
        String expFragment2 = "Não existe sessão válida para este contexto";
        String errMsg = u1DTO.getLastHttpResponse();
        boolean checkFrag1 = errMsg.contains(expFragment1);
        boolean checkFrag2 = errMsg.contains(expFragment2);

        logger.log(Level.INFO, String.format("Response Code: %s", u1DTO.getLastHttpResponseCode()));
        logger.log(Level.INFO, String.format("Response Body: %s", u1DTO.getLastHttpResponse()));
        logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment1, checkFrag1));
        logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment2, checkFrag2));
        assertEquals(expResCode, u1DTO.getLastHttpResponseCode());
        assertTrue(checkFrag1 || checkFrag2);
    }

    @Disabled @Test
    public void testLogoutComLogin() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        logger.log(Level.WARNING, String.format(METHOD_NAME_FORMAT, LINE_SEPARATOR, methodName, LINE_SEPARATOR));

        UsersAPIAdapter instance = null;
        instance = new UsersAPIAdapter(VALID_APP_KEY);
        instance.login(uidtoValid1);

        uapiaValidK.logout(uidtoValid1);
        logger.log(Level.INFO, String.format("»»» u1DTO.getAppContext()=%s", uidtoValid1.getApp_context()));

        String expResCode = "200";
        String expFragment1 = uidtoValid1.getEmail();
        String expFragment2 = "true";
        String errMsg = uidtoValid1.getLastHttpResponse();
        boolean checkFrag1 = errMsg.contains(expFragment1);
        boolean checkFrag2 = errMsg.contains(expFragment2);

        logger.log(Level.INFO, String.format("Response Code: %s", uidtoValid1.getLastHttpResponseCode()));
        logger.log(Level.INFO, String.format("Response Body: %s", uidtoValid1.getLastHttpResponse()));
        logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment1, checkFrag1));
        logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment2, checkFrag2));
        assertEquals(expResCode, uidtoValid1.getLastHttpResponseCode());
        assertTrue(checkFrag1);
        assertTrue(checkFrag2);
    }

    @Test
    public void testLogoutComLoginSemVerificacaoStringRespostas() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        logger.log(Level.WARNING, String.format(METHOD_NAME_FORMAT, LINE_SEPARATOR, methodName, LINE_SEPARATOR));

        UsersAPIAdapter instance = null;
        instance = new UsersAPIAdapter(VALID_APP_KEY);
        instance.login(uidtoValid1);

        uapiaValidK.logout(uidtoValid1);
        logger.log(Level.INFO, String.format("»»» u1DTO.getAppContext()=%s", uidtoValid1.getApp_context()));

        String expResCode = "200";
        String errMsg = uidtoValid1.getLastHttpResponse();

        logger.log(Level.INFO, String.format("Response Code: %s", uidtoValid1.getLastHttpResponseCode()));
        logger.log(Level.INFO, String.format("Response Body: %s", uidtoValid1.getLastHttpResponse()));
        assertEquals(expResCode, uidtoValid1.getLastHttpResponseCode());
    }

    @Test
    public void testLogoutComAppContextVazia() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        logger.log(Level.WARNING, String.format(METHOD_NAME_FORMAT, LINE_SEPARATOR, methodName, LINE_SEPARATOR));

        UsersAPIAdapter instance = null;
        instance = new UsersAPIAdapter(VALID_APP_KEY);

        uapiaValidK.logout(uidtoEmptyValues);
        logger.log(Level.INFO, String.format("»»» u1DTO.getAppContext()=%s", uidtoEmptyValues.getApp_context()));

        String expResCode = "401";
        String expFragment1 = "Invalid context";
        String expFragment2 = "Contexto inválido";
        String errMsg = uidtoEmptyValues.getLastHttpResponse();
        boolean checkFrag1 = errMsg.contains(expFragment1);
        boolean checkFrag2 = errMsg.contains(expFragment2);

        logger.log(Level.INFO, String.format("Response Code: %s", uidtoEmptyValues.getLastHttpResponseCode()));
        logger.log(Level.INFO, String.format("Response Body: %s", uidtoEmptyValues.getLastHttpResponse()));
        logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment1, checkFrag1));
        assertEquals(expResCode, uidtoEmptyValues.getLastHttpResponseCode());
        assertTrue(checkFrag1 || checkFrag2);
    }

    @Disabled @Test
    public void testCreateUserWithRolesBemSucedido() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        logger.log(Level.WARNING, String.format(METHOD_NAME_FORMAT, LINE_SEPARATOR, methodName, LINE_SEPARATOR));

        UsersAPIAdapter instance = null;
        instance = new UsersAPIAdapter(VALID_APP_KEY);

        UserInfoDTO u = new UserInfoDTO();
        u.setEmail("asd03@asd.asd");
        u.setPassword("asd03@asd.asd");
        u.setUsername("asd03@asd.asd");
        instance.getNewAppContext(u);

        uapiaValidK.registerUserWithRoles(u);

        String expResCode = "200";
        String expFragment1 = "username";
        String expFragment2 = u.getEmail();
        String expFragment3 = "registered";
        String expFragment4 = "true";

        String errMsg = u.getLastHttpResponse();
        boolean checkFrag1 = errMsg.contains(expFragment1);
        boolean checkFrag2 = errMsg.contains(expFragment2);
        boolean checkFrag3 = errMsg.contains(expFragment3);
        boolean checkFrag4 = errMsg.contains(expFragment4);

        logger.log(Level.INFO, String.format("Response Code: %s", u.getLastHttpResponseCode()));
        logger.log(Level.INFO, String.format("Response Body: %s", u.getLastHttpResponse()));
        logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment1, checkFrag1));
        logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment2, checkFrag2));
        logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment3, checkFrag3));
        logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment4, checkFrag4));
        assertEquals(expResCode, u.getLastHttpResponseCode());
        assertTrue(checkFrag1);
        assertTrue(checkFrag2);
        assertTrue(checkFrag3);
        assertTrue(checkFrag4);
    }

    @Test
    public void testCreateUserWithRolesMalSucedidoUsernameVazio() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        logger.log(Level.WARNING, String.format(METHOD_NAME_FORMAT, LINE_SEPARATOR, methodName, LINE_SEPARATOR));

        UsersAPIAdapter instance = null;
        instance = new UsersAPIAdapter(VALID_APP_KEY);

        UserInfoDTO u = new UserInfoDTO();
        u.setEmail("asd03@asd.asd");
        u.setPassword("asd03@asd.asd");
        u.setUsername("");
        instance.getNewAppContext(u);

        try {
            uapiaValidK.registerUserWithRoles(u);
        } catch (UsersAPIException e) {
        }

        String expResCode1 = "401";
        String expResCode2 = "400";
        String expFragment1 = "error";
        String expFragment2 = "Username cannot be empty";
        String expFragment3 = "O campo username está vazio";

        String errMsg = u.getLastHttpResponse();
        boolean checkFrag1 = errMsg.contains(expFragment1);
        boolean checkFrag2 = errMsg.contains(expFragment2);
        boolean checkFrag3 = errMsg.contains(expFragment3);
        boolean checkResponseCode = u.getLastHttpResponseCode().equals(expResCode1) || u.getLastHttpResponseCode().equals(expResCode2);

        logger.log(Level.INFO, String.format("Response Code: %s", u.getLastHttpResponseCode()));
        logger.log(Level.INFO, String.format("Response Body: %s", u.getLastHttpResponse()));
        logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment1, checkFrag1));
        logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment2, checkFrag2));

        assertTrue(checkResponseCode);
        assertTrue(checkFrag1);
        assertTrue(checkFrag2 || checkFrag3);
    }

    @Test
    public void testCreateUserWithRolesMalSucedidoPasswordVazio() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        logger.log(Level.WARNING, String.format(METHOD_NAME_FORMAT, LINE_SEPARATOR, methodName, LINE_SEPARATOR));

        UsersAPIAdapter instance = null;
        instance = new UsersAPIAdapter(VALID_APP_KEY);

        UserInfoDTO u = new UserInfoDTO();
        u.setEmail("asd03@asd.asd");
        u.setPassword("");
        u.setUsername("asd03@asd.asd");
        instance.getNewAppContext(u);

        try {
            uapiaValidK.registerUserWithRoles(u);
        } catch (UsersAPIException e) {
        }

        String expResCode1 = "401";
        String expResCode2 = "400";
        String expFragment1 = "error";
        String expFragment2 = "Password cannot be empty";
        String expFragment3 = "O campo password está vazio";

        String errMsgCode = u.getLastHttpResponseCode();
        String errMsg = u.getLastHttpResponse();
        boolean checkFrag1 = errMsg.contains(expFragment1);
        boolean checkFrag2 = errMsg.contains(expFragment2);
        boolean checkFrag3 = errMsg.contains(expFragment3);
        boolean checkResultCode = errMsgCode.contains(expResCode1) || errMsgCode.contains(expResCode2);

        logger.log(Level.INFO, String.format("Response Code: %s", u.getLastHttpResponseCode()));
        logger.log(Level.INFO, String.format("Response Body: %s", u.getLastHttpResponse()));
        logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment1, checkFrag1));
        logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment2, checkFrag2));
        logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment3, checkFrag3));
        logger.log(Level.INFO, String.format("CheckResultCode? %b.", checkFrag2));

        assertTrue(checkResultCode);
        assertTrue(checkFrag1);
        assertTrue(checkFrag2 || checkFrag3);
    }

    @Test
    public void testCreateUserWithRolesMalSucedidoEmailVazio() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        logger.log(Level.WARNING, String.format(METHOD_NAME_FORMAT, LINE_SEPARATOR, methodName, LINE_SEPARATOR));

        UsersAPIAdapter instance = null;
        instance = new UsersAPIAdapter(VALID_APP_KEY);

        UserInfoDTO u = new UserInfoDTO();
        u.setEmail("");
        u.setPassword("asd03@asd.asd");
        u.setUsername("asd03@asd.asd");
        instance.getNewAppContext(u);

        try {
            uapiaValidK.registerUserWithRoles(u);
        } catch (UsersAPIException e) {
        }

        String expResCode1 = "401";
        String expResCode2 = "400";
        String expFragment1 = "error";
        String expFragment2 = "Email cannot be empty";
        String expFragment3 = "O campo email está vazio";

        String errMsg = u.getLastHttpResponse();
        String errMsgCode = u.getLastHttpResponseCode();
        boolean checkFrag1 = errMsg.contains(expFragment1);
        boolean checkFrag2 = errMsg.contains(expFragment2);
        boolean checkFrag3 = errMsg.contains(expFragment3);
        boolean checkResultCode = errMsgCode.equals(expResCode1) || errMsgCode.equals(expResCode2);

        logger.log(Level.INFO, String.format("Response Code: %s", u.getLastHttpResponseCode()));
        logger.log(Level.INFO, String.format("Response Body: %s", u.getLastHttpResponse()));
        logger.log(Level.INFO, String.format("Fragment: <%s> is contained? <%b>.", expFragment1, checkFrag1));
        logger.log(Level.INFO, String.format("Fragment: <%s> is contained? <%b>.", expFragment2, checkFrag2));
        logger.log(Level.INFO, String.format("Fragment: <%s> is contained? <%b>.", expFragment3, checkFrag3));
        logger.log(Level.INFO, String.format("ResultCode: is one of the expected? <%b>.", checkResultCode));
        assertTrue(checkResultCode);
        assertTrue(checkFrag1);
        assertTrue(checkFrag2 || checkFrag3);
    }

    @Test
    public void testCreateUserWithRolesMalSucedidoUserJaRegistado() {

        String methodName = new Exception().getStackTrace()[0].getMethodName();
        logger.log(Level.WARNING, String.format(METHOD_NAME_FORMAT, LINE_SEPARATOR, methodName, LINE_SEPARATOR));

        UsersAPIAdapter instance = null;
        instance = new UsersAPIAdapter(VALID_APP_KEY);

        UserInfoDTO u = uidtoValid1;
        instance.getNewAppContext(u);

        try {
            uapiaValidK.registerUserWithRoles(u);
        } catch (UsersAPIException e) {
        }

        String expResCode1 = "401";
        String expResCode2 = "400";
        String expFragment1 = "error";
        String expFragment2 = "User already exists";
        String expFragment3 = "Email já existe.";

        String errMsg = u.getLastHttpResponse();
        String errMsgCode = u.getLastHttpResponseCode();
        boolean checkFrag1 = errMsg.contains(expFragment1);
        boolean checkFrag2 = errMsg.contains(expFragment2);
        boolean checkFrag3 = errMsg.contains(expFragment3);
        boolean checkResultCode = errMsgCode.contains(expResCode1) || errMsgCode.contains(expResCode2);

        logger.log(Level.INFO, String.format("Response Code: %s", u.getLastHttpResponseCode()));
        logger.log(Level.INFO, String.format("Response Body: %s", u.getLastHttpResponse()));
        logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment1, checkFrag1));
        logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment2, checkFrag2));
        logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment3, checkFrag3));
        logger.log(Level.INFO, String.format("checkResultCode? %b.", checkFrag3));
        assertTrue(checkResultCode);
        assertTrue(checkFrag1);
        assertTrue(checkFrag2 || checkFrag3);
    }

    @Test
    public void testGetSessionUserLogado() {

        String methodName = new Exception().getStackTrace()[0].getMethodName();
        logger.log(Level.WARNING, String.format(METHOD_NAME_FORMAT, LINE_SEPARATOR, methodName, LINE_SEPARATOR));

        UsersAPIAdapter instance = null;
        instance = new UsersAPIAdapter(VALID_APP_KEY);
        UserInfoDTO u = uidtoValid1;
        try {
            instance.login(u);
            uapiaValidK.getSession(u);

            String expResCode = "200";
            String expFragment1 = "username";
            String expFragment2 = u.getUsername();
            String expFragment3 = "email";
            String expFragment4 = u.getEmail();
            String expFragment5 = "logindate";
            String expFragment6 = "rolenames";

            String errMsg = u.getLastHttpResponse();
            boolean checkFrag1 = errMsg.contains(expFragment1);
            boolean checkFrag2 = errMsg.contains(expFragment2);
            boolean checkFrag3 = errMsg.contains(expFragment3);
            boolean checkFrag4 = errMsg.contains(expFragment4);
            boolean checkFrag5 = errMsg.contains(expFragment5);
            boolean checkFrag6 = errMsg.contains(expFragment6);

            logger.log(Level.INFO, String.format("Response Code: %s", u.getLastHttpResponseCode()));
            logger.log(Level.INFO, String.format("Response Body: %s", u.getLastHttpResponse()));
            logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment1, checkFrag1));
            logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment2, checkFrag2));
            logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment3, checkFrag3));
            logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment4, checkFrag4));
            logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment5, checkFrag5));
            logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment6, checkFrag6));
            assertEquals(expResCode, u.getLastHttpResponseCode());
            assertTrue(checkFrag1);
            assertTrue(checkFrag2);
            assertTrue(checkFrag3);
            assertTrue(checkFrag4);
            assertTrue(checkFrag5);
            assertTrue(checkFrag6);
        } finally {
            instance.logout(u);
        }
    }

    @Test
    public void testGetSessionUserNaoLogado() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        logger.log(Level.WARNING, String.format(METHOD_NAME_FORMAT, LINE_SEPARATOR, methodName, LINE_SEPARATOR));

        UsersAPIAdapter instance = null;
        instance = new UsersAPIAdapter(VALID_APP_KEY);
        UserInfoDTO u = uidtoValid1;
        try {
            instance.getNewAppContext(u);
            instance.getSession(u);
        } catch (Exception e) {
        }

        String expResCode1 = "401";
        String expResCode2 = "400";
        String expFragment1 = "You're not logged in";
        String expFragment2 = "Não existe sessão válida para este contexto";

        String errMsg = u.getLastHttpResponse();
        String errMsgCode = u.getLastHttpResponseCode();
        boolean checkFrag1 = errMsg.contains(expFragment1);
        boolean checkFrag2 = errMsg.contains(expFragment2);
        boolean checkResultCode1 = errMsgCode.contains(expResCode1);
        boolean checkResultCode2 = errMsgCode.contains(expResCode2);
        boolean checkResultCode = checkResultCode1 || checkResultCode2;

        logger.log(Level.INFO, String.format("Response Code: %s", u.getLastHttpResponseCode()));
        logger.log(Level.INFO, String.format("Response Body: %s", u.getLastHttpResponse()));
        logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment1, checkFrag1));
        logger.log(Level.INFO, String.format("Fragment: %s is contained? %b.", expFragment2, checkFrag2));
        logger.log(Level.INFO, String.format("ResultCode1: %s? %b.", expResCode1, checkResultCode1));
        logger.log(Level.INFO, String.format("ResultCode2: %s? %b.", expResCode2, checkResultCode2));
        logger.log(Level.INFO, String.format("checkResultCode? %b.", checkResultCode));

        assertTrue(checkResultCode);
        assertTrue(checkFrag1 || checkFrag2);
    }

    private String logString(String expRes, String res) {
        return String.format(LOG_FORMAT, expRes, res);
    }

}
