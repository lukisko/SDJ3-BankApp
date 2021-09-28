import java.rmi.Remote;

public interface ClientInterface extends Remote {
    double checkAmount(int customerID) throws Exception;
    void takeMoney(int customerID,double amount) throws Exception;
    int getMyID(String name) throws Exception;
    void response(double amount) throws Exception;

}
