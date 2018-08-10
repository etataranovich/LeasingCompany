package by.tataranovich.leasingcompany.service;

import java.util.List;

import by.tataranovich.leasingcompany.model.Client;

public interface IClientService extends DefaultService<Client>{
    List <Client> getClientsByLeasingCompanyId(Long idLeasingCompany);
    Client getClientByContractId(Long idContract);
    
}
