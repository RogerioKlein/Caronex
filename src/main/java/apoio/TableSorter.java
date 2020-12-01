/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Rogério H. Klein <rhklein@universo.univates.br>
 */
public class TableSorter {

    public TableSorter() {
        
    }

    public void sorter(JTable jTable) {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>((DefaultTableModel) jTable.getModel());
        jTable.setRowSorter(sorter);
    }
}
