package by.tataranovich.leasingcompany.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

import by.tataranovich.leasingcompany.model.IdEntity;


@XmlRootElement(name="carProvider")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarProvider extends IdEntity {
    
    public CarProvider() {
	super();
    }

    public CarProvider(Long id) {
	super(id);
    }

    private String name;
    private String phone;
    @JsonIgnore
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
