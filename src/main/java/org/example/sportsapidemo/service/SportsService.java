package org.example.sportsapidemo.service;

import com.google.gson.Gson;
import org.example.sportsapidemo.model.Sports;
import org.example.sportsapidemo.utils.DefaultSportsData;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SportsService {

    private static final Gson GSON = new Gson();

    private static final List<Sports> sports = new ArrayList<>();

    public SportsService() {
        DefaultSportsData.injectDefaultData(sports);
    }

    public String getSports(Request req, Response res) {
        res.type("application/json");
        return GSON.toJson(sports);
    }

    public Integer addSport(Request req, Response res) {
        res.type("application/json");
        sports.add(setSport(req));
        return res.status();
    }

    private Sports setSport(Request req) {
        String requestBody = req.body();
        Sports sport = GSON.fromJson(requestBody, Sports.class);
        sport.setId(req.params("id"));
        return sport;
    }

    public String getSportById(Request req, Response res) {
        res.type("application/json");
        String id = req.params("id");
        Optional<Sports> optionalSport = findSportById(id);
        if (optionalSport.isPresent()) {
            return GSON.toJson(optionalSport.get());
        } else {
            res.status(404);
            return GSON.toJson("No Sport with the id: " + id);
        }
    }

    private Optional<Sports> findSportById(String id) {
        return sports.stream()
                .filter(sport -> sport.getId().equals(id))
                .findFirst();
    }


}
