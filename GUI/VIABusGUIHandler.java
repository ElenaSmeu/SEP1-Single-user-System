package GUI;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

public class VIABusGUIHandler implements ActionListener
{
   private GUIVIABus gui;
   private VIABusController controller;
   
   public VIABusGUIHandler(GUIVIABus gui, VIABusController controller)
   {
      this.gui = gui;
      this.controller = controller;
   }

   public void actionPerformed(ActionEvent event)
   {
      String mode = event.getActionCommand();

         controller.execute(mode);
      
   
   }

}
