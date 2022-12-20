package Controller;

import Model.Budget;
import Model.Investment;
import View.AppView.AppView;
import View.BudgetView.BudgetView;
import View.InvestmentView.InvestmentView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

public class AppController implements ActionListener {
    private AppView appView;
    private InvestmentView investmentView;
    private InvestmentListController investmentListController;
    private BudgetView budgetView;
    private BudgetListController budgetListController;
    ArrayList<Investment> investmentList = new ArrayList<Investment>();
    ArrayList<Budget> budgetList = new ArrayList<Budget>();
    private int currentBudgetIndex;


    public AppController() throws ParseException {
        createView();
        addActionListeners();
        appView.setVisible(true);
    }

    public void createView() {
        appView = new AppView(this);
    }

    public void addActionListeners() {
        appView.getBtnBudgetList().addActionListener(this);
        appView.getBtnInvestmentList().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == appView.getBtnBudgetList()) {
            showBudgetListView();
        }
        if (obj == appView.getBtnInvestmentList()) {
            try {
                showInvestmentListView();
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void showInvestmentListView() throws ParseException {
        investmentListController = new InvestmentListController();
        investmentListController.showListView();
    }

    private void showBudgetListView() {
        budgetListController = new BudgetListController();
        budgetListController.showListView();
    }

    private void createInitialBudgetList() {
        budgetList.add(new Budget(10000.0, 2000.0, 7500.0, 500.0));
        budgetList.add(new Budget(1000.0, 100.0, 900.0, 0.0));
        budgetList.add(new Budget(5000.0, 2500.0, 2000.0, 500.0));
        currentBudgetIndex = budgetList.size()-1;
        budgetView.populateFields(budgetList.get(currentBudgetIndex));
    }
}
