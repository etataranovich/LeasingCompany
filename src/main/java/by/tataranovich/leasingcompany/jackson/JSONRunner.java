package by.tataranovich.leasingcompany.jackson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import by.tataranovich.leasingcompany.model.LeasingCompany;
import by.tataranovich.leasingcompany.service.jdbcimpl.LeasingCompanyServiceImpl;


public class JSONRunner {

    private final static String DATE_FORMAT = "yyyy-MM-dd";
    private static final Logger lOGGER = LogManager.getLogger(JSONRunner.class);

    public static void main(String[] args) {

	LeasingCompanyServiceImpl leasingCompanyServiceImpl = new LeasingCompanyServiceImpl();
	List<LeasingCompany> leasingCompanies = leasingCompanyServiceImpl.getAll();
	writeLeasingCopmaniesToJson(leasingCompanies, "src\\main\\resources\\LeasingCompany.json");
	readLeasingCopmaniesFromJson("src\\main\\resources\\LeasingCompany.json");
    }

    public static void writeLeasingCopmaniesToJson(List<LeasingCompany> leasingCompanies, String filePath) {
	ObjectMapper objectMapper = new ObjectMapper();
	DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
	objectMapper.setDateFormat(dateFormat);
	try {
	    objectMapper.writeValue(new File(filePath), leasingCompanies);
	} catch (JsonGenerationException e) {
	    lOGGER.error(e.getMessage());
	} catch (JsonMappingException e) {
	    lOGGER.error(e.getMessage());
	} catch (IOException e) {
	    lOGGER.error(e.getMessage());
	}
    }

    public static List<LeasingCompany> readLeasingCopmaniesFromJson(String filePath) {
	ObjectMapper objectMapper = new ObjectMapper();
	List<LeasingCompany> leasingCompanies = null;
	try (InputStream input = new FileInputStream(filePath)) {
	    leasingCompanies = objectMapper.readValue(input,
		    objectMapper.getTypeFactory().constructCollectionType(List.class, LeasingCompany.class));
	} catch (FileNotFoundException e) {
	    lOGGER.error(e.getMessage());
	} catch (JsonParseException e) {
	    lOGGER.error(e.getMessage());
	} catch (JsonMappingException e) {
	    lOGGER.error(e.getMessage());
	} catch (IOException e) {
	    lOGGER.error(e.getMessage());
	}
	return leasingCompanies;
    }
}

// public class JSONRunner {
// private static final Logger lOGGER = LogManager.getLogger(JSONRunner.class);
//
// public static void main(String[] args) {
//
// try {
// LeasingCompanyServiceImpl leasingCompanyServiceImpl = new
// LeasingCompanyServiceImpl();
// List<LeasingCompany> leasingCompanyList = leasingCompanyServiceImpl.getAll();
// ObjectMapper objectMapper = new ObjectMapper();
// DateFormat myDateFormat = new SimpleDateFormat("dd-MM-yyyy");
// objectMapper.setDateFormat(myDateFormat);
// objectMapper.writeValue(new File("src\\main\\resources\\LCCC.json"),
// leasingCompanyList);
// // InputStream input = new FileInputStream("data/fixedModel.json");
// // List<LeasingCompany> leasingCompanyListRead =
// objectMapper.readValue(input,
// // objectMapper.getTypeFactory().constructCollectionType(List.class,
// // LeasingCompany.class));
// InputStream input = new
// FileInputStream("src\\main\\resources\\LeasingCompany.json");
// List<LeasingCompany> leasingCompanyListRead = objectMapper.readValue(input,
// objectMapper.getTypeFactory().constructCollectionType(List.class,
// LeasingCompany.class));
// lOGGER.info(leasingCompanyListRead);
// // File reader = new File("src\\main\\resources\\LeasingCompany.json");
// // mapper.setDateFormat(new SimpleDateFormat("dd.MM.yyyy"));
// // JSONLeasingCompany jacksonBuilder = mapper.readValue(reader,
// // JSONLeasingCompany.class);
// // lOGGER.info(jacksonBuilder.getLeasingCompany().get(1).toString());
// // lOGGER.info(jacksonBuilder.getLeasingCompany().get(1).toString());
// } catch (JsonGenerationException e) {
// lOGGER.info(e.getMessage());
// } catch (JsonMappingException e) {
// lOGGER.info(e.getMessage());
// } catch (IOException e) {
// lOGGER.info(e.getMessage());
//
// }
// }
// }