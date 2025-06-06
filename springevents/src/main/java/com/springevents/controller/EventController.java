package com.springevents.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springevents.publisher.CashTransactionEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@Slf4j
@RequestMapping("/postMessage")
public class EventController {
    @Autowired
    CashTransactionEventPublisher cashTransactionEventPublisher;

    ObjectMapper mapper = new ObjectMapper();

    @PostMapping
    public ResponseEntity<JsonNode> postMessage(@RequestBody JsonNode payload) {
        try {
            log.info("payload Received in controller : ", payload);
            //Add observer to persist the raw payload

            //Convert the Json payload to valid model CashTransactionEvent and perform duplicate check

            //If Unique payload then Use Resource Locator or better design pattern to load cashTransactionEventPublisher and publish the event
            cashTransactionEventPublisher.publishTransactionEvent(payload);
            return ResponseEntity.ok(payload);
        }catch (Exception ex){
            Map<String,String> error = new HashMap<>();
            error.put("Exception",ex.getMessage());
            JsonNode jsonNodeError = mapper.convertValue(error, JsonNode.class);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(jsonNodeError);
        }
    }
}
