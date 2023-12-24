package br.com.supersim.service.people.model;

import br.com.supersim.service.people.common.AreaConverter;
import br.com.supersim.service.people.common.StateConverter;
import br.com.supersim.service.people.domain.Area;
import br.com.supersim.service.people.domain.State;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 3)
    private String name;

    @NotNull
    @Column(columnDefinition = "JSONB")
    @Convert(converter = AreaConverter.class)
    private Area area;

    @NotNull
    @Column(columnDefinition = "JSONB")
    @Convert(converter = StateConverter.class)
    private State state = State.APPLICATION;

    @NotNull
    private String position;

    public Candidate() {
    }

    public Candidate(String name, Area area, String position) {
        this.name = name;
        this.position = position;
        this.area = area;
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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
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
        return state == candidate.state;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + area.hashCode();
        result = 31 * result + position.hashCode();
        result = 31 * result + state.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", position='" + position + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
