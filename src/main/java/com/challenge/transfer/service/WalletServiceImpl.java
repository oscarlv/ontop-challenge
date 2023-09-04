package com.challenge.transfer.service;

import com.challenge.transfer.entity.WalletRequest;
import com.challenge.transfer.entity.WalletResponse;
import com.challenge.transfer.helper.RestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService{

    @Value("${service.wallet.base.url}")
    private String baseUrlWallet;

    @Autowired
    private RestHelper restHelper;

    private ResponseEntity<WalletResponse> callServiceWallet(WalletRequest walletRequest,
                                                             String walletPath) {
        String walletServiceUrl = restHelper.createUrl(baseUrlWallet, walletPath);

        final HttpEntity<WalletRequest> requestHttpEntity = new HttpEntity<>(walletRequest);

        return restHelper.executeServiceCall(walletServiceUrl, requestHttpEntity,
                        WalletResponse.class, HttpMethod.POST);
    }
}
