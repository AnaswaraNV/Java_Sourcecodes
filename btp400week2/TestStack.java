// use of an interface Stack

public class TestStack {

   public static void main(String[] args) {

	// use an implementation of the interface
	// Stack:      interface name!
	// StackArray: class name

	Stack one = new StackArray();  

	System.out.println( "Using an interface..." );
	System.out.println( "one is " + 
			    ( one.isEmpty()? "empty" : "not empty"));


        // application: use the methods declared in an interface 
	//              to build a stack of Double objects

	one.push( new Double(1.1) );
	one.push( new Double(3.3) );
	one.push( new Double(5.5) );

        double sum = 0;
	while ( !one.isEmpty() ) {
		
		Object t = one.pop();

		System.out.println( t );

		sum +=  ( (Double) t ).doubleValue();

		// what if there's no casting on t?
	}

	System.out.println( "sum: " + sum );
   }
}