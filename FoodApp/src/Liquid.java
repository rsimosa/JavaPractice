
public class Liquid extends Food {

    private int viscosity;

    public Liquid(String newDescription, int newNumberOfCalories) {
        super(newDescription, newNumberOfCalories);
        viscosity = 0;
    }

    public Liquid(String newDescription, int newNumberOfCalories, int newViscosity) {
        super(newDescription, newNumberOfCalories);
        viscosity = newViscosity;
    }

    public int getViscosity() {
        return viscosity;
    }

    public void setViscosity(int viscosity) {
        this.viscosity = viscosity;
    }

    @Override
    public String toString() {
        return "Viscocity: " + viscosity
                + "\n" + super.toString()
                + "\nTotal Calories:" + this.totalCalories(2);
    }

    @Override
    public int totalCalories(int newNumberOfServings) {
        int numberOfServings = newNumberOfServings;

        return this.getNumberOfCalories() * numberOfServings;

    }
}
