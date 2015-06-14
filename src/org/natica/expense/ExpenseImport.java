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
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Anil
 */
public class ExpenseImport {
    private WebDriver driver;
    private final String baseUrl;    
    private boolean acceptNextAlert;
    
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
    
    private void goToExpenseMonth(Calendar activeDateCal, Calendar expenseEntryDateCal) {
        int expenseEntryMonth = expenseEntryDateCal.get(Calendar.MONTH);
        int expenseEntryYear = expenseEntryDateCal.get(Calendar.YEAR);
        int activeMonth = activeDateCal.get(Calendar.MONTH);
        int activeYear = activeDateCal.get(Calendar.YEAR);
        int diff = (expenseEntryYear- activeYear) * 12 + (expenseEntryMonth - activeMonth);

        while (diff != 0) {
            WebElement calendarBack = driver.findElement(By.xpath(ExpenseConstants.CALENDARBACKXPATH));
            WebElement calendarForward = driver.findElement(By.xpath(ExpenseConstants.CALENDARFORWARDXPATH));                
            if (diff < 0) {
                diff++;
                calendarBack.click();
            }
            else {
                diff--;
                calendarForward.click();
            }
        }                
    }
    
    private WebElement findDay(int expenseDay, int lastDay) {
        List<WebElement> calendarElements = driver.findElements(By.xpath(ExpenseConstants.CALENDARBODYXPATH));
        List<WebElement> calendarRows = calendarElements.get(0).findElements(By.tagName("tr"));
        int rowCount = calendarRows.size();
        for (int i = 0; i < rowCount; i++) {
            if (i == 0 || i == 1)
                continue;

            WebElement rowElement = calendarRows.get(i);
            List<WebElement> calendarCols = rowElement.findElements(By.tagName("td"));
            int colCount = calendarCols.size();
            for (int k = 0; k < colCount; k++) {
                WebElement dayElement = calendarCols.get(k);
                int currentDay = Integer.parseInt(dayElement.getText());
                if (i == 2 && currentDay >= 25) 
                    continue;
                
                if (currentDay == expenseDay)
                    return dayElement;
                
                if (currentDay == lastDay)
                    break;
            }
        }
        return null;
    }
    
    public void importExpenes(List<Expense> expenses, String username, String password) {
        setUpDriverConfig(ExpenseConstants.WAITSECONDS);
        openBrowser();
        login(username, password);
        goToExpensePage();
        for (Expense e : expenses) {
            WebElement calendarButton = driver.findElement(By.xpath(ExpenseConstants.CALENDARPOPUPXPATH));
            calendarButton.click();
            
            String activeMonthYear = driver.findElement(By.xpath(ExpenseConstants.CALENDARACTIVEMONTHXPATH)).getText();
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
            goToExpenseMonth(activeDateCal, expenseEntryDateCal);
       
            WebElement expenseDay = findDay(expenseEntryDateCal.get(Calendar.DAY_OF_MONTH), expenseEntryDateCal.getActualMaximum(Calendar.DATE));
            expenseDay.click();
       
            WebElement showButton = driver.findElement(By.xpath(ExpenseConstants.SHOWBUTTONXPATH));
            showButton.click();
            
            WebElement projectName = driver.findElement(By.xpath(ExpenseConstants.PROJECTNAMEXPATH));
            Select projectNameSelect = new Select(projectName);
            projectNameSelect.selectByVisibleText(e.getProjectName());
            
            WebElement expenseName = driver.findElement(By.xpath(ExpenseConstants.EXPENSENAMEXPATH));
            Select expenseNameSelect = new Select(expenseName);
            expenseNameSelect.selectByVisibleText(e.getExpenseName());
            expenseName.sendKeys(Keys.TAB);
            waitSeconds(3);
                    
            WebElement description = driver.findElement(By.xpath(ExpenseConstants.EXPENSEDESCRIPTIONXPATH));
            description.sendKeys(Keys.chord(Keys.CONTROL, "a"), e.getDescription());
            description.sendKeys(Keys.TAB);
            
            
            WebElement paymentMethod = driver.findElement(By.xpath(ExpenseConstants.PAYMENTMETHODXPATH));
            Select paymentMethodSelect = new Select(paymentMethod);
            paymentMethodSelect.selectByVisibleText(e.getPaymentMethod());

            WebElement netAmount = driver.findElement(By.xpath(ExpenseConstants.NETAMOUNTXPATH));
            netAmount.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END), e.getNetAmount().toString().replace(".", ","));
            netAmount.sendKeys(Keys.TAB);
            waitSeconds(3);

            WebElement addButton = driver.findElement(By.xpath(ExpenseConstants.ADDBUTTONXPATH));
            addButton.click();
            acceptNextAlert = true;
            closeAlertAndGetItsText();
            
            WebElement submitButton = driver.findElement(By.xpath(ExpenseConstants.SUBMITBUTTONXPATH));
            submitButton.click();
                
        }
    }

    
    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
  
    public static void waitSeconds(int secons) {
        System.out.print("Pausing for " + secons + " seconds: ");
        try {
            Thread.currentThread();		
            int x = 1;
            while(x <= secons) {
                Thread.sleep(1000);
                System.out.print(" " + x );
                x = x + 1;
            }
            System.out.print('\n');
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }	
    }
}
