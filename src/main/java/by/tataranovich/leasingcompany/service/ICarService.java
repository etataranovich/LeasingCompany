package by.tataranovich.leasingcompany.service;

import java.util.List;

import by.tataranovich.leasingcompany.model.Car;

public interface ICarService extends DefaultService<Car> {
    
    public List<Car> getCarByCarProviderId(Long id);
    public Car getCarByContractId(Long idContract);

}
