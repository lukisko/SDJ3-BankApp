import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class DatabaseHandler extends UnicastRemoteObject implements ITier3 {

    public DatabaseHandler() throws RemoteException{
        try {
            LocateRegistry.createRegistry(1099);
            Naming.rebind("T3", this);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
// The method is working
    @Override
    public double getBalance(int customerID) throws SQLException, RemoteException {
        float balance = 0;
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select * from Account where customerID = ?");
            statement.setInt(1,customerID);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            balance = resultSet.getFloat(3);

        }
        return balance;
    }
// The method is working
    @Override
    public void setBalance(int customerID, double addAmount) throws
            SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("update Account set amount = ? where customerID = ?");
            statement.setDouble(1, addAmount);
            statement.setInt(2, customerID);
            statement.executeUpdate();
        }
    }
    // This method is working
    @Override
    public void createAccount(String name) throws SQLException, RemoteException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("insert into Account(name,amount) values (?,?)");
            statement.setString(1, name);
            statement.setDouble(2, 0);
            statement.executeUpdate();
        }
    }
    //The method is working
    @Override
    public void deleteAccount(int customerID) throws SQLException, RemoteException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("delete from Account where customerID=?");
            statement.setInt(1, customerID);
            statement.executeUpdate();
        }
    }
        //The method is working
    @Override
    public int getCustomerID(String name) throws SQLException, RemoteException {
        int id = 0;
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select customerID from Account where name=?");
            statement.setString(1, name);
            statement.executeQuery().next();
            id=statement.getResultSet().getInt("customerID");

        }
        return id;
    }
}
