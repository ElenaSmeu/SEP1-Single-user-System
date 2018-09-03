package Model;
import java.io.Serializable;
/**
 * Class that represents a DateInterval
 * @author Daniel Kim
 *
 */
public class DateInterval implements Serializable
{
   private DateTime start;
   private DateTime end;
   /**
    * 2 Argument constructor that initialize start and end
    * @param start
    * @param end
    */
   public DateInterval(DateTime start, DateTime end)
   {
     this.start = start.copy();
     this.end = end.copy();
   }
   /**
    * sets startdate
    * @param start
    */
   public void setStartDate(DateTime start)
   {
      this.start = start.copy();
   }
   /**
    * sets enddate
    * @param end
    */
   public void setEndDate(DateTime end)
   {
      this.end=end.copy();
   }
   /**
    * 
    * @return Start date
    */
   public DateTime getStartDate()
   {
      return this.start;
   }
   /**
    * 
    * @return End Date
    */
   public DateTime getEndDate()
   {
      return this.end;
   }
   /**
    * ToString method 
    * @return String containing the Date Interval in brackets
    */
   public String toString()
   {
      String t= "["+start+"  -  "+end+"]";
      return t;
   }
   /**@param object
    * @return boolean based on if argument given is equals to the object calling the method
    */
   public boolean equals(Object obj)
   {
      if(!(obj instanceof DateInterval))
         return false;
      DateInterval other = (DateInterval) obj;
      return this.start.equals(other.start)&&this.end.equals(other.end);
   }
   /**
    * 
    * @return DateInterval copy
    */
   public DateInterval copy()
   {
      return new DateInterval(start,end);
   }
   
}
