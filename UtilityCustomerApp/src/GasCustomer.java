
public class GasCustomer extends UtilityCustomer {

    public final double PRICEOFGAS = .25;
    private double cubicMetersUsed;

    public GasCustomer(int accountNumber, double newCubicMetersUsed) {
        super(accountNumber);
        cubicMetersUsed = newCubicMetersUsed;
    }

    public double calculateBill() {
        return cubicMetersUsed * PRICEOFGAS;
    }

    public void setCubicMettersUsed(double newCubicMetersUsed) {
        cubicMetersUsed = newCubicMetersUsed;
    }

    public double getCubicMetersUsed() {
        return cubicMetersUsed;
    }

    public double getPRICEOFGAS() {
        return PRICEOFGAS;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCubic Meters Rate:  " + PRICEOFGAS + "\nGas Used:   " + cubicMetersUsed + "\nTOTAL: $" + String.format("%.2f", calculateBill());
    }

}
