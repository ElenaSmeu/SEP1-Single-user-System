package Model;


import java.io.*;

/**
 * Class that represents File reader
 * @author Daniel Kim
 *
 */
public class FileVIABus implements Serializable
{
   private File viaBus;
   /**
    * No argument constructor that sets the file to "VIABus.bin"
    */
   public FileVIABus()
   {
      this.viaBus = new File("VIABus.bin"); 
   }
   /**
    * writes viabus to bin file
    * @param viaBus
    */
   public void writeVIABusToFile(VIABus viaBus) 
   {
      try{
      FileOutputStream out = new FileOutputStream(this.viaBus);
      ObjectOutputStream oos = new  ObjectOutputStream(out);
      oos.writeObject(viaBus);
      oos.close();  
      }
      catch(Exception e)
      {
         
      }
   }
   /**
    */
   public VIABus readVIABusFile() throws IOException, ClassNotFoundException
   {
      FileInputStream fis = new FileInputStream(this.viaBus);
      ObjectInputStream ois = new ObjectInputStream(fis);
      VIABus vlist = (VIABus) ois.readObject();
      ois.close();
      return vlist;
   }
   

}
