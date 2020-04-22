
abstract class Vacation {

    private double budgetCost;
    private String destination;

    public Vacation() {
        budgetCost = 0;
        destination = "";
    }

    public Vacation(double newBudgetCost, String newDestination) {
        budgetCost = newBudgetCost;
        destination = newDestination;
    }

    public double getBudgetCost() {
        return budgetCost;
    }

    public void setBudgetCost(double budgetCost) {
        this.budgetCost = budgetCost;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String Destination) {
        this.destination = Destination;
    }
    
    public String toString(){
        return "Budget: "+budgetCost + 
                "\nDstination: "+destination;
    }

    abstract double OverUnder();

}
