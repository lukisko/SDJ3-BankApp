public class T3runMethod {
  public static void main(String[] args) {
    try {
      DatabaseHandler T3 = new DatabaseHandler();

      System.out.println( "Tier3 ready" );
    } catch( Exception ex ) {
      ex.printStackTrace();
    }
  }
}
