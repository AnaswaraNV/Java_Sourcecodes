// use of inner classes

interface Event {

   public void action();

}

public class PhotoCopier {

   String model = "Xerox7501";

   Event[] features;

   PhotoCopier() { features = new Event[3];

		   features[0] = new Enlarge();
		   features[1] = new Copy();
                   features[2] = new Staple();
                 }

   public void testRun() {
			   for (int i=0; i<3; i++)
			       features[i].action();
                         }

   class Enlarge implements Event {
 	
	public void action() { 
                    System.out.println( model + ":" );
                    System.out.println( "\tEnlarge the original copy..." ); }
   }

   class Staple implements Event {
	public void action() {
 		    System.out.println( model + ":" );
                    System.out.println( "\tStaple the copies..." ); }
   }

   class Copy implements Event {
        public void action() {
		    System.out.println( model + ":" ); 
		    System.out.println( "\tMaking the copies..." ); }
   }
  
   public static void main(String[] args) {

      PhotoCopier little = new PhotoCopier();

      little.testRun();
   }   
}