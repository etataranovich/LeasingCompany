package by.tataranovich.leasingcompany.service.impl;

import java.util.List;

import by.tataranovich.leasingcompany.dao.impl.JDBCAddressDAO;
import by.tataranovich.leasingcompany.dao.impl.JDBCCarDAO;
import by.tataranovich.leasingcompany.dao.impl.JDBCCarProviderDAO;
import by.tataranovich.leasingcompany.dao.impl.JDBCClientDAO;
import by.tataranovich.leasingcompany.dao.impl.JDBCContractDAO;
import by.tataranovich.leasingcompany.dao.impl.JDBCCreditDAO;
import by.tataranovich.leasingcompany.dao.impl.JDBCLeasingCompanyDAO;
import by.tataranovich.leasingcompany.dao.impl.JDBCLeasingProgrammDAO;
import by.tataranovich.leasingcompany.model.Car;
import by.tataranovich.leasingcompany.model.Contract;
import by.tataranovich.leasingcompany.model.LeasingCompany;


public class LeasingCompanyServiceImpl {

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

    public LeasingCompanyServiceImpl() {
	super();
	this.leasingCompanyDAO = new JDBCLeasingCompanyDAO();
	this.addressDAO = new JDBCAddressDAO();
	this.contractDAO = new JDBCContractDAO();
	this.clientDAO = new JDBCClientDAO();
	this.carDAO = new JDBCCarDAO();
	this.carProviderDAO = new JDBCCarProviderDAO();
	this.leasingProgrammDAO = new JDBCLeasingProgrammDAO();
	this.creditDAO = new JDBCCreditDAO();
    }
    

    public Car getCarByContractId(Long idContract) {
	Car car = carDAO.getCarByContractId(idContract);
	car.setCarProvider(carProviderDAO.getCarProviderByCarId(car.getId()));
	return car;
    }
    
    public List<Contract> getContractsByLeasingCompanyId(Long idLeasingCompany) {
	List<Contract> contractList = contractDAO.getContractsByIdLeasingCompany(idLeasingCompany);
	contractList.stream().forEach((m) -> m.setCar(getCarByContractId(m.getId())));
	contractList.stream().forEach((m) -> m.setClient(clientDAO.getClientByContractId(m.getId())));
	contractList.stream().forEach((m) -> m.setLeasingProgramm(leasingProgrammDAO.getLeasingProgrammByContractId(m.getId())));
	contractList.stream().forEach((m) -> m.setCredit(creditDAO.getCreditByContractId(m.getId())));
	return contractList;
    }

    public List<LeasingCompany> getAll() {
	List<LeasingCompany> leasingCompanyList = leasingCompanyDAO.getAll();
	leasingCompanyList.stream().forEach((m) -> m.setAddresses(addressDAO.getAddressesByLeasingCompanyId(m.getId())));
	leasingCompanyList.stream().forEach((m) -> m.setContracts(getContractsByLeasingCompanyId(m.getId())));
	leasingCompanyList.stream().forEach((m) -> m.setClients(clientDAO.getClientsbyLeasingCompanyId(m.getId())));
	return leasingCompanyList;
    }
}
