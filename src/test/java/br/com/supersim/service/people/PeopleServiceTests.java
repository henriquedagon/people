package br.com.supersim.service.people;

import br.com.supersim.service.people.domain.Area;
import br.com.supersim.service.people.domain.Phase;
import br.com.supersim.service.people.model.Candidate;
import br.com.supersim.service.people.service.CandidateService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PeopleServiceTests {

	/**
	 * Logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(PeopleServiceTests.class);

	@Autowired
	CandidateService candidateService;

	@AfterEach
	private void deleteAllCandidates() {
		candidateService.deleteAll();
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void testAddCandidate() {
		final String name = "Tadeu";
		final String position = "BA";
		final Area area = Area.DATA;

		// TODO add address
		// Map<String, Object> additionalInformation = new HashMap<>();
		// additionalInformation.put("address", "123 Main Street");
		// additionalInformation.put("zipcode", 12345);

		Candidate createdCandidate = candidateService.addCandidate(name, position, area);

		PeopleServiceTests.LOGGER.info(createdCandidate.toString());
		Assertions.assertEquals(name, createdCandidate.getName());
		Assertions.assertEquals(position, createdCandidate.getPosition());
		Assertions.assertEquals(area, createdCandidate.getArea());
		Assertions.assertEquals(Phase.APPLICATION, createdCandidate.getPhase());
	}

}
