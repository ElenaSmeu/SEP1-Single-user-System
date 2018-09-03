package GUI;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class GUIReserveAddPassenger extends JPanel{
	private ButtonPanel buttonsPanel;
	private JPanel backButtonPanel;
	private JLabel labelAddPassenger;
	private JLabel labelName;
	private JTextField textFieldName;
	private JLabel labelAge;
	private JTextField textFieldAge;
	private JPanel centralPanel;
	private JPanel main;
	private JLabel labelCount;
	private JLabel labeladdedPassengers;
	public GUIReserveAddPassenger() {
		createComponents();
		addComponentsToPanel();
	}

	private void createComponents()
	   {
	 String[] buttons={"Back","Next","Add Passenger"};
	 buttonsPanel = new ButtonPanel(new FlowLayout(), buttons);
	 backButtonPanel=new JPanel();
	 labelAddPassenger=new JLabel("Reserve - Add Passenger");
	 labelAddPassenger.setHorizontalAlignment(SwingConstants.CENTER);
	 labelAge=new JLabel("Age");
	 labelName=new JLabel("Name");
	 textFieldAge=new JTextField(10);
	 textFieldName=new JTextField(10);
	 centralPanel=new JPanel();
	 main=new JPanel();
	 labelCount=new JLabel("0");
	 labeladdedPassengers=new JLabel("Added passengers");
	setSize(300,300);
	   }
	
	private void addComponentsToPanel()
	   {
		centralPanel.setLayout(new GridLayout(3,2,8,8));
		centralPanel.add(labelName);
		centralPanel.add(textFieldName);
		centralPanel.add(labelAge);
		centralPanel.add(textFieldAge);
		centralPanel.add(labeladdedPassengers);
		centralPanel.add(labelCount);
		
		main.add(centralPanel);
		 setLayout(new BorderLayout());
		    
	      backButtonPanel.add(buttonsPanel);
	      add(main, BorderLayout.CENTER);
	      add(labelAddPassenger, BorderLayout.NORTH);
	      add(backButtonPanel, BorderLayout.SOUTH);
	     
	   }
	public void addActionListener(ActionListener listener)
	   {
	      buttonsPanel.addActionListenerToAllButtons(listener);
	   }
	 public String[] getInput()
	   { String[] input = {textFieldName.getText(),
			   textFieldAge.getText()
	    		  };
	     // textFieldPanelForInput.getTextField(StudentGUI.INPUT).setText("");
	      return input;
	   }
	 
	 public void clear()
	 {
		 textFieldName.setText("");
		   textFieldAge.setText("");
		   labelCount.setText("0");
  		 
	 }
	 public void clearText()
	 {
	    textFieldName.setText("");
       textFieldAge.setText("");
	 }
	 
	 public void setTextCounter(String text)
	 {
		 labelCount.setText(text);
	 }
	 
	 public String getTextCounter()
	 {
		 return labelCount.getText();
	 }
	   
}
