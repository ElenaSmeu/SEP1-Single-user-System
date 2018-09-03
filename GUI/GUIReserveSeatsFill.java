package GUI;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;


public class GUIReserveSeatsFill extends JFrame{
	private TextFieldPanel textFields;
	private ButtonPanel buttonsPanel;
	JPanel backButtonPanel;
	private JLabel labelReserveSeats;
	public GUIReserveSeatsFill() {
		createComponents();
		addComponentsToPanel();
	}

	 private void createComponents()
	   {
		 String[] buttons={"Back",
	           "Next "};
		String[] text={"Number of the Reservation","Number of seats","Pick up destination"};
		 labelReserveSeats=new JLabel("Reserve Seats");
		 labelReserveSeats.setHorizontalAlignment(SwingConstants.CENTER);
	   buttonsPanel = new ButtonPanel(new FlowLayout(), buttons);
	    textFields=new TextFieldPanel(text);
	  
	   backButtonPanel=new JPanel();
	    
	    
	     setSize(300,300);
	   }

	 
	 private void addComponentsToPanel()
	   {
		
	      setLayout(new BorderLayout());
	    
	      backButtonPanel.add(buttonsPanel);
	      add(textFields, BorderLayout.CENTER);
	      add(labelReserveSeats, BorderLayout.NORTH);
	      add(backButtonPanel, BorderLayout.SOUTH);
	     
	   }
	 public void setText(String text)
	   {
	    
	   }
}
