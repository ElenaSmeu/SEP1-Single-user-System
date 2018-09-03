package GUI;
import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUIFindChauffeur extends JPanel
{
   JLabel labelChauffeur;
   JComboBox comboBoxSearch;
   JTextField textFieldValue;
   ButtonPanel buttonBackAndSearch;
   public GUIFindChauffeur() 
   {
      createComponents();
      addComponentsToPanel();
   }
   public void createComponents()
   {
      labelChauffeur = new JLabel("Find Chauffeur");
      String[] searchparameter = {"ID","Name"};
      comboBoxSearch = new JComboBox(searchparameter);
      textFieldValue = new JTextField(12);
      buttonBackAndSearch = new ButtonPanel(new FlowLayout(),"Back","Search");
   }
   public void addComponentsToPanel()
   { 
      setLayout(new BorderLayout());
      JPanel a = new JPanel(new FlowLayout());
      JPanel b = new JPanel(new FlowLayout());
      b.add(labelChauffeur, new BorderLayout().NORTH);
      a.add(textFieldValue, new FlowLayout());
      a.add(comboBoxSearch, new FlowLayout().CENTER);
      add(a, new BorderLayout().CENTER);
      add(b,new BorderLayout().NORTH);
      add(buttonBackAndSearch, new BorderLayout().SOUTH);
   }
   public void addActionListener(ActionListener listener)
   {
      buttonBackAndSearch.addActionListenerToAllButtons(listener);
   }
   public String[] getInput()
   {
      String[] input = { comboBoxSearch.getSelectedItem().toString(),
            textFieldValue.getText() };
      return input;
   }
   public void clear()
   {
      
   }

}
