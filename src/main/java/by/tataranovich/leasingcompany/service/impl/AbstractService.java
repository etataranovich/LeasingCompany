package by.tataranovich.leasingcompany.service.impl;

import by.tataranovich.leasingcompany.dao.impl.AbstractDAO;
import by.tataranovich.leasingcompany.service.DefaultService;

public abstract class AbstractService<T, S extends AbstractDAO<T>> implements DefaultService<T> {
    protected S dao;

    public AbstractService(S dao) {
	this.dao = dao;
    }

    
//  !!!!!!CHANGE it after removing all common methods in AbstractDAO

    //   public T getById(int id) {
//   return dao.getById(id);
//   }
//    public  add(T t) {
//	return dao.add(t);	
//    }
//
//    public update(int id) {
//	return dao.update(id);
//    }
//
//    public void delete(int id) {
//	dao.delete(id);
//    }
    
}


//If add id to arguments

// public T getById(int id) {
// return dao.getById(id);
// }
//
// public T add(T t) {
// return dao.add(t);
// }
//
// public T update(int id, T t) {
// return dao.update(id, t);
// }
//
// public void delete(int id) {
// dao.delete(id);
// }
// }
