package by.tataranovich.leasingcompany.service;

import by.tataranovich.leasingcompany.model.LeasingProgramm;

public interface ILeasingProgrammService extends DefaultService<LeasingProgramm> {
    LeasingProgramm getLeasingProgrammByContractId(Long idLeasingProgramm);
}
