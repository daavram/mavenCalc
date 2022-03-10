package com.endava.google;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GsonExample {

    private static final Logger LOGGER=LogManager.getLogger(GsonExample.class); // adaugare logger

    public static void main(String[] args) {
        Payment p = new Payment();
        p.setAmount(100.0);
        p.setCurrency("ron");
        p.setCustomerName("john Tavolta");
        p.setCardNumber("456788922445");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        //serializare

        String json = gson.toJson(p);
        LOGGER.info("\n{}",json);

        //deserializare
        Payment dP = gson.fromJson(json,Payment.class);

        LOGGER.info(p.equals(dP));
        LOGGER.info(dP.getCardNumber());
    }
}
