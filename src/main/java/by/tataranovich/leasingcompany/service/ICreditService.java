package by.tataranovich.leasingcompany.service;


import by.tataranovich.leasingcompany.model.Credit;

public interface ICreditService extends DefaultService<Credit>{
    Credit getCreditByContractId(Long idContract);
}
