package br.com.supersim.service.people;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.supersim.service.people.model.Candidate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class PeopleApplicationTests {

	/**
	 * Logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(PeopleApplicationTests.class);

	@Test
	void contextLoads() {
	}

	@Test
	void testSerialize(){
		Candidate candidate = new Candidate(1L, "Tadeu", "Data", "BA", "Application");

		Map<String, Object> attributes = new HashMap<>();
		attributes.put("address", "123 Main Street");
		attributes.put("zipcode", 12345);

		candidate.setAttributes(attributes);
		try {
			candidate.serializeAttributes();
		} catch (JsonProcessingException e) {
			PeopleApplicationTests.LOGGER.info("Unable to serialize attributes");
//			e.printStackTrace()
		}
		String serialized = candidate.getAttributesJson();

		PeopleApplicationTests.LOGGER.info("Serialized attributes: " + serialized);

		candidate.setAttributesJson(serialized);
		try{
			candidate.deserializeAttributes();
		}catch (IOException e) {
			PeopleApplicationTests.LOGGER.info("Unable to deserialize attributes");
			e.printStackTrace();
		}

		Assertions.assertEquals(attributes, candidate.getAttributes());
	}

}
