package com.challenge.transfer.entity.wallet;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class WalletRequest {
    @SerializedName("amount")
    private Integer amount;
    @SerializedName("user_id")
    private Integer userId;
}
