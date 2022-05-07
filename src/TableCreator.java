import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TableCreator {

    public static void createPersonnelTable(Connection conn) throws SQLException {
        dropTable(conn, "personnel");
        String query = """
                CREATE TABLE personnel (
                    ID INT PRIMARY KEY auto_increment,
                    owner varchar2(50),
                    balance number,
                    acc_number varchar2(16)
                )
                """;
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.execute();
    }

    private static void dropTable(Connection conn, String tableName) throws SQLException {
        String query = "drop table if exists " + tableName;
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.execute();
    }

}
