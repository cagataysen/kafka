package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Publisher {

    @Autowired
    KafkaTemplate<String, String> template;

    public void sendMessage(String message){
        //we can check the callbacks from send's result, we should log this part in real life scenarios
        template.send("addTopic", message);
    }






}
