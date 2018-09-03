package GUI;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
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

import Model.PredefinedTourList;
import Model.VIABus;


public class GUIReserveSeats2Part extends JPanel{
	private ButtonPanel buttonsPanel;
	private JComboBox comboTours;
	private JPanel backButtonPanel;
		private JLabel labelReserveSeats;
		private JCheckBox checkBusStop;
		private JLabel labelDestination;
		private JLabel labelTime;
		private JTextField textFieldDestination;
		private JTextField textFieldTime;
		private JPanel panelCentral;
		private JPanel Center;
	public GUIReserveSeats2Part() {
		createComponents();
		addComponentsToPanel();
	}

	 private void createComponents()
	   {
		 String[] buttons={"Back",
	           "Next"};
		String[] combo={"Tour","Tour name","Tour destination"};
		comboTours=new JComboBox(combo);
		 labelReserveSeats=new JLabel("Reserve Seats");
		 labelReserveSeats.setHorizontalAlignment(SwingConstants.CENTER);
	   buttonsPanel = new ButtonPanel(new FlowLayout(), buttons);
	  checkBusStop=new JCheckBox("Bus stop");
	  panelCentral=new JPanel();
	  labelDestination=new JLabel("Bus stop");
	  textFieldDestination=new JTextField(8);
	  textFieldTime=new JTextField(8);
	  labelTime=new JLabel("Date and Time");
	 Center=new JPanel();
	   backButtonPanel=new JPanel();
	    
	   
	    // setSize(300,300);
	   }

	 
	 private void addComponentsToPanel()
	   {
		 
		 Center.add(comboTours);
		 Center.add(checkBusStop);
		 Center.add(panelCentral);
		panelCentral.setLayout(new GridLayout(2,1,8,8));
		
		panelCentral.add(labelDestination);
		panelCentral.add(textFieldDestination);
		
		panelCentral.add(labelTime);
		panelCentral.add(textFieldTime);
	      setLayout(new BorderLayout());
	    
	      backButtonPanel.add(buttonsPanel);
	      add(Center, BorderLayout.CENTER);
	      add(labelReserveSeats, BorderLayout.NORTH);
	      add(backButtonPanel, BorderLayout.SOUTH);
	     
	   }
	 public void setText(String text)
	   {
	      
	   }
	 public void addActionListener(ActionListener listener)
	   {
	      buttonsPanel.addActionListenerToAllButtons(listener);
	   }
	 
	 public String[] getInput()
	   {
		 String checkBusStop;
	      if(this.checkBusStop.isSelected())
	      {
	    	  checkBusStop = "true";
	      }
	      else
	      {
	    	  checkBusStop = "false";
	      }
	      
	     
	      String[] input = {comboTours.getSelectedItem().toString(),
	    		  checkBusStop,
	    		 textFieldDestination.getText(),
	    		 textFieldTime.getText()
	    		  };
	     // textFieldPanelForInput.getTextField(StudentGUI.INPUT).setText("");
	      return input;
	   }
	 
	 public void clear()
	 {
		 comboTours.setSelectedItem("");
		 checkBusStop.setSelected(false);
		 textFieldDestination.setText("");
		 textFieldTime.setText("");
	 }
	 
	 public void setComboboxTour(PredefinedTourList list) 
	 {
		
		 comboTours.removeAllItems();
		 for(int i=0;i<list.size();i++)
		 {
			 comboTours.addItem(list.get(i).toString());
		 }
		 
	 }

}
