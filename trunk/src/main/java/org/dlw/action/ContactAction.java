package org.dlw.action;

import org.dlw.model.Contact;
import org.appfuse.service.GenericManager;
import org.appfuse.webapp.action.BaseAction;

import java.util.List;
import java.text.MessageFormat;

/**
 * @author dlwhitehurst 
 */
public class ContactAction extends BaseAction {
    GenericManager<Contact, Long> manager;
    Contact contact;
    Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public void setContactManager(GenericManager<Contact, Long> genericManager) {
        this.manager = genericManager;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String execute() {
        if (id != null) {
            contact = manager.get(id);
        }
        return "success";
    }

    public String save() {
        manager.save(contact);
        super.saveMessage("Contact updated successfully!");
        return "form";
    }

    private List contacts;

    public List getContacts() {
        return this.contacts;
    }
    
    public String list() {
        contacts = manager.getAll();
        return SUCCESS;
    }

    public String delete() {
        manager.remove(contact.getId());
        saveMessage(MessageFormat.format("{0} removed successfully.",
                contact.getFirstName() + ' ' + contact.getLastName()));
        return "form";
    }
}
