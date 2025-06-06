package com.springevents.publisher;

import com.fasterxml.jackson.databind.JsonNode;
import com.springevents.eventmodel.TransactionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class CashTransactionEventPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishTransactionEvent(final JsonNode payload) {
        System.out.println("Publishing custom Transaction Event ");
        TransactionEvent transactionEvent = new TransactionEvent(this, payload);
        applicationEventPublisher.publishEvent(transactionEvent);
    }
}
