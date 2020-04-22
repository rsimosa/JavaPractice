
import java.util.ArrayList;

public class FoodApp {

    public static void main(String[] args) {
        ArrayList<Food> calories = new ArrayList();

        calories.add(new Liquid("Tomato Soup", 250, 1));
        calories.add(new Liquid("Tomato bisque", 350, 2));
        calories.add(new Liquid("brocoli Soup", 450, 3));

        calories.add(new Fruit("Apples", 250, "In Season"));
        calories.add(new Fruit("Pears", 350, "Out of Season"));
        calories.add(new Fruit("Plums", 450, "In Season"));

        calories.forEach((plate) -> {
            System.out.println(plate.toString());
            System.out.println();
        });

    }
}
