package org.dlw.action;

import org.appfuse.webapp.action.BaseAction;
import org.appfuse.service.GenericManager;
import org.dlw.model.Business;

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
