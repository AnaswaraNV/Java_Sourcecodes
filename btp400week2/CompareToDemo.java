
// use the generic compareTo method
import java.util.Arrays;

public class CompareToDemo {

	public static void main( String args [ ] ){

		Customer one = new Customer( "John Doe", 3 ),
			     two = new Customer( "Paul Newman", 7 ),
			     three = new Customer( "Mary Lewis", 1 ),
			     four = new Customer( "Anne Schultz", 3 );


		if (one.compareTo(two) < 0)
			System.out.println( one + "\n<<< is less than >>>\n" + two );

		if (two.compareTo(three) > 0)
			System.out.println( two + "\n<<< is greater than >>>\n" + three );

		if (one.compareTo(four) == 0)
		    System.out.println( one + "\n<<< is equal to >>>\n" + four );

	    // sort an array of Comparable objects
		System.out.println( "\nsort an array of Comparable objects..." );
		Customer [] customers = new Customer [4];
		
	    customers[0] = one;
		customers[1] = two;
		customers[2] = three;
		customers[3] = four;
		
		Arrays.sort( customers );
		
		for (Customer element: customers)    // enhanced for loop
		     System.out.println( element );
    }
}

// define the natural ordering of customers
// Java API: interface Comparable<T>

class Customer implements Comparable<Customer> {

	private String name;
	private int    priority;

	public Customer( String name, int priority ){
		this.name = name;
		this.priority = priority;
	}

	public String toString() {

		return "name: " + name + " priority: " + priority;
	}

	public int compareTo( Customer z ){

		return this.priority - z.priority;
	}
	/* Comparable: T is Object
	public int compareTo( Customer z ){

		return this.priority - ((Customer)z).priority;
	}
	*/
}