// an example on Java objects

// constructor
// instance variables, static variable
// methods: getters and setters
// keywords: this, new

public class Employee implements Cloneable {

    public static int numberOfEmployees;

    private int    employeeID;
    private String employeeName;
    private String address;
    private String startingYear;


    public Employee clone() throws CloneNotSupportedException {

		return (Employee) super.clone(); // bitwise copying
		                                 // String objects are immutable!
    }

    public Employee( int id, String name, String addr, String year) {

	    employeeID = id;
        employeeName = name;

        setAddress( addr );

        startingYear = year;

        numberOfEmployees++;
    }

    public Employee() { this(10000, null, null, null); };

    public void setAddress( String address ) {

       this.address = address;
    }

    public String getAddress() { return address; }

    public String toString() {

       String s;

       s =    "*****************************************\n" +
              "*           Employee Information        *\n" +
	          "*****************************************\n" +
              "ID: " + employeeID + "\n" +
              "Name: " + employeeName + "\n" +
              "Address: " + address + "\n" +
              "Starting Year: " + startingYear + "\n\n";

       return s;
    }

    public static void main( String args[] ) {


         Employee phil, george;

         phil = new Employee();
         System.out.println( phil );
         System.out.println( "\t number of employees: " + Employee.numberOfEmployees +"\n" );

         // Part 2
         phil = new Employee( 10023, "Phil Coulthard",
                                     "70 The Pond, Seneca@York", "2002");


         george = new Employee( 10089, "George Farr",
                                       "678, IBM Toronto Lab", "1980" );

         System.out.println( phil );
         System.out.println( george );

         System.out.println( "\t number of employees: " + Employee.numberOfEmployees );

        // a special case about the default constructor:
	    // The Java compiler creates the default constructor if
        // does not have *any* constructors
  }
}
