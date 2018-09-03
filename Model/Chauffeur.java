package Model;

import java.io.Serializable;

/**
 * Class that represents a Chauffeur
 * @author Nikolina Chalakova
 */
public class Chauffeur implements Serializable
{
   private String name;

   private int id;
   private String address;
   private boolean isAvailable;
   private boolean isFullTime;
   private String emailAddress;
   private String phoneNumber;
   private String preferences;

   /**
    * non argument constructer that sets all instance variables to null or 0
    */
   public Chauffeur()
   {
      this.name = null;
      this.id = 0;
      this.address = null;
      this.isAvailable = true;
      this.isFullTime = true;
      this.emailAddress = null;
      this.phoneNumber = null;
      this.preferences = null;
   }

   /**
    * 8 argument constructor
    * 
    * @param name
    * @param id
    * @param address
    * @param isAvailable
    * @param isFullTime
    * @param emailAddress
    * @param phoneNumber
    * @param preferences
    */
   public Chauffeur(String name, int id, String address, boolean isAvailable,
         boolean isFullTime, String emailAddress, String phoneNumber,
         String preferences)
   {
      this.name = name;
      this.id = id;
      this.address = address;
      this.isAvailable = isAvailable;
      this.isFullTime = isFullTime;
      this.emailAddress = emailAddress;
      this.phoneNumber = phoneNumber;
      this.preferences = preferences;
   }

   /**
    * @return emailaddress
    */
   public String getEmailAddress()
   {
      return emailAddress;
   }

   /**
    * @param emailAddress
    *           sets email
    */
   public void setEmailAddress(String emailAddress)
   {
      this.emailAddress = emailAddress;
   }

   /**
    * @return address
    */
   public String getAddress()
   {
      return address;
   }

   /**
    * @return phone number
    */
   public String getPhoneNumber()
   {
      return phoneNumber;
   }

   /**
    * @return preferences
    */
   public String getPreferences()
   {
      return preferences;
   }

   /**
    * @return boolean isavailable
    */
   public boolean isAvailable()
   {
      return isAvailable;
   }

   /**
    * @param isAvailable
    *           sets availability
    */
   public void setAvailable(boolean isAvailable)
   {
      this.isAvailable = isAvailable;
   }

   /**
    * @return boolean if fulltime
    */
   public boolean isFullTime()
   {
      return isFullTime;
   }

   /**
    * sets boolean fulltime
    * 
    * @param isFullTime
    */
   public void setFullTime(boolean isFullTime)
   {
      this.isFullTime = isFullTime;
   }

   /**
    * sets name
    * 
    * @param newName
    */
   public void setName(String newName)
   {
      this.name = newName;
   }

   /**
    * Sets address
    * 
    * @param address
    */
   public void setAddress(String address)
   {
      this.address = address;
   }

   /**
    * Sets full time value
    * 
    * @param value
    */
   public void setIsFullTime(boolean value)
   {
      this.isFullTime = value;
   }

   /**
    * Sets preferences
    * 
    * @param preferences
    */
   public void setPreferences(String preferences)
   {
      this.preferences = preferences;
   }

   /**
    * Sets phonenumber
    * 
    * @param phoneNumber
    */
   public void setPhoneNumber(String phoneNumber)
   {
      this.phoneNumber = phoneNumber;
   }

   /**
    * Sets availability
    * 
    * @param value
    */
   public void setAvailability(boolean value)
   {
      this.isAvailable = value;
   }

   /**
    * Sets id
    * 
    * @param id
    */
   public void setID(int id)
   {
      if (id > 10000 && id < 99999)
      {
         this.id = id;
      }
      else
      {
         this.id = -1;
      }
   }

   /**
    * @return name
    */
   public String getName()
   {
      return this.name;
   }

   /**
    * @return id
    */
   public int getID()
   {
      return this.id;
   }

   /**
    * @return isavailable
    */
   public boolean available()
   {
      return isAvailable;
   }

   /**
    * @return isfulltime
    */
   public boolean fullTime()
   {
      return isFullTime;
   }

   /**
    * Equals method
    * 
    * @param object
    * @return boolean if equals
    */
   public boolean equals(Object obj)
   {
      if (!(obj instanceof Chauffeur))
         return false;
      Chauffeur other = (Chauffeur) obj;
      return this.name.equals(other.name) && this.id == other.id
            && this.address.equals(other.address)
            && this.isAvailable == other.isAvailable
            && this.isFullTime == other.isFullTime
            && this.emailAddress.equals(other.emailAddress)
            && this.phoneNumber.equals(other.phoneNumber)
            && this.preferences.equals(other.preferences);
   }

   /**
    * toString
    * 
    * @return String containing information
    */
   public String toString()
   {
      return this.name + "; " + this.id + "; " + this.address + "; "
            + this.isAvailable + "; " + this.isFullTime + "; "
            + this.emailAddress + "; " + this.phoneNumber + "; "
            + this.preferences + "; \n";
   }

   /**
    * Copys chauffeur
    * 
    * @return Chauffeur
    */
   public Chauffeur copy()
   {
      Chauffeur other = new Chauffeur(name, id, address, isAvailable,
            isFullTime, emailAddress, phoneNumber, preferences);
      return other;
   }
}
