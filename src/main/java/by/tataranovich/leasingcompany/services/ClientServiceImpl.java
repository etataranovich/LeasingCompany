package by.tataranovich.leasingcompany.services;

import java.util.List;

import by.tataranovich.leasingcompany.dao.jdbc.JDBCClientDAO;
import by.tataranovich.leasingcompany.model.Client;

public class ClientServiceImpl extends AbstractService<Client, JDBCClientDAO> implements IClientService {

    public ClientServiceImpl() {
	super(new JDBCClientDAO());
    }

    @Override
    public Client getById(Integer id) {
	return dao.getById(id);
    }

    public void addClientToLeasingCompany(Client client, Integer idLeasingCompany) {
	dao.add(client, idLeasingCompany);
    }

    @Override
    public void update(Client client) {
	dao.update(client);
    }

    @Override
    public void delete(Integer id) {
	dao.delete(id);
    }
    
    @Override
    public List<Client> getClientsByLeasingCompanyId(Integer idLeasingCompany) {
	return dao.getAllbyLeasingCompanyId(idLeasingCompany);
    }

    @Override
    public Client getClientByContractId(Integer idContract) {
	return dao.getClientByContractId(idContract);
    }

}
