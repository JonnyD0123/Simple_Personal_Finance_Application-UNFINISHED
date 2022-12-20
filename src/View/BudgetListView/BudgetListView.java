package View.BudgetListView;

import Controller.BudgetListController;

import javax.swing.*;
import java.awt.*;

public class BudgetListView extends JFrame{
    private BudgetListController budgetListController;
    private JPanel pnlRoot;
    private JPanel pnlTable;
    private JScrollPane scrollPane;
    private JTable tblBudgetList;
    private JPanel pnlButtons;
    private JButton btnDetails;
    private JButton btnGenerateNew;
    private JButton btnQuit;

    public BudgetListView(BudgetListController budgetListController) {
        this.budgetListController = budgetListController;
        createComponents();
    }

    public void createComponents() {
        tblBudgetList = new JTable(budgetListController.getBudgetTableModel());
        tblBudgetList.setPreferredScrollableViewportSize(new Dimension(400, 200));
        scrollPane.setViewportView(tblBudgetList);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.add(pnlRoot);
        this.setTitle("Budget List");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public JTable getTblBudgetList() {
        return tblBudgetList;
    }

    public JButton getBtnDetails() {
        return btnDetails;
    }

    public JButton getBtnGenerateNew() {
        return btnGenerateNew;
    }

    public JButton getBtnQuit() {
        return btnQuit;
    }


}
