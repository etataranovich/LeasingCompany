package by.tataranovich.leasingcompany.model;


import java.util.Date;

import by.tataranovich.leasingcompany.model.IdEntity;

public class Contract extends IdEntity {
    //public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private Date date;
    private Client client;
    private Car car;
    private LeasingProgramm leasingProgramm;
    private Credit credit;


    public Date getDate() {
	return date;
    }

    public void setDate(Date date) {
	this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LeasingProgramm getLeasingProgramm() {
        return leasingProgramm;
    }

    public void setLeasingProgramm(LeasingProgramm leasingProgramm) {
        this.leasingProgramm = leasingProgramm;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

//    public LeasingCompany getLeasingCompany() {
//        return leasingCompany;
//    }
//
//    public void setLeasingCompany(LeasingCompany leasingCompany) {
//        this.leasingCompany = leasingCompany;
//    }

    


}
