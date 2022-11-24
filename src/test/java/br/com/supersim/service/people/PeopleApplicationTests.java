package br.com.supersim.service.people;

import br.com.supersim.service.people.domain.Area;
import br.com.supersim.service.people.model.Candidate;
import br.com.supersim.service.people.service.CandidateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class PeopleApplicationTests {

//	@Autowired
//	CandidateService candidateService;

	@Test
	void contextLoads() {
	}

	@Test
	public void testJsonSerialization() {
		Candidate candidate = new Candidate("Name", Area.DATA, "Position", "Phase");

//		Candidate savedCandidate = candidateService.create(candidate);

//		Assertions.assertEquals(candidate, savedCandidate);
	}

}
