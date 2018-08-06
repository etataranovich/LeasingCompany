package by.tataranovich.leasingcompany.model;

import java.util.List;

import by.tataranovich.leasingcompany.model.IdEntity;

public class CarProvider extends IdEntity {
    
    public CarProvider() {
	super();
    }

    public CarProvider(int id) {
	super(id);
    }

    private String name;
    private String phone;
    private List<Car> cars;
    
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


    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
	return "CarProvider [id=" + getId() + ", name=" + name + ", phone=" + phone + "]";
    }
    
}
