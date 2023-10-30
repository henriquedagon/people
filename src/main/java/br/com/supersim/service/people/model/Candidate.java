package br.com.supersim.service.people.model;

import br.com.supersim.service.people.common.AreaConverter;
import br.com.supersim.service.people.common.PhaseConverter;
import br.com.supersim.service.people.domain.Area;
import br.com.supersim.service.people.domain.Phase;

import javax.persistence.*;

@Entity
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition = "JSONB")
    @Convert(converter = AreaConverter.class)
    private Area area;

    @Column(columnDefinition = "JSONB")
    @Convert(converter = PhaseConverter.class)
    private Phase phase;

    private String position;

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

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Candidate candidate = (Candidate) o;

        if (!id.equals(candidate.id))
            return false;
        if (!name.equals(candidate.name))
            return false;
        if (area != candidate.area)
            return false;
        if (!position.equals(candidate.position))
            return false;
        return phase == candidate.phase;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + area.hashCode();
        result = 31 * result + position.hashCode();
        result = 31 * result + phase.hashCode();
        return result;
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
