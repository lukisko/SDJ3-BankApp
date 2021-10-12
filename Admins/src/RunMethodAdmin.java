import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.sql.SQLException;
import java.rmi.registry.LocateRegistry;

public class RunMethodAdmin {
    public static void main(String[] args) throws Exception {
        IAdmin tier2 = (IAdmin) Naming.lookup("rmi://localhost:1099/T2");



        tier2.createAccount("John");
        int id = tier2.getCustomerID("John");
        tier2.deleteAccount(id);
        System.out.println("finished");

    }
}
