package com.research.consumer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MyTopicConsumer {

    private final List<String> messages = new ArrayList<>();

    @KafkaListener(topics = "osl_03", group = "kafka-sandbox")
    public void listen(String message) {
        synchronized (messages) {
            System.out.println("Listen() method called:-" + message);
            messages.add(message);
        }
    }

    public List<String> getMessages() {
        return messages;
    }

}
