package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

	public class GUIVehicleChangeInformation extends JPanel{
		private JLabel title;
		private JLabel regNumber;
		private JTextField regNumTextField;
		private JLabel type;
		private JComboBox<String> vehicles;
		private JButton Back;
		private JButton Cancel;
		
		private JButton Save;
		
		public GUIVehicleChangeInformation() {
			Initializing();
			createElments();
			
		}
		public void Initializing(){
			setLayout(new BorderLayout());
			this.title=new JLabel("Vehicle Information");
			this.Back=new JButton("Back");
			this.Cancel=new JButton("Cancel");
			this.Save=new JButton("Save");
			
			this.regNumber=new JLabel("Registration Number:");
			this.regNumTextField=new JTextField(7);
			this.type=new JLabel("Type:");
			String[] strings={"Mini Bus","Party Bus","Bus"};
			this.vehicles=new JComboBox<>(strings);
			
		}
		public void createElments(){
			//Title:Add Vehicle
			JPanel Title=new JPanel();
			Title.add(title,BorderLayout.NORTH);
			add(Title,BorderLayout.PAGE_START);
			
			//Center
			JPanel Text=new JPanel();
			Text.setLayout(new GridLayout(3, 2, 30,30));
			Text.add(regNumber);
			Text.add(regNumTextField);
			Text.add(type);
			Text.add(vehicles);
			
			JPanel otherJPanel=new JPanel();
			otherJPanel.add(Text,BorderLayout.CENTER);
			add(otherJPanel);
			
			//Bottom Buttons
			JPanel buttons=new JPanel();
			buttons.setLayout(new GridLayout(1, 3, 7, 20));
			buttons.add(Back);
			buttons.add(Cancel);
			buttons.add(Save);
			
			JPanel buttons1=new JPanel();
			buttons1.add(buttons,BorderLayout.SOUTH);
			add(buttons1,BorderLayout.SOUTH);
			
		}
		 public void changeVehicle(String a, String b)
		   {
		     regNumTextField.setText(a);
		     int type = 0;
		     if(b.equals("MiniBus"))
		        type=0;
		     if(b.equals("PartyBus"))
		        type=1;
		     if(b.equals("Bus"))
		        type=2;
		     vehicles.setSelectedIndex(type);
		   }
		 public String[] getInput()
	      {
	         String[] a = { 
	               regNumTextField.getText(), vehicles.getSelectedItem().toString()
	         };
	         return a;
	      }
		public void addActionListener(ActionListener listener)
		   {	
			  
		      Back.addActionListener(listener);
		      Cancel.addActionListener(listener);
		     Save.addActionListener(listener);
		      
		   }
	}
