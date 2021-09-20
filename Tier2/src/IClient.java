import java.rmi.RemoteException;
import java.sql.SQLException;

public interface IClient {
  boolean withdrawMoney(int customerID, double amount)
      throws SQLException, RemoteException;
  double checkBalance(int customerID) throws SQLException, RemoteException;
}
