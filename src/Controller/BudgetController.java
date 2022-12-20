package Controller;

import Model.Budget;
import View.BudgetView.BudgetView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BudgetController implements ActionListener {
    private BudgetView budgetView;
    ArrayList<Budget> budgetList = new ArrayList<Budget>();

    private int currentBudgetIndex;
    private BudgetListController listController;

    public BudgetController(BudgetListController listController) {
        System.out.println("in BudgetController - from ListController");
        this.listController = listController;

        budgetList = listController.getBudgetList();
        System.out.println("Budget List: " + budgetList);

        budgetView = new BudgetView(listController);
        addActionListeners();

        budgetView.clearTextFields();
        budgetView.setUpButtonForAddView();
        budgetView.setVisible(true);
    }

    public BudgetController(BudgetListController listController, int selectedRow) {
        currentBudgetIndex = selectedRow;
        this.listController = listController;
        budgetList = listController.getBudgetList();

        budgetView = new BudgetView(listController, selectedRow);
        addActionListeners();

        budgetView.setUpButtonForDetailsView();
        budgetView.setVisible(true);
    }
/*
    public void createView() {
        budgetView = new BudgetView(this);
        budgetView.setDisplayMessage("");
    }
*/

    public void addActionListeners() {
        budgetView.getGenerateBudgetBtn().addActionListener(this);
        budgetView.getPreviousBtn().addActionListener(this);
        budgetView.getNextBtn().addActionListener(this);
        budgetView.getDeleteBudgetBtn().addActionListener(this);
        budgetView.getUpdateBtn().addActionListener(this);
        budgetView.getQuitBtn().addActionListener(this);
        budgetView.getBtnBack().addActionListener(this);
        budgetView.getBtnSave().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == budgetView.getPreviousBtn()) {
            displayPreviousBudget();
        }
        if (obj == budgetView.getNextBtn()) {
            displayNextBudget();
        }
        if (obj == budgetView.getDeleteBudgetBtn()) {
            deleteBudget();
        }
        if (obj == budgetView.getUpdateBtn()) {
            updateBudget();
        }
        if (obj == budgetView.getQuitBtn()) {
            quitProcess();
        }
        if (obj == budgetView.getBtnBack()) {
            showBudgetListView();
        }
        if (obj == budgetView.getBtnSave()) {
            addBudgetFromListView();
            showBudgetListView();
        }
    }

    public void addBudget() {
        budgetList.add(budgetView.createNewBudget());
        currentBudgetIndex = budgetList.size()-1;
    }

    public void addBudgetFromListView() {
            budgetList.add(budgetView.createNewBudget());
            currentBudgetIndex = budgetList.size()-1;
            listController.getPersistenceController().writeBudgetFile();
    }

    public void displayPreviousBudget() {
        if (budgetList.isEmpty()) {
            System.out.println("Budget List is already empty.");
        } else {
            int previousBudgetIndex = currentBudgetIndex -1;
            if (previousBudgetIndex < 0) {
                previousBudgetIndex = budgetList.size()-1;
                System.out.println("Already at the beginning of Budget List");
                Budget previousBudget = budgetList.get(previousBudgetIndex);
                budgetView.populateFields(previousBudget);
            } else {
                Budget previousBudget = budgetList.get(previousBudgetIndex);
                budgetView.populateFields(previousBudget);
            }
            currentBudgetIndex = previousBudgetIndex;
        }
    }

    public void displayNextBudget() {
        if (budgetList.isEmpty()) {
            System.out.println("Budget List is already empty.");
        } else {
            int nextBudgetIndex = currentBudgetIndex +1;
            if (nextBudgetIndex >= budgetList.size()) {
                nextBudgetIndex = 0;
                System.out.println("Already at the end of Budget List");
                Budget nextBudget = budgetList.get(nextBudgetIndex);
                budgetView.populateFields(nextBudget);
            } else {
                Budget nextBudget = budgetList.get(nextBudgetIndex);
                budgetView.populateFields(nextBudget);
            }
            currentBudgetIndex = nextBudgetIndex;
        }
    }

    public void deleteBudget() {
        if (budgetList.size() == 0) {
            System.out.println("Budget List is already empty.");
        } else {
            budgetList.remove(budgetList.get(currentBudgetIndex));
            if (currentBudgetIndex > 0) {
                currentBudgetIndex = currentBudgetIndex-1;
                budgetView.populateFields(budgetList.get(currentBudgetIndex));
            } else {
                budgetView.clearTextFields();
                System.out.println("Budget list is already empty.");
            }
        }
    }

    public void updateBudget() {
        Budget updatedBudget = budgetView.createNewBudget();
        budgetList.set(currentBudgetIndex, updatedBudget);
        System.out.println("Budget updated at index " + currentBudgetIndex + " to " + updatedBudget.toString());
    }

    private void showBudgetListView() {
        budgetView.dispose();
        listController.showListView();
    }

    public void quitProcess() {
        System.exit(0);
    }

    private void createInitialList() {
        budgetList.add(new Budget(10000.0, 2000.0, 7500.0, 500.0));
        budgetList.add(new Budget(1000.0, 100.0, 900.0, 0.0));
        budgetList.add(new Budget(5000.0, 2500.0, 2000.0, 500.0));
        currentBudgetIndex = budgetList.size()-1;
        budgetView.populateFields(budgetList.get(currentBudgetIndex));
    }


}

