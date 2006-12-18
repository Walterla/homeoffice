package org.dlw.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dlw.dao.UniversalDao;
import org.dlw.service.Manager;

/**
 * Base class for Business Services - use this class for utility methods and
 * generic CRUD methods.
 * 
 * <p><a href="BaseManager.java.html"><i>View Source</i></a></p>
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class BaseManager implements Manager {
    protected final Log log = LogFactory.getLog(getClass());
    protected UniversalDao dao = null;
    
    /**
     * @see org.dlw.service.Manager#setDao(org.dlw.dao.UniversalDao)
     */
    public void setDao(UniversalDao dao) {
        this.dao = dao;
    }
    
    /**
     * @see org.dlw.service.Manager#get(java.lang.Class, java.io.Serializable)
     */
    public Object get(Class clazz, Serializable id) {
        return dao.get(clazz, id);
    }
    
    /**
     * @see org.dlw.service.Manager#getAll(java.lang.Class)
     */
    public List getAll(Class clazz) {
        return dao.getAll(clazz);
    }
    
    /**
     * @see org.dlw.service.Manager#remove(java.lang.Class, java.io.Serializable)
     */
    public void remove(Class clazz, Serializable id) {
        dao.remove(clazz, id);
    }
    
    /**
     * @see org.dlw.service.Manager#save(java.lang.Object)
     */
    public void save(Object o) {
        dao.save(o);
    }
}
