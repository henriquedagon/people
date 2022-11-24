package br.com.supersim.service.people.model;

import br.com.supersim.service.people.common.HashMapConverter;
import br.com.supersim.service.people.domain.Area;
import br.com.supersim.service.people.domain.Phase;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Area area;

    private String position;

    private String phase;

    public Candidate() {
    }

    public Long getId() {
        return id;
    }

    public Candidate(String name, Area area, String position, String phase) {
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

    @Column(columnDefinition = "JSONB")
    @Convert(converter = HashMapConverter.class)
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

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
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
