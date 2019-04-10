package by.den.dao.impl;

import by.den.dao.GenericDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository
public abstract class GenericDAOImpl<T extends Serializable, Id extends Serializable> implements GenericDAO<T, Id> {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    private final Class<T> entityClass;

    @SuppressWarnings("unchecked")
    protected GenericDAOImpl() {
        this.entityClass = (Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass())
        .getActualTypeArguments()[0];
    }

    @Override
    public void save(T entity) {
        getSession().saveOrUpdate(entity);
    }

    @Override
    public void saveOrUpdate(T entity) {
        getSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(T entity) {
        getSession().delete(entity);
    }

    @Override
    public void deleteAll() {
        List<T> entities = findAll();
        for (T entity: entities){
            getSession().delete(entity);
        }
    }

    @Override
    public List<T> findAll() {
        List T = null;
        Query query = getSession().createQuery("from " + this.entityClass.getName());
        T = query.list();
        return T;
    }

    @Override
    public T findById(Long id) {
        T t = null;
        t = (T) getSession().get(this.entityClass, id);
        this.getSession();
        return t;
    }
}
