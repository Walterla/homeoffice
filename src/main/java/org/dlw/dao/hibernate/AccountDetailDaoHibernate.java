package org.dlw.dao.hibernate;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.dlw.dao.AccountDetailDao;
import org.dlw.model.account.Account;
import org.dlw.model.account.AccountDetail;

/**
 * <p> This program is open software. It is licensed using the Apache Software
 * Foundation, version 2.0 January 2004
 * </p>
 * <a
 * href="mailto:dlwhitehurst@gmail.com">dlwhitehurst@gmail.com</a>
 *
 * @author David L Whitehurst
 */
public class AccountDetailDaoHibernate extends GenericDaoHibernate implements AccountDetailDao {

    public AccountDetailDaoHibernate() {
        super(AccountDetail.class);
    }

    public Account getAccount(Long id) {
        AccountDetail accountDetail = (AccountDetail) this.get(id);
        return accountDetail.getAccount();
    }
}
