package View.AppView;

import Controller.AppController;
import Controller.BudgetListController;
import Controller.InvestmentListController;
import Model.Investment;

import javax.swing.*;

public class AppView extends JFrame{
    private JButton btnBudgetList;
    private JPanel pnlRoot;
    private JButton btnInvestmentList;

    private static final int FRAME_WIDTH = 200;
    private static final int FRAME_HEIGHT = 200;

    private AppController appController;

    public AppView(AppController appController) {
        this.appController = appController;
        createComponents();
    }

    public JButton getBtnBudgetList() {
        return btnBudgetList;
    }
    public JButton getBtnInvestmentList() {
        return btnInvestmentList;
    }

    public void createComponents() {
        this.add(pnlRoot);
        this.setTitle("Assets Anonymous");
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
