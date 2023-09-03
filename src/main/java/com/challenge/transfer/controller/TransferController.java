package com.challenge.transfer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    @GetMapping(value = "/ping", produces = "application/json")
    public ResponseEntity<String> pingCheck() {
        return new ResponseEntity<>("I'm alive", HttpStatus.OK);
    }

}
