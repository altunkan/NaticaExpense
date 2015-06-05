/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.natica.expense;

import org.natica.expense.exceptions.ExpenseExcelFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Anil
 */
public class ExpenseParser {
    public List<Expense> parseExcel(File file) throws IOException, ExpenseExcelFormatException {
        List<Expense> expenses = new ArrayList<Expense>();
        FileInputStream fis;
        
        fis = new FileInputStream(file);
        XSSFWorkbook wb;
        
        wb = new XSSFWorkbook(fis);
        XSSFSheet sh = wb.getSheetAt(0);
        
        
        for (Row row : sh) {
            if (row.getRowNum() == 0) {
                if (!checkHeaderRow(sh.getRow(0)))
                    throw new ExpenseExcelFormatException("Excel Başlık İsimleri Hatalıdır.");
                else
                    continue;
            }
            Expense e = new Expense();      
            for (Cell cell : row) {
                if (cell.getColumnIndex() == 0) {
                    if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                        if (!HSSFDateUtil.isCellDateFormatted(cell)) {
                            throw new ExpenseExcelFormatException("Hatalı veri! Satır:"+row.getRowNum()+" Sütun:"+cell.getColumnIndex() + " Hata Nedeni: Veri tipi tarih değil");
                        }
                    }
                    else {
                        throw new ExpenseExcelFormatException("Hatalı veri! Satır:"+row.getRowNum()+" Sütun:"+cell.getColumnIndex() + " Hata Nedeni: Veri tipi tarih değil");
                    }
                    e.setExpenseEntryDate(cell.getDateCellValue());
                }
                else if (cell.getColumnIndex() == 1) {
                    if (cell.getCellType() != Cell.CELL_TYPE_STRING) {
                        throw new ExpenseExcelFormatException("Hatalı veri! Satır:"+row.getRowNum()+" Sütun:"+cell.getColumnIndex() + " Hata Nedeni: Veri tipi yazı değil");
                    }
                    e.setProjectName(cell.getStringCellValue());
                }
                else if (cell.getColumnIndex() == 2) {
                    if (cell.getCellType() != Cell.CELL_TYPE_STRING) {
                        throw new ExpenseExcelFormatException("Hatalı veri! Satır:"+row.getRowNum()+" Sütun:"+cell.getColumnIndex()  + " Hata Nedeni: Veri tipi yazı değil");
                    }
                    e.setExpenseName(cell.getStringCellValue());
                }
                else if (cell.getColumnIndex() == 3) {
                    if (cell.getCellType() != Cell.CELL_TYPE_STRING) {
                        throw new ExpenseExcelFormatException("Hatalı veri! Satır:"+row.getRowNum()+" Sütun:"+cell.getColumnIndex() + " Hata Nedeni: Veri tipi yazı değil");
                    }
                    e.setPaymentMethod(cell.getStringCellValue());
                }
                else if (cell.getColumnIndex() == 4) {
                    if (cell.getCellType() != Cell.CELL_TYPE_STRING) {
                        throw new ExpenseExcelFormatException("Hatalı veri! Satır:"+row.getRowNum()+" Sütun:"+cell.getColumnIndex() + " Hata Nedeni: Veri tipi yazı değil");
                    }
                    e.setCurrency(cell.getStringCellValue());
                }
                else if (cell.getColumnIndex() == 5) {
                    if (cell.getCellType() != Cell.CELL_TYPE_NUMERIC) {
                        throw new ExpenseExcelFormatException("Hatalı veri! Satır:"+row.getRowNum()+" Sütun:"+cell.getColumnIndex() + " Hata Nedeni: Veri tipi nümerik değil");
                    }
                    e.setNetAmount(BigDecimal.valueOf(cell.getNumericCellValue()));
                }
            }
            expenses.add(e);
        }
        
        if (wb != null)
            wb.close();
        
        if (fis != null)
            fis.close();
        
        return expenses;
    }
    
    private boolean checkHeaderRow(Row r) {
        if (!"EXPENSE_ENTRY_DATE".equals(r.getCell(0).getStringCellValue())) 
            return false;
        
        if (!"PROJECT_NAME".equals(r.getCell(1).getStringCellValue())) 
            return false;
        
        if (!"EXPENSE_NAME".equals(r.getCell(2).getStringCellValue())) 
            return false;
        
        if (!"PAYMENT_METHOD".equals(r.getCell(3).getStringCellValue())) 
            return false;
        
        if (!"CURRENCY".equals(r.getCell(4).getStringCellValue())) 
            return false;
        
        if (!"NET_AMOUNT".equals(r.getCell(5).getStringCellValue())) 
            return false;
                                                        
        return true;
    }
}
