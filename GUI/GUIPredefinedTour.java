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


public class GUIPredefinedTour extends JPanel {

   private JLabel PredefinedTourTitle;
   private JButton AddPredefinedTour;
   private JButton FindPredefinedTour;
   
   
   private JButton BackToManageData;
   private JButton Home;
   
   public GUIPredefinedTour() 
   {
      createComponents();
      TheLabelPosition();
   }
   public void createComponents()
   {
      this.PredefinedTourTitle= new JLabel("Predefined Tour");
      this.BackToManageData=new JButton("Back");
      this.Home=new JButton("Home");
      this.AddPredefinedTour=new JButton("Add Predefined Tour");
      this.FindPredefinedTour=new JButton("Find Predefined Tour");
   }
   public void TheLabelPosition(){
      setLayout(new BorderLayout());
      JPanel Label=new JPanel();
      PredefinedTourTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
      Label.add(PredefinedTourTitle,BorderLayout.CENTER);
      add(Label,BorderLayout.NORTH);
   
   
      
      JPanel Buttons=new JPanel();
      Buttons.setLayout(new GridLayout(4,1,10,40));

      Buttons.add(AddPredefinedTour);
      Buttons.add(FindPredefinedTour);
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
         AddPredefinedTour.addActionListener(listener);
         FindPredefinedTour.addActionListener(listener);
      }


    
   
}