package reservation;

public class Manager {

    private int houseNumber;
    private String day;
    private double housePrice;
    private int available;
    private String customerName;

    public Manager(int houseNumber, String day, double housePrice) {
        this.houseNumber = houseNumber;
        this.day = day;
        this.housePrice = housePrice;
    }

    public Manager(int houseNumber, String day, double housePrice, int available, String customerName) {
        this.houseNumber = houseNumber;
        this.day = day;
        this.housePrice = housePrice;
        this.available = available;
        this.customerName = customerName;
    }

    public double getHousePrice() {
        return housePrice;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public String getDay() {
        return day;
    }

    public int getAvailable() {
        return available;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setHousePrice(double housePrice) {
        this.housePrice = housePrice;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return houseNumber + " " + day + " " + housePrice + " " + available + " " + customerName;
    }
}
