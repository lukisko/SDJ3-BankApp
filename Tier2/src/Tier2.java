import interfaces.ClientInterface;
import interfaces.IGeneralForClient;
import interfaces.ITier3;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

public class Tier2 extends UnicastRemoteObject implements IGeneralForClient {

    private ITier3 tier3;
    private ArrayList<ClientInterface> activeClients;

    public Tier2() throws RemoteException {
        this.activeClients = new ArrayList<>();
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            Naming.bind("T2", this);
            tier3 = (ITier3) Naming.lookup("rmi://192.168.43.111:1099/T3");


        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }

    }

   @Override
    public void insertMoney(int customerID, double amount)
            throws SQLException, RemoteException {
       double addedMoney= tier3.getBalance(customerID)+amount;
        tier3.setBalance(customerID,addedMoney );
    }

   @Override
    public boolean withdrawMoney(int customerID, double amount)
            throws Exception  {

        if (checkBalance(customerID) < amount) {
            System.out.println("hello tier2 if ");
            return false;
        } else {
            System.out.println("hello tier2 else ");
         double withdrawnMoney= tier3.getBalance(customerID)-amount;

            tier3.setBalance(customerID, withdrawnMoney);

            double customerBalance = checkBalance(customerID);

            for (ClientInterface x : activeClients) {
                x.response(customerBalance);
            }
            return true;
        }
    }

    @Override
    public double checkBalance(int customerID) throws SQLException, RemoteException {
        System.out.println("Check balance method");
        try {
            return tier3.getBalance(customerID);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int getCustomerID(String name) throws SQLException, RemoteException {
        return tier3.getCustomerID(name);
    }

   @Override
    public void deleteAccount(int customerID) throws Exception {
        tier3.deleteAccount(customerID);
    }

    @Override
    public void createAccount(String name) throws SQLException, RemoteException {
        tier3.createAccount(name);
    }

  @Override
  public void addToActiveClientList(ClientInterface IClient) {
        activeClients.add(IClient);

    }
    @Override
    public void removeFromActiveClientList(ClientInterface IClient) {
        activeClients.remove(IClient);

    }
}
