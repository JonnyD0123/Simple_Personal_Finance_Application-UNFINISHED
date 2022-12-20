package Model;

public class CreditAccount extends Account{
    Double debt;
    Double availableToSpend;

    //Constructor
    public CreditAccount(String name, Double balance, Double debt, Double availableToSpend) {
        super(name, balance);
        this.debt = debt;
        this.availableToSpend = availableToSpend;
    }

    //Getters
    public Double getDebt() {
        return debt;
    }
    public Double getAvailableToSpend() {
        return availableToSpend;
    }

    //Setters
    public void setDebt(Double debt) {
        this.debt = debt;
    }
    public void setAvailableToSpend(Double availableToSpend) {
        this.availableToSpend = availableToSpend;
    }

    @Override
    public void totalBalance(){
        setBalance(debt+availableToSpend);
    }

    @Override
    public String toString() {
        return "Account name: " + getName() +
                "\nDebt Outstanding: $" + debt +
                "\nAvailable to Spend: $" + availableToSpend +
                "\nTotal Account Balance: $" + getBalance();
    }
}
