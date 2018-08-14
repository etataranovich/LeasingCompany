package by.tataranovich.leasingcompany.service.mybatisimpl;

import java.util.List;

import by.tataranovich.leasingcompany.dao.IClientDAO;
import by.tataranovich.leasingcompany.model.Client;
import by.tataranovich.leasingcompany.mybatis.DatabaseInstance;
import by.tataranovich.leasingcompany.service.IClientService;

public class ClientServiceImpl implements IClientService {

    private IClientDAO clientDAO;

    public ClientServiceImpl() {
	this.clientDAO = DatabaseInstance.getInstance().getFactory().openSession().getMapper(IClientDAO.class);

    }

    @Override
    public void add(Client entity) {
	clientDAO.add(entity);
    }

    @Override
    public Client getById(Long id) {
	return clientDAO.getById(id);
    }

    @Override
    public void update(Client entity) {
	clientDAO.update(entity);

    }

    @Override
    public void delete(Long id) {
	clientDAO.delete(id);

    }

    @Override
    public List<Client> getAll() {
	return clientDAO.getAll();
    }

    @Override
    public List<Client> getClientsByLeasingCompanyId(Long idLeasingCompany) {
	return clientDAO.getClientsbyLeasingCompanyId(idLeasingCompany);
    }

    @Override
    public Client getClientByContractId(Long idContract) {
	return clientDAO.getClientByContractId(idContract);
    }

}
