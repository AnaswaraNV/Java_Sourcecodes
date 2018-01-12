
// error propagation using the call stack of methods
// the code is compact and easier to understand

public class Propagate {

	static void one() {

       try {
   		    two();
   		    System.out.println( "one: hahaha" );

	       }
	   catch( ArithmeticException e ) {

           e.printStackTrace();
           System.out.println( "*** inside one: caught here ***" );
           throw new NumberFormatException();
       }
       finally {

		   System.out.println( "finally: what's going on?" );
	   }

       System.out.println( "... return from one" );
	}

	static void two() {

       try {
	        three();
	        System.out.println( "two:ho-ho-ho" );

           }
 	   catch( ClassCastException e ) {

            e.printStackTrace();
            System.out.println( "--- inside two: caught here ---" );
       }

       System.out.println( "... return from two" );
    }

	static void three() {

	       four();

           System.out.println( "return from three" );
	}

	static void four() {

           System.out.println( "\t inside four" );

	       int m = 100 / 0;

           System.out.println( "... return from four" );
        }

	public static void main( String[] args ){

        System.out.println( "... inside main");

        try {
		      one();
	    }
	    catch( Exception ex ) { ex.printStackTrace(); }

        System.out.println( "... leaving main" );
	}
}
