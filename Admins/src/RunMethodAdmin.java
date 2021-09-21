import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RunMethodAdmin {
  public static void main(String[] args)
      throws RemoteException, NotBoundException, MalformedURLException {
    IAdmin tier2 = (IAdmin) Naming.lookup( "rmi://localhost/T2" );
  }
}
