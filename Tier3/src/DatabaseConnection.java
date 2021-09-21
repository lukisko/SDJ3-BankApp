import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

  public static Connection getConnection() throws SQLException {
    DriverManager.registerDriver(new org.postgresql.Driver());
    return DriverManager.getConnection( DatabaseCredentials.URL, DatabaseCredentials.NAME, DatabaseCredentials.PASSWORD);
  }
}
