package Controller;

import Model.Budget;

import java.io.*;
import java.util.ArrayList;

public class BudgetPersistenceController {
    private ArrayList<Budget> budgetList = new ArrayList<>();
    private String fileName = "budgetFile.txt";

    public BudgetPersistenceController() {
        budgetList = readBudgetFile();
        if (budgetList == null || budgetList.isEmpty()) {
            System.out.println("creating initial list and saving to file...");
            budgetList = createInitialList();
            writeBudgetFile();
        }
    }

    public ArrayList<Budget> getBudgetList() {
        return budgetList;
    }

    public void writeBudgetFile() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("caught IOException in FileOutputStream: "+ e.getMessage());
        }
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(fos);
            out.writeObject(budgetList);
            out.close();
        } catch (IOException e) {
            System.out.println("caught IOException in ObjectOutputStream: "+ e.getMessage());
        }
        System.out.println("successful in writing budget file");
    }

    public ArrayList<Budget> readBudgetFile() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("caught IOException in FileInputStream: "+ e.getMessage());
            return null;
        }

        ObjectInputStream in = null;
        ArrayList<Budget> fileData = null;
        try {
            in = new ObjectInputStream(fis);
            fileData = (ArrayList<Budget>) in.readObject();
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("caught IOException in ObjectInputStream: " + e.getMessage());
        }
        return fileData;
    }

    public ArrayList<Budget> createInitialList() {
        ArrayList<Budget> initialList = new ArrayList<>();
        Budget b1 = new Budget(10000.0, 2000.0, 7500.0, 500.0);
        Budget b2 =new Budget(1000.0, 100.0, 900.0, 0.0);
        Budget b3 = new Budget(5000.0, 2500.0, 2000.0, 500.0);
        initialList.add(b1);
        initialList.add(b2);
        initialList.add(b3);
        return initialList;
    }
}
