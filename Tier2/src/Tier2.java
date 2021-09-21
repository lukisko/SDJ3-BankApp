import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class Tier2 extends UnicastRemoteObject implements /*IClient, IClerk,*/ IAdmin {

    private ITier3 tier3;

    protected Tier2() throws RemoteException {

        try {
            LocateRegistry.createRegistry(1099);
            //UnicastRemoteObject.exportObject(this,0);
            Naming.bind("Admin", this);

            tier3 = (ITier3) Naming.lookup("rmi://192.168.43.111:1099/T3");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }

    /*@Override
    public void insertMoney(int customerID, double amount)
            throws SQLException, RemoteException {
        tier3.setBalance(customerID, amount);
    }

    @Override
    public boolean withdrawMoney(int customerID, double amount)
            throws Exception {
        if (checkBalance(customerID) > amount) {

            return false;
        } else {
            tier3.setBalance(customerID, amount);
            return true;
        }
    }

    @Override
    public double checkBalance(int customerID) throws SQLException, RemoteException {
        return tier3.getBalance(customerID);
    }*/

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
}
