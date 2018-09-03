package Model;

import java.io.Serializable;

/**
 * Class that represents a Party bus
 * @author Elena Smeu
 */
public class PartyBus extends Vehicle implements Serializable
{
   private boolean partyGuide;

   /**
    * 1 argument constructor that initialize all instance variables and sets
    * seats to 12 and regNumber to the argument given.
    * 
    * @param regNumber
    */
   public PartyBus(String regNumber)
   {
      super(regNumber);
      super.setSeats(12);
      this.partyGuide = false;
   }
   /**
    * makes bus available
    */
   public void makeAvaiable()
   {
      super.makeAvaiable();
   }
/**
 * makes bus unavailable
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
      if (!(obj instanceof PartyBus))
         return false;
      PartyBus other = new PartyBus(super.getRegNumber());
      return super.equals(other);
   }
   /**
    * @return is available
    */
   public boolean getAvaiability()
   {
      return super.getAvaiability();
   }
   /**
    * toString
    */
   public String toString()
   {
      String all = super.toString() + "partyGuide:";
      if (partyGuide == true)
         all += "yes";
      else
         all += "no";
      return all;
   }
   /**
    * sets party guide to either true or false
    * @param value
    */
   public void setPartyGuide(boolean value)
   {
      this.partyGuide = value;
   }
   /**
    * @return type of bus
    */
   @Override
   public String getType()
   {

      return "PartyBus";
   }

}
