package Model;

public class Income implements Retriever{
    private String title;
    private Double salary;
    private String secondaryIncomeTitle;
    private Double secondaryIncome;
    private Double totalIncome;

    //Constructor
    public Income(String title, Double salary, String scdName, Double scdIncome, Double totalIncome) {
        this.title = title;
        this.salary = salary;
        this.secondaryIncomeTitle = scdName;
        this.secondaryIncome = scdIncome;
        this.totalIncome = totalIncome;
    }

    public Income(Double totalIncome) {
        this.totalIncome = totalIncome;
    }

    //Getters
    public String getTitle(){return title;}
    public Double getSalary() {
        return salary;
    }
    public String getSecondaryIncomeTitle() {
        return secondaryIncomeTitle;
    }
    public Double getSecondaryIncome() {
        return secondaryIncome;
    }
    public Double getTotalIncome() {
        return totalIncome;
    }

    //Setters
    public void setTitle(String title){this.title = title;}
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    public void setSecondaryIncomeTitle(String secondaryIncomeName) {
        this.secondaryIncomeTitle = secondaryIncomeName;
    }
    public void setSecondaryIncome(Double secondaryIncome) {
        this.secondaryIncome = secondaryIncome;
    }
    public void setTotalIncome(Double totalIncome){ this.totalIncome = secondaryIncome+salary; }

    @Override
    public void retrieveYearly() {
        System.out.println("Yearly Income is $" + getTotalIncome() +
                "\nConsists of " + "%"+ getSalary()/getTotalIncome()*100 +
                " salary: $" + getSalary() + ", and " +
                "\n%"+ getSecondaryIncome()/getTotalIncome()*100 + " secondary income: $" + getSecondaryIncome());
    }

    @Override
    public void retrieveMonthly() {
        System.out.println("Monthly Income is $" + getTotalIncome()/12 +
                "\nConsists of " + "%" + ((getSalary()/12)/(getTotalIncome()/12))*100 + " salary: $" + getSalary()/12 +
                ", and \n%" + ((getSecondaryIncome()/12)/(getTotalIncome()/12))*100 + " secondary income: $" +
                getSecondaryIncome()/12);
    }

    @Override
    public String toString() {
        return  "Title: " + title +
                "\nYearly salary: $" + salary +
                "\nMonthly salary: $" + salary/12 +
                "\nSecondary Income name: " + secondaryIncomeTitle +
                "\nSecondary Income salary: $" + secondaryIncome +
                "\nMonthly Secondary Income salary: $" + secondaryIncome/12 +
                "\nTotal Income: $" + totalIncome;
    }
}
