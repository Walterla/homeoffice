package org.dlw.model.account;

import org.appfuse.model.BaseObject;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

/**
 * <p> This program is open software. It is licensed using the Apache Software
 * Foundation, version 2.0 January 2004
 * </p>
 * <a
 * href="mailto:dlwhitehurst@gmail.com">dlwhitehurst@gmail.com</a>
 *
 * @author David L Whitehurst
 */
@Entity
public class Account extends BaseObject implements Serializable {
    protected Long id;

//    protected Long accountType;

    protected String accountName;

    protected String accountNumber;

    protected String optionalNumber;

    protected BigDecimal balance;

    protected BigDecimal budgetBilling;

    protected BigDecimal regularPayment;

    protected Date dueDate;

//    protected List accountDetails = new ArrayList();

//    protected Set contacts = new HashSet();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
/*
    public Long getAccountType() {
        return accountType;                                       
    }

    public void setAccountType(Long accountType) {
        this.accountType = accountType;
    }
*/
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOptionalNumber() {
        return optionalNumber;
    }

    public void setOptionalNumber(String optionalNumber) {
        this.optionalNumber = optionalNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getRegularPayment() {
        return regularPayment;
    }

    public void setRegularPayment(BigDecimal regularPayment) {
        this.regularPayment = regularPayment;
    }

    public BigDecimal getBudgetBilling() {
        return budgetBilling;
    }

    public void setBudgetBilling(BigDecimal budgetBilling) {
        this.budgetBilling = budgetBilling;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
/*
    public List getAccountDetails() {
        return accountDetails;
    }

    public void setAccountDetails(List accountDetails) {
        this.accountDetails = accountDetails;
    }

    public Set getContacts() {
        return contacts;
    }

    public void setContacts(Set contacts) {
        this.contacts = contacts;
    }
*/
    public String toString() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean equals(Object object) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int hashCode() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
