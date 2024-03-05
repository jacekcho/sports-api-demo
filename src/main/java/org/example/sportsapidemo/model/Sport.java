package org.example.sportsapidemo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Sport {

    private String id;

    private String name;

    private boolean active;

    private Sport() {
    }

    public Sport(String id, String name, boolean active) {
        this.id = id;
        this.name = name;
        this.active = active;
    }

}