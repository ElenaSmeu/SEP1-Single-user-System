package Model;


import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;

import Model.*;
import GUI.*;
/**
 * Class that represents a model manager
 * @author Nikolina Chalakova
 *
 */
public class VIABus implements Serializable
{
   private VehicleList vehicles;
   private CustomerList customers;
   private ReservationList reservations;
   private ChauffeurList chauffeurs;
   private FileVIABus file;
   private PredefinedTourList predefinedTourList;
   /**
    * A 0 argument constructor that initializes a new FileVIABus and the uses that class to read from a bin file
    * if nothing is found then it will initialize new lists
    */
   public VIABus() 
   { 
      try{
      this.file = new FileVIABus();
      this.chauffeurs = file.readVIABusFile().chauffeurs;
      this.customers = file.readVIABusFile().customers;
      this.predefinedTourList = file.readVIABusFile().predefinedTourList;
      this.vehicles = file.readVIABusFile().vehicles;
      this.reservations = file.readVIABusFile().reservations;
      }
      catch(Exception e)
      {
         this.chauffeurs = new ChauffeurList();
         this.customers = new CustomerList();
         this.predefinedTourList = new PredefinedTourList();
         this.vehicles = new VehicleList();
         this.reservations = new ReservationList();
      }try{
      file.writeVIABusToFile(this);
      }
      catch(Exception e){
         
      }
   }
   /**
    * Adds reservation
    * @param reservation
    */
   
   public void addReservation(Reservation reservation)
   {
      reservations.addReservation(reservation);
   }
   /**
    * Deletes reservation by reservation number
    * @param number
    */
   public void deleteReservation(int number)
   {
      for(int i=0; i<reservations.getNumberOfReservations(); i++)
      {
         if(reservations.get(i).getNumber() == number)
         {
            reservations.removeReservation(i);
            break;
         }
      }
   }
   /**
    * Adds Vehicle
    * @param vehicle
    */
   public void addVehicle(Vehicle vehicle)
   {
      vehicles.addVehicle(vehicle);
   }
   /**
    * Deletes vehicle by regNumber
    * @param regNumber
    */
   public void deleteVehicle(String regNumber)
   {
      vehicles.removeVehicle(regNumber);
   }
   /**
    * Adds chauffeur to chauffeur list
    * @param chauffeur
    */
   public void addChauffeur(Chauffeur chauffeur)
   {
      chauffeurs.addChauffeur(chauffeur);
   }
   /**
    * Removes chauffeur found by name
    * @param name
    */
   
   public void removeChauffeur(String name)
   {
      for(int i=0; i<chauffeurs.getNumberOfChauffeurs(); i++)
      {
         if(chauffeurs.get(i).getName().equals(name))
         {
            chauffeurs.removeChauffeurByIndex(i);
            break;
         }
      }
   }
   /**
    * Gets CustomerList
    * @return CustomerList
    */
   public CustomerList getCustomerList()
   {
      return customers;
   }
   /**
    * Gets VehicleList 
    * @return VehicleList
    */
   public VehicleList getVehicleList()
   {
      return vehicles;
   }
   /**
    * Gets ReservationList
    * @return ReservationList
    */
   public ReservationList getReservationList()
   {
      return reservations;
   }
   /**
    * Gets ChauffeurList
    * @return ChauffeurList
    */
   public ChauffeurList getChauffeurList()
   {
      return chauffeurs;
   }
   /**
    * Saves VIABus to bin file in FileVIABUS class
    */
   public void save() 
   {
      this.file.writeVIABusToFile(this);
   }
   /**
    * Gets PredefinedTourList
    * @return PredefinedTourList
    */
   public PredefinedTourList getPredefinedTourList()
   {
      return predefinedTourList;
   }
   /**
    * Adds tour to PredefinedTourList
    * @param tour
    */
   public void addPredefinedTour(PredefinedTour tour)
   {
      predefinedTourList.add(tour);
   }
   /**
    * Gets PredefinedTour at index in PredefinedTourList
    * @param index
    * @return PredefinedTour
    */
   public PredefinedTour getPredefinedTourAtIndex(int index)
   {
      return predefinedTourList.get(index);
   }
   public void setPredefinedTourAtIndex(int index, PredefinedTour tour)
   {
      predefinedTourList.set(index, tour);
   }
   
}
