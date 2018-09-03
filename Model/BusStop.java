package Model;

import java.io.Serializable;

/** Class that represents a Bus Stop
 * @author Daniel Kim
 */
public class BusStop implements Serializable
{
   private String address;
   private DateTime dateTime;

   /**
    * 2 Argument constructor that takes address and a copy of the argument
    * datetime and initialize it
    * 
    * @param address
    * @param dateTime
    */

   public BusStop(String address, DateTime dateTime)
   {
      this.address = address;
      this.dateTime = dateTime.copy();
   }

   /**
    * 6 Argument constructor that makes a datetime of minute,hour,day,month,year
    * and address and initialize it.
    * 
    * @param address
    * @param year
    * @param month
    * @param day
    * @param hour
    * @param minute
    */
   public BusStop(String address, int year, int month, int day, int hour,
         int minute)
   {
      this.address = address;
      this.dateTime = new DateTime(minute, hour, day, month, year);
   }

   /**
    * @return DateTime that contains the next stop
    */
   public DateTime getStopTime()
   {
      return dateTime;
   }

   /**
    * @return address
    */
   public String getAddress()
   {
      return address;
   }

   /**
    * @return String containing address and the datetime
    */
   public String toString()
   {
      String t = "";
      t += address + " - " + dateTime;
      return t;
   }

   /**
    * @return Boolean depending on if the argument given is the same object as
    *         the one calling the method
    * @param Object
    *           you want to compare
    */
   public boolean equals(Object obj)
   {
      if (!(obj instanceof BusStop))
         return false;
      BusStop other = (BusStop) obj;
      return this.address.equals(other.address)
            && this.dateTime.equals(other.dateTime);
   }

}
