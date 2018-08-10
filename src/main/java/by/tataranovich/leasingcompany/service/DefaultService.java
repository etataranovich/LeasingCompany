package by.tataranovich.leasingcompany.service;

import java.util.List;

public interface DefaultService<T> {
    
    void add(T entity);

    T getById(Long id);

    void update(T entity);

    void delete(Long id);

    List<T> getAll();

}





//void add(T entity);
//T add(T entity);



//T update(T entity);









//Maybe like this?
//public interface DefaultService<T extends IdHolder> {
//
//    T getById(int id);
//
//    T add(T t);
//
//    T update(int id, T t);
//
//    void delete(int id);
//}
