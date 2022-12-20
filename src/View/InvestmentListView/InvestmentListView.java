package View.InvestmentListView;

import Controller.InvestmentListController;

import javax.swing.*;
import java.awt.*;

public class InvestmentListView extends JFrame {
    private InvestmentListController investmentListController;
    private JPanel pnlRoot;
    private JPanel pnlTable;
    private JButton btnDetails;
    private JButton btnAdd;
    private JButton btnQuit;
    private JPanel pnlButtons;
    private JTable tblInvestmentList;
    private JScrollPane scrollPane;

    public InvestmentListView(InvestmentListController listController) {
        this.investmentListController = listController;
        createComponents();
    }

    public void createComponents() {
        tblInvestmentList = new JTable(investmentListController.getTableModel());
        tblInvestmentList.setPreferredScrollableViewportSize(new Dimension(400, 200));
        scrollPane.setViewportView(tblInvestmentList);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.add(pnlRoot);
        this.setTitle("Investment List");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public JTable getTblInvestmentList() {
        return tblInvestmentList;
    }

    public JButton getBtnDetails() {
        return btnDetails;
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnQuit() {
        return btnQuit;
    }


}
