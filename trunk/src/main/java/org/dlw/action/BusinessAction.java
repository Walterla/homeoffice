package org.dlw.action;

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

import java.util.List;
import java.text.MessageFormat;

/**
 * This class implements the Struts2 action for the Business object
 *
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version $Id$
 * @description Struts2 Action Class for Business
 */
public class BusinessAction extends BaseAction {
    GenericManager<Business, Long> manager;
    Business business;
    Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public void setBusinessManager(GenericManager<Business, Long> genericManager) {
        this.manager = genericManager;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public String execute() {
        if (id != null) {
            business = manager.get(id);
        }
        return "success";
    }

    public String save() {
        manager.save(business);
        super.saveMessage("Business updated successfully!");
        return "form";
    }

    private List businesses;

    public List getBusinesses() {
        return this.businesses;
    }

    public String list() {
        businesses = manager.getAll();
        return SUCCESS;
    }

    public String delete() {
        manager.remove(business.getId());
        saveMessage(MessageFormat.format("{0} removed successfully.",
                business.getBusinessName()));
        return "form";
    }
}
