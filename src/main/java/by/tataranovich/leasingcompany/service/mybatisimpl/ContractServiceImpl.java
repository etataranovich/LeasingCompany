package by.tataranovich.leasingcompany.service.mybatisimpl;

import java.util.List;

import by.tataranovich.leasingcompany.model.Contract;
import by.tataranovich.leasingcompany.mybatis.DatabaseInstance;
import by.tataranovich.leasingcompany.service.IContractService;

public class ContractServiceImpl implements IContractService {

    private IContractService contractService;

    public ContractServiceImpl() {
	this.contractService = DatabaseInstance.getInstance().getFactory().openSession(true)
		.getMapper(IContractService.class);

    }

    @Override
    public void add(Contract entity) {
	contractService.add(entity);
    }

    @Override
    public Contract getById(Long id) {
	return contractService.getById(id);
    }

    @Override
    public void update(Contract entity) {
	contractService.update(entity);

    }

    @Override
    public void delete(Long id) {
	contractService.delete(id);

    }

    @Override
    public List<Contract> getAll() {
	return contractService.getAll();
    }

    @Override
    public List<Contract> getContractsByLeasingCompanyId(Long idLeasingCompany) {
	return contractService.getContractsByLeasingCompanyId(idLeasingCompany);
    }

}
