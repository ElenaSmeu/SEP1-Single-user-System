package Model;

import java.util.ArrayList;
import java.io.Serializable;

/**
 * Class that represents a Route
 * @author Daniel Kim
 */
public class Route implements Serializable
{
   private ArrayList<BusStop> busStops;

   /**
    * 0 Argument constructor that initializes a new arraylist containing
    * busstops
    */
   public Route()
   {
      this.busStops = new ArrayList<>();
   }

   /**
    * @param index
    * @return BusStop at index
    */

   public BusStop get(int index)
   {
      return busStops.get(index);
   }

   /**
    * Adds busStop to arraylist
    * 
    * @param busStop
    */
   public void add(BusStop busStop)
   {
      this.busStops.add(busStop);
   }

   /**
    * @return next Busstop
    */
   public BusStop getNextBusStop()
   {
      // sorts list
      // checks if bus stop time is before current time, if true returns the bus
      // stop
      // otherwise if nothing is found return null
      this.sortByStopTime();
      DateTime now = new DateTime();
      for (int i = 0; i < busStops.size(); i++)
      {
         if (now.isBefore(busStops.get(i).getStopTime()))
            return busStops.get(i);
      }
      return null;
   }

   /**
    * Sorts busstops by Time
    */
   public void sortByStopTime()
   {
      ArrayList<BusStop> sorted = new ArrayList<>();
      while (busStops.size() > 0)
      {
         int minIndex = 0;
         for (int i = 0; i < busStops.size(); i++)
         {
            DateTime d1 = busStops.get(i).getStopTime();
            DateTime d2 = busStops.get(minIndex).getStopTime();
            if (d1.isBefore(d2))
            {
               minIndex = i;
            }
         }
         sorted.add(busStops.get(minIndex));
         busStops.remove(minIndex);
      }
      busStops = sorted;
   }

   /**
    * toString method
    */
   public String toString()
   {
      String t = "";
      for (int i = 0; i < busStops.size(); i++)
      {
         t += busStops.get(i);
         if (i + 1 < busStops.size())
            t += "\n";
      }
      return t;
   }

   /**
    * @return Last busstop in arraylist
    */
   public BusStop getLastBusStop()
   {
      if (busStops.get(busStops.size() - 1) != null)
         return busStops.get(busStops.size() - 1);
      return null;
   }

   /**
    * searches busstop and return its index
    * 
    * @param busStop
    * @return index
    */
   public int getIndexOf(BusStop busStop)
   {
      for (int i = 0; i < busStops.size(); i++)
      {
         if (busStop.equals(busStops.get(i)))
         {
            return i;
         }
      }
      return -1;
   }

   /**
    * Method looks for where the bus currently is by comparing current time to
    * the times in all busstops it then returns a string that says where it is
    * 
    * @return String containg information
    */
   public String status()
   {
      sortByStopTime();
      if (this.getNextBusStop() == null)
      {
         return getLastBusStop() + "  --- X";
      }
      if (this.getNextBusStop().equals(busStops.get(0)))
      {
         return "O --->  " + busStops.get(0);
      }
      return get(getIndexOf(getNextBusStop()) - 1) + "  --->  "
            + getNextBusStop();
   }
   /**
    * 
    * @return First busstop in arraylist
    */
   public BusStop getFirstBusStop()
   {
      BusStop a = null;
      if (busStops.get(0) == null)
      {
         return busStops.get(0);
      }
      return a;
   }
   /**
    * equals method
    */
   public boolean equals(Object obj)
   {
      if (!(obj instanceof Route))
         return false;
      Route other = (Route) obj;
      if (other.busStops.size() != this.busStops.size())
         return false;
      for (int i = 0; i < busStops.size(); i++)
      {
         if (!busStops.get(i).equals(other.busStops))
            return false;
      }
      return true;

   }

}
