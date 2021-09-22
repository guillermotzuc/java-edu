package com.github.simplesteph.udemy.kafka.streams;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import udemy.kafka.streams.eos.BankTransactionsProducer;

public class BankTransactionsProducerTests {

    @Test
    public void newRandomTransactionsTest(){
        ProducerRecord<String, String> record = BankTransactionsProducer.newRandomTransaction("john");
        String key = record.key();
        String value = record.value();

        assertEquals(key, "john");

        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode node = mapper.readTree(value);
            assertEquals(node.get("name").asText(), "john");
            assertTrue(node.get("amount").asInt() < 100);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(value);

    }

}
