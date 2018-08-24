package by.tataranovich.leasingcompany.service.mybatisimpl;

import java.util.List;

import by.tataranovich.leasingcompany.model.Client;
import by.tataranovich.leasingcompany.mybatis.DatabaseInstance;
import by.tataranovich.leasingcompany.service.IClientService;

public class ClientServiceImpl implements IClientService {

    private IClientService clientService;

    public ClientServiceImpl() {
	this.clientService = DatabaseInstance.getInstance().getFactory().openSession(true).getMapper(IClientService.class);

    }

    @Override
    public void add(Client entity) {
	clientService.add(entity);
    }

    @Override
    public Client getById(Long id) {
	return clientService.getById(id);
    }

    @Override
    public void update(Client entity) {
	clientService.update(entity);

    }

    @Override
    public void delete(Long id) {
	clientService.delete(id);

    }

    @Override
    public List<Client> getAll() {
	return clientService.getAll();
    }

    @Override
    public List<Client> getClientsByLeasingCompanyId(Long idLeasingCompany) {
	return clientService.getClientsByLeasingCompanyId(idLeasingCompany);
    }

    @Override
    public Client getClientByContractId(Long idContract) {
	return clientService.getClientByContractId(idContract);
    }

}
