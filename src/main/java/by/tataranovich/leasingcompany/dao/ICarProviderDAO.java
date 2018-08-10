package by.tataranovich.leasingcompany.dao;

import by.tataranovich.leasingcompany.model.CarProvider;

public interface ICarProviderDAO extends IDAO<CarProvider> {
    CarProvider getCarProviderByCarId(Long id);
}
