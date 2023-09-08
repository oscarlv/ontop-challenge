package com.challenge.transfer.service;

import com.challenge.transfer.entity.wallet.WalletRequest;
import com.challenge.transfer.entity.wallet.WalletResponse;
import org.springframework.http.ResponseEntity;

public interface WalletService {
    ResponseEntity<?> callWalletService(WalletRequest walletRequest,
                                        String walletPath);
}
