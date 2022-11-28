package br.com.supersim.service.people;

import br.com.supersim.service.people.domain.Area;
import br.com.supersim.service.people.service.CandidateService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.supersim.service.people.model.Candidate;
import org.springframework.data.geo.Distance;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class PeopleApplicationTests {

	/**
	 * Logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(PeopleApplicationTests.class);

	@Autowired
	CandidateService candidateService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testSerialize(){
		Candidate candidate = new Candidate("Tadeu", Area.DATA, "BA", "Application");

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

		PeopleApplicationTests.LOGGER.info(candidate.toString());

		Assertions.assertEquals(attributes, candidate.getAttributes());
	}

	@Test
	public void testSaveJson(){
		Candidate candidate = new Candidate("Tadeu", Area.DATA, "BA", "Application");
		Map<String, Object> attributes = new HashMap<>();
		attributes.put("address", "123 Main Street");
		attributes.put("zipcode", 12345);
		candidate.setAttributes(attributes);

		Candidate createdCandidate = candidateService.create(candidate);

		PeopleApplicationTests.LOGGER.info(createdCandidate.toString());
		Assertions.assertEquals(Area.DATA, createdCandidate.getArea());
	}


	@Test
	public void testSerializeEnums() {
		try{
			PeopleApplicationTests.LOGGER.info(new ObjectMapper().writeValueAsString(Area.DATA));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

}
