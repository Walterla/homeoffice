package org.dlw.service.impl;

import java.util.List;

import org.acegisecurity.userdetails.UsernameNotFoundException;
import org.dlw.dao.UserDao;
import org.dlw.model.User;
import org.dlw.service.UserExistsException;
import org.dlw.service.UserManager;
import org.springframework.dao.DataIntegrityViolationException;


/**
 * Implementation of UserManager interface.</p>
 * 
 * <p>
 * <a href="UserManagerImpl.java.html"><i>View Source</i></a>
 * </p>
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class UserManagerImpl extends BaseManager implements UserManager {
    private UserDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao the UserDao that communicates with the database
     */
    public void setUserDao(UserDao dao) {
        this.dao = dao;
    }

    /**
     * @see org.dlw.service.UserManager#getUser(java.lang.String)
     */
    public User getUser(String userId) {
        return dao.get(new Long(userId));
    }

    /**
     * @see org.dlw.service.UserManager#getUsers(org.dlw.model.User)
     */
    public List getUsers(User user) {
        return dao.getUsers();
    }

    /**
     * @see org.dlw.service.UserManager#saveUser(org.dlw.model.User)
     */
    public void saveUser(User user) throws UserExistsException {
    	// if new user, lowercase userId
    	if (user.getVersion() == null) {
            user.setUsername(user.getUsername().toLowerCase());
    	}
        try {
            dao.saveUser(user);
        } catch (DataIntegrityViolationException e) {
            throw new UserExistsException("User '" + user.getUsername() + "' already exists!");
        }
    }

    /**
     * @see org.dlw.service.UserManager#removeUser(java.lang.String)
     */
    public void removeUser(String userId) {
        log.debug("removing user: " + userId);
        dao.remove(new Long(userId));
    }

    public User getUserByUsername(String username) throws UsernameNotFoundException {
        return (User) dao.loadUserByUsername(username);
    }
}
