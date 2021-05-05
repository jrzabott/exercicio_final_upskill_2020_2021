/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.repo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ConnectionFactory {

    private static ConnectionFactory cf;
    private DatabaseConnection c;

    public static ConnectionFactory getConnectionFactory() {
        if (cf == null) {
            cf = new ConnectionFactory();
        }
        return cf;
    }

    // Daniel Junior - 20210212 15:11 - info hard-coded.
    // Connection String: jdbc:oracle:thin:UPSKILL_BD_Turma2_12/Qwerty123@vsrvbd1.dei.isep.ipp.pt:1521/pdborcl
    public DatabaseConnection getConnection() {
        if (c == null) {
            c = new DatabaseConnection(
                    "jdbc:oracle:thin:@vsrvbd1.dei.isep.ipp.pt:1521/pdborcl",
                    "UPSKILL_BD_Turma2_12",
                    "Qwerty123");
        }
        return c;
    }

}
