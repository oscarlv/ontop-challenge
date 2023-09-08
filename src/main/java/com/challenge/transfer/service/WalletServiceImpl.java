package com.challenge.transfer.service;

import com.challenge.transfer.entity.wallet.WalletError;
import com.challenge.transfer.entity.wallet.WalletRequest;
import com.challenge.transfer.entity.wallet.WalletResponse;
import com.challenge.transfer.helper.RestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService {

    @Value("${service.wallet.base.url}")
    private String baseUrlWallet;

    @Autowired
    private RestHelper restHelper;

    @Override
    public ResponseEntity<?> callWalletService(WalletRequest walletRequest,
                                                           String walletPath) {

        String walletServiceUrl = restHelper.createUrl(baseUrlWallet, walletPath);

        final HttpEntity<WalletRequest> requestHttpEntity
                = new HttpEntity<>(walletRequest);

        ResponseEntity<?> response = restHelper.executeServiceCall(walletServiceUrl, requestHttpEntity,
                Object.class, HttpMethod.POST);

        HttpStatus statusCode = response.getStatusCode();
        Object responseBody = response.getBody();

        switch (statusCode) {
            case OK:
                try {
                    return ResponseEntity.ok((WalletResponse) responseBody);
                } catch (ClassCastException e) {
                    // Handle the case where casting to WalletResponse is not possible
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Invalid response body for OK status from svc-wallet");
                }
            case BAD_REQUEST:
                try {
                    return ResponseEntity.status(statusCode).body((WalletError) responseBody);
                } catch (ClassCastException e) {
                    // Handle the case where casting to WalletError is not possible
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Invalid response body for BAD_REQUEST from svc-wallet");
                }
            default:
                try {
                    return ResponseEntity.status(statusCode).body((WalletError) responseBody);
                } catch (ClassCastException e) {
                    // Handle the case where casting to WalletError is not possible
                    return ResponseEntity.status(statusCode).body("Unexpected response from svc-wallet");
                }
        }
    }
}
