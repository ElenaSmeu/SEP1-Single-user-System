package Model;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * Class that represents a Reservation
 * 
 * @author Nikolina Chalakova
 *
 */
public class Reservation implements Serializable
{

   private int number;
   private Customer customer;
   private PassengerList passengers;
   private Tour tour;
   private ArrayList<Item> item;
   private double priceForItem;
   private double priceForTour;
   /**
    *  A no argument Constructor that initializes all instance variables and sets them
    *  to null, new lists and 0
    */

   public Reservation()
   {
      this.customer = null;
      this.passengers = new PassengerList();
      this.tour = null;
      this.number = 0;
      this.item=new ArrayList<>();
      this.priceForItem=0;
   }
   /**
    * 
    * @return number
    */
   public int getNumber()
   {
      return this.number;
   }
   /** Sets number
    * @param number
    */
   public void setNumber(int number)
   {
      this.number = number;
   }
   /**
    * Sets Tour
    * @param tour
    */
   public void setTour(Tour tour)
   {
      this.tour = tour;
   }
   /**
    * Sets Customer
    * @param customer
    */
   public void setCustomer(Customer customer)
   {
      this.customer=customer;
   }
   
   /**
    * Sets Items
    * @param items
    */
   public void setItems(ArrayList<Item> items){
	   this.item=items;
   }
   /**
    * Adds Item
    * @param newItem
    */
   public void addItem(Item newItem)
   {
	   item.add(newItem);
   }
   /**
    * Removes item at index
    * @param index
    */
   public void removeItem(int index)
   {
	   item.remove(index);
   }
   /**
    * 
    * @return allprices
    */
   public double getAllPrices()
   {
      int sum=0;
	   for(int i=0;i<item.size();i++)
	   {
		   sum+=item.get(i).getPrice()*item.get(i).getAmount();
	   }
	   sum+=priceForTour;
	return sum;
   }
   /**
    * sets price on item found by name
    * @param name
    * @param price
    */
   public void setItemPrice(String name, double price)
   {
	   for(int i=0;i<item.size();i++)
	   {
		  if(item.get(i).getName().equals(name))item.get(i).setPrice(price);
	   }
   }
   /**
    * Sets price for item
    * @param price
    */
   public void setPriceForItem(double price)
   {
	   this.priceForItem=price;
   }
   /**
    *  
    * @return price for tour
    */
   public double getPriceForTour()
   {
	   return this.priceForTour;
   }
   /**
    * Sets reservation to reservation given as argument
    * @param reservation
    */
   public void setReservation(Reservation reservation)
   {
      this.customer=reservation.getCustomer();
      this.item = reservation.getItems();
      this.number=reservation.getNumber();
      this.tour=reservation.getTour();
      this.passengers=reservation.getPassengerList();
      this.priceForItem=reservation.getAllPrices();
      this.priceForTour=reservation.priceForTour;
   }
   /**
    * Sets price for tour
    * @param price
    */
   public void setPriceForTour(double price)
   {
	   this.priceForTour=price;
   }
   /**
    * 
    * @param index
    * @return price at index
    */
   public double getPriceForItem(int index)
   {
	   return item.get(index).getPrice();
   }
   /**
    * sets itemlist
    * @param list
    */
   public void setItemList(ArrayList<Item> list)
   {
      this.item=list;
   }
   /**
    * 
    * @return Customer name
    */
   public String getCustomerName()
   {
      return this.customer.getName();
   }
   /**
    * 
    * @return Company name
    */
   public String getCustomerCompanyName()
   {
      return this.customer.getCompanyName();
   }
   /**
    * Adds customer to reservation
    * @param customer
    */
   public void addCustomer(Customer customer)
   {
      this.customer = customer;
   }
   /**
    * 
    * @return Customer
    */
   public Customer getCustomer()
   {
      return customer;
   }
   /**
    * 
    * @return Chauffeur
    */
   public Chauffeur getChauffeur()
   {
      return this.tour.getChauffeur();
   }
   /**
    * Sets Chauffeur
    * @param chauffeur
    */
   
   public void setChauffeur(Chauffeur chauffeur)
   {
	   this.tour.setChauffeur(chauffeur);
   }
   /**
    * Sets PassengerList
    * @param passengers
    */
   public void setPassengerList(PassengerList passengers)
   {
      this.passengers = passengers;
   }
   /**
    * 
    * @return passengerlist
    */
   public PassengerList getPassengerList()
   {
	   return passengers;
   }
   /**
    * 
    * @return tour
    */
   public Tour getTour()
   {
	   return tour;
   }
   /**
    * 
    * @return vehicle
    */
   
   public Vehicle getVehicle()
   {
  
   return	 getTour().getVehicle();
   }
   /**
    * Sets Vehicle
    * @param vehicle
    */
   public void setVehicle(Vehicle vehicle)
   {
	   this.tour.setVehicle(vehicle);
   }
   /**
    * 
    * @return list with items
    */
   public ArrayList<Item> getItems()
   {
	   return item;
   }
   /**
    * Adds passenger
    * @param passenger
    */
   public void addPassenger(Passenger passenger)
   {
	  passengers.addPassenger(passenger);
   }
   /**
    * 
    * @return amount of item
    */
   public int getItemsAmount()
   {int amounts=0;
	  for(int i=0;i<item.size();i++)
	  {
		  amounts+=item.get(i).getAmount();
	  }
	  return amounts;
   }
   /**
    * toString method
    */
   public String toString()
   {
	   String a ="";
	  a+="Regnr:"+number+": "+customer.toString()+" "+tour+" "+item+" "+priceForItem+priceForTour+";";
	   return a;
   }
}
