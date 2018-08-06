package by.tataranovich.leasingcompany.dao.interfaces;

import by.tataranovich.leasingcompany.model.LeasingProgramm;

public interface ILeasingProgrammDAO extends DAO<LeasingProgramm> {
    
  LeasingProgramm getLeasingProgrammByContractId(Integer id);

}

