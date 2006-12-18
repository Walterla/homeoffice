package org.dlw.dao.hibernate;

import java.util.List;

import org.dlw.dao.LookupDao;
import org.dlw.model.Role;

/**
 * Hibernate implementation of LookupDao.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class LookupDaoHibernate extends UniversalDaoHibernate implements LookupDao {

    /**
     * @see org.dlw.dao.LookupDao#getRoles()
     */
    public List<Role> getRoles() {
        log.debug("retrieving all role names...");

        return getHibernateTemplate().find("from Role order by name");
    }
}
