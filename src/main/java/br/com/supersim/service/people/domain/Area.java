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
public enum Area implements Serializable {

    TECH(0L, "tech", "Tech"),

    DATA(1L, "data", "Data"),

    RISK(2L, "risk", "Risk"),

    LEGAL(3L, "legal", "Legal")

    ;

    private Long id;

    private String value;

    private String name;

    Area(Long id, String value, String name) {
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

    public static Map<String, Object> toJson(Area area) {
        return Map.of("id", area.getId(),
                "value", area.getValue(),
                "name", area.getName());
    }

    public static List<Area> getAll() {
        return Arrays.stream(Area.values()).collect(Collectors.toList());
    }

    public static List<Map<String, Object>> getAllAsJson() {
        return Arrays.stream(Area.values())
                .map(Area::toJson)
                .collect(Collectors.toList());
    }

    public static Area getById(Long id) {
        for (Area a : values()) {
            if (a.id.equals(id))
                return a;
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
    public static Area fromJson(
            @JsonProperty(value = "id")
            final Long id) {
        return Area.getById(id);
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
