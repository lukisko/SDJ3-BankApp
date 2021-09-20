import java.rmi.Naming;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler implements ITier3{

  public DatabaseHandler(){
    try {
      Naming.rebind( "rmi://localhost/T3", this );
    } catch( Exception ex ) {
      ex.printStackTrace();
    }
  }

  @Override public void setBalance(int customerID, double addAmount) throws
      SQLException
  {
    try (Connection connection = DatabaseConnection.getConnection()){
      PreparedStatement statement = connection.prepareStatement("update Account set amount = ? where customerID = ?");
      statement.setDouble(1, addAmount);
      statement.setInt(2, customerID);
      statement.executeUpdate();
    }
  }
}
