package com.challenge.transfer.service;

import com.challenge.transfer.entity.payment.PaymentRequest;
import com.challenge.transfer.entity.payment.PaymentResponse;
import org.springframework.http.ResponseEntity;

public interface PaymentService {

    ResponseEntity<?> callPaymentService(PaymentRequest paymentRequest,
                                      String paymentPath);
}
