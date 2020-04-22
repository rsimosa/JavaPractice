package taxrates;

public class TaxRatesApp {

    public static void main(String[] args) {

        TaxRates tr = new TaxRates();

        System.out.println("State with largest average tax: " +
                tr.largestAvgRate());
        System.out.println("States with low taxes: " +
                tr.lowTaxStates());
        System.out.println("Highest rate for state 21: " +
                tr.largestRate(21));
    }
    
}