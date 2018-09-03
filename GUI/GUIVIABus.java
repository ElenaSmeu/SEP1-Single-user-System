package GUI;

import java.awt.CardLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.Chauffeur;
import Model.Customer;
import Model.Item;
import Model.PassengerList;
import Model.PredefinedTour;
import Model.PredefinedTourList;
import Model.Reservation;
import Model.VIABus;
import Model.Vehicle;

public class GUIVIABus extends JFrame
{

   private GUIMainMenu mainGui;
   private GUIFind findGui;
   private GUIFindReservation findReservationGui;
   private GUIFindChauffeur findChauffeurGui;
   private GUIFindCustomer findCustomerGui;
   private GUIFindOutput findOutputGui;
   private GUIFindOutputMulti findOutputMultiGui;
   private GUIFindPredefinedTour findPredefinedTourGui;

   private GUIChauffeur manageDataChauffeur;
   private GUIVIABusReserveMain reserveMain;
   private GUIManageData manageMenu;
   private GUIChauffeurAddChauffeur manageAddChauffeur;
   private GUIChauffeurChangeData manageChangeChauffeur;
   private GUIChauffeurDelete managedeleteChauffeur;
   private GUIVehicle manageVehicle;
   private GUIVehicleAddVehicle manageAddVehicle;
   private GUIVehicleChangeInformation manageChangeDataVehicle;
   private GUIVehicleDeleteInformation manageDeleteVehicle;

   private GUIChangeReservation changeReservationGui;
   private GUIDisplayChangeCustomerData changeCustomerGui;
   private GUIChangePassengers changePassengersGui;
   private GUIChangeExtras changeExtrasGui;


   private GUIReserveSeats1Part reserveSeats1part;
   private GUIReserveSeats2Part reserveSeats2Part;
   private GUIReserveBusAndChauffeur reserveBusAndChauffeur;
   private GUIReserveAddCustomer reserveAddCustomer;
   private GUIReserveAddCustomer reserveAddCustomerBC;
   private GUIReserveAddPassenger reserveAddPassenger;
  // private GUIReserveAddPassenger reserveAddPassengerBC;
   private GUIReserveExtras reserveExtras;
   private GUIReserveExtras reserveExtrasBC;
   private GUIPredefinedTourAddTour addPredefinedTour;
   private GUIPredefinedTourChange changePredefinedTour;
   
   private GUIPredefinedTour managePredefinedTour;
   private GUIPredefinedTourOutputPanel outputPredefinedTourAdd;
   private GUIPredefinedTourOutputPanel outputPredefinedTourChange;
   private GUIShowReservation showReservation;
   private GUIShowReservationBC showReservationBC;
   private JPanel cardPanel;
   private CardLayout cardLayout;

   private String mode;
   private VIABus via;

   public GUIVIABus(VIABus via)
   {
      super("VIABus");
      this.via = via;
      createComponents();
      initializeComponents();
      addComponentsToFrame();
      mode = "MainMenu";
   }

   public void createComponents()
   {
      mainGui = new GUIMainMenu();
      findGui = new GUIFind();
      changePredefinedTour = new GUIPredefinedTourChange(via);
      findReservationGui = new GUIFindReservation();
      findChauffeurGui = new GUIFindChauffeur();
      findCustomerGui = new GUIFindCustomer();
      findOutputGui = new GUIFindOutput();
      findOutputMultiGui = new GUIFindOutputMulti();
      findPredefinedTourGui = new GUIFindPredefinedTour();
      reserveMain = new GUIVIABusReserveMain();
      manageMenu = new GUIManageData();
      managePredefinedTour = new GUIPredefinedTour();
      

      manageDataChauffeur = new GUIChauffeur(via);
      manageAddChauffeur = new GUIChauffeurAddChauffeur();
      manageChangeChauffeur = new GUIChauffeurChangeData();
      managedeleteChauffeur = new GUIChauffeurDelete();
      manageVehicle = new GUIVehicle(via);
      manageAddVehicle = new GUIVehicleAddVehicle();
      manageChangeDataVehicle = new GUIVehicleChangeInformation();
      manageDeleteVehicle = new GUIVehicleDeleteInformation();

      changeReservationGui = new GUIChangeReservation(via);
      changeCustomerGui = new GUIDisplayChangeCustomerData();
      changePassengersGui = new GUIChangePassengers();
      changeExtrasGui = new GUIChangeExtras();
     
      reserveAddCustomer=new GUIReserveAddCustomer();
      reserveAddCustomerBC=new GUIReserveAddCustomer();
      reserveAddPassenger=new GUIReserveAddPassenger();
      //reserveAddPassengerBC=new GUIReserveAddPassenger();
      reserveBusAndChauffeur =new GUIReserveBusAndChauffeur(via);
      reserveSeats1part=new GUIReserveSeats1Part();
      reserveSeats2Part=new GUIReserveSeats2Part();
      reserveExtras=new GUIReserveExtras();
      reserveExtrasBC=new GUIReserveExtras();
      showReservation=new GUIShowReservation(via);
      showReservationBC=new GUIShowReservationBC(via);   
      addPredefinedTour=new GUIPredefinedTourAddTour(via);
      outputPredefinedTourAdd=new GUIPredefinedTourOutputPanel();
      outputPredefinedTourChange = new GUIPredefinedTourOutputPanel();
      

      
      cardLayout = new CardLayout();
      cardPanel = new JPanel(cardLayout);

   }

   public void initializeComponents()
   {
      setSize(500, 650);
      setLocationRelativeTo(null); // center of the screen
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   }

   public void addComponentsToFrame()
   {
     
      cardPanel.add(mainGui, "MainMenu");
      cardPanel.add(changePredefinedTour, "ChangePredefinedTour");
      cardPanel.add(managePredefinedTour, "ManagePredefinedTour");
      cardPanel.add(reserveMain, "ReserveMenu");
      cardPanel.add(findCustomerGui, "FindCustomer");
      cardPanel.add(findChauffeurGui, "FindChauffeur");
      cardPanel.add(findReservationGui, "FindReservation");
      cardPanel.add(findGui, "FindMenu");
      cardPanel.add(findOutputGui, "output");
      cardPanel.add(findOutputMultiGui, "outputMulti");
      cardPanel.add(findPredefinedTourGui, "FindPredefinedTour");

      cardPanel.add(manageDataChauffeur, "ManageChauffeur");
      cardPanel.add(manageMenu, "ManageMenu");
      cardPanel.add(manageAddChauffeur, "AddNewChauffeur");
      cardPanel.add(manageChangeChauffeur, "ChangeChauffeur");
      cardPanel.add(managedeleteChauffeur, "ManageDeleteChauffeur");
      cardPanel.add(manageVehicle, "ManageVehicle");
      cardPanel.add(manageAddVehicle, "ManageAddVehicle");
      cardPanel.add(manageChangeDataVehicle, "ManageDataVehicle");
      cardPanel.add(manageDeleteVehicle, "ManageDeleteVehicle");

      cardPanel.add(changeReservationGui, "ChangeReservation");
      cardPanel.add(changeCustomerGui, "ChangeCustomer");
      cardPanel.add(changePassengersGui, "ChangePassengers");
      cardPanel.add(changeExtrasGui, "ChangeExtras");
      
      
      cardPanel.add(reserveAddPassenger,"AddPassenger");
      cardPanel.add(reserveAddCustomer,"AddCustomer");
      cardPanel.add(reserveAddCustomerBC,"AddCustomerBC");
      cardPanel.add(reserveBusAndChauffeur,"ReserveBusAndChauffeur");
      cardPanel.add(reserveSeats1part,"ReserveSeats1Part");
      cardPanel.add(reserveSeats2Part,"ReserveSeats2Part");
      //cardPanel.add(reserveAddPassengerBC,"AddPassengerBC");
      cardPanel.add(reserveExtras,"ReserveExtras");
      cardPanel.add(reserveExtrasBC,"ReserveExtrasBC");
      cardPanel.add(showReservation,"ShowReservation");
      cardPanel.add(showReservationBC,"ShowReservationBC");
      cardPanel.add(addPredefinedTour,"AddPredefinedTour");
      cardPanel.add(outputPredefinedTourAdd,"OutputPredefinedTour");
      cardPanel.add(outputPredefinedTourChange,"OutputPredefinedTourChange");
      
      
      

      setContentPane(cardPanel);
   }

   public void startGui(VIABusController controller)
   {
      VIABusGUIHandler handler = new VIABusGUIHandler(this, controller);
      changePredefinedTour.addActionListener(handler);
      mainGui.addActionListener(handler);
      findGui.addActionListener(handler);
      findReservationGui.addActionListener(handler);
      findChauffeurGui.addActionListener(handler);
      findCustomerGui.addActionListener(handler);
      findOutputGui.addActionListener(handler);
      findOutputMultiGui.addActionListener(handler);
      findPredefinedTourGui.addActionListener(handler);
      reserveMain.addActionListener(handler);
      managePredefinedTour.addActionListener(handler);

      manageDataChauffeur.addActionListener(handler);
      manageMenu.addActionListener(handler);
      manageAddChauffeur.addActionListener(handler);
      manageChangeChauffeur.addActionListener(handler);
      managedeleteChauffeur.addActionListener(handler);
      manageVehicle.addActionListener(handler);
      manageAddVehicle.addActionListener(handler);
      manageDeleteVehicle.addActionListener(handler);
      manageChangeDataVehicle.addActionListener(handler);

      changeReservationGui.addActionListener(handler);
      changeCustomerGui.addActionListener(handler);
      changePassengersGui.addActionListener(handler);
      changeExtrasGui.addActionListener(handler);

      reserveAddCustomer.addActionListener(handler);
      reserveAddCustomerBC.addActionListener(handler);
      reserveAddPassenger.addActionListener(handler);
      reserveBusAndChauffeur.addActionListener(handler);
      reserveSeats1part.addActionListener(handler);
      reserveSeats2Part.addActionListener(handler);
      
   // reserveAddPassengerBC.addActionListener(handler);
      reserveExtras.addActionListener(handler);
      reserveExtrasBC.addActionListener(handler);
      showReservation.addActionListener(handler);
      showReservationBC.addActionListener(handler);
      addPredefinedTour.addActionListener(handler);
      outputPredefinedTourAdd.addActionListener(handler);
      outputPredefinedTourChange.addActionListener(handler);
      setVisible(true);
   }
   public void loadPredefinedTour(PredefinedTour pre)
   {
      changePredefinedTour.loadPredefinedTour(pre);
   }
   public void setMode(String mode)
   {
      String mode1 = mode;
      // Main menu
      if (this.mode.equals("MainMenu"))
      {
         if (mode1.equals("Manage Data"))    mode1 = "ManageMenu";
         if (mode1.equals("Reserve"))        mode1 = "ReserveMenu";
         if (mode1.equals("Find"))           mode1 = "FindMenu";
      }
      // Find Menu
      if (this.mode.equals("FindMenu"))
      {
         if (mode1.equals("Back"))           mode1 = "MainMenu";
         if (mode1.equals("Predefined Tour"))mode1 = "FindPredefinedTour";
         if (mode1.equals("Reservation"))    mode1 = "FindReservation";
         if (mode1.equals("Chauffeur"))      mode1 = "FindChauffeur";
         if (mode1.equals("Customer"))       mode1 = "FindCustomer";
      }
      // Find Predefined Tour
      if (this.mode.equals("FindPredefinedTour"))
      {
         if (mode1.equals("Back"))           mode1 = "FindMenu";
      }
      // Find Chauffeur
      if (this.mode.equals("FindChauffeur"))
      {
         if (mode1.equals("Back"))           mode1 = "FindMenu";
      }
      // Find Reservation
      if (this.mode.equals("FindReservation"))
      {
         if (mode1.equals("Back"))           mode1 = "FindMenu";
      }
      // Find Customer
      if (this.mode.equals("FindCustomer"))
      {
         if (mode1.equals("Back"))           mode1 = "FindMenu";
      }

      // Output panel
      if (this.mode.equals("output"))
      {
         if (mode1.equals("Back"))           mode1 = "MainMenu";
      }
      //Multi output panel
      if (this.mode.equals("outputMulti"))
      {
         if (mode1.equals("Back"))           mode1 = "MainMenu";
      }
      //Change Predefined tour
      if (this.mode.equals("ChangePredefinedTour"))
      {
         if(mode1.equals("Next"))            mode1 = "OutputPredefinedTourChange";
         if(mode1.equals("Back"))            mode1 = "ManagePredefinedTour";
      }
      //"OutputPredefinedTourChange"
      if (this.mode.equals("OutputPredefinedTourChange"))
      {
         if(mode1.equals("Back"))            mode1="ChangePredefinedTour";
         if(mode1.equals("Finish"))          mode1="MainMenu";
      }
      // Manage Add Vehicle
      if (this.mode.equals("ManageAddVehicle"))
      {
         if (mode1.equals("Back"))           mode1 = "ManageVehicle";
         if (mode1.equals("Cancel"))         mode1 = "MainMenu";
      }
      // Manage Delete Vehicle
      if (this.mode.equals("ManageDeleteVehicle"))
      {
         if (mode1.equals("Cancel"))         mode1 = "ManageVehicle";
      }
      // Manage Vehicle Data
      if (this.mode.equals("ManageDataVehicle"))
      {
         if (mode1.equals("Back"))           mode1 = "ManageVehicle";
         if (mode1.equals("Cancel"))         mode1 = "MainMenu";
      }
      // Manage Menu
      if (this.mode.equals("ManageMenu"))
      {
         if (mode1.equals("Chauffeur"))      mode1 = "ManageChauffeur";
         if (mode1.equals("Back"))           mode1 = "MainMenu";
         if (mode1.equals("Vehicles"))       mode1 = "ManageVehicle";
         if (mode1.equals("Reservation"))    mode1 = "FindReservation";
         if (mode1.equals("Customer"))       mode1 = "FindCustomer";
         if (mode1.equals("Predefined Tours"))mode1="ManagePredefinedTour";      
      }
      //Predefined Tour manage
      if(this.mode.equals("ManagePredefinedTour"))
      {
         if(mode1.equals("Find Predefined Tour"))mode1 = "FindPredefinedTour";
         if(mode1.equals("Home"))               mode1 = "MainMenu";
         if(mode1.equals("Back"))               mode1 = "ManageMenu";
         if(mode1.equals("Add Predefined Tour"))mode1 = "AddPredefinedTour";
      }
      // Manage Vehicle Menu
      if (this.mode.equals("ManageVehicle"))
      {
         if (mode1.equals("Add Vehicle"))    mode1 = "ManageAddVehicle";
         if (mode1.equals("Change Info"))    mode1 = "ManageDataVehicle";
         if (mode1.equals("Delete Vehicle")) mode1 = "ManageDeleteVehicle";
         if (mode1.equals("Back"))           mode1 = "ManageMenu";
         if (mode1.equals("Home"))           mode1 = "MainMenu";
      }
      // Manage Chauffeur Menu
      if (this.mode.equals("ManageChauffeur"))
      {
         if (mode1.equals("Add Chauffeur"))  mode1 = "AddNewChauffeur";
         if (mode1.equals("Change Info"))    mode1 = "ChangeChauffeur";
         if (mode1.equals("Delete Chauffeur"))mode1 = "ManageDeleteChauffeur";
         if (mode1.equals("Back"))           mode1 = "ManageMenu";
         if (mode1.equals("Home"))           mode1 = "MainMenu";

      }
      // Manage add Chauffeur
      if (this.mode.equals("AddNewChauffeur"))
      {
         if (mode1.equals("Cancel"))         mode1 = "ManageChauffeur";
      }
      // Manage Delete Chauffeur
      if (this.mode.equals("ManageDeleteChauffeur"))
      {
         if (mode1.equals("Back"))           mode1 = "ManageChauffeur";
      }
      // Manage Change Chauffeur
      if (this.mode.equals("ChangeChauffeur"))
      {
         if (mode1.equals("Cancel"))         mode1 = "ManageChauffeur";
         if (mode1.equals("Save"))           mode1 = "MainMenu";
      }
      //Change Customer
      if(this.mode.equals("ChangeCustomer"))
      {
         if(mode1.equals("Back"))          mode1 = "output";
         if(mode1.equals("Cancel"))        mode1 = "MainMenu";
      }
      // Change Reservation Menu
      if (this.mode.equals("ChangeReservation"))
      {
         if (mode1.equals("Back"))           mode1 = "ManageMenu";
         if (mode1.equals("Change Passenger Data"))mode1 = "ChangePassengers";
         if (mode1.equals("Change Extras"))  mode1 = "ChangeExtras";
         if (mode1.equals("Cancel"))         mode1 = "ManageMenu";  
      }
      // Change Passengers
      if (this.mode.equals("ChangePassengers"))
      {
         if (mode1.equals("Back"))           mode1 = "ChangeReservation";
         if (mode1.equals("Home"))           mode1 = "MainMenu";
      }
      // Change Extras
      if (this.mode.equals("ChangeExtras"))
      {
         if (mode1.equals("Back"))           mode1 = "ChangeReservation";
         if (mode1.equals("Home"))           mode1 = "MainMenu";       
      }
      // Change Customer
      if (this.mode.equals("ChangeCustomer"))
      {
         if (mode1.equals("Back"))           mode1 = "ManageMenu";
         if (mode1.equals("Cancel"))         mode1 = "ManageMenu";        
      }
      //Add Predefined Tour
      if(this.mode.equals("AddPredefinedTour"))
      {
        if(mode1.equals("Next"))             mode1="OutputPredefinedTour";
        if(mode1.equals("Back"))             mode1="ManageMenu";    
      }
      // Predefined Output
      if(this.mode.equals("OutputPredefinedTour"))
      {
        if(mode1.equals("Back"))             mode1="AddPredefinedTour";   
        if(mode1.equals("Finish"))           mode1="MainMenu";         
      }
      //Reserve seats part 1
      if(this.mode.equals("ReserveSeats1Part"))
      {
        if(mode1.equals("Back"))             mode1="ReserveMenu";  
        if(mode1.equals("Next"))             mode1="ReserveSeats2Part";
      }
      //Reserve seats part 2
      if(this.mode.equals("ReserveSeats2Part") )
      {
        if(mode1.equals("Back"))             mode1="ReserveSeats1Part"; 
        if(mode1.equals("Next"))             mode1="AddCustomer";  
      }
      //Add Customer Predefined Tour
      if(this.mode.equals("AddCustomer"))
      {
        if(mode1.equals("Next"))             mode1="AddPassenger";
        if(mode1.equals("Back"))             mode1="ReserveSeats2Part";
      }
      //Add Customer Buss & Chauffeur
      if(this.mode.equals("AddCustomerBC"))
      {
        if(mode1.equals("Next"))             mode1="ReserveExtrasBC";
        if(mode1.equals("Back"))             mode1="ReserveBusAndChauffeur";     
      }
      // Add Passenger Predefined Tour
      if(this.mode.equals("AddPassenger"))
      {
        if(mode1.equals("Add Passenger"))    mode1="AddPassenger";
        if(mode1.equals("Back"))             mode1="AddCustomer"; 
        if(mode1.equals("Next"))             mode1="ReserveExtras";
      }
      //reserve Extras Predefined tour
      if(this.mode.equals("ReserveExtras"))
      {
         if(mode1.equals("Add Extras"))       mode1="ReserveExtras";
         if(mode1.equals("Back"))             mode1="AddPassenger";
         if(mode1.equals("Next"))             mode1="ShowReservation";
       }
      //Reserve Extras Buss & Chauffeur
      if(this.mode.equals("ReserveExtrasBC"))
      {
        if(mode1.equals("Add Extras"))       mode1="ReserveExtrasBC";
        if(mode1.equals("Back"))             mode1="AddCustomerBC";
        if(mode1.equals("Next"))             mode1="ShowReservationBC";
      }
      //ReserveExtras Predefined Tour
      if(this.mode.equals("ReserveExtras"))
      {
        if(mode1.equals("Add Extras"))       mode1="ReserveExtras";         
        if(mode1.equals("Back"))             mode1="AddPassenger";       
        if(mode1.equals("Next"))             mode1="ShowReservation";    
      }
      //Show Reservation Predefined Tour
      if(this.mode.equals("ShowReservation"))
      {
        if(mode1.equals("Back"))             mode1="ReserveExtras";
        if(mode1.equals("Finish"))           mode1="MainMenu";
      }
      //Show Reservation Buss & Chauffeur
      if(this.mode.equals("ShowReservationBC"))
      {
        if(mode1.equals("Back"))             mode1="ReserveExtrasBC";
        if(mode1.equals("Finish"))           mode1="MainMenu";
      }
   
     //Reserve Buss & Chauffeur
      if(this.mode.equals("ReserveBusAndChauffeur"))
      {
        if(mode1.equals("Next"))             mode1="AddCustomerBC";
        if(mode1.equals("Back"))             mode1="ReserveMenu";
      }  
     //Reserve Menu
      if(this.mode.equals("ReserveMenu") )
      {
        if(mode1.equals("Reserve seats"))    mode1="ReserveSeats1Part";        
        if(mode1.equals("Back"))             mode1="MainMenu";
        if(mode1.equals("Reserve Bus and Chauffeur")) mode1="ReserveBusAndChauffeur";
      }
      // Switching modes
      this.mode = mode1;
      cardLayout.show(cardPanel, mode1);
   }

   public void setText(String text)
   {
      findOutputGui.setText(text);
   }
   public void setTextMulti(String text)
   {
      findOutputMultiGui.setText(text);
   }
   public void loadCustomerChange(Customer customer)
   {
      changeCustomerGui.loadCustomer(customer);
   }
   public void clear()
   {
      reserveBusAndChauffeur.clear();
      reserveAddCustomer.clear();
      reserveAddCustomerBC.clear();
      reserveAddPassenger.clear();
      reserveExtras.clear();
      reserveExtrasBC.clear();
      reserveSeats1part.clear();
      reserveSeats2Part.clear();  
   }
   public String[] getInput()
   {
      if(mode.equals("FindChauffeur"))       return findChauffeurGui.getInput();
      if(mode.equals("FindReservation"))     return findReservationGui.getInput();
      if(mode.equals("FindCustomer"))        return findCustomerGui.getInput();
      if(mode.equals("FindPredefinedTour"))  return findPredefinedTourGui.getInput();
      if(mode.equals("ChangePassengers"))    return changePassengersGui.getInput();
      if(mode.equals("ChangeExtras"))        return changeExtrasGui.getInput();
      if(mode.equals("ChangePassengers"))    return changePassengersGui.getInput();
      if(mode.equals("ChangeReservation"))   return changeReservationGui.getInput();
      if(mode.equals("AddNewChauffeur"))     return manageAddChauffeur.getInput();
      if(mode.equals("ManageDeleteChauffeur"))return managedeleteChauffeur.getInput();
      if(mode.equals("ManageChauffeur"))     return manageDataChauffeur.getInput();
      if(mode.equals("ChangeChauffeur"))     return manageChangeChauffeur.getInput();
      if(mode.equals("ChangeCustomer"))      return changeCustomerGui.getInput();
      if(mode.equals("ManageAddVehicle"))    return manageAddVehicle.getInput();
      if(mode.equals("ManageVehicle"))       return manageVehicle.getInput();
      if(mode.equals("ManageDataVehicle"))   return manageChangeDataVehicle.getInput();
      if(mode.equals("output"))              return findOutputGui.getInput();
      if(mode.equals("outputMulti"))         return findOutputMultiGui.getInput();
      if(mode.equals("ReserveSeats1Part"))   return reserveSeats1part.getInput();   
      if(mode.equals("ReserveSeats2Part"))   return reserveSeats2Part.getInput();   
      if(mode.equals("AddCustomer"))         return reserveAddCustomer.getInput();   
      if(mode.equals("AddPassenger"))        return reserveAddPassenger.getInput();
      //if(mode.equals("AddPassengerBC"))    return reserveAddPassengerBC.getInput();
      if(mode.equals("AddCustomerBC"))       return reserveAddCustomerBC.getInput();
      if(mode.equals("ReserveExtras"))       return reserveExtras.getInput();
      if(mode.equals("ReserveExtrasBC"))     return reserveExtrasBC.getInput();
      if(mode.equals("ReserveBusAndChauffeur"))return reserveBusAndChauffeur.getInput();
      if(mode.equals("AddPredefinedTour"))   return addPredefinedTour.getInput();
      if(mode.equals("ChangePredefinedTour"))return changePredefinedTour.getInput();
      
      
      return null;
   }
   public void setPreChangeText(String text)
   {
      outputPredefinedTourChange.setText(text);
   }
   public void setPreAddText(String text)
   {
      outputPredefinedTourAdd.setText(text);
   }
   public void setComboTours(PredefinedTourList list)
   {
      reserveSeats2Part.setComboboxTour(list);
   }
   public void loadReservation(Reservation reser)
   {
      changeReservationGui.loadReservation(reser);
   }
   public void loadPassengerList(PassengerList list)
   {
      changePassengersGui.loadPassengerList(list);
   }

   public void ShowExistingCustomer(Customer customer)
   {
      reserveAddCustomer.showExistingCustomer(customer);
   }
   public void ShowExistingCustomerBC(Customer customer)
   {
     reserveAddCustomerBC.showExistingCustomer(customer);
   }
   public GUIReserveAddPassenger getReserveAddPassenger()
   {
      return reserveAddPassenger;
   }
   
   public GUIReserveExtras getReserveExtras()
   {
      return reserveExtras;
   }
   public GUIReserveExtras getReserveExtrasBC()
   {
      return reserveExtrasBC;
   }
   public GUIShowReservation getShowReservation()
   {
      return showReservation;
   }
   public GUIShowReservationBC getShowReservationBC()
   {
      return showReservationBC;
   }
   public Chauffeur getChauffeur()
   {
      return manageDataChauffeur.getChauffeur();
   }
   public void loadChauffeur(Chauffeur chaf)
   {
      managedeleteChauffeur.loadChauffeur(chaf);
   }
   public void setChauffeur(Chauffeur chaf)
   {
      manageChangeChauffeur.setChauffeur(chaf);
   }
   public void updater()
   {
      manageDataChauffeur.updater();
      manageVehicle.updater();
   }
   public void loadVehicle(Vehicle vehi)
   {
      manageDeleteVehicle.loadVehicle(vehi);
   }
   public void loadExtras(ArrayList<Item> extras)
   {
      changeExtrasGui.loadExtras(extras);
   }
   public Vehicle getVehicleInfo()
   {
      return manageDeleteVehicle.getVehicleInfo();
   }
   public void changeVehicle(String a, String b)
   {
      manageChangeDataVehicle.changeVehicle(a, b);
   }
   public String getMode()
   {
      return mode;
   }

}
