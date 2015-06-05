/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.natica.expense;

import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Anil
 */
public class ExpenseBuilder {
    
    public void generateHeaders(DefaultTableModel model) {
        model.addColumn("Tarih"); 
        model.addColumn("Proje"); 
        model.addColumn("Masraf Tipi");
        model.addColumn("Ödeme Yöntemi");
        model.addColumn("Para Birimi");
        model.addColumn("Net Tutar");
    }
    
    public void populateTable(DefaultTableModel model, List<Expense> expenses) {
        for (Expense e : expenses) {
            model.addRow(new Object[]{e.getExpenseEntryDateString(), e.getProjectName(), e.getExpenseName(), e.getPaymentMethod(), e.getCurrency(), e.getNetAmount()});
        }        
    }
    
    public JComboBox generateProjectComboBox() {
        JComboBox comboBox = new JComboBox();
        comboBox.addItem(ExpenseConstants.PROJECTS[0]);
        comboBox.addItem(ExpenseConstants.PROJECTS[1]);
        return comboBox;
    }
    
}
