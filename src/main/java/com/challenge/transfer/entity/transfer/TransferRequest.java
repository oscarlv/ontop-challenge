package com.challenge.transfer.entity.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TransferRequest {

    private Integer userId;
    private Integer recipientId;
    private Integer amount;
}
