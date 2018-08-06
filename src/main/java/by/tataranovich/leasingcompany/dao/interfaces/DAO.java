package by.tataranovich.leasingcompany.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

//public interface DAO<T extends IdHolder> {
public interface DAO<T> {

    void add(T entity);

    T getById(Integer id);

    void update(T entity) throws SQLException;

    void delete(Integer id);

    List<T> getAll();

}
