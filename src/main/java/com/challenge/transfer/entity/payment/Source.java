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
public class Source {
    @SerializedName("type")
    private String type;

    @SerializedName("sourceInformation")
    private SourceInformation sourceInformation;

    @SerializedName("account")
    private Account account;
}
