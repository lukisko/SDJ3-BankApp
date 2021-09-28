import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class RunMethodClerk  {
  public static void main(String[] args)
      throws RemoteException, NotBoundException, MalformedURLException, SQLException {
    IGeneral tier2 = (IGeneral) Naming.lookup("rmi://localhost:1099/T2");
    int custID=tier2.getCustomerID("George Washington");
    tier2.insertMoney(custID,2000);
  }
}
