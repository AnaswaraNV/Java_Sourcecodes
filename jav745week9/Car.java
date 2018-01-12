// 3 user-defined exceptions:
// smoke, out of gas, flat tires

// throws and throw

class CarException extends Exception {

    CarException() { }
    CarException(String s) { super(s); }
}

class SmokeException extends CarException {

    SmokeException() { }
    SmokeException(String s1) { super(s1); }
}

class OutOfGasException extends CarException {

    OutOfGasException() { }
    OutOfGasException(String s2) { super(s2); }
}

class FlatTireException extends CarException {

    FlatTireException() { }
    FlatTireException(String s3) { super(s3); }
}

public class Car{

   private double gasLevel;
   private double temperature;
   private double[] tirePressure;

   public Car() { gasLevel = 45;
                  temperature = 22;
                  tirePressure = new double[] { 30, 22, 24, 30 };
                }

   public void run(int m, int n, int t) throws CarException	// what if this is omitted???
   {
	  // adjust the gas level, the temperature of the engine and tire pressure
      gasLevel -= m; temperature += n * n;

      for(int i=0; i<tirePressure.length; i++)

	      tirePressure[i] += t*(i+1);

      System.out.println( "... gas is going low; " +
                          "temperature and tire pressure are rising..." );

      // check the gas level, the temperature of the engine and tire pressure
      if (gasLevel <= 0 )

          throw new OutOfGasException( "the gas tank has become empty" );

      if (temperature > 50 )

          throw new SmokeException( "smoke is coming out from the car" );


      // find the number of flat tires
      int count=0;

	  for(int i=0; i<tirePressure.length; i++)

          if (tirePressure[i] > 40) count++;

      if (count == 1)
          throw new FlatTireException( count + " tire has gone flat" );

      else if (count > 1)
               throw new FlatTireException( count + " tires have gone flat" );

   } // what will happen if the method checks tire pressure first?

   public static void main( String args[] ) {

      Car     chevy = new Car();
      boolean normal = true;
      int     a=5, b=4, c=15;

      while ( normal ) {

         try {
	           chevy.run(a, b, c);
             }
         catch (CarException e) {

            System.out.println( e.getMessage() );
            System.out.println( e );
            System.out.println( "------------------------" );

            if (e instanceof OutOfGasException)
                  normal = false;

            else System.out.println( "*** keep on running the car ***" );
         }
     } // while
   } // main
}
