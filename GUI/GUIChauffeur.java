package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.Chauffeur;
import Model.VIABus;


public class GUIChauffeur extends JPanel {

	private JLabel ChauffeurTitle;
	private JButton AddChauffeur;
	private JButton DeleteChauffeur;
	private JButton ChangeInfo;
	private JComboBox combobox;
	private VIABus viabus;
	
	
	private JButton BackToManageData;
	private JButton Home;
	
	public GUIChauffeur(VIABus via) 
	{
	   this.viabus=via;
		createComponents();
		TheLabelPosition();
	}
	public void createComponents()
	{
		String[] chauffeurs=viabus.getChauffeurList().getChauffeursForComboBox();
		this.combobox=new JComboBox<>(chauffeurs);
		this.ChauffeurTitle=new JLabel("Chauffeur");
		this.BackToManageData=new JButton("Back");
		this.Home=new JButton("Home");
		this.AddChauffeur=new JButton("Add Chauffeur");
		this.DeleteChauffeur=new JButton("Delete Chauffeur");
		this.ChangeInfo=new JButton("Change Info");
	}
	public void TheLabelPosition(){
		setLayout(new BorderLayout());
		JPanel Label=new JPanel();
		ChauffeurTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Label.add(ChauffeurTitle,BorderLayout.CENTER);
		add(Label,BorderLayout.NORTH);
	
	
		
		JPanel Buttons=new JPanel();
		Buttons.setLayout(new GridLayout(4,1,10,40));
		Buttons.add(combobox);
		Buttons.add(AddChauffeur);
		Buttons.add(DeleteChauffeur);
		Buttons.add(ChangeInfo);
		JPanel buttom=new JPanel();
		buttom.add(Buttons,BorderLayout.CENTER);
		add(buttom,BorderLayout.CENTER);
	
		JPanel BackHome=new JPanel();
		BackHome.setLayout(new GridLayout(1, 2, 4, 30));
		BackHome.add(BackToManageData);
		BackHome.add(Home);
		JPanel buttom1=new JPanel();
		buttom1.add(BackHome,BorderLayout.CENTER);
		add(buttom1,BorderLayout.SOUTH);
		
	}
	public void addActionListener(ActionListener listener)
	   {
	      BackToManageData.addActionListener(listener);
	      Home.addActionListener(listener);
	      AddChauffeur.addActionListener(listener);
	      DeleteChauffeur.addActionListener(listener);
	      ChangeInfo.addActionListener(listener);
	   }
	 public String[] getInput()
	   {
	      String[] input = { combobox.getSelectedItem().toString() };
	      return input;
	   }
	 public Chauffeur getChauffeur()
	 {
	    Chauffeur chaf = new Chauffeur();
	      String[] input = getInput();
	      
	        String chauf[]= input[0].split(", ");
	        chaf = viabus.getChauffeurList().getChauffeurByID(Integer.parseInt(chauf[0]));
	        return chaf;
	 }
	 public void updater()
	 {
	    combobox.removeAllItems();
	    String[] a = viabus.getChauffeurList().getChauffeursForComboBox();
	    for(int i =0;i<a.length;i++)
	    {
	       combobox.addItem(a[i]);
	    }
	    
	 }
	
}