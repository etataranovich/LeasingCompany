package by.tataranovich.leasingcompany.services;


import java.util.List;

import by.tataranovich.leasingcompany.dao.jdbc.JDBCAddressDAO;
import by.tataranovich.leasingcompany.dao.jdbc.JDBCLeasingCompanyDAO;
import by.tataranovich.leasingcompany.model.LeasingCompany;

public class LeasingCompanyServiceImpl extends AbstractService<LeasingCompany, JDBCLeasingCompanyDAO> implements ILeasingCompanyService {
    
    
    private  JDBCAddressDAO addressDAO;
    private  ContractServiceImpl contractServiceImpl;
    private  ClientServiceImpl  clientServiceImpl;
    

    
    public LeasingCompanyServiceImpl(JDBCLeasingCompanyDAO dao) {
	super(new JDBCLeasingCompanyDAO());
	this.addressDAO = new JDBCAddressDAO();
	this.contractServiceImpl = new ContractServiceImpl();
	this.clientServiceImpl = new ClientServiceImpl();
	
	
    }
    

    public List<LeasingCompany> getAll() {
	List<LeasingCompany> leasingCompanyList = dao.getAll();
	leasingCompanyList.stream().forEach((m) -> m.setAddresses(addressDAO.getAddressesByLeasingCompanyId(m.getId())));
	leasingCompanyList.stream().forEach((m) -> m.setContracts(contractServiceImpl.getContractsByLeasingCompanyId(m.getId())));
	leasingCompanyList.stream().forEach((m) -> m.setClients(clientServiceImpl.getClientsByLeasingCompanyId(m.getId())));
	return leasingCompanyList;
    }

    @Override
    public LeasingCompany getById(Integer id) {
	return null;
    }

    @Override
    public void update(LeasingCompany entity) {

	
    }

    @Override
    public void delete(Integer id) {

	
    }


}


