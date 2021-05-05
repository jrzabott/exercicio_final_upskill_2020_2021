/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import t4j.app.dto.UserInfoDTO;
import t4j.app.repo.UsersAPI;
import static org.mockito.Mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import t4j.app.repo.UsersAPIAdapter;

/**
 *
 * @author user
 */
public class UsersServiceTest {

    private static final Logger logger = Logger.getLogger(UsersServiceTest.class.getName());
    public static final String LINE_SEPARATOR = "**********************************************";
    public static final String METHOD_NAME_FORMAT = "%n%s%n%s%n%s";

    public UsersServiceTest() {
    }

    /**
     * Test of addUtilizador method, of class UsersService.
     */
    @Test
    public void testAddUtilizador() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        logger.log(Level.WARNING, String.format(METHOD_NAME_FORMAT, LINE_SEPARATOR, methodName, LINE_SEPARATOR));

        UserInfoDTO u = new UserInfoDTO();
        UsersService instance = new UsersService();

        u.setEmail("mock@mock.pt");
        u.setUsername("mock@mock.pt");
        u.setPassword("mock@mock.pt");

        instance.uapi = mock(UsersAPI.class);
        when(instance.uapi.registerUser(u)).thenReturn(Boolean.TRUE);

        logger.log(Level.INFO, "u Before add: {0}", u);
        assertTrue(instance.addUtilizador(u));
        logger.log(Level.INFO, "u After add: {0} ", u);

    }

    /**
     * Test of getRoles method, of class UsersService.
     */
    @Test
    public void testGetRoles() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        logger.log(Level.WARNING, String.format(METHOD_NAME_FORMAT, LINE_SEPARATOR, methodName, LINE_SEPARATOR));

        UserInfoDTO u = new UserInfoDTO();
        UsersService instance = new UsersService();

        String expResult = "GESTOR, COLABORADOR";

        instance.uapi = mock(UsersAPI.class);
        doAnswer(invocation -> {
            ((UserInfoDTO) invocation.getArgument(0)).setRolenames(expResult);
            return expResult;
        }).when(instance.uapi).getRoles(u);

        logger.log(Level.INFO, "u Before getRolenames: {0}", u);
        instance.getRoles(u);
        logger.log(Level.INFO, "u After getRolenames: {0}", u);
        assertEquals(expResult, u.getRolenames());
    }

    /**
     * Test of getSession method, of class UsersService.
     */
    @Test
    public void testGetSession() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        logger.log(Level.WARNING, String.format(METHOD_NAME_FORMAT, LINE_SEPARATOR, methodName, LINE_SEPARATOR));

        UserInfoDTO u = new UserInfoDTO();
        UsersService instance = new UsersService();

        String expResult = "[{\"username\":\"rtivav@ydrbrnfnyh.com\",\"email\":\"rtivav@ydrbrnfnyh.com\",\"logindate\":\"2021-02-03T12:46:19.000Z\",\"rolenames\":\"Colaborador\"}]";

        instance.uapi = mock(UsersAPI.class);
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock iom) throws Throwable {
                Object[] args = iom.getArguments();
                ((UserInfoDTO) args[0]).setSession(expResult);
                return null;
            }
        }).when(instance.uapi).getSession(u);
        logger.log(Level.INFO, "u Before getSession: {0}", u);
        instance.getSession(u);
        logger.log(Level.INFO, "u After getSesion: {0}", u);
        assertEquals(expResult, u.getSession());
    }

    /**
     * Test of logout method, of class UsersService.
     */
    @Test
    public void testLogout() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        logger.log(Level.WARNING, String.format(METHOD_NAME_FORMAT, LINE_SEPARATOR, methodName, LINE_SEPARATOR));

        UserInfoDTO u = new UserInfoDTO();
        UsersService instance = new UsersService();

        instance.uapi = mock(UsersAPI.class);
        when(instance.uapi.logout(u)).thenReturn(Boolean.TRUE);
        boolean logout = instance.logout(u);
        logger.log(Level.INFO, "Logout True:");
        assertTrue(logout);

        when(instance.uapi.logout(u)).thenReturn(Boolean.FALSE);
        logout = instance.logout(u);
        logger.log(Level.INFO, "Logout False:");
        assertFalse(logout);
    }

    /**
     * Test of login method, of class UsersService.
     */
    @Test
    public void testLogin() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        logger.log(Level.WARNING, String.format(METHOD_NAME_FORMAT, LINE_SEPARATOR, methodName, LINE_SEPARATOR));

        UserInfoDTO u = new UserInfoDTO();
        u.setApp_context("app_context");
        u.setEmail("user@user.pt");
        u.setLastHttpResponse("responseBody");
        u.setLastHttpResponseCode("responseCode");
        u.setPassword("userPass");
        u.setRolenames("COLABORADOR");
        u.setUsername(u.getEmail());

        String expNifResult = "123123321";
        String expSessionString = "Session Info";

        UsersService instance = new UsersService();
        instance.uapi = mock(UsersAPI.class);
        instance.organizacoesService = mock(OrganizacoesService.class);

        doAnswer(inv -> {
            ((UserInfoDTO) inv.getArgument(0)).setNifOrganizacao("123123321");
            return null;}).when(instance.organizacoesService).setOrgInfoInSessionByUserEmail(u);
        doAnswer(i -> {
            ((UserInfoDTO) i.getArgument(0)).setSession(expSessionString);
            return null;}).when(instance.uapi).getSession(u);
        when(instance.uapi.login(u)).thenReturn(Boolean.TRUE);

        logger.log(Level.INFO, "u Before Login: {0}", u);
        instance.login(u);
        assertEquals(expNifResult, u.getNifOrganizacao());
        assertEquals(expSessionString, u.getSession());
        logger.log(Level.INFO, "u After Login: {0}", u);
    }


}
