// console-based input/output

import java.util.*;

public class ScannerApp {

   public static void main(String[] args) {

	Scanner scanner = new Scanner( System.in );

	System.out.println( "Enter a line of characters:" );


	String inputLine = scanner.nextLine();

	System.out.println( "You have entered:\n" + inputLine );


	// Part 2

    /* input format: int, float, string */

	System.out.println( "*** Enter an integer, a float and a string: " );

	inputLine = scanner.nextLine();  // returns null at the end of stream

    // extract 3 tokens

    String regexp = "\\s";
    String [] tokens;

    tokens = inputLine.split( regexp );

	int m = Integer.parseInt( tokens[0] );    // extract an int

	// Java 2
	float z = Float.parseFloat( tokens[1] );  // extract a float

	      /* JDK 1.1
	         valueOf(): convert a String object into a Float object
	         float z = Float.valueOf( chopper.nextToken() ).floatValue();
               */

	String remaining = "";

	for (int i=2; i < tokens.length; i++) {

		 remaining += "*" + tokens[i];
	}

	System.out.println( "integer: " + m );
	System.out.println( "float: " + z );
	System.out.println( "string: " + remaining );


   }
}