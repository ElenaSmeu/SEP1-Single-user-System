package Model;
import java.io.Serializable;

/**
 * A class representing a vehicle
 * 
 * @author Elena Smeu
 */
public abstract class Vehicle implements Serializable
{
   private String regNumber;
   private boolean isAvaiable;
   private int numberOfseats;

   /**
    * A two-argument constructor.
    * 
    * @param regNumber
    *           the registration number
    */

   public Vehicle(String regNumber)
   {
      this.regNumber = regNumber;
      this.isAvaiable = true;
      this.numberOfseats=0;
   }

   /**
    * A non-argument constructor.Which set the regNumber as an empty string and
    * the value of isAvaiable to false
    */
   public Vehicle()
   {
      this.regNumber = " ";
   }
   /**
    * Gets reg number
    * @return Reg number
    */
   public String getRegNumber()
   {

         return regNumber;


   }
   /**
    * Gets seats
    * @return seats
    */
   public int getNumberOfSeats()
   {
      return numberOfseats;
   }
   /**
    * Sets regnumber to newOne
    * @param newOne
    */
   public void setRegNumber(String newOne)
   {
      this.regNumber = newOne;
   }
   /**
    * Set seats to param
    * @param seats
    */
   public void setSeats(int seats)
   {
      this.numberOfseats=seats;
   }
   /**
    * Makes vehicle available
    */
   public void makeAvaiable()
   {
      this.isAvaiable = true;
   }
   /**
    * Makes vehicle unavailable
    */
   public void makeUnavaiable()
   {
      this.isAvaiable = false;
   }
   /**
    * Gets availability
    * @return availability
    */
   public boolean getAvaiability()
   {
      return isAvaiable;
   }
   /**
    * equals method
    */
   public boolean equals(Object obj)
   {
      if (!(obj instanceof Vehicle))
         return false;
      Vehicle other = (Vehicle) obj;
      return regNumber.equals(other.regNumber)
            && isAvaiable == other.isAvaiable&&numberOfseats==other.numberOfseats;
   }

   /**
    * 
    * abstract method that returns the type of vehicle in a String
    * @return Type of vehicle
    */
   public abstract String getType();

   public String toString()
   {
      String all = "";
      all += getType();
      all += ",";
      all += getNumberOfSeats();
      all += ",";
      all += isAvaiable;
      all += ",";
      all += regNumber;
      return all;
   }
   
   public void setPartyGuide()
   {
	   if(getType().equals("Party Bus"))
	   {
		   setPartyGuide();
	   }
   }

}
