package com.springevents.listiner;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.springevents.eventmodel.TransactionEvent;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BreakThroughTransactionEventListener {
     @EventListener(condition = "#event.payload.get('eventName').toString().contains('breakthrough')")
    @Async
    public void handleEvent(TransactionEvent event) {
        log.info("BreakThroughTransactionEventListener Thread Name: " + Thread.currentThread().getName());
        log.info("BreakThroughTransactionEventListener - "+ event.getPayload());
    }
}