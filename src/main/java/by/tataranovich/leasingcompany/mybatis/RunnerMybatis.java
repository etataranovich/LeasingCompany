package by.tataranovich.leasingcompany.mybatis;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.tataranovich.leasingcompany.dao.IAddressDAO;
import by.tataranovich.leasingcompany.dao.ICarDAO;
import by.tataranovich.leasingcompany.dao.ICarProviderDAO;
import by.tataranovich.leasingcompany.model.Address;
import by.tataranovich.leasingcompany.model.Car;
import by.tataranovich.leasingcompany.model.CarModel;
import by.tataranovich.leasingcompany.model.CarProvider;

public class RunnerMybatis {
    private static final Logger LOGGER = LogManager.getLogger(RunnerMybatis.class);

    public static void main(String[] args) {

	IAddressDAO addressDAO = DatabaseInstance.getInstance().getFactory().openSession(true)
		.getMapper(IAddressDAO.class);
	ICarDAO carDAO = DatabaseInstance.getInstance().getFactory().openSession().getMapper(ICarDAO.class);
	ICarProviderDAO carProviderDAO = DatabaseInstance.getInstance().getFactory().openSession()
		.getMapper(ICarProviderDAO.class);
	Address address1 = new Address();
	address1.setHouseNumber("gug");
	address1.setLeasingCompanyId(1);
	address1.setStreet("hgf");
	//CarProvider carProvider = carProviderDAO.getById(1);
	//LOGGER.info(carProvider);

	//Car car1 = new Car();
	//car1.setCarModel(CarModel.AUDI);
	//car1.setPrice(456);
	//car1.setCarProvider(carProvider);
	//carDAO.add(car1);
	
	// // addressDAO.add(address1);
	//
	Address address = addressDAO.getById((long) 2);
	
	LOGGER.info(address);
	//carDAO.getById(id)
	
	Car car = carDAO.getById((long) 1);
	LOGGER.info(car);
	//
	// carDAO.getById(1);
	// LOGGER.info(carDAO.getById(1));

    }

}













//package by.tataranovich.leasingcompany.mybatis;
//package by.tataranovich.leasingcompany.mybatis;
//
//import java.io.IOException;
//import java.io.InputStream;
//
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import by.tataranovich.leasingcompany.dao.IAddressDAO;
//import by.tataranovich.leasingcompany.model.Address;
//
//public class RMB {
//
//  private static final Logger lOGGER = LogManager.getLogger(RunnerMyBatis.class);
//
//  public static void main(String[] args) {
//
//	// @Override
//	// public void add(Address address) {
//	// SqlSession session = null;
//	// try {
//	// session = getSqlSessionFactory().openSession();
//	// session.insert("com.roxoft.buildingcompany.main.dao.mybatis.MyBatisAddressDao.add",
//	// address);
//	// session.commit();
//	// } finally {
//	// close(session);
//	// }
//	// }
//	//
//
////	SqlSessionFactory sqlSessionFactory;
////	IAddressDAO addressDAO;
////	InputStream is = null;
////
////	// Reader reader = null;
////	try {
////	    // is = Resources.getResourceAsStream("src\\main\\resources\\mybatis2.xml");
////	    is = Resources.getResourceAsStream(getClass().getResource("src\\main\\resources\\mybatis.xml"));
////
////	    sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
////	    addressDAO = sqlSessionFactory.openSession().getMapper(IAddressDAO.class);
////	    List<Address> addresses = addressDAO.getAll();
////	    Address address = addressDAO.getById((long) 1);
////	    System.out.println(address);
////	} catch (IOException e) {
////	    e.printStackTrace();
////	}
////  }
//	
//	
//	
//	IAddressDAO addressDAO;
//	//InputStream is = null;
//
//	addressDAO =  getSqlSessionFactory().openSession(true).getMapper(IAddressDAO.class);
//	//List<Address> addresses = addressDAO.getAll();
//   Address address1 = new Address();
//   address1.setHouseNumber("gug");
//   address1.setLeasingCompanyId(1);
//   address1.setStreet("hgf");
//	//Address address = addressDAO.getById(1);
//	Address address = addressDAO.getById(1);
//	 addressDAO.add(address1);
//	Address address2 = addressDAO.getById(6);
//	
//	 lOGGER.info(address2);
//	System.out.println(address);
//  }
//	
//	
//
//  public static SqlSessionFactory getSqlSessionFactory() {
//	String resource = "mybatis.xml";
//	InputStream inputStream = null;
//	try {
//	    inputStream = Resources.getResourceAsStream(resource);
//	} catch (IOException e) {
//	    lOGGER.error(e.getMessage());
//	}
//	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//	return sqlSessionFactory;
//  }
//
//}
