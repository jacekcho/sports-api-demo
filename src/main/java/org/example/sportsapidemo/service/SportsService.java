package org.example.sportsapidemo.service;

import com.google.gson.Gson;
import org.example.sportsapidemo.model.Sport;
import org.example.sportsapidemo.utils.DefaultSportsData;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SportsService {

    private static final Gson GSON = new Gson();

    private static final List<Sport> SPORTS = new ArrayList<>();

    public SportsService() {
        DefaultSportsData.injectDefaultData(SPORTS);
    }

    public String getSports(Request req, Response res) {
        return GSON.toJson(SPORTS);
    }

    public String getSportById(Request req, Response res) {
        String id = req.params("id");
        Optional<Sport> optionalSport = findSportById(id);
        if (optionalSport.isPresent()) {
            return GSON.toJson(optionalSport.get());
        } else {
            res.status(404);
            return GSON.toJson("No Sport with the id: " + id);
        }
    }

    public Integer addSport(Request req, Response res) {
        SPORTS.add(setSport(req));
        return res.status();
    }

    public Integer updateSport(Request req, Response res) {
        String requestSportId = req.params("id");
        Optional<Sport> existingSport = findSportById(requestSportId);
        if (existingSport.isPresent()) {
            Sport sport = setSport(req);
            existingSport.get().setName(sport.getName());
            existingSport.get().setActive(sport.isActive());
            res.status(200);
        } else {
            res.status(404);
        }
        return res.status();
    }

    private Sport setSport(Request req) {
        Sport sport = GSON.fromJson(req.body(), Sport.class);
        sport.setId(req.params("id"));
        return sport;
    }

    private Optional<Sport> findSportById(String id) {
        return SPORTS.stream()
                .filter(sport -> sport.getId().equals(id))
                .findFirst();
    }

}
