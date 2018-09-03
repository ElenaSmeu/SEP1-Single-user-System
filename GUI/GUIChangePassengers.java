package GUI;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Model.PassengerList;

public class GUIChangePassengers extends JPanel
{
   private JTextArea textAreaPassenger;
   private JButton buttonHome;
   private JButton buttonBack;
   private JButton buttonSave;

   public GUIChangePassengers()
   {
      initializing();
      addComponentsToPanel();
   }
   
   public void initializing()
   {
      textAreaPassenger = new JTextArea();
      buttonHome = new JButton("Home");
      buttonBack = new JButton ("Back");
      buttonSave = new JButton ("Save");
   }
   
   
   public void addComponentsToPanel()
   {
      setLayout(new BorderLayout());
      add(new JScrollPane(textAreaPassenger), BorderLayout.CENTER);
      
      JPanel buttonPanel = new JPanel();
      buttonPanel.add(buttonHome);
      buttonPanel.add(buttonBack);
      buttonPanel.add(buttonSave);
      
      add(buttonPanel, BorderLayout.SOUTH);
      
   }
   
   public void addActionListener(ActionListener listener)
   {
      buttonHome.addActionListener(listener);
      buttonBack.addActionListener(listener);
      buttonSave.addActionListener(listener);
   }
   public void loadPassengerList(PassengerList list)
   {
      textAreaPassenger.setText(list.toString());
   }
   public String[] getInput()
   {
      String[] input = { textAreaPassenger.getText()};
      return input;
   }
}
