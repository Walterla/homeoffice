package org.dlw.service;

import org.dlw.model.account.Account;
import org.dlw.dao.AccountDao;

import java.util.List;

public interface AccountManager {

    public void setDao(AccountDao dao);

    public List getAccountDetails(String id);

    public Account getAccount(String id);

    public List getAccounts();

    public void saveAccount(Account account);

    public void removeAccount(String id);

}
