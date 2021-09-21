import java.rmi.RemoteException;
import java.sql.SQLException;

public interface IAdmin {
    void deleteAccount(int customerID) throws Exception;
    void createAccount(String name)
            throws SQLException, RemoteException;
    int getCustomerID(String name) throws SQLException, RemoteException;
}
