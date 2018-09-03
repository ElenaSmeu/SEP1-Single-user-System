import java.io.IOException;

import GUI.*;
import Model.*;
public class Main
{

   public static void main(String[] args) throws ClassNotFoundException, IOException
   {
      VIABus model = new VIABus();
      GUIVIABus gui = new GUIVIABus(model);
      VIABusController controller = new VIABusController(gui, model);
      gui.startGui(controller);
   }

}
