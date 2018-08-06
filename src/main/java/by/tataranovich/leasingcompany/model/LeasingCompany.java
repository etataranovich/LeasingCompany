package by.tataranovich.leasingcompany.model;

import java.util.List;

import by.tataranovich.leasingcompany.model.IdEntity;

public class LeasingCompany extends IdEntity {
    private String name;
    private String phone;
    private List<Address> addresses;
    private List<Contract> contracts;
    private List<Client> clients;

    public LeasingCompany(int id) {
	super(id);
    }

    public LeasingCompany() {
	super();
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Address> getAddresses() {
	return addresses;
    }

    public void setAddresses(List<Address> addresses) {
	this.addresses = addresses;
    }

    public List<Contract> getContracts() {
	return contracts;
    }

    public void setContracts(List<Contract> contracts) {
	this.contracts = contracts;
    }

    
    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
	return "LeasingCompany [id=" + getId() + ", name=" + name + ", phone=" + phone + ", addresses" + addresses
		+ ", contracts=" + contracts + ", clients=" + clients +"]";
    }

}
