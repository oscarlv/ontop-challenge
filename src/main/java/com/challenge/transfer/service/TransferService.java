package com.challenge.transfer.service;

import com.challenge.transfer.entity.wallet.WalletResponse;
import com.challenge.transfer.entity.transfer.TransferRequest;
import org.springframework.http.ResponseEntity;

public interface TransferService {

    ResponseEntity<?> withdrawMoney(TransferRequest transferRequest);
}
