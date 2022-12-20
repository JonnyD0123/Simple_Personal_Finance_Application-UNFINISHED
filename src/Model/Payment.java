package Model;

import java.util.ArrayList;

public class Payment implements Retriever{
    private String type;
    private String name;
    private Double amount;

    //Constructor
    public Payment(String type, String name, Double amount) {
        this.type = type;
        this.name = name;
        this.amount = amount;
    }

    //Getters
    public String getType() {
        return type;
    }
    public String getName() {
        return name;
    }
    public Double getAmount() {
        return amount;
    }

    //Setters
    public void setType(String type) {
        this.type = type;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public void retrieveYearly() {
        System.out.println("Yearly Payment for " + getName() +
                " is $"+getAmount()*12);;
    }

    @Override
    public void retrieveMonthly(){
        System.out.println("Monthly payment for " + getName() +
                " is $"+getAmount());
    }

    @Override
    public String toString(){
        return  "Payment Type: " + type +
                ", Payment Name: " + name +
                ", Total Payment Amount: $" + amount;
    }
}
