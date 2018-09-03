package Model;

import java.util.ArrayList;
import java.io.Serializable;

/**
 * Class that represents a Chauffer List
 * @author Niki Chalakova
 *
 */
public class ChauffeurList implements Serializable
{
   private ArrayList<Chauffeur> chauffeurs;
   /** 0 argument constructor that makes a new list 
    * 
    */
   public ChauffeurList()
   {
      chauffeurs = new ArrayList<>();
   }
   /**
    * 
    * @return amount of chauffeurs in the list
    */
   public int getNumberOfChauffeurs()
   {
      return chauffeurs.size();
   }
   /**
    * 
    * @param chauffeur 
    */
   public void addChauffeur(Chauffeur chauffeur)
   {
      chauffeurs.add(chauffeur);
   }
   /**
    * 
    * @param index removes chauffeur at index in arraylist
    */
   public void removeChauffeurByIndex(int index)
   {
      for (int i = 0; i < chauffeurs.size(); i++)
      {
         if (i == index)
         {
            chauffeurs.remove(i);
            break;
         }
      }
   }
   /**
    * removes chauffuer by name
    * @param name
    */
   public void removeChauffeurByName(String name)
   {
      for (int i = 0; i < chauffeurs.size(); i++)
      {
         if (chauffeurs.get(i).getName().equals(name))
         {
            chauffeurs.remove(i);
            break;
         }
      }
   }
   /**
    * remove chauffeur by id
    * @param id
    */
   public void removeChauffeurByID(int id)
   {
      for (int i = 0; i < chauffeurs.size(); i++)
      {
         if (chauffeurs.get(i).getID() == id)
         {
            chauffeurs.remove(i);
            break;
         }
      }
   }
   /**
    * removes chauffeur by addresss
    * @param address
    */
   public void removeChauffeurByAddress(String address)
   {
      for (int i = 0; i < chauffeurs.size(); i++)
      {
         if (chauffeurs.get(i).getAddress().equals(address))
         {
            chauffeurs.remove(i);
            break;
         }
      }
   }
   /**
    * removes chauffeur by phonenumber
    * 
    * @param number
    */
   public void removeChauffeurByPhoneNumber(String number)
   {
      for (int i = 0; i < chauffeurs.size(); i++)
      {
         if (chauffeurs.get(i).getAddress().equals(number))
         {
            chauffeurs.remove(i);
            break;
         }
      }
   }
   /**
    * removes chauffeur by emailaddress
    * @param email
    */
   public void removeChauffeurByEmailAddress(String email)
   {
      for (int i = 0; i < chauffeurs.size(); i++)
      {
         if (chauffeurs.get(i).getEmailAddress().equals(email))
         {
            chauffeurs.remove(i);
            break;
         }
      }
   }
   /**
    * returns chauffeur that is find by the name given
    * @param name
    * @return chauffeur
    */
   public Chauffeur getChauffeurByName(String name)
   {
      for (int i = 0; i < chauffeurs.size(); i++)
      {
         if (chauffeurs.get(i).getName().equals(name))
         {
            return chauffeurs.get(i);
         }
      }
      return null;
   }
   /**
    * 
    * @return all available chauffeurs
    */
   public Chauffeur[] getAllAvailableChauffeurs()
   {
      int availableCounter = 0;
      for (int i = 0; i < chauffeurs.size(); i++)
      {
         if (chauffeurs.get(i).available())
         {
            availableCounter++;
         }
      }

      Chauffeur[] chaufArray = new Chauffeur[availableCounter];
      int actualIndex = 0;
      for (int i = 0; i < chaufArray.length; i++)
      {
         if (chauffeurs.get(i).available())
         {
            chaufArray[actualIndex] = chauffeurs.get(i);
            actualIndex++;
         }
      }
      return chaufArray;
   }
   /**
    * 
    * @return all fulltime chauffeurs
    */
   public Chauffeur[] getAllFullTimeChauffeurs()
   {
      int fullTimeCounter = 0;
      for (int i = 0; i < chauffeurs.size(); i++)
      {
         if (chauffeurs.get(i).fullTime())
         {
            fullTimeCounter++;
         }
      }

      Chauffeur[] chaufArray = new Chauffeur[fullTimeCounter];
      int actualIndex = 0;
      for (int i = 0; i < chaufArray.length; i++)
      {
         if (chauffeurs.get(i).fullTime())
         {
            chaufArray[actualIndex] = chauffeurs.get(i);
            actualIndex++;
         }
      }
      return chaufArray;
   }
   /**
    * 
    * @param id
    * @return chauffer found by id
    */
   public Chauffeur getChauffeurByID(int id)
   {
      for (int i = 0; i < chauffeurs.size(); i++)
      {
         if (chauffeurs.get(i).getID() == id)
         {
            return chauffeurs.get(i);
         }
      }
      return null;
   }
   /**
    * 
    * @param index
    * @return chauffeur at index
    */
   public Chauffeur get(int index)
   {
      return chauffeurs.get(index);
   }
   /**
    * 
    * @return String[] for combobox in Gui
    */
   public String[] getChauffeursForComboBox()
   {
      String[] all = new String[chauffeurs.size()];
      for (int i = 0; i < chauffeurs.size(); i++)
      {
         all[i] = chauffeurs.get(i).getID() + ", " + chauffeurs.get(i).getName()+", "+chauffeurs.get(i).getPreferences();
      }
      return all;
   }
   /**
    * finds and delete the chauffeur given
    * @param chaf
    */
   public void deleteChauffeur(Chauffeur chaf)
   {
      for(int i = 0; i<chauffeurs.size();i++)
      {
         if(chaf.equals(chauffeurs.get(i)))
            chauffeurs.remove(i);
      }
   }
   /**
    * toString
    * @return String containing all chauffeurs in list
    */
   public String toString()
   {
      String all = "";
      for (int i = 0; i < chauffeurs.size(); i++)
      {
         all += chauffeurs.get(i).toString();
      }
      return all;
   }
}
