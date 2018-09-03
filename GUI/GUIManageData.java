package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GUIManageData extends JPanel {
	private JLabel ManageData;

	private JButton predefinedTour;
	private JButton Vehicles;
	private JButton Chauffeur;
	private JButton Reservation;
	private JButton Customer;
	
	
	private JButton Back;
	
	public GUIManageData()
	{
		createComponents();
		setSize(400,550);
		TheLabelPosition();
		
	}
	
	public void createComponents()
   {
		this.ManageData=new JLabel("Manage Data");
		this.predefinedTour=new JButton("Predefined Tours");
		this.Back=new JButton("Back");
		this.Vehicles=new JButton("Vehicles");
		this.Chauffeur=new JButton("Chauffeur");
		this.Reservation=new JButton("Reservation");
		this.Customer=new JButton("Customer");
	}

	public void TheLabelPosition(){
		setLayout(new BorderLayout());
		JPanel Label=new JPanel();
		ManageData.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Label.add(ManageData,BorderLayout.CENTER);
		add(Label,BorderLayout.NORTH);
	
		JPanel Buttons=new JPanel();
		Buttons.setLayout(new GridLayout(3,2,10,40));
		Buttons.add(predefinedTour);
		Buttons.add(Reservation);
		Buttons.add(Chauffeur);
		Buttons.add(Customer);
		Buttons.add(Vehicles);
		
		JPanel buttom=new JPanel();
		buttom.add(Buttons,BorderLayout.CENTER);
		add(buttom,BorderLayout.CENTER);
		
		JPanel button=new JPanel();
		button.add(Back,BorderLayout.CENTER);
		add(button,BorderLayout.SOUTH);
	}
	/*public void BottomButtons(){
		JPanel BackHome=new JPanel();
		BackHome.setLayout(new GridLayout(1, 1, 4, 30));
		BackHome.add(Back);
		JPanel buttom=new JPanel();
		buttom.add(BackHome,BorderLayout.CENTER);
		add(buttom,BorderLayout.PAGE_END);
		
	}*/
	
	public void addActionListener(ActionListener listener)
   {
      predefinedTour.addActionListener(listener);
      Back.addActionListener(listener);
      Vehicles.addActionListener(listener);
      Chauffeur.addActionListener(listener);
      Reservation.addActionListener(listener);
      Customer.addActionListener(listener);
   }
}