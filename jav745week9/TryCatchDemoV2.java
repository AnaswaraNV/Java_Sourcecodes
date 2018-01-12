
// the try-catch-finally block

// case 1: java TryCatchDemoV2
// case 2: java TryCatchDemoV2 hi
// case 3: java TryCathcDemoV2 hi there
// case 4: java TryCatchDemoV2 hi there wow

public class TryCatchDemoV2 {

	public static void main( String[] args) {


		Object cookie = new String( "choclate chip cookies" );

		try {
			   Double v = (Double) cookie;
        }
		catch( ClassCastException c ) { // exception handler

 			   System.out.println( c );
		}

		// normal flow of control
        System.out.println( "... more to come" );


        /* the finally block must go with a try block */
        try {
			   int r = 111 / args.length;

			   System.out.println( "r= " + r );

        }
        catch( Exception e) {
			   System.out.println( ">>> " + e );
        }

        finally { // the finally block is ALWAYS executed
                  // it is used to clean up things before
                  // the control is passed to another piece of code
			      // (e.g. close a file or close a socket connection)

                  System.out.println( "... inside the finally-block " );
        }

        // normal flow of control
        System.out.println( "*** the end ***" );
	}
}
