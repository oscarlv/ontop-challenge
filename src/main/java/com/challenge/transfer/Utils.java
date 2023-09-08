package com.challenge.transfer;

import com.challenge.transfer.entity.wallet.WalletRequest;
import com.challenge.transfer.entity.payment.*;
import com.challenge.transfer.entity.recipient.GetRecipientResponse;
import com.challenge.transfer.entity.transfer.TransferRequest;

public class Utils {

    public static PaymentRequest createPaymentRequest(TransferRequest transferRequest, GetRecipientResponse recipient) {
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

    public static WalletRequest createWalletRequest(TransferRequest transferRequest) {
        return WalletRequest.builder()
                .userId(transferRequest.getUserId())
                .amount(transferRequest.getAmount())
                .build();
    }
}
