package by.tataranovich.leasingcompany.service.mybatisimpl;

import java.util.List;

import by.tataranovich.leasingcompany.model.Credit;
import by.tataranovich.leasingcompany.mybatis.DatabaseInstance;
import by.tataranovich.leasingcompany.service.ICreditService;

public class CreditServiceImpl implements ICreditService {

    private ICreditService creditService;

    public CreditServiceImpl() {
	this.creditService = DatabaseInstance.getInstance().getFactory().openSession(true).getMapper(ICreditService.class);

    }

    @Override
    public void add(Credit entity) {
	creditService.add(entity);
    }

    @Override
    public Credit getById(Long id) {
	return creditService.getById(id);
    }

    @Override
    public void update(Credit entity) {
	creditService.update(entity);

    }

    @Override
    public void delete(Long id) {
	creditService.delete(id);
    }

    @Override
    public List<Credit> getAll() {
	return creditService.getAll();
    }

    @Override
    public Credit getCreditByContractId(Long idContract) {
	return creditService.getCreditByContractId(idContract);
    }

}
