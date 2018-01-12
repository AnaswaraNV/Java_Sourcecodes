
// 3 subclasses of Fruit: Apple, Banana, Cocunut
// only 2 subclasses are Sliceable


/* a separate Java class */
public class Fruit {

   public void inquire() { System.out.println( "Can this fruit be sliced into pieces?" ); }
}

/* a class that implements the interface Sliceable */
class Apple extends Fruit
            implements Sliceable {

   private int pieces = 2;

   public void slice() { System.out.println( "Slice the apple into " + getPieces() + " pieces." ); }

   public int getPieces() { return pieces; }

}

/* a class that implements the interface Sliceable */
class Banana extends Fruit
             implements Sliceable {

   private int chunks = 7;

   public void slice() { System.out.println( "Slice the banana into " + getPieces() + " pieces." ); }

   public int getPieces() { return chunks; }

}

class Coconut extends Fruit {

    public String toString() { return "cocunt cannot be sliced!"; }

}



