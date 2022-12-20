package Model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class BudgetTableModel extends AbstractTableModel {
    private String[] columnNames = {"Total Income", "Save", "Spend", "Invest"};
    private ArrayList<Budget> budgetList;

    public BudgetTableModel(ArrayList<Budget> budgetList) {
        this.budgetList = budgetList;
    }

    public ArrayList<Budget> getBudgetList(){return budgetList;}

    public void setBudgetList(ArrayList<Budget> budgetList){this.budgetList = budgetList;}

    @Override
    public int getRowCount() {return budgetList.size();}

    @Override
    public int getColumnCount() {return columnNames.length;}

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return(Object) budgetList.get(rowIndex).getTotalIncome();
            case 1:
                return(Object) budgetList.get(rowIndex).getSave();
            case 2:
                return(Object) budgetList.get(rowIndex).getSpend();
            case 3:
                return(Object) budgetList.get(rowIndex).getInvest();
            default: return null;
        }
    }

    public String getColumnName(int columnIndex){return columnNames[columnIndex];}
}
