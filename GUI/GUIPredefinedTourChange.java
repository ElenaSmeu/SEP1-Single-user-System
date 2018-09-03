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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Model.PredefinedTour;
import Model.VIABus;

public class GUIPredefinedTourChange extends JPanel
{
   private ButtonPanel buttonsPanel;
   private JPanel backButtonPanel;
   private JTextField textFieldsStartDate;
   private JTextField textFieldsEndDate;
   private JTextField textFieldsDestination;
   private JLabel labelDestination;
   private JLabel addTour;
   private JLabel startDateLabel;
   private JLabel endDateLabel;
   private JPanel datesPanel;
   private JComboBox comboChauffeurs;
   private JComboBox comboVehicles;
   private JLabel labelChauffeur;
   private JLabel labelVehicle;
   private JLabel labelPrice;
   private JTextField textFieldPrice;
   private VIABus via;
   private JPanel mainPanel;
   private JPanel panelContainer;

   public GUIPredefinedTourChange(VIABus via)
   {
      this.via = via;
      createComponents();
      addComponentsToPanel();
   }

   private void createComponents()
   {
      panelContainer = new JPanel();
      mainPanel = new JPanel();

      labelChauffeur = new JLabel("Chauffeur");
      labelVehicle = new JLabel("Vehicle");
      String[] chauffeurs = via.getChauffeurList().getChauffeursForComboBox();
      String[] vehicles = {"Bus","MiniBus","PartyBus"};
      comboChauffeurs = new JComboBox(chauffeurs);
      comboVehicles = new JComboBox(vehicles);
      startDateLabel = new JLabel("Start Date:");
      endDateLabel = new JLabel("End Date");
      String[] buttons = { "Back", "Next" };
      labelPrice = new JLabel("Price per seat");
      textFieldPrice = new JTextField(10);
      labelDestination = new JLabel("Destination");
      datesPanel = new JPanel();
      backButtonPanel = new JPanel();
      textFieldsDestination = new JTextField(10);
      buttonsPanel = new ButtonPanel(new FlowLayout(), buttons);
      addTour = new JLabel("Change Tour");
      addTour.setHorizontalAlignment(SwingConstants.CENTER);
      textFieldsStartDate = new JTextField(10);
      textFieldsEndDate = new JTextField(10);
      // setSize(400,550);

   }

   private void addComponentsToPanel()
   {
      mainPanel.setLayout(new GridLayout(1, 1));
      mainPanel.add(datesPanel);
      datesPanel.setLayout(new GridLayout(6, 2));

      datesPanel.add(labelDestination);
      datesPanel.add(textFieldsDestination);
      datesPanel.add(startDateLabel);
      datesPanel.add(textFieldsStartDate);
      datesPanel.add(endDateLabel);
      datesPanel.add(textFieldsEndDate);
      datesPanel.add(labelChauffeur);
      datesPanel.add(comboChauffeurs);
      datesPanel.add(labelVehicle);
      datesPanel.add(comboVehicles);
      datesPanel.add(labelPrice);
      datesPanel.add(textFieldPrice);
      panelContainer.add(mainPanel);

      backButtonPanel.add(buttonsPanel);

      setLayout(new BorderLayout());
      add(mainPanel, BorderLayout.CENTER);
      add(addTour, BorderLayout.NORTH);
      add(backButtonPanel, BorderLayout.SOUTH);

   }
   public String[] getInput()
   {
      String[] a = { 
            textFieldsDestination.getText(),textFieldsStartDate.getText(), textFieldsEndDate.getText(),comboChauffeurs.getSelectedItem().toString(),comboVehicles.getSelectedItem().toString(),textFieldPrice.getText()
      };
      return a;
   }
   public void loadPredefinedTour(PredefinedTour tur)
   {
      textFieldsEndDate.setText(tur.getDateInterval().getEndDate().toString());
      textFieldsStartDate.setText(tur.getDateInterval().getStartDate().toString());
      textFieldsDestination.setText(tur.getDestination());
      textFieldPrice.setText(tur.getPrice()+"");
   }

   public void addActionListener(ActionListener listener)
   {
      buttonsPanel.addActionListenerToAllButtons(listener);
   }
}
