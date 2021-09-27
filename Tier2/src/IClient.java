import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface IClient extends Remote  {
  boolean withdrawMoney(int customerID, double amount) throws  Exception;
  double checkBalance(int customerID) throws SQLException, RemoteException;
  int getCustomerID(String name) throws SQLException, RemoteException;
  void addToActiveClientList(ClientInterface IClient) throws RemoteException;
  void removeFromActiveClientList(ClientInterface IClient) throws RemoteException;
}
