package parts;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NEDL
 */
public class PartsApp {
    
        public static void main(String[] args) {
        
            Outsorced out = new Outsorced(12,5.11);
            
            out.setSuppliers("James", 25.23);
            out.setSuppliers("Joe's", 25.14);
            out.setSuppliers("Frank", 25.11);
            out.setSuppliers("Charles", 25.55);
            
            System.out.println(out.toString());
            System.out.println("The lowest Cost is: "+out.LowestCost());
            
            SelfManufactured inHouse = new SelfManufactured(4, 12345.01, 56789.74, 3);
            System.out.println(inHouse.OverUnder());
            
    }
    
}
