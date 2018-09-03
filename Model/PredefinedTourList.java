package Model;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * Class that represents a Predefined Tour List
 * @author Daniel Kim
 *
 */
public class PredefinedTourList implements Serializable
{
   private ArrayList<PredefinedTour> predefinedTours;
   /**
    * No argument constructor that initialize the arraylist
    */
   public PredefinedTourList()
   {
      predefinedTours = new ArrayList<>();
   }
   /**
    * 
    * @param chafname
    * @return Predefinedtour
    */
   public PredefinedTour getPredefinedTourByChauffeurName(String name)
   {
      for(int i = 0;i<predefinedTours.size();i++)
      {
         if(predefinedTours.get(i).getChauffeur().getName().equals(name))
         {
           return  predefinedTours.get(i);
         }
      }
      return null;
   }
   /**
    * removes tour given
    * @param tour
    */
   public void removePredefinedTour(PredefinedTour tour)
   {
      for(int i = 0; i<predefinedTours.size();i++)
      {
         if(tour.equals(predefinedTours.get(i)))
            predefinedTours.remove(i);
      }
   }
   /**
    * gets tour by destination
    * @param destination
    * @return tour
    */
   public PredefinedTour getPredefinedTourByDestination(String destination)
   {
      for(int i = 0;i<predefinedTours.size();i++)
      {
         if(predefinedTours.get(i).getDestination().equals(destination))
         return predefinedTours.get(i);
      }
      return null;
   }
   /**
    * adds tour
    * @param tour
    */
   public void add(PredefinedTour tour)
   {
      predefinedTours.add(tour);
   }
   /**
    * 
    * @param date
    * @return PredefinedTourList
    */
   public PredefinedTourList getAllToursOnStartDate(DateTime date)
   {
      PredefinedTourList a = new PredefinedTourList();
      for(int i = 0;i<predefinedTours.size();i++)
      {
         if(predefinedTours.get(i).getDateInterval().getStartDate().isSameDate(date))
         {
            a.add(predefinedTours.get(i));
         }
      }
      return a;
   }
   /**
    * gets all tour on end date
    * @param date
    * @return PredefinedTourList
    */
   public PredefinedTourList getAllToursOnEndDate(DateTime date)
   {
      PredefinedTourList a = new PredefinedTourList();
      for(int i = 0;i<predefinedTours.size();i++)
      {
         if(predefinedTours.get(i).getDateInterval().getEndDate().isSameDate(date))
         {
            a.add(predefinedTours.get(i));
         }
      }
      return a;
   }
   /**
    * removes tour at index
    * @param index
    */
   public void remove(int index)
   {
      predefinedTours.remove(index);
   }
   /**
    * sets tour at index
    * @param index
    * @param tour
    */
   public void set(int index, PredefinedTour tour)
   {
      predefinedTours.set(index, tour);
   }
   /**
    * gets tour at index
    * @param index
    * @return tour
    */
   public PredefinedTour get(int index)
   {
      return predefinedTours.get(index);
   }
   /**
    * 
    * @return ArrayList<PredefinedTour>
    */
   
   public ArrayList<PredefinedTour> getList()
   {
      return predefinedTours;
   }
     /**
      * toString method
      */
   public String toString()
   {
      String t ="";
      for(int i =0; i<predefinedTours.size();i++)
      {
          t +=(i+1)+": "+predefinedTours.get(i);
          if(i<predefinedTours.size()-1);
             t+="\n";
      }
      return t;
   }
   /**
    * 
    * @return size of arraylist
    */
   public int size()
   {
     return predefinedTours.size();
   }
   /**
    * gets tour by destination and date
    * @param destination
    * @param date
    * @return tour
    */
   public PredefinedTour getPredefinedToursByDestenationAndDate(String destination, DateTime date)
   {
      for(int i = 0;i<predefinedTours.size();i++)
      {
         if(predefinedTours.get(i).getDestination().equals(destination)&&predefinedTours.get(i).getDateInterval().getStartDate().isSameDate(date))
         {
            return predefinedTours.get(i);
         }
         
      }
      return null;
   }
   /**
    * gets tour by destination and number of seats
    * @param destination
    * @param numberOfSeats
    * @return tour
    */
public PredefinedTourList getPredefinedToursByDestenationAndSeats(String destination, int numberOfSeats)
{
   PredefinedTourList a = new PredefinedTourList();
   for(int i = 0; i<predefinedTours.size();i++)
   {
      if(predefinedTours.get(i).getDestination().equals(destination)&&predefinedTours.get(i).getAvailbleSeats()>=numberOfSeats)
      {
         a.add(predefinedTours.get(i));
      }
   }
   return a;
}
/**
 * adds bus stop
 * @param tour
 * @param stop
 */
   public void addBusStop(PredefinedTour tour,BusStop stop)
   {
     for(int i=0;i<predefinedTours.size();i++)
     {
        if(predefinedTours.get(i).equals(tour))
        {
           System.out.println(get(i));
          predefinedTours.get(i).addBusStop(stop);
        }
     }
   }
   /**
    * gets all predefined tours by chauffeur name
    * @param name
    * @return tours
    */
   public PredefinedTourList getAllPredefinedTourByChauffeurName(String name)
   {
      PredefinedTourList a = new PredefinedTourList();
      for (int i = 0; i < predefinedTours.size(); i++)
      {
         if (predefinedTours.get(i).getChauffeur().getName().equals(name))
         {
            a.add(predefinedTours.get(i));
         }
      }
      return a;
   }
   /***
    * gets all predefined tours by destination
    * @param destination
    * @return tours
    */
   public PredefinedTourList getAllPredefinedTourByDestination(String destination)
   {
      PredefinedTourList a = new PredefinedTourList();
      for (int i = 0; i < predefinedTours.size(); i++)
      {
         if (predefinedTours.get(i).getDestination().equals(destination))
            a.add(predefinedTours.get(i)); 
      }
      return a;
   }
   
   
      
   

}
