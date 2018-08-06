package by.tataranovich.leasingcompany.services;

import java.util.List;

import by.tataranovich.leasingcompany.dao.jdbc.JDBCContractDAO;
import by.tataranovich.leasingcompany.dao.jdbc.JDBCCreditDAO;
import by.tataranovich.leasingcompany.dao.jdbc.JDBCLeasingProgrammDAO;

import by.tataranovich.leasingcompany.model.Contract;

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

    public void add(Contract contract, int idLeasingCompany) {
	dao.add(contract);
	carServiceImpl.add(contract.getCar());
	clientService.addClientToLeasingCompany(contract.getClient(), idLeasingCompany);
	leasingProgrammDAO.add(contract.getLeasingProgramm());
	creditDAO.add(contract.getCredit());

    }

    public List<Contract> getContractsByLeasingCompanyId(int idLeasingCompany) {
	List<Contract> contractList = dao.getContractsByIdLeasingCompany(idLeasingCompany);
	contractList.stream().forEach((m) -> m.setCar(carServiceImpl.getCarByContractId(m.getId())));
	contractList.stream().forEach((m) -> m.setClient(clientService.getClientByContractId(m.getId())));
	contractList.stream().forEach((m) -> m.setLeasingProgramm(leasingProgrammDAO.getLeasingProgrammByContractId(m.getId())));
	contractList.stream().forEach((m) -> m.setCredit(creditDAO.getCreditByContractId(m.getId())));
	return contractList;
    }

    @Override
    public Contract getById(Integer id) {
	return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(Contract entity) {

    }

    @Override
    public List<Contract> getAllByLeasingCompanyId(int idLeasingCompany) {
	return null;
    }

}
