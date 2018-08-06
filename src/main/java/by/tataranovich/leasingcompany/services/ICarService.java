package by.tataranovich.leasingcompany.services;

import java.util.List;

import by.tataranovich.leasingcompany.model.Car;

public interface ICarService extends DefaultService<Car> {
    
    public List<Car> getCarByCarProviderId(Integer id);
    public Car getCarByContractId(Integer idContract);

}
