import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class Tier2 extends UnicastRemoteObject implements IClient, IClerk {

  private ITier3 tier3;

  protected Tier2() throws RemoteException
  {

    try {
      Naming.rebind( "rmi://localhost/T2", this );

      tier3 = (ITier3) Naming.lookup( "rmi://localhost/T3" );
    } catch( Exception ex ) {
      ex.printStackTrace();
      System.exit( 1 );
    }
  }

  @Override public void insertMoney(int customerID, double amount)
      throws SQLException, RemoteException
  {
    double balance = tier3.getBalance(customerID) + amount;
    tier3.setBalance(customerID,balance);
  }

  @Override public boolean withdrawMoney(int customerID, double amount)
      throws SQLException, RemoteException
  {
    double balance = tier3.getBalance(customerID);

    if(balance > amount){
      balance -= amount;
      tier3.setBalance(customerID,balance);
      return true;
    }
    return false;
  }

  @Override public double checkBalance(int customerID)
      throws SQLException, RemoteException
  {
    return tier3.getBalance(customerID);
  }
}
