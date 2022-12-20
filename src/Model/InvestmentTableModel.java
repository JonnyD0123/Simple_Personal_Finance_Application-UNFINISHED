package Model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class InvestmentTableModel extends AbstractTableModel {
    private String[] columnNames = {"Type", "Name", "Value", "Initial Investment", "Capital Added", "Date of Purchase", "Sold", "Total Return", "Date of Sale"};
    private ArrayList<Investment> investmentList;

    public InvestmentTableModel(ArrayList<Investment> investmentList) {
        this.investmentList = investmentList;
    }

    public ArrayList<Investment> getInvestmentList(){return investmentList;}
    public void setInvestmentList(ArrayList<Investment> investmentList){this.investmentList = investmentList;}

    @Override
    public int getRowCount() {return investmentList.size();}

    @Override
    public int getColumnCount() {return columnNames.length;}

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return(Object) investmentList.get(rowIndex).getType();
            case 1:
                return(Object) investmentList.get(rowIndex).getName();
            case 2:
                return(Object) investmentList.get(rowIndex).getValue();
            case 3:
                return(Object) investmentList.get(rowIndex).getInitialInvestment();
            case 4:
                return(Object) investmentList.get(rowIndex).getCapitalAdded();
            case 5:
                return(Object) investmentList.get(rowIndex).getDateOfPurchase();
            case 6:
                return(Object) investmentList.get(rowIndex).getSold();
            case 7:
                return(Object) investmentList.get(rowIndex).getTotalReturn();
            case 8:
                return(Object) investmentList.get(rowIndex).getDateOfSale();
            default: return null;
        }
    }

    public String getColumnName(int columnIndex){return columnNames[columnIndex];}
}
