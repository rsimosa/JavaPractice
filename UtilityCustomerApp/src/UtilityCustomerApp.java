
import java.util.ArrayList;


public class UtilityCustomerApp {

    public static void main(String[] args) {
        
        ArrayList <UtilityCustomer> customer = new ArrayList<>();
        
        customer.add(new ElectricCustomer (100001, 240));
        customer.add(new ElectricCustomer (100002, 1240));
        customer.add(new GasCustomer (200001, 240));
        customer.add(new GasCustomer (200002, 1240));
        
        customer.forEach((customers) -> {
            System.out.println("\n"+customers);
        });
    }

}
