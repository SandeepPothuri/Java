package com.springevents.listiner;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.springevents.eventmodel.TransactionEvent;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ThresholdTransactionEventListener {
    @EventListener(condition = "#event.payload.get('eventName').toString().contains('threshold')")
    @Async
    public void handleEvent(TransactionEvent event) {
        log.info("ThresholdTransactionEventListener Thread Name: " + Thread.currentThread().getName());
        log.info("ThresholdTransactionEventListener - " + event.getPayload());
    }
}