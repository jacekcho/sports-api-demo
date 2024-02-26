package org.example.sportsapidemo.service;

import com.google.gson.Gson;
import org.example.sportsapidemo.model.Sports;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.List;

public class SportsService {

    private static final Gson GSON = new Gson();

    private static final List<Sports> sports = new ArrayList<>();

    static {
        sports.add(new Sports("1", "Fishing", false));
        sports.add(new Sports("2", "Football", true));
        sports.add(new Sports("3", "Pool", false));
        sports.add(new Sports("4", "Sumo", false));
        sports.add(new Sports("5", "Rugby League", true));
        sports.add(new Sports("6", "Futsal", true));
        sports.add(new Sports("7", "Snooker", true));
        sports.add(new Sports("8", "UFC", true));
        sports.add(new Sports("9", "Hockey", false));
        sports.add(new Sports("10", "Motor Racing", true));
    }

    public String getSports(Request req, Response res) {
        res.type("application/json");
        return GSON.toJson(sports);
    }

    public Integer addSport(Request req, Response res) {
        String requestBody = req.body();
        Sports sport = GSON.fromJson(requestBody, Sports.class);
        sports.add(sport);
        return res.status();
    }

}
