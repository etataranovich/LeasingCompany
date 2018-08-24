package by.tataranovich.leasingcompany.service.mybatisimpl;

import java.util.List;

import by.tataranovich.leasingcompany.model.Car;
import by.tataranovich.leasingcompany.mybatis.DatabaseInstance;
import by.tataranovich.leasingcompany.service.ICarService;

public class CarServiceImpl implements ICarService {

    private ICarService carService;

    public CarServiceImpl() {
	this.carService = DatabaseInstance.getInstance().getFactory().openSession(true).getMapper(ICarService.class);

    }

    @Override
    public void add(Car entity) {
	carService.add(entity);

    }

    @Override
    public Car getById(Long id) {
	return carService.getById(id);
    }

    @Override
    public void update(Car entity) {
	carService.update(entity);
    }

    @Override
    public void delete(Long id) {
	carService.delete(id);

    }

    @Override
    public List<Car> getAll() {
	return carService.getAll();
    }

    @Override
    public List<Car> getCarByCarProviderId(Long id) {
	return carService.getCarByCarProviderId(id);
    }

    @Override
    public Car getCarByContractId(Long idContract) {
	return carService.getCarByContractId(idContract);
    }

}
