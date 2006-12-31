package org.dlw.action;

import org.appfuse.webapp.action.BaseActionTestCase;
import org.appfuse.service.GenericManager;
import org.apache.struts2.ServletActionContext;
import org.dlw.model.Contact;
import org.springframework.mock.web.MockHttpServletRequest;

/**
 * <p> This program is open software. It is licensed using the Apache Software
 * Foundation, version 2.0 January 2004
 * </p>
 * <a
 * href="mailto:dlwhitehurst@gmail.com">dlwhitehurst@gmail.com</a>
 *
 * @author David L Whitehurst
 */
public class ContactActionTest extends BaseActionTestCase {
    private ContactAction action;

    public void setContactAction(ContactAction action) {
 	 	this.action = action;
	}

    /**
     * Tests for correct action return on cancel?
     * 
     * @throws Exception
     */
    public void testCancel() throws Exception {
        assertEquals(action.cancel(), "cancel");
        assertFalse(action.hasActionErrors());

        action.setFrom("list");
        assertEquals(action.cancel(), "cancel");
    }

    /**
     * Tests an edit on the first record of sample_data.xml.  Assumes id=1 is available.
     *
     * @throws Exception
     */
    public void testEdit() throws Exception {
        // so request.getRequestURL() doesn't fail
        MockHttpServletRequest request = new MockHttpServletRequest("GET", "/contact.html");
        ServletActionContext.setRequest(request);

        Contact contact = new Contact();
        contact.setId(1L);
        action.setContact(contact);
        action.getContact().setCellPhone("405-111-3333");
        assertNotNull(action.getContact().getCellPhone());
        assertEquals("success", action.execute());
        assertNotNull(action.getContact());
        assertFalse(action.hasActionErrors());
    }

    /**
     * Creates a new contact and saves it.
     *
     * @throws Exception
     */
    public void testSave() throws Exception {
        // so request.getRequestURL() doesn't fail
        MockHttpServletRequest request = new MockHttpServletRequest("POST", "/contact.html");
        ServletActionContext.setRequest(request);

        Contact contact = new Contact();
        contact.setFirstName("Joe");
        contact.setLastName("Camel");
        contact.setHomeEmail("joecamel@gmail.com");

        action.setContact(contact);
        assertEquals(action.save(), "form");
        assertNotNull(action.getContact());
        assertFalse(action.hasActionErrors());
    }

    /**
     * Tests to see if all contacts are returned
     *
     * @throws Exception
     */
    public void testSearch() throws Exception {
        assertNull(action.getContacts());
        assertEquals("success", action.list());
        assertNotNull(action.getContacts());
        assertFalse(action.hasActionErrors());
    }

    /**
     * Removes id=2 of sample_data.
     * @throws Exception
     */
    public void testRemove() throws Exception {
        Contact contact = new Contact();
        contact.setId(2L);
        action.setContact(contact);
        assertEquals("form", action.delete());
        assertFalse(action.hasActionErrors());
    }

}
