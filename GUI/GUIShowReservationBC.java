package GUI;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Model.MiniBus;
import Model.Reservation;
import Model.VIABus;


public class GUIShowReservationBC extends JPanel{
	private ButtonPanel buttonsPanel;
	private JPanel backButtonPanel;
	private JTextField textFieldStartDate;
	private JTextField textFieldEndDate;
	private JTextField textFieldDestination;
	private JLabel labelDestination;
	private JLabel labelReserveBusAndChauffeur;
	private JLabel startDateLabel;
	private JLabel endDateLabel;
	private JPanel datesPanel;
	private JComboBox typeVehicleComboBox;
	private JLabel labelChauffeur;
	private JLabel labelVehicle;
	private JTextField textFieldVehicle;
	private JTextField textFieldChauffeur;
	private JLabel labelAmountOfPassengers;
	private JTextField textFieldAmountOfPassengers;
	private JCheckBox partyGuideCheckBox;
	private JTextField searchByCustomerTextField;
	private JCheckBox checkisInSystem;
	private JPanel centralPanel;
	private JComboBox comboChauffeur;
	private JPanel smallPanel;
	private JPanel additionalPanel;
	private JLabel labelPrice;
	private JTextField textFieldPrice;
	private JPanel pricePanel;
	private JLabel labelExtras;
	private JTextArea textFieldExtras;
	private JLabel labelAmount;
	private JTextField textFieldAmount;
	private JLabel labelTotalPrice;
	private JTextField textFieldTotalPrice;
	private JPanel bottomPanel;
	private JLabel labelCustomer;
	private JTextField textFieldCustomer;
private VIABus via;
	public GUIShowReservationBC(VIABus via)  {
	   this.via=via;
		createComponents();
		addComponentsToPanel();	
		setEditableFalse(false);
	}
	private void createComponents() 
	{
		labelAmountOfPassengers=new JLabel("Number of passengers");
		labelChauffeur=new JLabel("Chauffeur");
		labelVehicle=new JLabel("Vehicle");
		textFieldAmountOfPassengers=new JTextField(10);
		textFieldChauffeur=new JTextField(10);
		textFieldVehicle=new JTextField(10);
		String[] typeVehicle = {"Bus","Minibus","Party bus"};
	      typeVehicleComboBox = new JComboBox(typeVehicle);
	      partyGuideCheckBox=new JCheckBox("Party guide");
		startDateLabel=new JLabel("Start Date:");
		textFieldStartDate=new JTextField(10);
		endDateLabel=new JLabel("End Date");
		textFieldEndDate=new JTextField(10);
	String[] buttons={"Back","Finish"};
	 datesPanel=new JPanel();
	 backButtonPanel=new JPanel();
	 textFieldDestination=new JTextField(10);
	 labelDestination=new JLabel("Destination");
	buttonsPanel=new ButtonPanel(new FlowLayout(),buttons);
	 labelReserveBusAndChauffeur=new JLabel("Reserve");
	 labelReserveBusAndChauffeur.setHorizontalAlignment(SwingConstants.CENTER);
	 textFieldStartDate=new JTextField(10);
	 searchByCustomerTextField=new JTextField(10);
	 textFieldEndDate=new JTextField(10);
	 centralPanel=new JPanel();
	 checkisInSystem=new JCheckBox("Customer in system");
	 String[] chauffeurs=via.getChauffeurList().getChauffeursForComboBox();
	 comboChauffeur=new JComboBox(chauffeurs);
	 smallPanel=new JPanel();
	 additionalPanel=new JPanel();
	 labelPrice=new JLabel("Price for tour");
	 textFieldPrice=new JTextField(10);
	 labelExtras=new JLabel("Extras");
	 labelAmount=new JLabel("Amount of extras");
	 textFieldAmount=new JTextField(10);
	 textFieldExtras=new JTextArea(2,1);
	 pricePanel=new JPanel();
	 bottomPanel=new JPanel();
	 labelTotalPrice=new JLabel("Total Price");
	 textFieldTotalPrice=new JTextField(10);
	 labelCustomer=new JLabel("Customer");
	 textFieldCustomer=new JTextField(10);
	 
	 //setSize(300,300);
	   }
	 private void addComponentsToPanel()
	   {
		 bottomPanel.setLayout(new GridLayout(2,1,8,8));
		 bottomPanel.add(smallPanel);
		 bottomPanel.add(pricePanel);
		pricePanel.setLayout(new GridLayout(4,2,8,8));
		pricePanel.add(labelPrice);
		pricePanel.add(textFieldPrice);
		pricePanel.add(labelExtras);
		pricePanel.add(textFieldExtras);
		pricePanel.add(labelAmount);
		pricePanel.add(textFieldAmount);
		pricePanel.add(labelTotalPrice);
		pricePanel.add(textFieldTotalPrice);
		 additionalPanel.setLayout(new GridLayout(1,2,8,8));
		
		 
		 smallPanel.setLayout(new GridLayout(3,2,8,8));
		 
		 smallPanel.add(labelCustomer);
		 smallPanel.add(textFieldCustomer);
		 smallPanel.add(labelVehicle);
		 smallPanel.add(textFieldVehicle);
		 smallPanel.add(labelChauffeur);
		 smallPanel.add(textFieldChauffeur);
		 
		
		 centralPanel.add(labelReserveBusAndChauffeur);
		 centralPanel.add(datesPanel);
		 centralPanel.add(additionalPanel);
		 centralPanel.add(bottomPanel);
		
		datesPanel.setLayout(new GridLayout(3,2,8,8));
		
		datesPanel.add(startDateLabel);
		datesPanel.add(textFieldStartDate);
		datesPanel.add(endDateLabel);
		datesPanel.add(textFieldEndDate);
		datesPanel.add(labelDestination);
		datesPanel.add(textFieldDestination);
		
		
		 backButtonPanel.add(buttonsPanel);
		 setLayout(new BorderLayout());
	      add(centralPanel, BorderLayout.CENTER);
	      add(labelReserveBusAndChauffeur, BorderLayout.NORTH);
	      add(backButtonPanel, BorderLayout.SOUTH);
	     
	   }
	 public void addActionListener(ActionListener listener)
	   {
		 buttonsPanel.addActionListenerToAllButtons(listener);
	   }
	 public void setEditableFalse(boolean b)
	 {
		 textFieldAmount.setEditable(b);
		 textFieldDestination.setEditable(b);
		 textFieldEndDate.setEditable(b);
		 textFieldExtras.setEditable(b);
		 textFieldPrice.setEditable(b);
		 searchByCustomerTextField.setEditable(b);
		 textFieldStartDate.setEditable(b);
		 textFieldTotalPrice.setEditable(b);
		 typeVehicleComboBox.setEditable(b);
		 comboChauffeur.setEditable(b);
		 checkisInSystem.setEnabled(b);
		 textFieldAmountOfPassengers.setEditable(b);
		 textFieldChauffeur.setEditable(b);
		 textFieldCustomer.setEditable(b);
		 textFieldVehicle.setEditable(b);
	 }
	 public void clear()
	 {
		 textFieldAmount.setText("");
		 textFieldDestination.setText("");
		 textFieldEndDate.setText("");
		 textFieldExtras.setText("");
		 textFieldPrice.setText("");
		 textFieldStartDate.setText("");
		 textFieldTotalPrice.setText("");
		 typeVehicleComboBox.setSelectedItem("");
		 comboChauffeur.setSelectedItem("");
		 checkisInSystem.setSelected(false);
		 
	 }
	 public void showReservation(Reservation reservation)
	 {
		 String start="";
		 start+= reservation.getTour().getDateInterval().getStartDate();
		 textFieldStartDate.setText(start);
		 String end="";
		 end+= reservation.getTour().getDateInterval().getEndDate();
		 textFieldEndDate.setText(end);
		 textFieldDestination.setText(reservation.getTour().getDestination());
		 textFieldCustomer.setText(reservation.getCustomerName());
		 textFieldVehicle.setText(reservation.getVehicle().getType());
		 String chauffeur="";
		 chauffeur+=reservation.getChauffeur().getName();
		 textFieldChauffeur.setText(chauffeur);
		 String passengers="";
		 passengers+=reservation.getPassengerList().getSize();
		 textFieldAmountOfPassengers.setText(passengers);
		 
		 String price="";
		 price+=reservation.getAllPrices();
		 textFieldPrice.setText(price);
		 String extras="";
		 extras+=reservation.getItems();
		 textFieldExtras.setText(extras);
		 String amount="";
		 amount+=reservation.getItemsAmount();
		 textFieldAmount.setText(amount);
		 String total="";
		 total+=reservation.getAllPrices();
		 textFieldTotalPrice.setText(total);
		 //make a price for the tour in the predefined tour and add it to the total price
		 
	 }
	 public void showReservationBC(Reservation reservation)
	 {
		 String start="";
		 
		 //System.out.println(reservation);
		 start += reservation.getTour().getDateInterval().getStartDate();
		 textFieldStartDate.setText(start);
		 String end="";
		 end += reservation.getTour().getDateInterval().getEndDate();
		 textFieldEndDate.setText(end);
		 textFieldDestination.setText(reservation.getTour().getDestination());
		 textFieldCustomer.setText(reservation.getCustomerName());
		 textFieldVehicle.setText(reservation.getVehicle().getType());
		 String chauffeur="";
		 chauffeur += reservation.getChauffeur().getName();
		 textFieldChauffeur.setText(chauffeur);
		// String passengers="";
		// passengers+=reservation.getPassengerList().getSize();
		// textFieldAmountOfPassengers.setText(passengers);
		 
		 String price="";
		 price+=reservation.getPriceForTour();
		 textFieldPrice.setText(price);
		 String extras="";
		 extras+=reservation.getItems();
		 textFieldExtras.setText(extras);
		 String amount="";
		 amount+=reservation.getItemsAmount();
		 textFieldAmount.setText(amount);
		 String total="";
		 total+=reservation.getAllPrices();
		 textFieldTotalPrice.setText(total);
		 //make a price for the tour in the predefined tour and add it to the total price
		 
	 }
}
