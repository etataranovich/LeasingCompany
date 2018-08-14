package by.tataranovich.leasingcompany.service.mybatisimpl;

import java.util.List;

import by.tataranovich.leasingcompany.dao.IContractDAO;
import by.tataranovich.leasingcompany.model.Contract;
import by.tataranovich.leasingcompany.mybatis.DatabaseInstance;
import by.tataranovich.leasingcompany.service.IContractService;

public class ContractServiceImpl implements IContractService {

    private IContractDAO contractDAO;

    public ContractServiceImpl() {
	this.contractDAO = DatabaseInstance.getInstance().getFactory().openSession().getMapper(IContractDAO.class);

    }

    @Override
    public void add(Contract entity) {
	contractDAO.add(entity);
    }

    @Override
    public Contract getById(Long id) {
	return contractDAO.getById(id);
    }

    @Override
    public void update(Contract entity) {
	contractDAO.update(entity);

    }

    @Override
    public void delete(Long id) {
	contractDAO.delete(id);

    }

    @Override
    public List<Contract> getAll() {
	return contractDAO.getAll();
    }

    @Override
    public List<Contract> getContractsByLeasingCompanyId(Long idLeasingCompany) {
	return contractDAO.getContractsByIdLeasingCompany(idLeasingCompany);
    }

}
