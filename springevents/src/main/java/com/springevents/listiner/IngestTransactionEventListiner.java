package com.springevents.listiner;

import com.fasterxml.jackson.databind.JsonNode;
import com.springevents.eventmodel.TransactionEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class IngestTransactionEventListiner implements ApplicationListener<TransactionEvent> {
    private final ExpressionParser parser = new SpelExpressionParser();
    private final EvaluationContext context = new StandardEvaluationContext();

    @Override
    @Async
    public void onApplicationEvent(TransactionEvent event) {
        log.info("IngestTransactionEventListiner Thread Name: " + Thread.currentThread().getName());
        JsonNode jsonNode = event.getPayload();
        // Add jsonNode to SpEL context
        context.setVariable("input", jsonNode);
        // SpEL expression to check if eventName == "ingest"
        String condition = "#input.get('eventName').toString().contains('ingest')";
        Boolean shouldProcess = parser.parseExpression(condition).getValue(context, Boolean.class);

        if (Boolean.TRUE.equals(shouldProcess)) {
            log.info("IngestTransactionEventListiner received custom event - "+ event.getPayload());
        }

    }
}
