/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 *
 * @author user
 */
public class ApiFunctionsTest {

    private static final Logger logger = Logger.getLogger(ApiFunctionsTest.class.getName());
    private static final String STRING_FORMAT = "expResult=%s »»» result=%s%n";

    public ApiFunctionsTest() {

    }


    @Disabled
    @Test
    public void test() {
        logger.log(Level.INFO, "testTest");

        ArrayList<ApiFunctions> functions = new ArrayList<>();
        functions.addAll(Arrays.asList(ApiFunctions.values()));

        ApiFunctions expResult = functions.get(0);
        ApiFunctions result = ApiFunctions.CONTEXT;

        assertEquals(functions.get(0), ApiFunctions.CONTEXT);
        log(expResult, result);
    }

    private void log(Object expResult, Object result){
        logger.log(Level.INFO, String.format(STRING_FORMAT, expResult.toString(), result.toString()));
    }

}
