package com.endava.jackson;

import com.endava.google.GsonExample;
import com.endava.google.Payment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JacksonExample {

    private static final Logger LOGGER = LogManager.getLogger(JacksonExample.class); // adaugare logger

    public static void main(String[] args) throws JsonProcessingException {
        Payment p = new Payment();
        p.setAmount(100.5);
        p.setCurrency("EUR");
        p.setCustomerName("Mark Hamilton");
        p.setCardNumber("335645676777");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(p);
        LOGGER.info("json {}", json);

        Payment dP = objectMapper.readValue(json,Payment.class);
        LOGGER.info(p.equals(dP));

    }
}
