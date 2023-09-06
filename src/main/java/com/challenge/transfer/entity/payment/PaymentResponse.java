package com.challenge.transfer.entity.payment;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentResponse {
    @SerializedName("requestInfo")
    private RequestInfo requestInfo;

    @SerializedName("paymentInfo")
    private PaymentInfo paymentInfo;

    public static class RequestInfo {
        @SerializedName("status")
        private String status;
    }

    public static class PaymentInfo {
        @SerializedName("amount")
        private Integer amount;

        @SerializedName("id")
        private String id;
    }
}
