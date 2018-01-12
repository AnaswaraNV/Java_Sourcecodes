
// use multiple threads to search for the highest
// temperature over a period of years

public class MultipleThreads {

   public static void main(String[] args) {

       SearchThread[] threads = new SearchThread[5];

       int[][] temperatures = { {10, 20, 30, 0 },
                                {-20, -30, -40, -50},
                                {15, 26, 34, 38},
                                {-1, -2, -3, -4},
                                {18, 22, 31, 35} };
       int max = -1000;


       for (int i=0; i < 5; i++) {

            threads[i] = new SearchThread( temperatures[i] );
            threads[i].start();
       }

       // wait for all the threads to finish
       try {

            for (int i=0; i < 5; i++) {

                 threads[i].join();

                 max = Math.max(max, threads[i].getResult());
            }
       }
       catch (InterruptedException e) { }

       System.out.println("Maximum value was " + max);
   }
}

class SearchThread extends Thread {

    private int max = -1000;

    private int[] dataArray;

    public SearchThread(int[] dataArray) { this.dataArray = dataArray; }

    // search for the highest temperature in this array
    public void run() {

       for (int i = 0; i < dataArray.length; i++)

            max = Math.max(max, dataArray[i]);

       System.out.println( getName() + " finished: max= " + max );
    }

    public int getResult() { return max; }
}