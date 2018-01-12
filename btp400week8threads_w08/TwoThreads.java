
// we cannot predict the timing of thread scheduling and execution
// (i.e. nondeterministic)

public class TwoThreads {

    public static void main(String[] args) {

       Thread thread1 = new Thread1();
       Thread thread2 = new Thread2();

       thread1.start();
       thread2.start();
    }
}

class Thread1 extends Thread {

   public void run() {

	  for (int i=1; i<=10; i++) {

           System.out.print("A");
           System.out.print("B");
           System.out.println("." );
      }
  }
}

class Thread2 extends Thread {

   public void run() {

	  for (int j=1; j<=10; j++) {

           System.out.print("1");
           System.out.print("2");
           System.out.println("-");
      }
   }
}