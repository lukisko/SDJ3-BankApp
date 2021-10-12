package com.example.tier2spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

@RestController
public class Tier2Controller
{
  private ITier3 tier3;
  public Tier2Controller() throws RemoteException
  {
    try {
      tier3 = (ITier3) Naming.lookup("rmi://192.168.43.111:1099/T3");
    } catch (Exception e){
      e.printStackTrace();
      System.exit(1);
    }
  }
}
