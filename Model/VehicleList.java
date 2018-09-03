package Model;

import java.util.ArrayList;
import java.io.Serializable;
/**
 * Class that represents a Vehicle List
 * @author Elena Smeu
 *
 */
public class VehicleList implements Serializable
{
   private ArrayList<Vehicle> vehicles;
   /**
    * 0 argument constructor that initializes a new array list
    */
   public VehicleList()
   {
      this.vehicles = new ArrayList<>();
   }
   /**
    * Adds vehicle
    * @param newVehicle
    */

   public void addVehicle(Vehicle newVehicle)
   {
      vehicles.add(newVehicle);
   }
   /**
    * Removes vehicle by regnumber
    * @param regNumber
    */
   public void removeVehicle(String regNumber)
   {
      for (int i = 0; i < vehicles.size(); i++)
      {
         if (vehicles.get(i).getRegNumber().equals(regNumber))
         {
            vehicles.remove(i);
            break;
         }
      }
   }
   /**
    * gets number of available vehiclees
    * @return number
    */
   public int getNumberOfAvaiableVehicles()
   {
      int x = 0;
      for (int i = 0; i < vehicles.size(); i++)
      {
         if (vehicles.get(i).getAvaiability())
            x++;
      }
      return x;
   }
   /**
    * Gets first availablevehicle
    * @return Vehicle
    */
   public Vehicle getFirstAvaiableVehicle()
   {
      return getAllAvaiableVehicles().get(0);
   }
   /**
    * Gets all available vehicle
    * @return ArrayList<Vehicle>
    */
   public ArrayList<Vehicle> getAllAvaiableVehicles()
   {
      ArrayList<Vehicle> other = new ArrayList<>();
      for (int i = 0; i < vehicles.size(); i++)
      {
         if (vehicles.get(i).getAvaiability())
         {
            other.add(vehicles.get(i));
         }
      }
      return other;
   }
   /**
    * Gets all availableMiniBuses
    * @return ArrayList<Vehicle>
    */
   public ArrayList<Vehicle> getAllAvaiableMiniBuses()
   {
      ArrayList<Vehicle> other = new ArrayList<>();
      for (int i = 0; i < vehicles.size(); i++)
      {
         if (vehicles.get(i).getType().equals("MiniBus"))
         {
            other.add(vehicles.get(i));
         }
      }
      return other;

   }
   /**
    * Gets all available buses
    * @return ArrayList<Vehicle>
    */
   public ArrayList<Vehicle> getAllAvaiableBuses()
   {
      ArrayList<Vehicle> other = new ArrayList<>();
      for (int i = 0; i < vehicles.size(); i++)
      {
         if (vehicles.get(i).getType().equals("Bus"))
            other.add(vehicles.get(i));
      }
      return other;

   }
   /**
    * Gets all available party buses
    * @return ArrayList<Vehicle>
    */
   public ArrayList<Vehicle> getAllAvaiablePartyBuses()
   {
      ArrayList<Vehicle> other = new ArrayList<>();
      for (int i = 0; i < vehicles.size(); i++)
      {
         if (vehicles.get(i).getType().equals("PartyBus"))
            other.add(vehicles.get(i));
      }
      return other;
   }
   /**
    * Gets Vehicle at idex
    * @param index
    * @return Vehicle
    */
   public Vehicle get(int index)
   {
      return vehicles.get(index);
   }
   /**
    * Gets number of vehicles in arraylist
    * @return number
    */
   public int getNumberOfVehicles()
   {
      int counter = 0;
      for (int i = 0; i < vehicles.size(); i++)
      {
         counter++;
      }
      return counter;
   }
   /**
    * Gets Vehicle for combobox
    * @return String[] 
    */
   public String[] getVehiclesForComboBox()
   {
      String[] all = new String[vehicles.size()];
      for (int i = 0; i < vehicles.size(); i++)
      {
         all[i] = vehicles.get(i).getRegNumber() + ", "
               + vehicles.get(i).getType();
      }
      return all;
   }
   /**
    * Gets vehicle by regnumber
    * @param regNumber
    * @return Vehicle
    */
   public Vehicle getVehicleByRegistrationNumber(String regNumber)
   {
      for(int i = 0;i<vehicles.size();i++)
      {
         if(regNumber.equals(vehicles.get(i).getRegNumber()))
         {
            return vehicles.get(i);
         }
      }
      return null;
   }
   /**
    * toString method
    */
   public String toString()
   {
      String all = "";
      for (int i = 0; i < vehicles.size(); i++)
      {
         all += vehicles.get(i).toString();
         all += "\n";
      }
      return all;
   }

}
