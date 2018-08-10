package by.tataranovich.leasingcompany.service.impl;

import java.util.List;

import by.tataranovich.leasingcompany.dao.impl.JDBCContractDAO;
import by.tataranovich.leasingcompany.dao.impl.JDBCCreditDAO;
import by.tataranovich.leasingcompany.dao.impl.JDBCLeasingProgrammDAO;
import by.tataranovich.leasingcompany.model.Contract;
import by.tataranovich.leasingcompany.service.IContractService;

public class ContractServiceImpl extends AbstractService<Contract, JDBCContractDAO> implements IContractService {

    private ClientServiceImpl clientService;
    private CarServiceImpl carServiceImpl;
    private JDBCLeasingProgrammDAO leasingProgrammDAO;
    private JDBCCreditDAO creditDAO;

    public ContractServiceImpl() {
	super(new JDBCContractDAO());
	this.carServiceImpl = new CarServiceImpl();
	this.clientService = new ClientServiceImpl();
	this.leasingProgrammDAO = new JDBCLeasingProgrammDAO();
	this.creditDAO = new JDBCCreditDAO();

    }

    public void add(Contract contract, Long idLeasingCompany) {
	dao.add(contract);
	carServiceImpl.add(contract.getCar());
	clientService.addClientToLeasingCompany(contract.getClient(), idLeasingCompany);
	leasingProgrammDAO.add(contract.getLeasingProgramm());
	creditDAO.add(contract.getCredit());

    }

    public List<Contract> getContractsByLeasingCompanyId(Long idLeasingCompany) {
	List<Contract> contractList = dao.getContractsByIdLeasingCompany(idLeasingCompany);
	contractList.stream().forEach((m) -> m.setCar(carServiceImpl.getCarByContractId(m.getId())));
	contractList.stream().forEach((m) -> m.setClient(clientService.getClientByContractId(m.getId())));
	contractList.stream().forEach((m) -> m.setLeasingProgramm(leasingProgrammDAO.getLeasingProgrammByContractId(m.getId())));
	contractList.stream().forEach((m) -> m.setCredit(creditDAO.getCreditByContractId(m.getId())));
	return contractList;
    }

    @Override
    public Contract getById(Long id) {
	return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Contract entity) {

    }

    @Override
    public List<Contract> getAllByLeasingCompanyId(int idLeasingCompany) {
	return null;
    }

    @Override
    public void add(Contract entity) {
	
    }

    @Override
    public List<Contract> getAll() {
	return null;
    }
    
    

}
