package by.tataranovich.leasingcompany.model;

//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;

import com.fasterxml.jackson.annotation.JsonIgnore;

//@XmlAccessorType(XmlAccessType.FIELD)
public class Address extends IdEntity {

    private String street;
    private String houseNumber;
    
    @JsonIgnore
    private int leasingCompanyId;
    
    

    public Address(String street, String houseNumber, int leasingCompanyId) {
		super();
		this.street = street;
		this.houseNumber = houseNumber;
		this.leasingCompanyId = leasingCompanyId;
	}

	public Address(Long id) {
	super(id);
    }

    public Address() {
	super();
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

        
    public int getLeasingCompanyId() {
        return leasingCompanyId;
    }

    public void setLeasingCompanyId(int leasingCompanyId) {
        this.leasingCompanyId = leasingCompanyId;
    }

    @Override
    public String toString() {
	return "Address [id=" + getId() + ", street=" + street + ", houseNumber = " + houseNumber + "]";
    }

}