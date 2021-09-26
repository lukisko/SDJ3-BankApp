import java.rmi.Remote;

public interface ClientInterface extends Remote {
    double checkAmount(int customerID);
    void takeMoney(int customerID,double amount);
    void getMyID(String name);
    void response(double amount);

}
