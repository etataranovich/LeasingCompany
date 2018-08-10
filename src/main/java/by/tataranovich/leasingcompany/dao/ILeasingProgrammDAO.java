package by.tataranovich.leasingcompany.dao;

import by.tataranovich.leasingcompany.model.LeasingProgramm;

public interface ILeasingProgrammDAO extends IDAO<LeasingProgramm> {
    
  LeasingProgramm getLeasingProgrammByContractId(Long id);

}

