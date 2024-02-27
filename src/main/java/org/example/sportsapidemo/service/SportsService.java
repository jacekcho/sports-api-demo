package org.example.sportsapidemo.service;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.example.sportsapidemo.model.Sports;
import org.example.sportsapidemo.utils.DefaultSportsData;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class SportsService {

    private static final Gson GSON = new Gson();

    private static final List<Sports> sports = new ArrayList<>();

    public SportsService() {
        DefaultSportsData.injectDefaultData(sports);
    }

    public String getSports(Request req, Response res) {
        logRequest(req);
        res.type("application/json");
        return GSON.toJson(sports);
    }

    public Integer addSport(Request req, Response res) {
        logRequest(req);
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
        logRequest(req);
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

    private void logRequest(Request req) {
        if (req.body().isEmpty()) {
            log.info(String.format("\nRequest method: %s\nRequest URI: %s%s", req.requestMethod(), req.host(), req.uri()));
        } else {
            log.info(String.format("\nRequest method: %s\nRequest URI: %s%s\nBody: %s", req.requestMethod(), req.host(), req.uri(), req.body()));
        }
    }

}
