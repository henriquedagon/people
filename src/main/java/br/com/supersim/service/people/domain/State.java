package br.com.supersim.service.people.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ApiModel
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum State implements Serializable {

    DECLINED(0L, "declined", "Declined"),

    APPLICATION(10L, "application", "Application"),

    APPROVED(20L, "approved", "Approved"),

    ;

    private Long id;

    private String value;

    private String name;

    State(Long id, String value, String name) {
        this.id = id;
        this.value = value;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static Map<String, Object> toJson(State state) {
        return Map.of("id", state.getId(),
                "value", state.getValue(),
                "name", state.getName());
    }

    public static List<State> getAll() {
        return Arrays.stream(State.values()).collect(Collectors.toList());
    }

    public static List<Map<String, Object>> getAllAsJson() {
        return Arrays.stream(State.values())
                .map(State::toJson)
                .collect(Collectors.toList());
    }

    public static State getById(Long id) {
        for (State p : values()) {
            if (p.id.equals(id))
                return p;
        }
        return null;
    }

    /**
     * Gets the value of the enum from a given JSON.
     *
     * @param id Identifier.
     * @return The value of the enum from a given JSON.
     */
    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public static State fromJson(
            @JsonProperty(value = "id") final Long id) {
        return State.getById(id);
    }

    @Override
    public String toString() {
        return "State{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
