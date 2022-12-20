package Controller;

import Model.Investment;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InvestmentPersistenceController {
    private ArrayList<Investment> investmentList = new ArrayList<>();
    private String fileName = "investmentFile.txt";

    public InvestmentPersistenceController() throws ParseException {
        investmentList = readInvestmentFile();
        if (investmentList == null || investmentList.isEmpty()) {
            System.out.println("creating initial list and saving to file...");
            investmentList = createInitialList();
            writeInvestmentFile();
        }
    }

    public ArrayList<Investment> getInvestmentList() {
        return investmentList;
    }

    public void writeInvestmentFile() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("caught IOException in FileOutputStream: "+ e.getMessage());
        }
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(fos);
            out.writeObject(investmentList);
            out.close();
        } catch (IOException e) {
            System.out.println("caught IOException in ObjectOutputStream: "+ e.getMessage());
        }
        System.out.println("successful in writing investment file");
    }

    public ArrayList<Investment> readInvestmentFile() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("caught IOException in FileInputStream: "+ e.getMessage());
            return null;
        }

        ObjectInputStream in = null;
        ArrayList<Investment> fileData = null;
        try {
            in = new ObjectInputStream(fis);
            fileData = (ArrayList<Investment>) in.readObject();
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("caught IOException in ObjectInputStream: " + e.getMessage());
        }
        return fileData;
    }

    private ArrayList<Investment> createInitialList() throws ParseException {

        ArrayList<Investment> initialList = new ArrayList<>();

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
        initialList.add(in1);
        initialList.add(in2);
        return initialList;
    }
}
