// learning objectives
//   - Java API
//   - console output
//   - keyboard input

/* Note: a Java program is built on classes
 */

/**
       This is a javadoc comment. It documents classes and methods.
       The purpose of this class is self-explanatory.

       @version 1.0
       @author  Peter Liu
       @see     "Deitel and Deitel, Java How To Program"

 */


public class Welcome {

        /**
            The main method will be called by the JVM.

        	@param args the command-line arguments
          */

	    public static void main(String args [] ) {

	        System.out.println( "This is a console-based Java Application!" );

	        System.out.println( "number of command-line arguments: " + args.length );

	        for (int k=0; k < args.length; k++)

	        	System.out.println( args[k] );

	        // Part 2 - keyboard input
	        java.util.Scanner scanner = new java.util.Scanner( System.in );

	        System.out.println( "Please enter a line of data values:" );
	        String inputLine = scanner.nextLine();
	        System.out.println( "... You've entered the following line of characters:" );
	        System.out.println( inputLine );
	}
}
