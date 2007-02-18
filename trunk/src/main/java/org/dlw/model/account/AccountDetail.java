package org.dlw.model.account;

import org.appfuse.model.BaseObject;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

@Entity
public class AccountDetail extends BaseObject implements Serializable {

    Long id;
    Long sequenceNumber;
    BigDecimal amount;
    Date transactionDate;
    String description;
    Account account;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Long getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Long sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
