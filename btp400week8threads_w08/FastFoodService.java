
// a multithreaded application
// related threads that do not interact

public class FastFoodService {

   public static void main(String[] args) {

      int m = 24;                                   // number of customers

      Integer clients[] = new Integer [m];          // an array of customers

      for(int i=0; i < clients.length; i++)

         clients[i] = new Integer( i*i + m );

      int k = 3;                                    // number of threads
      ServerThread cashiers[] = new ServerThread[k];

      int p = m / 3;                                // amount of workload

      for(int j=0; j<k; j++) {

         int start = j*p;

         cashiers[j] = new ServerThread( j+1, start, start+p-1, clients, j+1 );
         cashiers[j].start();
      }
   }
}

class ServerThread extends Thread {

    private int from;
    private int to;
    private Object[] v;
    private int wait;

    ServerThread(int id, int a, int b, Object[] c, int d) {

       super( "Cashier Counter " + id );

       from = a;       to = b;
       v = c;          wait = d;
    }

    public void run() {

       for (int i=from; i <= to; i++) {

           System.out.println( getName() + ": serving customer " +

                               i + " <id = "+ (Integer)v[i] + ">" );

           // process a customer's order

	   try {
		  switch( wait ) {
	      	   case 1: sleep(1500); break;
               case 2: sleep(1000); break;
               case 3: sleep(1200); break;
          }
	   }
	   catch( InterruptedException e) { }
       }

       // the thread will die after exiting the method run()
       System.out.println( "\t" + getName() + ": NO MORE CUSTOMERS ***" );
    }
}