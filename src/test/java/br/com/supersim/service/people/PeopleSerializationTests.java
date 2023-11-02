package br.com.supersim.service.people;

import br.com.supersim.service.people.domain.Area;
import br.com.supersim.service.people.domain.Phase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PeopleSerializationTests {

	@Autowired
	ObjectMapper mapper;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testSerializeEnums() {
		String data = null;
		String phase = null;
		try {
			data = mapper.writeValueAsString(Area.DATA);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		try {
			phase = mapper.writeValueAsString(Phase.APPLICATION);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		Assertions.assertEquals("{\"id\":1,\"value\":\"data\",\"name\":\"Data\"}", data);
		Assertions.assertEquals("{\"id\":0,\"value\":\"application\",\"name\":\"Application\"}", phase);
	}

}
