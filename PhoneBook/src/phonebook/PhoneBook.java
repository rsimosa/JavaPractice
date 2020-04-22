package phonebook;

public class PhoneBook {

    public String lastName;
    public String firstName;
    public String phoneNumber;

    public PhoneBook(String lastName, String firstName, String phoneNumber) {

        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;

    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + phoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)$2-$3") + "\n";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}
