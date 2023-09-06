package com.challenge.transfer.entity.payment;

import com.challenge.transfer.entity.payment.Destination;
import com.challenge.transfer.entity.payment.Source;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentRequest {
    @SerializedName("source")
    private Source source;

    @SerializedName("destination")
    private Destination destination;

    @SerializedName("amount")
    private Integer amount;
}
