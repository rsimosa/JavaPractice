
abstract class Food {

    private String description;
    private int numberOfCalories;

    public Food(String newDescription, int newNumberOfCalories) {
        description = newDescription;
        numberOfCalories = newNumberOfCalories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberOfCalories() {
        return numberOfCalories;
    }

    public void setNumberOfCalories(int numberOfCalories) {
        this.numberOfCalories = numberOfCalories;
    }

    abstract int totalCalories(int newNumberOfServings);

    @Override
    public String toString() {
        return "Description: " + description
                + "\nCalories Per Serving: " + numberOfCalories;
    }

}
