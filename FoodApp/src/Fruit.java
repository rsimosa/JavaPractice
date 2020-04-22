
public class Fruit extends Food {

    private String season;

    public Fruit(String newDescription, int newNumberOfCalories) {
        super(newDescription, newNumberOfCalories);
        season = "In Season";
    }

    public Fruit(String newDescription, int newNumberOfCalories, String newSeason) {
        super(newDescription, newNumberOfCalories);
        season = newSeason;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return "Season: " + season
                + "\n" + super.toString()
                + "\nTotal Calories: " + this.totalCalories(0);
    }

    @Override
    public int totalCalories(int newNumberOfServings) {
        int numberOfServings = newNumberOfServings;
        return this.getNumberOfCalories() * numberOfServings;
    }

}
