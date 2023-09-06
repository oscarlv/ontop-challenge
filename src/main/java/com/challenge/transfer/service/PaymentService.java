package com.challenge.transfer.service;

import com.challenge.transfer.entity.payment.PaymentRequest;
import com.challenge.transfer.entity.payment.PaymentResponse;

public interface PaymentService {

    PaymentResponse callPaymentService(PaymentRequest paymentRequest,
                                      String paymentPath);
}
