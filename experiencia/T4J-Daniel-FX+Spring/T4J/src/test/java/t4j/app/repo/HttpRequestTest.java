/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.repo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import t4j.app.dto.UserInfoDTO;

/**
 * a
 *
 * @author user
 */
public class HttpRequestTest {

    HttpRequest hrGoogle;
    HttpRequest hrLocalHost;
    HttpRequest hrURLNull;
    Object obj = new Object();

    URL urlGoogle;
    URL urlLocalHost;
    URL urlNull;

    private static final String OUTPUT_STRING = "expResult=%s --- currResult=%s%n";
    private static final Logger logger = Logger.getLogger(HttpRequestTest.class.getName());


    public HttpRequestTest() {
        System.out.println("\n-------------------------------------------");

        try {
            urlGoogle = new URL("http://www.google.com");
            urlLocalHost = new URL("http://localhost");
            urlNull = null;

            hrGoogle = new HttpRequest(urlGoogle);
            hrLocalHost = new HttpRequest(urlLocalHost);
            hrURLNull = new HttpRequest(urlNull);

        } catch (MalformedURLException e) {
            logger.log(Level.INFO, e.getMessage());
        }


    }
    @Test
    public void testConnect_UserInfoDTO() {
        System.out.println("testConnect_UserInfoDTO");
        UserInfoDTO u = new UserInfoDTO();

        String resultString = "";
        String expResultString = "";
        String result = "0";
        Integer expResult = 0;



        hrLocalHost.connect(u);
        expResultString = hrLocalHost.getResponseBody();
        expResult = hrLocalHost.getResponseCode();
        resultString = u.getLastHttpResponse();
        result = u.getLastHttpResponseCode();
        assertEquals(expResult.toString(), result);
        logger.log(Level.INFO, String.format(OUTPUT_STRING, expResult, result));
        assertEquals(expResultString, resultString);
        logger.log(Level.INFO, String.format(OUTPUT_STRING, expResultString, resultString));

        hrGoogle.connect(u);
        expResultString = hrGoogle.getResponseBody();
        expResult = hrGoogle.getResponseCode();
        resultString = u.getLastHttpResponse();
        result = u.getLastHttpResponseCode();
        assertEquals(expResult.toString(), result);
        logger.log(Level.INFO, String.format(OUTPUT_STRING, expResult, result));
        assertEquals(expResultString, resultString);
        logger.log(Level.INFO, String.format(OUTPUT_STRING, expResultString, resultString));

        hrURLNull.connect(u);
        expResultString = hrURLNull.getResponseBody();
        expResult = hrURLNull.getResponseCode();
        resultString = u.getLastHttpResponse();
        result = u.getLastHttpResponseCode();
        assertEquals(expResult.toString(), result);
        logger.log(Level.INFO, String.format(OUTPUT_STRING, expResult, result));
        assertEquals(expResultString, resultString);
        logger.log(Level.INFO, String.format(OUTPUT_STRING, expResultString, resultString));

    }
    /**
     * Test of getMethod method, of class HttpRequest.
     */
    @Test
    public void testGetMethod() {
        System.out.println("getMethod");
        HttpMethod m1 = HttpMethod.GET;
        HttpMethod m2 = HttpMethod.POST;
        HttpMethod m3 = HttpMethod.DELETE;

        hrGoogle.setMethod(m1);
        assertEquals(m1, hrGoogle.getMethod());
        logger.log(Level.INFO, String.format(OUTPUT_STRING, m1, hrGoogle.getMethod()));

        hrGoogle.setMethod(m2);
        assertEquals(m2, hrGoogle.getMethod());
        logger.log(Level.INFO, String.format(OUTPUT_STRING, m2, hrGoogle.getMethod()));

        hrGoogle.setMethod(m3);
        assertEquals(m3, hrGoogle.getMethod());
        logger.log(Level.INFO, String.format(OUTPUT_STRING, m3, hrGoogle.getMethod()));

        hrGoogle.setMethod(null);
        assertEquals(null, hrGoogle.getMethod());
        logger.log(Level.INFO, String.format(OUTPUT_STRING, null, hrGoogle.getMethod()));
    }
    /**
     * Test of getPOSTBody method, of class HttpRequest.
     */

    /**
     * Test of getResponseBody method, of class HttpRequest.
     */
    @Test
    public void testGetResponseBody() {
        System.out.println("getResponseBody");

        String rb1 = "http://www.google.pt";
        String rb2 = "http://www.google.com.br";
        String emptyString = "";
        String nullString = null;

        hrGoogle.setGETResponse(rb1);
        assertEquals(rb1, hrGoogle.getResponseBody());
        logger.log(Level.INFO, String.format(OUTPUT_STRING, rb1, hrGoogle.getResponseBody()));

        hrGoogle.setGETResponse(rb2);
        assertEquals(rb2, hrGoogle.getResponseBody());
        logger.log(Level.INFO, String.format(OUTPUT_STRING, rb2, hrGoogle.getResponseBody()));

        hrGoogle.setGETResponse(emptyString);
        assertEquals(emptyString, hrGoogle.getResponseBody());
        logger.log(Level.INFO, String.format(OUTPUT_STRING, emptyString, hrGoogle.getResponseBody()));

        hrGoogle.setGETResponse(nullString);
        assertEquals(nullString, hrGoogle.getResponseBody());
        logger.log(Level.INFO, String.format(OUTPUT_STRING, nullString, hrGoogle.getResponseBody()));
    }

    /**
     * Test of getResponseCode method, of class HttpRequest.
     */
    @Test
    public void testGetResponseCode0FromGoogle_NoConnectionRequest() {
        /**
         * What is the unit under test (module, function, class, whatever)? Class HttpRequest
         * What should it do? Test all the funcionalities of that class also error handling.
         * What was the actual output?
         * What was the expected output?
         * How do you reproduce the failure?
         */
        System.out.println("testGetResponseCode0FromGoogle");
        HttpRequest instance = null;
        try {
            URL url = new URL("http://www.google.com");
            instance = new HttpRequest(url);
        } catch (MalformedURLException ex) {
            Logger.getLogger(HttpRequestTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        int expResultCode = 0;
        int resultCode = instance.getResponseCode();
        assertEquals(expResultCode, resultCode);
        Logger.getLogger(HttpRequestTest.class.getName()).log(Level.INFO, String.format(OUTPUT_STRING, expResultCode, resultCode));

        String expResultMessage = "";
        String resultMessage = instance.getResponseBody();
        assertEquals(expResultMessage, resultMessage);
        Logger.getLogger(HttpRequestTest.class.getName()).log(Level.INFO, String.format(OUTPUT_STRING, expResultMessage, resultMessage));
    }

    /**
     * Test of getResponseCode method, of class HttpRequest.
     */
    @Test
    public void testGetResponseCode200FromGoogle() {
        /**
         * What is the unit under test (module, function, class, whatever)? Class HttpRequest
         * What should it do? Test all the funcionalities of that class also error handling.
         * What was the actual output?
         * What was the expected output?
         * How do you reproduce the failure?
         */
        System.out.println("testGetResponseCode200FromGoogle");
        HttpRequest instance = null;
        try {
            URL url = new URL("http://www.google.com");
            instance = new HttpRequest(url);
            instance.connect();
        } catch (MalformedURLException ex) {
            Logger.getLogger(HttpRequestTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        int expResultCode = 200;
        int resultCode = instance.getResponseCode();
        assertEquals(expResultCode, resultCode);
        Logger.getLogger(HttpRequestTest.class.getName()).log(Level.INFO, String.format(OUTPUT_STRING, expResultCode, resultCode));

        String expResultMessage = "<!doctype html>";
        String resultMessage = instance.getResponseBody().substring(0, expResultMessage.length());
        assertEquals(expResultMessage, resultMessage);
        Logger.getLogger(HttpRequestTest.class.getName()).log(Level.INFO, String.format(OUTPUT_STRING, expResultMessage, resultMessage));
    }

    /**
     * Test of getResponseCode method, of class HttpRequest.
     */
    @Test
    public void testGetResponseCodeFromLocalHost_ConnectionRefused() {
        /**
         * What is the unit under test (module, function, class, whatever)? Class HttpRequest
         * What should it do? Test all the funcionalities of that class also error handling.
         * What was the actual output?
         * What was the expected output?
         * How do you reproduce the failure?
         */
        System.out.println("testGetUnknownResponseCodeFromLocalHost");
        HttpRequest instance = null;
        try {
            URL url = new URL("http://localhost");
            instance = new HttpRequest(url);
            instance.connect();
        } catch (MalformedURLException ex) {
            Logger.getLogger(HttpRequestTest.class.getName()).log(Level.SEVERE, null, ex);
        }
//        IOException assertThrows = assertThrows(IOException.class,(instance::connect));

        int expResultCode = 0;
        int resultCode = instance.getResponseCode();
        assertEquals(expResultCode, resultCode);
        Logger.getLogger(HttpRequestTest.class.getName()).log(Level.INFO, String.format(OUTPUT_STRING, expResultCode, resultCode));

        String expResultMessage = "Connection refused (Connection refused). address=http://localhost";
        String resultMessage = instance.getResponseBody();
        assertEquals(expResultMessage, resultMessage);
        Logger.getLogger(HttpRequestTest.class.getName()).log(Level.INFO, String.format(OUTPUT_STRING, expResultMessage, resultMessage));
    }


}
