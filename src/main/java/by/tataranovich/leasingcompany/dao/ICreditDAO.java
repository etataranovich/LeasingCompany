package by.tataranovich.leasingcompany.dao;

import by.tataranovich.leasingcompany.model.Credit;

public interface ICreditDAO extends IDAO<Credit>{
    public Credit getCreditByContractId(Long id);
}
