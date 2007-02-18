package org.dlw.dao;

import org.appfuse.dao.GenericDao;
import org.dlw.model.account.Account;

/**
 * <p> This program is open software. It is licensed using the Apache Software
 * Foundation, version 2.0 January 2004
 * </p>
 * <a
 * href="mailto:dlwhitehurst@gmail.com">dlwhitehurst@gmail.com</a>
 *
 * @author David L Whitehurst
 */
public interface AccountDetailDao <T, PK extends java.io.Serializable> extends GenericDao {
    
    public Account getAccount(Long id);
}
