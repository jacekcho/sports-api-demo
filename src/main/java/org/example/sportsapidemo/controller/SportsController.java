package org.example.sportsapidemo.controller;

import org.example.sportsapidemo.service.SportsService;
import spark.Spark;

public class SportsController {

    private final SportsService sportsService;

    public SportsController(SportsService sportsService) {
        this.sportsService = sportsService;
        setupRoutes();
    }

    private void setupRoutes() {
        Spark.port(8080);
        Spark.get("/sports", sportsService::getSports);
        Spark.post("/sports", sportsService::addSport);
    }
}
