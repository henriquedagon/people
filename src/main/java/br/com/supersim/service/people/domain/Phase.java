package br.com.supersim.service.people.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ApiModel
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Phase {

    APPLICATION(0L, "application", "Application"),

    DECLINED(10L, "declined", "Declined"),

    APPROVED(20L, "approved", "Approved")

    ;

    private Long id;

    private String value;

    private String name;

    Phase(Long id, String value, String name) {
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

    public static Map<String, Object> toJson(Phase phase) {
        return Map.of("id", phase.getId(),
                "value", phase.getValue(),
                "name",phase.getName());
    }

    public static List<Map<String, Object>> getAllAsJson() {
        return Arrays.stream(Phase.values())
                .map(Phase::toJson)
                .collect(Collectors.toList());
    }

    public static Phase getById(Long id) {
        for(Phase p : values()) {
            if(p.id.equals(id)) return p;
        }
        return null;
    }

    /**
     * Gets the value of the enum from a given JSON.
     *
     * @param  id              Identifier.
    //     * @param  name            Name.
    //     * @param  value           Value.
     * @return                 The value of the enum from a given JSON.
     */
    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public static Phase fromJson(
            @JsonProperty(value = "id")
            final Long id) {
        return Phase.getById(id);
    }

    @Override
    public String toString() {
        return "Phase{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
