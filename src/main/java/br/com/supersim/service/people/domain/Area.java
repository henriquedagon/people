package br.com.supersim.service.people.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum Area {

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
                "name",area.getName());
    }

    public static List<Map<String, Object>> getAllAsJson() {
        return Arrays.stream(Area.values())
                .map(Area::toJson)
                .collect(Collectors.toList());
    }
}
