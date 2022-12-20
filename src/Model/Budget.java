package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Budget extends Income implements BudgetInstance, Serializable {
    private Double save;
    private Double spend;
    private Double invest;

    //Constructors
    public Budget(Double totalIncome, Double save, Double spend, Double invest) {
        super(totalIncome);
        this.save = save;
        this.spend = spend;
        this.invest = invest;
    }

    public Budget(Double totalIncome){
        super(totalIncome);
    }

    //Getters
    public Double getSave() {
        return save;
    }
    public Double getSpend() {
        return spend;
    }
    public Double getInvest() {
        return invest;
    }

    //Setters
    public void setSave(Double save) {
        this.save = save;
    }
    public void setSpend(Double spend) {
        this.spend = spend;
    }
    public void setInvest(Double invest) {
        this.invest = invest;
    }

    @Override
    public void calcBudget6040(ArrayList<Payment> payments, Budget budget) {
        Double income = budget.getTotalIncome();
        Double totalPayments=0.0;

        for (Payment payment : payments) {
            totalPayments = totalPayments + payment.getAmount();
        }

        Double takeHome = getTotalIncome() - totalPayments;

        setSpend(takeHome*.6);
        setSave(takeHome*.4);

        System.out.println("Take Home Pay: "+ takeHome +
                "\nSave: " + getSave() +
                "\nSpend: " + getSpend());
    }

    @Override
    public String toString() {
        return "\nTotal Income: $" + getTotalIncome() +
                "\nAmount to Save: $" + save +
                "\nAmount to Spend: $" + spend +
                "\nAmount to Invest $" + invest;
    }

    public String getBudgetDetails() {
        return "\nTotal Income: $" + getTotalIncome() +
                "\nAmount to Save: $" + save +
                "\nAmount to Spend: $" + spend +
                "\nAmount to Invest $" + invest;
    }

}
