package by.tataranovich.leasingcompany.service;

import java.util.List;

import by.tataranovich.leasingcompany.model.LeasingCompany;

public interface ILeasingCompanyService extends DefaultService<LeasingCompany>{
    List<LeasingCompany> getAll();
}
