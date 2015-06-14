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
    
    public static final String      CALENDARBACKXPATH       = ".//*[@id='ctl00_ctl00_ctl00_CB_CB_ContentPlaceHolderBody_CtlAccountExpenseEntryList1_CalendarPopup1_calendar']/table/tbody/tr[1]/td[1]/span";
    public static final String      CALENDARFORWARDXPATH    = ".//*[@id='ctl00_ctl00_ctl00_CB_CB_ContentPlaceHolderBody_CtlAccountExpenseEntryList1_CalendarPopup1_calendar']/table/tbody/tr[1]/td[3]/span";

    public static final String      CALENDARBODYXPATH       = ".//*[@id='ctl00_ctl00_ctl00_CB_CB_ContentPlaceHolderBody_CtlAccountExpenseEntryList1_CalendarPopup1_calendar']/table/tbody";

    public static final String      PROJECTNAMEXPATH        = ".//*[@id='ctl00_ctl00_ctl00_CB_CB_ContentPlaceHolderBody_CtlAccountExpenseEntryList1_FormView1_ddlProjectName']";
    public static final String      EXPENSENAMEXPATH        = ".//*[@id='ctl00_ctl00_ctl00_CB_CB_ContentPlaceHolderBody_CtlAccountExpenseEntryList1_FormView1_ddlExpenseName']";
    public static final String      EXPENSEDESCRIPTIONXPATH = ".//*[@id='ctl00_ctl00_ctl00_CB_CB_ContentPlaceHolderBody_CtlAccountExpenseEntryList1_FormView1_DescriptionTextBox']";
    public static final String      PAYMENTMETHODXPATH      = ".//*[@id='ctl00_ctl00_ctl00_CB_CB_ContentPlaceHolderBody_CtlAccountExpenseEntryList1_FormView1_ddlAccountPaymentMethodId']";
    public static final String      CURRENCYXPATH           = ".//*[@id='ctl00_ctl00_ctl00_CB_CB_ContentPlaceHolderBody_CtlAccountExpenseEntryList1_FormView1_ddlAccountCurrencyId']";
    public static final String      NETAMOUNTXPATH          = ".//*[@id='ctl00_ctl00_ctl00_CB_CB_ContentPlaceHolderBody_CtlAccountExpenseEntryList1_FormView1_AmountTextBox']";
    public static final String      ADDBUTTONXPATH          = ".//*[@id='ctl00_ctl00_ctl00_CB_CB_ContentPlaceHolderBody_CtlAccountExpenseEntryList1_FormView1_btnAdd']";
    
}


