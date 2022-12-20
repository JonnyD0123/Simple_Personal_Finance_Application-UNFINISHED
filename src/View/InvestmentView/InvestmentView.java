package View.InvestmentView;

import Controller.InvestmentController;
import Controller.InvestmentListController;
import Model.Investment;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.*;
import java.util.Date;

public class InvestmentView extends JFrame{
    private JPanel pnlRoot;
    private JLabel lblType;
    private JLabel lblName;
    private JLabel lblValue;
    private JLabel lblInitialInvestment;
    private JLabel lblCapitalAdded;
    private JLabel lblDateOfPurchase;
    private JLabel lblSold;
    private JLabel lblTotalReturn;
    private JLabel lblDateOfSale;
    private JTextField txtType;
    private JTextField txtName;
    private JTextField txtValue;
    private JTextField txtInitialInvestment;
    private JTextField txtCapitalAdded;
    private JTextField txtDateOfPurchase;
    private JTextField txtSold;
    private JTextField txtTotalReturn;
    private JTextField txtDateOfSale;
    private JPanel pnlButtons;
    private JPanel pnlTitle;
    private JLabel lblTitle;
    private JButton btnPrevious;
    private JButton btnAdd;
    private JButton btnNext;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnBack;
    private JButton btnSave;
    private JButton btnQuit;

    private InvestmentListController listController;

    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 800;

    public Investment createNewInvestment() throws ParseException {
        String type = txtType.getText().toString();
        String name = txtName.getText();
        Double value = Double.parseDouble(txtValue.getText());
        Double initialInvestment = Double.parseDouble(txtInitialInvestment.getText());
        Double capitalAdded = Double.parseDouble(txtCapitalAdded.getText());
        Date dateOfPurchase = null;
        try {
            dateOfPurchase = new SimpleDateFormat("dd/MM/yyyy").parse(txtDateOfPurchase.getText());
        } catch (ParseException e){
            System.out.println("Date Format must be: 'dd/MM/yyyy");
        }
        Boolean sold = Boolean.parseBoolean(txtSold.getText());
        Double totalReturn = Double.parseDouble(txtTotalReturn.getText());
        if(sold) {
            try {
                Date dateOfSale = new SimpleDateFormat("dd/MM/yyyy").parse(txtDateOfSale.getText());
                Investment input = new Investment(type, name, value, initialInvestment, capitalAdded, dateOfPurchase, sold, totalReturn, dateOfSale);
                return input;
            } catch (ParseException e){
                System.out.println("Date Format must be: 'dd/MM/yyyy");
                return null;
            }
        } else {
            Investment input = new Investment(type, name, value, initialInvestment, capitalAdded, dateOfPurchase, sold, totalReturn);
            return input;
        }
    }

    private InvestmentController investmentController;
/*
    public BudgetView(BudgetController budgetController) {
        this.budgetController = budgetController;
        createComponents();
    }
*/

    public InvestmentView(InvestmentListController listController) {
        this.listController = listController;
        createComponents();
    }

    public InvestmentView(InvestmentListController listController, int selectedRow) {
        this.listController = listController;
        createComponents();

        Investment selectedInvestment = listController.getInvestmentList().get(selectedRow);
        System.out.println("Selected Investment: " + selectedInvestment);
        populateFields(selectedInvestment);
    }

    public void createComponents() {
        this.add(pnlRoot);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle("Investment Ideas");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }
    public JButton getBtnPrevious() {
        return btnPrevious;
    }
    public JButton getBtnDelete() {
        return btnDelete;
    }
    public JButton getBtnUpdate() {
        return btnUpdate;
    }
    public JButton getBtnNext() {
        return btnNext;
    }
    public JButton getBtnQuit() {
        return btnQuit;
    }
    public JButton getBtnBack() {return btnBack;}
    public JButton getBtnSave() {return btnSave;}

    public void populateFields(Investment investment) {
        //add null check
       this.txtType.setText(""+investment.getType());
       this.txtName.setText(""+investment.getName());
       this.txtValue.setText(""+investment.getValue());
       this.txtInitialInvestment.setText(""+investment.getInitialInvestment());
       this.txtCapitalAdded.setText(""+investment.getCapitalAdded());
       this.txtDateOfPurchase.setText(""+investment.getDateOfPurchase());
       this.txtSold.setText(""+investment.getSold());
       this.txtTotalReturn.setText(""+investment.getTotalReturn());
       this.txtDateOfSale.setText(""+investment.getDateOfSale());
    }

    public void clearTextFields() {
        this.txtType.setText("");
        this.txtName.setText("");
        this.txtValue.setText("");
        this.txtInitialInvestment.setText("");
        this.txtCapitalAdded.setText("");
        this.txtDateOfPurchase.setText("dd/MM/yyyy");
        this.txtSold.setText("");
        this.txtTotalReturn.setText("");
        this.txtDateOfSale.setText("dd/MM/yyyy");
    }

    public void setUpButtonForAddView() {
        btnAdd.setVisible(false);
        btnDelete.setVisible(false);
        btnPrevious.setVisible(false);
        btnNext.setVisible(false);
        btnUpdate.setVisible(false);
        btnQuit.setVisible(false);
        btnBack.setVisible(true);
        btnSave.setVisible(true);
    }

    public void setUpButtonForDetailsView() {
        btnAdd.setVisible(false);
        btnDelete.setVisible(true);
        btnPrevious.setVisible(true);
        btnNext.setVisible(true);
        btnUpdate.setVisible(true);
        btnQuit.setVisible(true);
        btnBack.setVisible(true);
        btnSave.setVisible(false);
    }
}
