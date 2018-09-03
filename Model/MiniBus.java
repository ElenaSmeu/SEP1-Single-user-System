package Model;

import java.io.Serializable;

/**
 * Class that represents a mini bus
 * @author Elena Smeu
 */
public class MiniBus extends Vehicle implements Serializable
{

   /**1 Argument constructor that sets regnumber to argument given and seats to 16
    * @param regNumber 
    */
   public MiniBus(String regNumber)
   {
      super(regNumber);
      super.setSeats(16);
   }
   /**
    * Makes bus available
    */
   public void makeAvaiable()
   {
      super.makeAvaiable();
   }
   /**
    * Makes bus unavailable
    */
   public void makeUnavaiable()
   {
      super.makeUnavaiable();
   }
   /**
    * equals method
    */
   public boolean equals(Object obj)
   {
      if (!(obj instanceof MiniBus))
         return false;
      MiniBus other = new MiniBus(super.getRegNumber());
      return super.equals(other);
   }
   /**
    * @return if available
    */
   public boolean getAvaiability()
   {
      return super.getAvaiability();
   }
   /**
    * toString method
    */
   public String toString()
   {
      return super.toString();
   }
/**
 * @return type of bus
 */
   @Override
   public String getType()
   {

      return "MiniBus";
   }

}
