package org.example.sportsapidemo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Sport {

    private String id;

    private String name;

    private boolean active;

    private List<Competition> competitions;

    private Sport() {
    }

    public Sport(String id, String name, boolean active, List<Competition> competitions) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.competitions = competitions;
    }

}