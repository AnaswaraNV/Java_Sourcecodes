// a simple client/server application
// console-based

// a CLIENT program that uses a stream socket connection
// use of DataOutputStream and DataInputStream classes

// the client program terminates after sending 4 service requests

import java.net.*;
import java.io.*;
import java.util.*;

public class SimpleClient{

   public static void main(String[] args) {

	Socket clientSocket;		// TCP/IP socket

	try {

             /* step 1: connect to the server
                        IP address/server name: "localhost"
                        port number:            8000
              */

	     clientSocket = new Socket( InetAddress.getByName( "localhost" ),
                                        8000 );

                                      // InetAddress.getByName( "127.0.0.1" )

	     System.out.println( "Connected to " +
		                 clientSocket.getInetAddress().getHostName() );

	         /* step 2: connect input and output streams to the socket
              */

	     DataOutputStream dosToServer = new DataOutputStream(
                                                clientSocket.getOutputStream() );

	     DataInputStream  disFromServer= new DataInputStream(
                                                 clientSocket.getInputStream() );

	     System.out.println( "I/O streams connected to the socket" );


	     /* step 3: exchange data with the server
              */
         /* BufferedReader keyboard = new BufferedReader(
                                           new InputStreamReader( System.in ) ); */

         Scanner keyboard = new Scanner( System.in );

        for (int i=1; i < 5; i++) {

				try {
                     // keyboard input
		             System.out.print( "What is the radius of the circle? " );

                     double radius = Double.parseDouble( keyboard.nextLine() );

		             // send data to the server
                     dosToServer.writeDouble( radius );
                     dosToServer.flush();		//  data sent immediately!

                     // receive data from the server
                     double area = disFromServer.readDouble();

		             // display the result to the screen
                     System.out.println( "\t### the area of the circle: " + area );

                     // DecimalFormat
				}
				catch( EOFException eof ) { // loss of connection

			    System.out.println( "The server has terminated connection!" ); }

				catch(IOException e ) { System.out.println( "I/O errors in data exchange" );
                                        e.printStackTrace(); 								}
	     }
              System.out.println( "Client: data exchange completed" );

	     /* step 4: close the connection to the server
              */
	     System.out.println( "Client: closing the connection..." );

	     dosToServer.close();
	     disFromServer.close();
	     clientSocket.close();
	}
    catch( IOException ioe ) { System.out.println( "I/O errors in socket connection" );
                               ioe.printStackTrace(); }

    System.out.println( "... the client is going to stop running..." );

   } // end main
}
