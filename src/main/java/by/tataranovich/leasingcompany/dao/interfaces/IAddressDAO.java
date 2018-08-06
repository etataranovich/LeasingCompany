package by.tataranovich.leasingcompany.dao.interfaces;

import java.util.List;

import by.tataranovich.leasingcompany.model.Address;

public interface IAddressDAO extends DAO<Address> {
    
    public List<Address> getAddressesByLeasingCompanyId(Integer id);

    
}
