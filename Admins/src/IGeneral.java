import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface IGeneral extends Remote {
    void deleteAccount(int customerID) throws SQLException, RemoteException;
    void createAccount(String name)
            throws SQLException, RemoteException;
    int getCustomerID(String name) throws SQLException, RemoteException;
    boolean withdrawMoney(int customerID, double amount) throws SQLException, RemoteException;
    void insertMoney(int customerID, double amount)
            throws SQLException, RemoteException;
    double checkBalance(int customerID) throws SQLException, RemoteException;

}
