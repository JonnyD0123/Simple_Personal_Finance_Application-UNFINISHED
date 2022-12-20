package Controller;

import Model.Investment;
import View.InvestmentView.InvestmentView;
import Controller.InvestmentPersistenceController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InvestmentController implements ActionListener {
    private InvestmentView investmentView;
    ArrayList<Investment> investmentList = new ArrayList<Investment>();

    private int currentInvestmentIndex;
    private InvestmentListController listController;

    public InvestmentController(InvestmentListController listController) {
        System.out.println("in InvestmentController - from ListController");
        this.listController = listController;

        investmentList = listController.getInvestmentList();
        System.out.println("Investment List: " + investmentList);

        investmentView = new InvestmentView(listController);
        addActionListeners();

        investmentView.clearTextFields();
        investmentView.setUpButtonForAddView();
        investmentView.setVisible(true);
    }

    public InvestmentController(InvestmentListController listController, int selectedRow) {
        currentInvestmentIndex = selectedRow;
        this.listController = listController;
        investmentList = listController.getInvestmentList();

        investmentView = new InvestmentView(listController, selectedRow);
        addActionListeners();

        investmentView.setUpButtonForDetailsView();
        investmentView.setVisible(true);
    }

    public void addActionListeners() {
        investmentView.getBtnAdd().addActionListener(this);
        investmentView.getBtnPrevious().addActionListener(this);
        investmentView.getBtnNext().addActionListener(this);
        investmentView.getBtnDelete().addActionListener(this);
        investmentView.getBtnUpdate().addActionListener(this);
        investmentView.getBtnQuit().addActionListener(this);
        investmentView.getBtnBack().addActionListener(this);
        investmentView.getBtnSave().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == investmentView.getBtnPrevious()) {
            displayPreviousInvestment();
        }
        if (obj == investmentView.getBtnNext()) {
            displayNextInvestment();
        }
        if (obj == investmentView.getBtnDelete()) {
            deleteInvestment();
        }
        if (obj == investmentView.getBtnUpdate()) {
            try {
                updateInvestment();
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
        if (obj == investmentView.getBtnQuit()) {
            quitProcess();
        }
        if (obj == investmentView.getBtnBack()) {
            showInvestmentListView();
        }
        if (obj == investmentView.getBtnSave()) {
            try {
                addInvestmentFromListView();
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            showInvestmentListView();
        }
    }

    public void addInvestment() throws ParseException {
        investmentList.add(investmentView.createNewInvestment());
        currentInvestmentIndex = investmentList.size()-1;
    }

    public void addInvestmentFromListView() throws ParseException {
        investmentList.add(investmentView.createNewInvestment());
        currentInvestmentIndex = investmentList.size()-1;
        listController.getPersistenceController().writeInvestmentFile();
    }

    public void displayPreviousInvestment() {
        if (investmentList.isEmpty()) {
            System.out.println("List is already empty.");
        } else {
            int previousInvestmentIndex = currentInvestmentIndex -1;
            if (previousInvestmentIndex < 0) {
                previousInvestmentIndex = investmentList.size()-1;
                System.out.println("Already at the beginning of List");
                Investment previousInvestment = investmentList.get(previousInvestmentIndex);
                investmentView.populateFields(previousInvestment);
            } else {
                Investment previousInvestment = investmentList.get(previousInvestmentIndex);
                investmentView.populateFields(previousInvestment);
            }
            currentInvestmentIndex = previousInvestmentIndex;
        }
    }

    public void displayNextInvestment() {
        if (investmentList.isEmpty()) {
            System.out.println("List is already empty.");
        } else {
            int nextInvestmentIndex = currentInvestmentIndex +1;
            if (nextInvestmentIndex >= investmentList.size()) {
                nextInvestmentIndex = 0;
                System.out.println("Already at the end of List");
                Investment nextInvestment = investmentList.get(nextInvestmentIndex);
                investmentView.populateFields(nextInvestment);
            } else {
                Investment nextInvestment = investmentList.get(nextInvestmentIndex);
                investmentView.populateFields(nextInvestment);
            }
            currentInvestmentIndex = nextInvestmentIndex;
        }
    }

    public void deleteInvestment() {
        if (investmentList.size() == 0) {
            System.out.println("List is already empty.");
        } else {
            investmentList.remove(investmentList.get(currentInvestmentIndex));
            listController.getPersistenceController().writeInvestmentFile();
            if (currentInvestmentIndex > 0) {
                currentInvestmentIndex = currentInvestmentIndex-1;
                investmentView.populateFields(investmentList.get(currentInvestmentIndex));
            } else {
                investmentView.clearTextFields();
                System.out.println("List is already empty.");
            }
        }
    }

    public void updateInvestment() throws ParseException {
        Investment updatedInvestment = investmentView.createNewInvestment();
        investmentList.set(currentInvestmentIndex, updatedInvestment);
        System.out.println("Investment updated at index " + currentInvestmentIndex + " to " + updatedInvestment.toString());
    }

    private void showInvestmentListView() {
        investmentView.dispose();
        listController.showListView();
    }

    public void quitProcess() {
        System.exit(0);
    }

    private void createInitialList() throws ParseException {
        String msftP = "11/11/2021";
        Date msftPurchase = new SimpleDateFormat("dd/MM/yyyy").parse(msftP);
        String msftS = "10/07/2022";
        Date msftSale = new SimpleDateFormat("dd/MM/yyyy").parse(msftS);

        String tslaP = "11/11/2021";
        Date tslaPurchase = new SimpleDateFormat("dd/MM/yyyy").parse(tslaP);
        String tslaS = "01/05/2022";
        Date tslaSale = new SimpleDateFormat("dd/MM/yyyy").parse(tslaS);

        investmentList.add(new Investment("Stock", "MSFT", 24000.0, 20000.0, 10000.0, msftPurchase, true, -6000.0, msftSale));
        investmentList.add(new Investment("Stock", "TSLA", 18000.0, 5000.0, 0.0, tslaPurchase, true, 13000.0, tslaSale));
        currentInvestmentIndex = investmentList.size()-1;
        investmentView.populateFields(investmentList.get(currentInvestmentIndex));
    }



}
