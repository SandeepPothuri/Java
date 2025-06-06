package com.springevents.eventmodel;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.context.ApplicationEvent;

public class TransactionEvent extends ApplicationEvent {
    private JsonNode payload;

    public TransactionEvent(Object source, JsonNode payload) {
        super(source);
        this.payload = payload;
    }

    public JsonNode getPayload() {
        return payload;
    }
}
