
// How can a method throw an exception?
// an exception is an object

public class ThrowDemo {

   int m;

   public ThrowDemo( int a ) { m = a; }

   public int foo() {

	if ( m > 100 )

             throw new ArrayIndexOutOfBoundsException( "!@$%^???" );

                              // a description of the exception
	else return m;
   }

   public static void main(String[] args) {

      int k = 1000;

      ThrowDemo what = new ThrowDemo(35);

      k = what.foo();

      System.out.println( "main: k: " + k );
      System.out.println( "..........." );

      k = -55;
      what = new ThrowDemo(200);

      try {
            k = what.foo();
          }

      catch( ArrayIndexOutOfBoundsException e ){

         System.out.println( e );

         System.out.println( e.getMessage() );

	     System.out.println( "### stack trace ###" );

         e.printStackTrace();
      }

      System.out.println( "main: k: " + k );
   }
}
