package by.tataranovich.leasingcompany.dao;

import java.util.List;

public interface IDAO<T> {

    void add(T entity);

    T getById(Long id);

    void update(T entity);

    void delete(Long id);

    List<T> getAll();

}
