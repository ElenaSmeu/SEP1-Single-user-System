package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Model.Customer;

public class GUIDisplayChangeCustomerData extends JPanel
{
   private JLabel labelChangeCustomerData;
   private JLabel labelName;
   private JLabel labelPhoneNumber;
   private JLabel labelAddress;
   private JLabel labelEmail;
   private JLabel labelCompanyName;

   private JTextField textFieldName;
   private JTextField textFieldPhone;
   private JTextField textFieldAddress;
   private JTextField textFieldEMail;
   private JTextField textFieldCompanyName;

   private JCheckBox checkBoxRecieveNewsLetter;
   private JCheckBox checkBoxIsACompany;

   private JButton buttonSave;
   private JButton buttonBack;
   private JButton buttonCancel;

   public GUIDisplayChangeCustomerData()
   {
      initializing();
      addComponentsToPanel();
   }

   public void initializing()
   {
      labelChangeCustomerData = new JLabel("Customer Data:");
      labelName = new JLabel("Name:");
      labelPhoneNumber = new JLabel("Phone Number: ");
      labelAddress = new JLabel("Address:");
      labelEmail = new JLabel("E-mail: ");
      labelCompanyName = new JLabel("Company Name: ");

      textFieldName = new JTextField(10);
      textFieldPhone = new JTextField(10);
      textFieldAddress = new JTextField(10);
      textFieldEMail = new JTextField(10);
      textFieldCompanyName = new JTextField(10);

      checkBoxRecieveNewsLetter = new JCheckBox("Recieve Newsletter:");
      checkBoxIsACompany = new JCheckBox("Is a company: ");

      buttonSave = new JButton("Save");
      buttonBack = new JButton("Back");
      buttonCancel = new JButton("Cancel");
   }

   public void addComponentsToPanel()
   {
      JPanel panelCenterChangeCustomerLabel = new JPanel();
      panelCenterChangeCustomerLabel.add(labelChangeCustomerData,
            BorderLayout.CENTER);

      JPanel panelBody = new JPanel(new GridLayout(5, 1));

      JPanel panelBigData = new JPanel();
      // /////////////////Contents///////////////////
      JPanel panelData = new JPanel();
      panelData.setLayout(new GridLayout(3, 2));
      panelData.add(labelName);
      panelData.add(textFieldName);
      panelData.add(labelPhoneNumber);
      panelData.add(textFieldPhone);
      panelData.add(labelAddress);
      panelData.add(textFieldAddress);
      // ///////////////////////////////////////////
      panelBigData.add(panelData, BorderLayout.CENTER);

      JPanel panelNewsletterEmailGroup = new JPanel();
      /* Beginning of group */

      JPanel panelCenteredNewsletterButton = new JPanel();
      panelCenteredNewsletterButton.add(checkBoxRecieveNewsLetter,
            BorderLayout.CENTER);

      JPanel panelBigEmail = new JPanel();
      // /////////////Big Email Contents///////////////
      JPanel panelTextFieldEmail = new JPanel(new GridLayout(1, 2));
      panelTextFieldEmail.add(labelEmail);
      panelTextFieldEmail.add(textFieldEMail);
      // /////////////////////////////////////////////
      panelBigEmail.add(panelTextFieldEmail);

      JPanel panelNewsletterEmail = new JPanel(new GridLayout(2, 1));
      panelNewsletterEmail.add(panelCenteredNewsletterButton);
      panelNewsletterEmail.add(panelBigEmail);
      /* End of group */
      panelNewsletterEmailGroup.add(panelNewsletterEmail);

      JPanel panelCompanyGroup = new JPanel();
      /* Beginning of group */
      JPanel panelCenterCompanyRadioButton = new JPanel();
      panelCenterCompanyRadioButton
            .add(checkBoxIsACompany, BorderLayout.CENTER);

      JPanel panelBigCompany = new JPanel();
      // /////////////////Contents///////////////////
      JPanel panelTextFieldCompanyName = new JPanel(new GridLayout(1, 2));
      panelTextFieldCompanyName.add(labelCompanyName);
      panelTextFieldCompanyName.add(textFieldCompanyName);
      // ///////////////////////////////////////////
      panelBigCompany.add(panelTextFieldCompanyName, BorderLayout.CENTER);

      JPanel panelCompanyButtonName = new JPanel(new GridLayout(2, 1));
      panelCompanyButtonName.add(panelCenterCompanyRadioButton);
      panelCompanyButtonName.add(panelBigCompany);
      /* End of group */
      panelCompanyGroup.add(panelCompanyButtonName);

      JPanel panelButtons = new JPanel();
      panelButtons.add(buttonBack);
      panelButtons.add(buttonSave);
      panelButtons.add(buttonCancel);

      panelBody.add(panelBigData);
      panelBody.add(panelNewsletterEmailGroup);
      panelBody.add(panelCompanyGroup);
      JPanel all = new JPanel(new BorderLayout());
      all.add(panelCenterChangeCustomerLabel, BorderLayout.NORTH);
      all.add(panelBody, BorderLayout.CENTER);
      // To have Button panel at the bottom of the Panel
      // V
      all.add(panelButtons, BorderLayout.SOUTH);

      add(all);
   }
   
   public void addActionListener(ActionListener listener)
   {
      buttonBack.addActionListener(listener);
      buttonSave.addActionListener(listener);
      buttonCancel.addActionListener(listener);
   }
   public void loadCustomer(Customer customer)
   {
      System.out.println(customer);
      textFieldName.setText(customer.getName());
      checkBoxIsACompany.setSelected(false);
      if(customer.isCompany())
      {
         checkBoxIsACompany.setSelected(true);
         textFieldCompanyName.setText(customer.getCompanyName());
      }
      textFieldAddress.setText(customer.getAddress());
      textFieldPhone.setText(customer.getPhoneNumber());
      checkBoxRecieveNewsLetter.setSelected(false);
      if(customer.getEmailAddress()!=null|| customer.getEmailAddress().equals(""))
      {
         checkBoxRecieveNewsLetter.setSelected(true);
         textFieldEMail.setText(customer.getEmailAddress());
      }
   }
   public String[] getInput()
   {
      String checkNewsLetter;
      if(checkBoxRecieveNewsLetter.isSelected())
      {
         checkNewsLetter = "true";
      }
      else
      {
         checkNewsLetter = "false";
      }
      
      String checkCompany;
      if(checkBoxIsACompany.isSelected())
      {
         checkCompany = "true";
      }
      else
      {
         checkCompany = "false";
      }
      
      String[] input = { textFieldName.getText().toString(),
            textFieldPhone.getText(),
            textFieldAddress.getText().toString(),
            checkNewsLetter, textFieldEMail.getText(),
            checkCompany, textFieldCompanyName.getText() };
      return input;
   }
   
   public void clear()
   {
      
   }
}
