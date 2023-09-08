package com.challenge.transfer.service;

import com.challenge.transfer.entity.payment.PaymentRequest;
import com.challenge.transfer.entity.payment.PaymentResponse;
import com.challenge.transfer.helper.RestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Value("${service.payment.base.url}")
    private String baseUrlPayment;

    @Autowired
    private RestHelper restHelper;

    @Override
    public ResponseEntity<?> callPaymentService(PaymentRequest paymentRequest, String paymentPath) {
        String paymentServiceUrl = restHelper.createUrl(baseUrlPayment, paymentPath);

        final HttpEntity<PaymentRequest> requestHttpEntity = new HttpEntity<>(paymentRequest);

        return restHelper.executeServiceCall(paymentServiceUrl, requestHttpEntity,
                Object.class, HttpMethod.POST);
    }
}
