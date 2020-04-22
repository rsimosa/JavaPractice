
public class ElectricCustomer extends UtilityCustomer {

    public final double KILOWATTHOURRATE = .14;
    public final double DELIVERYFEE = 30.00;
    private double kilowattHoursUsed;

    public ElectricCustomer(int accountNumber, double newKilowattHoursUsed) {
        super(accountNumber);
        kilowattHoursUsed = newKilowattHoursUsed;
    }

    public double calculateBill() {
        return (kilowattHoursUsed * KILOWATTHOURRATE) + DELIVERYFEE;
    }

    public void setKilowattshoursUsed(double newKilowattHoursUsed) {
        kilowattHoursUsed = newKilowattHoursUsed;
    }

    public double getKilowattsHoursUsed() {
        return kilowattHoursUsed;
    }

    public double getPRICEOFGAS() {
        return KILOWATTHOURRATE;
    }

    @Override
    public String toString() {
        return super.toString() + "\nKilowatt Hour Rate: " + KILOWATTHOURRATE + "\nHours Used: " + kilowattHoursUsed + "\nTOTAL: $" + String.format("%.2f", calculateBill());
    }

}
