/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.natica.expense;

/**
 *
 * @author Anil
 */
public class ExpenseConstants {
    public static final String[]    PROJECTS                = {"Anadolu Sigorta AP-AR", "Natica Ofis"}; 
    public static final String[]    EXPENSETYPES            = {"Öğle Yemeği"};
    public static final String[]    PAYMENTMETHOD           = {"Cash", "Personal Credit Card"};
    public static final String[]    CURRENCY                = {"TRY", "USD"};
    
    public static final String      BASEURL                 = "http://support.natica.com.tr:15395";
    public static final long        WAITSECONDS             = 30;
    
    public static final String      LOGINUSERNAMEID         = "CtlLogin1_Login1_UserName";
    public static final String      LOGINPASSWORDID         = "CtlLogin1_Login1_Password";
    public static final String      LOGINBUTTONID           = "CtlLogin1_Login1_Button1";

    public static final String      EXPENSEXPATH            = "//a[contains(text(),'EXPENSES')]";
    public static final String      EXPENSEENTRYDATEXPATH   = ".//*[@id='ctl00_ctl00_ctl00_CB_CB_ContentPlaceHolderBody_CtlAccountExpenseEntryList1_CalendarPopup1_textBox']";
    public static final String      SHOWBUTTONXPATH         = ".//*[@id='ctl00_ctl00_ctl00_CB_CB_ContentPlaceHolderBody_CtlAccountExpenseEntryList1_btnShow']";
    public static final String      CALENDARPOPUPXPATH      = ".//*[@id='ctl00_ctl00_ctl00_CB_CB_ContentPlaceHolderBody_CtlAccountExpenseEntryList1_CalendarPopup1_button']";
    
}


