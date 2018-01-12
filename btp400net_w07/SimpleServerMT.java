// a simple client/server application
// console-based

// a "mutlithreaded" SERVER program that uses a stream socket connection
// use of DataOutputStream and DataInputStream classes

import java.net.*;
import java.io.*;

public class SimpleServerMT{

   public static void main(String[] args) {

	ServerSocket serverSocket;		// TCP server socket used for listening

    System.out.println( "*** a multithreaded server is running ***" );

	try {
             /* step 1: create a server socket
                        port number:     8000
              */

			serverSocket = new ServerSocket( 8000 );

             /* setp 2: a loop that listens for connections and
                                    creates THREADS with sockets
              */

            int count = 1;

	     	while (true) {

	        	System.out.println( "listening for a connection..." );

            	Socket socketConnection
                          = serverSocket.accept();  // listen and wait
                                                    // socketConnection: a TCP socket
						    						// that is connected
                                                    // to the client

            	System.out.println( "start a thread for client #" + count );
	        	System.out.println( "\t host name: " +
                                        socketConnection.getInetAddress().getHostName() +
                                    "\t IP address: " +
                                        socketConnection.getInetAddress().getHostAddress() );

                // System.out.println( "at port: " + socketConnection.getPort() );

            	Thread t = new HandleClientThread( socketConnection );
            	t.start();

            	count++;
	     	}
     }
	 catch(IOException e ) { e.printStackTrace();     }

     System.out.println( "*** the server is going to stop running ***" );

   } // end main
}

class HandleClientThread extends Thread {

         private Socket connection;
		 
		//constructor to initialize  socket connection.
         public HandleClientThread(Socket sock) { connection = sock; }

         public void run() {

            try {
	        	/* connect input and output streams to the socket
                 */

	        	DataOutputStream dosToClient = new DataOutputStream(
                                                      connection.getOutputStream() );

	        	DataInputStream  disFromClient = new DataInputStream(
                                                        connection.getInputStream() );

	        	System.out.println( "I/O streams connected to the socket" );

	       		/* exchange data with ONE client
                 */
               	try {
                 	 while (true) {  // keep on getting data from the client

		     		 	// read data from ONE client
                     	double radius = disFromClient.readDouble();

                     	System.out.println( "*** receive radius from the client: " + radius );

		     		 	// compute the area
                     	double area = radius * radius * Math.PI;

		     		 	// send the data to THE client
                     	dosToClient.writeDouble( area );
                     	dosToClient.flush();

		     		 	// display the result to the screen
                     	System.out.println( "\t*** send area to the client: " + area );
	          		 } // end while

	     	   	}
              	catch( EOFException eof ) { System.out.println(
                                               "*** the CLIENT has terminated connection ***" );
                                       	  }

	     		/* close the connection to the client
              	 */
	     		dosToClient.close();
	     		disFromClient.close();
             	connection.close();
        	}
			catch(IOException e ) { e.printStackTrace();    }

        } // end run

     } // end HandleClientThread