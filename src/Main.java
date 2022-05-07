import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DBHandler dbHandler = new DBHandler();

        try (Connection connection = dbHandler.getConnection()) {

            TableCreator.createPersonnelTable(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
