package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInterface extends Remote {
    double checkAmount(int customerID) throws RemoteException;
    void takeMoney(int customerID,double amount) throws RemoteException;
    void getMyID(String name) throws RemoteException;
    void response(double amount, int customerID) throws RemoteException;

}
