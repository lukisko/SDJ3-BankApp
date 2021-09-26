import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RunMethodCustomer {



  public static void main(String[] args)
  {
    Client client=new Client();
    client.takeMoney(1,3);
    client.disconnect();
  }
}
