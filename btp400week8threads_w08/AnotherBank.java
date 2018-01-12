
// a demo on unsynchronized threads
// that share one account

// Notes
// 1. sometimes, the new balance becomes strange!
/* e.g.

deposit 50 ...new balance (from deposit): 0
Withdraw 50 deposit 50 ...new balance (from deposit): 50
...new balance (from withdraw): 0
deposit 50 ...new balance (from deposit): 50

*/
// 2. sometimes, the final balance is not zero!
/* e.g.

 deposit 50 ...new balance (from deposit): 50
 Withdraw 50 ...new balance (from withdraw): 0
 deposit 50 Withdraw 50 ...new balance (from withdraw): -50
 ...new balance (from deposit): 0
 Withdraw 50 ...new balance (from withdraw): -50
 deposit 50 ...new balance (from deposit): 0
 deposit 50 ...new balance (from deposit): 50
final balance: 50

*/


public class AnotherBank {

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



class Shared {

    private int m = 0;   // initial balance

    public int getbalance() { return m; }

    public void deposit(int k) { System.out.print( " deposit " + k );

    							 int temp;
    							 temp = m;
                                 temp += k;
                                 System.out.println( " ...new balance (from deposit): " + temp );
                                 m = temp;
                               }

    public void withdraw( int z ) { System.out.print( " Withdraw " + z );

                                    int temp2;
                                    temp2 = m;
                                    temp2 -= z;
                                    System.out.println( " ...new balance (from withdraw): " + temp2 );
                                    m = temp2;
                                  }
}
