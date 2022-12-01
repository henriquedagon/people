package br.com.supersim.service.people.common;

import br.com.supersim.service.people.domain.Area;
import br.com.supersim.service.people.domain.Phase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.AttributeConverter;
import java.io.IOException;

public class PhaseConverter implements AttributeConverter<Phase, String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PhaseConverter.class);

    final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Phase phase) {

        String phaseJson = null;
        try {
            phaseJson = objectMapper.writeValueAsString(phase);
        } catch (final JsonProcessingException e) {
           PhaseConverter.LOGGER.error("JSON writing error", e);
        }

        return phaseJson;
    }

    @Override
    public Phase convertToEntityAttribute(String phaseJson) {

        Phase phase = null;
        try {
            phase = objectMapper.readValue(phaseJson, new TypeReference<>() {});
        } catch (final IOException e) {
           PhaseConverter.LOGGER.error("JSON writing error", e);
        }

        return phase;
    }


}
