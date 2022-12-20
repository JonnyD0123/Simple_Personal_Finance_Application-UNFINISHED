package Model;

import java.util.Date;

public class UrgentPayment {
    private Payment payment;
    private Date dateToPayBy;
    private Double amountToPayOnDate;

    public UrgentPayment(Payment payment, Date dateToPayBy, Double amountToPayOnDate) {
        this.payment = payment;
        this.dateToPayBy = dateToPayBy;
        this.amountToPayOnDate = amountToPayOnDate;
    }

    public Payment getPayment() {
        return payment;
    }
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Date getDateToPayBy() {
        return dateToPayBy;
    }
    public void setDateToPayBy(Date dateToPayBy) {
        this.dateToPayBy = dateToPayBy;
    }

    public Double getAmountToPayOnDate() {
        return amountToPayOnDate;
    }
    public void setAmountToPayOnDate(Double amountToPayOnDate) {
        this.amountToPayOnDate = amountToPayOnDate;
    }

    //I want to use this method to compare Urgent Payments in the list to new Urgent Payments first by date
    //and second by amount to pay - the earlier the date, the higher it should be positioned in the list
    public boolean decideToInsert(UrgentPayment up) {
        boolean decision = false;
        if(dateToPayBy.after(up.getDateToPayBy())) {
            decision = true;
        }
        //if the new Urgent Payment has the same date as the Payment it is being compared to,
        //then it is compared by amount, and the Urgent Payment with the larger amount is placed higher up in the list
        if(dateToPayBy.equals(up.getDateToPayBy())) {
            if(amountToPayOnDate < up.getAmountToPayOnDate()) {
                decision = true;
            }
        }
        return decision;
    }

    @Override
    public String toString() {
        return "UrgentPayment" +
                "\nPayment: {" + payment +
                "}\nAmount To Pay: $" + amountToPayOnDate +
                ", by " + dateToPayBy;
    }
}
