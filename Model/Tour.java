package Model;
import java.io.Serializable;
/**
 * 
 * Class that represents a Tour
 * @author Daniel Kim
 *
 */
public abstract class Tour  implements Serializable
{
   private Chauffeur chauffeur;
   private String destination;
   private DateInterval timeinterval;
   private Vehicle vehicle;
   private Route route;
   /**
    * 4 Argument constructor that initializes all the instance variables
    * @param destination
    * @param timeinterval
    * @param vehicle
    * @param chauffeur
    */
   
   public Tour(String destination, DateInterval timeinterval, Vehicle vehicle, Chauffeur chauffeur)
   {
      this.destination= destination;
      this.timeinterval = timeinterval.copy();
      this.vehicle = vehicle;
      this.chauffeur= chauffeur;
   }
   /**
    * Gets Destination
    * @return destination
    */
   public String getDestination()
   {
      return this.destination;
   }
   /**
    * Sets Destination
    * @param destination
    */
   public void setDestination(String destination)
   {
      this.destination=destination;
   }
   /**
    * Sets vehicle
    * @param vehicle
    */
   public void setVehicle(Vehicle vehicle)
   {
      this.vehicle=vehicle;
   }
   /**
    * Sets Chauffeur 
    * @param chauffeur
    */
   public void setChauffeur(Chauffeur chauffeur)
   {
      this.chauffeur=chauffeur;
   }
   /**
    * Gets Chauffeur
    * @return Chauffeur
    */
   public Chauffeur getChauffeur()
   {
      return chauffeur;
   }
   /**
    * Gets Vehicle   
    * @return Vehicle
    */
   public Vehicle getVehicle()
   {
      return this.vehicle;
   }
   /**
    * Gets DateInterval
    * @return DateInterval
    */
   public DateInterval getDateInterval()
   {
      return this.timeinterval;
   }
   /**
    * Sets DateInterval
    * @param timeinterval
    */
   public void setDateInterVal(DateInterval timeinterval)
   {
      this.timeinterval= timeinterval.copy();
   }
   /**
    * Gets Route
    * @return Route
    */
   public Route getRoute()
   {
      return route;
   }
   /**
    * Gets next busstop
    * @return BusStop
    */
   public BusStop getNextBustStop()
   {
      return route.getNextBusStop();
   }
   /**
    * Gets first busstop in route
    * @return BusStop
    */
   public BusStop getFirstBusStop()
   {
      return route.getFirstBusStop();
   }
   /**
    * Gets last bus stop in route
    * @return BusStop
    */
   public BusStop getLastBusStop()
   {
      return route.getLastBusStop();
   }
   /**
    * toString method
    */
      
   public String toString()
   {
      String t ="";
      t +="Tour to "+destination+" in "+vehicle.getType()+ " at "+timeinterval;
      return t;
   }
}
