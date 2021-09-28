import interfaces.ClientInterface;
import interfaces.IGeneralForClient;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Client extends UnicastRemoteObject implements ClientInterface {


    private IGeneralForClient tier2;

    public Client() throws RemoteException {
        try {
            tier2 = (IGeneralForClient) Naming.lookup("rmi://localhost/T2");
            tier2.addToActiveClientList(this);
            System.out.println("Client connected...");
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
    public int getMyID(String name) {

        try {
            return tier2.getCustomerID(name);

        } catch (Exception e) {
        }
        return 0;
    }

    @Override
    public void response(double amount) {
        System.out.println("Balance was changed to: " + amount);
    }

    public void disconnect() throws RemoteException {
           tier2.removeFromActiveClientList(this);
    }
}
