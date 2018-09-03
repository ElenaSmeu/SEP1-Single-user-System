package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.Bus;
import Model.MiniBus;
import Model.PartyBus;
import Model.Vehicle;

public class GUIVehicleDeleteInformation extends JPanel
{
   private JLabel title;;
   private JLabel RegNumber;
   private JTextField regNumberTextField;
   private JLabel Type;
   private JTextField typeTextField;
   private JButton Back;
   private JButton delete;

   public GUIVehicleDeleteInformation()
   {
      initializing();
      createcomponents();
      nonEditable();
   }
   
   public void initializing()
   {
      this.title = new JLabel("Vehicle Information");
      this.RegNumber = new JLabel("Registration Number:");
      this.regNumberTextField = new JTextField();
      this.Type = new JLabel("Type:");
      this.typeTextField = new JTextField();
      this.Back = new JButton("Cancel");
      this.delete = new JButton("Delete");

   }

   public void createcomponents()
   {
      setLayout(new BorderLayout());
      // Title
      JPanel titleP = new JPanel();
      titleP.add(title, BorderLayout.CENTER);
      add(titleP, BorderLayout.NORTH);
      // Text-Center
      JPanel text = new JPanel();
      text.setLayout(new GridLayout(2, 2, 30, 30));
      text.add(RegNumber);
      text.add(regNumberTextField);
      text.add(Type);
      text.add(typeTextField);
      JPanel textP = new JPanel();
      textP.add(text, BorderLayout.CENTER);
      add(textP, BorderLayout.CENTER);
      // Button Bottom
      JPanel buttons = new JPanel();
      buttons.setLayout(new GridLayout(1, 3, 30, 20));
      buttons.add(Back);
      buttons.add(delete);
      JPanel other = new JPanel();
      other.add(buttons, BorderLayout.CENTER);
      add(other, BorderLayout.SOUTH);
   }
   public void nonEditable()
   {
      regNumberTextField.setEditable(false);
      typeTextField.setEditable(false); 
   }
   public void loadVehicle(Vehicle vehi)
   {
      regNumberTextField.setText(vehi.getRegNumber());
      typeTextField.setText(vehi.getType());
   }
   public Vehicle getVehicleInfo()
   {
      try{
         if(typeTextField.getText().equals("PartyBus"))
         {
            PartyBus a = new PartyBus(regNumberTextField.getText());
            return a;
         }
         else if(typeTextField.getText().equals("MiniBus"))
         {
            MiniBus a = new MiniBus(regNumberTextField.getText());
            return a;
         }
         else if(typeTextField.getText().equals("Bus"))
         {
            Bus a = new Bus(regNumberTextField.getText());
            return a;
         }
         return null;
      }
      catch(Exception e)
      {
         return null;
      }
   }
   public void addActionListener(ActionListener listener)
   {

      Back.addActionListener(listener);
      delete.addActionListener(listener);

   }
}