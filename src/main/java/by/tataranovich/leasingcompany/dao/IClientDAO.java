package by.tataranovich.leasingcompany.dao;

import java.util.List;

import by.tataranovich.leasingcompany.model.Client;

public interface IClientDAO extends IDAO<Client> {

    Client getClientByContractId(Long id);
    
    List<Client> getClientsbyLeasingCompanyId(Long idLeasingCompany);
    
    
}
