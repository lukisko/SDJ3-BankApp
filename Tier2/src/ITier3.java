import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface ITier3 extends Remote
{
  void setBalance(int customerID, double addAmount) throws SQLException,
      RemoteException;
  double getBalance(int customerID)throws SQLException,
      RemoteException;
}
