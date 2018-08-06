package by.tataranovich.leasingcompany.services;

import java.util.List;

import by.tataranovich.leasingcompany.model.Client;

public interface IClientService extends DefaultService<Client>{
    List <Client> getClientsByLeasingCompanyId(Integer idLeasingCompany);
    Client getClientByContractId(Integer idContract);
    
}
