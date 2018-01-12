public class ThreadTest {
	public static void main(String[] args) {
		CoffeeRequest coffee = new CoffeeRequest();
		coffee.start();
		
	}
}

class CoffeeRequest extends Thread {
	private int count = 0; 

	public void run() {
		while (count < 5 ) {
				try { sleep(1000); }
                       catch( InterruptedException e ) { }
				System.out.println("coffee please " + count);
				count++;
				
		}
	}
}