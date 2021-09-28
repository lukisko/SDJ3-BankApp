import java.rmi.Naming;

public class RunMethodAdmin {
    public static void main(String[] args) throws Exception {
        IGeneral tier2 = (IGeneral) Naming.lookup("rmi://localhost:1099/T2");

        tier2.createAccount("George Washington");



        System.out.println("Admin connected...");

    }
}
