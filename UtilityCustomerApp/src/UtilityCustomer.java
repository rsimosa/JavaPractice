
abstract public class UtilityCustomer {

    int accountNumber;

    public UtilityCustomer() {
        accountNumber = 0;
    }

    public UtilityCustomer(int newAccountNumber) {
        accountNumber = newAccountNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int newAccountNumber) {
        accountNumber = newAccountNumber;
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber;
    }

}
