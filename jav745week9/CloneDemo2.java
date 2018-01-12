
/*
   cloning: the process of making a bit-for-bit copy of a Java objcet
       - the clone() method in Object: only the (reference) values are copied if
                                       the instance variables are object variables
*/

/* deep cloning for refereces to mutable objects */

public class CloneDemo2 implements Cloneable {

   private int   start;
   private Fruit item;

   public CloneDemo2( int z, Fruit f ) { start = z; item = f; }

   Fruit getItem() { return item; }

   // deep cloning
   public Object clone() {

      CloneDemo2 copy = null;

      try {
           copy = (CloneDemo2) super.clone();     // clone() from the class Object
                                                  // bitwise copying

           copy.item = (Fruit) item.clone();      // the Fruit class is cloneable
      }
      catch( CloneNotSupportedException cse ) { cse.printStackTrace(); }

      return copy;
   }


   public static void main( String args[] ) {

      Fruit x = new Fruit( "apple" );

      CloneDemo2 cd = new CloneDemo2(100, x );

      CloneDemo2 cd2 = (CloneDemo2) cd.clone();

      System.out.println( "cd.getItem() == cd2.getItem() " +
                          (cd.getItem() == cd2.getItem() ) );

   }

}


class Fruit implements Cloneable {

	private String name;

	public Fruit( String z ) { name = z; }

	public Object clone() {

       Fruit t = null;

	   try { t = (Fruit) super.clone(); }

	   catch( CloneNotSupportedException cse ) { cse.printStackTrace(); }

	   return t;
	}
}