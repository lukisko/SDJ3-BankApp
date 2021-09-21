import java.rmi.RemoteException;
import java.sql.SQLException;

public interface IClerk {
  boolean withdrawMoney(int customerID, double amount)
      throws SQLException, RemoteException;
  void insertMoney(int customerID, double amount)
      throws SQLException, RemoteException;
}
