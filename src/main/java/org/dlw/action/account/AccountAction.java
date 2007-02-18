package org.dlw.action.account;

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
import org.appfuse.webapp.action.BaseAction;
import org.appfuse.service.GenericManager;
import org.dlw.model.Business;
import org.dlw.model.account.Account;
import org.dlw.service.AccountManager;

import java.util.List;
import java.text.MessageFormat;

/**
 * This class implements the Struts2 action for the Account object
 *
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version $Id$
 * @description Struts2 Action Class for Account
 */
public class AccountAction extends BaseAction {
    private List accounts;
    private List accountDetails;

    AccountManager accountManager;
    Account account;
    Long id;

    public void setId(Long id) {
        this.id = id;
    }
    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List getAccounts() {
        return this.accounts;
    }

    public List getAccountDetails() {
        return accountDetails;
    }

    public String list() {
        accounts = accountManager.getAccounts();
        return SUCCESS;
    }

    public String listChildren() {
        accountDetails = accountManager.getAccountDetails(account.getId().toString());
        return SUCCESS;
    }

    public String execute() {
        if (id != null) {
            account = (Account) accountManager.getAccount(id.toString());
        }
        return "success";
    }

    public String save() {
        accountManager.saveAccount(account);
        super.saveMessage("Account updated successfully!");
        return "form";
    }

    public String delete() {
        accountManager.removeAccount(account.getId().toString());
        saveMessage(MessageFormat.format("{0} removed successfully.",
                account.getAccountName()));
        return "form";
    }
}

