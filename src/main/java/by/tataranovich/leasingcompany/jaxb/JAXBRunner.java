package by.tataranovich.leasingcompany.jaxb;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.tataranovich.leasingcompany.model.LeasingCompany;
import by.tataranovich.leasingcompany.model.LeasingCompanyList;
import by.tataranovich.leasingcompany.service.jdbcimpl.LeasingCompanyServiceImpl;

public class JAXBRunner {
    
	 private static final Logger lOGGER = LogManager.getLogger(JAXBRunner.class);
	
	 
	 public static void main(String[] args) {
	     
	        LeasingCompanyServiceImpl leasingCompanyServiceImpl = new LeasingCompanyServiceImpl();
	        List<LeasingCompany> leasingCompanies = leasingCompanyServiceImpl.getAll();
	        
		writeLeasingCopmaniesToXml(leasingCompanies, "src\\main\\resources\\LeasingCompany.xml");
		readLeasingCopmaniesFromXml("src\\main\\resources\\LeasingCompany.xml");
		//System.out.println(leasingCompanyServiceImpl.getAll());
	 }
	 
	public static void writeLeasingCopmaniesToXml(List<LeasingCompany> leasingCompanies, String filePath) {
	    LeasingCompanyList leasingCompanyList = new LeasingCompanyList();
	    leasingCompanyList.setLeasingCompanyList(leasingCompanies);
	    JAXBContext context = null;
	    Marshaller marshaller = null;
	    try {
		//context1 = JAXBContext.newInstance(LeasingCompanyList.class);
		context = JAXBContext.newInstance(LeasingCompanyList.class);
		marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(leasingCompanyList, new File(filePath));
	    } catch (JAXBException e) {
		lOGGER.error(e.getMessage());
	    }
	}

	public static List<LeasingCompany> readLeasingCopmaniesFromXml(String filePath) {
	    JAXBContext context = null;
	    List<LeasingCompany> leasingCompanies = null;
	    try {
		File file = new File("data/modelxml.xml");
		context = JAXBContext.newInstance(LeasingCompanyList.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		LeasingCompanyList leasingCompanyList = (LeasingCompanyList) unmarshaller.unmarshal(file);
		leasingCompanies = leasingCompanyList.getLeasingCompanyList();
	    } catch (JAXBException e) {
		lOGGER.error(e.getMessage());
	    }
	    return leasingCompanies;
	}
    }

