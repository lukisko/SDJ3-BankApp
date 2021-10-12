package com.example.tier2spring;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

  @DeleteMapping("/customer/{custId}")
  public synchronized ResponseEntity<String> deleteCustomer(@PathVariable String custId){
    try {
      int Id = Integer.parseInt(custId);
      tier3.deleteAccount(Id);
    } catch (NumberFormatException exception){
      return new ResponseEntity(HttpStatus.BAD_REQUEST);
    } catch (Exception exception){
      return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity(HttpStatus.OK);
  }

  @GetMapping("/customer/{customerNo}/balance")
  public synchronized ResponseEntity<String> getBalance(@PathVariable String customerNo){
    int custNo = 0;
    double value = 0;
    try {
      custNo = Integer.parseInt(customerNo);
    } catch (NumberFormatException exception){
      return new ResponseEntity<>("Invalid number.",HttpStatus.BAD_REQUEST);
    }
    try {
      value = tier3.getBalance(custNo);
      return new ResponseEntity<String>(String.valueOf(value),HttpStatus.OK);
    } catch (Exception exception){
      return new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/customer")
  @ResponseBody
  public synchronized ResponseEntity<String> getCustomerId(@RequestParam String name){
    if (name == null || name.equals("")){
      return new ResponseEntity<>("needs name parameter",HttpStatus.BAD_REQUEST);
    } else {
      try{
        int Id = tier3.getCustomerID(name);
        return new ResponseEntity<>(String.valueOf(Id),HttpStatus.OK);
      } catch (Exception exception){
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }
  }

  @PostMapping("/customer")
  public synchronized ResponseEntity<String> createAccount(@RequestBody String body){
    return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
