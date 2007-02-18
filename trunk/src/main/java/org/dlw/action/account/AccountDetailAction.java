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
import org.dlw.service.AccountDetailManager;
import org.dlw.model.account.AccountDetail;
import com.opensymphony.xwork2.Preparable;

import java.util.List;
import java.text.MessageFormat;

/**
 * This class implements the Struts2 action for the AccountDetail object
 *
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version $Id$
 * @description Struts2 Action Class for AccountDetail
 */
public class AccountDetailAction extends BaseAction implements Preparable {

    AccountDetailManager accountDetailManager;
    AccountDetail accountDetail;
    Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public AccountDetailManager getAccountDetailManager() {
        return accountDetailManager;
    }

    public void setAccountDetailManager(AccountDetailManager accountDetailManager) {
        this.accountDetailManager = accountDetailManager;
    }

    public AccountDetail getAccountDetail() {
        return accountDetail;
    }

    public void setAccountDetail(AccountDetail accountDetail) {
        this.accountDetail = accountDetail;
    }

    public String execute() {
        if (id != null) {
            accountDetail = accountDetailManager.getAccountDetail(id.toString());
        }
        return "success";
    }

    public String save() {
        accountDetailManager.saveAccountDetail(accountDetail);
        super.saveMessage("AccountDetail updated successfully!");
        return "form";
    }

    private List accountDetails;

    public List getAccountDetails() {
        return this.accountDetails;
    }

    public String list() {
        accountDetails = accountDetailManager.getAccountDetails();
        return SUCCESS;
    }

    public String delete() {
        accountDetailManager.removeAccountDetail(accountDetail.getId().toString());
        saveMessage(MessageFormat.format("{0} removed successfully.",
                accountDetail.getDescription()));
        return "form";
    }

    public void prepare() throws Exception {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            if (!"".equals(getRequest().getParameter("accountDetail.id"))) {
                // prevent failures on new
                accountDetail = accountDetailManager.getAccountDetail(getRequest().getParameter("accountDetail.id"));
            }
        }
    }
}
