/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parts;

/**
 *
 * @author NEDL
 */
abstract class Parts {

    private int partNumber;
    private double budgetCost;

    public Parts() {
    }

    public Parts(int newPartNumber, double newBudgetCost) {

        partNumber = newPartNumber;
        budgetCost = newBudgetCost;

    }

    public int getPartNumber() {
        return partNumber;
    }

    public double getBudgetCost() {
        return budgetCost;
    }

    public void setPartNumber(int newPartNumber) {
        partNumber = newPartNumber;
    }

    public void setBudgetCost(double newBudgetCost) {
        budgetCost = newBudgetCost;
    }
    
    @Override
    public String toString(){
        return "Part Number: " + partNumber + "\n Budget: " +budgetCost;
    }

}
