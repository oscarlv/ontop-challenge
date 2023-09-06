package com.challenge.transfer.entity.payment;

import com.challenge.transfer.entity.payment.Account;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Destination {
    @SerializedName("name")
    private String name;

    @SerializedName("account")
    private Account account;
}
