package com.research.controller;

import com.research.consumer.MyTopicConsumer;
import com.research.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ApacheKafkaWebController {

    @Autowired
    private MyTopicConsumer myTopicConsumer;

    @Autowired
    private KafkaTemplate<String, User> template;

    private static final String TOPIC = "osl_03";

    @GetMapping(value = "/kafka/produce")
    public String produce(@RequestParam String message)
    {
        template.send(TOPIC, new User("OSL", message));
        return message;
    }

    @GetMapping("/kafka/messages")
    public List<String> getMessages()
    {
        return myTopicConsumer.getMessages();
    }
}

