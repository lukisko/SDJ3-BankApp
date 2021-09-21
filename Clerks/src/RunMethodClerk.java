import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RunMethodClerk {
  public static void main(String[] args)
      throws RemoteException, NotBoundException, MalformedURLException {
    IClerk tier2 = (IClerk) Naming.lookup( "rmi://localhost/T2" );
  }
}
