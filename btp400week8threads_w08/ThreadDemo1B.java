// a demo on the interleaving of the main thread
// and another thread
// both threads have the same priority
// (you may use the getPriority method to return the priority value)

public class ThreadDemo1B {

   public static void main(String[] args)  {

      CoffeeThread [] coffeeRequests = new CoffeeThread[2];

      for (int i=0; i < coffeeRequests.length; i++) {

		   coffeeRequests[i] = new CoffeeThread();

           coffeeRequests[i].start();
      }

      System.out.println( "the main thread has started running TWO coffee threads..." );

      boolean exit = false;

      while ( !exit ) {

            Thread t = Thread.currentThread();

            System.out.println( "\t........ " + t.getName() + " : hello ???" );

            try { Thread.sleep(1000); }
            catch( InterruptedException e) { System.out.println( "INTERRUPT!" );
                                             exit = true; }
      }

      System.out.println( "main: the end" );

/*      Thread teaRequest = new Thread( new TeaThread() );

        teaRequest.start();
*/
   }
}

// option 1: extends Thread
class CoffeeThread extends Thread {

    private static int count = 0;

    // override the run() method
    public void run() {

        while (true) { count++;
                       System.out.println( getName() + " " + count +
                                           ": coffee please..." );

		       try { sleep( 500 ); }
               catch( InterruptedException e )
                       {  e.printStackTrace();          }
        }
    }
}

// option 2: implements Runnable
