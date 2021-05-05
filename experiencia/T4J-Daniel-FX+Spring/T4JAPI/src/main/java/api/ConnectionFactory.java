package api;

public class ConnectionFactory {

    private static ConnectionFactory cf;
    private DatabaseConnection c;

    public static ConnectionFactory getConnectionFactory() {
        if (cf == null) {
            cf = new ConnectionFactory();
        }
        return cf;
    }

    // Connection String: jdbc:oracle:thin:UPSKILL_BD_Turma2_03/qwerty123@vsrvbd1.dei.isep.ipp.pt:1521/pdborcl
    public DatabaseConnection getConnection() {
        if (c == null) {
            c = new DatabaseConnection(
                    "jdbc:oracle:thin:@vsrvbd1.dei.isep.ipp.pt:1521/pdborcl",
                    "UPSKILL_BD_Turma2_03",
                    "qwerty123");
        }
        return c;
    }
}
