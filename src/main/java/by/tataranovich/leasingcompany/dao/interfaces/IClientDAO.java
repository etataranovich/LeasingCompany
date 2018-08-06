package by.tataranovich.leasingcompany.dao.interfaces;

import by.tataranovich.leasingcompany.model.Client;

public interface IClientDAO extends DAO<Client> {

    Client getClientByContractId(Integer id);
    
    
}
