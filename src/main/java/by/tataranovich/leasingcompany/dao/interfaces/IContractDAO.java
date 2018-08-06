package by.tataranovich.leasingcompany.dao.interfaces;

import java.util.List;

import by.tataranovich.leasingcompany.model.Contract;

public interface IContractDAO extends DAO<Contract>{
    public List<Contract> getContractsByIdLeasingCompany(int id);
    public List<Contract> getContractsByIdClient(int id);
    

}
