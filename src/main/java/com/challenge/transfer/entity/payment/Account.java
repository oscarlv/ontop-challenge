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
public class Account {
    @SerializedName("accountNumber")
    private String accountNumber;

    @SerializedName("currency")
    private String currency;

    @SerializedName("routingNumber")
    private String routingNumber;
}
