import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler {

    // embedded mood
    // private static final String URL = "jdbc:h2:~/test";

    // server mood
    private static final String URL = "jdbc:h2:tcp://localhost/~/test";
    private static final String DRIVER = "org.h2.Driver";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123";

    private Connection connection;

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("driver not found");
        }
    }

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = openConnection();
        }
        return connection;
    }

    private Connection openConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("connection closed");
            }
        } catch (SQLException e) {
            System.out.println("connection close error");
        }
    }

    /*public Connection getConnection() {
        return connection;
    }*/
}
