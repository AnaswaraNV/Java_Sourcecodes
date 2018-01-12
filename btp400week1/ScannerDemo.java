
// Java 1.6, 1.5

import java.util.*;

public class ScannerDemo {

   public static void main( String args[] ) {


          Scanner keyboard = new Scanner( System.in );

          System.out.println( "What year?" );

          String year = keyboard.nextLine();   // nextInt()

          System.out.println( "Your comment: " );

          String comment = keyboard.nextLine();

          System.out.println( "year- " + year + "\n" +
                              "comment-\n" + comment );


   }

}