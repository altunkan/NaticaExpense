/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.natica.expense;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Anil
 */
public class Expense {
    private Date expenseEntryDate;
    private String projectName;
    private String expenseName;
    private String paymentMethod;
    private String currency;
    private BigDecimal netAmount;
    private Integer documentNumber;
    private String restaurant;
    private BigDecimal vatAmount;
    private String description;

    /**
     * @return the expenseEntryDate
     */
    public Date getExpenseEntryDate() {
        return expenseEntryDate;
    }

    /**
     * @param expenseEntryDate the expenseEntryDate to set
     */
    public void setExpenseEntryDate(Date expenseEntryDate) {
        this.expenseEntryDate = expenseEntryDate;
    }

    /**
     * @return the projectName
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * @param projectName the projectName to set
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * @return the expenseName
     */
    public String getExpenseName() {
        return expenseName;
    }

    /**
     * @param expenseName the expenseName to set
     */
    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    /**
     * @return the paymentMethod
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * @param paymentMethod the paymentMethod to set
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * @return the netAmount
     */
    public BigDecimal getNetAmount() {
        return netAmount;
    }

    /**
     * @param netAmount the netAmount to set
     */
    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }
    
    public String getExpenseEntryDateString() {
        String pattern = "dd.MM.yyyy";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(getExpenseEntryDate());
    }

    /**
     * @return the documentNumber
     */
    public Integer getDocumentNumber() {
        return documentNumber;
    }

    /**
     * @param documentNumber the documentNumber to set
     */
    public void setDocumentNumber(Integer documentNumber) {
        this.documentNumber = documentNumber;
    }

    /**
     * @return the restaurant
     */
    public String getRestaurant() {
        return restaurant;
    }

    /**
     * @param restaurant the restaurant to set
     */
    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    /**
     * @return the vatAmount
     */
    public BigDecimal getVatAmount() {
        return vatAmount;
    }

    /**
     * @param vatAmount the vatAmount to set
     */
    public void setVatAmount(BigDecimal vatAmount) {
        this.vatAmount = vatAmount;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
