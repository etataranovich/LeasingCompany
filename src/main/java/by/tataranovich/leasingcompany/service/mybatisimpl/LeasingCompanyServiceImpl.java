package by.tataranovich.leasingcompany.service.mybatisimpl;

import java.util.List;

import by.tataranovich.leasingcompany.model.LeasingCompany;
import by.tataranovich.leasingcompany.mybatis.DatabaseInstance;
import by.tataranovich.leasingcompany.service.ILeasingCompanyService;

public class LeasingCompanyServiceImpl implements ILeasingCompanyService {

    private ILeasingCompanyService leasingCompanyService;

    public LeasingCompanyServiceImpl() {
	this.leasingCompanyService = DatabaseInstance.getInstance().getFactory().openSession(true)
		.getMapper(ILeasingCompanyService.class);

    }

    @Override
    public LeasingCompany getById(Long id) {
	return leasingCompanyService.getById(id);
    }

    @Override
    public void update(LeasingCompany entity) {
	leasingCompanyService.update(entity);
    }

    @Override
    public void delete(Long id) {
	leasingCompanyService.delete(id);
    }

    @Override
    public List<LeasingCompany> getAll() {
	return leasingCompanyService.getAll();
    }

    @Override
    public void add(LeasingCompany entity) {
	leasingCompanyService.add(entity);
    }

}
