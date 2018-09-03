package GUI;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Model.Customer;
import Model.VIABus;


public class GUIReserveSeats1Part extends JPanel{
	
	private JLabel labelReserveSeats;
	private JLabel labelDestination;
	private JTextField textFieldDestination;
	private JLabel labelSeats;
	private JTextField textFieldSeats;
	
	private TextFieldPanel searchByCustomerTextField;
	private ButtonPanel buttonsPanel;
	private JPanel backButtonPanel;
	private JPanel destinationPanel;
	
	private JCheckBox alreadyInSystemCheckBox;
	private JPanel checkBoxAndCustomerPanel;
	private JPanel centralPanel;
	public GUIReserveSeats1Part() {
		createComponents();
		addComponentsToPanel();
	}

	 private void createComponents()
	   {
		 String[] buttons={"Back",
	           "Next"};
		 labelDestination=new JLabel("Destination");
		 labelSeats=new JLabel("Number of Seats");
		 textFieldDestination=new JTextField(8);
		 textFieldSeats=new JTextField(8);
		//textField=new TextFieldPanel(new GridLayout(4,2),10,"Destination","Seats");
		searchByCustomerTextField=new TextFieldPanel(new GridLayout(1,2),6,"Customer");
		alreadyInSystemCheckBox=new JCheckBox("Already in system");
		 labelReserveSeats=new JLabel("Reserve Seats");
		 labelReserveSeats.setHorizontalAlignment(SwingConstants.CENTER);
	   buttonsPanel = new ButtonPanel(new FlowLayout(), buttons);
	    checkBoxAndCustomerPanel=new JPanel();
	  destinationPanel=new JPanel();
	   backButtonPanel=new JPanel();
	    centralPanel=new JPanel();
	    // setSize(300,300);
	   }

	 
	 private void addComponentsToPanel()
	   {
		
	      setLayout(new BorderLayout());
	      destinationPanel.setLayout(new GridLayout(2,1,8,8));
	      destinationPanel.add(labelDestination);
	      destinationPanel.add(textFieldDestination);
	      destinationPanel.add(labelSeats);
	      destinationPanel.add(textFieldSeats);
	  checkBoxAndCustomerPanel.add(alreadyInSystemCheckBox);
	  checkBoxAndCustomerPanel.add(searchByCustomerTextField);
	      backButtonPanel.add(buttonsPanel);
	      centralPanel.add(destinationPanel);
	      centralPanel.add(checkBoxAndCustomerPanel);
	      add(centralPanel, BorderLayout.CENTER);
	      add(labelReserveSeats, BorderLayout.NORTH);
	      add(backButtonPanel, BorderLayout.SOUTH);
	     
	   }
	 public void setText(String text)
	   {
	      textFieldDestination.setText(text);
	     searchByCustomerTextField.getTextField(0).setText(text);
	      textFieldSeats.setText(text);
	   }
	 public void addActionListener(ActionListener listener)
	   {
	      buttonsPanel.addActionListenerToAllButtons(listener);
	   }
	 
	 public String[] getInput()
	   {
		 String checkInSystem;
	      if(alreadyInSystemCheckBox.isSelected())
	      {
	    	  checkInSystem = "true";
	      }
	      else
	      {
	    	  checkInSystem = "false";
	      }
	      
	     
	      String[] input = {textFieldDestination.getText(),
	    		  textFieldSeats.getText(),
	    		  checkInSystem,searchByCustomerTextField.getTextField(0).getText()};
	     // textFieldPanelForInput.getTextField(StudentGUI.INPUT).setText(""); for canceling
	      return input;
	   }
	 
	 public void clear()
	 {
		 textFieldDestination.setText("");
		  textFieldSeats.setText("");
		  alreadyInSystemCheckBox.setSelected(false);
		  searchByCustomerTextField.getTextField(0).setText("");
	 }

	 public Customer getCustomerData() throws ClassNotFoundException, IOException
	 {
		 VIABus via=new VIABus();
		String [] input=getInput();
		 boolean checkCustomer=Boolean.parseBoolean(input[2]);
		 if(checkCustomer)
		 {
			 return via.getCustomerList().getCustomerByName(input[3]);
		 }
		return null;  
	 }
}
