package com.challenge.transfer.service;

import com.challenge.transfer.entity.payment.*;
import com.challenge.transfer.entity.recipient.GetRecipientResponse;
import com.challenge.transfer.entity.transfer.TransferRequest;
import com.challenge.transfer.entity.wallet.WalletRequest;
import com.challenge.transfer.entity.wallet.WalletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.EntityResponse;

import static com.challenge.transfer.TransferConstants.PATH_EXTERNAL_PAYMENT;
import static com.challenge.transfer.TransferConstants.PATH_WALLET_TRANSACTION;
import static com.challenge.transfer.Utils.createPaymentRequest;
import static com.challenge.transfer.Utils.createWalletRequest;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    WalletService walletService;

    @Autowired
    PaymentService paymentService;

    @Autowired
    RecipientService recipientService;

    public ResponseEntity<?> withdrawMoney(TransferRequest transferRequest) {

        WalletRequest walletRequest = createWalletRequest(transferRequest);
        ResponseEntity<?> walletResponse
                = walletService.callWalletService(walletRequest, PATH_WALLET_TRANSACTION);

        /*
        //Call recipient-service to get all the details
        GetRecipientResponse getRecipientResponse
                = recipientService.getRecipientInformation(transferRequest.getRecipientId());

        PaymentRequest paymentRequest = createPaymentRequest(transferRequest, getRecipientResponse);
        //Call payment service
        PaymentResponse paymentResponse
                = paymentService.callPaymentService(paymentRequest, PATH_EXTERNAL_PAYMENT);
         */
        return walletResponse;
    }


}
