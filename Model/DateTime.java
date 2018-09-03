package Model;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 * Class that represents a Date Time
 * @author Daniel Kim
 *
 */
public class DateTime implements Serializable

{
   private int day;
   private int month;
   private int year;
   private Time time;
   /**
    * A 5 argument constructor that sets and initialize all instance variables
    * @param minute
    * @param hour
    * @param day
    * @param month
    * @param year
    */
   public DateTime(int minute, int hour, int day, int month, int year)
   {
      this.time = new Time(hour, minute);
      this.day = day;
      this.month=month;
      this.year=year;
   }
   /**
    * A 3 argument constructor that initialize and sets day, month and year, sets Time to null
    * @param day
    * @param month
    * @param year
    */
   public DateTime( int day, int month, int year)
   {
      this.day = day;
      this.month=month;
      this.year=year;
      time=null;
   }
   /**
    * A 4 argument constructor that takes day, month, year and time.
    * 
    * @param day
    * @param month
    * @param year
    * @param time
    */
   public DateTime(int day, int month, int year, Time time)
   {
      this.day = day;
      this.month=month;
      this.year=year;
      this.time = time.copy();
   }
   /**
    * A no argument constructor that sets the date and time to the current time and date.
    */
   public DateTime()
   {
      this.time = new Time();
      Calendar now = GregorianCalendar.getInstance();
      this.day = now.get(Calendar.DAY_OF_MONTH);
      this.month = now.get(Calendar.MONTH) + 1;
      this.year = now.get(Calendar.YEAR);
   }
   /**
    *  sets all
    * @param minute
    * @param hour
    * @param day
    * @param month
    * @param year
    */
   public void set(int minute, int hour, int day, int month, int year)
   {
      if (year < 0)
      {
         year = -year;
      }
      this.year = year;

      if (month < 1)
      {
         month = 1;
      }
      if (month > 12)
      {
         month = 12;
      }
      this.month = month;

      if (day < 1)
      {
         day = 1;
      }
      if (day > numberOfDaysInMonth())
      {
         day = numberOfDaysInMonth();
      }
      this.day = day;
      time.set(hour, minute);
   }
   /**
    * 
    * @return day
    */
   public int getDay()
   {
      return day;
   }
/**
 * 
 * @return month
 */
   public int getMonth()
   {
      return month;
   }
   /**
    * 
    * @return year
    */
   public int getYear()
   {
      return year;
   }
   /**
    * 
    * @return hour
    */
   public int getHour()
   {
      return time.getHour();
   }
   /**
    * 
    * @return minute
    */
   public int getMinute()
   {
      return time.getMinute();
   }
   /**
    * 
    * @return month name
    */
   public String getMonthName()
   {
      switch (month)
      {
         case 1:
            return "January";
         case 2:
            return "February";
         case 3:
            return "March";
         case 4:
            return "April";
         case 5:
            return "May";
         case 6:
            return "June";
         case 7:
            return "July";
         case 8:
            return "August";
         case 9:
            return "September";
         case 10:
            return "October";
         case 11:
            return "November";
         case 12:
            return "December";
         default:
            return "Wrong month";
      }
   }
   /**
    * 
    * @return  Boolean if its isleapyear
    */
   public boolean isLeapYear()
   {
      return (year % 4 == 0 && ((year % 100 != 0) || (year % 400 == 0)));
   }
   /**
    * Increments day by one
    */
   public void stepForwardOneDay()
   {
      day++;
      if (day > numberOfDaysInMonth())
      {
         day = 1;
         month++;
         if (month > 12)
         {
            month = 1;
            year++;
         }
      }
   }
   /**
    * Increments days by parameter days
    * @param days
    */
   public void stepForward(int days)
   {
      for (int i = 0; i < days; i++)
      {
         stepForwardOneDay();
      }
   }
   /**
    * 
    * @return number of days in current month
    */
   public int numberOfDaysInMonth()
   {
      switch (month)
      {
         case 4:
         case 6:
         case 9:
         case 11:
            return 30;
         case 2:
            if (isLeapYear())
            {
               return 29;
            }
            else
            {
               return 28;
            }
         default:
            return 31;
      }
   }

   
   /**
    * 
    * @param other
    * @return boolean if other is before the object calling the method
    */
   public boolean isBefore(DateTime other)
   {
      double d1 = year * 525948.766 + month * 43829.0639 + day*1440 + time.getHour()*60+time.getMinute();
      double d2 = other.year * 525948.766 + other.month * 43829.0639 + other.day*1440 + other.time.getHour()*60+other.time.getMinute();
      return d1 < d2;
   }

   
   /**
    * 
    * @return datetime copy
    */
   public DateTime copy()
   {
      return new DateTime(day, month, year, time);
   }
   /**
    * 
    * @param date
    * @return boolean if its same date 
    */
   public boolean isSameDate(DateTime date)
   {
      return day == date.day && month == date.month && year == date.year;
   }
   /**
    * Equals method
    */
   public boolean equals(Object obj)
   {
      if (!(obj instanceof DateTime))
         return false;

      DateTime other = (DateTime) obj;

      return day == other.day && month == other.month && year == other.year && time.getHour()==other.time.getHour() && time.getMinute()==other.time.getMinute();
   }
   /**
    * tostring method
    */

   public String toString()
   {
      String s = "";
      if (day < 10)
      {
         s += "0";
      }
      s += day + "/";
      if (month < 10)
      {
         s += "0";
      }
      s += month + "/" + year;
      s += " "+time;

      return s;
   }

}
