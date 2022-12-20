package Controller;

import Model.Investment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CollectionController {
    Map<String, Double> investmentReturns = new HashMap<>();

    public CollectionController() throws ParseException {
        buildInitialCollection();
        printCollection();
    }

    public Map<String, Double> getInvestmentReturns() {
        return investmentReturns;
    }

    public void buildInitialCollection() throws ParseException {
        String msftP = "11/11/2021";
        Date msftPurchase = new SimpleDateFormat("dd/MM/yyyy").parse(msftP);
        String msftS = "10/07/2022";
        Date msftSale = new SimpleDateFormat("dd/MM/yyyy").parse(msftS);
        String tslaP = "11/11/2021";
        Date tslaPurchase = new SimpleDateFormat("dd/MM/yyyy").parse(tslaP);
        String tslaS = "01/05/2022";
        Date tslaSale = new SimpleDateFormat("dd/MM/yyyy").parse(tslaS);

        Investment in1 = new Investment("Stock", "MSFT", 24000.0, 20000.0, 10000.0, msftPurchase, true, -6000.0, msftSale);
        Investment in2 = new Investment("Stock", "TSLA", 18000.0, 5000.0, 0.0, tslaPurchase, true, 13000.0, tslaSale);
        this.investmentReturns.put(in1.getName(), in1.getTotalReturn());
        this.investmentReturns.put(in2.getName(), in2.getTotalReturn());
    }

    public Map<String, Double> getInvestmentFromCollection(String search) {
        Map<String, Double> searchResults = new HashMap<>();
        for (Map.Entry entry : investmentReturns.entrySet()) {
            try {
                if (Double.parseDouble(search) <= Double.parseDouble(entry.getValue().toString())) {
                    searchResults.put(entry.getKey().toString(), Double.parseDouble(entry.getValue().toString()));
                }
            } catch (NumberFormatException nfe) {
                if (search.equalsIgnoreCase(entry.getKey().toString())) {
                    searchResults.put(entry.getKey().toString(), Double.parseDouble(entry.getValue().toString()));
                }
            }
        }
        return searchResults;
    }

    public void addNewInvestment(Investment inv) {
        this.investmentReturns.put(inv.getName(), inv.getTotalReturn());
    }

    public void removeItem(Double TR, String invName) {
        Iterator<Map.Entry<String, Double>> iterator = investmentReturns.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            if (TR.equals(entry.getValue()) && invName.equalsIgnoreCase(entry.getKey().toString())) {
                iterator.remove();
            }
        }
    }

    public void updateTotalReturnKey(Double TR, String invName, Double newTR){
        Iterator<HashMap.Entry<String, Double>> iterator = investmentReturns.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            if (TR.equals(entry.getValue()) && invName.equalsIgnoreCase(entry.getKey().toString())) {
                investmentReturns.put(invName, newTR);
            }
        }
    }

    public void printCollection() {
        for (Map.Entry investment : investmentReturns.entrySet()) {
            System.out.println("Investment| " + investment);
        }
    }
}
