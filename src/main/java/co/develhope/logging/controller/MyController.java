package co.develhope.logging.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    Logger logger = LoggerFactory.getLogger(MyController.class);
    @Value("${my.custom.value1}")
    private int value1;

    @Value("${my.custom.value2}")
    private int value2;


    @GetMapping("/")
    public ResponseEntity<String> welcome() {
        String message = "Welcome to the Spring Boot application!";
        logger.info(message);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/exp")
    public ResponseEntity<String> calculateExponent() {
        logger.debug("Calculating exponent...");
        double result = Math.pow(value1, value2);
        logger.debug("Exponent calculation finished. Result: {}", result);
        return ResponseEntity.ok("The exponent of " + value1 + " and " + value2 + " is: " + result);
    }

    @GetMapping("/get-errors")
    public String getError() {
        String message = "Error!";
        Error error = new Error("This is a custom error made by Claudio");
        logger.error("Attention! An error occurred! : " + error);
        return message;
    }
}
