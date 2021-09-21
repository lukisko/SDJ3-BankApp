import java.rmi.Naming;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler implements ITier3 {

    public DatabaseHandler() {
        try {
            Naming.rebind("rmi://localhost/T3", this);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public double getBalance(int customerID) throws SQLException, RemoteException {
        double balance = 0;
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select balance from Account where customerID = ?");
            balance = statement.getResultSet().getDouble(2);
            statement.executeUpdate();
        }
        return balance;
    }

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

    @Override
    public void createAccount(String name) throws SQLException, RemoteException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("insert into Account(id,name,balance) values (DEFAULT,name = ?,amount=?)");
            statement.setString(1, name);
            statement.setDouble(2, 0);
            statement.executeUpdate();
        }
    }

    @Override
    public void deleteAccount(int customerID) throws SQLException, RemoteException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("delete from Account where customerID=?");
            statement.setInt(1, customerID);
            statement.executeUpdate();
        }
    }

    @Override
    public int getCustomerID(String name) throws SQLException, RemoteException {
        int id = 0;
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select ID=? from Account where name=?");
            statement.setString(2, name);
            id = statement.getResultSet().getInt(1);
            statement.executeUpdate();
        }
        return id;
    }
}
