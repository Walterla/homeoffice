package org.dlw.service.impl;

import org.dlw.service.AccountManager;
import org.dlw.dao.AccountDao;
import org.dlw.model.account.Account;

import java.util.List;

public class AccountManagerImpl implements AccountManager {
    private AccountDao dao = null;
    
    public void setDao(AccountDao dao) {
        this.dao = dao;
    }

    public List getAccountDetails(String id) {
        return dao.getAllChildren(new Long(id));
    }

    public Account getAccount(String id) {
        return (Account) dao.get(new Long(id));
    }

    public List getAccounts() {
        return dao.getAll();
    }

    public void saveAccount(Account account) {
        dao.save(account);
    }

    public void removeAccount(String id) {
        dao.remove(new Long(id));
    }
}
