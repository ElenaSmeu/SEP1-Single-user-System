package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class GUIVIABusReserveMain extends JPanel {
	
		private ButtonPanel bp;
		JPanel button;
     JLabel reserveLabel;
  JButton backButton;
  JPanel backButtonPanel;
	public GUIVIABusReserveMain() {
		createComponents();
	      addComponentsToPanel();
	}

	
	 private void createComponents()
	   {
		 String[] buttons={"Reserve seats",
	           "Reserve Bus and Chauffeur"};
		
	       reserveLabel=new JLabel("Reserve");
	       reserveLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    bp = new ButtonPanel( buttons);
	    button=new JPanel();
	   backButton=new JButton("Back");
	   backButtonPanel=new JPanel();
	      
	   }

	 
	 private void addComponentsToPanel()
	   {
	      setLayout(new BorderLayout());
	      button.add(bp);
	      backButtonPanel.add(backButton);
	      add(button, BorderLayout.CENTER);
	      add(reserveLabel, BorderLayout.NORTH);
	      add(backButtonPanel, BorderLayout.SOUTH);
	     
	   }

	 
	 public void setText(String text)
	   {
	     
	   }

	   public void addActionListener(ActionListener listener)
	   {
	      bp.addActionListenerToAllButtons(listener);
	      backButton.addActionListener(listener);
	   }
}
