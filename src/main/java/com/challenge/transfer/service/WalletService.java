package com.challenge.transfer.service;

import com.challenge.transfer.entity.WalletRequest;
import com.challenge.transfer.entity.WalletResponse;

public interface WalletService {
    WalletResponse callWalletService(WalletRequest walletRequest,
                                     String walletPath);
}
