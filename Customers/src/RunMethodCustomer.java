import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RunMethodCustomer {



  public static void main(String[] args) throws RemoteException
  {
    Client client=new Client();

    Scanner input=new Scanner(System.in);

   int id= client.getMyID("George Washington");
      client.takeMoney(id,300);



//    client.takeMoney(1,3);
//    client.disconnect();
  }
}
