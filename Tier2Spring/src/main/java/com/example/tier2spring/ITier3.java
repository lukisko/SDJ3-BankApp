package com.example.tier2spring;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface ITier3 extends Remote
{
  double getBalance(int customerID) throws SQLException,
          RemoteException;
  void setBalance(int customerID, double addAmount) throws SQLException,
      RemoteException;
  void createAccount(String name) throws SQLException,
          RemoteException;
  void deleteAccount(int customerID) throws SQLException,
          RemoteException;
  int getCustomerID(String name) throws SQLException,
          RemoteException;
}
