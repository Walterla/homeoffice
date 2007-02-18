package org.dlw.model.account;

import org.appfuse.model.BaseObject;
import org.dlw.model.vehicle.VehicleMaintenance;

import javax.persistence.*;
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

    Long id;
    String accountName;
    String accountNumber;
    String optionalNumber;
    BigDecimal balance;
    BigDecimal budgetBilling;
    BigDecimal regularPayment;
    Date dueDate;

    List<AccountDetail> accountDetails = new ArrayList<AccountDetail>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @OneToMany(mappedBy="account")
    @OrderBy("sequenceNumber")
    public List<AccountDetail> getAccountDetails() {
        return accountDetails;
    }

    public void setAccountDetails(List<AccountDetail> accountDetails) {
        this.accountDetails = accountDetails;
    }

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
