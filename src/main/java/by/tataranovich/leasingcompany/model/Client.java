package by.tataranovich.leasingcompany.model;

import java.util.ArrayList;

import by.tataranovich.leasingcompany.model.IdEntity;


public class Client extends IdEntity{
   
    private String firstName;
    private String lastName;
    private String phone;
    private ArrayList<Contract> contracts;

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getPhone() {
	return phone;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }

    public ArrayList<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(ArrayList<Contract> contracts) {
        this.contracts = contracts;
    }
    
    @Override
    public String toString() {
	return "Client [id=" + getId() + ", firstName=" + firstName + ", lastName=" + firstName + ", phone=" + phone
		+ "]";
    }

}
