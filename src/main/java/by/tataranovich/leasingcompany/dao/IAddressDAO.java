package by.tataranovich.leasingcompany.dao;

import java.util.List;

import by.tataranovich.leasingcompany.model.Address;

public interface IAddressDAO extends IDAO<Address> {
    
    public List<Address> getAddressesByLeasingCompanyId(Long id);

    
}
