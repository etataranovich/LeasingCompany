package by.tataranovich.leasingcompany.jackson;

import java.util.List;

import by.tataranovich.leasingcompany.model.Address;
import by.tataranovich.leasingcompany.model.Client;
import by.tataranovich.leasingcompany.model.Contract;
import by.tataranovich.leasingcompany.model.LeasingCompany;


public class JSONLeasingCompany {

	public JSONLeasingCompany() {
		super();
	}

	private List<LeasingCompany> leasingCompany;
	
	private List<Address> addresses;

	private List<Contract> contracts;

	private List<Client> clients;

	public List<LeasingCompany> getLeasingCompany() {
	    return leasingCompany;
	}

	public void setLeasingCompany(List<LeasingCompany> leasingCompany) {
	    this.leasingCompany = leasingCompany;
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


	
}
