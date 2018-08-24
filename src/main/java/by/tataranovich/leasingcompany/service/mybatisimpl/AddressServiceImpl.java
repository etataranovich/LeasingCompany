package by.tataranovich.leasingcompany.service.mybatisimpl;

import java.util.List;


import by.tataranovich.leasingcompany.model.Address;
import by.tataranovich.leasingcompany.mybatis.DatabaseInstance;
import by.tataranovich.leasingcompany.service.IAddressService;

public class AddressServiceImpl implements IAddressService {

    private IAddressService addressService;

    public AddressServiceImpl() {
	this.addressService = DatabaseInstance.getInstance().getFactory().openSession(true)
		.getMapper(IAddressService.class);

    }

    @Override
    public void add(Address entity) {
	addressService.add(entity);

    }

    @Override
    public Address getById(Long id) {
	return addressService.getById(id);
    }

    @Override
    public void update(Address entity) {
	addressService.update(entity);

    }

    @Override
    public void delete(Long id) {
	addressService.delete(id);
    }

    @Override
    public List<Address> getAll() {
	return addressService.getAll();
    }

    @Override
    public List<Address> getAddressesByLeasingCompanyId(Long idLeasingCompany) {
	return addressService.getAddressesByLeasingCompanyId(idLeasingCompany);
    }

}

// MAYBE create In ABSTRACT CLASS????
// public T getMapper(T clas, boolean autoCommit) {
// return DatabaseInstance.getInstance().getFactory().openSession(autoCommit)
// .getMapper(clas) ;
// }

// private IAddressDAO addressDAO =
// DatabaseInstance.getInstance().getFactory().openSession()
// .getMapper(IAddressDAO.class);
