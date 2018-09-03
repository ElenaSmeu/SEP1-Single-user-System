package Model;

import java.io.Serializable;

/**
 * Class that represents a Bus
 * 
 * @author Elena Smeu
 */
public class Bus extends Vehicle implements Serializable
{
   /**
    * Constructor that sets seats to 30 and regnumber to the argument given
    * 
    * @param regNumber
    */
   public Bus(String regNumber)
   {
      super(regNumber);
      super.setSeats(30);
   }

   /**
    * Method for changing boolean instance variable Available in super class
    * Vehicle to true
    */
   public void makeAvaiable()
   {
      super.makeAvaiable();
   }

   /**
    * Method for changing boolean instance variable Available in super class
    * Vehicle to false
    */
   public void makeUnavaiable()
   {
      super.makeUnavaiable();
   }

   /**
    * Equals method that takes one argument and compares it to the object the
    * method is called from it first checks if it is the same object type with
    * instanceof and return false if it isn't the same type then it checks the
    * instance variables of this class and also calls the equals method for the
    * super class vehicle.
    * 
    * @param obj
    * @return boolean based on if its the same or not
    */
   public boolean equals(Object obj)
   {
      if (!(obj instanceof Bus))
         return false;
      Bus other = new Bus(super.getRegNumber());
      return super.equals(other);
      }
   /**
    * Method that calls getAvailability() in superclass
    * 
    * @return availability
    * 
    */
   public boolean getAvaiability()
   {
      return super.getAvaiability();
   }
   /**
    * 
    * @return toString that returns a string containing the super class' toString method
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

      return "Bus";
   }

}
