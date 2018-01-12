// a demo on creating 2 different threads

public class ThreadDemo3 {

   public static void main(String[] args) {

      CoffeeThread coffeeRequest = new CoffeeThread();

      coffeeRequest.start();

      Thread teaRequest = new Thread( new TeaRunnable(), 
	                                  "tea-request thread" );
                                      // a Runnable object is passed into the constructor
									  // of the Thread class

      teaRequest.start();

      System.out.println( "*** " + Thread.currentThread().getName() + " : THE STORE IS CLOSED ***" );
   }
}

// option 1: extends Thread (that has implemented Runnable already)

class CoffeeThread extends Thread {

    private static int count = 0;

    public CoffeeThread() { super( "coffee-request thread" ); }

    // override the run() method
    public void run() {

        while (count<10) {
                       try { sleep(1000); }
                       catch( InterruptedException e ) { }

                       count++;
					   System.out.println( count + ": " + getName() +
                                                   " : coffee please!!" );
                     }
    }
}

// option 2: implements Runnable
class TeaRunnable implements Runnable {

    private static int num=0;

    // implement the run() method
    public void run() {
                	while (num<10) {

                           try { Thread.sleep( 1500 ); }      // a static method
                           catch( InterruptedException e) { }

                           num++;
						   System.out.println( "\t\t<" + num + "> " +
						                       Thread.currentThread().getName() +
                                               " : tea please!" );
                        }
    		      }
}