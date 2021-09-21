import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class RunMethodAdmin {
  public static void main(String[] args) throws Exception
  {
    IAdmin tier2 = (IAdmin) Naming.lookup( "rmi://localhost:1099/Admin" );
    //tier2.deleteAccount(25);
    tier2.createAccount("Peter");

    System.out.println("finished");

  }
}
