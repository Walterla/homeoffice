package org.dlw.dao;

import java.io.Serializable;
import java.util.List;

import org.dlw.model.Role;

/**
 * Role Data Access Object (DAO) interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public interface RoleDao extends GenericDao<org.dlw.model.Role, Long> {
    /**
     * Gets role information based on rolename
     * @param rolename the rolename
     * @return role populated role object
     */
    public Role getRoleByName(String rolename);
    
    /**
     * Removes a role from the database by name
     * @param rolename the role's rolename
     */
    public void removeRole(String rolename);
}
