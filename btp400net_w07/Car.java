// the class implements the Serializable interface

import java.io.*;

public class Car implements Serializable {

   private String model;
   private String owner;
   private double mileage;
   private String registration;

   public Car( String brand, String name, double k ) {
      model = brand;
      owner = name;
      mileage = k;
      registration = "xxx";
   }

   public String toString() {

      String s = "";

      s += "Model: " + model + " Owner: " + owner + 
           " mileage: " +  mileage + 
           " Registration: " + registration;

      return s;
   }
   
   public void getRegistered(String num) {
      registration = num;
   }

}
