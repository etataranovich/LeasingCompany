package by.tataranovich.leasingcompany.services;


public interface DefaultService<T> {
    
    T getById(Integer id);

    void update(T entity);
  
    void delete(Integer id);
    
//    List<T> getAll();
//    List<T> getAllBy();

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
