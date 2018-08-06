package by.tataranovich.leasingcompany.services;

import java.util.List;

import by.tataranovich.leasingcompany.model.Contract;

public interface IContractService extends DefaultService<Contract> {
    List<Contract> getAllByLeasingCompanyId(int idLeasingCompany);
}
