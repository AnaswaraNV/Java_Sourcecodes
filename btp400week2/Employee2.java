// an example on Java objects

// constructor
// instance variables, static variable
// methods: getters and setters
// keywords: this,new

public class Employee2 {

    public static int numberOfEmployees;

    private int    employeeID;
    private String employeeName;
    private String address;
    private String startingYear;

    public Employee2( int id, String name, String addr, String year) {

	    employeeID = id;
        employeeName = name;

        setAddress( addr );

        startingYear = year;

        numberOfEmployees++;
    }

    public Employee2( ) { this( 10000, "unknown", "unknown", "unknown"); }

    public void setAddress( String address ) { this.address = address;  }

    public void setEmployeeID( int id ) { employeeID = id; }

    public void setEmployeeName( String name ) { employeeName = name; }

    public void setStartingYear( String year ) { startingYear = year; }

    public String getAddress() { return address; }

	public int getEmployeeID() { return employeeID; }

	public String getEmployeeName() { return employeeName; }

	public String getStartingYear() { return startingYear; }

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

    // the equals() method
    public boolean equals( Object z ) {

		boolean result = false;

		if ( z instanceof Employee2 ) {

			Employee2 z2 = (Employee2) z;

			if ( ( z2.employeeID == employeeID) &&
			     (z2.employeeName.equals(employeeName)) &&
			     (z2.address.equals(address)) &&
			     (z2.startingYear.equals(startingYear)) )

			     result = true;
		}

		return result;
	}

	// the static main method
    public static void main(String args[]) {

         Employee2 e1, e2;


         e1 = new Employee2( 10023, "Phil Coulthard",
                                     "70 The Pond, Seneca@York", "2002" );

         e2 = new Employee2( 10023, "Phil Coulthard",
                                     "70 The Pond, Seneca@York", "2002" );

         if ( e1 == e2)

              System.out.println( "the objects are equal" );

         else System.out.println( "the objects are NOT equal" );


         // ------------------------------------------------------------
		 if ( e1.equals(e2) )

              System.out.println( "two objects have the same data contents" );

         else System.out.println( "two objects do NOT have the same data contents" );
    }
}