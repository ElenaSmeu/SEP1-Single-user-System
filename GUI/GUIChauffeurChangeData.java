package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Model.Chauffeur;


public class GUIChauffeurChangeData extends JPanel {
	private JLabel title;
	private JLabel Name;
	private JTextField nameTextField;
	private JLabel Id;
	private JTextField IdTextField;
	private JLabel Address;
	private JTextField AddressTextField;
	private JRadioButton isFullTime;
	private JLabel EmailAddress;
	private JTextField EmailAddressTextField;
	private JLabel PhoneNumber;
	private JTextField PhoneNumberTextField;
	private JLabel Preferences;
	private JTextField PreferencesTextField;
	
	private JButton Cancel;
	private JButton Save;
	
	public GUIChauffeurChangeData(){
		Initialize();
		setPanels();
		
	}
	public void Initialize(){
		this.title=new JLabel("Chauffeur");
		this.Name=new JLabel("Name");
		this.nameTextField=new JTextField();
		this.Id=new JLabel("Id");
		this.IdTextField=new JTextField(5);
		this.Address=new JLabel("Address");
		this.AddressTextField=new JTextField();
		this.isFullTime=new JRadioButton("Full Time");
		this.EmailAddress=new JLabel("email:");
		this.EmailAddressTextField=new JTextField();
		this.PhoneNumber=new JLabel("Phone Number:");
		this.PhoneNumberTextField=new JTextField();
		this.Preferences=new JLabel("Preferences");
		this.PreferencesTextField=new JTextField();
		
	
		this.Cancel=new JButton("Cancel");
		this.Save=new JButton("Save");
	}
	public void setPanels(){
		setLayout(new BorderLayout());
		//Title
		JPanel titleP=new JPanel();
		titleP.add(title,BorderLayout.CENTER);
		add(titleP,BorderLayout.NORTH);
		
		//Text
		JPanel text=new JPanel();
		text.setLayout(new GridLayout(10, 2, 20, 20));
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
		text.add(Preferences);
		text.add(PreferencesTextField);
		JPanel textP=new JPanel();
		textP.add(text,BorderLayout.CENTER);
		
		JPanel other=new JPanel();
		other.add(isFullTime,BorderLayout.CENTER);
		
		JPanel content=new JPanel();
		content.setLayout(new GridLayout(2,1,10,10));
		content.add(textP);
		content.add(other);
		
		add(content,BorderLayout.CENTER);
		
		
		//BottomButtons
		JPanel buttons=new JPanel();
		buttons.setLayout(new GridLayout(1, 3, 20, 10));
		buttons.add(Cancel);
		buttons.add(Save);
		JPanel buttons1=new JPanel();
		buttons1.add(buttons,BorderLayout.SOUTH);
		add(buttons1,BorderLayout.SOUTH);
	}	
	public void loadChauffeur(Chauffeur chaf)
	{
	   nameTextField.setText(chaf.getName());  
	   IdTextField.setText(chaf.getID()+"");
	   AddressTextField.setText(chaf.getAddress()); 
	   EmailAddressTextField.setText(chaf.getEmailAddress());
	   PhoneNumberTextField.setText(chaf.getPhoneNumber());
	   PreferencesTextField.setText(chaf.getPreferences());
	   isFullTime.setSelected(chaf.isFullTime());
	}
	public String[] getInput()
	{
	   String check="";
	   if(isFullTime.isSelected())check="true"; 
	   else check="false";
	      
	   String[] data = {
	         nameTextField.getText(), IdTextField.getText(), AddressTextField.getText()
	         ,check, EmailAddressTextField.getText(),PhoneNumberTextField.getText(),PreferencesTextField.getText(),      
	};
	   return data;
	}
	
	public void setChauffeur(Chauffeur chaf)
	{
	   if(chaf != null);;
	   nameTextField.setText(chaf.getName());
	   IdTextField.setText(chaf.getID()+"");
	   AddressTextField.setText(chaf.getAddress());
	   EmailAddressTextField.setText(chaf.getEmailAddress());
	   PhoneNumberTextField.setText(chaf.getPhoneNumber());
	   isFullTime.setSelected(chaf.isFullTime());
	   PreferencesTextField.setText(chaf.getPreferences());
	}
	
	public void addActionListener(ActionListener listener)
	   {
	      Cancel.addActionListener(listener);
	      Save.addActionListener(listener);
	   }
}
