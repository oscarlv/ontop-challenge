package com.challenge.transfer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    @GetMapping(value = "/ping", produces = "application/json")
    public ResponseEntity<String> pingCheck() {
        return new ResponseEntity<>("I'm alive", HttpStatus.OK);
    }

    @PostMapping(value = "/transfer", produces = "application/json")
    public ResponseEntity<String> transferMoney() {
        return new ResponseEntity<>("Transfered", HttpStatus.OK);
    }

    @GetMapping(value = "/history", produces = "application/json")
    public ResponseEntity<String> getTransactions() {
        return new ResponseEntity<>("Fetched", HttpStatus.OK);
    }

    @GetMapping(value = "/transfer/status", produces = "application/json")
    public ResponseEntity<String> getStatus() {
        return new ResponseEntity<>("Status", HttpStatus.OK);
    }
}
