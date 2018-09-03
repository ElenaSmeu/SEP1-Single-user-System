package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.Reservation;
import Model.VIABus;

public class GUIChangeReservation extends JPanel
{
   private VIABus viaBus;

   private JLabel labelReservation;
   private JLabel labelResNum;
   private JLabel labelCustomerInfo;
   private JLabel labelTourInformation;
   private JLabel labelCustName;
   private JLabel labelCustPhone;
   private JLabel labelCustAddress;
   private JLabel labelTourDestination;
   private JLabel labelTourDateInterval;

   private JTextField textFieldResNum;
   private JTextField textFieldCustName;
   private JTextField textFieldCustPhone;
   private JTextField textFieldCustAddress;
   private JTextField textFieldTourDestination;
   private JTextField textFieldTourDates;

   private JComboBox comboBoxVehicleType;
   private JComboBox comboBoxChauffeur;

   private JButton buttonBack;
   private JButton buttonDelete;
   private JButton buttonSave;
   private JButton buttonCancel;
   private JButton buttonChangePassengerData;
   private JButton buttonChangeExtras;

   public GUIChangeReservation(VIABus via)
   {
      this.viaBus = via;
      initializing();
      addComponentsToPanel();
   }

   public void initializing() 
   {
      labelReservation = new JLabel("Change Reservation");
      labelResNum = new JLabel("Reservation number: ");
      labelCustName = new JLabel("Name: ");
      labelCustPhone = new JLabel("Phone number: ");
      labelCustAddress = new JLabel("Address: ");
      labelCustomerInfo = new JLabel("Customer Information:");
      labelTourInformation = new JLabel("Tour Information:");
      labelTourDestination = new JLabel("Destination:");
      labelTourDateInterval = new JLabel("Start and End Dates: ");

      textFieldResNum = new JTextField(10);
      textFieldCustAddress = new JTextField(10);
      textFieldCustName = new JTextField(10);
      textFieldCustPhone = new JTextField(10);
      textFieldTourDestination = new JTextField(10);
      textFieldTourDates = new JTextField(10);

      

      String[] typeVehicle = { "Bus", "Mini Bus", "Party Bus" };
      comboBoxVehicleType = new JComboBox(typeVehicle);
      // Chauffeurs need to be changed to read ChauffeurList from file!
      String[] chauffeurs = viaBus.getChauffeurList()
            .getChauffeursForComboBox();
      comboBoxChauffeur = new JComboBox(chauffeurs);
      // //////////////////////////////////////////////////////////////

      buttonBack = new JButton("Back");
      buttonDelete = new JButton("Delete");
      buttonSave = new JButton("Save");
      buttonChangePassengerData = new JButton("Change Passenger Data");
      buttonCancel = new JButton("Cancel");
      buttonChangeExtras = new JButton("Change Extras");
   }

   private void addComponentsToPanel()
   {
      // declaring and initializing main center panel:
      JPanel panelInformation = new JPanel();
      panelInformation.setLayout(new GridLayout(5, 1));

      // creating panel to center label "Change Reservation" - acting as title
      // for panel
      JPanel panelCenterResLabel = new JPanel();
      panelCenterResLabel.add(labelReservation, BorderLayout.CENTER);

      // panelBigRes - container panel for panel with reservation number label
      // and text field
      // used to center the contents of the panel.
      JPanel panelBigRes = new JPanel();

      // panelReservation - contains reservation number and text field
      JPanel panelReservation = new JPanel(new GridLayout(1, 2, 10, 2));

      panelReservation.add(labelResNum);
      textFieldResNum.setEditable(false);
      panelReservation.add(textFieldResNum);

      panelBigRes.add(panelReservation, BorderLayout.CENTER);

      panelInformation.add(panelBigRes);

      JPanel centerCustomerInfo = new JPanel();
      centerCustomerInfo.add(labelCustomerInfo, BorderLayout.CENTER);
      panelInformation.add(centerCustomerInfo);

      JPanel panelBigCustomer = new JPanel();
      // //////////////////////////////////////////////////////////////////////////
      JPanel panelCustomerInformation = new JPanel(new GridLayout(3, 2, 10, 2));

      panelCustomerInformation.add(labelCustName);
      panelCustomerInformation.add(textFieldCustName);
      panelCustomerInformation.add(labelCustPhone);
      panelCustomerInformation.add(textFieldCustPhone);
      panelCustomerInformation.add(labelCustAddress);
      panelCustomerInformation.add(textFieldCustAddress);
      // ///////////////////////////////////////////////////////////////////////////
      panelBigCustomer.add(panelCustomerInformation);
      panelInformation.add(panelBigCustomer);

      JPanel panelCenterTourLabel = new JPanel();
      panelCenterTourLabel.add(labelTourInformation, BorderLayout.CENTER);

      JPanel panelBigTour = new JPanel();
      // ///////////////////////////////////////////////////////////////////
      JPanel panelTourInformation = new JPanel(new GridLayout(3, 2, 10, 2));

      panelTourInformation.add(labelTourDestination);
      panelTourInformation.add(textFieldTourDestination);
      panelTourInformation.add(labelTourDateInterval);
      panelTourInformation.add(textFieldTourDates);
      panelTourInformation.add(comboBoxChauffeur);
      panelTourInformation.add(comboBoxVehicleType);
      // ////////////////////////////////////////////////////////////////////
      panelBigTour.add(panelTourInformation);

      panelInformation.add(panelCenterTourLabel);
      panelInformation.add(panelBigTour, BorderLayout.CENTER);

      JPanel panelTwoColumns = new JPanel(new GridLayout(2, 2, 5, 5));
      panelTwoColumns.add(buttonBack);
      panelTwoColumns.add(buttonDelete);
      panelTwoColumns.add(buttonSave);
      panelTwoColumns.add(buttonCancel);

      JPanel panelChangeExtraPasButton = new JPanel(new GridLayout(2, 1, 5, 5));
      panelChangeExtraPasButton.add(buttonChangePassengerData);
      panelChangeExtraPasButton.add(buttonChangeExtras);

      JPanel panelButtons = new JPanel();
      panelButtons.add(panelTwoColumns);
      panelButtons.add(panelChangeExtraPasButton);

      JPanel all = new JPanel(new BorderLayout());
      all.add(panelCenterResLabel, BorderLayout.NORTH);
      all.add(panelInformation, BorderLayout.CENTER);
      all.add(panelButtons, BorderLayout.SOUTH);

      add(all);
   }

   public void addActionListener(ActionListener listener)
   {
      buttonBack.addActionListener(listener);
      buttonDelete.addActionListener(listener);
      buttonSave.addActionListener(listener);
      buttonCancel.addActionListener(listener);
      buttonChangePassengerData.addActionListener(listener);
      buttonChangeExtras.addActionListener(listener);
   }

   public String[] getInput()
   {
      String[] input = { textFieldResNum.getText().toString(),
            textFieldCustName.getText(),
            textFieldCustPhone.getText().toString(),
            textFieldCustAddress.getText(),
            textFieldTourDestination.getText(),
            textFieldTourDates.getText(),
            comboBoxChauffeur.getSelectedItem().toString(),
            comboBoxVehicleType.getSelectedItem().toString()};
      return input;
   }
   public void loadReservation(Reservation reser)
   {
      textFieldResNum.setText(reser.getNumber()+"");
      textFieldCustAddress.setText(reser.getCustomer().getAddress());
      textFieldCustPhone.setText(reser.getCustomer().getPhoneNumber());
      textFieldTourDates.setText(reser.getTour().getDateInterval().getStartDate()+" "+reser.getTour().getDateInterval().getEndDate());
      textFieldCustName.setText(reser.getCustomerName());
      textFieldTourDestination.setText(reser.getTour().getDestination());
   }
   
   /*
    * private void registerEvents() { ButtonHandler handler = new
    * ButtonHandler(); buttonBack.addActionListener(handler);
    * buttonDelete.addActionListener(handler);
    * buttonSave.addActionListener(handler);
    * buttonCancel.addActionListener(handler); } private class ButtonHandler
    * implements ActionListener { public void actionPerformed(ActionEvent event)
    * { } }
    */
}
