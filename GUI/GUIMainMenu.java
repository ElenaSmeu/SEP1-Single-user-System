package GUI;
import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUIMainMenu extends JPanel
{
   JLabel viaBus;
   ButtonPanel mainmenu;
  
   public GUIMainMenu()
   {
      createComponents();
      addComponentsToPanel();
   }

   public void createComponents()
   {
      viaBus = new JLabel("VIA Bus");
      mainmenu = new ButtonPanel("Reserve", "Manage Data", "Find");
      viaBus.setHorizontalAlignment(SwingConstants.CENTER);
      viaBus.setFont(new Font("Maiandra GD", Font.PLAIN, 36));
      
   }
   public void addComponentsToPanel()
   {
      setLayout(new BorderLayout());
      add(viaBus, new BorderLayout().NORTH);
      add(mainmenu, new BorderLayout().CENTER);
   }
   public void addActionListener(ActionListener listener)
   {
      mainmenu.addActionListenerToAllButtons(listener);
   }
   public void clear()
   {
      
   }
}
