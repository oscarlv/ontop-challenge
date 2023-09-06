package com.challenge.transfer.service;

import com.challenge.transfer.entity.WalletResponse;
import com.challenge.transfer.entity.transfer.TransferRequest;
import org.springframework.http.ResponseEntity;

public interface TransferService {

    WalletResponse sendMoney(TransferRequest transferRequest);
}
