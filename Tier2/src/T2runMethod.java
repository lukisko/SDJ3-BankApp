public class T2runMethod {
  public static void main(String[] args) {

    System.setProperty("java.security.policy","all.policy");
    if (System.getSecurityManager() == null){
      System.setSecurityManager(new SecurityManager());
    }

    try {
      Tier2 T2 = new Tier2();

      System.out.println( "Tier2 ready" );
    } catch( Exception ex ) {
      ex.printStackTrace();
    }
  }
}
