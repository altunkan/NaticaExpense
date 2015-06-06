/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.natica.expense;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Anil
 */
public class ExpenseImport {
    private WebDriver driver;
    private String baseUrl;    
    
    public ExpenseImport(String baseUrl) {
        this.baseUrl = baseUrl;
    }
    
    private void setUpDriverConfig(long waitSeconds) {
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(waitSeconds, TimeUnit.SECONDS);
    }    
    
    private void openBrowser() {
        driver.get(baseUrl + "/");
    }
    
    private void login(String username, String password) {
        driver.findElement(By.id(ExpenseConstants.LOGINUSERNAMEID)).clear();
        driver.findElement(By.id(ExpenseConstants.LOGINUSERNAMEID)).sendKeys(username);
        driver.findElement(By.id(ExpenseConstants.LOGINPASSWORDID)).clear();
        driver.findElement(By.id(ExpenseConstants.LOGINPASSWORDID)).sendKeys(password);
        driver.findElement(By.id(ExpenseConstants.LOGINBUTTONID)).click();        
    }
    
    private void goToExpensePage() {
        WebElement expensePageLink = driver.findElement(By.xpath(ExpenseConstants.EXPENSEXPATH));
        expensePageLink.click();	
    }
    
    
    public void importExpenes(List<Expense> expenses) {
        setUpDriverConfig(ExpenseConstants.WAITSECONDS);
        openBrowser();
        login("anil@natica.com.tr", "elansele");
        goToExpensePage();
        WebElement showButton = driver.findElement(By.xpath(ExpenseConstants.CALENDARPOPUPXPATH));
        showButton.click();
        
        System.out.println("asfas");
        System.out.println("asfas");
        
        for (Expense e : expenses) {
            String activeMonthYear = driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_ctl00_CB_CB_ContentPlaceHolderBody_CtlAccountExpenseEntryList1_CalendarPopup1_calendar']/table/tbody/tr[1]/td[2]/span")).getText();
            DateFormat format = new SimpleDateFormat("MMMM yyyy");
            Date activeDate = null;
            try {
               activeDate = format.parse(activeMonthYear);
            } catch (ParseException ex) {
                Logger.getLogger(ExpenseImport.class.getName()).log(Level.SEVERE, null, ex);
            }
            Calendar activeDateCal = Calendar.getInstance();
            activeDateCal.setTime(activeDate);
            
            Calendar expenseEntryDateCal = Calendar.getInstance();
            expenseEntryDateCal.setTime(e.getExpenseEntryDate());
            
            int expenseEntryMonth = expenseEntryDateCal.get(Calendar.MONTH);
            int expenseEntryYear = expenseEntryDateCal.get(Calendar.YEAR);
            int activeMonth = activeDateCal.get(Calendar.MONTH);
            int activeYear = activeDateCal.get(Calendar.YEAR);
            int diff = (activeYear - expenseEntryYear) * 12 + (activeMonth - expenseEntryMonth) + 1;
                    
            
        }
    }
}
