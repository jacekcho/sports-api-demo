package org.example.sportsapidemo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Sports {

    private String id;

    private String name;

    private boolean active;

    private Sports() {
    }

    public Sports(String id, String name, boolean active) {
        this.id = id;
        this.name = name;
        this.active = active;
    }

}