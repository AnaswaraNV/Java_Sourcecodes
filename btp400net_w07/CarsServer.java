// a simple client/server application: car registration
// console-based

// a SERVER program that uses a stream socket connection
// to exchange objects

// *** use of ObjectOutputStream and ObjectInputStream classes ***

import java.net.*;
import java.io.*;

public class CarsServer{

   public static void main(String[] args) {

	ServerSocket serverSocket;		// TCP socket used for listening

	try {
             /* step 1: create a server socket
                        port number:     8000
              */
 
	     serverSocket = new ServerSocket( 8000 ); 

             /* setp 2: listen for a connection and create a socket
              */
             System.out.println( "*** this server is going register the cars ***" );
	     System.out.println( "listening for a connection..." );

             Socket socketConnection = serverSocket.accept();  // listen and wait
                                                               // TCP socket that is connected
                                                               // to the client

	     /* step 3: connect input and output streams to the socket
              */
	     ObjectOutputStream oosToClient = new ObjectOutputStream( 
                                                     socketConnection.getOutputStream() );

	     ObjectInputStream  oisFromClient = new ObjectInputStream( 
                                                       socketConnection.getInputStream() );

	     System.out.println( "I/O streams connected to the socket" );

	     /* step 4: exchange objects with THE client
              */
	     Car car;
		
             try {
                 int m = 1000;

                 while (true) {  // keep on getting data from the client

		     // read an object from THE client
                     car = (Car) oisFromClient.readObject();         // casting!
                     System.out.println( "\n*** receive an object from the CLIENT:\n " + car );              

		     // register the car 
                     car.getRegistered( "R" + m );
                     m++;

		     // send the object to THE client
                     oosToClient.writeObject( car ); 
                     oosToClient.flush();
                     
		     // display the result to the screen of the server
                     System.out.println( "\t******* send the object to the CLIENT" );

	          } // end while

	     }

             catch( ClassNotFoundException cnf ) { cnf.printStackTrace(); }
                     // thrown by readObject()

             catch( EOFException eof ) { System.out.println( 
                                               "*** THE client has terminated connection ***" ); }
             catch(IOException e ) { e.printStackTrace();    }	 

	     /* step 5: close the connection to the client
              */
	     oosToClient.close();
	     oisFromClient.close();	      
             socketConnection.close();	   
	 }
	 catch(IOException e ) { e.printStackTrace();     }	

         System.out.println( "*** the server is going to stop running ***" );

   } // end main   
}
