package View.BudgetView;

import Controller.BudgetController;
import Controller.BudgetListController;
import Model.Budget;

import javax.swing.*;

public class BudgetView extends JFrame{
    private JPanel budgetPanel;
    private JLabel lblBudget;
    private JTextField txtSave;
    private JTextField txtSpend;
    private JTextField txtInvest;
    private JLabel lblSave;
    private JLabel lblSpend;
    private JLabel lbl_Invest;
    private JButton previousBtn;
    private JButton generateBudgetBtn;
    private JTextField txtTotalIncome;
    private JLabel lblTotalIncome;
    private JButton nextBtn;
    private JButton updateBtn;
    private JButton deleteBudgetBtn;
    private JButton quitBtn;
    private JButton btnBack;
    private JButton btnSave;
    private JLabel lblMessage;

    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 800;


    private BudgetListController listController;

    public Budget createNewBudget() {
        Double ti = Double.parseDouble(txtTotalIncome.getText());
        if (txtTotalIncome.getText().equals("")){
            txtTotalIncome.setText("0.0");
        }
        Double save = Double.parseDouble(txtSave.getText());
        Double spend = Double.parseDouble(txtSpend.getText());
        Double invest = Double.parseDouble(txtInvest.getText());
        Budget inputBudget = new Budget(ti, save, spend, invest);
        return inputBudget;
    }

    private BudgetController budgetController;
/*
    public BudgetView(BudgetController budgetController) {
        this.budgetController = budgetController;
        createComponents();
    }
*/

    public BudgetView(BudgetListController listController) {
        this.listController = listController;
        createComponents();
    }

    public BudgetView(BudgetListController listController, int selectedRow) {
        this.listController = listController;
        createComponents();

        Budget selectedBudget = listController.getBudgetList().get(selectedRow);
        System.out.println("Selected Budget: " + selectedBudget);
        populateFields(selectedBudget);
    }

    public void createComponents() {
        this.add(budgetPanel);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle("Budget Ideas");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JButton getGenerateBudgetBtn() {
        return generateBudgetBtn;
    }

    public JButton getPreviousBtn() {
        return previousBtn;
    }

    public JButton getDeleteBudgetBtn() {
        return deleteBudgetBtn;
    }

    public JButton getUpdateBtn() {
        return updateBtn;
    }

    public JButton getNextBtn() {
        return nextBtn;
    }

    public JButton getQuitBtn() {
        return quitBtn;
    }

    public JButton getBtnBack() {return btnBack;}

    public JButton getBtnSave() {return btnSave;}

    public void setDisplayMessage(String message) {
        lblMessage.setText(message);
    }

    public void populateFields(Budget budget) {
        //add null check
        txtTotalIncome.setText(""+budget.getTotalIncome());
        txtSave.setText(""+budget.getSave());
        txtSpend.setText(""+budget.getSpend());
        txtInvest.setText(""+budget.getInvest());
    }

    public void clearTextFields() {
        this.txtTotalIncome.setText("");
        this.txtSave.setText("");
        this.txtSpend.setText("");
        this.txtInvest.setText("");
    }

    public void setUpButtonForAddView() {
        generateBudgetBtn.setVisible(false);
        deleteBudgetBtn.setVisible(false);
        previousBtn.setVisible(false);
        nextBtn.setVisible(false);
        updateBtn.setVisible(false);
        quitBtn.setVisible(false);
        btnBack.setVisible(true);
        btnSave.setVisible(true);
    }

    public void setUpButtonForDetailsView() {
        generateBudgetBtn.setVisible(false);
        deleteBudgetBtn.setVisible(true);
        previousBtn.setVisible(true);
        nextBtn.setVisible(true);
        updateBtn.setVisible(true);
        quitBtn.setVisible(true);
        btnBack.setVisible(true);
        btnSave.setVisible(false);
    }
}