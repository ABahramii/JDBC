import org.h2.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler {
    private static final String URL = "jdbc:h2:~/test2";
    private static final String DRIVER = "org.h2.Driver";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "123";

    private Connection conn;

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("driver not found");
        }
    }

    public void open() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("connection created");
            }
        } catch (SQLException e) {
            System.out.println("connection error");
        }
    }

    public void close() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("connection closed");
            }
        } catch (SQLException e) {
            System.out.println("connection error");
        }
    }

}
