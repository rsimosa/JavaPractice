package reservation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reservation {

    public static void main(String[] args) {

        ArrayList<Manager> UpdateList = new ArrayList<>();
        ArrayList<Manager> BookedList = new ArrayList<>();
        ArrayList<Manager> AvailableList = new ArrayList<>();

        /////////////////////////////////////////////////// LOADING THE CURRENT PRICES CHANGES ///////////////////////////////////////////////////////////////////////////////////////////////////
        try {
            Scanner updatefile = new Scanner(new File("updateFile.txt"));

            while (updatefile.hasNext()) {

                String stringRead = updatefile.nextLine();
                Scanner parse = new Scanner(stringRead);
                parse.useDelimiter(" ");

                int houseNumber = parse.nextInt();
                String day = parse.next();
                double housePrice = parse.nextDouble();

                UpdateList.add(new Manager(houseNumber, day, housePrice, 0, null));

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("THIS IS THE UPDATE LIST  PRINT");

        UpdateList.forEach(System.out::println);

        ////////////////////////////////////////////////////   LOADING THE CURRENT BOOKED LIST  ////////////////////////////////////////////////////////////////////////////////////////////////
        try {
            Scanner bookingFile = new Scanner(new File("reservationFile.txt"));

            while (bookingFile.hasNext()) {

                String stringRead = bookingFile.nextLine();
                Scanner parse = new Scanner(stringRead);
                parse.useDelimiter(" ");

                int houseNumber = parse.nextInt();
                String day = parse.next();
                double housePrice = parse.nextDouble();
                int available = parse.nextInt();
                String customerName = parse.next();

                BookedList.add(new Manager(houseNumber, day, housePrice, available, customerName));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("THIS IS THE BOOKED LIST PRINT");
        BookedList.forEach(System.out::println);

        /////////////////////////////////////////    UPDATING AVALAIBLE LIST FROM BOOKED LIST        /////////////////////////////////////////////////////////////////////////////////////////
        for (int i = 0; i < BookedList.size(); i++) {

            if (BookedList.get(i).getAvailable() == 1) {

                AvailableList.add(BookedList.get(i));
            }
        }

        /////////////////////////////////////   UPDATING AVAILABLE AND BOOKED LIST FROM USER SELECTION   ////////////////////////////////////////////////////////////////////////////////////
        while (AvailableList.size() > 0) {

            System.out.println("SELECT THE OPTION FROM 1 TO " + AvailableList.size() + " 0 TO EXIT");

            AvailableList.forEach(System.out::println);

            Scanner inputHouse = new Scanner(System.in);

            int inputNumber = inputHouse.nextInt();

            System.out.println("Input your Name");

            Scanner inputRenter = new Scanner(System.in);

            String inputName = inputRenter.next();

            for (int k = 0; k < BookedList.size(); k++) {

                if (AvailableList.get(inputNumber - 1).getDay().equalsIgnoreCase(BookedList.get(k).getDay())
                        && AvailableList.get(inputNumber - 1).getHouseNumber() == BookedList.get(k).getHouseNumber()) {

                    BookedList.get(k).setAvailable(0);
                    BookedList.get(k).setCustomerName(inputName);

                }
            }
            AvailableList.remove(inputNumber - 1);
        }
//////////////////////////////////////////////////////////       WRITING TO FILE       ///////////////////////////////////////////////////////////////////////////////////////////////////////
        try {
            PrintWriter outputBookedListFile = new PrintWriter("reservationFile.txt");
            for (int i = 0; i < BookedList.size(); i++) {
                for (int j = 0; j < UpdateList.size(); j++) {

                    if (BookedList.get(i).getAvailable() == 1) {
                        if (UpdateList.get(j).getDay().equalsIgnoreCase(BookedList.get(i).getDay())
                                && UpdateList.get(j).getHouseNumber() == BookedList.get(i).getHouseNumber()) {

                            BookedList.remove(i);
                            BookedList.add(i, UpdateList.get(j));
                        }
                    }

                }
            }

            BookedList.forEach(outputBookedListFile::print);

            outputBookedListFile.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }

    }
}
