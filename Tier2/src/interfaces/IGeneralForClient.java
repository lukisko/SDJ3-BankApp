package interfaces;

import java.rmi.RemoteException;

public interface IGeneralForClient extends IGeneral{
   void addToActiveClientList(ClientInterface IClient) throws RemoteException;
  void removeFromActiveClientList(ClientInterface IClient) throws RemoteException;
}
