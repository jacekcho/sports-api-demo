package org.example.sportsapidemo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Competition {

    private String id;

    private String name;

    private Competition() {
    }

    public Competition(String id, String name) {
        this.id = id;
        this.name = name;
    }

}
