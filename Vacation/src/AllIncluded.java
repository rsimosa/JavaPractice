
public class AllIncluded extends Vacation {

    private String brand;
    private int rating;
    private double price;

    public AllIncluded() {
        brand = "";
        rating = 0;
        price = 0.00;
    }
    
    public AllIncluded(double newBudgetCost, String newDestination, String brand, int rating, double price){
        super(newBudgetCost,newDestination);
        this.brand = brand;
        this.rating = rating;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public String toString(){
        return "Brand: "+ brand +
                "\nRating: "+rating +" Stars "+
                "\nPrice: " + price +
                "\nInBudget: "+ OverUnder() +"\n"+ super.toString();
    }
    
    @Override
    public double OverUnder(){
        
        return this.price - super.getBudgetCost();
        
    }

}
