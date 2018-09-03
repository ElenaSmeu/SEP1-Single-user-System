package GUI;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;




public class GUIReserveExtras extends JPanel{

	private ButtonPanel buttonsPanel;
	private JPanel backButtonPanel;
	private JLabel labelPrice;
	private JTextField textFieldPrice;
	private JPanel pricePanel;
	private JLabel labelExtras;
	private JTextField textFieldExtras;
	private JLabel labelAmount;
	private JTextField textFieldAmount;
	private JLabel labelTopExtras;
	
	public GUIReserveExtras()
	{
		createComponents();
		addComponentsToPanel();
	}
	private void createComponents()
	   {
		String[] buttons={"Back","Next","Add Extras"};
		buttonsPanel=new ButtonPanel(new FlowLayout(),buttons);
		 backButtonPanel=new JPanel();
		 labelPrice=new JLabel("Price");
		 textFieldPrice=new JTextField(10);
		 labelExtras=new JLabel("Extra");
		 labelAmount=new JLabel("Amount");
		 textFieldAmount=new JTextField(10);
		 textFieldExtras=new JTextField(10);
		 pricePanel=new JPanel();
		 labelTopExtras=new JLabel("Add Extras");
		 labelTopExtras.setHorizontalAlignment(SwingConstants.CENTER);
		 //setSize(300,300);
	   }
	 private void addComponentsToPanel()
	   {
		 pricePanel.setLayout(new GridLayout(3,2,8,8));
			
			pricePanel.add(labelExtras);
			pricePanel.add(textFieldExtras);
			pricePanel.add(labelAmount);
			pricePanel.add(textFieldAmount);
			pricePanel.add(labelPrice);
			pricePanel.add(textFieldPrice);
		 backButtonPanel.add(buttonsPanel);
		 setLayout(new BorderLayout());
	      add(pricePanel, BorderLayout.CENTER);
	      add(labelTopExtras, BorderLayout.NORTH);
	      add(backButtonPanel, BorderLayout.SOUTH);
	   }
	 
	 public void addActionListener(ActionListener listener)
	   {
	      buttonsPanel.addActionListenerToAllButtons(listener);
	   }
	 public String[] getInput()
	   {
		 String[] input = {textFieldExtras.getText(),
				 textFieldAmount.getText(),
				 textFieldPrice.getText()};
		 return input;
		 
	   }
	 public void clear()
	   {
		 textFieldExtras.setText("");
		 textFieldAmount.setText("");
		 textFieldPrice.setText("");
		
		 
	   }
}
