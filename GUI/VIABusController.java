package GUI;

import java.util.ArrayList;

import Model.*;

import javax.swing.JOptionPane;

public class VIABusController
{
   private GUIVIABus gui;
   private VIABus model;
   private Reservation reservation;

   public VIABusController(GUIVIABus gui, VIABus model)
   {
      this.gui = gui;
      this.model = model;
      this.reservation = new Reservation();
   }

   public void execute(String mode)
   {
      String mode1 = mode;
      if (gui.getMode().equals("OutputPredefinedTourChange")
            && mode1.equals("Finish"))
      {
         executeSaveChangePredefinedTour();
      }
      if (gui.getMode().equals("FindChauffeur") && mode1.equals("Search"))
      {
         executeChauffeurSearch();
      }
      if (gui.getMode().equals("AddPredefinedTour") && mode1.equals("Next"))
      {
         executeShowPredefinedTour();
      }
      if (gui.getMode().equals("OutputPredefinedTour")
            && mode1.equals("Finish"))
      {
         executeAddPredefinedTour();
      }
      if (gui.getMode().equals("output") && mode1.equals("Change"))
      {
         executeChange();
      }
      if (gui.getMode().equals("FindReservation") && mode1.equals("Search"))
      {
         executeReservationSearch();
      }
      if (gui.getMode().equals("FindCustomer") && mode1.equals("Search"))
      {
         executeCustomerSearch();
      }
      if (gui.getMode().equals("FindPredefinedTour") && mode1.equals("Search"))
      {
         executePredefinedSearch();
      }
      if (gui.getMode().equals("AddNewChauffeur") && mode1.equals("Save"))
      {
         executeAddChauffeurSearch();
      }
      if (gui.getMode().equals("ManageDeleteChauffeur")
            && mode1.equals("Delete"))
      {
         executeDeleteChauffeur();
      }
      if (gui.getMode().equals("ManageChauffeur")
            && mode1.equals("Change Info"))
      {
         executeChangeInfoChauffeur();
      }
      if (gui.getMode().equals("ManageChauffeur")
            && mode1.equals("Delete Chauffeur"))
      {
         executePassInfoDeleteChauffeur();
      }
      if (gui.getMode().equals("ChangeChauffeur") && mode1.equals("Save"))
      {
         executeChangeInfoSave();
      }
      if (gui.getMode().equals("ManageAddVehicle") && mode1.equals("Save"))
      {
         executeSaveVehicle();
      }
      if (gui.getMode().equals("ManageVehicle")
            && mode1.equals("Delete Vehicle"))
      {
         executePassInfoVehicleToDelete();
      }
      if (gui.getMode().equals("outputMulti") && mode1.equals("Change"))
      {
         executeChangeReservationPredefinedTour();
      }
      if (gui.getMode().equals("ManageDeleteVehicle") && mode1.equals("Delete"))
      {
         executeDeleteVehicle();
      }
      if (gui.getMode().equals("ChangeCustomer") && mode1.equals("Save"))
      {
         executeSaveCustomer();
      }
      if (gui.getMode().equals("ManageVehicle") && mode1.equals("Change Info"))
      {
         executePassInfoVehicleToChange();
      }
      if (gui.getMode().equals("ManageDataVehicle") && mode1.equals("Save"))
      {
         executeChangeVehicle();
      }
      if (mode1.equals("Next") && gui.getMode().equals("ReserveSeats1Part"))
      {
         executeReserveSeatsSearchForTour();

      }

      if (gui.getMode().equals("ReserveSeats2Part") && mode1.equals("Next"))
      {
         executeDispayCustomer();
         executeAddReserveSeats2Part();

      }
      if (gui.getMode().equals("ReserveBusAndChauffeur")
            && mode1.equals("Next"))
      {
         executeReserveBusAndChauffeur();
         executeDispayCustomerBC();

      }
      if (gui.getMode().equals("ReserveExtrasBC") && mode1.equals("Next"))
      {
         executeShowReservationBC();
      }
      if (gui.getMode().equals("ReserveExtras") && mode1.equals("Next"))
      {
         executeShowReservation();
      }
      if (gui.getMode().equals("AddPassenger") && mode1.equals("Add Passenger"))
      {

         gui.setMode("ReserveSeats1Part");
         String[] input3 = gui.getInput();
         int numberOfPassengers = Integer.parseInt(input3[1]);
         gui.setMode("AddPassenger");
         int count = Integer.parseInt(gui.getReserveAddPassenger()
               .getTextCounter());
         String countText = "";
         if (count < numberOfPassengers)
         {
            count++;
            countText += count;

            gui.getReserveAddPassenger().setTextCounter(countText);
         }
         else
         {
            JOptionPane.showMessageDialog(null,
                  "You can not add more passengers than the number of seats..",
                  "Warning", JOptionPane.WARNING_MESSAGE);
         }
      }
      if (gui.getMode().equals("ReserveExtras") && mode1.equals("Add Extras"))
      {
         executeAddExtras();
      }
      if (gui.getMode().equals("ReserveExtrasBC") && mode1.equals("Add Extras"))
      {
         executeAddExtrasBC();
      }
      if (gui.getMode().equals("AddCustomer") && mode1.equals("Next"))
      {
         executeAddCustomer();
      }
      if (gui.getMode().equals("AddCustomerBC") && mode1.equals("Next"))
      {
         executeAddCustomerBC();
      }

      if (gui.getMode().equals("AddPassenger") && mode1.equals("Add Passenger"))
      {
         executeAddPassenger();
      }
      if (gui.getMode().equals("ShowReservation") && mode1.equals("Finish"))
      {
         executeSaveReservation();
      }
      if (gui.getMode().equals("ChangePredefinedTour") && mode1.equals("Next"))
      {
         executeShowChangePredefinedTour();
      }
      if (gui.getMode().equals("ChangeReservation") && mode1.equals("Save"))
      {
         executeSaveChangedReservation();
      }
      if (gui.getMode().equals("ChangeReservation")
            && mode1.equals("Change Extras"))
      {
         executeChangeExtras();
      }
      if (gui.getMode().equals("ChangeExtras") && mode1.equals("Save"))
      {
         executeSaveExtras();
      }
      if (gui.getMode().equals("ChangeReservation")
            && mode1.equals("Change Passenger Data"))
      {
         executeChangePassengerData();
      }
      if (gui.getMode().equals("ChangeReservation") && mode1.equals("Delete"))
      {
         executeDeleteReservation();
      }
      if (gui.getMode().equals("ChangePassengers") && mode1.equals("Save"))
      {
         executeSavePassengers();
      }

      if (gui.getMode().equals("ShowReservationBC") && mode1.equals("Finish"))
      {
         executeSaveReservationBC();
      }
      if ((mode1.equals("Save") || mode1.equals("Finish"))
            && (!gui.getMode().equals("ChangePassengers") || gui.getMode()
                  .equals("ChangeExtras")))
      {
         gui.clear();
      }
      if (!mode1.equals("Search") && !mode1.equals("Save")
            && !mode1.equals("Delete") && !mode1.equals("Change"))
      {
         gui.setMode(mode1);

      }
      model.save();

   }

   private void executeSaveChangedReservation()
   {
      String[] data = gui.getInput();
      int resnr = Integer.parseInt(data[0]);
      String phone = data[2];
      String dest = data[4];
      String[] dates = data[5].split(" ");
      int sminute = Integer.parseInt(dates[1].split(":")[0]);
      int shour = Integer.parseInt(dates[1].split(":")[1]);
      int sday = Integer.parseInt(dates[0].split("/")[0]);
      int smonth = Integer.parseInt(dates[0].split("/")[1]);
      int syear = Integer.parseInt(dates[0].split("/")[2]);
      DateTime start = new DateTime(sminute,shour,sday,smonth,syear);
      int eminute = Integer.parseInt(dates[3].split(":")[0]);
      int ehour = Integer.parseInt(dates[3].split(":")[1]);
      int eday = Integer.parseInt(dates[2].split("/")[0]);
      int emonth = Integer.parseInt(dates[2].split("/")[1]);
      int eyear = Integer.parseInt(dates[2].split("/")[2]);
      DateTime end = new DateTime(eminute,ehour,eday,emonth,eyear);
      DateInterval dateint = new DateInterval(start, end);
      Reservation res = new Reservation();
      res.setTour(model.getReservationList().getReservationByReservationNumber(resnr).getTour());
      res.getTour().setDateInterVal(dateint);
      res.getTour().setDestination(dest);
      res.setCustomer(model.getCustomerList().getCustomerByNumber(phone));
      int chafID = Integer.parseInt(data[6].split(",")[0]);
      res.setChauffeur(model.getChauffeurList().getChauffeurByID(chafID));
      String busName = data[7];
      res.setNumber(resnr);
      if(busName.equals("Bus"))
      {
         res.setVehicle(model.getVehicleList().getAllAvaiableBuses().get(0));
         model.getReservationList().setReservationByNumber(resnr, res);
      }
      if(busName.equals("Party Bus"))
      {
         res.setVehicle(model.getVehicleList().getAllAvaiablePartyBuses().get(0));
         model.getReservationList().setReservationByNumber(resnr, res);
      }
      if(busName.equals("Mini Bus"))
      {
         res.setVehicle(model.getVehicleList().getAllAvaiableMiniBuses().get(0));
         model.getReservationList().setReservationByNumber(resnr, res);
      }
      gui.setMode("MainMenu");
      
      
      
      
      
      
      
      
   }

   private void executeSaveReservationBC()
   {
      gui.setMode("AddCustomerBC");
      String[] input = gui.getInput();
      String name = (input[0].trim());
      String address = input[1].trim();
      String phone = input[2].trim();
      Customer customer = new Customer(name, address, phone);
      customer.increaseCounterByOne();
      gui.setMode("ShowReservationBC");

      model.getCustomerList().addCustomer(customer);

      model.addReservation(reservation);

      model.save();
      reservation = null;
   }

   private void executeSaveReservation()
   {
      gui.setMode("AddCustomer");
      String[] input = gui.getInput();
      gui.setMode("ReserveSeats1Part");
      int seats = Integer.parseInt(gui.getInput()[1]);
      String name = (input[0].trim());
      String address = input[1].trim();
      String phone = input[2].trim();

      Customer customer = new Customer(name, address, phone);
      customer.increaseCounterByOne();
      gui.setMode("ShowReservation");
      PredefinedTour a = (PredefinedTour) reservation.getTour();
      a.decrementSeats(seats);
      model.getCustomerList().addCustomer(customer);
      model.addReservation(reservation);

      model.save();
      reservation = null;

   }

   private void executeSaveExtras()
   {
      if (!gui.getInput()[0].equals(""))
      {
         String[] extralist = gui.getInput()[0].split(";");
         ArrayList<Item> a = new ArrayList<>();
         for (int i = 0; i < extralist.length - 1; i++)
         {

            String[] data = extralist[i].split(":");
            String itemname = data[0].trim();
            double price = Double.parseDouble(data[1].trim());
            Item it = new Item();
            it.setName(itemname);
            it.setPrice(price);
            a.add(it);
         }
         gui.setMode("ChangeReservation");
         model.getReservationList()
               .getReservationByReservationNumber(
                     Integer.parseInt(gui.getInput()[0])).setItemList(a);
         ;
      }

   }

   private void executeChangeExtras()
   {
      int regnr = Integer.parseInt(gui.getInput()[0]);
      gui.loadExtras(model.getReservationList()
            .getReservationByReservationNumber(regnr).getItems());

   }

   private void executeSavePassengers()
   {
      gui.setMode("ChangePassengers");
      if (!gui.getInput()[0].equals(""))
      {
         String[] passengerlist = gui.getInput()[0].split(";");
         PassengerList a = new PassengerList();
         System.out.println(passengerlist.length);
         for (int i = 0; i < passengerlist.length; i++)
         {
            String[] data = passengerlist[i].split(":");
            String name = data[0].trim();
            int age = Integer.parseInt(data[1]);
            a.addPassenger(new Passenger(name, age));
         }
         System.out.println(a);
         gui.setMode("ChangeReservation");
         model.getReservationList()
               .getReservationByReservationNumber(
                     Integer.parseInt(gui.getInput()[0])).setPassengerList(a);
      }

   }

   private void executeChangePassengerData()
   {
      int regnr = Integer.parseInt(gui.getInput()[0]);
      gui.loadPassengerList(model.getReservationList()
            .getReservationByReservationNumber(regnr).getPassengerList());

   }

   private void executeDeleteReservation()
   {
      int regnr = Integer.parseInt(gui.getInput()[0]);
      model.getReservationList().removeReservation(regnr);
      gui.setMode("MainMenu");

   }

   private void executeSaveChangePredefinedTour()
   {
      gui.setMode("outputMulti");
      String[] dataoutput = gui.getInput();
      String search = dataoutput[0].split(":")[1].trim();
      int index = Integer.parseInt(dataoutput[1]);
      gui.setMode("FindPredefinedTour");
      String value = gui.getInput()[1].trim();
      PredefinedTour tour = null;
      System.out.println(search);
      if (search.equals("Destination"))
      {
         tour = model.getPredefinedTourList()
               .getAllPredefinedTourByDestination(value).get(index - 1);
      }
      if (search.equals("Start"))
      {
         String[] data = value.split("/");
         int day = Integer.parseInt(data[0]);
         int month = Integer.parseInt(data[1]);
         int year = Integer.parseInt(data[2]);
         DateTime time = new DateTime(day, month, year);
         System.out.println(time);
         tour = model.getPredefinedTourList().getAllToursOnStartDate(time)
               .get(index - 1);
      }
      if (search.equals("End"))
      {
         String[] data = value.split("/");
         int day = Integer.parseInt(data[0]);
         int month = Integer.parseInt(data[1]);
         int year = Integer.parseInt(data[2]);
         DateTime time = new DateTime(day, month, year);
         tour = model.getPredefinedTourList().getAllToursOnEndDate(time)
               .get(index - 1);
      }
      if (search.equals("Chauffeur"))
      {
         tour = model.getPredefinedTourList()
               .getAllPredefinedTourByChauffeurName(value).get(index - 1);
      }
      System.out.println(tour);
      model.getPredefinedTourList().removePredefinedTour(tour);

      gui.setMode("ChangePredefinedTour");
      String[] input = gui.getInput();
      String destination = input[0];
      String[] data = input[1].split(" ");
      int day = Integer.parseInt(data[0].split("/")[0]);
      int month = Integer.parseInt(data[0].split("/")[1]);
      int year = Integer.parseInt(data[0].split("/")[2]);
      int hour = Integer.parseInt(data[1].split(":")[0]);
      int minute = Integer.parseInt(data[1].split(":")[1]);
      DateTime startdate = new DateTime(hour, minute, day, month, year);
      String[] data1 = input[2].split(" ");
      int day1 = Integer.parseInt(data1[0].split("/")[0]);
      int month1 = Integer.parseInt(data1[0].split("/")[1]);
      int year1 = Integer.parseInt(data1[0].split("/")[2]);
      int hour1 = Integer.parseInt(data1[1].split(":")[0]);
      int minute1 = Integer.parseInt(data1[1].split(":")[1]);
      DateTime enddate = new DateTime(hour1, minute1, day1, month1, year1);

      Chauffeur chaf = model.getChauffeurList().getChauffeurByID(
            Integer.parseInt(input[3].split(", ")[0]));
      PartyBus pb = null;
      Bus b = null;
      MiniBus mb = null;
      double price = Double.parseDouble(input[5]);
      if (input[4].equals("Bus"))
      {
         b = (Bus) model.getVehicleList().getAllAvaiableBuses().get(0);
         model.addPredefinedTour(new PredefinedTour(destination,
               new DateInterval(startdate, enddate), b, chaf, price));
      }
      if (input[4].equals("MiniBus"))
      {
         mb = (MiniBus) model.getVehicleList().getAllAvaiableMiniBuses().get(0);
         model.addPredefinedTour(new PredefinedTour(destination,
               new DateInterval(startdate, enddate), mb, chaf, price));
      }
      if (input[4].equals("PartyBus"))
      {
         pb = (PartyBus) model.getVehicleList().getAllAvaiablePartyBuses()
               .get(0);
         model.addPredefinedTour(new PredefinedTour(destination,
               new DateInterval(startdate, enddate), pb, chaf, price));
      }
      gui.setMode("OutputPredefinedTourChange");

   }

   private void executeShowChangePredefinedTour()
   {
      gui.setMode("ChangePredefinedTour");
      String[] input = gui.getInput();
      String text = input[0] + "\n " + input[1] + "\n " + input[2] + "\n "
            + input[3] + "\n " + input[4] + "\n " + input[5];
      gui.setPreChangeText(text);
   }

   private void executeShowPredefinedTour()
   {
      gui.setMode("AddPredefinedTour");
      String[] input = gui.getInput();
      String text = input[0] + "\n " + input[1] + "\n " + input[2] + "\n "
            + input[3] + "\n " + input[4] + "\n " + input[5];
      gui.setPreAddText(text);
   }

   private void executeAddPredefinedTour()
   {
      gui.setMode("AddPredefinedTour");
      String[] input = gui.getInput();
      String destination = input[0];
      String[] data = input[1].split(" ");
      int day = Integer.parseInt(data[0].split("/")[0]);
      int month = Integer.parseInt(data[0].split("/")[1]);
      int year = Integer.parseInt(data[0].split("/")[2]);
      int hour = Integer.parseInt(data[1].split(":")[0]);
      int minute = Integer.parseInt(data[1].split(":")[1]);
      DateTime startdate = new DateTime(minute, hour, day, month, year);
      String[] data1 = input[2].split(" ");
      int day1 = Integer.parseInt(data1[0].split("/")[0]);
      int month1 = Integer.parseInt(data1[0].split("/")[1]);
      int year1 = Integer.parseInt(data1[0].split("/")[2]);
      int hour1 = Integer.parseInt(data1[1].split(":")[0]);
      int minute1 = Integer.parseInt(data1[1].split(":")[1]);
      DateTime enddate = new DateTime(minute1, hour1, day1, month1, year1);
      Chauffeur chaf = model.getChauffeurList().getChauffeurByID(
            Integer.parseInt(input[3].split(", ")[0]));
      PartyBus pb = null;
      Bus b = null;
      MiniBus mb = null;
      double price = Double.parseDouble(input[5]);
      if (input[4].equals("Bus"))
      {
         b = (Bus) model.getVehicleList().getAllAvaiableBuses().get(0);
         model.addPredefinedTour(new PredefinedTour(destination,
               new DateInterval(startdate, enddate), b, chaf, price));
      }
      if (input[4].equals("MiniBus"))
      {
         mb = (MiniBus) model.getVehicleList().getAllAvaiableMiniBuses().get(0);
         model.addPredefinedTour(new PredefinedTour(destination,
               new DateInterval(startdate, enddate), mb, chaf, price));
      }
      if (input[4].equals("PartyBus"))
      {
         pb = (PartyBus) model.getVehicleList().getAllAvaiablePartyBuses()
               .get(0);
         model.addPredefinedTour(new PredefinedTour(destination,
               new DateInterval(startdate, enddate), pb, chaf, price));
      }
      gui.setMode("OutputPredefinedTour");

   }

   private void executeChangeReservationPredefinedTour()
   {
      String[] input = gui.getInput();
      gui.setMode("FindReservation");
      String value1 = gui.getInput()[1];
      gui.setMode("FindPredefinedTour");
      String value = gui.getInput()[1];
      gui.setMode("outputMulti");
      String type = input[0].split(":")[0];
      String searcher = input[0].split(":")[1].trim();// search method
      System.out.println(type);
      int index = Integer.parseInt(input[1]);
      if (type.equals("PredefinedTour"))
      {
         PredefinedTour tur = null;
         if (searcher.equals("End"))
         {
            String[] date = value.split("/");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);
            DateTime a = new DateTime(day, month, year);
            tur = model.getPredefinedTourList().getAllToursOnEndDate(a)
                  .get(index - 1);
         }
         if (searcher.equals("Start"))
         {
            String[] date = value.split("/");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);
            DateTime a = new DateTime(day, month, year);
            tur = model.getPredefinedTourList().getAllToursOnEndDate(a)
                  .get(index - 1);
         }
         if (searcher.equals("Destination"))
         {
            tur = model.getPredefinedTourList()
                  .getAllPredefinedTourByDestination(value).get(index - 1);

         }
         if (searcher.equals("Chauffeur"))
         {

         }
         if (tur != null)
         {
            gui.loadPredefinedTour(tur);
            gui.setMode("ChangePredefinedTour");
         }
      }
      if (type.equals("Reservation"))
      {
         Reservation res = null;
         if (searcher.equals("Start"))
         {
            String[] date = value1.split("/");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);
            DateTime a = new DateTime(day, month, year);
            res = model.getReservationList().getAllReservationsByStartDate(a)
                  .get(index - 1);
         }
         if (searcher.equals("End"))
         {
            String[] date = value1.split("/");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);
            DateTime a = new DateTime(day, month, year);
            res = model.getReservationList().getAllReservationsByEndDate(a)
                  .get(index - 1);
         }
         if (searcher.equals("Customer"))
         {
            res = model.getReservationList()
                  .getAllReservationsByCustomerName(value1).get(index - 1);
         }
         gui.loadReservation(res);
         gui.setMode("ChangeReservation");
      }
   }

   private void executeSaveCustomer()
   {

      gui.setMode("output");
      String[] input = gui.getInput();
      String name = input[0].split(":")[2].trim().split(" ")[0];
      String phonenumber = input[0].split(":")[4].split(" ")[0];
      System.out.println(name);
      Customer oldcust = model.getCustomerList().getCustomerByName(name);
      gui.setMode("ChangeCustomer");
      String[] data = gui.getInput();
      String namenew = data[0];
      String phone = data[1];
      String address = data[2];
      boolean emailon = Boolean.parseBoolean(data[3]);
      String email = "";
      if (emailon)
         email = data[4];
      boolean isCompany = Boolean.parseBoolean(data[5]);
      String companyName = "";
      if (isCompany)
      {
         companyName = data[6];
      }
      System.out.println(oldcust);
      model.getCustomerList().removeCustomer(name, phonenumber);
      Customer js = new Customer(namenew, address, phone, email, companyName);
      System.out.println(js);
      model.getCustomerList().addCustomer(js);

   }

   private void executeChange()
   {
      String[] input = gui.getInput();

      String type = input[0].split(":")[0].trim();

      System.out.println(type);
      if (type.equals("Customer"))
      {
         String name = input[0].split(":")[2].trim().split(" ")[0];
         gui.setMode("ChangeCustomer");
         System.out.println(name);
         gui.loadCustomerChange(model.getCustomerList().getCustomerByName(name));
      }
      if (type.equals("Chauffeur"))
      {
         String chafname = input[0].split(":")[1].split(";")[0].trim();
         gui.setMode("ChangeChauffeur");
         System.out.println(chafname);
         gui.setChauffeur(model.getChauffeurList().getChauffeurByName(chafname));

      }

   }

   private void executePassInfoVehicleToDelete()
   {
      try
      {
         String[] data = gui.getInput();
         String[] input = data[0].split(", ");
         Vehicle a = model.getVehicleList().getVehicleByRegistrationNumber(
               input[0]);
         if (input[1].equals("PartyBus"))
         {
            gui.loadVehicle((PartyBus) a);
         }
         else if (input[1].equals("MiniBus"))
         {
            gui.loadVehicle((MiniBus) a);
         }
         else if (input[1].equals("Bus"))
         {
            gui.loadVehicle((Bus) a);
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }

   }

   private void executePassInfoVehicleToChange()
   {
      try
      {
         System.out.println("koa");
         String[] input = gui.getInput();
         String[] data = input[0].split(", ");
         gui.changeVehicle(data[0], data[1]);
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   private void executeChangeVehicle()
   {
      try
      {
         System.out.println("123");
         gui.setMode("ManageVehicle");
         String[] input = gui.getInput();
         String[] data = input[0].split(", ");
         model.getVehicleList().removeVehicle(data[0]);
         gui.setMode("ManageDataVehicle");
         String[] data1 = gui.getInput();
         System.out.println(data1[1]);
         MiniBus mini = new MiniBus(data1[0]);
         PartyBus party = new PartyBus(data1[0]);
         Bus bus = new Bus(data1[0]);
         if (data1[0].equals(""))
         {
            throw new IllegalArgumentException();
         }
         if (data1[1].equals("Mini Bus"))
         {
            model.addVehicle(mini);
         }
         else if (data1[1].equals("Party Bus"))
         {
            model.addVehicle(party);
         }
         else if (data[1].equals("Bus"))
         {
            model.addVehicle(bus);
         }
         model.save();
         gui.updater();
         gui.setMode("MainMenu");
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }

   }

   private void executeDeleteVehicle()
   {
      try
      {
         Vehicle a = gui.getVehicleInfo();
         System.out.println(a.getRegNumber());
         model.getVehicleList().removeVehicle(a.getRegNumber());
         gui.updater();

         gui.setMode("MainMenu");
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   private void executeSaveVehicle()
   {
      try
      {
         String[] data = gui.getInput();
         MiniBus mini = new MiniBus(data[0]);
         PartyBus party = new PartyBus(data[0]);
         Bus bus = new Bus(data[0]);
         if (data[0].equals(""))
         {
            throw new IllegalArgumentException();
         }
         if (data[1].equals("Mini Bus"))
         {
            model.addVehicle(mini);
         }
         else if (data[1].equals("Party Bus"))
         {
            model.addVehicle(party);
         }
         else if (data[1].equals("Bus"))
         {
            model.addVehicle(bus);
         }
         model.save();
         gui.updater();
         gui.setMode("MainMenu");
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }

   }

   private void executeChangeInfoSave()
   {
      try
      {
         gui.setMode("ChangeChauffeur");
         String[] data = gui.getInput();
         String name = data[0];
         int id = Integer.parseInt(data[1]);
         String address = data[2];
         boolean isfulltime = Boolean.parseBoolean(data[3]);
         String number = data[4];
         String email = data[5];
         String pref = data[6];
         Chauffeur chaf = new Chauffeur(name, id, address, true, isfulltime,
               email, number, pref);
         boolean found = true;
         System.out.println(chaf);
         for (int i = 0; i < model.getChauffeurList()
               .getAllAvailableChauffeurs().length; i++)
         {
            if (model.getChauffeurList().getAllAvailableChauffeurs()[i]
                  .equals(chaf))
            {
               found = false;
            }
         }
         if (found)
         {
            model.getChauffeurList().deleteChauffeur(gui.getChauffeur());
            model.addChauffeur(chaf);
         }
         model.save();
         gui.updater();
         gui.setMode("MainMenu");
      }
      catch (Exception e)
      {
         gui.setMode("MainMenu");
         e.printStackTrace();
      }

   }

   private void executeChangeInfoChauffeur()
   {

      try
      {
         gui.setChauffeur(gui.getChauffeur());
      }
      catch (Exception e)
      {
      }

   }

   private void executePassInfoDeleteChauffeur()
   {
      try
      {
         String[] input = gui.getInput();
         String data[] = input[0].split(", ");
         gui.loadChauffeur(model.getChauffeurList().getChauffeurByID(
               Integer.parseInt(data[0])));
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   private void executeDeleteChauffeur()
   {
      try
      {
         gui.setMode("ManageChauffeur");
         String[] input = gui.getInput();
         String[] data = input[0].split(", ");
         model.getChauffeurList()
               .removeChauffeurByID(Integer.parseInt(data[0]));
         gui.updater();
      }

      catch (Exception e)
      {
         gui.setMode("MainMenu");
      }
      gui.setMode("MainMenu");
   }

   private void executeAddChauffeurSearch()
   {
      String[] input = gui.getInput();
      try
      {
         for (int i = 0; i < input.length; i++)
         {
            if (input[i] == null)
            {
               throw new IllegalArgumentException();
            }
         }
         String name = input[0];
         int id = Integer.parseInt(input[1]);
         String address = input[2];
         String emailAddress = input[3];
         String phoneNumber = input[4];
         String preferences = input[5];
         boolean isFullTime = Boolean.parseBoolean(input[6]);
         model.addChauffeur(new Chauffeur(name, id, address, true, isFullTime,
               emailAddress, phoneNumber, preferences));
         model.save();
         gui.updater();
      }

      catch (Exception e)
      {
         gui.setMode("MainMenu");
      }
      gui.setMode("MainMenu");
   }

   private void executePredefinedSearch()
   {

      String text = "";
      String[] input = gui.getInput();
      try
      {
         String what = input[0];
         String value = input[1];

         switch (what)
         {
            case "Start Date":
               String[] date = value.split("/");
               int day = Integer.parseInt(date[0]);
               int month = Integer.parseInt(date[1]);
               int year = Integer.parseInt(date[2]);
               DateTime a = new DateTime(day, month, year);
               PredefinedTourList sd = model.getPredefinedTourList()
                     .getAllToursOnStartDate(a);
               text += "PredefinedTour: Start: \n" + sd;
               break;
            case "End Date":
               String[] date1 = value.split("/");
               int day1 = Integer.parseInt(date1[0]);
               int month1 = Integer.parseInt(date1[1]);
               int year1 = Integer.parseInt(date1[2]);
               DateTime a1 = new DateTime(day1, month1, year1);
               PredefinedTourList sd1 = model.getPredefinedTourList()
                     .getAllToursOnEndDate(a1);
               text += "PredefinedTour: End: \n" + sd1;
               break;
            case "Destination":
               PredefinedTourList sd2 = model.getPredefinedTourList()
                     .getAllPredefinedTourByDestination(value);
               text += "PredefinedTour: Destination: \n" + sd2;
               break;
            case "Chauffeur":
               PredefinedTourList sd3 = model.getPredefinedTourList()
                     .getAllPredefinedTourByChauffeurName(value);
               text += "PredefinedTour: Chauffeur: \n" + sd3;
               break;

         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
         text = input[0];
      }
      gui.setTextMulti(text);
      gui.setMode("outputMulti");

   }

   private void executeChauffeurSearch()
   {
      Chauffeur chauf = null;
      String text = "";
      String[] input = gui.getInput();
      try
      {
         String what = input[0];
         String value = input[1];

         switch (what)
         {
            case "ID":
               int id = Integer.parseInt(value);
               chauf = model.getChauffeurList().getChauffeurByID(id);
               text += "Chauffeur: " + chauf.toString();
               break;
            case "Name":
               chauf = model.getChauffeurList().getChauffeurByName(value);
               text += "Chauffeur: " + chauf.toString();
               break;
         }
      }
      catch (Exception e)
      {
         text = "error";
      }
      gui.setText(text);
      gui.setMode("output");

   }

   private void executeCustomerSearch()
   {
      Customer customer = null;
      String text = "";
      String[] input = gui.getInput();
      try
      {
         String what = input[0];
         String value = input[1];

         switch (what)
         {
            case "Company":
               customer = model.getCustomerList().getCustomerByCompanyName(
                     value);
               text += "Customer: " + customer.toString();
               break;
            case "Name":
               customer = model.getCustomerList().getCustomerByName(value);
               text += "Customer: " + customer.toString();
               break;
            case "Phone Number":
               customer = model.getCustomerList().getCustomerByNumber(value);
               text += "Customer: " + customer.toString();
               break;
         }
      }
      catch (Exception e)
      {
         text = gui.getInput()[1];
      }
      gui.setText(text);
      gui.setMode("output");

   }

   private void executeReservationSearch()
   {
      Reservation reservation = null;
      String text = "";
      String[] input = gui.getInput();
      try
      {
         String what = input[0];
         String value = input[1];

         switch (what)
         {
            case "Start Date":
               String[] date = value.split("/");
               int day = Integer.parseInt(date[0]);
               int month = Integer.parseInt(date[1]);
               int year = Integer.parseInt(date[2]);
               DateTime a = new DateTime(day, month, year);
               ReservationList res1 = model.getReservationList()
                     .getAllReservationsByStartDate(a);
               text += "Reservation: Start: \n";
               text += res1.toString();
               break;
            case "End Date":
               String[] date1 = value.split("/");
               int day1 = Integer.parseInt(date1[0]);
               int month1 = Integer.parseInt(date1[1]);
               int year1 = Integer.parseInt(date1[2]);
               DateTime a1 = new DateTime(day1, month1, year1);
               ReservationList res2 = model.getReservationList()
                     .getAllReservationsByEndDate(a1);
               text += "Reservation: End: \n";
               text += res2.toString();
               break;
            case "Customer":
               ReservationList reslist = model.getReservationList()
                     .getAllReservationsByCustomerName(value);
               text += "Reservation: Customer: \n" + reslist.toString();
               break;
            case "Reservation Number":
               int number = Integer.parseInt(value);
               reservation = model.getReservationList()
                     .getReservationByReservationNumber(number);
               gui.loadReservation(reservation);
               text += "Reservation: ReservationNumber: \n"
                     + reservation.toString();
               break;
         }
         gui.setTextMulti(text);
         gui.setMode("outputMulti");
         if (what.equals("Reservation Number"))
         {
            gui.setMode("ChangeReservation");
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
         text = "error";
      }

   }

   private void executeAddReserveSeats2Part()
   {
      String[] input = gui.getInput();
      try
      {
         if (reservation == null)
         {
            reservation = new Reservation();
         }
         // System.out.println("Add 2 part");
         String tour = (input[0].trim());
         String tourDestination[] = tour.split(" ");
         String tourName = tourDestination[2];

         boolean ckeckBusStop = Boolean.parseBoolean(input[1].trim());

         if (ckeckBusStop)
         {
            String busStop = input[2].trim();
            String dateTime = input[3].trim();
            String[] all = dateTime.split(" ");
            String[] date = all[0].split("/");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            String yearString = (date[2]);
            String yearSplit[] = yearString.split(" ");
            int year = Integer.parseInt(yearSplit[0]);
            String[] time = all[1].split(":");
            int hour = Integer.parseInt(time[0]);
            int minute = Integer.parseInt(time[1]);
            Time t = new Time(hour, minute);
            DateTime a = new DateTime(day, month, year, t);
            BusStop stop = new BusStop(busStop, a);
            PredefinedTour prdefinedTour = model.getPredefinedTourList()
                  .getPredefinedTourByDestination(tourName);
            // System.out.println(prdefinedTour);
            // System.out.println(prdefinedTour.getRoute());
            // System.out.println(stop);
            model.getPredefinedTourList().addBusStop(prdefinedTour, stop);

         }

      }
      catch (Exception e)
      {
         e.printStackTrace();
      }

   }

   private void executeDispayCustomer()

   {
      Customer customer = null;
      gui.setMode("ReserveSeats1Part");
      String[] input = gui.getInput();

      String name = input[3].trim();
      if (!name.equals(""))
      {
         customer = model.getCustomerList().getCustomerByName(name);
      }
      System.out.println(customer);

      gui.setMode("ReserveSeats2Part");

      gui.ShowExistingCustomer(customer);

   }

   private void executeDispayCustomerBC()

   {
      // System.out.println("display customer");
      Customer customer = null;
      gui.setMode("ReserveBusAndChauffeur");
      String[] input = gui.getInput();
      boolean checkAlreadyInSystem = Boolean.parseBoolean(input[3]);
      // System.out.println(input[3]);
      String name = input[4].trim();
      if (!name.equals("") && checkAlreadyInSystem)
      {
         customer = model.getCustomerList().getCustomerByName(name);
      }

      gui.ShowExistingCustomerBC(customer);

   }

   private void executeReserveSeatsSearchForTour()
   {

      PredefinedTourList tour = null;

      String[] input = gui.getInput();
      try
      {
         String destination = input[0];
         int numberOfSeats = Integer.parseInt(input[1].trim());

         tour = model.getPredefinedTourList()
               .getPredefinedToursByDestenationAndSeats(destination,
                     numberOfSeats);

         gui.setComboTours(tour);
         // System.out.println(customer);

      }

      catch (Exception e)
      {

      }

   }

   private void executeAddCustomer()
   {
      String[] input = gui.getInput();
      try
      {
         if (reservation == null)
         {
            reservation = new Reservation();
         }
         // Reservation reservation = null;
         String name = (input[0].trim());
         String address = input[1].trim();
         String phone = input[2].trim();
         Customer customer = new Customer(name, address, phone);

         String email = (input[4].trim());
         if (!email.equals(""))
         {
            customer.setEmailAddress(email);
         }
         String companyName = (input[6].trim());
         if (!companyName.equals(""))
         {
            customer.setCompanyName(companyName);
         }

         // model.getCustomerList().addCustomer(customer);
         gui.setMode("ReserveSeats2Part");
         String input1[] = gui.getInput();
         String[] data = input1[0].split(" ");

         // System.out.println(model.getPredefinedTourList()
         // .getPredefinedTourByDestination(data[2].trim()));
         reservation.setTour(model.getPredefinedTourList()
               .getPredefinedTourByDestination(data[2].trim()));
         reservation.addCustomer(customer);

         gui.setMode("AddCustomer");

      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   private void executeAddCustomerBC()
   {
      // System.out.println("add customer");
      // try{
      /*
       * String[] input = gui.getInput(); Vehicle vehicle=null; Chauffeur
       * chauffeur=null; //Reservation reservation=new Reservation(); Customer
       * customer=null; Tour tour=null; String text="";
       */try
      {
         String[] input = gui.getInput();
         String name = (input[0].trim());
         String address = input[1].trim();
         String phone = input[2].trim();
         Customer customer = new Customer(name, address, phone);
         String email = (input[4].trim());
         if (!email.equals(""))
         {
            customer.setEmailAddress(email);
         }
         String companyName = (input[6].trim());
         if (!companyName.equals(""))
         {
            customer.setCompanyName(companyName);
         }
         reservation.addCustomer(customer);

         model.save();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   private void executeAddPassenger()
   {

      String[] input = gui.getInput();
      try
      {
         gui.setMode("ReserveSeats1Part");
         String[] input3 = gui.getInput();
         int numberOfPassengers = Integer.parseInt(input3[1]);
         gui.setMode("AddPassenger");
         int count = Integer.parseInt(gui.getReserveAddPassenger()
               .getTextCounter());
         if (count < numberOfPassengers)
         {
            String name = (input[0].trim());
            // System.out.println(name);
            int age = Integer.parseInt((input[1].trim()));
            Passenger pas1 = new Passenger(name, age);
            reservation.addPassenger(pas1);
         }

         gui.getReserveAddPassenger().clearText();
         model.save();
         gui.setMode("AddPassenger");
      }
      catch (Exception e)
      {
         e.printStackTrace();
         // System.out.println("Catch block");
      }
   }

   private void executeAddExtras()
   {
      try
      {
         String input[] = gui.getInput();
         String extra = input[0].trim();

         // System.out.println(extra);

         int amount = Integer.parseInt(input[1].trim());
         double price = Double.parseDouble(input[2].trim());

         // System.out.println(price);

         Item item = new Item();
         item.setName(extra);
         item.setPrice(price);
         item.setAmount(amount);
         reservation.addItem(item);
         gui.setMode("ReserveExtras");
         // System.out.println(reservation);
         gui.getReserveExtras().clear();

      }

      catch (Exception e)
      {
         e.printStackTrace();
      }

   }

   private void executeAddExtrasBC()
   {

      // System.out.println("reserve extrasBC");
      // Reservation reservation=null;
      String input[] = gui.getInput();
      String extra = input[0].trim();
      int amount = Integer.parseInt(input[1].trim());
      double price = Double.parseDouble(input[2].trim());
      Item item = new Item();
      item.setName(extra);
      item.setPrice(price);
      item.setAmount(amount);
      // check if it is the same reservation
      gui.setMode("ReserveBusAndChauffeur");
      // System.out.println(start);
      gui.setMode("AddCustomerBC");

      reservation.addItem(item);

      gui.setMode("ReserveExtrasBC");
      // System.out.println(item);
      gui.getReserveExtrasBC().clear();
   }

   private void executeShowReservationBC()
   { // System.out.println("Show reservation");
     // Reservation reservation=null;
      try
      {
         gui.getShowReservationBC().showReservationBC(reservation);
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }

   }

   private void executeReserveBusAndChauffeur()
   {
      // Reservation reservation = null;
      if (reservation == null)
      {
         reservation = new Reservation();
      }
      Customer customer = null;
      Vehicle vehicle = null;
      Chauffeur chauffeur = null;
      Tour tour = null;
      String input[] = gui.getInput();
      // take input for start Date
      String start = input[0].trim();

      // System.out.println(start);

      String startDate[] = start.split("/");
      int startDay = Integer.parseInt(startDate[0]);
      int startMonth = Integer.parseInt(startDate[1]);
      String startYearString = (startDate[2]);
      String startYearSplit[] = startYearString.split(" ");
      int startYear = Integer.parseInt(startYearSplit[0]);

      // System.out.println(startDay+" "+startMonth+" "+startYear);

      String dateTime[] = start.split(" ");
      String time = dateTime[1];
      String Time[] = time.split("\\:");
      int startHour = Integer.parseInt(Time[0]);
      int startMinute = Integer.parseInt(Time[1]);
      // System.out.println(startHour +" "+startMinute);
      // take input for end date
      String end = input[1].trim();
      // System.out.println(end);
      String endDate[] = start.split("/");
      int endDay = Integer.parseInt(endDate[0]);
      int endMonth = Integer.parseInt(endDate[1]);
      String endYearString = (endDate[2]);
      String endYearSplit[] = endYearString.split(" ");
      int endYear = Integer.parseInt(endYearSplit[0]);

      String endDateTime[] = end.split(" ");
      String endtime = endDateTime[1];
      String endTime[] = endtime.split(":");
      int endHour = Integer.parseInt(endTime[0]);
      int endMinute = Integer.parseInt(endTime[1]);
      String destination = input[2];
      boolean checkAlreadyInSystem = Boolean.parseBoolean(input[3]);
      if (checkAlreadyInSystem && input[4] != null)
      {
         String name = input[4].trim();
         customer = model.getCustomerList().getCustomerByName(name);
         // reservation=new Reservation();
         reservation.addCustomer(customer);
      }
      Time startTime = new Time(startHour, startMinute);
      DateTime startDate1 = new DateTime(startDay, startMonth, startYear,
            startTime);
      Time endTime1 = new Time(endHour, endMinute);
      DateTime endDate1 = new DateTime(endDay, endMonth, endYear, endTime1);
      DateInterval dateInterval = new DateInterval(startDate1, endDate1);

      String typeVehicle = input[5].trim();
      switch (typeVehicle)
      {
         case "Bus":
            vehicle = model.getVehicleList().getAllAvaiableBuses().get(0);
            break;
         case "Minibus":
            vehicle = model.getVehicleList().getAllAvaiableMiniBuses().get(0);
            break;

         case "Party bus":
            vehicle = model.getVehicleList().getAllAvaiablePartyBuses().get(0);
            break;
      }
      // System.out.println(vehicle);
      boolean partyGuide = Boolean.parseBoolean(input[6]);

      String chauffeur1 = input[7].trim();
      String chauffeurInfo[] = chauffeur1.split(",");
      int chauffeurId = Integer.parseInt(chauffeurInfo[0]);
      chauffeur = model.getChauffeurList().getChauffeurByID(chauffeurId);

      tour = new BusAndChauffeur(destination, dateInterval, vehicle, chauffeur);
      reservation.setTour(tour);

      if (partyGuide)
      {
         if (vehicle.getType().equals("Party Bus") && reservation != null)
         {
            reservation.getVehicle().setPartyGuide();
         }
      }

      double priceForTour = Double.parseDouble(input[8].trim());
      if (reservation != null)
      {
         reservation.setPriceForTour(priceForTour);
      }

   }

   private void executeShowReservation()
   {
      try
      {
         gui.getShowReservation().showReservation(reservation);
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
}