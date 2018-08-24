package by.tataranovich.leasingcompany.service;

import java.util.List;

import by.tataranovich.leasingcompany.model.Car;

public interface ICarService extends DefaultService<Car> {
    
    List<Car> getCarByCarProviderId(Long id);
    Car getCarByContractId(Long idContract);

}
