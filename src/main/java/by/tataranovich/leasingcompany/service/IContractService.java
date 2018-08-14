package by.tataranovich.leasingcompany.service;

import java.util.List;

import by.tataranovich.leasingcompany.model.Contract;

public interface IContractService extends DefaultService<Contract> {
    List<Contract> getAllByLeasingCompanyId(Long idLeasingCompany);
}
