package by.tataranovich.leasingcompany.service.jdbcimpl;

import java.util.List;

import by.tataranovich.leasingcompany.dao.jdbcimpl.JDBCCarDAO;
import by.tataranovich.leasingcompany.dao.jdbcimpl.JDBCCarProviderDAO;
import by.tataranovich.leasingcompany.model.Car;
import by.tataranovich.leasingcompany.service.ICarService;

public class CarServiceImpl extends AbstractService<Car, JDBCCarDAO> implements ICarService {

    private JDBCCarProviderDAO carProviderDAO;

    public CarServiceImpl() {
	super(new JDBCCarDAO());
	this.carProviderDAO = new JDBCCarProviderDAO();
    }

    @Override
    public void add(Car car) {
	carProviderDAO.add(car.getCarProvider());
	dao.add(car);
    }

    @Override
    public List<Car> getCarByCarProviderId(Long idCarProvider) {
	dao = new JDBCCarDAO();
	List<Car> cars = dao.getCarByCarProviderId(idCarProvider);
	carProviderDAO = new JDBCCarProviderDAO();
	for (Car car : cars) {
	    long carId = car.getId();
	    car.setCarProvider(carProviderDAO.getCarProviderByCarId((carId)));
	}
	return cars;
    }

    public List<Car> getAll() {
	List<Car> carList = dao.getAll();
	carList.stream().forEach((m) -> m.setCarProvider(carProviderDAO.getCarProviderByCarId(m.getId())));
	return carList;
    }

    @Override
    public void update(Car car) {
	dao.update(car);
	carProviderDAO.update(car.getCarProvider());
    }

    @Override
    public Car getCarByContractId(Long idContract) {
	Car car = dao.getCarByContractId(idContract);
	car.setCarProvider(carProviderDAO.getCarProviderByCarId(car.getId()));
	return car;
    }

    @Override
    public Car getById(Long id) {

	return null;
    }

    @Override
    public void delete(Long id) {

    }

}

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
