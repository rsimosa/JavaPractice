package taxrates;

import java.util.ArrayList;
import java.util.Random;

public class TaxRates {

    private final double[][] taxRates;

    public TaxRates() {

        taxRates = new double[50][10];

        Random prng = new Random();

        for (double[] state : taxRates) {
            for (int year = 0; year < state.length; year++) {
                state[year] = prng.nextDouble() * 0.06;
            }
        }
    }

    public int largestAvgRate() {

        int largestIndex = -1;

        double largestAvg = Double.NEGATIVE_INFINITY;

        for (int state = 0; state < taxRates.length; state++) {
            double sum = 0.0;

            for (int year = 0; year < taxRates[state].length; year++) {
                sum += taxRates[state][year];
            }

            sum /= taxRates[state].length;

            if (sum > largestAvg) {
                largestAvg = sum;
                largestIndex = state;
            }

        }

        return largestIndex;
    }

    public ArrayList<Integer> lowTaxStates() {
        ArrayList<Integer> lowTaxList = new ArrayList<>();

        for (int state = 0; state < taxRates.length; state++) {
            for (int year = 0; year < taxRates[state].length; year++) {
                if (taxRates[state][year] < 0.001) {
                    lowTaxList.add(state);
                    break;
                }
            }
        }

        return lowTaxList;
    }

    public double largestRate(int stateIndex) {

        double maxRate = Double.NEGATIVE_INFINITY;

        for (int year = 0; year < taxRates[stateIndex].length; year++) {

            if (taxRates[stateIndex][year] > maxRate) {
                maxRate = taxRates[stateIndex][year];
            }
        }

        return maxRate;
    }

}

