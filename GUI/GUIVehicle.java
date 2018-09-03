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

import Model.VIABus;


public class GUIVehicle extends JPanel {

	private JLabel Vehicle;
	private JButton AddVehicle;
	private JButton DeleteVehicle;
	private JButton ChangeInfo;
	private VIABus  viabus;
	private JComboBox combobox;
	
	
	private JButton Back;
	private JButton Home;
	
	public GUIVehicle(VIABus via) 
	{
	   this.viabus=via;
		createComponents();
		setSize(400,550);
		TheLabelPosition();
	}
	public void createComponents()
	{
		

		String vehicles[]=viabus.getVehicleList().getVehiclesForComboBox();
		this.combobox=new JComboBox(vehicles);
		
		this.Vehicle=new JLabel("Vehicle");
		this.Back=new JButton("Back");
		this.Home=new JButton("Home");
		this.AddVehicle=new JButton("Add Vehicle");
		this.DeleteVehicle=new JButton("Delete Vehicle");
		this.ChangeInfo=new JButton("Change Info");
		
	}
	public void setSize(){
		setSize(500,700);
	}
	public void TheLabelPosition(){
		setLayout(new BorderLayout());
		JPanel Label=new JPanel();
		Vehicle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Label.add(Vehicle,BorderLayout.CENTER);
		add(Label,BorderLayout.NORTH);
	
		JPanel Buttons=new JPanel();
		Buttons.setLayout(new GridLayout(4,1,10,40));
		Buttons.add(combobox);
		Buttons.add(AddVehicle);
		Buttons.add(DeleteVehicle);
		Buttons.add(ChangeInfo);
		JPanel buttom=new JPanel();
		buttom.add(Buttons,BorderLayout.CENTER);
		add(buttom,BorderLayout.CENTER);
	
		JPanel BackHome=new JPanel();
		BackHome.setLayout(new GridLayout(1, 2, 4, 30));
		BackHome.add(Back);
		BackHome.add(Home);
		JPanel buttom1=new JPanel();
		buttom1.add(BackHome,BorderLayout.CENTER);
		add(buttom1,BorderLayout.SOUTH);
		
	}
	public void addActionListener(ActionListener listener)
	   {	
		  
	      Back.addActionListener(listener);
	      Home.addActionListener(listener);
	      AddVehicle.addActionListener(listener);
	      DeleteVehicle.addActionListener(listener);
	      ChangeInfo.addActionListener(listener);
	      
	   }
	public void updater()
	{
      combobox.removeAllItems();
      String[] a = viabus.getVehicleList().getVehiclesForComboBox();
      for(int i =0;i<a.length;i++)
      {
         combobox.addItem(a[i]);
      }
      
   }
	 public String[] getInput()
	   {
	      String[] input = { combobox.getSelectedItem().toString()};
	      return input;
	   }
}