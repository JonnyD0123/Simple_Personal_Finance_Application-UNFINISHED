package Controller;

import Model.Payment;
import Model.UrgentPayment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class PaymentsToMake {
    private LinkedList<UrgentPayment> urgentPaymentList = new LinkedList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

    public PaymentsToMake() throws ParseException {
        createUrgentPaymentList();
        printPaymentsToMake();
    }

    public LinkedList<UrgentPayment> getUrgentPaymentList() {return urgentPaymentList;}

    public void createUrgentPaymentList() throws ParseException {
        Payment studentLoans = new Payment("Loan", "Student Loan", 57000.0);
        Payment mortgage = new Payment("Secured Loan", "Mortgage", 10000.0);

        UrgentPayment UP1 = new UrgentPayment(studentLoans, sdf.parse("11/01/2022"), 750.0);
        UrgentPayment UP2 = new UrgentPayment(mortgage, sdf.parse("11/04/2022"), 650.0);

        addUrgentPayment(UP1);
        addUrgentPayment(UP2);
    }

    public void addUrgentPayment(UrgentPayment newUP) {
        boolean added = false;
        boolean insert = false;
        ListIterator<UrgentPayment> upIterator = urgentPaymentList.listIterator();
        while(upIterator.hasNext()){
            insert = upIterator.next().decideToInsert(newUP);
            if(insert) {
                urgentPaymentList.add(upIterator.previousIndex(), newUP);
                added = true;
                break;
            }
        }
        if(!added) {
            urgentPaymentList.add(newUP);
        }
    }

    public void removeUrgentPayment(UrgentPayment up) {
        urgentPaymentList.remove(up);
    }

    public ArrayList<UrgentPayment> getUrgentPayment(String date) throws ParseException {
        try {
            sdf.parse(date);
        } catch (IllegalFormatException e) {
            System.out.println("Date is not in correct format --> 'MM/dd/yyyy'");
        }
        ArrayList<UrgentPayment> searchResults = new ArrayList<>();
        ListIterator<UrgentPayment> upIterator = urgentPaymentList.listIterator();
        while(upIterator.hasNext()) {
            UrgentPayment currentUP = upIterator.next();
            if (sdf.parse(date).equals(currentUP.getDateToPayBy())) {
                searchResults.add(currentUP);
            }
        }
        return searchResults;
    }

    public void updateUrgentPayment(UrgentPayment updated) {
        //Matches an updated version of urgent payment with an urgent payment already in the list
        //It matches by payment field to make sure the correct urgent payment corresponding to the same payment is updated
        ListIterator<UrgentPayment> upIterator = urgentPaymentList.listIterator();
        while(upIterator.hasNext()) {
            UrgentPayment toUpdate = upIterator.next();
            if(updated.getPayment() == (toUpdate.getPayment())) {
                toUpdate.setDateToPayBy(updated.getDateToPayBy());
                toUpdate.setAmountToPayOnDate(updated.getAmountToPayOnDate());
            }
        }
    }

    public void printPaymentsToMake() {
        ListIterator<UrgentPayment> upIterator = urgentPaymentList.listIterator();
        while(upIterator.hasNext()) {
            System.out.println(upIterator.next().toString());
        }
    }


}
