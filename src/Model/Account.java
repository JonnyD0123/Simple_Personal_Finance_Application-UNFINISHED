package Model;

public abstract class Account {
    private String name;
    private Double balance;

    //Constructor
    public Account(String name, Double balance){
        this.name = name;
        this.balance = balance;
    }

    //Getters
    public String getName() {
        return name;
    }
    public Double getBalance() {
        return balance;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public abstract void totalBalance();

    @Override
    public String toString() {
        return "Account name: " + name +
                "\nAccount balance: " + balance;
    }
}
