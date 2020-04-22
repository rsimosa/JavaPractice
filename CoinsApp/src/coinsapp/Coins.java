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
public class Coins {
    
    private int numQuarters;
    private int numDimes;
    private int numNickels;
    private int numPennies;
    
    public Coins(){
            
    numQuarters = 0;
    numDimes = 0;
    numNickels = 0;
    numPennies = 0;
    
    }
    
    public Coins(int newNumQuarters, int newNumDimes, int newNumNickels, int newNumPennies){
        
    numQuarters = newNumQuarters;
    numDimes = newNumDimes;
    numNickels = newNumNickels;
    numPennies = newNumPennies;
    }

    public int getNumQuarters() {
        return numQuarters;
    }

    public int getNumDimes() {
        return numDimes;
    }

    public int getNumNickels() {
        return numNickels;
    }

    public int getNumPennies() {
        return numPennies;
    }

    public void setNumQuarters(int numQuarters) {
        this.numQuarters = numQuarters;
    }

    public void setNumDimes(int numDimes) {
        this.numDimes = numDimes;
    }

    public void setNumNickels(int numNickels) {
        this.numNickels = numNickels;
    }

    public void setNumPennies(int numPennies) {
        this.numPennies = numPennies;
    }
    
    public String dollarAmount(){
        float dollarAmount = (float) ((numQuarters * 0.25) +
                                     (numDimes * 0.1) +
                                     (numNickels * 0.05) +
                                     (numPennies * 0.01));
        return "$ "+String.format("%.2f",dollarAmount);
    }
    
    public String toString(){
        return dollarAmount();        
    }
    
    @Override
    public boolean equals(Object o){
        
        if (!(o instanceof Coins))
            return false;
        else
        {
                    Coins objCoins = (Coins) o;
                    if (numQuarters == objCoins.numQuarters
                        && numDimes == objCoins.numDimes
                        && numNickels == objCoins.numNickels
                        && numPennies == objCoins.numPennies){
                               
                        return true;
                } else {
                        return false;
                    }
                }       
    }
    
    public int coinsValues(int coinType){
        
        int coinValue = 0;
        switch (coinType){
            case 1:
                coinValue = (numPennies * 1);
                break;
            case 5:
                coinValue = (numNickels * 5);
                break;
            case 10:
                coinValue = (numDimes * 10);
                break;
            case 25:
                coinValue = (numQuarters * 25);
                break;               
        }
        return coinValue;        
    }    
}
