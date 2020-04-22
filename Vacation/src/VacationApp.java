
import java.util.ArrayList;

public class VacationApp {

    public static void main(String[] args) {

        ArrayList<Vacation> vacations = new ArrayList();
        PieceMeal PM = new PieceMeal(4000, "Houston");
        PM.setVacationItems("Car", 22.56);
        PM.setVacationItems("Hotel", 250.0);

        vacations.add(PM);

        vacations.add(new AllIncluded(2000, "hawaii", "costco", 2, 1400));
        vacations.add(new AllIncluded(3000, "Texas", "TravelPlus", 3, 2400));
        vacations.add(new AllIncluded(4000, "PR", "AA", 4, 14000));

        vacations.forEach((vacation) -> {
            System.out.println(vacation.toString());
            System.out.println();
        });

    }

}
