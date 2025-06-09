package com.springevents.listiner;

import com.fasterxml.jackson.databind.JsonNode;
import com.springevents.eventmodel.TransactionEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AllocationTransactionEventListener {

    @EventListener(condition = "#event.payload.get('eventName').toString().contains('allocation')")
    @Async
    public void handleEvent(TransactionEvent event) {
        log.info("AllocationTransactionEventListener Thread Name: " + Thread.currentThread().getName());
        log.info("AllocationTransactionEventListener - "+ event.getPayload());
    }
}
