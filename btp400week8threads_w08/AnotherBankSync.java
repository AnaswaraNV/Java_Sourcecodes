
// a demo on synchronized threads
// that share one account

public class AnotherBankSync {

   final static int NUM = 10;

   public static void main(String[] args) {

        Shared  account = new Shared();

        System.out.println( "starting balance: " + account.getbalance() );

	    WorkThread t1 = new WorkThread( account, 'W' ),

	               t2 = new WorkThread( account, 'D' );

	    t1.start();
	    t2.start();

	    try { t1.join();
	            t2.join();
		}
	    catch( InterruptedException ie ) { }

        System.out.println( "final balance: " + account.getbalance() );
   }
}


class WorkThread extends Thread {

    private Shared data;
    private char   opcode;

    WorkThread( Shared w, char op ) { data = w;
                                      opcode = op;
                                    }

    public void run() {

        // Thread t = Thread.currentThread();

      	// System.out.println( "*** " + t.getName() + ": balance: " + q);
        // System.out.println( "\t sleeping..." );

	  try {  for( int j=0; j<20; j++) {

				 if ( opcode == 'D' )

				      data.deposit( 50 );

				 else data.withdraw( 50 );

		         Thread.sleep( 15 );
		     }

	  }
      catch (InterruptedException e) { }

 	  //  System.out.println( "\t*** " + t.getName() + " new balance: " +
      //                      data.getbalance() + " ***" );
    }
}

// the class is thread-safe
class Shared {

    private int m = 0;   // initial balance

    public int getbalance() { return m; }

    public synchronized void deposit(int k) { System.out.print( " deposit " + k );

    							 int temp;
    							 temp = m;
                                 temp += k;
                                 System.out.println( " ...new balance (from deposit): " + temp );
                                 m = temp;
                               }

    public synchronized void withdraw( int z ) { System.out.print( " Withdraw " + z );

                                    int temp2;
                                    temp2 = m;
                                    temp2 -= z;
                                    System.out.println( " ...new balance (from withdraw): " + temp2 );
                                    m = temp2;
                                  }
}
