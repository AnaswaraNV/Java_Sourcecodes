// a demo on creating a thread

public class ThreadDemo {

   public static void main(String[] args)  {

      CoffeeThread coffeeRequest = new CoffeeThread();

      coffeeRequest.start();

      System.out.println( "\t*** the main thread is going to sleep..." );

      try { Thread.sleep( 500 ); }     // the main thread is sleeping
      catch( InterruptedException e ) { }

      System.out.println( "\t*** the main thread is going to stop: Bye Bye ***" );

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

        while (true) {

			count++;

            System.out.println( getName() + " " + count +
                                ": coffee please..." );

		    try { sleep(1000); }

            catch( InterruptedException e ) { }

            //if (count == 13) throw new RuntimeException( "???" );
        }
    } // run
}

// option 2: implements Runnable
