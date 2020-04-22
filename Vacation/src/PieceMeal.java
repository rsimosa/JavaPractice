
import java.util.ArrayList;

public class PieceMeal extends Vacation {

    private ArrayList<String> items;
    private ArrayList<Double> price;

    public PieceMeal(double newBudgetCost, String newDestination) {
        super(newBudgetCost, newDestination);
        items = new ArrayList();
        price = new ArrayList();
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public ArrayList<Double> getPrice() {
        return price;
    }

    public void setVacationItems(String newItem, double newPrice) {
        items.add(newItem);
        price.add(newPrice);
    }

    @Override
    public String toString() {
        return "Items: " + items
                + "\nPrice: " + price
                + "\nInBudget: "+OverUnder()+"\n" + super.toString();
    }

    @Override
    double OverUnder() {
        double sumOfCosts = 0;

        for (double cost : price) {
            sumOfCosts += cost;
        }
        return sumOfCosts - super.getBudgetCost();
    }

}
