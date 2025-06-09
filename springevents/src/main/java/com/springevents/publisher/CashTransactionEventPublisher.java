package com.springevents.publisher;

import com.fasterxml.jackson.databind.JsonNode;
import com.springevents.eventmodel.TransactionEvent;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CashTransactionEventPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishTransactionEvent(final JsonNode payload) {
        log.info("CashTransactionEventPublisher Thread Name: " + Thread.currentThread().getName());
        log.info("Publishing custom Transaction Event ");
        TransactionEvent transactionEvent = new TransactionEvent(this, payload);
        applicationEventPublisher.publishEvent(transactionEvent);
    }
}
