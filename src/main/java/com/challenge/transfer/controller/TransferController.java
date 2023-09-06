package com.challenge.transfer.controller;

import com.challenge.transfer.entity.WalletResponse;
import com.challenge.transfer.entity.transfer.TransferRequest;
import com.challenge.transfer.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    @Autowired
    TransferService transferService;

    @GetMapping(value = "/ping", produces = "application/json")
    public ResponseEntity<String> pingCheck() {
        return new ResponseEntity<>("I'm alive", HttpStatus.OK);
    }

    @PostMapping(value = "/withdraw", produces = "application/json")
    public ResponseEntity<WalletResponse> transferMoney(@RequestBody TransferRequest transferRequest) {
        return new ResponseEntity<>(transferService.sendMoney(transferRequest), HttpStatus.OK);
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
