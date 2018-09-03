package Model;
import java.io.Serializable;
/**
 * A class that represents a customer.
 * 
 * @author Tina Petkova
 */
public class Customer implements Serializable
{
   private String name;
   private String address;
   private String phoneNumber;
   private String emailAddress;
   private int counter;
   private String companyName;

   // constructor for company or school
   /**
    * A five argument constructor. It initialises the information of a company
    * or a school.
    * 
    * @param name
    * @param address
    * @param phoneNumber
    * @param emailAddress
    * @param companyName
    */
   public Customer(String name, String address, String phoneNumber,
         String emailAddress, String companyName)
   {
      this.name = name;
      this.phoneNumber = phoneNumber;
      this.address = address;
      this.emailAddress = emailAddress;
      this.companyName = companyName;
      this.counter = 0;
   }
  
   // constructor for individuals
   /**
    * A four argument constructor. It initialises the information of an
    * individual.
    * 
    * @param name
    * @param address
    * @param phoneNumber
    * @param emailAddress
    */
   public Customer(String name, String address, String phoneNumber)
   {
      this.name = name;
      this.phoneNumber = phoneNumber;
      this.address = address;
      this.emailAddress = null;
      this.companyName = null;
      this.counter = 0;
   }
   
   


   /**
    * Setter for the name.
    * 
    * @param name
    */
   public void setName(String name)
   {
      this.name = name;
   }

   /**
    * Getter for the name.
    * 
    * @return name
    */
   public String getName()
   {
      return this.name;
   }

   /**
    * Getter for the phone number.
    * 
    * @return string with the phone number.
    */
   public String getPhoneNumber()
   {
      return this.phoneNumber;
   }

   /**
    * Setter for the phone number.
    * 
    * @param phoneNumber
    */
   public void setPhoneNumber(String phoneNumber)
   {
      this.phoneNumber = phoneNumber;
   }

   /**
    * Getter for the address.
    * 
    * @return string with the address
    */
   public String getAddress()
   {
      return this.address;
   }

   /**
    * Setter for the address.
    * 
    * @param address
    */
   public void setAddress(String address)
   {
      this.address = address;
   }

   /**
    * Setter for the e-mail address.
    * 
    * @param emailAddress
    */
   public void setEmailAddress(String emailAddress)
   {
      this.emailAddress = emailAddress;
   }

   /**
    * Getter for the e-mail address.
    * 
    * @return string with the e-mail address
    */
   public String getEmailAddress()
   {
      return this.emailAddress;
   }

   /**
    * Getter for the name of the company or school
    * 
    * @return name of the company/school
    */
   public String getCompanyName()
   {
      return companyName;
   }

   /**
    * Setter for the name of the company/school
    * 
    * @param companyName
    */
   public void setCompanyName(String companyName)
   {
      this.companyName = companyName;
   }

   /**
    * Boolean method equals to check if the object in the arguments is the same.
    */
   public boolean equals(Object obj)
   {
      if (!(obj instanceof Customer))
         return false;
      Customer other = (Customer) obj;
      if(emailAddress==null && companyName==null)
      {
    	  return this.name.equals(other.name)
  	            && this.phoneNumber.equals(other.phoneNumber)
  	            && this.address.equals(other.address)
  	            && this.emailAddress==(other.emailAddress)
  	            && this.counter == other.counter
  	            && this.companyName==(other.companyName);   
      }
      else if(emailAddress==null)
      {
    	  return this.name.equals(other.name)
  	            && this.phoneNumber.equals(other.phoneNumber)
  	            && this.address.equals(other.address)
  	            && this.emailAddress.equals(other.emailAddress)
  	            && this.counter == other.counter
  	            && this.companyName.equals(other.companyName);   
      }
      else if(companyName==null)
      {
    	  return this.name.equals(other.name)
    	            && this.phoneNumber.equals(other.phoneNumber)
    	            && this.address.equals(other.address)
    	            && this.emailAddress==(other.emailAddress)
    	            && this.counter == other.counter
    	            && this.companyName==(other.companyName);
      }
      else{
      return this.name.equals(other.name)
            && this.phoneNumber.equals(other.phoneNumber)
            && this.address.equals(other.address)
            && this.emailAddress.equals(other.emailAddress)
            && this.counter == other.counter
            && this.companyName.equals(other.companyName);
   }}

   /**
    * Copy method
    * 
    * @return copy of the customer object.
    */
   public Customer copy()
   {
      Customer c = new Customer(name, address, phoneNumber, emailAddress,
            companyName);
      return c;
   }

   /**
    * Getter for the counter of reservations of a customer.
    * 
    * @return integer with the number of made reservations.
    */
   public int getCounter()
   {
      return this.counter;
   }

   /**
    * Setter for the counter. It increases the counter by one every time.
    */
   public void increaseCounterByOne()
   {
      this.counter++;
   }

   /**
    * Boolean method for checking if the customer is frequent one.
    * 
    * @return true or false depending on weather the customer is a frequent one.
    */
   public boolean isFrequent()
   {
      if (counter >= 2)
      {
         return true;
      }
      return false;
   }

   /**
    * Boolean method checking if the customer is a company or a school
    * 
    * @return true or false depending on weather the customer is a school or a
    *         company.
    */
   public boolean isCompany()
   {
      if (companyName == null)
      {
         return false;
      }
      return true;
   }

   /**
    * toString method that returns all information of the customer.
    */
   public String toString()
   {
      String s = "Name:" + name + " Address:" + address + " Phone number:"
            + phoneNumber;
      if (emailAddress != null)
      {
         s += " Phone number:" + phoneNumber;
      }
      if (companyName != null)
      {
         s += " Company:" + companyName;
      }
      if (isFrequent())
      {
         s += " Frequent customer";
      }
      return s;
   }
}
