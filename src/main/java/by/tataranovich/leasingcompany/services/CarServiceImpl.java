package by.tataranovich.leasingcompany.services;

import java.util.List;

import by.tataranovich.leasingcompany.dao.jdbc.JDBCCarDAO;
import by.tataranovich.leasingcompany.dao.jdbc.JDBCCarProviderDAO;
import by.tataranovich.leasingcompany.model.Car;

public class CarServiceImpl extends AbstractService<Car, JDBCCarDAO> implements ICarService {

    private JDBCCarProviderDAO carProviderDAO;

    public CarServiceImpl() {
	super(new JDBCCarDAO());
	this.carProviderDAO = new JDBCCarProviderDAO();
    }

    public void add(Car car) {
	carProviderDAO.add(car.getCarProvider());
	dao.add(car);
    }

    @Override
    public List<Car> getCarByCarProviderId(Integer idCarProvider) {
	dao = new JDBCCarDAO();
	List<Car> cars = dao.getCarByCarProviderId(idCarProvider);
	carProviderDAO = new JDBCCarProviderDAO();
	for (Car car : cars) {
	    int carId = car.getId();
	    car.setCarProvider(carProviderDAO.getByCarId(carId));
	}
	return cars;
    }

    // GET ALL !!!!!!!!!!
    // public List<Car> getAll() {
    // dao = new JDBCCarDAO();
    // List<Car> cars = dao.getAll();
    // carProviderDAO = new JDBCCarProviderDAO();
    // for (Car car : cars) {
    // int carId = car.getId();
    // car.setCarProvider(carProviderDAO.getByCarId(carId));
    // }
    // return cars;
    // }

    public List<Car> getAll() {
	List<Car> carList = dao.getAll();
	carList.stream().forEach((m) -> m.setCarProvider(carProviderDAO.getByCarId(m.getId())));
	return carList;
    }

    @Override
    public void update(Car car) {
	dao.update(car);
	carProviderDAO.update(car.getCarProvider());
    }


    @Override
    public Car getCarByContractId(Integer idContract) {
	return dao.getCarByContractId(idContract);
    }

    @Override
    public Car getById(Integer id) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void delete(Integer id) {
	// TODO Auto-generated method stub
	
    }
    
}



















// public Car getByIdFull(int id) {
// Car car = getById(id);
// CarProvider carProvider =
// carProviderService.getById(car.getCarProvider().getId());
// car.setCarProvider(carProvider);
// return car;
// }

// add
/*
 * public List<Car> getByCarProviderId(int id) { return
 * dao.getByCarProviderId(id); }
 */

//
// public JDBCCarDAO CarDAO = new JDBCcarDAO();
// //public JDBCContractDAO contractDAO = new JDBCContractDAO();
//
//
// public void addcar(car car) {
// carDAO.add(car);
//
//
// }
//
// public Car getcar(Car car) {
// return carDAO.getById(car.getId());
//
// }
//
// public List<Car> getAllcars() {
// return carDAO.getAll();
//
// }
//
//
//
// }
// }

// private CarProviderService carProviderService;
//
// public CarServiceImpl() {
// super(new JDBCCarDAO());
// this.carProviderService = new CarProviderServiceImpl();
// }
//
// public Car getByIdFull(int id) {
// Car car = getById(id);
// CarProvider carProvider =
// carProviderService.getById(car.getCarProvider().getId());
// car.setCarProvider(carProvider);
// return car;
// }
