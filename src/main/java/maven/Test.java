package maven;

import by.tataranovich.leasingcompany.model.Car;
import by.tataranovich.leasingcompany.model.CarModel;

public class Test {
    public static void main(String[] args) {

	//System.setProperty("javax.xml.bind.JAXBContextFactory", "org.eclipse.persistence.jaxb.JAXBContextFactory");
//
//	System.out.println("I’ve got ");
//	int numberOfArgs = args.length;
//
//	for (int i = 0; i < numberOfArgs; i++) {
//
//	    System.out.println("I’ve got " + args[i]);
//
//	}
	
	Car car1 = new Car();
	car1.setCarModel(CarModel.AUDI);
	Car car2 = new Car();
	car1.setCarModel(CarModel.AUDI);

	if (car1.getCarModel().equals(car2.getCarModel())) {
	    System.out.println("Good");
	}
	
	else  {
	    System.out.println("baad");
	}

    }
}