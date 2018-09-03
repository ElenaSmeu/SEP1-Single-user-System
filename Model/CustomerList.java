package Model;
import java.util.ArrayList;
import java.io.Serializable;

/**
 * Class that represents a Customer List
 * @author Tina Petkova
 */
public class CustomerList implements Serializable
{
   private ArrayList<Customer> customers;

   /**
    * No-argument constructor that creates an ArrayList.
    */
   public CustomerList()
   {
      this.customers = new ArrayList<>();
   }

   /**
    * Setter method for the customer list that adds new customers to the list.
    * 
    * @param customer
    */
   public void addCustomer(Customer customer)
   {
      customers.add(customer);
   }

   /**
    * Setter for the customer list that removes customers from the list by given
    * name and phone number.
    * 
    * @param customer
    */
   public void removeCustomer(String name, String phone)
   {
      for (int i = 0; i < customers.size(); i++)
      {
         if (customers.get(i).getName().equals(name)
               && customers.get(i).getPhoneNumber().equals(phone))
         {
            customers.remove(i);
         }

      }

   }

   /**
    * Method that returns a customer object from the list by given name and
    * phone number.
    * 
    * @param name
    * @param phone
    * @return customer
    */
   public Customer getCustomerByName(String name)
   {
      for (int i = 0; i < customers.size(); i++)
      {
         if (customers.get(i).getName().equals(name))
         {
            return this.customers.get(i);
         }
      }
      return null;
   }
   public Customer getCustomerByNumber(String number)
   {
      for(int i = 0;i < customers.size();i++)
      {
         if(customers.get(i).getPhoneNumber().equals(number))
         {
            return this.customers.get(i);
         }
      }
      return null;
   }

   /**
    * Method that returns a customer from the list by given address.
    * 
    * @param address
    * @return customer
    */
   public Customer getCustomerByAddress(String address)
   {
      for (int i = 0; i < customers.size(); i++)
      {
         if (customers.get(i).getAddress().equals(address))
         {
            return customers.get(i);
         }
      }
      return null;
   }

   /**
    * One-argument method that returns a customer by given companyName.
    * 
    * @param companyName
    * @return customer
    */
   public Customer getCustomerByCompanyName(String companyName)
   {
      for (int i = 0; i < customers.size(); i++)
      {
         if (customers.get(i).getCompanyName().equals(companyName))
         {
            return customers.get(i);
         }
      }
      return null;
   }

   /**
    * Method that returns an array with all frequent customers.
    * 
    * @return array with all frequent customers
    */
   public Customer[] getAllFrequentCustomers()
   {
      int count = 0;
      int j = 0;
      for (int i = 0; i < customers.size(); i++)
      {
         if (customers.get(i).isFrequent())
         {
            count++;
         }
      }
      Customer[] c = new Customer[count];
      for (int i = 0; i < customers.size(); i++)
      {
         if (customers.get(i).isFrequent())
         {
            c[j] = customers.get(i);
            j++;
         }
      }
      return c;
   }

   /**
    * Getter for the customer list.
    * 
    * @return list with all customers
    */
   public ArrayList<Customer> getCustomerList()
   {
      return customers;
   }

   /**
    * toString method returning all information of the customers in the list.
    */
   public String toString()
   {
      String s = "";
      for (int i = 0; i < customers.size(); i++)
      {
         s += customers.get(i);
      }
      return s;

   }

}
