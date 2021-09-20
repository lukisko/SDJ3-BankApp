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
    tier3.setBalance(customerID,amount);
  }

  @Override public boolean withdrawMoney(int customerID, double amount)
  {
    return false;
  }
}
