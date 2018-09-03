package Model;

import java.io.Serializable;

/**
 * Class that represents an Item
 * @author Elena Smeu
 */
public class Item implements Serializable
{
   private String name;
   private double price;
   private int amount;
   /**
    * No argument constructor that sets name to null,price to 0 and amount to 0;
    */
   public Item()
   {
      this.name = null;
      this.price = 0;
      this.amount = 0;
   }
   /**
    * 
    * @param price
    */
   public void setPrice(double price)
   {
      this.price = price;
   }
   /**
    * setsname
    * @param name
    */
   public void setName(String name)
   {
      this.name = name;
   }
   /**
    * 
    * @return name
    */
   public String getName()
   {
      return name;
   }
   /**
    * 
    * @return price
    */
   public double getPrice()
   {
      return price;
   }
   /**
    * sets amount
    * @param amount
    */
   public void setAmount(int amount)
   {
      this.amount = amount;
   }
   /**
    * 
    * @return amount
    */
   public int getAmount()
   {
      return amount;
   }
   /**
    * toString method
    */
   public String toString()
   {
      String all = "";
      all += name;
      all += ":";
      all += price + ";";
      return all;
   }
}
