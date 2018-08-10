package by.tataranovich.leasingcompany.dao;

import java.util.List;

import by.tataranovich.leasingcompany.model.Car;

public interface ICarDAO extends IDAO<Car> {

    List<Car> getCarByCarProviderId(Long id);

    Car getCarByContractId(Long idContract);

}
