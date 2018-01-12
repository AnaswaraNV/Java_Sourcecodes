// inheritance in Java
// keywords: extends, super

// superclass
class Container {

   protected int width;     // accessible by a subclass AND any class in the same package
   protected int length;
   protected int height;

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


public class Inherit {

   public static void main(String[] args) {

      CargoContainer polarExpress = new CargoContainer( 3500, 6758.9, 100, 200, 300 );

      Container c = new Container(100, 200, 300);

      System.out.println( "the volume of the cargo container: " + polarExpress.volume() );
      System.out.println( "the volume of the container: " + c.volume() );
      System.out.println( "... extra space allocated for a cargo container: " + CargoContainer.EXTRA );

      System.out.println( "****************" );
      System.out.println( c );
      System.out.println( polarExpress );


   }
}