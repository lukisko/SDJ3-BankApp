import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RunMethodCustomer {



  public static void main(String[] args)
      throws RemoteException, NotBoundException, MalformedURLException {
    IClient tier2 = (IClient) Naming.lookup( "rmi://localhost/T2" );
  }
}
