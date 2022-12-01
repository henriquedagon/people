package br.com.supersim.service.people.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HashMapConverter implements AttributeConverter<Map<String, Object>, String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(HashMapConverter.class);

    final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Map<String, Object> attribute) {

        String attributeJson = null;
        try {
            attributeJson = objectMapper.writeValueAsString(attribute);
        } catch (final JsonProcessingException e) {
           HashMapConverter.LOGGER.error("JSON writing error", e);
        }

        return attributeJson;
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String attributeJson) {

        Map<String, Object> attribute = null;
        try {
            attribute = objectMapper.readValue(attributeJson, new TypeReference<HashMap<String, Object>>() {});
        } catch (final IOException e) {
           HashMapConverter.LOGGER.error("JSON writing error", e);
        }

        return attribute;
    }


}
