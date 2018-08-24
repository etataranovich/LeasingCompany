package by.tataranovich.leasingcompany.service.mybatisimpl;

import java.util.List;

import by.tataranovich.leasingcompany.model.LeasingProgramm;
import by.tataranovich.leasingcompany.mybatis.DatabaseInstance;
import by.tataranovich.leasingcompany.service.ILeasingProgrammService;

public class LeasingProgrammImpl implements ILeasingProgrammService {

    private ILeasingProgrammService leasingProgrammService;

    public LeasingProgrammImpl() {
	this.leasingProgrammService = DatabaseInstance.getInstance().getFactory().openSession(true)
		.getMapper(ILeasingProgrammService.class);

    }

    @Override
    public void add(LeasingProgramm entity) {
	leasingProgrammService.add(entity);

    }

    @Override
    public LeasingProgramm getById(Long id) {
	return leasingProgrammService.getById(id);
    }

    @Override
    public void update(LeasingProgramm entity) {
	leasingProgrammService.update(entity);

    }

    @Override
    public void delete(Long id) {
	leasingProgrammService.delete(id);
    }

    @Override
    public List<LeasingProgramm> getAll() {
	return leasingProgrammService.getAll();
    }

    @Override
    public LeasingProgramm getLeasingProgrammByContractId(Long idLeasingProgramm) {
	return leasingProgrammService.getLeasingProgrammByContractId(idLeasingProgramm);
    }

}
