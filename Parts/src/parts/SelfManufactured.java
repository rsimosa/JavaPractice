package parts;

public class SelfManufactured extends Parts {

    private double cost;
    private int drawNumber;

    public SelfManufactured(int partNumber, double budgetCost) {
        super(partNumber, budgetCost);

    }

    public SelfManufactured(int partNumber, double budgetCost, double newCost, int newDrawNumber) {

        super(partNumber, budgetCost);
        cost = newCost;
        drawNumber = newDrawNumber;

    }

    public double getCost() {
        return cost;
    }

    public void setCost(double newCost) {
        cost = newCost;
    }

    public int getDrawNumber() {
        return drawNumber;
    }

    public void setDrawNumber(int newDrawNumber) {
        drawNumber = newDrawNumber;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDraw number: " + drawNumber + "\nCost: " + cost;
    }

    public String OverUnder() {

        if (cost > super.getBudgetCost()) {
            return "Over Budget.";
        } else {
            return "Under Budget";
        }
    }
}
