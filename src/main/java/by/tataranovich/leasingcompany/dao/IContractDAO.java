package by.tataranovich.leasingcompany.dao;

import java.util.List;

import by.tataranovich.leasingcompany.model.Contract;

public interface IContractDAO extends IDAO<Contract>{
    public List<Contract> getContractsByIdLeasingCompany(Long id);
    public List<Contract> getContractsByIdClient(Long id);
    

}
