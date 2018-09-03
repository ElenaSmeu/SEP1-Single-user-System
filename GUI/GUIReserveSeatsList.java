package GUI;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class GUIReserveSeatsList extends JFrame{
	private ButtonPanel buttonsPanel;
	private JTextArea listAllTextArea;
	 JPanel backButtonPanel;
		private JLabel labelReserveSeats;
	public GUIReserveSeatsList() {
		createComponents();
		addComponentsToPanel();
	}

	 private void createComponents()
	   {
		 String[] buttons={"Back",
	           "Next "};
		String[] textFields={"NumberOfReservation","NumberOfSeats","PickUpDestination"};
		
		 labelReserveSeats=new JLabel("Reserve Seats");
		 labelReserveSeats.setHorizontalAlignment(SwingConstants.CENTER);
	   buttonsPanel = new ButtonPanel(new FlowLayout(), buttons);
	    listAllTextArea=new JTextArea(3,5);
	  
	   backButtonPanel=new JPanel();
	    
	     listAllTextArea.setEditable(false);
	     setSize(300,300);
	   }

	 
	 private void addComponentsToPanel()
	   {
		
	      setLayout(new BorderLayout());
	    
	      backButtonPanel.add(buttonsPanel);
	      add(listAllTextArea, BorderLayout.CENTER);
	      add(labelReserveSeats, BorderLayout.NORTH);
	      add(backButtonPanel, BorderLayout.SOUTH);
	     
	   }
	 public void setText(String text)
	   {
	      listAllTextArea.setText(text);
	   }
}
