package com.sieyip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sieyip.services.KafkaWriterService;
import com.sieyip.dto.KafkaMessageRequest;


@RestController
@RequestMapping("/api")
public class KafkaWriterController {

    @Autowired
    private KafkaWriterService kafkaWriterService;

    @RequestMapping(value = "/kafka/{topic}/{key}", method = RequestMethod.POST)
    public ResponseEntity saveToKafka(
            @PathVariable("topic") String topic,
            @PathVariable("key") String key,
            @RequestBody KafkaMessageRequest kafkaMessageRequest) {
        
        kafkaWriterService.writeToTopic(topic, key, kafkaMessageRequest.message);
        return new ResponseEntity(HttpStatus.OK);
    }

    
}
