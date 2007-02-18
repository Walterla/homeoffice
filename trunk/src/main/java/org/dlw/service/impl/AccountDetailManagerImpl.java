package org.dlw.service.impl;

import org.dlw.service.AccountDetailManager;
import org.dlw.dao.AccountDetailDao;
import org.dlw.model.account.AccountDetail;
import org.dlw.model.account.Account;

import java.util.List;

public class AccountDetailManagerImpl implements AccountDetailManager {

    private AccountDetailDao dao = null;

    public void setDao(AccountDetailDao dao) {
        this.dao = dao;
    }

    public AccountDetail getAccountDetail(String id) {
        return (AccountDetail) dao.get(new Long(id));
    }

    public List getAccountDetails() {
        return dao.getAll();
    }

    public void saveAccountDetail(AccountDetail accountDetail) {
        dao.save(accountDetail);
    }

    public void removeAccountDetail(String id) {
        dao.remove(new Long(id));
    }

    public Account getAccount(String id) {
        return dao.getAccount(new Long(id));
    }
}
