import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DBHandler dbHandler = new DBHandler();

        String query = """
                CREATE TABLE personnel (
                    ID INT PRIMARY KEY auto_increment,
                    owner varchar2(50),
                    balance number,
                    acc_number varchar2(16)
                )
                """;

        try (Connection connection = dbHandler.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
