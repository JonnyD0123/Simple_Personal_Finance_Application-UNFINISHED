package Test;

import Controller.PaymentsToMake;
import Model.Payment;
import Model.UrgentPayment;
import org.junit.jupiter.api.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestPaymentsToMake {
    @Test
    public void testConstructor() throws ParseException {
        PaymentsToMake paymentsToMake = new PaymentsToMake();

        System.out.println(paymentsToMake.getUrgentPaymentList());
    }

    @Test
    public void testAddUrgentPayment() throws ParseException {
        PaymentsToMake paymentsToMake = new PaymentsToMake();

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Payment p1 = new Payment("Debt", "Credit Card Debt", 560.54);
        Payment p2 = new Payment("Utility", "Monthly Water Bill", 75.00);

        //Additions to list are sorted by date, then amount
        //these two new Urgent Payments have the same date but 'p2' has a larger payment amount than 'p1'
        //so 'p2' should be positioned directly before 'p1' in the list after adding both
        UrgentPayment up1 = new UrgentPayment(p1, sdf.parse("11/02/2022"), 17.54);
        UrgentPayment up2 = new UrgentPayment(p2, sdf.parse("11/02/2022"), 75.00);
        paymentsToMake.addUrgentPayment(up1);
        paymentsToMake.addUrgentPayment(up2);

        System.out.println(paymentsToMake.getUrgentPaymentList());
    }

    @Test
    public void testRemoveUrgentPayment() throws ParseException {
        PaymentsToMake paymentsToMake = new PaymentsToMake();

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Payment p1 = new Payment("Debt", "Credit Card Debt", 560.54);
        UrgentPayment up1 = new UrgentPayment(p1, sdf.parse("11/02/2022"), 17.54);

        paymentsToMake.addUrgentPayment(up1);
        System.out.println(paymentsToMake.getUrgentPaymentList());

        System.out.println("");

        paymentsToMake.removeUrgentPayment(up1);
        System.out.println(paymentsToMake.getUrgentPaymentList());
    }

    @Test
    public void testSearchUrgentPayment() throws ParseException {
        PaymentsToMake paymentsToMake = new PaymentsToMake();

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Payment p1 = new Payment("Debt", "Credit Card Debt", 560.54);
        UrgentPayment up1 = new UrgentPayment(p1, sdf.parse("11/02/2022"), 17.54);

        paymentsToMake.addUrgentPayment(up1);
        System.out.println(paymentsToMake.getUrgentPayment("11/02/2022"));
    }

    @Test
    public void testPrintPaymentsToMake() throws ParseException {
        PaymentsToMake paymentsToMake = new PaymentsToMake();
        paymentsToMake.printPaymentsToMake();
    }
}
