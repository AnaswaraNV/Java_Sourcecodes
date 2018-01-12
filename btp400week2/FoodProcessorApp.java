
/* a class that "uses" the interface Sliceable */
public class FoodProcessorApp {

   FoodProcessorApp() { System.out.println( "Starting a food processor..." ); }

   /* the interface Sliceable is used as the TYPE of an ARGUMENT */

   public void sliceAnItem( Sliceable a ) {

      a.slice();    /* dynamic(i.e. runtime) binding! */
   }

   public static void main(String[] args) {

      FoodProcessorApp fp = new FoodProcessorApp();

      Apple apple = new Apple();
      Banana banana = new Banana();
      Coconut coconut = new Coconut();


      fp.sliceAnItem( banana );   // pass a Sliceable object reference
      fp.sliceAnItem( apple );

      // Part 2
      Fruit basket[] = { apple, banana, coconut };

      for (int i=0; i < basket.length; i++)

          if ( (basket[i] instanceof Apple) == true ||
               (basket[i] instanceof Banana) == true   )

               fp.sliceAnItem( (Sliceable)basket[i] );

          else System.out.println( basket[i] );

      // Sliceable x = new Sliceable();        // compiler error
      // Sliceable y[] = new Sliceable [100];  // OK!

   }
}
