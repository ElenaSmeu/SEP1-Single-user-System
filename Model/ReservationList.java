package Model;

import java.util.ArrayList;
import java.io.Serializable;

/**
 * Class that represents a Reservation List
 * @author Nikolina Chalakova
 */
public class ReservationList implements Serializable
{

   private ArrayList<Reservation> reservations;

   /**
    * No argument constructor that initialize a new reservation array list
    */
   public ReservationList()
   {
      this.reservations = new ArrayList<>();
   }

   /**
    * @param destination
    * @param date
    * @return tour found by destination and dateinterval
    */
   public Tour getTourByDestinationAndDate(String destination, DateTime date)
   {
      for (int i = 0; i < reservations.size(); i++)
      {
         if (reservations.get(i).getTour().getDestination().equals(destination)
               && reservations.get(i).getTour().getDateInterval()
                     .getStartDate().equals(date))
         {
            return reservations.get(i).getTour();
         }
      }
      return null;
   }

   /**
    * Sets reservation that has resnr as reservation number to reservation given
    * as argument
    * 
    * @param resnr
    * @param reservation
    */
   public void setReservationByNumber(int resnr, Reservation reservation)
   {
      for (int i = 0; i < reservations.size(); i++)
      {
         if (resnr == reservations.get(i).getNumber())
         {
            reservations.set(i, reservation);
            break;
         }
      }
   }

   /**
    * @return number of reservations in reservationlist
    */
   public int size()
   {
      return reservations.size();
   }
   /**
    * Adds Reservation
    * @param reservation
    */
   public void addReservation(Reservation reservation)
   {
      this.reservations.add(reservation);
      if (reservations.size() == 0)
      {
         reservation.setNumber(0);
      }
      else
      {
         reservation.setNumber(reservations.get(reservations.size() - 1)
               .getNumber() + 1);
      }
   }
   /**
    * 
    * @param date
    * @return reservationlist with all found reservations
    */
   public ReservationList getAllReservationsByStartDate(DateTime date)
   {
      ReservationList a = new ReservationList();
      for (int i = 0; i < reservations.size(); i++)
      {
         if (date.isSameDate(reservations.get(i).getTour().getDateInterval()
               .getStartDate()))
            a.addReservation(reservations.get(i));
      }
      return a;
   }
   /**
    * Gets all Reservations by customers name
    * @param name
    * @return reservations
    */
   public ReservationList getAllReservationsByCustomerName(String name)
   {
      ReservationList res = new ReservationList();
      for (int i = 0; i < reservations.size(); i++)
      {
         if (reservations.get(i).getCustomer().getName().equals(name))
         {
            res.addReservation(reservations.get(i));
         }

      }
      return res;
   }
   /**
    * Gets all reservations by enddate
    * @param date
    * @return ReservationList
    */
   public ReservationList getAllReservationsByEndDate(DateTime date)
   {
      ReservationList a = new ReservationList();
      for (int i = 0; i < reservations.size(); i++)
      {
         if (date.isSameDate(reservations.get(i).getTour().getDateInterval()
               .getEndDate()))
            a.addReservation(reservations.get(i));
      }
      return a;
   }
   /**
    * Gets reservation by reservation number
    * @param number
    * @return Reservation
    */
   public Reservation getReservationByReservationNumber(int number)
   {
      for (int i = 0; i < reservations.size(); i++)
      {
         if (number == reservations.get(i).getNumber())
            return reservations.get(i);
      }
      return null;
   }
   /**
    * removes reservation by reservation number
    * @param number
    */
   public void removeReservation(int number)
   {
      for (int i = 0; i < reservations.size(); i++)
      {
         if (reservations.get(i).getNumber() == number)
         {
            reservations.remove(i);
         }
      }
   }
   /**
    * Gets reservation by destination
    * @param destination
    * @return Reservation
    */
   public Reservation getReservationByDestination(String destination)
   {
      for (int i = 0; i < reservations.size(); i++)
      {
         if (reservations.get(i).getTour().getDestination().equals(destination))
            return reservations.get(i);
      }
      return null;
   }
   /**
    * Gets reservation by Chauffeur Name
    * @param name
    * @return Chauffeur
    */
   public Reservation getReservationByChauffeurName(String name)
   {
      for (int i = 0; i < reservations.size(); i++)
      {
         if (reservations.get(i).getChauffeur().getName().equals(name))
            return reservations.get(i);
      }
      return null;
   }
   /**
    * Gets all reservations by customers phone number
    * @param phone
    * @return Reservation[]
    */
   public Reservation[] getAllReservationsByCustomerPhone(String phone)
   {
      int counter = 0;
      for (int i = 0; i < reservations.size(); i++)
      {
         if (reservations.get(i).getCustomer().getPhoneNumber().equals(phone))
         {
            counter++;
         }
      }

      Reservation[] customerRes = new Reservation[counter];
      int size = 0;
      for (int i = 0; i < reservations.size(); i++)
      {
         if (reservations.get(i).getCustomer().getPhoneNumber().equals(phone))
         {
            customerRes[size] = reservations.get(i);
            size++;
         }
      }
      return customerRes;
   }
   /**
    * Gets reservation by customer name
    * @param name
    * @return Reservation
    */
   public Reservation getReservationByCustomerName(String name)
   {
      for (int i = 0; i < reservations.size(); i++)
      {
         if (reservations.get(i).getCustomerName().equals(name))
         {
            return reservations.get(i);
         }
      }
      return null;
   }
   /**
    * Gets reservation by customers phonenumber
    * @param phoneNumber
    * @return Reservation
    */
   public Reservation getReservationByPhoneNumber(String phoneNumber)
   {
      for (int i = 0; i < reservations.size(); i++)
      {
         if (reservations.get(i).getCustomer().getPhoneNumber()
               .equals(phoneNumber))
         {
            return reservations.get(i);
         }
      }
      return null;
   }
   /**
    * 
    * @return number of reservations in reservationlist
    */
   public int getNumberOfReservations()
   {
      int counter = 0;
      for (int i = 0; i < reservations.size(); i++)
      {
         counter++;
      }
      return counter;
   }
   /**
    * 
    * @param index
    * @return Reservation at index
    */
   public Reservation get(int index)
   {
      return reservations.get(index);
   }
   /**
    * toString method
    */
   public String toString()
   {
      String a = "";
      for (int i = 0; i < reservations.size(); i++)
      {
         a += i + 1 + ": " + reservations.get(i).toString() + "\n";
      }
      return a;
   }
}