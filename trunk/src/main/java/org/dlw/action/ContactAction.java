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
import org.dlw.model.Contact;
import org.appfuse.service.GenericManager;
import org.appfuse.webapp.action.BaseAction;

import java.util.List;
import java.text.MessageFormat;

/**
 * This class implements the Struts2 action for the Contact object
 *
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 * @version $Id$
 * @description Struts2 Action Class for Contact
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
