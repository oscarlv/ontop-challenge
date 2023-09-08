package com.challenge.transfer.controller;

import com.challenge.transfer.entity.wallet.WalletResponse;
import com.challenge.transfer.entity.transfer.TransferRequest;
import com.challenge.transfer.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@EnableScheduling
@RestController
public class TransferController {

    @Autowired
    TransferService transferService;

    @GetMapping(value = "/ping", produces = "application/json")
    public ResponseEntity<String> pingCheck() {
        return new ResponseEntity<>("I'm alive", HttpStatus.OK);
    }

    @PostMapping(value = "/withdraw", produces = "application/json")
    public ResponseEntity<?> transferMoney(@RequestBody TransferRequest transferRequest) {
        return new ResponseEntity<>(transferService.withdrawMoney(transferRequest), HttpStatus.OK);
    }

    @GetMapping(value = "/transactions", produces = "application/json")
    public ResponseEntity<String> getTransactions() {
        return new ResponseEntity<>("Fetched", HttpStatus.OK);
    }

    // TODO: Disabled as it is an improvement idea only
    /*
    @Scheduled(fixedRate = 5000)
    @GetMapping(value = "/status", produces = "application/json")
    public ResponseEntity<String> getStatus(Integer transactionId) {
        return new ResponseEntity<>(transferService.checkTransactionStatus(transactionId), HttpStatus.OK);
    }*/
}
