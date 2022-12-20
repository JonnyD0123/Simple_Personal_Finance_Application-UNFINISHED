package Test;

import Controller.PaymentsToMake;
import Model.Payment;
import Model.UrgentPayment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;

public class TestLinkedList {
    PaymentsToMake paymentsToMake = new PaymentsToMake();

    public TestLinkedList() throws ParseException {
        LinkedList<UrgentPayment> urgentPayments = paymentsToMake.getUrgentPaymentList();

        //Get
        System.out.println("\nGet Item By Index --> " + urgentPayments.get(0));
        System.out.println("Get Last Item --> " + urgentPayments.getLast());

        System.out.println("");
        //Search for urgent payments with a payment date of 11/01/2022
        ArrayList<UrgentPayment> searchResult = paymentsToMake.getUrgentPayment("11/01/2022");
        System.out.println("Search Payments to Make by Date --> " + searchResult);

        System.out.println("");
        //Add
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Payment p1 = new Payment("Debt", "Credit Card Debt", 560.54);
        UrgentPayment up1 = new UrgentPayment(p1, sdf.parse("11/02/2022"), 17.54);

        System.out.println("Adding Item...");
        paymentsToMake.addUrgentPayment(up1);
        paymentsToMake.printPaymentsToMake();

        System.out.println("");
        //Update --> updates amount to pay on date from 17.54 to 18.54
        System.out.println("Updating Item...");
        UrgentPayment up1Updated = new UrgentPayment(p1, sdf.parse("11/02/2022"), 18.54);
        paymentsToMake.updateUrgentPayment(up1Updated);
        paymentsToMake.printPaymentsToMake();

        System.out.println("");
        //Remove
        System.out.println("Removing Item... ");
        paymentsToMake.removeUrgentPayment(up1);
        paymentsToMake.printPaymentsToMake();

    }
}
