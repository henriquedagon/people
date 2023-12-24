package br.com.supersim.service.people.common;

import br.com.supersim.service.people.domain.State;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.AttributeConverter;
import java.io.IOException;

public class StateConverter implements AttributeConverter<State, String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(StateConverter.class);

    final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(State state) {

        String stateJson = null;
        try {
            stateJson = objectMapper.writeValueAsString(state);
        } catch (final JsonProcessingException e) {
           StateConverter.LOGGER.error("JSON writing error", e);
        }

        return stateJson;
    }

    @Override
    public State convertToEntityAttribute(String stateJson) {

        State state = null;
        try {
            state = objectMapper.readValue(stateJson, new TypeReference<>() {});
        } catch (final IOException e) {
           StateConverter.LOGGER.error("JSON writing error", e);
        }

        return state;
    }


}
