
/* Override the equals AND the hashCode() methods */

public class Employee3 {

    public static int numberOfEmployees;

    private int    employeeID;
    private String employeeName;
    private String address;
    private String startingYear;

    public Employee3( int id, String name, String addr, String year) {

	    employeeID = id;
        employeeName = name;

        setAddress( addr );

        startingYear = year;

        numberOfEmployees++;
    }

    public Employee3( ) { this( 10000, "unknown", "unknown", "unknown"); }

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

		if ( z instanceof Employee3 ) {

			Employee3 z2 = (Employee3) z;

			if ( ( z2.employeeID == employeeID) &&
			     (z2.employeeName.equals(employeeName)) &&
			     (z2.address.equals(address)) &&
			     (z2.startingYear.equals(startingYear)) )

			     result = true;
		}

		return result;
	}
	
	// override the hashCode() method
	public int hashCode() {
	    /* implementation of a hash function */
		
        int hash = 17;
		
        hash = hash * 37 + employeeID;                 // type: int
        hash = hash * 37 + employeeName.hashCode();    // type: String
		hash = hash * 37 + address.hashCode();
        hash = hash * 37 + startingYear.hashCode();
		return hash;
		
		// hash = hash * 37 + (ref == null ? 0 : ref.hashCode()); 
    }

	// the static main method
    public static void main(String args[]) {

         Employee3 e1, e2, e3;


         e1 = new Employee3( 10023, "Phil Coulthard",
                                     "70 The Pond, Seneca@York", "2002" );

         e2 = new Employee3( 10023, "Phil Coulthard",
                                     "70 The Pond, Seneca@York", "2002" );

        
		 if ( e1.equals(e2) ) {
              System.out.println( "both objects are EQUAL by contents" );
              System.out.println( e1.hashCode() == e2.hashCode() );
		 }

         e3 = new Employee3( 99999, "John Doe", "70 The Pond, Seneca@York", "2017" );
		 
		 if (!e1.equals(e3))
		     System.out.println( e1.hashCode() == e3.hashCode() );
    }
}