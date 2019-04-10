package by.den.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T extends Serializable, ID extends Serializable> {

    void save(T entity);

    void saveOrUpdate(T entity);

    void delete(T entity);

    void deleteAll();

    List<T> findAll();

    T findById(Long id);
}
