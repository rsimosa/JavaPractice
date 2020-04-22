package phonebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import javafx.scene.control.ListView;

public class PhoneBookModel {

    private ArrayList<PhoneBook> phoneBookList = new ArrayList<>();
    private ArrayList<PhoneBook> tempPhoneBookList = new ArrayList<>();

    public void readFile() {
        try {
            Scanner itemsAvailableFile = new Scanner(new File("ContactsList.txt"));

            while (itemsAvailableFile.hasNext()) {

                String stringRead = itemsAvailableFile.nextLine();
                Scanner parse = new Scanner(stringRead);
                parse.useDelimiter(" ");

                String lName = parse.next();
                String fName = parse.next();
                String pNumber = parse.next();

                phoneBookList.add(new PhoneBook(lName, fName, pNumber));
            }
        } catch (FileNotFoundException ex) {
            System.out.print(ex);
        }
    }

    public void fillListView(ListView lvContacts) {
        for (int i = 0; i < phoneBookList.size(); i++) {
            lvContacts.getItems().add(getLastName(i) + " " + getFirstName(i) + " " + getPhoneNumber(i));
        }
    }

    public void writeFile() {

        try (PrintWriter outputContactList = new PrintWriter("ContactsList.txt")) {
            phoneBookList.forEach(outputContactList::print);
            outputContactList.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }

    public String getLastName(int index) {
        return phoneBookList.get(index).lastName;
    }

    public String getFirstName(int index) {
        return phoneBookList.get(index).firstName;
    }

    public String getPhoneNumber(int index) {
        return phoneBookList.get(index).phoneNumber;
    }

    public void setLastName(int index, String lastName) {
        phoneBookList.get(index).lastName = lastName;
    }

    public void setFirstName(int index, String firstName) {
        phoneBookList.get(index).firstName = firstName;
    }

    public void setPhoneNumber(int index, String phoneNumber) {
        phoneBookList.get(index).phoneNumber = phoneNumber;
    }

    public void addPhoneBookList(String lastName, String firstName, String phoneNumber) {
        phoneBookList.add(new PhoneBook(lastName, firstName, phoneNumber));
    }

    public void removePhoneBookList(String lastName, String firstName, String phoneNumber) {

        for (int i = 0; i < phoneBookList.size(); i++) {
            if (phoneBookList.get(i).getLastName().equalsIgnoreCase(lastName)
                    && phoneBookList.get(i).getFirstName().equalsIgnoreCase(firstName)
                    || phoneBookList.get(i).getLastName().equalsIgnoreCase(lastName)
                    && phoneBookList.get(i).getPhoneNumber().toLowerCase().equals(phoneNumber)
                    || phoneBookList.get(i).getFirstName().equalsIgnoreCase(firstName)
                    && phoneBookList.get(i).getPhoneNumber().toLowerCase().equals(phoneNumber)){

                phoneBookList.remove(i);
                break;
            }
        }
    }

    public void sortByLastname() {
        phoneBookList.sort(Comparator.comparing(e -> e.getLastName()));
    }

    public void sortByFirstName() {
        phoneBookList.sort(Comparator.comparing(e -> e.getFirstName()));
    }

    public void sortByPhoneNumber() {
        phoneBookList.sort(Comparator.comparing(e -> e.getPhoneNumber()));
    }

    public void getSearch(String searchString, ListView lvContacts) {

        lvContacts.getItems().clear();

        for (int i = 0; i < phoneBookList.size(); i++) {
            if (phoneBookList.get(i).getLastName().toLowerCase().contains(searchString)
                    || phoneBookList.get(i).getFirstName().toLowerCase().contains(searchString)
                    || phoneBookList.get(i).getPhoneNumber().toLowerCase().contains(searchString)) {

                tempPhoneBookList.add(new PhoneBook(getLastName(i), getFirstName(i), getPhoneNumber(i)));
                lvContacts.getItems().add(getLastName(i) + " " + getFirstName(i) + " " + getPhoneNumber(i));
            }
        }
    }
}
