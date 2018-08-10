package by.tataranovich.leasingcompany.service.impl;

import java.util.List;

import by.tataranovich.leasingcompany.dao.impl.JDBCClientDAO;
import by.tataranovich.leasingcompany.model.Client;
import by.tataranovich.leasingcompany.service.IClientService;

public class ClientServiceImpl extends AbstractService<Client, JDBCClientDAO> implements IClientService {

    public ClientServiceImpl() {
	super(new JDBCClientDAO());
    }

    @Override
    public Client getById(Long id) {
	return dao.getById(id);
    }
///!!!!!!!!!!!!!!!!
    public void addClientToLeasingCompany(Client client, Long idLeasingCompany) {
	dao.add(client, idLeasingCompany);
    }

    @Override
    public void update(Client client) {
	dao.update(client);
    }

    @Override
    public void delete(Long id) {
	dao.delete(id);
    }

    @Override
    public List<Client> getClientsByLeasingCompanyId(Long idLeasingCompany) {
	return dao.getClientsbyLeasingCompanyId(idLeasingCompany);
    }

    @Override
    public Client getClientByContractId(Long idContract) {
	return dao.getClientByContractId(idContract);
    }

    @Override
    public void add(Client entity) {

    }

    @Override
    public List<Client> getAll() {
	return null;
    }

}
