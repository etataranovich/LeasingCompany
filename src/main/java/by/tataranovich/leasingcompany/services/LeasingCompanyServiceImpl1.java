package by.tataranovich.leasingcompany.services;

import java.util.Date;
import java.util.List;

import by.tataranovich.leasingcompany.dao.jdbc.JDBCAddressDAO;
import by.tataranovich.leasingcompany.dao.jdbc.JDBCCarDAO;
import by.tataranovich.leasingcompany.dao.jdbc.JDBCCarProviderDAO;
import by.tataranovich.leasingcompany.dao.jdbc.JDBCClientDAO;
import by.tataranovich.leasingcompany.dao.jdbc.JDBCContractDAO;
import by.tataranovich.leasingcompany.dao.jdbc.JDBCCreditDAO;
import by.tataranovich.leasingcompany.dao.jdbc.JDBCLeasingCompanyDAO;
import by.tataranovich.leasingcompany.dao.jdbc.JDBCLeasingProgrammDAO;
import by.tataranovich.leasingcompany.model.Car;
import by.tataranovich.leasingcompany.model.Client;
import by.tataranovich.leasingcompany.model.Contract;
import by.tataranovich.leasingcompany.model.Credit;
import by.tataranovich.leasingcompany.model.LeasingCompany;
import by.tataranovich.leasingcompany.model.LeasingProgramm;

public class LeasingCompanyServiceImpl1 {

    // private Date date;
    // private Client client;
    // private Car car;
    // private LeasingProgramm leasingProgramm;
    // private Credit credit;
    private JDBCLeasingCompanyDAO leasingCompanyDAO;
    
    private JDBCAddressDAO addressDAO;
    private JDBCContractDAO contractDAO;
    private JDBCClientDAO clientDAO;
    // for contract
    private JDBCCarDAO carDAO;
    private JDBCCarProviderDAO carProviderDAO;
    private JDBCLeasingProgrammDAO leasingProgrammDAO;
    private JDBCCreditDAO creditDAO;

    public LeasingCompanyServiceImpl1(JDBCAddressDAO addressDAO, JDBCContractDAO contractDAO, JDBCClientDAO clientDAO,
	    JDBCCarDAO carDAO, JDBCCarProviderDAO carProviderDAO, JDBCLeasingProgrammDAO leasingProgrammDAO,
	    JDBCCreditDAO creditDAO) {
	super();
	this.addressDAO = addressDAO;
	this.contractDAO = contractDAO;
	this.clientDAO = clientDAO;
	this.carDAO = carDAO;
	this.carProviderDAO = carProviderDAO;
	this.leasingProgrammDAO = leasingProgrammDAO;
	this.creditDAO = creditDAO;
    }
    

    
    public List<Client> getClientsByLeasingCompanyId(Integer idLeasingCompany) {
 	return clientDAO.getAllbyLeasingCompanyId(idLeasingCompany);
     }
    
    public List<Car> getCars() {
 	List<Car> carList = carDAO.getAll();
 	carList.stream().forEach((m) -> m.setCarProvider(carProviderDAO.getByCarId(m.getId())));
 	return carList;
     }
    
    public List<Contract> getContractsByLeasingCompanyId(int idLeasingCompany) {
	List<Contract> contractList = contractDAO.getContractsByIdLeasingCompany(idLeasingCompany);
	contractList.stream().forEach((m) -> m.setCar(carServiceImpl.getCarByContractId(m.getId())));
	contractList.stream().forEach((m) -> m.setClient(clientDAO.getClientByContractId(m.getId())));
	contractList.stream().forEach((m) -> m.setLeasingProgramm(leasingProgrammDAO.getLeasingProgrammByContractId(m.getId())));
	contractList.stream().forEach((m) -> m.setCredit(creditDAO.getCreditByContractId(m.getId())));
	return contractList;
    }

    public List<LeasingCompany> getAll() {
	List<LeasingCompany> leasingCompanyList = leasingCompanyDAO.getAll();
	leasingCompanyList.stream().forEach((m) -> m.setAddresses(addressDAO.getAddressesByLeasingCompanyId(m.getId())));
	leasingCompanyList.stream().forEach((m) -> m.setContracts(getContractsByLeasingCompanyId(m.getId())));
	leasingCompanyList.stream().forEach((m) -> m.setClients(clientServiceImpl.getClientsByLeasingCompanyId(m.getId())));
	return leasingCompanyList;
    }
}
