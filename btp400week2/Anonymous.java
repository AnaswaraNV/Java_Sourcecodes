
// two ways of declaring anonymous inner classes

interface Z {

   public void zoo();
}

class B {

   public void boo() {}
}

public class Anonymous {

   String sound = "Somone is making a funny sound: ";

   public void what() { System.out.println( "Do you like it?" ); }

   public void shout() {

        Z z = new Z() { // an anonymous inner class that
			// implements the interface Z
                        // advantage: access the members of the outer class

			public void zoo() { 
                               System.out.println( sound + "Zzzzz..." );

                               what(); // outer class method
                        }
                      } ;     

        B b = new B() { // an anonymous inner class that
		        // extends a class
                        // advantage: access the members of the outer class

		        public void boo() { 
                               System.out.println( sound + "Beeeee..." );

                               what(); // Anonymous.this.what();
                        }
		      };

        z.zoo();  
        b.boo();
   }

 
   public static void main(String[] args) {
    
      // create an instance of the Anonymous class

      Anonymous a = new Anonymous();

      a.shout();  
   }
}
