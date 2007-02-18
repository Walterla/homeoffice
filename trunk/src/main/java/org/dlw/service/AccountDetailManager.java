package org.dlw.service;

import org.dlw.dao.AccountDetailDao;
import org.dlw.model.account.AccountDetail;
import org.dlw.model.account.Account;

import java.util.List;

public interface AccountDetailManager {

    public void setDao(AccountDetailDao dao);

    public AccountDetail getAccountDetail(String id);

    public List getAccountDetails();

    public void saveAccountDetail(AccountDetail accountDetail);

    public void removeAccountDetail(String id);

    public Account getAccount(String id);

}
