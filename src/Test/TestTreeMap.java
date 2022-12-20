package Test;

import Controller.CollectionController;
import Model.Investment;

import javax.sound.midi.Soundbank;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class TestTreeMap {

    public TestTreeMap() throws ParseException {
        System.out.println("Initial Collection");
        CollectionController CC = new CollectionController();

        System.out.println("\nAdd a New Item");

        String msftP = "01/11/2022";
        Date msftPurchase = new SimpleDateFormat("dd/MM/yyyy").parse(msftP);
        String msftS = "10/01/2022";
        Date msftSale = new SimpleDateFormat("dd/MM/yyyy").parse(msftS);
        String tslaP = "03/13/2021";
        Date tslaPurchase = new SimpleDateFormat("dd/MM/yyyy").parse(tslaP);
        String tslaS = "12/01/2022";
        Date tslaSale = new SimpleDateFormat("dd/MM/yyyy").parse(tslaS);

        Investment in1 = new Investment("Stock", "AAPL", 20000.0, 12000.0, 10000.0, msftPurchase, true, -2000.0, msftSale);

        CC.addNewInvestment(in1);
        CC.printCollection();

        System.out.println("\nSearch Collection");
        System.out.println("Search for Positive Returns");
        String searchTerm1 = "0.0";
        Map<String, Double> PositiveReturns = CC.getInvestmentFromCollection(searchTerm1);
        System.out.println(PositiveReturns);
        System.out.println("Search for Microsoft Investments");
        String searchTerm2 = "MSFT";
        Map<String, Double> msftInvestments = CC.getInvestmentFromCollection(searchTerm2);
        System.out.println(msftInvestments);

        System.out.println("\nRemove Item from Collection");
        CC.removeItem(-6000.0, "MSFT");
        CC.printCollection();

        System.out.println("\nUpdate Item in Collection");
        CC.updateTotalReturnKey(-2000.0, "AAPL", 3000.0);
        CC.printCollection();
    }
}
