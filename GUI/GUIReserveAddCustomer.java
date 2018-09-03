package GUI;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Model.Customer;


public class GUIReserveAddCustomer extends JPanel {
	private ButtonPanel buttonsPanel;
	private JPanel backButtonPanel;
	private JLabel labelName;
	private JTextField textFieldName;
	private JLabel labelAddress;
	private JTextField textFieldAddress;
	private JLabel labelPhone;
	private JTextField textFieldPhone;
	private JCheckBox checkNewsletter;
	private JCheckBox checkCompany;
	private JLabel labelEmail;
	private JTextField textFieldEmail;
	private JLabel labelCompany;
	private JTextField textFieldCompany;
	private JPanel main;
	private JPanel secondPanel;
	private JPanel centralPanel;
	private JLabel labelAddCustomer;
	public GUIReserveAddCustomer() {
		createComponents();
		addComponentsToPanel();
	}

	private void createComponents()
	   {
	 String[] buttons={"Back","Next"};
	 buttonsPanel = new ButtonPanel(new FlowLayout(), buttons);
	 backButtonPanel=new JPanel();
	 main=new JPanel();
	 labelAddress=new JLabel("Address");
	 labelCompany=new JLabel("Company name");
	 labelEmail=new JLabel("Email");
	 labelName=new JLabel("Name");
	 labelPhone=new JLabel("Phone number");
	 textFieldAddress=new JTextField(10);
	 textFieldCompany=new JTextField(10);
	 textFieldEmail=new JTextField(10);
	 textFieldName=new JTextField(10);
	 textFieldPhone=new JTextField(10);
	checkCompany=new JCheckBox("Company");
	checkNewsletter=new JCheckBox("Newsletter");
	labelAddCustomer=new JLabel("Reserve - Add Customer");
	labelAddCustomer.setHorizontalAlignment(SwingConstants.CENTER);
	secondPanel=new JPanel();
	centralPanel=new JPanel();
	setSize(300,300);
	   }
	
	private void addComponentsToPanel()
	   {
		main.setLayout(new GridLayout(3,2,8,8));
		main.add(labelName);
		main.add(textFieldName);
		main.add(labelAddress);
		main.add(textFieldAddress);
		main.add(labelPhone);
		main.add(textFieldPhone);
		secondPanel.setLayout(new GridLayout(2,3,1,8));
		secondPanel.add(checkNewsletter);
		secondPanel.add(labelEmail);
		secondPanel.add(textFieldEmail);
		secondPanel.add(checkCompany);
		secondPanel.add(labelCompany);
		secondPanel.add(textFieldCompany);
	centralPanel.add(main);
	centralPanel.add(secondPanel);
		 setLayout(new BorderLayout());
		    
	      backButtonPanel.add(buttonsPanel);
	      add(centralPanel, BorderLayout.CENTER);
	      add(labelAddCustomer, BorderLayout.NORTH);
	      add(backButtonPanel, BorderLayout.SOUTH);
	     
	   }
	
	 public void addActionListener(ActionListener listener)
	   {
	      buttonsPanel.addActionListenerToAllButtons(listener);
	   }
	 String checkNewsLetter;
	 String checkIsCompany;
	 public String[] getInput()
	   {
		 
	      if(checkNewsletter.isSelected())
	      {
	    	  checkNewsLetter = "true";
	      }
	      else
	      {
	    	  checkNewsLetter = "false";
	      }
	     
	      if(this.checkCompany.isSelected())
	      {
	    	  checkIsCompany = "true";
	      }
	      else
	      {
	    	  checkIsCompany= "false";
	      }
	      
	     
	      String[] input = {textFieldName.getText(),
	    		  textFieldAddress.getText(),
	    		  textFieldPhone.getText(),
	    		 checkNewsLetter,
	    		 checkIsCompany,
	    		 textFieldEmail.getText(),
	    		 textFieldCompany.getText()};
	    		  
	     // textFieldPanelForInput.getTextField(StudentGUI.INPUT).setText("");
	      return input;
	   }
	 public void clear(){
		 textFieldName.setText("");
		  textFieldAddress.setText("");
		  textFieldPhone.setText("");
		 checkNewsLetter="false";
		 checkNewsletter.setSelected(false);
		 checkCompany.setSelected(false);
		 checkIsCompany="false";
		 textFieldEmail.setText("");
		 textFieldCompany.setText("");
	 }
	 
	 public void showExistingCustomer(Customer customer)
	 {
		 if(customer!=null){
		 textFieldName.setText(customer.getName());
		 textFieldAddress.setText(customer.getAddress());
		 textFieldPhone.setText(customer.getPhoneNumber());
		 if(customer.getEmailAddress()!=null || (!(customer.getEmailAddress().equals(""))))
		 {
			 textFieldEmail.setText(customer.getEmailAddress());
			 checkNewsletter.setSelected(true);
		 }
		 if(customer.getCompanyName()!=null && (!(customer.getCompanyName().equals(""))))
		 {
			 textFieldCompany.setText(customer.getCompanyName());
			 checkCompany.setSelected(true);
		 }
	 }}
	   
}
