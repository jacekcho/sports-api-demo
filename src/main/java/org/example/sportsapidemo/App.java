package org.example.sportsapidemo;

import lombok.extern.slf4j.Slf4j;
import org.example.sportsapidemo.controller.SportsController;
import org.example.sportsapidemo.service.SportsService;
import spark.Spark;

@Slf4j
public class App {

    public static void main(String[] args) {
        log.info("APP is starting...");
        SportsService sportsService = new SportsService();
        new SportsController(sportsService);
        Spark.awaitInitialization();
    }

}