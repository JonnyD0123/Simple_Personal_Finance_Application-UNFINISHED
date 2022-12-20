package Controller;

import Model.Investment;
import Model.InvestmentTableModel;
import View.InvestmentListView.InvestmentListView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InvestmentListController implements ActionListener {
    private ArrayList<Investment> investmentList = new ArrayList<>();
    private InvestmentTableModel tableModel;
    private InvestmentListView listView;
    private InvestmentController controller;
    private InvestmentPersistenceController persistenceController;

    public InvestmentListController() throws ParseException {
        persistenceController = new InvestmentPersistenceController();
        investmentList = persistenceController.getInvestmentList();
        tableModel = new InvestmentTableModel(investmentList);

        createListView();
        addActionListeners();
    }

    public InvestmentTableModel getTableModel(){return tableModel;}

    public ArrayList<Investment> getInvestmentList(){return investmentList;}

    public InvestmentPersistenceController getPersistenceController(){return persistenceController;}

    public void createListView() {listView = new InvestmentListView(this);}

    public void addActionListeners() {
        listView.getBtnAdd().addActionListener(this);
        listView.getBtnDetails().addActionListener(this);
        listView.getBtnQuit().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == listView.getBtnAdd()) {
            showNewInvestmentView();
        }
        if (obj == listView.getBtnDetails()) {
            showDetailsView();
        }
        if (obj == listView.getBtnQuit()) {
            quitProcess();
        }
    }

    public void showListView() {
        listView.setVisible(true);
    }

    public void showDetailsView() {
        listView.dispose();
        int selectedRow = listView.getTblInvestmentList().getSelectedRow();
        System.out.println("selectedRow = " + selectedRow);
        if (selectedRow == -1) {
            System.out.println("setting row to 0");
            selectedRow = 0;
        }
        controller = new InvestmentController(this, selectedRow);
    }

    public void showNewInvestmentView() {
        listView.dispose();
        controller = new InvestmentController(this);
    }

    public void quitProcess() { System.exit(0);}

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
