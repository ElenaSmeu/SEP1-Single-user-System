package Model;
import java.io.Serializable;

/**
 * Class that represents a Passenger
 * @author Tina Petkova
 */
public class Passenger implements Serializable
{
   private String name;
   private int age;
  

   /**
    * Five-argument constructor that sets the instance variables.
    * 
    * @param name
    * @param address
    * @param day
    * @param month
    * @param year
    */
   public Passenger(String name, int age)
   {
      this.name = name;
      this.age= age;
     
   }

   /**
    * Getter for the name.
    * 
    * @return the name
    */
   public String getName()
   {
      return this.name;
   }

   /**
    * Setter for the name
    * 
    * @param name
    */
   public void setName(String name)
   {
      this.name = name;
   }

  public int getAge()
  {
	  return this.age;
  }
  
  public void setAge(int age)
  {
	  this.age=age;
  }
   

  
   
   /**
    * ToString method that returns all the information for the object.
    */
   public String toString()
   {
      String s = getName() + ":" + age +";";
      return s;
   }

}
