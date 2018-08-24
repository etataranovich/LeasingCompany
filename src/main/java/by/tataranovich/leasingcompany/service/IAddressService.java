package by.tataranovich.leasingcompany.service;

import java.util.List;

import by.tataranovich.leasingcompany.model.Address;

public interface IAddressService extends DefaultService<Address> {
   List<Address> getAddressesByLeasingCompanyId(Long idLeasingCompany);

}
