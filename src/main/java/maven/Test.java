package maven;

public class Test {
    public static void main(String[] args) {

	//System.setProperty("javax.xml.bind.JAXBContextFactory", "org.eclipse.persistence.jaxb.JAXBContextFactory");

	System.out.println("I’ve got ");
	int numberOfArgs = args.length;

	for (int i = 0; i < numberOfArgs; i++) {

	    System.out.println("I’ve got " + args[i]);

	}

    }
}