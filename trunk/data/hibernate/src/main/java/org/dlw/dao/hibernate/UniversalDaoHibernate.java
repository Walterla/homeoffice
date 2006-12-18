package org.dlw.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dlw.dao.UniversalDao;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * This class serves as the a class that can CRUD any object witout any
 * Spring configuration. The only downside is it does require casting
 * from Object to the object class.
 *
 * @author Bryan Noll
 */
public class UniversalDaoHibernate extends HibernateDaoSupport implements UniversalDao {
    protected final Log log = LogFactory.getLog(getClass());

    /**
     * @see org.dlw.dao.UniversalDao#save(java.lang.Object)
     */
    public void save(Object o) {
        getHibernateTemplate().saveOrUpdate(o);
    }

    /**
     * @see org.dlw.dao.UniversalDao#get(java.lang.Class, java.io.Serializable)
     */
    public Object get(Class clazz, Serializable id) {
        Object o = getHibernateTemplate().get(clazz, id);

        if (o == null) {
            throw new ObjectRetrievalFailureException(clazz, id);
        }

        return o;
    }

    /**
     * @see org.dlw.dao.UniversalDao#getAll(java.lang.Class)
     */
    public List getAll(Class clazz) {
        return getHibernateTemplate().loadAll(clazz);
    }

    /**
     * @see org.dlw.dao.UniversalDao#remove(java.lang.Class, java.io.Serializable)
     */
    public void remove(Class clazz, Serializable id) {
        getHibernateTemplate().delete(get(clazz, id));
    }
}
