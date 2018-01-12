
// Test the Employee class
// The default package is used here.
// The Employee and TestEmployee classes are put in the same directory

class TestEmployee {

    public static void main(String args[]) {


         Employee phil, george;

         System.out.println( "\t number of employees: " + Employee.numberOfEmployees +"\n" );

         phil = new Employee( 10023, "Phil Coulthard",
                                     "70 The Pond, Seneca@York", "2002");


         george = new Employee( 10089, "George Farr",
                                       "678, IBM Toronto Lab", "1980" );

         System.out.println( phil );
         System.out.println( george );

         System.out.println( "\t number of employees: " + Employee.numberOfEmployees );


    }

  }