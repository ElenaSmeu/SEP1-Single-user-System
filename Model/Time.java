package Model;

import java.util.Calendar;
import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * Class that represents a Time
 * @author Daniel Kim
 */
public class Time implements Serializable
{
   private int hour, minute;

   /**
    * 2 argument constructor that initialize and sets hour and minute
    * 
    * @param hour
    * @param minute
    */
   public Time(int hour, int minute)
   {
      set(hour, minute);
   }

   /**
    * 0 Argument constructor that sets it to current time
    */
   public Time()
   {
      Calendar now = GregorianCalendar.getInstance();
      this.hour = now.get(Calendar.HOUR_OF_DAY);
      this.minute = now.get(Calendar.MINUTE);
   }

   /**
    * Gets hour
    * 
    * @return hour
    */
   public int getHour()
   {
      return this.hour;
   }

   /**
    * Gets minute
    * 
    * @return minute
    */
   public int getMinute()
   {
      return this.minute;
   }

   /**
    * Makes a copy and returns it
    * 
    * @return Time copy
    */

   public Time copy()
   {
      Time other = new Time(hour, minute);
      return other;
   }

   /**
    * toString method
    */

   public String toString()
   {
      String all = "";
      if (hour < 10)
      {
         all += "0";
      }
      all += hour;
      all += ":";
      if (minute < 10)
      {
         all += "0";
      }
      all += minute;

      return all;
   }

   /**
    * Sets hour and minute then checks if they are legal otherwise it makes them
    * legal values for hours and minutes.
    * 
    * @param hour
    * @param minute
    */
   public void set(int hour, int minute)
   {
      this.hour = hour;
      this.minute = minute;
      if (hour < 0)
         this.hour = 0;
      else if (hour > 23)
         this.hour = 23;

      if (minute < 0)
         this.minute = 0;
      else if (minute > 59)
         this.minute = 59;
   }
}
