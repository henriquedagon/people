package br.com.supersim.service.people.model;

import br.com.supersim.service.people.common.HashMapConverter;
import br.com.supersim.service.people.domain.Area;
import br.com.supersim.service.people.domain.Phase;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

import javax.persistence.*;

@Entity
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String area;

    private String position;

    private String phase;

    private String attributesJson;

    @Convert(converter = HashMapConverter.class)
    private Map<String, Object> attributes;

    public Candidate() {
    }

    public Candidate(Long id, String name, String area, String position, String phase) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.position = position;
        this.phase = phase;
    }

    public Long getId() {
        return id;
    }

    public Candidate(String name, String area, String position, String phase) {
        this.name = name;
        this.area = area;
        this.position = position;
        this.phase = phase;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getAttributesJson() {
        return attributesJson;
    }

    public void setAttributesJson(String attributeJson) {
        this.attributesJson = attributeJson;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public void serializeAttributes() throws JsonProcessingException {
        final ObjectMapper objectMapper = new ObjectMapper();
        this.attributesJson = objectMapper.writeValueAsString(this.attributes);
    }

    public void deserializeAttributes() throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        this.attributes = objectMapper.readValue(this.attributesJson, new TypeReference<>() {});
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", position='" + position + '\'' +
                ", phase='" + phase + '\'' +
                '}';
    }
}
