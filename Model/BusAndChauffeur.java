package Model;
import java.io.Serializable;
/**
 * Class that represents Bus And Chauffeur
 * @author Daniel Kim
 *
 */
public class BusAndChauffeur extends Tour implements Serializable
{
   /**
    * 4 Argument constructor that sets 
    * destination, timeinterval, vehicle and chauffeur in the superclass constructor
    * 
    * @param destination
    * @param timeinterval
    * @param vehicle
    * @param chauffeur
    */
   
   public BusAndChauffeur(String destination, DateInterval timeinterval, Vehicle vehicle, Chauffeur chauffeur)
   {
      super(destination, timeinterval, vehicle, chauffeur);
   }
   /**@param vehicle
    *  Sets the vehicle in super class
    */
   public void setVehicle(Vehicle vehicle)
   {
      super.setVehicle(vehicle);
   }
   /**
    * @param chauffeur 
    * Sets the chauffeur in superclass
    */
   public void setChauffeur(Chauffeur chauffeur)
   {
      super.setChauffeur(chauffeur);
   }
   /**
    * @return chauffeur
    * Gets chauffeur from superclass
    */
   public Chauffeur getChauffeur()
   {
      return super.getChauffeur();
   }
   /**
    * Calls setstartdate in superclass
    * @param datetime
    */
   public void setStartDate(DateTime datetime)
   {
      super.getDateInterval().setStartDate(datetime);
   }
   /**
    * Calls setsenddate in superclass
    * @param datetime
    */
   public void setEndDate(DateTime datetime)
   {
      super.getDateInterval().setEndDate(datetime);
   }
   /**
    * @return vehicle
    * returns vehicle from superclass
    * 
    */
   public Vehicle getVehicle()
   {
      return super.getVehicle();
   }
   /**
    * @return String containing super constructor tostring + chauffeurs name
    * 
    */
   public String toString()
   {
      String t=super.toString();
      t +=" Chauffeur :"+super.getChauffeur().getName();
      return t;
   }
   
}
