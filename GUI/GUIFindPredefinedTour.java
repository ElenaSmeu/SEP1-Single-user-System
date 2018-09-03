package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIFindPredefinedTour extends JPanel
{
   JLabel labelFindPredefinedTour;
   JComboBox comboBoxSearch;
   JTextField textFieldValue;
   ButtonPanel buttonBackAndSearch;
   public GUIFindPredefinedTour() 
   {
      createComponents();
      addComponentsToPanel();
   }
   public void createComponents()
   {
      labelFindPredefinedTour = new JLabel("Find Predefined Tour");
      String[] searchparameter = {"Destination", "Start Date","End Date", "Chauffeur"};
      comboBoxSearch = new JComboBox(searchparameter);
      textFieldValue = new JTextField(12);
      buttonBackAndSearch = new ButtonPanel(new FlowLayout(),"Back","Search");
   }
   public void addComponentsToPanel()
   { 
      setLayout(new BorderLayout());
      JPanel a = new JPanel(new FlowLayout());
      JPanel b = new JPanel(new FlowLayout());
      b.add(labelFindPredefinedTour, new BorderLayout().NORTH);
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
