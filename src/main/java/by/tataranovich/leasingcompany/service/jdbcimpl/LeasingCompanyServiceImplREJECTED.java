package by.tataranovich.leasingcompany.service.jdbcimpl;

import java.util.List;

import by.tataranovich.leasingcompany.dao.jdbcimpl.JDBCAddressDAO;
import by.tataranovich.leasingcompany.dao.jdbcimpl.JDBCLeasingCompanyDAO;
import by.tataranovich.leasingcompany.model.LeasingCompany;
import by.tataranovich.leasingcompany.service.ILeasingCompanyService;

public class LeasingCompanyServiceImplREJECTED extends AbstractService<LeasingCompany, JDBCLeasingCompanyDAO>
	implements ILeasingCompanyService {

    private JDBCAddressDAO addressDAO;
    private ContractServiceImpl contractServiceImpl;
    private ClientServiceImpl clientServiceImpl;

    public LeasingCompanyServiceImplREJECTED(JDBCLeasingCompanyDAO dao) {
	super(new JDBCLeasingCompanyDAO());
	this.addressDAO = new JDBCAddressDAO();
	this.contractServiceImpl = new ContractServiceImpl();
	this.clientServiceImpl = new ClientServiceImpl();

    }

    public List<LeasingCompany> getAll() {
	List<LeasingCompany> leasingCompanyList = dao.getAll();
	leasingCompanyList.stream()
		.forEach((m) -> m.setAddresses(addressDAO.getAddressesByLeasingCompanyId(m.getId())));
	leasingCompanyList.stream()
		.forEach((m) -> m.setContracts(contractServiceImpl.getContractsByLeasingCompanyId(m.getId())));
	leasingCompanyList.stream()
		.forEach((m) -> m.setClients(clientServiceImpl.getClientsByLeasingCompanyId(m.getId())));
	return leasingCompanyList;
    }

    @Override
    public LeasingCompany getById(Long id) {
	return null;
    }

    @Override
    public void update(LeasingCompany entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void add(LeasingCompany entity) {

    }

}
