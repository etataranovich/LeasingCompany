package by.tataranovich.leasingcompany.mybatis;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.tataranovich.leasingcompany.dao.IAddressDAO;
import by.tataranovich.leasingcompany.dao.ICarDAO;
import by.tataranovich.leasingcompany.dao.ICarProviderDAO;
import by.tataranovich.leasingcompany.model.Address;
import by.tataranovich.leasingcompany.model.Car;
import by.tataranovich.leasingcompany.model.CarModel;
import by.tataranovich.leasingcompany.model.CarProvider;
import by.tataranovich.leasingcompany.service.IAddressService;
import by.tataranovich.leasingcompany.service.mybatisimpl.LeasingCompanyServiceImpl;
import by.tataranovich.leasingcompany.service.mybatisimpl.AddressServiceImpl;
import by.tataranovich.leasingcompany.service.mybatisimpl.ContractServiceImpl;

public class RunnerMybatis {
    private static final Logger LOGGER = LogManager.getLogger(RunnerMybatis.class);

    public static void main(String[] args) {

	// IAddressDAO addressDAO =
	// DatabaseInstance.getInstance().getFactory().openSession(true)
	// .getMapper(IAddressDAO.class);
	// ICarDAO carDAO =
	// DatabaseInstance.getInstance().getFactory().openSession().getMapper(ICarDAO.class);
	// ICarProviderDAO carProviderDAO =
	// DatabaseInstance.getInstance().getFactory().openSession()
	// .getMapper(ICarProviderDAO.class);
	
	// CarProvider carProvider = carProviderDAO.getById(1);
	// LOGGER.info(carProvider);
	
	AddressServiceImpl addressService = new AddressServiceImpl();
	
	Address address1 = new Address();
	address1.setStreet("Kalinovski");
	address1.setHouseNumber("134a");
	address1.setLeasingCompanyId(1);
	
	addressService.add(address1);
	
	Address address2 = addressService.getById((long) 2);
	address2.setStreet("Nezavisimosti");
	address2.setLeasingCompanyId(2);
	
	addressService.update(address2);
	
	
	
	
	
	
	
	
	ContractServiceImpl contractService = new ContractServiceImpl();
	
	LOGGER.info(contractService.getAll());
	LeasingCompanyServiceImpl leasingCompanyService = new LeasingCompanyServiceImpl();
	
	LOGGER.info(addressService.getAddressesByLeasingCompanyId((long) 1));
	LOGGER.info(leasingCompanyService.getAll());
//	Car car1 = new Car();
//	car1.setCarModel(CarModel.AUDI);
//		
//	Car car3 = new Car();
//	
//	
//	car3.setCarModel(CarModel.AUDI);
//
//	if (car1.getCarModel()==(car3.getCarModel())) {
//	    LOGGER.info("Good");
//	}
//	
//	else  {
//	    LOGGER.info(car1.getCarModel());
//	    LOGGER.info(car3.getCarModel());
//	    
//	}
	    
//	 car1.setPrice(456);
//	car1.setCarProvider(carProvider);
//	 carDAO.add(car1);

	// // addressDAO.add(address1);
	//
	// Address address = addressDAO.getById((long) 2);

	// LOGGER.info(address);
	// carDAO.getById(id)
	//AddressServiceImpl addressService = new AddressServiceImpl();
	//Address address2 = addressService.getById((long) 21);
	//address2.setStreet("dd");
	// address2.setLeasingCompanyId(1);
	//List<Address> addresses = addressService.getAll();
	// Car car = carDAO.getById((long) 1);
	//LOGGER.info(addresses);

	//addressService.update(address2);
	//LOGGER.info(address2);
	//
	// carDAO.getById(1);
	// LOGGER.info(carDAO.getById(1));

    }

}

// package by.tataranovich.leasingcompany.mybatis;
// package by.tataranovich.leasingcompany.mybatis;
//
// import java.io.IOException;
// import java.io.InputStream;
//
// import org.apache.ibatis.io.Resources;
// import org.apache.ibatis.session.SqlSessionFactory;
// import org.apache.ibatis.session.SqlSessionFactoryBuilder;
// import org.apache.logging.log4j.LogManager;
// import org.apache.logging.log4j.Logger;
//
// import by.tataranovich.leasingcompany.dao.IAddressDAO;
// import by.tataranovich.leasingcompany.model.Address;
//
// public class RMB {
//
// private static final Logger lOGGER =
// LogManager.getLogger(RunnerMyBatis.class);
//
// public static void main(String[] args) {
//
// // @Override
// // public void add(Address address) {
// // SqlSession session = null;
// // try {
// // session = getSqlSessionFactory().openSession();
// //
// session.insert("com.roxoft.buildingcompany.main.dao.mybatis.MyBatisAddressDao.add",
// // address);
// // session.commit();
// // } finally {
// // close(session);
// // }
// // }
// //
//
//// SqlSessionFactory sqlSessionFactory;
//// IAddressDAO addressDAO;
//// InputStream is = null;
////
//// // Reader reader = null;
//// try {
//// // is =
// Resources.getResourceAsStream("src\\main\\resources\\mybatis2.xml");
//// is =
// Resources.getResourceAsStream(getClass().getResource("src\\main\\resources\\mybatis.xml"));
////
//// sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
//// addressDAO = sqlSessionFactory.openSession().getMapper(IAddressDAO.class);
//// List<Address> addresses = addressDAO.getAll();
//// Address address = addressDAO.getById((long) 1);
//// System.out.println(address);
//// } catch (IOException e) {
//// e.printStackTrace();
//// }
//// }
//
//
//
// IAddressDAO addressDAO;
// //InputStream is = null;
//
// addressDAO =
// getSqlSessionFactory().openSession(true).getMapper(IAddressDAO.class);
// //List<Address> addresses = addressDAO.getAll();
// Address address1 = new Address();
// address1.setHouseNumber("gug");
// address1.setLeasingCompanyId(1);
// address1.setStreet("hgf");
// //Address address = addressDAO.getById(1);
// Address address = addressDAO.getById(1);
// addressDAO.add(address1);
// Address address2 = addressDAO.getById(6);
//
// lOGGER.info(address2);
// System.out.println(address);
// }
//
//
//
// public static SqlSessionFactory getSqlSessionFactory() {
// String resource = "mybatis.xml";
// InputStream inputStream = null;
// try {
// inputStream = Resources.getResourceAsStream(resource);
// } catch (IOException e) {
// lOGGER.error(e.getMessage());
// }
// SqlSessionFactory sqlSessionFactory = new
// SqlSessionFactoryBuilder().build(inputStream);
// return sqlSessionFactory;
// }
//
// }
