package by.tataranovich.leasingcompany.service.mybatisimpl;

import java.util.List;

import by.tataranovich.leasingcompany.dao.ICreditDAO;
import by.tataranovich.leasingcompany.model.Credit;
import by.tataranovich.leasingcompany.mybatis.DatabaseInstance;
import by.tataranovich.leasingcompany.service.ICreditService;

public class CreditServiceImpl implements ICreditService {

    private ICreditDAO creditDAO;

    public CreditServiceImpl() {
	this.creditDAO = DatabaseInstance.getInstance().getFactory().openSession().getMapper(ICreditDAO.class);

    }

    @Override
    public void add(Credit entity) {
	creditDAO.add(entity);
    }

    @Override
    public Credit getById(Long id) {
	return creditDAO.getById(id);
    }

    @Override
    public void update(Credit entity) {
	creditDAO.update(entity);

    }

    @Override
    public void delete(Long id) {
	creditDAO.delete(id);
    }

    @Override
    public List<Credit> getAll() {
	return creditDAO.getAll();
    }

    @Override
    public Credit getCreditByContractId(Long idContract) {
	return creditDAO.getCreditByContractId(idContract);
    }

}
