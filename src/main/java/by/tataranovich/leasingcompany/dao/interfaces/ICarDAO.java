package by.tataranovich.leasingcompany.dao.interfaces;

import java.util.List;


import by.tataranovich.leasingcompany.model.Car;

public interface ICarDAO extends DAO<Car> {
    
    public List<Car> getCarByCarProviderId(int id);

    public void add(Car car, int carProviderId);
    
    public Car getCarByContractId(Integer idContract);
    
}
