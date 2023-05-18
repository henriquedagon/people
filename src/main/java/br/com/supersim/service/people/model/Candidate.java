package br.com.supersim.service.people.model;

import br.com.supersim.service.people.common.AreaConverter;
import br.com.supersim.service.people.common.HashMapConverter;
import br.com.supersim.service.people.common.PhaseConverter;
import br.com.supersim.service.people.common.Views;
import br.com.supersim.service.people.domain.Area;
import br.com.supersim.service.people.domain.Phase;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.annotations.Type;

import java.io.IOException;
import java.util.Map;

import javax.persistence.*;

@Entity
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonView(Views.Public.class)
    @Convert(converter = AreaConverter.class)
    private Area area;

    private String position;

    @JsonView(Views.Public.class)
    @Convert(converter = PhaseConverter.class)
    private Phase phase;

//    @Type(type = "JSONB")
//    @Column(columnDefinition = "JSONB")
//    @Convert(converter = HashMapConverter.class)
//    private Map<String, Object> additionalInformation;

    public Candidate() {
    }

    public Candidate(String name, Area area, String position, Phase phase) {
        this.name = name;
        this.area = area;
        this.position = position;
        this.phase = phase;
    }

    public Long getId() {
        return id;
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

    @Column(columnDefinition = "JSONB")
    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Column(columnDefinition = "JSONB")
    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

//    public Map<String, Object> getAdditionalInformation() {
//        return additionalInformation;
//    }
//
//    public void setAdditionalInformation(Map<String, Object> additionalInformation) {
//        this.additionalInformation = additionalInformation;
//    }

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
