package br.com.supersim.service.people.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.AttributeConverter;
import java.io.IOException;
import br.com.supersim.service.people.domain.Area;
import org.springframework.beans.factory.annotation.Autowired;

public class AreaConverter implements AttributeConverter<Area, String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AreaConverter.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public String convertToDatabaseColumn(Area area) {

        String areaJson = null;
        try {
            areaJson = this.objectMapper.writeValueAsString(area);
        } catch (final JsonProcessingException e) {
            AreaConverter.LOGGER.error("JSON writing error", e);
        }

        return areaJson;
    }

    @Override
    public Area convertToEntityAttribute(String areaJson) {

        Area area = null;
        try {
            area = this.objectMapper.readValue(areaJson, new TypeReference<>() {
            });
        } catch (final IOException e) {
            AreaConverter.LOGGER.error("JSON writing error", e);
        }

        return area;
    }

}
