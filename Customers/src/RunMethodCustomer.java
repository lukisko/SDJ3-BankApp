import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RunMethodCustomer {


    public static void main(String[] args) throws RemoteException, InterruptedException {
        Client client = new Client();
        Scanner input = new Scanner(System.in);


        System.out.println("Please wait...");
        Thread.sleep(3000);
        System.out.println("Login\n Insert your name:\n");

        String clientName = input.nextLine();
        int customerID = client.getMyID(clientName);

        while (true) {
            System.out.println("Please choose an action\n 0)Exit \n 1)Check balance \n 2)Withdraw money\n ");
            int action = input.nextInt();

            if (action == 0) {
                client.disconnect();
                break;
            }

            switch (action) {
                case 1:
                    System.out.println("Your balance is: " + client.checkAmount(customerID));
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Insert the amount that you want to withdraw ");
                    int amountToWithdraw = input.nextInt();
                    client.takeMoney(customerID, amountToWithdraw);
                    break;
            }

        }

    }
}
