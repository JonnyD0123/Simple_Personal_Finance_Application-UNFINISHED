package Model;

public class CashAccount extends Account{
    String type;
    Double interest;

    //Constructor
    public CashAccount(String name, Double balance, String type, Double interest) {
        super(name, balance);
        this.type = type;
        this.interest = interest;
    }

    //Getters
    public String getType() {
        return type;
    }
    public Double getInterest() {
        return interest;
    }

    //Setters
    public void setType(String type) {
        this.type = type;
    }
    public void setInterest(Double interest) {
        this.interest = interest;
    }

    @Override
    public void totalBalance() {
        getBalance();
    }

    @Override
    public String toString() {
        return "Account name: " + getName() +
                "\nAccount Type: " + type +
                "\nAccount Balance: $" + getBalance() +
                "\nInterest Rate: " + interest + "%";
    }
}
