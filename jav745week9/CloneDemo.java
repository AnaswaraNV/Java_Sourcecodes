
/*
   cloning: the process of making a bit-for-bit copy of a Java objcet
       - the clone() method in Object: only the (reference) values are copies if
                                       the instance variables are object variables
*/


public class CloneDemo {

   public static void main( String args[] ) throws Exception {

      int a[] = new int[3];

      for (int k=0; k < a.length; k++ ) a[k] = k+1;

      int b[], c[];

      b = a;

      System.out.println( "b == a " + (b==a) );

      c = (int []) a.clone();

      System.out.println( "c == a " + (c==a) );

      for (int j=0; j < c.length; j++ )

          System.out.print( c[j] );

      System.out.println( "........" );

      // Part 2
      Employee e1, e2;

      e1 = new Employee( 12345, "John Doe", "70 The Pond", "1950" );

      e2 = (Employee) e1.clone();  // only if the Employee class has overidden the clone method

      System.out.println( e2);

      System.out.println( "e1 == e2: " + (e1==e2) );

       /* String s1 = "xyz", s2;

	  	      s2 = (String) s1.clone(); // compiler error message
	  	    */

	   /* java.util.Date d1 = new java.util.Date(), d2;

	  	       d2 = (java.util.Date) d1.clone(); // OK; read the API
	    */
   }

}