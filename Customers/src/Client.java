import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class Client implements ClientInterface {
    IClient tier2;

    public Client() {
        try {
            tier2 = (IClient) Naming.lookup("rmi://localhost/T2");
            tier2.addToActiveClientList(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public double checkAmount(int customerID) {
        try {
            return tier2.checkBalance(customerID);
        } catch (Exception throwables) {
            return 0;
        }
    }

    @Override
    public void takeMoney(int customerID, double amount) {

        try {
            tier2.withdrawMoney(customerID, amount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getMyID(String name) {

        try {
            System.out.println(tier2.getCustomerID(name));

        } catch (Exception e) {
        }

    }

    @Override
    public void response(double amount) {
        System.out.println("Balance was changed to: " + amount);
    }

    public void disconnect() {
        tier2.removeFromActiveClientList(this);

    }
}
