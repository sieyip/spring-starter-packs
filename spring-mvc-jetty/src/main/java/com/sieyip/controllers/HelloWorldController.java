package com.sieyip.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sieyip.dto.HelloWorldRequest;
import com.sieyip.dto.HelloWorldResponse;


@RestController
@RequestMapping("/api")
public class HelloWorldController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<String> helloWorld() {    
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{greeting}/{name}", method = RequestMethod.GET)
    public ResponseEntity<String> helloYou(
            @PathVariable("greeting") String greeting,
            @PathVariable("name") String name) {
        
        return new ResponseEntity<>(greeting + " " + name, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<HelloWorldResponse> addRestaurantGroup(@RequestBody HelloWorldRequest helloWorldRequest) {
        return new ResponseEntity<>(helloWorldRequest.toHelloWorldResponse(), HttpStatus.OK);
    }
    
}
