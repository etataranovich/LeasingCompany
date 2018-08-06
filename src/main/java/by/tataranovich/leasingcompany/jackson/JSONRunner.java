package by.tataranovich.leasingcompany.jackson;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JSONRunner {
	private static final Logger lOGGER = LogManager.getLogger(JSONRunner.class);

	public static void main(String[] args) {

		ObjectMapper mapper = new ObjectMapper();
		try {
			File reader = new File("src\\main\\resources\\LeasingCompany.json");
			//mapper.setDateFormat(new SimpleDateFormat("dd.MM.yyyy"));
			JSONLeasingCompany jacksonBuilder = mapper.readValue(reader, JSONLeasingCompany.class);
			lOGGER.info(jacksonBuilder.getLeasingCompany().get(1).toString());
			lOGGER.info(jacksonBuilder.getLeasingCompany().get(1).toString());
		} catch (JsonGenerationException e) {
			lOGGER.info(e.getMessage());
		} catch (JsonMappingException e) {
			lOGGER.info(e.getMessage());
		} catch (IOException e) {
			lOGGER.info(e.getMessage());

		}
	}
}
