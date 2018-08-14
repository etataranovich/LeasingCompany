package by.tataranovich.leasingcompany.service.mybatisimpl;

import java.util.List;

import by.tataranovich.leasingcompany.dao.ICarDAO;
import by.tataranovich.leasingcompany.dao.IClientDAO;
import by.tataranovich.leasingcompany.model.Car;
import by.tataranovich.leasingcompany.mybatis.DatabaseInstance;
import by.tataranovich.leasingcompany.service.ICarService;

public class CarServiceImpl implements ICarService {

    private ICarDAO carDAO;

    public CarServiceImpl() {
	this.carDAO = DatabaseInstance.getInstance().getFactory().openSession().getMapper(ICarDAO.class);

    }

    @Override
    public void add(Car entity) {
	carDAO.add(entity);

    }

    @Override
    public Car getById(Long id) {
	return carDAO.getById(id);
    }

    @Override
    public void update(Car entity) {
	carDAO.update(entity);
    }

    @Override
    public void delete(Long id) {
	carDAO.delete(id);

    }

    @Override
    public List<Car> getAll() {
	return carDAO.getAll();
    }

    @Override
    public List<Car> getCarByCarProviderId(Long id) {
	return carDAO.getCarByCarProviderId(id);
    }

    @Override
    public Car getCarByContractId(Long idContract) {
	return carDAO.getCarByContractId(idContract);
    }

}
