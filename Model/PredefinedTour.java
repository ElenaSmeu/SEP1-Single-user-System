package Model;

import java.io.Serializable;

/**
 * Class that represents a Predefined Tour
 * @author Daniel Kim
 */
public class PredefinedTour extends Tour implements Serializable
{
   private int availableSeats;
   private double seatprice;

   /**
    * 5 Argument constructor that sets instance variables in this class and
    * super class
    * 
    * @param destination
    * @param timeinterval
    * @param vehicle
    * @param chauffeur
    * @param seatprice
    */
   public PredefinedTour(String destination, DateInterval timeinterval,
         Vehicle vehicle, Chauffeur chauffeur, double seatprice)
   {
      super(destination, timeinterval, vehicle, chauffeur);
      this.availableSeats = vehicle.getNumberOfSeats();
      this.seatprice = seatprice;
   }
   /**
    * Sets price
    * @param price
    */

   public void setPrice(double price)
   {
      this.seatprice = price;
   }
   /**
    * 
    * @return price
    */
   public double getPrice()
   {
      return seatprice;
   }
   /**Sets destination
    * @param destination
    */

   public void setDestination(String destination)
   {
      super.setDestination(destination);
   }
   /**
    * Adds busstops
    * @param stop
    */
   public void addBusStop(BusStop stop)
   {
      super.getRoute().add(stop);
   }
   /**
    * @return destination
    */
   public String getDestination()
   {
      return super.getDestination();
   }
   /**
    * Sets chauffeur
    *  @param chauffeur
    */
   public void setChauffeur(Chauffeur chauffeur)
   {
      super.setChauffeur(chauffeur);
   }
   /**
    * @return chauffeur
    */
   public Chauffeur getChauffeur()
   {
      return super.getChauffeur();
   }
   /**
    * sets dateInterval
    * @param timeinterval
    */
   public void setDateInterval(DateInterval timeinterval)
   {
      super.setDateInterVal(timeinterval);
   }
   /**
    * 
    * @return availableseats
    */
   public int getAvailbleSeats()
   {
      return availableSeats;
   }
   /** Sets vehicle
    * @param vehicle
    */
   public void setVehicle(Vehicle vehicle)
   {
      super.setVehicle(vehicle);
   }
   /**
    * @return vehicle
    */
   public Vehicle getVehicle()
   {
      return super.getVehicle();
   }
   /**
    * Decrements seats available
    * @param decrement
    */
   public void decrementSeats(int decrement)
   {
      this.availableSeats -= decrement;
   }
   /**
    * toString method
    */

   public String toString()
   {
      String t = super.toString();
      t += " available seats: " + availableSeats;
      return t;
   }

}
