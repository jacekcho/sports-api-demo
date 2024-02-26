package org.example.sportsapidemo.service;

import com.google.gson.Gson;
import org.example.sportsapidemo.model.Sports;
import org.example.sportsapidemo.utils.DefaultSportsData;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.List;

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
        String requestBody = req.body();
        Sports sport = GSON.fromJson(requestBody, Sports.class);
        sports.add(sport);
        return res.status();
    }

}
