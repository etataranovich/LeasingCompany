package by.tataranovich.leasingcompany.dao.interfaces;

import by.tataranovich.leasingcompany.model.Credit;

public interface ICreditDAO extends DAO<Credit>{
    public Credit getCreditByContractId(Integer id);
}
