package br.com.supersim.service.people;

import br.com.supersim.service.people.domain.Area;
import br.com.supersim.service.people.domain.Phase;
import br.com.supersim.service.people.service.CandidateService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.supersim.service.people.model.Candidate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class PeopleSerializationTests {

	/**
	 * Logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(PeopleSerializationTests.class);

	@Autowired
	CandidateService candidateService;

	@Autowired
	ObjectMapper mapper;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testSerialize(){
		Candidate candidate = new Candidate("Tadeu", Area.DATA, "BA", Phase.APPLICATION);

		Map<String, Object> attributes = new HashMap<>();
		attributes.put("address", "123 Main Street");
		attributes.put("zipcode", 12345);

		candidate.setAdditionalInformation(attributes);
		try {
			candidate.serializeAdditionalInformation();
		} catch (JsonProcessingException e) {
			PeopleSerializationTests.LOGGER.info("Unable to serialize attributes");
//			e.printStackTrace()
		}
		String serialized = candidate.getAdditionalInformationJson();

		PeopleSerializationTests.LOGGER.info("Serialized attributes: " + serialized);

		candidate.setAdditionalInformationJson(serialized);
		try{
			candidate.deserializeAdditionalInformation();
		}catch (IOException e) {
			PeopleSerializationTests.LOGGER.info("Unable to deserialize attributes");
			e.printStackTrace();
		}

		PeopleSerializationTests.LOGGER.info(candidate.toString());

		Assertions.assertEquals(attributes, candidate.getAdditionalInformation());
	}

	@Test
	public void testSaveJson(){
		Candidate candidate = new Candidate("Tadeu", Area.DATA, "BA", Phase.APPLICATION);
		Map<String, Object> additionalInformation = new HashMap<>();
		additionalInformation.put("address", "123 Main Street");
		additionalInformation.put("zipcode", 12345);
		candidate.setAdditionalInformation(additionalInformation);

		Candidate createdCandidate = candidateService.create(candidate);

		PeopleSerializationTests.LOGGER.info(createdCandidate.toString());
		Assertions.assertEquals(Area.DATA, createdCandidate.getArea());
		Assertions.assertEquals(Phase.APPLICATION, createdCandidate.getPhase());
	}


	@Test
	public void testSerializeEnums() {
		String data = null;
		String phase = null;
		try{
			data = mapper.writeValueAsString(Area.DATA);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		try{
			phase = mapper.writeValueAsString(Phase.APPLICATION);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		Assertions.assertEquals("{\"id\":1,\"value\":\"data\",\"name\":\"Data\"}", data);
		Assertions.assertEquals("{\"id\":0,\"value\":\"application\",\"name\":\"Application\"}", phase);
	}

}
