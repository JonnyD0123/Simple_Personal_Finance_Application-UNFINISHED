package Model;

import java.io.Serializable;
import java.util.Date;

public class Investment implements Serializable {
    String type;
    String name;
    Double value;
    Double initialInvestment;
    Double capitalAdded;
    Date dateOfPurchase;
    Boolean sold;
    Double totalReturn;
    Date dateOfSale;

    //Constructor
    public Investment(String type, String name, Double value, Double initialInvestment, Double capitalAdded,
                      Date dateOfPurchase, Boolean sold, Double totalReturn) {
        this.type = type;
        this.name = name;
        this.value = value;
        this.initialInvestment = initialInvestment;
        this.capitalAdded = capitalAdded;
        this.dateOfPurchase = dateOfPurchase;
        this.sold = sold;
        this.totalReturn = totalReturn;
    }

    public Investment(String type, String name, Double value, Double initialInvestment, Double capitalAdded,
                      Date dateOfPurchase, Boolean sold, Double totalReturn, Date dateOfSale) {
        this.type = type;
        this.name = name;
        this.value = value;
        this.initialInvestment = initialInvestment;
        this.capitalAdded = capitalAdded;
        this.dateOfPurchase = dateOfPurchase;
        this.sold = sold;
        this.totalReturn = totalReturn;
        this.dateOfSale = dateOfSale;
    }

    //Getters
    public String getType() {
        return type;
    }
    public String getName() {
        return name;
    }
    public Double getValue() {
        return value;
    }
    public Double getInitialInvestment() {
        return initialInvestment;
    }
    public Double getCapitalAdded() {
        return capitalAdded;
    }
    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }
    public Boolean getSold() {
        return sold;
    }
    public Double getTotalReturn() {
        return totalReturn;
    }
    public Date getDateOfSale() { return dateOfSale; }

    //Setters
    public void setType(String type) {
        this.type = type;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setValue(Double value) {
        this.value = value;
    }
    public void setInitialInvestment(Double initialInvestment) {
        this.initialInvestment = initialInvestment;
    }
    public void setCapitalAdded(Double capitalAdded) {
        this.capitalAdded = capitalAdded;
    }
    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }
    public void setSold(Boolean sold) {
        this.sold = sold;
    }
    public void setTotalReturn(Double totalReturn) {
        this.totalReturn = totalReturn;
    }
    public void setDateOfSale(Date dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    @Override
    public String toString() {
        if (sold){
            return "\nType of Investment: " + type +
                    "\nName of Investment: " + name +
                    "\nCurrent Value: $" + value +
                    "\nInitial Capital Invested: $" + initialInvestment +
                    "\nAdded Capital: $" + capitalAdded +
                    "\nDate of Purchase: " + dateOfPurchase +
                    "\nSold: " + sold +
                    "\nTotal Return: $" + totalReturn +
                    "\nDate of Sale: " + dateOfSale;
        } else {
            return "\nType of Investment: " + type +
                    "\nName of Investment: " + name +
                    "\nCurrent Value: $" + value +
                    "\nInitial Capital Invested: $" + initialInvestment +
                    "\nAdded Capital: $" + capitalAdded +
                    "\nDate of Purchase: " + dateOfPurchase +
                    "\nSold: " + sold +
                    "\nTotal Return: $" + totalReturn;
        }
    }
}
