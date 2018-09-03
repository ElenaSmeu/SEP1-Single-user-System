package Model;
import java.util.*;
import java.io.Serializable;

/**
 * Class that represents a Passenger list
 * @author Tina Petkova
 */
public class PassengerList implements Serializable
{
   private ArrayList<Passenger> passengers;

   /**
    * No argument constructor. It initialise a list.
    */
   public PassengerList()
   {
      this.passengers = new ArrayList<>();
   }

   /**
    * Setter that adds new passengers to the list
    * 
    * @param passenger
    */
   public void addPassenger(Passenger passenger)
   {
      passengers.add(passenger);
   }

   /**
    * Setter that removes passengers from the list by given name and address
    * 
    * @param name
    * @param address
    */
   public void removePassenger(String name)
   {
      for (int i = 0; i < passengers.size(); i++)
      {
         if (passengers.get(i).getName().equals(name)
              )
         {
            this.passengers.remove(i);
         }

      }

   }
   public ArrayList<Passenger>  getPassengerList()
   {
	   return passengers;
   }

   /**
    * ToString method that returns all the information for all the passengers in
    * the list.
    */
   public String toString()
   {
      String s = "";
      for (int i = 0; i < passengers.size(); i++)
      {
         s += passengers.get(i)+"\n";
      }
      return s;
   }
   /**
    * 
    * @return size of list
    */
   public int getSize()
   {
	   return passengers.size();
   }
   
   
   
}
