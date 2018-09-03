package GUI;
import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;




public class GUIFind extends JPanel
{
     JLabel labelFind;
     ButtonPanel buttonFinder;
     JButton buttonBack;
     
     
   public GUIFind()
   {
      createComponents();
      addComponentsToPanel();
   }
   
   public void createComponents()
   {
      labelFind = new JLabel("Find");
      buttonFinder = new ButtonPanel("Reservation","Customer", "Chauffeur","Predefined Tour");
      buttonFinder.setLayout(new GridLayout(4, 1,30,30));
      labelFind.setHorizontalAlignment(SwingConstants.CENTER);
      buttonBack = new JButton("Back");
   }
   public void addComponentsToPanel()
   {
      setLayout(new BorderLayout());
      add(labelFind, new BorderLayout().NORTH);
      JPanel other=new JPanel();
      other.add(buttonFinder,BorderLayout.CENTER);
      add(other, new BorderLayout().CENTER);
      JPanel button=new JPanel();
      button.add(buttonBack,BorderLayout.CENTER);
      add(button, new BorderLayout().SOUTH);
   }
   public void addActionListener(ActionListener listener)
   {
      buttonBack.addActionListener(listener);
      buttonFinder.addActionListenerToAllButtons(listener);
   }
   public void clear()
   {
      
   }

}