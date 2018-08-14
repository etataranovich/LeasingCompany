package by.tataranovich.leasingcompany.service.mybatisimpl;

import java.util.List;

import by.tataranovich.leasingcompany.dao.IAddressDAO;
import by.tataranovich.leasingcompany.model.Address;
import by.tataranovich.leasingcompany.mybatis.DatabaseInstance;
import by.tataranovich.leasingcompany.service.IAddressService;

public class AddressServiceImpl implements IAddressService {

    // MAYBE create In ABSTRACT CLASS????
    // public T getMapper(T clas, boolean autoCommit) {
    // return DatabaseInstance.getInstance().getFactory().openSession(autoCommit)
    // .getMapper(clas) ;
    // }

    // private IAddressDAO addressDAO =
    // DatabaseInstance.getInstance().getFactory().openSession()
    // .getMapper(IAddressDAO.class);

    private IAddressDAO addressDAO;

    public AddressServiceImpl() {
	this.addressDAO = DatabaseInstance.getInstance().getFactory().openSession().getMapper(IAddressDAO.class);

    }

    @Override
    public void add(Address entity) {
	addressDAO.add(entity);

    }

    @Override
    public Address getById(Long id) {
	return addressDAO.getById(id);
    }

    @Override
    public void update(Address entity) {
	addressDAO.update(entity);

    }

    @Override
    public void delete(Long id) {
	addressDAO.delete(id);
    }

    @Override
    public List<Address> getAll() {
	return addressDAO.getAll();
    }

    @Override
    public List<Address> getAddressesByLeasingCompanyId(Long idLeasingCompany) {
	return addressDAO.getAddressesByLeasingCompanyId(idLeasingCompany);
    }

}
