package Test;

import Model.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JUnitTestHarness {

    /*@org.junit.jupiter.api.Test
    void testCashAccount() {
        CashAccount cash = new CashAccount("M&T Spend", "Debit", 0.01);
        String result = cash.getName() + ", " + cash.getType() + ", " + cash.getInterest() + "%";
        System.out.println(result);
        assertEquals("M&T Spend, Debit, 0.01%", result);

        cash.setName("M&T Savings");
        cash.setType("Debit");
        cash.setInterest(0.04);
        String result2 = cash.getName() + ", " + cash.getType() + ", " + cash.getInterest() + "%";
        assertEquals("M&T Savings, Debit, 0.04%", result2);
    }

    @org.junit.jupiter.api.Test
    void testCreditAccount() {
        CreditAccount credit = new CreditAccount(1075.00, 8925.00);
        String result = "$" + credit.getDebt() + ", $" + credit.getAvailableToSpend();
        System.out.println(result);
        assertEquals("$1075.0, $8925.0", result);
    }*/

    /*@org.junit.jupiter.api.Test
    void testCashAccountSet() {
        CashAccount cash = new CashAccount("M&T Spend", "Debit", 0.01);
        cash.setName("M&T Savings");
        cash.setType("Debit");
        cash.setInterest(0.04);
        String result = cash.getName() + ", " + cash.getType() + ", " + cash.getInterest() + "%";
        System.out.println(result);
        assertEquals("M&T Savings, Debit, 0.04%", result);
    }

    @org.junit.jupiter.api.Test
    void testCreditAccountSet() {
        CreditAccount credit = new CreditAccount(1075.00, 8925.00);
        credit.setDebt(350.00);
        credit.setAvailableToSpend(650.00);
        String result = "$" + credit.getDebt() + ", $" + credit.getAvailableToSpend();
        System.out.println(result);
        assertEquals("$350.0, $650.0", result);
    }

    @org.junit.jupiter.api.Test
    void testClassHierarchy() {
        ArrayList<Account> accounts = new ArrayList<>();
        Account cashSavings = new CashAccount("New Car Fund", 16789.82, "Savings", 0.03);
        Account Discover = new CreditAccount("Discover", 10000.00, 2356.92, 7643.08);
        accounts.add(cashSavings);
        accounts.add(Discover);

        ArrayList<Account> results = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++){
            results.add(accounts.get(i));
        }
        assertEquals("Account name: New Car Fund\n" +
                "Account Type: Savings\n" +
                "Account Balance: $16789.82\n" +
                "Interest Rate: 0.03%\n" +
                "Account name: Discover\n" +
                "Debt Outstanding: $2356.92\n" +
                "Available to Spend: $7643.08\n" +
                "Total Account Balance: $10000.0", cashSavings +"\n"+ Discover.toString());
    }*/

    @org.junit.jupiter.api.Test
    void testInterface() {
        ArrayList<Retriever> retrievers = new ArrayList<>();
        Payment p1 = new Payment("Debt", "Mortgage", 1850.00);
        Income job = new Income("Software Engineer", 105000.00, "N/A", 0.00, 105000.0);

        retrievers.add(p1);
        retrievers.add(job);

        for (Retriever r : retrievers) {
            r.retrieveYearly();
            r.retrieveMonthly();
            System.out.println("");
        }
    }

}