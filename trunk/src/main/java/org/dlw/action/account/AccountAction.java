package org.dlw.action.account;

import org.appfuse.webapp.action.BaseAction;
import org.appfuse.service.GenericManager;
import org.dlw.model.Business;
import org.dlw.model.account.Account;

import java.util.List;
import java.text.MessageFormat;

/**
 * <p> This program is open software. It is licensed using the Apache Software
 * Foundation, version 2.0 January 2004
 * </p>
 * <a
 * href="mailto:dlwhitehurst@gmail.com">dlwhitehurst@gmail.com</a>
 *
 * @author David L Whitehurst
 */
public class AccountAction extends BaseAction {
    GenericManager<Account, Long> manager;
    Account account;
    Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public void setAccountManager(GenericManager<Account, Long> genericManager) {
        this.manager = genericManager;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String execute() {
        if (id != null) {
            account = manager.get(id);
        }
        return "success";
    }

    public String save() {
        manager.save(account);
        super.saveMessage("Account updated successfully!");
        return "form";
    }

    private List accounts;

    public List getAccounts() {
        return this.accounts;
    }

    public String list() {
        accounts = manager.getAll();
        return SUCCESS;
    }

    public String delete() {
        manager.remove(account.getId());
        saveMessage(MessageFormat.format("{0} removed successfully.",
                account.getAccountName()));
        return "form";
    }
}

