package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Model.Chauffeur;

public class GUIChauffeurDelete extends JPanel
{
   private JLabel title;
   private JLabel Name;
   private JTextField nameTextField;
   private JLabel Id;
   private JTextField IdTextField;
   private JLabel Address;
   private JTextField AddressTextField;
   private JLabel EmailAddress;
   private JTextField EmailAddressTextField;
   private JLabel PhoneNumber;
   private JTextField PhoneNumberTextField;

   private JButton Back;
   private JButton Delete;

   public GUIChauffeurDelete()
   {
      Initialize();
      setPanels();
      nonEditable();
   }

   public void Initialize()
   {
      this.title = new JLabel("Fire Chauffeur");
      this.Name = new JLabel("Name");
      this.nameTextField = new JTextField();
      this.Id = new JLabel("Id");
      this.IdTextField = new JTextField(5);
      this.Address = new JLabel("Address");
      this.AddressTextField = new JTextField();
      this.EmailAddress = new JLabel("email:");
      this.EmailAddressTextField = new JTextField();
      this.PhoneNumber = new JLabel("Phone Number:");
      this.PhoneNumberTextField = new JTextField();

      this.Back = new JButton("Back");
      this.Delete = new JButton("Delete");
   }

   public void setPanels()
   {
      setLayout(new BorderLayout());
      // Title
      JPanel titleP = new JPanel();
      titleP.add(title, BorderLayout.CENTER);
      add(titleP, BorderLayout.NORTH);

      // Text
      JPanel text = new JPanel();
      text.setLayout(new GridLayout(7, 2, 20, 20));
      text.add(Name);
      text.add(nameTextField);
      text.add(Id);
      text.add(IdTextField);
      text.add(Address);
      text.add(AddressTextField);
      text.add(EmailAddress);
      text.add(EmailAddressTextField);
      text.add(PhoneNumber);
      text.add(PhoneNumberTextField);
      JPanel textP = new JPanel();
      textP.add(text, BorderLayout.CENTER);

      add(textP, BorderLayout.CENTER);

      // BottomButtons
      JPanel buttons = new JPanel();
      buttons.setLayout(new GridLayout(1, 3, 20, 30));
      buttons.add(Back);
      buttons.add(Delete);

      JPanel buttons1 = new JPanel();
      buttons1.add(buttons);
      add(buttons1, BorderLayout.SOUTH);

   }
   public void nonEditable()
   {
      nameTextField.setEditable(false);
      IdTextField.setEditable(false);
      AddressTextField.setEditable(false);
      EmailAddressTextField.setEditable(false);
      PhoneNumberTextField.setEditable(false);
   }
   public void loadChauffeur(Chauffeur chaf)
   {
      nameTextField.setText(chaf.getName());
      IdTextField.setText(chaf.getID()+"");
      AddressTextField.setText(chaf.getAddress());
      EmailAddressTextField.setText(chaf.getEmailAddress());
      PhoneNumberTextField.setText(chaf.getPhoneNumber());   
   }
   public String[] getInput()
   {

      String[] input = { nameTextField.getText(), IdTextField.getText(),
            AddressTextField.getText(), EmailAddressTextField.getText(),
            PhoneNumberTextField.getText(), };
      return input;
   }

   public void addActionListener(ActionListener listener)
   {
      Back.addActionListener(listener);
      Delete.addActionListener(listener);
   }

}
