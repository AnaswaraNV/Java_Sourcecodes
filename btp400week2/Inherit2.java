// polymorphism and casting in Java

// superclass
class Container {

   private int width;
   private int length;
   private int height;

   public Container() { this(10, 10, 10); }

   public Container(int w, int lg, int h) {

	  width = w;  length = lg;  height = h;
   }

   public int volume() { return width * length * height; }

   public String toString() {

	   String r = new String("/// container-");

       r += " width: " + width +
            " length: " + length +
            " height: " + height;

	   return r;
   }
}

// subclass
class CargoContainer extends Container {

   private double weight;
   private double cost;

   public static final int EXTRA = 1500;  // extra space for safety regulation

   public CargoContainer() {

      super();       // superclass default constructor

	  weight = 1000;
      cost = 1234.5;
   }

   public CargoContainer(double z, double c, int wf, int wlg, int wh) {

	  super(wf, wlg, wh); // superclass constructor

      weight = z;
	  cost = c;
   }

   // override the method from the superclass
   public int volume() {

	   return super.volume() + EXTRA;
   }

   // override the method from the superclass
   public String toString() {

	   String r = "*** cargo container- weight: " + weight +
                  " cost: " + cost + "\n";

       r += super.toString();

       return r; }
}


public class Inherit2 {

   public static void main(String[] args) {


      CargoContainer polarExpress = new CargoContainer( 3500, 6758.9, 100, 200, 300 );

      Container d = new Container( 100, 200, 300 );

      System.out.println( "volume: " + d.volume() );

      // casting UP: superclass-type variable = subclass-type variable
      d = polarExpress;

      // Java: dynamic binding(i.e. use of object type)!
      // reference type of d: Container
      // type of the object referenced by d: CargoContainer

      System.out.println( "**********\n" +
                          "casting up and dynamic binding - volume: " +
                          d.volume() );

      // casting DOWN: EXPLICIT type conversion coded by the programmer;
      //               the compiler will reject the assignment, otherwise
      // subclass-type variable = (subclass) superclass-type variable

      CargoContainer f = (CargoContainer) d;

      // declared reference type of f: CargoContanier
      // declared reference type of d: Container
      // actual object type referenced by d: CargoContainer

      System.out.println( "casting down and dynamic binding - volume: " + f.volume() );
   }
}
