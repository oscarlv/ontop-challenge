package com.challenge.transfer.entity.wallet;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WalletResponse {
    @SerializedName("wallet_transaction_id")
    private Integer walletTransactionId;
    @SerializedName("user_id")
    private Integer userId;
    @SerializedName("amount")
    private Integer amount;
}
