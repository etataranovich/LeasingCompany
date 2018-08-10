package by.tataranovich.leasingcompany.connect;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.tataranovich.leasingcompany.dao.LeasingCompanyDAO;
import by.tataranovich.leasingcompany.dao.impl.JDBCAddressDAO;
import by.tataranovich.leasingcompany.dao.impl.JDBCCarDAO;
import by.tataranovich.leasingcompany.dao.impl.JDBCClientDAO;
import by.tataranovich.leasingcompany.dao.impl.JDBCLeasingCompanyDAO;
import by.tataranovich.leasingcompany.model.Address;
import by.tataranovich.leasingcompany.model.Car;
import by.tataranovich.leasingcompany.model.CarModel;
import by.tataranovich.leasingcompany.model.Client;
import by.tataranovich.leasingcompany.model.Contract;
import by.tataranovich.leasingcompany.model.Credit;
import by.tataranovich.leasingcompany.model.LeasingCompany;
import by.tataranovich.leasingcompany.model.LeasingProgramm;
import by.tataranovich.leasingcompany.service.impl.CarServiceImpl;
import by.tataranovich.leasingcompany.service.impl.ContractServiceImpl;
import by.tataranovich.leasingcompany.service.impl.LeasingCompanyServiceImpl;
import by.tataranovich.leasingcompany.service.impl.LeasingCompanyServiceImpl1;


public class RunnerDao {
    private static final Logger lOGGER = LogManager.getLogger(RunnerDao.class);
    //static CarService carService = new CarService();
    //static ContractService contractService = new ContractService();
    //static ClientService clientService = new ClientService();
    
    public static void main(String[] args) throws InterruptedException {
	
	//CarServiceImpl carServiceImpl = new CarServiceImpl(); 
	
	LeasingCompanyServiceImpl leasingCompanyServiceImpl = new LeasingCompanyServiceImpl();
	LeasingCompanyDAO leasingCompanyDAO = new JDBCLeasingCompanyDAO();
	JDBCAddressDAO JDBCAaddressDAO = new JDBCAddressDAO();
	System.out.println(JDBCAaddressDAO.getById((long) 1));
	System.out.println("ff");

	//JDBCLeasingCompanyDAO leasingCompanyDAO = new JDBCLeasingCompanyDAO();
	//System.out.println(leasingCompanyDAO.getAll());
	
	
///*	    private Date date;
//	    private Client client;
//	    private Car car;
//	    private LeasingProgramm leasingProgramm;
//	    private Credit credit;
//	    private LeasingCompany leasingCompany;*/
//	Car
//	Contract contract = new Contract();
//	Client client = new Client();
//	client.setId(3);
//	contract.setDate(new Date());
//	contract.setClient(clientService.getClient(client));
//	
//	
        //JDBCAddressDAO jdbcAddressDao = new JDBCAddressDAO();
	//JDBCCarDAO jdbcCarDao = new JDBCCarDAO();
	//lOGGER.info(jdbcAddressDao.getById(1).toString());
	
	Address address = new Address();
	address.setStreet("Dzerginskogo");
	address.setHouseNumber("12");
	
	
	//System.out.println(carServiceImpl.getAll());
	//lOGGER.info(jdbcAddressDao.getAddressByLeasingCompanyId(1));
	//Car car = new Car (1);
	//ContractServiceImpl ContractServiceImpl = new ContractServiceImpl();
	//System.out.println(carServiceImpl.getAll());
	//System.out.println(carServiceImpl.getAll());
	
	//System.out.println(ContractServiceImpl.getAll(1));
	//LeasingCompany leasingCompany = new LeasingCompany(1);
	//address.setLeasingCompany(leasingCompany);
	
	//jdbcAddressDao.add(address);
	
	
	//lOGGER.info(jdbcAddressDao.getById().toString());
	//lOGGER.info(jdbcAddressDao.getById(1).toString());
	//List <Address> addresses = jdbcAddressDao.getAddressByLeasingCompanyId(1);
	//for (Address address1: addresses) lOGGER.info (address1.toString());
	
	
         //lOGGER.info (jdbcAddressDao.getAddressByLeasingCompanyId(1));
	
        // lOGGER.info (jdbcCarDao.getCarByCarProviderId(2));
	
	//lOGGER.info(jdbcAddressDao.getAddressByLeasingCompanyId(1));
	
	//address.setLeasingCompany(leasingCompany.setId());

	


}
}