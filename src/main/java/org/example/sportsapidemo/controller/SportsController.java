package org.example.sportsapidemo.controller;

import org.example.sportsapidemo.service.SportsService;
import org.example.sportsapidemo.utils.PropertiesManager;
import spark.Spark;

public class SportsController {

    private final SportsService sportsService;

    public SportsController(SportsService sportsService) {
        this.sportsService = sportsService;
        setupRoutes();
    }

    private void setupRoutes() {
        Spark.port(PropertiesManager.getSparkPort());
        Spark.get("/sports", sportsService::getSports);
        Spark.post("/sports", sportsService::addSport);
    }
}
