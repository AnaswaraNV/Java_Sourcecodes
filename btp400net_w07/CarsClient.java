// a simple client/server application
// that exchanges OBJECTS
// console-based

// a CLIENT program that uses a stream socket connection to
// exchange objects
// use of ObjectOutputStream and ObjectInputStream classes

import java.net.*;
import java.io.*;

public class CarsClient {

   public static void main(String[] args) {

	Socket clientSocket;		// TCP/IP socket

	try {

             /* step 1: connect to the server
                IP address/server name: "localhost"
                port number:            8000
              */
 
	     clientSocket = new Socket( InetAddress.getByName( "localhost" ),
                                        8000 );

	     System.out.println( "Connected to " + 
		    clientSocket.getInetAddress().getHostName() );

	     /* step 2: connect input and output streams to the socket
              */
	     ObjectInputStream  oisFromServer= new ObjectInputStream( 
                                                   clientSocket.getInputStream() );

	     ObjectOutputStream oosToServer = new ObjectOutputStream( 
                                                  clientSocket.getOutputStream() );                            
            

	     System.out.println( "I/O streams connected to the socket" );


	     /* step 3: communicate with the server
              */
             Car[] cars = new Car[3];

             cars[0] = new Car( "Toyata Corolla", "john doe", 1000 );
             cars[1] = new Car( "Honda Civic", "mary ryan", 2000 );
             cars[2] = new Car( "Volvo S70", "mel lastman", 3000 );

             for(int i=0; i < 3; i++) {

		try {

                     
		     // send an object to the server
                     oosToServer.writeObject( cars[i] ); 
                     oosToServer.flush();
             
		     System.out.println( "\n### send this car to the server for registration:\n" +
                                         cars[i] );

                     // receive an objectfrom the server
                     cars[i] = (Car) oisFromServer.readObject();   // casting!

                     System.out.println( "\t###### the car returned by the server:\n" + cars[i] );

                     try { Thread.sleep(2000); }		     
		     catch( InterruptedException e ) { }
		}

                catch( ClassNotFoundException cnf) { cnf.printStackTrace(); }

		catch( EOFException eof ) { System.out.println( 
                                              "The server has terminated connection!" ); }

		catch(IOException e ) { e.printStackTrace(); }		
	     }

	     /* step 4: close the connection to the server
              */
	     System.out.println( "\nClient: closing the connection..." );		

	     oosToServer.close();
	     oisFromServer.close();
	     clientSocket.close();
	}
        catch( IOException ioe ) { ioe.printStackTrace(); }
 
        System.out.println( "the client is going to stop runing..." );
	
   } // end main   
}
