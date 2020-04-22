/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circleapp;

/**
 *
 * @author NEDL
 */
public class CircleApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Circle circleOne = new Circle();
        
        System.out.println(circleOne.toString());
        
        
        Circle circleTwo = new Circle(3, 4, 2);
        
        System.out.println(circleTwo.toString());
        
        circleOne.setCenterPointX(4);
        circleOne.setCenterPointY(2);
        circleOne.setRadiusCircle(3);
        
        System.out.println(circleOne.toString());
        
        System.out.println("is Circle one equal to Circle Two? " + circleOne.equals(circleTwo));
    }
    
}
