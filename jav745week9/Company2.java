
import java.util.*;

public class Company2 {

   private Vector employees;       // instance variable
   private String name;



   public Company2( String name, int n ){

   	  this.name = name;

   	  employees = new Vector();
   }

   public boolean hire( Employee person ) {

   	   boolean done = true;

   	   employees.addElement( person );

   	   return done;
   }

   public String toString() {

   	  int m = employees.size();

   	  String s = name + " has " + m + " employees.\n\n";

   	  for (int k=0; k < m; k++) {

		   Employee emp = (Employee) employees.elementAt(k);

   		   s += emp.toString();
      }

   	  return s;
   }


	public static void main( String[] arg ) {


		Company2 c = new Company2( "Seneca@York", 500 );

		System.out.println( c );

		c.hire( new Employee( 1001, "John Doe", "111 The Pond", "2003" ) );
		c.hire( new Employee( 2002, "Mary Cunha", "222 Leslie", "2001" ) );

		System.out.println( c );


	}
}