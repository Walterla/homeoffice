package org.dlw.dao.hibernate;

/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.dlw.dao.AccountDao;
import org.dlw.model.account.Account;

import java.util.List;

/**
 * <p> This program is open software. It is licensed using the Apache Software
 * Foundation, version 2.0 January 2004
 * </p>
 * <a
 * href="mailto:dlwhitehurst@gmail.com">dlwhitehurst@gmail.com</a>
 *
 * @author David L Whitehurst
 */
public class AccountDaoHibernate extends GenericDaoHibernate implements AccountDao {

    public AccountDaoHibernate() {
        super(Account.class);
    }

    public List getAllChildren(Long id) {
        Account account = (Account) this.get(id);
        return account.getAccountDetails();
    }
}
