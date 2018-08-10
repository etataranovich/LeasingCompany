package by.tataranovich.leasingcompany.model;



import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import by.tataranovich.leasingcompany.model.IdEntity;


@XmlRootElement(name="carProvider")
@XmlAccessorType(XmlAccessType.FIELD)
public class Car extends IdEntity {

    public Car(Long id) {
	super(id);
    }

    public Car() {
	super();
    }

    private Integer price;
    private CarModel carModel;
    private CarProvider carProvider;

    public Integer getPrice() {
	return price;
    }

    public void setPrice(Integer price) {
	this.price = price;
    }

    public CarModel getCarModel() {
	return carModel;
    }

    public void setCarModel(CarModel carModel) {
	this.carModel = carModel;
    }

    public CarProvider getCarProvider() {
	return carProvider;
    }

    public void setCarProvider(CarProvider carProvider) {
	this.carProvider = carProvider;
    }

    @Override
    public String toString() {
	return "Car [id=" + getId() + ", price=" + price + ", carModel=" + carModel + ", carProvider=" + carProvider
		+ "]";
    }

}
