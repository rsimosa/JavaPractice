package parts;

import java.util.*;

public class Outsorced extends Parts {

    private final Map<String, Double> Suppliers;

    public Outsorced(int partNumber, double budgetCost) {

        super(partNumber, budgetCost);
        Suppliers = new Hashtable();

    }

    public Object getSuppliers(String supplier) {
        return Suppliers.get(supplier);
    }

    public void setSuppliers(String supplier, double price) {
        Suppliers.put(supplier, price);
    }

    @Override
    public String toString() {

        return Suppliers.toString() + "\n";
    }

    public double LowestCost() {
        double lowCost = 100000000;
        for (Double key : Suppliers.values()) {
            if (key < lowCost) {
                lowCost = key;
            }

        }
        return lowCost;
    }
}
