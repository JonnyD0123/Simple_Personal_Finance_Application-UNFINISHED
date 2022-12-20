import Controller.AppController;
import Controller.BudgetController;
import Controller.BudgetListController;
import Controller.InvestmentListController;
import Test.TestHarness;
import Test.TestLinkedList;
import Test.TestTreeMap;

import java.text.ParseException;

public class App {
    public static void main(String[] args) throws ParseException {
 //       new TestTreeMap();

        AppController appController = new AppController();
/*
        System.out.println("Linked List Testing - Assets Anonymous");
        new TestLinkedList();


        Date msftPurchase = new GregorianCalendar(2022, Calendar.JANUARY, 10).getTime();

        Payment payment = new Payment("Debt", "Student Loan", 600.00);
        Income mainIncome = new Income(100000, "N/A", 0);
        Investment microsoftStock = new Investment("Stock", "Microsoft", 1000, 950,
                0, msftPurchase, false, 50);
        Budget firstBudget = new Budget(500, 1500, 250);
        CashAccount spendAccount = new CashAccount("Spend", "Debit", 0.03);
        CreditAccount discover = new CreditAccount(750.00, 9250.00);

        System.out.println(payment);
        System.out.println();
        System.out.println(mainIncome);
        System.out.println();
        System.out.println(microsoftStock);
        System.out.println();
        System.out.println(firstBudget);
        System.out.println();
        System.out.println(spendAccount);
        System.out.println();
        System.out.println(discover);
        */
/*
        //call TestHarness
        TestHarness testHarness = new TestHarness();
        System.out.println(testHarness);
*/
       /*
        Payment payment = new Payment("Debt", "Student Loan", 600.00);
        Payment payment2 = new Payment("Tax", "Utilities", 50.00);
        Payment payment3 = new Payment("Debt", "Mortgage", 1850.00);

        ArrayList<Payment> payments = new ArrayList<>();
        payments.add(payment);
        payments.add(payment2);
        payments.add(payment3);

        Budget b = new Budget(10000.00);
        b.calcBudget6040(payments, b);*/
    }
}
