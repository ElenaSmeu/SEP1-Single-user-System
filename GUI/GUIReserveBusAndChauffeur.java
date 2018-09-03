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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Model.VIABus;


public class GUIReserveBusAndChauffeur extends JPanel{
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
	private JTextField textFieldExtras;
	private JLabel labelAmount;
	private JTextField textFieldAmount;
	private JPanel bottomPanel;
private VIABus via;
	public GUIReserveBusAndChauffeur(VIABus via) {
	   this.via=via;
		createComponents();
		addComponentsToPanel();	
	}
	private void createComponents() 
	   {
		
		String[] typeVehicle = {"Bus","Minibus","Party bus"};
	      typeVehicleComboBox = new JComboBox(typeVehicle);
	      partyGuideCheckBox=new JCheckBox("Party guide");
		startDateLabel=new JLabel("Start Date:");
		textFieldStartDate=new JTextField(10);
		endDateLabel=new JLabel("End Date");
		textFieldEndDate=new JTextField(10);
	String[] buttons={"Back","Next"};
	 datesPanel=new JPanel();
	 backButtonPanel=new JPanel();
	 textFieldDestination=new JTextField(10);
	 labelDestination=new JLabel("Destination");
	buttonsPanel=new ButtonPanel(new FlowLayout(),buttons);
	 labelReserveBusAndChauffeur=new JLabel("Reserve Bus and Chauffeur");
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
	 labelPrice=new JLabel("Price for Bus amd Chauffeur");
	 textFieldPrice=new JTextField(10);
	 labelExtras=new JLabel("Extras");
	 labelAmount=new JLabel("Amount of extras");
	 textFieldAmount=new JTextField(10);
	 textFieldExtras=new JTextField(10);
	 pricePanel=new JPanel();
	 bottomPanel=new JPanel();
	 
	 //setSize(300,300);
	   }
	 private void addComponentsToPanel()
	   {
		 bottomPanel.setLayout(new GridLayout(2,1));
		 bottomPanel.add(smallPanel);
		 bottomPanel.add(pricePanel);
		pricePanel.setLayout(new GridLayout(1,2,8,8));
		pricePanel.add(labelPrice);
		pricePanel.add(textFieldPrice);
		//pricePanel.add(labelExtras);
		//pricePanel.add(textFieldExtras);
		//pricePanel.add(labelAmount);
		//pricePanel.add(textFieldAmount);
		 additionalPanel.setLayout(new GridLayout(1,2,8,8));
		 additionalPanel.add(checkisInSystem);
		 additionalPanel.add(searchByCustomerTextField);
		 
		 smallPanel.setLayout(new GridLayout(3,1,8,8));
		 smallPanel.add(typeVehicleComboBox);
		 smallPanel.add(partyGuideCheckBox);
		 smallPanel.add(comboChauffeur);
		
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
	
	 public String[] getInput()
	   {
		 String checkCustomer;
	      if(checkisInSystem.isSelected())
	      {
	    	  checkCustomer = "true";
	      }
	      else
	      {
	    	  checkCustomer = "false";
	      }
	      
	      String checkParty;
	      if(partyGuideCheckBox.isSelected())
	      {
	    	  checkParty = "true";
	      }
	      else
	      {
	    	  checkParty = "false";
	      }
	      
	     
	      String[] input = {textFieldStartDate.getText(),
	    		  textFieldEndDate.getText(),
	    		  textFieldDestination.getText(),
	    		  checkCustomer,
	    		  searchByCustomerTextField.getText(),
	    		  typeVehicleComboBox.getSelectedItem().toString(),
	    		  checkParty,
	    		  comboChauffeur.getSelectedItem().toString(),
	    		  textFieldPrice.getText()
	    		  };
	     // textFieldPanelForInput.getTextField(StudentGUI.INPUT).setText("");
	      return input;
	   }
	 
	 public void clear()
	 {
		 textFieldStartDate.setText("");
		  textFieldEndDate.setText("");
		  textFieldDestination.setText("");
		  //checkCustomemer="false";
		  checkisInSystem.setSelected(false);
		  searchByCustomerTextField.setText("");
		  typeVehicleComboBox.setSelectedItem("");
		 // checkParty="false";
		  partyGuideCheckBox.setSelected(false);
		  comboChauffeur.setSelectedItem("");
		  textFieldPrice.setText("");
		  
	 }
}
