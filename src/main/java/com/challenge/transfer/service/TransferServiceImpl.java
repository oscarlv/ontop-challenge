package com.challenge.transfer.service;

import com.challenge.transfer.entity.*;
import com.challenge.transfer.entity.payment.*;
import com.challenge.transfer.entity.recipient.GetRecipientRequest;
import com.challenge.transfer.entity.recipient.GetRecipientResponse;
import com.challenge.transfer.entity.transfer.TransferRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.challenge.transfer.TransferConstants.PATH_EXTERNAL_PAYMENT;
import static com.challenge.transfer.TransferConstants.PATH_WALLET_TRANSACTION;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    WalletService walletService;

    @Autowired
    PaymentService paymentService;

    @Autowired
    RecipientService recipientService;

    public WalletResponse sendMoney(TransferRequest transferRequest) {
        WalletRequest walletRequest = WalletRequest.builder()
                .userId(transferRequest.getUserId())
                .amount(transferRequest.getAmount())
                .build();

        WalletResponse walletResponse
                = walletService.callWalletService(walletRequest, PATH_WALLET_TRANSACTION);

        //Call recipient-service to get all the details
        GetRecipientResponse getRecipientResponse
                = recipientService.getRecipientInformation(1);


        PaymentRequest paymentRequest = createPaymentRequest(transferRequest, getRecipientResponse);

        //Call payment service
        PaymentResponse paymentResponse
                = paymentService.callPaymentService(paymentRequest, PATH_EXTERNAL_PAYMENT);

        return walletResponse;
    }

    private PaymentRequest createPaymentRequest(TransferRequest transferRequest, GetRecipientResponse recipient) {
        return PaymentRequest.builder()
                .source(Source.builder()
                        .type("COMPANY")
                        .sourceInformation(SourceInformation.builder().name("ONTOP INC").build())
                        .account(Account.builder()
                                .accountNumber("0245253419")
                                .routingNumber("028444018")
                                .currency("USD")
                                .build())
                        .build())
                .destination(Destination.builder()
                        .name("Nombre")
                        .account(Account.builder()
                                .routingNumber(recipient.getRoutingNumber())
                                .accountNumber(recipient.getAccountNumber())
                                .currency("USD")
                                .build())
                        .build())
                .amount(transferRequest.getAmount())
                .build();
    }
}
