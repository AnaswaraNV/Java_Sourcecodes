// use an interface as the type of an argument

interface Sliceable {
   public void slice();
}

class Fruit {

   public void inquire() { System.out.println( "Can this fruit be sliced into pieces?" ); }
}

class Apple extends Fruit
            implements Sliceable {

   public void slice() { System.out.println( "Slice the apple into 2 pieces." ); }

}

class Banana extends Fruit 
             implements Sliceable {

   public void slice() { System.out.println( "Slice the banana into 7 pieces." ); }

}

public class TestFood {

   public static void main(String[] arg) {

       Sliceable x[] = new Sliceable[100];

       x[0] = new Apple();
       x[1] = new Banana();
  
       x[0].slice(); x[1].slice();
   }
}
/*
public class FoodProcessor {

   FoodProcessor() { System.out.println( "Starting a food processor..." ); }

   public void sliceAnItem( Sliceable a ) {
      a.slice();    // dynamic(i.e. runtime) binding!
   }

   public static void main(String[] args) {

      FoodProcessor fp = new FoodProcessor();

      Apple apple = new Apple();
      Banana banana = new Banana();

      fp.sliceAnItem( banana );
      fp.sliceAnItem( apple );
      
   }
}
*/
