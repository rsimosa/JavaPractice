/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coinsapp;

/**
 *
 * @author NEDL
 */
public class CoinsApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Coins coinsOne =  new Coins();
        
        System.out.println(coinsOne.toString());
        
        Coins coinsTwo = new Coins(6, 5, 4, 0);
        
        System.out.println(coinsTwo.toString());
        
        coinsOne.setNumQuarters(6);
        coinsOne.setNumDimes(5);
        coinsOne.setNumNickels(4);
        coinsOne.setNumPennies(0);
        
        System.out.println(coinsOne.equals(coinsTwo));
        
        System.out.println(coinsOne.dollarAmount());
        
        System.out.println(coinsTwo.coinsValues(1)+" Cents");
        System.out.println(coinsTwo.coinsValues(5)+" Cents");
        System.out.println(coinsTwo.coinsValues(10)+" Cents");
        System.out.println(coinsTwo.coinsValues(25)+" Cents");
        
        
        
        
    }
    
}
