package Controller;

import Model.Budget;
import Model.BudgetTableModel;
import View.BudgetListView.BudgetListView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BudgetListController implements ActionListener {
    private ArrayList<Budget> budgetList = new ArrayList<>();
    private BudgetTableModel budgetTableModel;
    private BudgetListView budgetListView;
    private BudgetController budgetController;
    private BudgetPersistenceController persistenceController;

    public BudgetListController() {
        persistenceController = new BudgetPersistenceController();
        budgetList = persistenceController.getBudgetList();
        budgetTableModel = new BudgetTableModel(budgetList);

        createListView();
        addActionListeners();
    }

    public BudgetTableModel getBudgetTableModel(){return budgetTableModel;}

    public ArrayList<Budget> getBudgetList(){return budgetList;}

    public BudgetPersistenceController getPersistenceController(){return persistenceController;}

    public void createListView() {budgetListView = new BudgetListView(this);}

    public void addActionListeners() {
        budgetListView.getBtnGenerateNew().addActionListener(this);
        budgetListView.getBtnDetails().addActionListener(this);
        budgetListView.getBtnQuit().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == budgetListView.getBtnGenerateNew()) {
            showNewBudgetView();
        }
        if (obj == budgetListView.getBtnDetails()) {
            showDetailsView();
        }
        if (obj == budgetListView.getBtnQuit()) {
            quitProcess();
        }
    }

    public void showListView() {
        budgetListView.setVisible(true);
    }

    public void showDetailsView() {
        budgetListView.dispose();
        int selectedRow = budgetListView.getTblBudgetList().getSelectedRow();
        System.out.println("selectedRow = " + selectedRow);
        if (selectedRow == -1) {
            System.out.println("setting row to 0");
            selectedRow = 0;
        }
        budgetController = new BudgetController(this, selectedRow);
    }

    public void showNewBudgetView() {
        budgetListView.dispose();
        budgetController = new BudgetController(this);
    }

    public void quitProcess() { System.exit(0);}

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
