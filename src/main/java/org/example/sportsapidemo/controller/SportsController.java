package org.example.sportsapidemo.controller;

import org.example.sportsapidemo.service.SportsService;
import org.example.sportsapidemo.utils.GlobalFilterInitializer;
import org.example.sportsapidemo.utils.PropertiesManager;
import spark.Spark;

public class SportsController {

    private final SportsService sportsService;

    public SportsController(SportsService sportsService) {
        this.sportsService = sportsService;
        setupRoutes();
        GlobalFilterInitializer.applyResponseContentType();
        GlobalFilterInitializer.applyLogger();
    }

    private void setupRoutes() {
        Spark.port(PropertiesManager.getSparkPort());

        Spark.get("/sports", sportsService::getSports);
        Spark.get("/sports/:id", sportsService::getSportById);

        Spark.post("/sports/:id", sportsService::addSport);

        Spark.put("/sports/:id", sportsService::updateSport);

        Spark.delete("/sports/:id", sportsService::removeSport);
    }
}
