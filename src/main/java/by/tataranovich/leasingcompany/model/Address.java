package by.tataranovich.leasingcompany.model;

//public class Address implements IdHolder
public class Address extends IdEntity {

    private String street;
    private String houseNumber;

    public Address(Integer id) {
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

    @Override
    public String toString() {
	return "Address [id=" + getId() + ", street=" + street + ", houseNumber" + houseNumber + "]";
    }

}